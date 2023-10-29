package com.sunyard.hgam.presentation.action.smm;


import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.adc.EformFieldDefineForm;
import com.sunyard.hgam.persistence.dao.iface.adc.EformDao;
import com.sunyard.hgam.persistence.dao.beans.adc.EformFieldDefine;


public class addFieldDefineAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.
      Exception {

    String strForward = "SUCCESS";
    EformFieldDefineForm EformFieldDefineForm = (EformFieldDefineForm)form;
    try {
      EformFieldDefine eformFieldDefine = EformFieldDefineForm.
          getEformFieldDefine();

      EformDao eformDao = (EformDao) domainLogic.getDAO("Eform");
      eformDao.addFieldDefine(eformFieldDefine);

    }
    catch (Exception ex) {
      ex.printStackTrace();
      EformFieldDefineForm.setMsgError(ex.toString());
      strForward = "FAILURE";
    }finally{
      return mapping.findForward(strForward);
    }

  }

}