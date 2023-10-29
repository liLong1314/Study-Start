package com.sunyard.hgam.presentation.action.smm;

import java.util.*;
import javax.servlet.http.*;

import org.apache.struts.action.*;
import com.sunyard.hgam.persistence.dao.iface.adc.*;
import com.sunyard.hgam.presentation.base.*;
import com.sunyard.hgam.presentation.form.adc.EformDefineForm;
import com.sunyard.hgam.persistence.dao.beans.adc.EformDefine;

public class ViewEformFieldListAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.Exception{

    String eform_id = request.getParameter("eform_id");
    if (eform_id == null || eform_id.equalsIgnoreCase("")) {
      eform_id = String.valueOf(request.getSession().getAttribute("eform_id"));
    }

    EformDefineForm eformDefineForm = (EformDefineForm)form;

    EformDao eformDao = (EformDao) domainLogic.getDAO("Eform");
    EformDefine eformDefine = eformDao.getEformDefineByEformId(eform_id);
    eformDefineForm.setEformDefine(eformDefine);

    List eformFieldList = (List)eformDao.getEformFieldDefineByEformId(eform_id);

    request.getSession().setAttribute("eform_id", eform_id);
    request.setAttribute("EformDefineForm", eformDefineForm);
    request.setAttribute("eformFieldList", eformFieldList);

    return (mapping.findForward("SUCCESS"));
  }

}