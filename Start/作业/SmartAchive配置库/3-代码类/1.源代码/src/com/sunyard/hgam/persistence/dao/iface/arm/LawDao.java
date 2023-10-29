package com.sunyard.hgam.persistence.dao.iface.arm;

import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.beans.arm.Law;

/**
 * <p>Title: 法律法规管理</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 叶昊
 * @version 1.0
 */

public interface LawDao {
  public PaginatedList getAllLaw();
  public PaginatedList getAllLaw(int pageSize);
  public PaginatedList searchLaw(Law law);
  public PaginatedList searchLaw(Law law,int pageSize);
  public Law getLaw(String lawID);
  public int addLaw(Law law);
  public int modifyLaw(Law law);
  public int delLaw(String lawId);

}