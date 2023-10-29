package com.sunyard.hgam.presentation.action.adc;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.adc.ArchivesFileForm;
import com.sunyard.hgam.persistence.dao.beans.adc.ArchivesFile;
import com.sunyard.hgam.persistence.dao.iface.adc.ArchivesFileDao;
import com.sunyard.hgam.persistence.dao.beans.adc.Archives;
import java.util.List;
import java.util.ArrayList;

public class SelectReceivedFilesAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.Exception {
    //ѡ�����ļ�
    String fileId[] = null;
    String strForwardTo = "SUCCESS";

    try {
      if(request.getParameterValues("file_id")!=null){
        fileId=request.getParameterValues("file_id");
      }else{
        throw new Exception("�������ԣ�û��ָ���ļ���ţ�fileId��");
      }

      ArchivesFileForm archivesFileForm = (ArchivesFileForm) form;
      ArchivesFile archivesFile = archivesFileForm.getArchivesFile();
      String archivesId = archivesFile.getArchives_id();
      ArchivesFileDao archivesFileDao = (ArchivesFileDao)domainLogic.getDAO("ArchivesFile");

      //����ѡ�����ļ�
      List archivesFileList = new ArrayList();
      for (int i = 0; i < fileId.length; i++) {
        //��ʼ���ļ�ʵ��
        archivesFile = archivesFileDao.getArchivesFileByFileID(fileId[i]);

        //�����ļ��ĵ�������
        archivesFile.setArchives_id(archivesId);

        //��װ������
        archivesFileList.add(archivesFile);
      }

      //���񻯸��²���
      archivesFileDao.updateReceivedArchivesFiles(archivesFileList);

    }catch (Exception ex) {
      strForwardTo = "FAILURE";
      ex.printStackTrace();
    }

    //����
    return (mapping.findForward(strForwardTo));
  }

}