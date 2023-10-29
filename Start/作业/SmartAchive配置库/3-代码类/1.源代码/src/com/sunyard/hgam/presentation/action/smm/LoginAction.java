package com.sunyard.hgam.presentation.action.smm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.smm.AccountForm;
import com.sunyard.hgam.persistence.dao.iface.smm.*;
import com.sunyard.hgam.persistence.dao.beans.smm.*;
import com.ibatis.db.dao.*;
import java.util.*;
import com.sunyard.hgam.util.common.DateTimeKit;

/**
 * <p>Title: Hang Zhou Net Archives</p>
 * <p>Description: 杭州市网上档案馆建设（一期）</p>
 * <p>Copyright: Hangzhou Sunyard System Engineering， Ltd. All rights reserved @2003</p>
 * <p>Company: </p>
 * @Date        Author      Changes
 * Nov 4,2003   yujx        created
 * @version 0.01
 */

public class LoginAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping actionMapping,
                                 ActionForm actionForm,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    String forward = null;

    AccountForm accountForm = (AccountForm) actionForm;
    OperationUrl operation = new OperationUrl();

    AccountDAO accountDAO = (AccountDAO) domainLogic.getDAO("Account");
    Account account = accountDAO.getAccountByUsernameAndPassword(
        accountForm.getAccount().getUserName(),
        accountForm.getAccount().getPassword());

    if (account == null) {
      request.setAttribute("message", "无效的用户名或密码，登录失败。");
      account = new Account();
      account.setUserID("");
      account.setUserName(accountForm.getAccount().getUserName());
      operation.setOperDesc("用户" + accountForm.getAccount().getUserName() +
                            "尝试登录失败");
      forward = "failure";
    }
    else {
      //把登录成功用户的信息放入Form Bean中
      accountForm.setAccount(account);
      //密码设置为null
      accountForm.getAccount().setPassword(null);

      //获取功能权限表
      List funcPerms = accountDAO.getUserFuncPerm(account.getUserID(), account.getRoleID());
      List groups = accountDAO.getUserGroups(account.getUserID());

      if ((funcPerms.size() < 1) && (groups.size() < 1)) {
        request.setAttribute("message", "您还没有访问权限，请联系管理员");
        operation.setOperDesc("用户" + account.getUserName() +
                            "尝试登录成功，但还没有权限访问系统");
        forward = "failure";
      }
      else {

        addCategory(funcPerms);
        accountForm.setFuncPerms(funcPerms);
        //获取数据权限表
        List dataPerms = accountDAO.getUserDataPerm(account.getUserID(), account.getRoleID());
        accountForm.setDataPerms(dataPerms);

        //获取用户的角色
        accountForm.setMyRoles(accountDAO.getUserGroups(account.getUserID()));

        //更新用户登录信息
        account.setAccessTimes(String.valueOf(Integer.parseInt(account.getAccessTimes()) + 1));
        account.setLastAccessDate(DateTimeKit.getCurrentDateTime());
        accountDAO.updateLoginInfo(account);

        request.getSession().setAttribute("ACCOUNT_INFORMATION", accountForm);

        operation.setOperDesc("用户" + account.getUserName() + "登录成功");
        forward = "success";

      }
    }

    //进行日志记录
    LogDao logDao = (LogDao) domainLogic.getDAO("Log");
    Log log = new Log();
    log.setUserID(account.getUserID());
    log.setUserName(account.getUserName());
    log.setIp(request.getRemoteAddr());
    log.setOperID("");
    log.setResultCode("");
    log.setLogMsg(operation.getOperDesc());
    log.setType("1");
    log.setOccurTime(DateTimeKit.getCurrentDateTime());
    logDao.insertLog(log);

    return actionMapping.findForward(forward);
  }

  private void addCategory(List list) {
    int len = list.size();
    for (int i = 0; i < len; i++) {
      String code = (String) list.get(i);
      String c2 = code.substring(0, 7);
      if (!list.contains(c2)) {
        String c1 = code.substring(0, 5);
        if (!list.contains(c1)) {
          list.add(c1);
        }
        list.add(c2);
      }
    }
  }
}