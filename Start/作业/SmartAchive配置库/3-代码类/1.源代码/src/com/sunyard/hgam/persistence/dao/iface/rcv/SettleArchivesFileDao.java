package com.sunyard.hgam.persistence.dao.iface.rcv;

import com.sunyard.hgam.persistence.dao.beans.adc.ArchivesFile;
import com.ibatis.common.util.PaginatedList;

public interface SettleArchivesFileDao {
  //���ݲ�ѯ�����������ļ��б�(Ĭ��)
  public PaginatedList querySettleArchivesFileList(ArchivesFile archivesFile);
  //���ݲ�ѯ�����������ļ��б�(����ÿҳ��¼��)
  public PaginatedList querySettleArchivesFileList(ArchivesFile archivesFile,int pageSize);

}