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
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
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

  //���������ļ���Ϣ
  public int addArchivesFile(ArchivesFile archivesFile){
    int iResult = 0;
    try {
      //����PK
      //ִ�в������
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

  //���������ļ���Ϣ(���е��ӱ���ҵ����)
  public int addArchivesFile(ArchivesFile archivesFile,List eformFieldValueList){
    int iResult = 0;
    try {
      //����PK
      //ִ�в������
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


  //ȡ�������ļ�ID����
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


  //���ݵ���ArchivesID��ѯ���е��ļ���Ϣ
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

  //�����ļ�FileID��ѯ���е��ļ���Ϣ
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

  //�����ļ�FileID��ѯ�ļ���Ϣ
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
   * ������Ŀ�������ҵ�������Ŀ�׶κ��ļ��б�
   * @param archives
   * @return List
   * �޶���¼��
   * 1��������֣��ȫ,2003-12-19��
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
   * ������Ŀ�������ҵ����˶�����Ŀ�׶����������Ŀ�׶κ��ļ��б�֣��ȫ��
   * @param archivesFile
   * @return
   * �޶���¼��
   * 1��������֣��ȫ,2003-12-19��
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

  //������Ŀ�ҵ����ж�����Ŀ�׶κ��ļ��б�֣��ȫ��
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


  //������Ŀ�ҵ����˶�����Ŀ�׶����s����������Ŀ�׶κ��ļ��б�֣��ȫ��
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

  //�����ļ���Ϣ(�޵��ӱ���Ϣ)
  public int updateArchivesFile(ArchivesFile archivesFile){
    int iResult = 0;
    try {
      //����
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

  //�����ļ���Ϣ(�е��ӱ���Ϣ)
  public int updateArchivesFile(ArchivesFile archivesFile,List eformFieldValueList){
    int iResult = 0;
    try {
      //����
      this.startTransation();
      iResult = this.executeUpdate("updateArchivesFile", archivesFile);
      //���ӱ��ֶθ����߼�����ɾ����������
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

  //ȡ�ý��յ��ļ��б�
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

  //ѡ���ѽ��յ��ļ�
  public int updateReceivedArchivesFiles(List archivesFileList){
    int iResult = 0;
    try {
      //����
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

  //�г�����ĳ���׶ε������ļ�
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
 //�õ��ļ�ҳ����Сֵ
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
  //�õ��ļ�ҳ�����ֵ
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
      //���ݵ���ArchivesID��ѯ���е��ļ���Ϣ
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

     //����id�Σ�ȡ������Ϣ���� add by hukp
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

       //����fileID�����Ƿ����ı�־λ,wanghua add,2004-03-15
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

 //��ѯ�ļ��б�
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