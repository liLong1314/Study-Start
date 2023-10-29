package com.sunyard.hgam.persistence.dao.iface.arm;

import com.sunyard.hgam.persistence.dao.beans.arm.Identify;
import com.ibatis.common.util.PaginatedList;

/**
 * <p>Title: 鉴定管理</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 叶昊
 * @version 1.0
 */

public interface IdentifyDao {
  public PaginatedList getAllIdentify();
  public PaginatedList getAllIdentify(int pageSize);
  public int addIdentify(Identify identify);
  public PaginatedList queryIdentifyList(Identify identify,int pageSize);
  public PaginatedList queryIdentifyList(Identify identify);
}