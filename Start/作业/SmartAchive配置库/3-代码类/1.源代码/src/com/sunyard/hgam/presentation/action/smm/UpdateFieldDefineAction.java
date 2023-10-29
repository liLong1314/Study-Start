package com.sunyard.hgam.presentation.action.smm;


import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.adc.EformFieldDefineForm;
import com.sunyard.hgam.persistence.dao.iface.adc.EformDao;
import com.sunyard.hgam.persistence.dao.beans.adc.EformFieldDefine;


public class UpdateFieldDefineAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.
      Exception {

    String strForward = "SUCCESS";
    EformFieldDefineForm eformFieldDefineFormForm = (EformFieldDefineForm)form;
    EformFieldDefine eformFieldDefineForm = eformFieldDefineFormForm.getEformFieldDefine();

    try {
      EformDao eformDao = (EformDao) domainLogic.getDAO("Eform");
      eformDao.updateFieldDefine(eformFieldDefineForm);

    }catch (Exception ex) {
      ex.printStackTrace();
      eformFieldDefineFormForm.setMsgError(ex.toString());
      strForward = "FAILURE";
    }finally{
      return mapping.findForward(strForward);
    }

  }

}