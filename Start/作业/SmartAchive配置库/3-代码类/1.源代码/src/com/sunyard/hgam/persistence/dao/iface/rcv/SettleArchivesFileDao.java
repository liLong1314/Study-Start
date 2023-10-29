package com.sunyard.hgam.persistence.dao.iface.rcv;

import com.sunyard.hgam.persistence.dao.beans.adc.ArchivesFile;
import com.ibatis.common.util.PaginatedList;

public interface SettleArchivesFileDao {
  //根据查询条件，返回文件列表(默认)
  public PaginatedList querySettleArchivesFileList(ArchivesFile archivesFile);
  //根据查询条件，返回文件列表(定制每页记录数)
  public PaginatedList querySettleArchivesFileList(ArchivesFile archivesFile,int pageSize);

}