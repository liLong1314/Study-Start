package com.sunyard.hgam.presentation.action.smm;


import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.adc.EformDefineForm;
import com.sunyard.hgam.persistence.dao.iface.adc.EformDao;
import com.sunyard.hgam.persistence.dao.beans.adc.EformDefine;
import com.sunyard.hgam.presentation.form.adc.EformFieldDefineForm;
import com.sunyard.hgam.persistence.dao.beans.adc.EformFieldDefine;


public class ViewFieldDefineAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.
      Exception {

    String field_id = request.getParameter("field_id");
    if (field_id == null || field_id.equalsIgnoreCase("")) {
      field_id = String.valueOf(request.getSession().getAttribute("field_id"));
    }

    EformFieldDefineForm eformFieldDefineForm = (EformFieldDefineForm)form;

    try {
      //获取信息
      EformDao eformDao = (EformDao) domainLogic.getDAO("Eform");
      EformFieldDefine eformFieldDefine = eformDao.getFieldDefineByFieldId(field_id);
      eformFieldDefineForm.setEformFieldDefine(eformFieldDefine);

      request.getSession().setAttribute("field_id",field_id);
      request.setAttribute("EformFieldDefineForm", eformFieldDefineForm);
    }catch (Exception ex) {
      ex.printStackTrace();
    }finally{
      return mapping.findForward("SUCCESS");
    }
  }

}