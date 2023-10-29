package com.sunyard.hgam.persistence.dao.iface.arm;

import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.beans.arm.Destroy;

/**
 * <p>Title: 销毁管理</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 叶昊
 * @version 1.0
 */

public interface DestroyDao {
  public PaginatedList getAllDestroy();
  public PaginatedList getAllDestroy(int pageSize);
  public int addDestory(Destroy destroy);
  public PaginatedList queryDestroyList(Destroy destroy);
  public PaginatedList queryDestroyList(Destroy destroy,int pageSize);
}