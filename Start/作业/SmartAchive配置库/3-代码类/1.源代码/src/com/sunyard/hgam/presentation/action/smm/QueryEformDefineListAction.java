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
import com.sunyard.hgam.presentation.form.adc.EformDefineForm;
import com.sunyard.hgam.persistence.dao.beans.adc.EformDefine;
import com.sunyard.hgam.persistence.dao.iface.adc.EformDao;

public class QueryEformDefineListAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.Exception{

    PaginatedList eformDefineList = (PaginatedList) request.getSession().getAttribute("eformDefineList");

    String page = request.getParameter("page");

    if(eformDefineList==null || page == null){
      EformDefineForm eformDefineForm = (EformDefineForm) form;
      EformDefine eformDefine = null;
      if(eformDefineForm!=null)
        eformDefine= eformDefineForm.getEformDefine();

      EformDao eformDao = (EformDao) domainLogic.getDAO("Eform");
      eformDefineList = eformDao.queryEformDefineList(eformDefine);

      //∑≈»Îª∫¥Ê
      request.getSession().setAttribute("eformDefineList", eformDefineList);
    }else{
      PagedListHelper.pageTo(eformDefineList, page);
    }

    //
    return (mapping.findForward("SUCCESS"));
  }

}