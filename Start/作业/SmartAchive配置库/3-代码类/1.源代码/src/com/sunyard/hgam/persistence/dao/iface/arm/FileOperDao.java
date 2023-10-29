package com.sunyard.hgam.persistence.dao.iface.arm;

import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.beans.arm.Identify;
import com.sunyard.hgam.persistence.dao.beans.arm.Destroy;
import com.sunyard.hgam.persistence.dao.beans.arm.FileOper;

/**
 * <p>Title: 档案信息管理－文件部分</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 叶昊
 * @version 1.0
 */

public interface FileOperDao {
  public PaginatedList getFiles(String archiveId);
  public PaginatedList getFiles(String archiveId,int pageSize);
  public PaginatedList queryFiles(FileOper fileOper);
  public PaginatedList queryFiles(FileOper fileOper,int pageSize);
  public PaginatedList getIdentFiles(String archiveId);
  public PaginatedList getIdentFiles(String archiveId,int pageSize);
  public int updateIdentFile(Identify identify);
  public PaginatedList getDestroyFiles(String archiveId);
  public PaginatedList getDestroyFiles(String archiveId,int pageSize);
  public int updateDestroyFile(Destroy destroy);
}