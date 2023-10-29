package com.sunyard.hgam.presentation.action.smm;


import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.adc.EformDefineForm;
import com.sunyard.hgam.persistence.dao.iface.adc.EformDao;
import com.sunyard.hgam.persistence.dao.beans.adc.EformDefine;


public class ViewEformDefineAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.
      Exception {

    String eform_id = request.getParameter("eform_id");
    if (eform_id == null || eform_id.equalsIgnoreCase("")) {
      eform_id = String.valueOf(request.getSession().getAttribute("eform_id"));
    }

    EformDefineForm eformDefineForm = (EformDefineForm)form;

    try {
      //获取信息
      EformDao eformDao = (EformDao) domainLogic.getDAO("Eform");
      EformDefine eformDefine = eformDao.getEformDefineByEformId(eform_id);
      eformDefineForm.setEformDefine(eformDefine);

      request.getSession().setAttribute("eform_id",eform_id);
      request.setAttribute("EformDefineForm", eformDefineForm);
    }catch (Exception ex) {
      ex.printStackTrace();
    }finally{
      return mapping.findForward("SUCCESS");
    }
  }

}