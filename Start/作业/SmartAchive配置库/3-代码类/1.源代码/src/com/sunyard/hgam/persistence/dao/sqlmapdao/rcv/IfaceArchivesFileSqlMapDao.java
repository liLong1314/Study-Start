package com.sunyard.hgam.persistence.dao.sqlmapdao.rcv;

import java.util.List;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.beans.adc.ArchivesFile;
import com.sunyard.hgam.persistence.dao.iface.rcv.IfaceArchivesFileDao;
import com.sunyard.hgam.persistence.dao.base.BaseSqlMapDao;
import com.ibatis.db.dao.DaoException;
import com.sunyard.hgam.persistence.dao.beans.adc.ArchivesPage;
import com.sunyard.hgam.util.rcv.FileUtil;

public class IfaceArchivesFileSqlMapDao
    extends BaseSqlMapDao
    implements IfaceArchivesFileDao {
  public IfaceArchivesFileSqlMapDao() {
  }
  //根据查询条件，返回文件列表(默认)
  public PaginatedList queryIfaceArchivesFileList(ArchivesFile ifaceFile){
    return queryIfaceArchivesFileList(ifaceFile,this.PAGE_SIZE) ;
  }
  //根据查询条件，返回文件列表(定制每页记录数)
  public PaginatedList queryIfaceArchivesFileList(ArchivesFile ifaceFile,int pageSize){
    PaginatedList lstRet = null;
    try {
      this.startTransation();
      lstRet = this.executeQueryForPaginatedList("queryIfaceArchivesFileList",
                                               ifaceFile, pageSize);
      this.commitTransation();
    }catch(Exception e){/* ignore  Exception*/
      try { this.rollbackTransation(); } catch (Exception ex2) { /* ignore */ }
    }
    return lstRet ;
  }
  //根据file_id，取得接口库文件信息
  public ArchivesFile getIfaceArchivesFileByFileId(String fileId){
    ArchivesFile lstRet = null;
    try {
      this.startTransation();
      lstRet = (ArchivesFile)this.executeQueryForObject("getIfaceArchivesFileByFileId", fileId);
      this.commitTransation();
    }
    catch (Exception e) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
    }
    return lstRet;
  }

  //根据file_id,取得电子表单字段定义及其字段值
  public List getIfaceEformFieldValueInfoByFileId(String fileId){
    List list = null;
    try {
      this.startTransation();
      list = this.executeQueryForList("getIfaceEformFieldValueInfoByFileId", fileId);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return list;
  }


  //导入接口库的电子表单
  public int insertAllEformFromOA(){
    int iResult = 0;
    try {
      this.startTransation();
      //导入电子表单定义
      iResult = this.executeUpdate("insertAllEformDefineFromOA", null);
      //导入电子表单字段定义
      iResult = this.executeUpdate("insertAllFieldDefineFromOA", null);
      //导入电子表单－字段关系
      iResult = this.executeUpdate("insertAllEformFieldFromOA", null);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return iResult;
  }

  //事务化接收接口档案文件著录信息、文件附件、影像页著录信息、影像页文件（无电子表单）
  public int receiveIfaceInfoInTrans(ArchivesFile archivesFile,String ifaceFileId,
                                     List archivesPageList, List fileUrlList,
                                     List metadataList) throws java.lang.Exception {
    return receiveIfaceInfoInTrans(archivesFile, ifaceFileId, archivesPageList, fileUrlList,
                                   metadataList, null);
  }

  //事务化接收接口档案文件著录信息、文件附件、影像页著录信息、影像页文件（有电子表单）
  public int receiveIfaceInfoInTrans(ArchivesFile archivesFile,String ifaceFileId,
                                     List archivesPageList, List fileUrlList,
                                     List metadataList,
                                     List eformFieldValueList) throws java.lang.Exception {
    String page_id = "";
    int iResult = 0;
    try {
      this.startTransation();
      //导入文件著录信息
      iResult = this.executeUpdate("addArchivesFile", archivesFile);
      //导入相关影像页著录信息
      for(int i=0;i<archivesPageList.size();i++){
        //修订：增加PAGE_ID的取得
        ArchivesPage archivesPage = (ArchivesPage)archivesPageList.get(i);
        page_id = String.valueOf(((Integer)this.executeQueryForObject("getMaxArchivesPageId", null)).intValue() + 1);
        archivesPage.setPage_id(page_id);
        iResult = this.executeUpdate("addArchivesPageFromIface", archivesPage);
      }
      //导入电子文件
      if (fileUrlList!=null){
        for (int i = 0; i < fileUrlList.size(); i++) {
          try{
            FileUtil.receiveFileFromIfaceByPathName( (String) fileUrlList.get(i));
          }catch(Exception ex){
            throw new Exception("文件接收过程中发生异常：\nfileId=：" +
                                archivesFile.getFile_id() + "\nURL=：" +
                                fileUrlList.get(i) + "\n异常信息：" + ex);
          }
        }
      }
      //导入电子表单字段值
      if (eformFieldValueList!=null){
        for (int i = 0; i < eformFieldValueList.size(); i++) {
          iResult = this.executeUpdate("addEformFieldValue",
                                       eformFieldValueList.get(i));
        }
      }
      //导入元数据
      /*
      if(metadataList!=null){
        for (int i = 0; i < metadataList.size(); i++) {
          iResult = this.executeUpdate("TODO", metadataList.get(i));
        }
      }*/
      //更新中间库的状态为“已接收”(注意，必须是原来的FILE_ID-ifaceFileId)
      //iResult = this.executeUpdate("updateIfaceArchivesFileStatusToReceivedByFileId", archivesFile.getFile_id());
      iResult = this.executeUpdate("updateIfaceArchivesFileStatusToReceivedByFileId", ifaceFileId);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return iResult;
  }

  //更新接口库文件状态为“已接收-2”
  public int updateIfaceArchivesFileStatusToReceivedByFileId(String fileId){
    int iResult = 0;
    try {
      this.startTransation();
      iResult = this.executeUpdate("updateIfaceArchivesFileStatusToReceivedByFileId", fileId);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return iResult;
  }
  //更新接口库文件状态为“已退回-3”
  public int updateIfaceArchivesFileStatusToBackByFileIds(String fileIds){
    int iResult = 0;
    try {
      this.startTransation();
      iResult = this.executeUpdate("updateIfaceArchivesFileStatusToBackByFileIds", fileIds);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return iResult;
  }

  //根据file_id，取得接口库文件所对于的所有影像页列表
  public List getIfaceArchivesPageByFileID(String fileId){
    List list = null;
    try {
      this.startTransation();
      list = this.executeQueryForList("getIfaceArchivesPageByFileID", fileId);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return list;
  }


}
