package com.sunyard.hgam.presentation.action.smm;

import java.util.*;
import javax.servlet.http.*;

import org.apache.struts.action.*;
import com.sunyard.hgam.persistence.dao.iface.adc.*;
import com.sunyard.hgam.presentation.base.*;
import com.sunyard.hgam.presentation.form.adc.EformFieldDefineForm;
import com.sunyard.hgam.persistence.dao.beans.adc.EformFieldDefine;

public class ViewFieldEformListAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.Exception{

    String field_id = request.getParameter("field_id");
    if (field_id == null || field_id.equalsIgnoreCase("")) {
      field_id = String.valueOf(request.getSession().getAttribute("field_id"));
    }

    EformFieldDefineForm eformFieldDefineForm = (EformFieldDefineForm)form;

    EformDao eformDao = (EformDao) domainLogic.getDAO("Eform");
    EformFieldDefine eformFieldDefine = eformDao.getFieldDefineByFieldId(field_id);
    eformFieldDefineForm.setEformFieldDefine(eformFieldDefine);

    List fieldEformDefineList = (List)eformDao.queryFieldEformList(field_id);

    request.getSession().setAttribute("field_id", field_id);
    request.setAttribute("EformFieldDefineForm", eformFieldDefineForm);
    request.setAttribute("fieldEformDefineList", fieldEformDefineList);

    return (mapping.findForward("SUCCESS"));
  }

}