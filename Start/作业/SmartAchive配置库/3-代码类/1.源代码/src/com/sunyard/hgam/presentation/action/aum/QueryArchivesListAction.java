package com.sunyard.hgam.presentation.action.aum;

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

public class QueryArchivesListAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.Exception{

    PaginatedList archivesList = (PaginatedList) request.getSession().getAttribute("archivesList");

    String page = request.getParameter("page");
    String ENTRY_ID = request.getParameter("ENTRY_ID");
    String ISOPERATION = request.getParameter("ISOPERATION");
    if (ENTRY_ID == null || ENTRY_ID.equalsIgnoreCase("")) {
      ENTRY_ID = String.valueOf(request.getSession().getAttribute("ENTRY_ID"));
    }
    if (ISOPERATION == null || ISOPERATION.equalsIgnoreCase("")) {
      ISOPERATION = String.valueOf(request.getSession().getAttribute("ISOPERATION"));
    }

    if(page == null){
      ArchivesForm archivesForm = (ArchivesForm) form;
      Archives archives = archivesForm.getArchives();
      archives.setAENTRY_ID(ENTRY_ID);
      archives.setAIS_OPERATION(ISOPERATION);

      ArchivesDao archivesDao = (ArchivesDao) domainLogic.getDAO("Archives");
      archivesList = archivesDao.queryArchivesList(archives);

      //∑≈»Îª∫¥Ê
      request.getSession().setAttribute("archivesList", archivesList);
      request.getSession().setAttribute("ROLL_MODE", archives.getAROLL_MODE());
      request.getSession().setAttribute("ENTRY_ID", ENTRY_ID);
      request.getSession().setAttribute("ISOPERATION", ISOPERATION);
    }else{
      PagedListHelper.pageTo(archivesList, page);
    }

    //
    return (mapping.findForward("SUCCESS"));
  }

}