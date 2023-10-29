package com.sunyard.hgam.persistence.dao.iface.arm;

import com.sunyard.hgam.persistence.dao.beans.arm.ArchOper;
import com.ibatis.common.util.PaginatedList;
import java.util.List;
import java.util.Map;

/**
 * <p>Title: 档案资源管理－案卷部分</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 叶昊
 * @version 1.0
 */

public interface ArchOperDao {
  public int breakArchive(String archiveId);
  public PaginatedList getArchOper(String entryId);
  public PaginatedList getArchOper(String entryId,int pageSize);
  public PaginatedList queryArchive(ArchOper archOper);
  public PaginatedList queryArchive(ArchOper archOper,int pageSize);
  public PaginatedList queryArchiveDest(ArchOper archOper,int pageSize);
  public PaginatedList queryOperArchive(ArchOper archOper);
  public PaginatedList queryOperArchive(ArchOper archOper,int pageSize);
  public PaginatedList queryblurArchive(ArchOper archOper);
  public PaginatedList queryblurArchive(ArchOper archOper,int pageSize);
  public PaginatedList searchArchive(ArchOper archOper);
  public PaginatedList searchArchive(ArchOper archOper,int pageSize);
  public ArchOper getOneArchive(String archiveID);
  public int addChangedArchive(ArchOper archOper);
  public PaginatedList getChangedArchives(String archiveId);
  public PaginatedList getChangedArchives(String archiveId,int pageSize);
  //ADD BY ZHENGXQ
  public PaginatedList queryArchiveX(ArchOper archOper);
  public PaginatedList queryArchiveX(ArchOper archOper,int pageSize);
  public PaginatedList queryblurArchiveX(ArchOper archOper);
  public PaginatedList queryblurArchiveX(ArchOper archOper,int pageSize);
  public PaginatedList queryOperArchiveX(ArchOper archOper);
  public PaginatedList queryOperArchiveX(ArchOper archOper,int pageSize);

  public PaginatedList getArchivesDescByEntryID(String entryId);
  public PaginatedList getArchivesDescByEntryID(String entryId,int pageSize);
  public PaginatedList searchArchiveDest(ArchOper archOper);
  public PaginatedList searchArchiveDest(ArchOper archOper,int pageSize);




}