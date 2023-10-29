package com.sunyard.hgam.presentation.action.adc;

import com.sunyard.hgam.presentation.base.BaseAction;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForward;
import com.sunyard.hgam.presentation.form.adc.ArchivesForm;
import com.sunyard.hgam.persistence.dao.iface.adc.ArchivesDao;

public class InputPieceNavigatorAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.Exception {

    //InsertPiece.do?ENTRY_ID=13&ISOPERATION=1
    String ENTRY_ID = request.getParameter("ENTRY_ID");
    String ISOPERATION = request.getParameter("ISOPERATION");
    if (ENTRY_ID == null || ENTRY_ID.equalsIgnoreCase("")) {
      ENTRY_ID = String.valueOf(request.getSession().getAttribute("ENTRY_ID"));
    }
    if (ISOPERATION == null || ISOPERATION.equalsIgnoreCase("")) {
      ISOPERATION = String.valueOf(request.getSession().getAttribute("ISOPERATION"));
    }

    String strForwardTo = "SUCCESS";
    try {
      ArchivesForm archivesForm = new ArchivesForm();
      archivesForm.getArchives().setAENTRY_ID(ENTRY_ID);
      archivesForm.getArchives().setAIS_OPERATION(ISOPERATION);
      archivesForm.getArchives().setAROLL_MODE("2");
      archivesForm.getArchives().setAARCHIVES_STATUS("0");
      //³õÊ¼»¯ÊÒ±à¼þºÅ
      ArchivesDao archivesDao = (ArchivesDao)domainLogic.getDAO("Archives");
      archivesForm.getArchives().setAPIECE_NUM(String.valueOf(archivesDao.getMaxPieceNum().intValue()+1));

      request.setAttribute("ArchivesForm", archivesForm);
      request.getSession().setAttribute("ENTRY_ID", ENTRY_ID);
      request.getSession().setAttribute("ISOPERATION", ISOPERATION);
    }
    catch (Exception ex) {
      ex.printStackTrace();
      strForwardTo = "FAILURE";
    }finally{
      //return mapping.findForward("SUCCESS");
      return mapping.findForward(strForwardTo);
    }
  }

}
