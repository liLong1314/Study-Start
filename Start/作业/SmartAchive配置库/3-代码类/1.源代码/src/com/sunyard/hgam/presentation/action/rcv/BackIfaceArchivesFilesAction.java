package com.sunyard.hgam.presentation.action.rcv;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.presentation.form.adc.ArchivesFileForm;
import com.sunyard.hgam.persistence.dao.beans.adc.ArchivesFile;
import com.sunyard.hgam.persistence.dao.iface.rcv.IfaceArchivesFileDao;


public class BackIfaceArchivesFilesAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.Exception {

    //ѡ�����ļ�
    String fileIds = request.getParameter("fileIds2");

    try {
      if(fileIds==null || fileIds.equals("")){
        throw new Exception("�������ԣ�û��ָ���ļ���ţ�fileId��");
      }

      ArchivesFileForm archivesFileForm = (ArchivesFileForm) form;
      ArchivesFile archivesFile = null;
      IfaceArchivesFileDao ifaceArchivesFileDao = (IfaceArchivesFileDao)
          domainLogic.getDAO("IfaceArchivesFile");

      //�˻�ָ���������ļ�������״̬Ϊ�����˻أ�3��
      ifaceArchivesFileDao.updateIfaceArchivesFileStatusToBackByFileIds(fileIds);

    }catch (Exception ex) {
      ex.printStackTrace();
    }

    //����
    return (mapping.findForward("SUCCESS"));
  }
}
