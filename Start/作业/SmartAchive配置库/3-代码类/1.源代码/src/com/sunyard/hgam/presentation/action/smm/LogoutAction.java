package com.sunyard.hgam.presentation.action.smm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.smm.AccountForm;
import com.sunyard.hgam.persistence.dao.beans.smm.*;
import com.sunyard.hgam.persistence.dao.iface.smm.LogDao;
import com.sunyard.hgam.util.common.DateTimeKit;

public class LogoutAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping actionMapping,
                                 ActionForm actionForm,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    AccountForm accountForm = (AccountForm) request.getSession().getAttribute(
        "ACCOUNT_INFORMATION");
    Account account = null;
    if (accountForm != null) {
      account = accountForm.getAccount();
    }
    else {
      account = new Account();
      account.setUserID("");
      account.setUserName("未登录用户");
    }
    //进行日志记录
    LogDao logDao = (LogDao) domainLogic.getDAO("Log");
    Log log = new Log();
    log.setUserID(account.getUserID());
    log.setUserName(account.getUserName());
    log.setIp(request.getRemoteAddr());
    log.setOperID("");
    log.setResultCode("");
    log.setLogMsg("用户退出");
    log.setType("1");
    log.setOccurTime(DateTimeKit.getCurrentDateTime());
    logDao.insertLog(log);

    request.getSession().invalidate();

    return actionMapping.findForward("global-login");
  }
}