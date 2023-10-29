package com.sunyard.hgam.presentation.action.aum;

import com.sunyard.hgam.presentation.base.BaseAction;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.presentation.form.aum.UtilizeInfoForm;
import com.sunyard.hgam.persistence.dao.beans.aum.UtilizeInfo;
import com.sunyard.hgam.util.common.DateTimeKit;
import com.sunyard.hgam.persistence.dao.iface.aum.UtilizeInfoDao;
import com.sunyard.hgam.presentation.form.smm.AccountForm;
import com.sunyard.hgam.persistence.dao.beans.smm.Account;

public class AddUtilizeInfoAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.
      Exception {

    UtilizeInfoDao utilDao = (UtilizeInfoDao) domainLogic.getDAO(
        "UtilizeInfoDao");

    String applyID = "";
    UtilizeInfoForm uform = (UtilizeInfoForm) form;
    UtilizeInfo uInfo = uform.getUtilizeInfo();
    String personID = (String) request.getSession().getAttribute("personID");
    String isSelf = (String) request.getSession().getAttribute("isSelf");

    /*** 业务数据部份 ***/
    if (isSelf.equals("0")) {
      uInfo.setPersonID(personID); //利用者ID
    }
    else {
      AccountForm accountInfo = (AccountForm) request.getSession().getAttribute(
          "ACCOUNT_INFORMATION");
      if (accountInfo != null) {
        Account account = accountInfo.getAccount();
        uInfo.setUserID(account.getUserID());
      }
    }

    uInfo.setTypeID("1"); //"1"表示利用方式是查阅
    //申请日期
    uInfo.setApplyDate(DateTimeKit.getCurrentTimestamp().substring(0, 10));
    //流程状态
    uInfo.setUtilizeStatus("APPLIED");
    //在UTILIZE_APPLY表插入一条记录
    applyID = utilDao.addApply(uInfo);

    request.getSession().setAttribute("applyID", applyID);

    return (mapping.findForward("success"));
  }

}