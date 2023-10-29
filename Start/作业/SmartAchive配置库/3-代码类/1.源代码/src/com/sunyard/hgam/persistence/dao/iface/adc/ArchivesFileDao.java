package com.sunyard.hgam.persistence.dao.iface.adc;

import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.beans.adc.Archives;
import com.sunyard.hgam.persistence.dao.beans.adc.ArchivesFile;
import java.util.Map;
import java.util.List;

/**
 * <p>Title: HGAM</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author ֣��ȫ
 * @version 1.0
 */

public interface ArchivesFileDao {
  //���������ļ���Ϣ(һ��������)
  public int addArchivesFile(ArchivesFile archivesFile);

  //���������ļ���Ϣ(���е��ӱ���ҵ����)
  public int addArchivesFile(ArchivesFile archivesFile,List eformFieldValueList);

  //ȡ�������ļ�ID����
  public Integer getMaxFileId();

  //���ݵ���ArchivesID��ѯ���е��ļ���Ϣ
  public PaginatedList queryArchivesFileByArchivesID(String archivesID) throws Exception;
  public PaginatedList queryArchivesFileByArchivesID(String archivesID,
      int pageSize) throws Exception;

  //�����ļ�FileID��ѯ���е��ļ���Ϣ
  public PaginatedList queryArchivesFileByFileID(String fileID, int pageSize) throws
      Exception;

  //�����ļ�FileID��ѯ�ļ���Ϣ
  public ArchivesFile getArchivesFileByFileID(String fileID) throws Exception;

  //������Ŀ�������ҵ�������Ŀ�׶κ��ļ��б�֣��ȫ��
  public List queryTopArchivesProjPhaseList(Archives archives);

  //������Ŀ�������ҵ����˶�����Ŀ�׶����������Ŀ�׶κ��ļ��б�֣��ȫ��
  public List queryOtherArchivesProjPhaseList(ArchivesFile archivesFile);

  //������Ŀ�ҵ����ж�����Ŀ�׶κ��ļ��б�֣��ȫ��
  public List queryAllTopProjPhaseList(Archives archives);

  //������Ŀ�ҵ����˶�����Ŀ�׶����s����������Ŀ�׶κ��ļ��б�֣��ȫ��
  public List queryAllOtherProjPhaseList(ArchivesFile archivesFile);

  //�����ļ���Ϣ(�޵��ӱ���Ϣ)
  public int updateArchivesFile(ArchivesFile archivesFile);

  //�����ļ���Ϣ(�е��ӱ���Ϣ)
  public int updateArchivesFile(ArchivesFile archivesFile,List eformFieldValueList);

  //ȡ�ý��յ��ļ��б�
  public PaginatedList getReceivedArchivesFiles(ArchivesFile archivesFile) throws Exception;
  public PaginatedList getReceivedArchivesFiles(ArchivesFile archivesFile,int pageSize) throws Exception;

  //ѡ���ѽ��յ��ļ�
  public int updateReceivedArchivesFiles(List archivesFileList);

  //�г�����ĳ���׶ε������ļ�
  public PaginatedList queryArchivesFileByPhaseID(ArchivesFile archivesFile);
  public PaginatedList queryArchivesFileByPhaseID(ArchivesFile archivesFile,int pageSize);
 public PaginatedList queryArchivesFileJianByArchivesID(String archivesID) throws Exception ;
 //��ѯ�����б� hukp add
 public List queryArchivesJianByID(Map projIdMap);

 //����fileID�����Ƿ����ı�־λ,wanghua add,2004-03-15
 public int updateBorrowStatusByFileID(Map fileIDMap);

 //��ѯ�ļ��б�
  public PaginatedList queryArchivesFile(ArchivesFile archivesFile) throws Exception;
  public PaginatedList queryArchivesFile(ArchivesFile archivesFile, int pageSize) throws Exception;

}