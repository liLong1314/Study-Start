package com.sunyard.hgam.presentation.action.rcv;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.presentation.form.adc.ArchivesFileForm;
import com.sunyard.hgam.persistence.dao.beans.adc.ArchivesFile;
import com.sunyard.hgam.persistence.dao.iface.rcv.IfaceArchivesFileDao;

public class QueryIfaceArchivesFileListAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.Exception {

    PaginatedList ifaceArchivesFileList = (PaginatedList) request.getSession().getAttribute("ifaceArchivesFileList");

    String page = request.getParameter("page");
    String pageSize = request.getParameter("pageSize");

    if (ifaceArchivesFileList==null || page == null) {
      ArchivesFileForm archivesFileForm = (ArchivesFileForm) form;
      ArchivesFile archivesFile = archivesFileForm.getArchivesFile();

      IfaceArchivesFileDao ifaceArchivesFileDao = (IfaceArchivesFileDao) domainLogic.getDAO("IfaceArchivesFile");
      if(pageSize!=null && !pageSize.equals("")){
        ifaceArchivesFileList = ifaceArchivesFileDao.queryIfaceArchivesFileList(archivesFile,Integer.parseInt(pageSize));
      }else{
        ifaceArchivesFileList = ifaceArchivesFileDao.queryIfaceArchivesFileList(archivesFile);
      }

      //∑≈»Îª∫¥Ê
      request.getSession().setAttribute("ifaceArchivesFileList", ifaceArchivesFileList);
    }
    else {
      PagedListHelper.pageTo(ifaceArchivesFileList, page);
    }

    //
    return (mapping.findForward("SUCCESS"));
  }
}