package com.sunyard.hgam.persistence.dao.iface.arm;

import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.beans.arm.SubRollCatalog;

/**
 * <p>Title: 分局目录管理</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 华良东
 * @version 1.0
 */

public interface SubRollCatalogDao {
 public PaginatedList getAllSubRollCatalog();
 public PaginatedList getAllSubRollCatalog(int pageSize);
 public  SubRollCatalog  getSubRollCatalog(SubRollCatalog rollCataId);
 public int addSubRollCatalog(SubRollCatalog subRollCatalog);
  public PaginatedList querySubRollCatalogList(SubRollCatalog subRollCatalog);
  public PaginatedList querySubRollCatalogList(SubRollCatalog subRollCatalog,int pageSize);
}