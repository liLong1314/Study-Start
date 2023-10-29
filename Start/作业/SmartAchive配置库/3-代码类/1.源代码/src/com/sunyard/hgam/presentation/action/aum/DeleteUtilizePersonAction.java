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

public class DeleteUtilizePersonAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.
      Exception {

    UtilizeInfoDao utilDao = (UtilizeInfoDao)domainLogic.getDAO("UtilizeInfoDao");

    String personID = request.getParameter("personID");
    String forwardJSP = "";

    try {
      utilDao.deleteUtilizePerson(personID);
      forwardJSP = "success";
    }
    catch (Exception ex) {
      forwardJSP = "FAILURE";
    }

    return (mapping.findForward(forwardJSP));
  }

}
