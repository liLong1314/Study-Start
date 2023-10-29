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

public class RoleSwitchAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping actionMapping,
                                 ActionForm actionForm,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    String forward = null;

    AccountForm accountForm = (AccountForm) actionForm;
    Account account = accountForm.getAccount();

    AccountDAO accountDAO = (AccountDAO) domainLogic.getDAO("Account");
    //获取功能权限表
    List funcPerms = accountDAO.getUserFuncPerm(account.getUserID(),
                                                account.getRoleID());
    addCategory(funcPerms);
    accountForm.setFuncPerms(funcPerms);
    //获取数据权限表
    List dataPerms = accountDAO.getUserDataPerm(account.getUserID(),
                                                account.getRoleID());
    accountForm.setDataPerms(dataPerms);

    forward = "success";

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