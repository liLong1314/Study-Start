package com.sunyard.hgam.presentation.action.smm;

import java.util.*;
import javax.servlet.http.*;

import org.apache.struts.action.*;
import com.sunyard.hgam.persistence.dao.iface.adc.*;
import com.sunyard.hgam.presentation.base.*;
import com.sunyard.hgam.presentation.form.adc.EformDefineForm;
import com.sunyard.hgam.persistence.dao.beans.adc.EformDefine;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.beans.adc.EformFieldDefine;
import com.sunyard.hgam.presentation.form.adc.EformFieldDefineForm;

public class ViewEformFieldListForSelectAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.Exception{

    String eform_id = request.getParameter("eform_id");
    if (eform_id == null || eform_id.equalsIgnoreCase("")) {
      eform_id = String.valueOf(request.getSession().getAttribute("eform_id"));
    }
    String page = request.getParameter("page");
    PaginatedList eformFieldListForSelect = (PaginatedList) request.getSession().getAttribute("eformFieldListForSelect");

    if(eformFieldListForSelect==null || page == null){
      EformDao eformDao = (EformDao) domainLogic.getDAO("Eform");
      EformFieldDefineForm eformFieldDefineForm = (EformFieldDefineForm)form;
      EformFieldDefine eformFieldDefine = eformFieldDefineForm.getEformFieldDefine();
      eformFieldDefine.setEform_id(eform_id);

      eformFieldListForSelect = (PaginatedList) eformDao.
          getFieldDefineListForSelectByEformId(eformFieldDefine);

      //∑≈»Îª∫¥Ê
      request.getSession().setAttribute("eform_id", eform_id);
      request.setAttribute("EformFieldDefineForm", eformFieldDefineForm);
      request.getSession().setAttribute("eformFieldListForSelect",eformFieldListForSelect);
    }
    else {
      PagedListHelper.pageTo(eformFieldListForSelect, page);
    }

    return (mapping.findForward("SUCCESS"));
  }

}