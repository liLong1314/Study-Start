package com.sunyard.hgam.presentation.action.smm;


import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.adc.EformDefineForm;
import com.sunyard.hgam.persistence.dao.iface.adc.EformDao;
import com.sunyard.hgam.persistence.dao.beans.adc.EformDefine;


public class addEformDefineAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.
      Exception {

    String strForward = "SUCCESS";
    EformDefineForm eformDefineForm = (EformDefineForm)form;
    EformDefine eformDefine = eformDefineForm.getEformDefine();

    try {
      EformDao eformDao = (EformDao) domainLogic.getDAO("Eform");
      eformDao.addEformDefine(eformDefine);

    }catch (Exception ex) {
      ex.printStackTrace();
      eformDefineForm.setMsgError(ex.toString());
      strForward = "FAILURE";
    }finally{
      return mapping.findForward(strForward);
    }

  }

}