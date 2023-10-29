package com.sunyard.hgam.presentation.action.rcv;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.presentation.form.adc.ArchivesFileForm;
import com.sunyard.hgam.persistence.dao.beans.adc.ArchivesFile;
import com.sunyard.hgam.persistence.dao.iface.rcv.IfaceArchivesFileDao;
import com.sunyard.hgam.persistence.dao.iface.adc.ArchivesFileDao;
import java.util.List;
import java.util.ArrayList;
import com.sunyard.hgam.persistence.dao.beans.adc.EformFieldValue;
import com.sunyard.hgam.persistence.dao.iface.adc.ArchivesPageDao;
import com.sunyard.hgam.persistence.dao.beans.adc.ArchivesPage;


public class ReceiveIfaceArchivesFilesAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.Exception {
    //ѡ�����ļ�
    String fileId[] = null;

    try {
      if(request.getParameterValues("fileIds1")!=null){
        fileId=((String)request.getParameter("fileIds1")).split(",");
      }else{
        throw new Exception("�������ԣ�û��ָ���ļ���ţ�fileId��");
      }

      ArchivesFileForm archivesFileForm = (ArchivesFileForm) form;
      ArchivesFile archivesFile = null;
      IfaceArchivesFileDao ifaceArchivesFileDao = (IfaceArchivesFileDao)
          domainLogic.getDAO("IfaceArchivesFile");
      ArchivesFileDao archivesFileDao = (ArchivesFileDao)
          domainLogic.getDAO("ArchivesFile");
      ArchivesPageDao archivesPageDao = (ArchivesPageDao)
          domainLogic.getDAO("ArchivesPageDao");

      //����ӿڿ��µĵ��ӱ�����
      ifaceArchivesFileDao.insertAllEformFromOA();

      //����
      String oldFileId = "";
      String newFileId = "";
      ArchivesPage archivesPage = null;

      //����ָ�����ļ�
      for(int i=0;i<fileId.length;i++){
        int fileIndex = 0;
        List archivesPageList = null;
        List fileUrlList = new ArrayList();
        //��ʼ���ļ�ʵ��
        archivesFile = ifaceArchivesFileDao.getIfaceArchivesFileByFileId(fileId[i]);

        //�����ֶ�ֵ
        oldFileId = archivesFile.getFile_id();
        newFileId = (archivesFileDao.getMaxFileId().intValue() + 1) + "";
        archivesFile.setFile_id(newFileId);
        archivesFile.setParent_file_id("");//ע�⣺��ʱ���ø��ֶ�

        //����ļ��и�����Ҫ����
        if(archivesFile.getFile_pathName()!=null && !archivesFile.getFile_pathName().equals("")){
          fileUrlList.add(fileIndex,archivesFile.getFile_pathName());
          fileIndex++;
        }
        //���ӷ�����ȷ�������������(2004-1-2)
        if (archivesFile.getEform_id() == null ||
            archivesFile.getEform_id().equals("")) {
          //�������ļ�
          //1.�����ļ���¼��Ϣ
          //archivesFileDao.addArchivesFile(archivesFile);
          //2.��װӰ��ҳ��¼��Ϣ��Ӱ��ҳ�ļ�
          archivesPageList = ifaceArchivesFileDao.getIfaceArchivesPageByFileID(fileId[i]);
          for (int j=0;j<archivesPageList.size();j++){
            //
            archivesPage = (ArchivesPage) archivesPageList.get(j);
            //�޶���������ļ���ű������µ��ļ���ţ�����ԭ����fileId[i]
            archivesPage.setFile_id(newFileId);
            archivesPageList.set(j,archivesPage);
            //archivesPageDao.addArchivesPage(archivesPage);
            if (archivesPage.getPage_pathName() != null && !archivesPage.getPage_pathName().equals("")) {
              fileUrlList.add(fileIndex, archivesPage.getPage_pathName());
              fileIndex++;
            }
          }
          //TODO:Ԫ���ݵķ�װ�뵼��
          //���񻯵������
          ifaceArchivesFileDao.receiveIfaceInfoInTrans(archivesFile,oldFileId,
              archivesPageList, fileUrlList, null);
        }
        else {
          //ҵ�����ļ�
          //1.�����ļ���¼��Ϣ
          //archivesFileDao.addArchivesFile(archivesFile);
          //2.��װӰ��ҳ��¼��Ϣ��Ӱ��ҳ�ļ�
          archivesPageList = ifaceArchivesFileDao.getIfaceArchivesPageByFileID(fileId[i]);
          for (int j=0;j<archivesPageList.size();j++){
            //
            archivesPage = (ArchivesPage) archivesPageList.get(j);
            archivesPage.setFile_id(newFileId);
            archivesPageList.set(j,archivesPage);
            //archivesPageDao.addArchivesPage(archivesPage);
            if (archivesPage.getPage_pathName() != null && !archivesPage.getPage_pathName().equals("")) {
              fileUrlList.add(fileIndex, archivesPage.getPage_pathName());
              fileIndex++;
            }
          }
          //3.��װ���ӱ���¼
          List eformFieldValueList1 = new ArrayList();
          List eformFieldValueList = new ArrayList();
          int gg = 0;
          eformFieldValueList1 = ifaceArchivesFileDao.getIfaceEformFieldValueInfoByFileId(fileId[i]);
          for(int j=0;j<eformFieldValueList1.size();j++){
            EformFieldValue eformFieldValue = (EformFieldValue) eformFieldValueList1.get(j);
            //�޶������ڴ�ʱ����field_valueΪNULL�Ŀ��ܣ��ʱ����жϲ�����һ�£�֣��ȫ��2004-1-6��
            if(eformFieldValue.getField_value()!=null && !eformFieldValue.getField_value().equals("")){
              eformFieldValue.setFile_id(newFileId);
              eformFieldValueList.add(gg, eformFieldValue);
            }
          }
          //TODO:Ԫ���ݵķ�װ�뵼��
          //���񻯵������
          ifaceArchivesFileDao.receiveIfaceInfoInTrans(archivesFile,oldFileId,
              archivesPageList, fileUrlList, null, eformFieldValueList);
        }
      }
    }catch (Exception ex) {
      ex.printStackTrace();
    }

    //����
    return (mapping.findForward("SUCCESS"));
  }
}
