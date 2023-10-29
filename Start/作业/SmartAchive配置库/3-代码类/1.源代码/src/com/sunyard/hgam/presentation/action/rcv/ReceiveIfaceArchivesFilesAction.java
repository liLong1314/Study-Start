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
    //选定的文件
    String fileId[] = null;

    try {
      if(request.getParameterValues("fileIds1")!=null){
        fileId=((String)request.getParameter("fileIds1")).split(",");
      }else{
        throw new Exception("参数不对，没有指定文件编号（fileId）");
      }

      ArchivesFileForm archivesFileForm = (ArchivesFileForm) form;
      ArchivesFile archivesFile = null;
      IfaceArchivesFileDao ifaceArchivesFileDao = (IfaceArchivesFileDao)
          domainLogic.getDAO("IfaceArchivesFile");
      ArchivesFileDao archivesFileDao = (ArchivesFileDao)
          domainLogic.getDAO("ArchivesFile");
      ArchivesPageDao archivesPageDao = (ArchivesPageDao)
          domainLogic.getDAO("ArchivesPageDao");

      //导入接口库新的电子表单定义
      ifaceArchivesFileDao.insertAllEformFromOA();

      //变量
      String oldFileId = "";
      String newFileId = "";
      ArchivesPage archivesPage = null;

      //接收指定的文件
      for(int i=0;i<fileId.length;i++){
        int fileIndex = 0;
        List archivesPageList = null;
        List fileUrlList = new ArrayList();
        //初始化文件实例
        archivesFile = ifaceArchivesFileDao.getIfaceArchivesFileByFileId(fileId[i]);

        //设置字段值
        oldFileId = archivesFile.getFile_id();
        newFileId = (archivesFileDao.getMaxFileId().intValue() + 1) + "";
        archivesFile.setFile_id(newFileId);
        archivesFile.setParent_file_id("");//注意：暂时不用该字段

        //如果文件有附件，要设置
        if(archivesFile.getFile_pathName()!=null && !archivesFile.getFile_pathName().equals("")){
          fileUrlList.add(fileIndex,archivesFile.getFile_pathName());
          fileIndex++;
        }
        //增加方法，确保导入过程事务化(2004-1-2)
        if (archivesFile.getEform_id() == null ||
            archivesFile.getEform_id().equals("")) {
          //文书类文件
          //1.导入文件著录信息
          //archivesFileDao.addArchivesFile(archivesFile);
          //2.封装影像页著录信息和影像页文件
          archivesPageList = ifaceArchivesFileDao.getIfaceArchivesPageByFileID(fileId[i]);
          for (int j=0;j<archivesPageList.size();j++){
            //
            archivesPage = (ArchivesPage) archivesPageList.get(j);
            //修订：这里的文件编号必须是新的文件编号，而非原来的fileId[i]
            archivesPage.setFile_id(newFileId);
            archivesPageList.set(j,archivesPage);
            //archivesPageDao.addArchivesPage(archivesPage);
            if (archivesPage.getPage_pathName() != null && !archivesPage.getPage_pathName().equals("")) {
              fileUrlList.add(fileIndex, archivesPage.getPage_pathName());
              fileIndex++;
            }
          }
          //TODO:元数据的封装与导入
          //事务化导入操作
          ifaceArchivesFileDao.receiveIfaceInfoInTrans(archivesFile,oldFileId,
              archivesPageList, fileUrlList, null);
        }
        else {
          //业务类文件
          //1.导入文件著录信息
          //archivesFileDao.addArchivesFile(archivesFile);
          //2.封装影像页著录信息和影像页文件
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
          //3.封装电子表单著录
          List eformFieldValueList1 = new ArrayList();
          List eformFieldValueList = new ArrayList();
          int gg = 0;
          eformFieldValueList1 = ifaceArchivesFileDao.getIfaceEformFieldValueInfoByFileId(fileId[i]);
          for(int j=0;j<eformFieldValueList1.size();j++){
            EformFieldValue eformFieldValue = (EformFieldValue) eformFieldValueList1.get(j);
            //修订：由于此时存在field_value为NULL的可能，故必须判断并处理一下（郑先全，2004-1-6）
            if(eformFieldValue.getField_value()!=null && !eformFieldValue.getField_value().equals("")){
              eformFieldValue.setFile_id(newFileId);
              eformFieldValueList.add(gg, eformFieldValue);
            }
          }
          //TODO:元数据的封装与导入
          //事务化导入操作
          ifaceArchivesFileDao.receiveIfaceInfoInTrans(archivesFile,oldFileId,
              archivesPageList, fileUrlList, null, eformFieldValueList);
        }
      }
    }catch (Exception ex) {
      ex.printStackTrace();
    }

    //返回
    return (mapping.findForward("SUCCESS"));
  }
}
