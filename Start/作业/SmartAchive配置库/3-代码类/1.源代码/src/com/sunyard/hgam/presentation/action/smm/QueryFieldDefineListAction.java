package com.sunyard.hgam.presentation.action.smm;

import com.sunyard.hgam.presentation.base.BaseAction;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.beans.adc.Archives;
import com.sunyard.hgam.presentation.base.PagedListHelper;
import com.sunyard.hgam.persistence.dao.iface.adc.ArchivesDao;
import com.sunyard.hgam.presentation.form.adc.ArchivesForm;
import com.sunyard.hgam.presentation.form.adc.EformFieldDefineForm;
import com.sunyard.hgam.persistence.dao.beans.adc.EformFieldDefine;
import com.sunyard.hgam.persistence.dao.iface.adc.EformDao;

public class QueryFieldDefineListAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.Exception{

    PaginatedList fieldDefineList = (PaginatedList) request.getSession().getAttribute("fieldDefineList");

    String page = request.getParameter("page");

    if(fieldDefineList==null || page == null){
      EformFieldDefineForm eformFieldDefineForm = (EformFieldDefineForm) form;
      EformFieldDefine eformFieldDefine = null;
      if(eformFieldDefineForm!=null)
        eformFieldDefine = eformFieldDefineForm.getEformFieldDefine();

      EformDao eformDao = (EformDao) domainLogic.getDAO("Eform");
      fieldDefineList = eformDao.queryFieldDefineList(eformFieldDefine);

      //∑≈»Îª∫¥Ê
      request.getSession().setAttribute("fieldDefineList", fieldDefineList);
    }else{
      PagedListHelper.pageTo(fieldDefineList, page);
    }

    //
    return (mapping.findForward("SUCCESS"));
  }

}