package com.sunyard.hgam.presentation.action.smm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.smm.*;
import com.sunyard.hgam.persistence.dao.iface.smm.*;
import com.sunyard.hgam.persistence.dao.beans.smm.*;
import com.sunyard.hgam.util.common.*;

/**
 * <p>Title: Hang Zhou Net Archives</p>
 * <p>Description: 杭州市网上档案馆建设（一期）：对已有用户进行授权</p>
 * <p>Copyright: Hangzhou Sunyard System Engineering， Ltd. All rights reserved @2003</p>
 * <p>Company: </p>
 * @author xcf
 * @version 1.00
 */

public class ChangePasswordAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    String forwardString = "";


    AccountForm curUserInfoForm = (AccountForm) request.getSession().getAttribute("ACCOUNT_INFORMATION");
    Account curAccountInfo = null;
    if(curUserInfoForm != null) {
      curAccountInfo = curUserInfoForm.getAccount();
      if (curAccountInfo.getUserID() == null) {
        forwardString = "unknown-error";
        return mapping.findForward(forwardString);
      }
    }
    else {
      forwardString = "unknown-error";
      return mapping.findForward(forwardString);
    }

    AccountForm accountForm = (AccountForm) form;
    if (accountForm.getNewPassword() == null || accountForm.getNewPassword().length() < 1) {
      accountForm.setOperResults("新密码不能为空");
      forwardString = "failure";
      return mapping.findForward(forwardString);
    }
    else if(!accountForm.getNewPassword().equals(accountForm.getRepeatedPassword())) {
      accountForm.setOperResults("密码不匹配");
      forwardString = "failure";
      return mapping.findForward(forwardString);
    }

    Account account = accountForm.getAccount();
    AccountDAO accountDAO = (AccountDAO) domainLogic.getDAO("Account");
    //旧密码校验
    if (accountDAO.getAccountByUsernameAndPassword(curAccountInfo.getUserName(),
        account.getPassword()) == null) { //旧密码输入错误
      accountForm.setOperResults("旧密码错误！");
      forwardString = "failure";
      return mapping.findForward(forwardString);
    }

    //change the user's password
    account.setUserID(curAccountInfo.getUserID());
    account.setPassword(accountForm.getNewPassword());
    accountDAO.updateAccountPassword(account);

    //clear input info
    account.setPassword(null);
    accountForm.setNewPassword(null);
    accountForm.setRepeatedPassword(null);

    accountForm.setOperResults("密码更改成功！");
    forwardString = "success";

    return mapping.findForward(forwardString);
  }
}