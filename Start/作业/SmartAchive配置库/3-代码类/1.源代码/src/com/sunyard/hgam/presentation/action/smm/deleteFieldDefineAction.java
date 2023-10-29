package com.sunyard.hgam.presentation.action.smm;


import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.adc.EformFieldDefineForm;
import com.sunyard.hgam.persistence.dao.iface.adc.EformDao;
import com.sunyard.hgam.persistence.dao.beans.adc.EformDefine;


public class deleteFieldDefineAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.
      Exception {

    String strForward = "SUCCESS";
    String field_id = request.getParameter("field_id");
    EformFieldDefineForm eformFieldDefineForm = (EformFieldDefineForm) form;

    try {
      EformDao eformDao = (EformDao) domainLogic.getDAO("Eform");
      eformDao.deleteFieldDefine(field_id);

    }catch (Exception ex) {
      //ex.printStackTrace();
      eformFieldDefineForm.setMsgError(ex.getMessage());
      strForward = "FAILURE";
    }finally{
      return mapping.findForward(strForward);
    }
  }

}