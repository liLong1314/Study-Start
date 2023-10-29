package com.sunyard.hgam.persistence.dao.iface.smm;

import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.beans.smm.SysParam;
import java.util.*;

/**
 * <p>Title: 参数管理</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 华良东
 * @version 1.0
 */

public interface SysParamDao {
  public List getSysParamList();
  public PaginatedList getAllSysParam();
  public PaginatedList getAllSysParam(int pageSize);
  public PaginatedList searchSysParam(SysParam sysParam);
  public SysParam getSysParam(String sysParamId);
  public SysParam getSysParamByTypeAndValue(String sysParamType, String sysParamValue);
  public List getSysParamByType(String type);
  public int addSysParam(SysParam sysParam);
  public int delSysParam(String sysParamId);
  public int modifySysParam(SysParam sysParam);

}