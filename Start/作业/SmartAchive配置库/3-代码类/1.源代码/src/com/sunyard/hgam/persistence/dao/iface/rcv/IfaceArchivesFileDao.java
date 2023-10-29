package com.sunyard.hgam.persistence.dao.iface.rcv;

import java.util.List;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.beans.adc.ArchivesFile;

public interface IfaceArchivesFileDao {
  //���ݲ�ѯ�����������ļ��б�(Ĭ��)
  public PaginatedList queryIfaceArchivesFileList(ArchivesFile ifaceFile);
  //���ݲ�ѯ�����������ļ��б�(����ÿҳ��¼��)
  public PaginatedList queryIfaceArchivesFileList(ArchivesFile ifaceFile,int pageSize);
  //����file_id��ȡ�ýӿڿ��ļ���Ϣ
  public ArchivesFile getIfaceArchivesFileByFileId(String fileId);
  //����file_id��ȡ�ýӿڿ��ļ������ڵ�����Ӱ��ҳ�б�
  public List getIfaceArchivesPageByFileID(String fileId);
  //����file_id,ȡ�õ��ӱ��ֶζ��弰���ֶ�ֵ
  public List getIfaceEformFieldValueInfoByFileId(String fileId);
  //����ӿڿ�ĵ��ӱ�
  public int insertAllEformFromOA();
  //���񻯽��սӿڵ����ļ���¼��Ϣ���ļ�������Ӱ��ҳ��¼��Ϣ��Ӱ��ҳ�ļ���Ԫ���ݣ��޵��ӱ���
  public int receiveIfaceInfoInTrans(ArchivesFile archivesFile,String ifaceFileId,
                                     List archivesPageList, List fileUrlList,
                                     List metadataList) throws java.lang.Exception;

  //���񻯽��սӿڵ����ļ���¼��Ϣ���ļ�������Ӱ��ҳ��¼��Ϣ��Ӱ��ҳ�ļ���Ԫ���ݣ��е��ӱ���
  public int receiveIfaceInfoInTrans(ArchivesFile archivesFile,String ifaceFileId,
                                     List archivesPageList, List fileUrlList,
                                     List metadataList,
                                     List eformFieldValueList) throws java.lang.Exception;

  //���½ӿڿ��ļ�״̬Ϊ���ѽ��ա�
  public int updateIfaceArchivesFileStatusToReceivedByFileId(String fileId);
  //���½ӿڿ��ļ�״̬Ϊ�����˻ء�
  public int updateIfaceArchivesFileStatusToBackByFileIds(String fileIds);

}
