package com.sunyard.hgam.presentation.action.adc;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.presentation.form.adc.ArchivesFileForm;
import com.sunyard.hgam.persistence.dao.iface.adc.ArchivesDao;
import com.sunyard.hgam.persistence.dao.beans.adc.Archives;
import com.sunyard.hgam.persistence.dao.iface.adc.ArchivesFileDao;
import com.sunyard.hgam.persistence.dao.beans.adc.ArchivesFile;

public class ViewSelectedFilesAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.Exception {
    //修订(郑先全，20040302)：可以查询
    PaginatedList receivedArchivesFileList = (PaginatedList) request.
        getAttribute("receivedArchivesFileList");

    String page = request.getParameter("page");
    String pageSize = request.getParameter("pageSize");
    String operName = request.getParameter("operName");

    if (receivedArchivesFileList==null || page == null || operName!=null) {
      ArchivesFileForm archivesFileForm = (ArchivesFileForm) form;
      ArchivesFile archivesFile = archivesFileForm.getArchivesFile();

      //取得档案ID：1. 从参数表获取 ， 2.从session中获取
      String archives_id = request.getParameter("ARCHIVES_ID");
      if (archives_id == null || archives_id.equalsIgnoreCase("")) {
        archives_id = String.valueOf(request.getSession().getAttribute("ARCHIVES_ID"));
      }

      archivesFile.setArchives_id(archives_id);

      //得到列表
      ArchivesFileDao archivesFileDao = (ArchivesFileDao) domainLogic.getDAO("ArchivesFile");
      if(pageSize==null || pageSize.equals("")){
        receivedArchivesFileList = archivesFileDao.getReceivedArchivesFiles(
            archivesFile);
      }else{
        receivedArchivesFileList = archivesFileDao.getReceivedArchivesFiles(
            archivesFile,Integer.parseInt(pageSize));
      }

      //放入缓存
      request.setAttribute("receivedArchivesFileList",receivedArchivesFileList);
    }
    else {
      PagedListHelper.pageTo(receivedArchivesFileList, page);
    }

    //
    return (mapping.findForward("SUCCESS"));
  }

}