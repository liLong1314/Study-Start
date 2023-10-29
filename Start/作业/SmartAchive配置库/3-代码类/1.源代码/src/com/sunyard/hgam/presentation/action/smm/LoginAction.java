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
 * <p>Description: ���������ϵ����ݽ��裨һ�ڣ�</p>
 * <p>Copyright: Hangzhou Sunyard System Engineering�� Ltd. All rights reserved @2003</p>
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
      request.setAttribute("message", "��Ч���û��������룬��¼ʧ�ܡ�");
      account = new Account();
      account.setUserID("");
      account.setUserName(accountForm.getAccount().getUserName());
      operation.setOperDesc("�û�" + accountForm.getAccount().getUserName() +
                            "���Ե�¼ʧ��");
      forward = "failure";
    }
    else {
      //�ѵ�¼�ɹ��û�����Ϣ����Form Bean��
      accountForm.setAccount(account);
      //��������Ϊnull
      accountForm.getAccount().setPassword(null);

      //��ȡ����Ȩ�ޱ�
      List funcPerms = accountDAO.getUserFuncPerm(account.getUserID(), account.getRoleID());
      List groups = accountDAO.getUserGroups(account.getUserID());

      if ((funcPerms.size() < 1) && (groups.size() < 1)) {
        request.setAttribute("message", "����û�з���Ȩ�ޣ�����ϵ����Ա");
        operation.setOperDesc("�û�" + account.getUserName() +
                            "���Ե�¼�ɹ�������û��Ȩ�޷���ϵͳ");
        forward = "failure";
      }
      else {

        addCategory(funcPerms);
        accountForm.setFuncPerms(funcPerms);
        //��ȡ����Ȩ�ޱ�
        List dataPerms = accountDAO.getUserDataPerm(account.getUserID(), account.getRoleID());
        accountForm.setDataPerms(dataPerms);

        //��ȡ�û��Ľ�ɫ
        accountForm.setMyRoles(accountDAO.getUserGroups(account.getUserID()));

        //�����û���¼��Ϣ
        account.setAccessTimes(String.valueOf(Integer.parseInt(account.getAccessTimes()) + 1));
        account.setLastAccessDate(DateTimeKit.getCurrentDateTime());
        accountDAO.updateLoginInfo(account);

        request.getSession().setAttribute("ACCOUNT_INFORMATION", accountForm);

        operation.setOperDesc("�û�" + account.getUserName() + "��¼�ɹ�");
        forward = "success";

      }
    }

    //������־��¼
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