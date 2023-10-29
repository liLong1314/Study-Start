package com.sunyard.hgam.presentation.action.adc;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.adc.ArchivesForm;

public class InputFileNavigatorAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws java.lang.Exception {
    //InsertFile.do?ENTRY_ID=13&ISOPERATION=1
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
      archivesForm.getArchives().setAARCHIVES_STATUS("0");

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