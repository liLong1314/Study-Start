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
import com.sunyard.hgam.persistence.dao.iface.aum.UtilizeDetailDao;

public class DeleteUtilizeInfoAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.
      Exception {

    UtilizeInfoDao utilDao = (UtilizeInfoDao)domainLogic.getDAO("UtilizeInfoDao");
    UtilizeDetailDao utilizeDetailDao = (UtilizeDetailDao) domainLogic.getDAO(
        "UtilizeDetail");

    String showTaskFlag = request.getParameter("showTaskFlag");
    String applyID = (String)request.getSession().getAttribute("applyID");
    String forwardJSP = "";

    try {
      utilizeDetailDao.deleteByApplyID(applyID);
      utilDao.deleteApplyInfoByApplyID(applyID);

      if (showTaskFlag.equals("1")) {
        forwardJSP = "VIEW";
      }
      else if (showTaskFlag.equals("2")) {
        forwardJSP = "BORROW";
      }
      else if (showTaskFlag.equals("3")) {
        forwardJSP = "REPAIR";
      }
    }
    catch (Exception ex) {
      forwardJSP = "FAILURE";
    }

    return (mapping.findForward(forwardJSP));
  }

}
