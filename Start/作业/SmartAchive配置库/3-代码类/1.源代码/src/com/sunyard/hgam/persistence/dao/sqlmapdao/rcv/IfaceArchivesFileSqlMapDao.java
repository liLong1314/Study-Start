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
  //���ݲ�ѯ�����������ļ��б�(Ĭ��)
  public PaginatedList queryIfaceArchivesFileList(ArchivesFile ifaceFile){
    return queryIfaceArchivesFileList(ifaceFile,this.PAGE_SIZE) ;
  }
  //���ݲ�ѯ�����������ļ��б�(����ÿҳ��¼��)
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
  //����file_id��ȡ�ýӿڿ��ļ���Ϣ
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

  //����file_id,ȡ�õ��ӱ��ֶζ��弰���ֶ�ֵ
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


  //����ӿڿ�ĵ��ӱ�
  public int insertAllEformFromOA(){
    int iResult = 0;
    try {
      this.startTransation();
      //������ӱ�����
      iResult = this.executeUpdate("insertAllEformDefineFromOA", null);
      //������ӱ��ֶζ���
      iResult = this.executeUpdate("insertAllFieldDefineFromOA", null);
      //������ӱ����ֶι�ϵ
      iResult = this.executeUpdate("insertAllEformFieldFromOA", null);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return iResult;
  }

  //���񻯽��սӿڵ����ļ���¼��Ϣ���ļ�������Ӱ��ҳ��¼��Ϣ��Ӱ��ҳ�ļ����޵��ӱ���
  public int receiveIfaceInfoInTrans(ArchivesFile archivesFile,String ifaceFileId,
                                     List archivesPageList, List fileUrlList,
                                     List metadataList) throws java.lang.Exception {
    return receiveIfaceInfoInTrans(archivesFile, ifaceFileId, archivesPageList, fileUrlList,
                                   metadataList, null);
  }

  //���񻯽��սӿڵ����ļ���¼��Ϣ���ļ�������Ӱ��ҳ��¼��Ϣ��Ӱ��ҳ�ļ����е��ӱ���
  public int receiveIfaceInfoInTrans(ArchivesFile archivesFile,String ifaceFileId,
                                     List archivesPageList, List fileUrlList,
                                     List metadataList,
                                     List eformFieldValueList) throws java.lang.Exception {
    String page_id = "";
    int iResult = 0;
    try {
      this.startTransation();
      //�����ļ���¼��Ϣ
      iResult = this.executeUpdate("addArchivesFile", archivesFile);
      //�������Ӱ��ҳ��¼��Ϣ
      for(int i=0;i<archivesPageList.size();i++){
        //�޶�������PAGE_ID��ȡ��
        ArchivesPage archivesPage = (ArchivesPage)archivesPageList.get(i);
        page_id = String.valueOf(((Integer)this.executeQueryForObject("getMaxArchivesPageId", null)).intValue() + 1);
        archivesPage.setPage_id(page_id);
        iResult = this.executeUpdate("addArchivesPageFromIface", archivesPage);
      }
      //��������ļ�
      if (fileUrlList!=null){
        for (int i = 0; i < fileUrlList.size(); i++) {
          try{
            FileUtil.receiveFileFromIfaceByPathName( (String) fileUrlList.get(i));
          }catch(Exception ex){
            throw new Exception("�ļ����չ����з����쳣��\nfileId=��" +
                                archivesFile.getFile_id() + "\nURL=��" +
                                fileUrlList.get(i) + "\n�쳣��Ϣ��" + ex);
          }
        }
      }
      //������ӱ��ֶ�ֵ
      if (eformFieldValueList!=null){
        for (int i = 0; i < eformFieldValueList.size(); i++) {
          iResult = this.executeUpdate("addEformFieldValue",
                                       eformFieldValueList.get(i));
        }
      }
      //����Ԫ����
      /*
      if(metadataList!=null){
        for (int i = 0; i < metadataList.size(); i++) {
          iResult = this.executeUpdate("TODO", metadataList.get(i));
        }
      }*/
      //�����м���״̬Ϊ���ѽ��ա�(ע�⣬������ԭ����FILE_ID-ifaceFileId)
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

  //���½ӿڿ��ļ�״̬Ϊ���ѽ���-2��
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
  //���½ӿڿ��ļ�״̬Ϊ�����˻�-3��
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

  //����file_id��ȡ�ýӿڿ��ļ������ڵ�����Ӱ��ҳ�б�
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
