package com.sunyard.hgam.presentation.action.rcv;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.presentation.form.adc.ArchivesFileForm;
import com.sunyard.hgam.persistence.dao.beans.adc.ArchivesFile;
import com.sunyard.hgam.persistence.dao.iface.rcv.SettleArchivesFileDao;

public class QuerySettleArchivesFileListAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.Exception {

    PaginatedList toSettleArchivesFileList = (PaginatedList) request.getSession().getAttribute("toSettleArchivesFileList");

    String page = request.getParameter("page");

    if (toSettleArchivesFileList==null || page == null) {
      ArchivesFileForm archivesFileForm = (ArchivesFileForm) form;
      ArchivesFile archivesFile = archivesFileForm.getArchivesFile();

      SettleArchivesFileDao archivesFileDao = (SettleArchivesFileDao) domainLogic.getDAO("SettleArchivesFile");
      toSettleArchivesFileList = archivesFileDao.querySettleArchivesFileList(archivesFile);

      //∑≈»Îª∫¥Ê
      request.getSession().setAttribute("toSettleArchivesFileList", toSettleArchivesFileList);
    }
    else {
      PagedListHelper.pageTo(toSettleArchivesFileList, page);
    }

    //
    return (mapping.findForward("SUCCESS"));
  }
}
