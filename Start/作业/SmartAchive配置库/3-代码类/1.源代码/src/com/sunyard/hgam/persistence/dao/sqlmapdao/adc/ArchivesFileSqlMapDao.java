package com.sunyard.hgam.persistence.dao.sqlmapdao.adc;

import com.sunyard.hgam.persistence.dao.base.BaseSqlMapDao;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.iface.adc.ArchivesFileDao;
import com.sunyard.hgam.persistence.dao.beans.adc.ArchivesFile;
import com.sunyard.hgam.persistence.dao.beans.adc.Archives;
import java.util.List;
import com.ibatis.db.dao.DaoException;
import java.util.Map;

/**
 * <p>Title: HGAM</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author xuxj
 * @version 1.0
 */

public class ArchivesFileSqlMapDao
    extends BaseSqlMapDao
    implements ArchivesFileDao {
  public ArchivesFileSqlMapDao() {
  }

  //新增档案文件信息
  public int addArchivesFile(ArchivesFile archivesFile){
    int iResult = 0;
    try {
      //设置PK
      //执行插入操作
      this.startTransation();
      iResult = this.executeUpdate("addArchivesFile", archivesFile);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return iResult;
  }

  //新增档案文件信息(具有电子表单的业务类)
  public int addArchivesFile(ArchivesFile archivesFile,List eformFieldValueList){
    int iResult = 0;
    try {
      //设置PK
      //执行插入操作
      this.startTransation();
      iResult = this.executeUpdate("addArchivesFile", archivesFile);
      for(int i=0;i<eformFieldValueList.size();i++){
        iResult = this.executeUpdate("addEformFieldValue", eformFieldValueList.get(i));
      }
      this.commitTransation();
    }
    catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return iResult;

  }


  //取得最大的文件ID编码
  public Integer getMaxFileId(){
    Integer maxId = null;
    try {
      this.startTransation();
      maxId = (Integer)this.executeQueryForObject("getMaxFileId", null);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return maxId;

  }


  //根据档案ArchivesID查询所有的文件信息
  public PaginatedList queryArchivesFileByArchivesID(String archivesID) throws Exception {
    return queryArchivesFileByArchivesID(archivesID,this.PAGE_SIZE);
  }

  public PaginatedList queryArchivesFileByArchivesID(String archivesID,
      int pageSize) throws Exception {
    PaginatedList lstRet = null;
    try {
      this.startTransation();
      lstRet = this.executeQueryForPaginatedList("queryArchivesFileByArchivesID",
                                               archivesID, pageSize);
      this.commitTransation();
    }catch(Exception e){/* ignore  Exception*/
      try { this.rollbackTransation(); } catch (Exception ex2) { /* ignore */ }
    }
    return lstRet ;
  }

  //根据文件FileID查询所有的文件信息
  public PaginatedList queryArchivesFileByFileID(String fileID,
                                                 int pageSize) throws Exception {
    PaginatedList lstRet = null;
    try{
      this.startTransation();
      lstRet = this.executeQueryForPaginatedList("queryArchivesFileByFileID",
                                               fileID, pageSize);
      this.commitTransation();
    }catch(Exception e){ /* ignore  Exception*/
      try { this.rollbackTransation(); } catch (Exception ex2) { /* ignore */ }
    }
    return lstRet ;
  }

  //根据文件FileID查询文件信息
  public ArchivesFile getArchivesFileByFileID(String fileID) throws Exception {
    ArchivesFile lstRet = null;
    try {
      this.startTransation();
      lstRet = (ArchivesFile)this.executeQueryForObject(
          "queryArchivesFileByFileID", fileID);
      this.commitTransation();
    }
    catch (Exception e) { /* ignore  Exception*/
      try { this.rollbackTransation(); } catch (Exception ex2) { /* ignore */ }
    }
    return lstRet;
  }

  /**
   * 根据项目、档号找到顶级项目阶段和文件列表
   * @param archives
   * @return List
   * 修订记录：
   * 1、创建（郑先全,2003-12-19）
   */
  public List queryTopArchivesProjPhaseList(Archives archives){
    List lstRet = null;
    try{
      this.startTransation();
      lstRet = this.executeQueryForList("queryTopArchivesProjPhaseList",archives);
      this.commitTransation();
    }catch(Exception e){
      try { this.rollbackTransation(); } catch (Exception ex2) {}
    }
    return lstRet ;
  }

  /**
   * 根据项目、档号找到除了顶级项目阶段外的其他项目阶段和文件列表（郑先全）
   * @param archivesFile
   * @return
   * 修订记录：
   * 1、创建（郑先全,2003-12-19）
   */
  public List queryOtherArchivesProjPhaseList(ArchivesFile archivesFile){
    List lstRet = null;
    try{
      this.startTransation();
      lstRet = this.executeQueryForList("queryOtherArchivesProjPhaseList",archivesFile);
      this.commitTransation();
    }catch(Exception e){
      try { this.rollbackTransation(); } catch (Exception ex2) {}
    }
    return lstRet ;
  }

  //根据项目找到所有顶级项目阶段和文件列表（郑先全）
  public List queryAllTopProjPhaseList(Archives archives){
    List lstRet = null;
    try{
      this.startTransation();
      lstRet = this.executeQueryForList("queryAllTopProjPhaseList",archives);
      this.commitTransation();
    }catch(Exception e){
      try { this.rollbackTransation(); } catch (Exception ex2) {}
    }
    return lstRet ;
  }


  //根据项目找到除了顶级项目阶段外的s所有其他项目阶段和文件列表（郑先全）
  public List queryAllOtherProjPhaseList(ArchivesFile archivesFile){
    List lstRet = null;
    try{
      this.startTransation();
      lstRet = this.executeQueryForList("queryAllOtherProjPhaseList",archivesFile);
      this.commitTransation();
    }catch(Exception e){
      try { this.rollbackTransation(); } catch (Exception ex2) {}
    }
    return lstRet ;
  }

  //更新文件信息(无电子表单信息)
  public int updateArchivesFile(ArchivesFile archivesFile){
    int iResult = 0;
    try {
      //操作
      this.startTransation();
      iResult = this.executeUpdate("updateArchivesFile", archivesFile);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return iResult;
  }

  //更新文件信息(有电子表单信息)
  public int updateArchivesFile(ArchivesFile archivesFile,List eformFieldValueList){
    int iResult = 0;
    try {
      //操作
      this.startTransation();
      iResult = this.executeUpdate("updateArchivesFile", archivesFile);
      //电子表单字段更新逻辑：先删除，后增加
      iResult = this.executeUpdate("deleteEformFieldValueByFileId", archivesFile.getFile_id());
      for(int i=0;i<eformFieldValueList.size();i++){
        iResult = this.executeUpdate("addEformFieldValue", eformFieldValueList.get(i));
      }
      this.commitTransation();
    }
    catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return iResult;
  }

  //取得接收的文件列表
  public PaginatedList getReceivedArchivesFiles(ArchivesFile archivesFile) throws Exception{
    return getReceivedArchivesFiles(archivesFile,this.PAGE_SIZE);
  }
  public PaginatedList getReceivedArchivesFiles(ArchivesFile archivesFile,int pageSize) throws Exception{
    PaginatedList lstRet = null;
    try{
      this.startTransation();
      lstRet = this.executeQueryForPaginatedList("getReceivedArchivesFiles",
                                               archivesFile, pageSize);
      this.commitTransation();
    }catch(Exception e){
      try { this.rollbackTransation(); } catch (Exception ex2) {}
    }
    return lstRet ;
  }

  //选定已接收的文件
  public int updateReceivedArchivesFiles(List archivesFileList){
    int iResult = 0;
    try {
      //操作
      this.startTransation();
      for(int i=0;i<archivesFileList.size();i++){
        iResult = this.executeUpdate("updateReceivedArchivesFileByFileId",
                                     (ArchivesFile)archivesFileList.get(i));
      }
      this.commitTransation();
    }
    catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return iResult;
  }

  //列出档案某个阶段的所有文件
  public PaginatedList queryArchivesFileByPhaseID(ArchivesFile archivesFile){
    return queryArchivesFileByPhaseID(archivesFile,this.PAGE_SIZE);
  }
  public PaginatedList queryArchivesFileByPhaseID(ArchivesFile archivesFile,int pageSize){
    PaginatedList lstRet = null;
    try{
      this.startTransation();
      lstRet = this.executeQueryForPaginatedList("queryArchivesFileByPhaseID",archivesFile,pageSize);
      this.commitTransation();
    }catch(Exception e){
      try { this.rollbackTransation(); } catch (Exception ex2) {}
    }
    return lstRet ;
  }
 //得到文件页得最小值
 public int getMINPageNumArchivesFiles(ArchivesFile archivesFile){
     int MinPageNum=0;
     try{
     this.startTransation();
     MinPageNum=this.executeUpdate("getMINPageNumArchivesFiles",archivesFile);
     this.commitTransation();
   }catch(Exception e){
     try { this.rollbackTransation();}catch (Exception ex2) {}
 }
  return MinPageNum ;
    }
  //得到文件页得最大值
   public int getMAXPageNumArchivesFiles(ArchivesFile archivesFile){
       int MaxPageNum=0;
       try{
       this.startTransation();
       MaxPageNum=this.executeUpdate("getMAXPageNumArchivesFiles",archivesFile);
       this.commitTransation();
     }catch(Exception e){
       try { this.rollbackTransation();}catch (Exception ex2) {}
   }
    return MaxPageNum ;
      }
      //根据档案ArchivesID查询所有的文件信息
      public PaginatedList queryArchivesFileJianByArchivesID(String archivesID) throws Exception {
         return queryArchivesFileJianByArchivesID(archivesID,this.PAGE_SIZE);
       }

       public PaginatedList queryArchivesFileJianByArchivesID(String archivesID,
           int pageSize) throws Exception {
         PaginatedList lstRet = null;
         try {
           this.startTransation();
           lstRet = this.executeQueryForPaginatedList("queryArchivesFileJianByArchivesID",
                                                    archivesID, pageSize);
           this.commitTransation();
         }catch(Exception e){/* ignore  Exception*/
           try { this.rollbackTransation(); } catch (Exception ex2) { /* ignore */ }
         }
         return lstRet ;
       }

     //根据id段，取档案信息数据 add by hukp
       public List queryArchivesJianByID(Map projIdMap){
         List list = null;
         try {
           this.startTransation();
           list = this.executeQueryForList("getArchivesJianByProjId", projIdMap);
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

       //根据fileID更新是否借出的标志位,wanghua add,2004-03-15
       public int updateBorrowStatusByFileID(Map fileIDMap) {
         int affectedRows = 0;
         try {
           this.startTransation();
           affectedRows = this.executeUpdate("updateBorrowStatusByFileID", fileIDMap);
           this.commitTransation();
         }
         catch (DaoException ex) {
           try {
             this.rollbackTransation();
           }
           catch (Exception ex2) {}
           ex.printStackTrace();
         }
         return affectedRows;
       }

 //查询文件列表
 public PaginatedList queryArchivesFile(ArchivesFile archivesFile) throws Exception{
   return queryArchivesFile(archivesFile,this.PAGE_SIZE) ;
 }
  public PaginatedList queryArchivesFile(ArchivesFile archivesFile, int pageSize) throws Exception{
    PaginatedList lstRet = null;
    try{
      this.startTransation();
      lstRet = this.executeQueryForPaginatedList("queryArchivesFile",archivesFile,pageSize);
      this.commitTransation();
    }catch(Exception e){
      try { this.rollbackTransation(); } catch (Exception ex2) {}
    }
    return lstRet ;
  }


}