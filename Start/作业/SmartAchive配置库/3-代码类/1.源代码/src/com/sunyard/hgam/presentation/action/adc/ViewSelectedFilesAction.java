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
    //�޶�(֣��ȫ��20040302)�����Բ�ѯ
    PaginatedList receivedArchivesFileList = (PaginatedList) request.
        getAttribute("receivedArchivesFileList");

    String page = request.getParameter("page");
    String pageSize = request.getParameter("pageSize");
    String operName = request.getParameter("operName");

    if (receivedArchivesFileList==null || page == null || operName!=null) {
      ArchivesFileForm archivesFileForm = (ArchivesFileForm) form;
      ArchivesFile archivesFile = archivesFileForm.getArchivesFile();

      //ȡ�õ���ID��1. �Ӳ������ȡ �� 2.��session�л�ȡ
      String archives_id = request.getParameter("ARCHIVES_ID");
      if (archives_id == null || archives_id.equalsIgnoreCase("")) {
        archives_id = String.valueOf(request.getSession().getAttribute("ARCHIVES_ID"));
      }

      archivesFile.setArchives_id(archives_id);

      //�õ��б�
      ArchivesFileDao archivesFileDao = (ArchivesFileDao) domainLogic.getDAO("ArchivesFile");
      if(pageSize==null || pageSize.equals("")){
        receivedArchivesFileList = archivesFileDao.getReceivedArchivesFiles(
            archivesFile);
      }else{
        receivedArchivesFileList = archivesFileDao.getReceivedArchivesFiles(
            archivesFile,Integer.parseInt(pageSize));
      }

      //���뻺��
      request.setAttribute("receivedArchivesFileList",receivedArchivesFileList);
    }
    else {
      PagedListHelper.pageTo(receivedArchivesFileList, page);
    }

    //
    return (mapping.findForward("SUCCESS"));
  }

}