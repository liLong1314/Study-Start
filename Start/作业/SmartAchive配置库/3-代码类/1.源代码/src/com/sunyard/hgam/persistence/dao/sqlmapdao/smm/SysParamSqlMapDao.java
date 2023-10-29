package com.sunyard.hgam.persistence.dao.sqlmapdao.smm;

import com.sunyard.hgam.persistence.dao.base.BaseSqlMapDao;
import com.ibatis.common.util.PaginatedList;
import com.ibatis.db.dao.DaoException;
import com.sunyard.hgam.persistence.dao.beans.smm.SysParam;
import com.sunyard.hgam.persistence.dao.iface.smm.SysParamDao;
import java.util.*;

/**
 * <p>Title:参数管理</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 华良东
 * @version 1.0
 */

public class SysParamSqlMapDao
    extends BaseSqlMapDao
    implements SysParamDao {
  public List getSysParamList() {
    List list = null;
    try {
      this.startTransation();
      list = this.executeQueryForList("getAllSysParam", null);
      this.commitTransation();
    }

    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    return list;
  }

  public PaginatedList getAllSysParam() {
    return getAllSysParam(this.PAGE_SIZE);
  }

  public PaginatedList getAllSysParam(int pageSize) {
    PaginatedList list = null;
    try {
      this.startTransation();
      list = this.executeQueryForPaginatedList("getAllSysParam", null, pageSize);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    return list;
  }

  public PaginatedList searchSysParam(SysParam sysParam) {
    return searchSysParam(sysParam, this.PAGE_SIZE);
  }

  public PaginatedList searchSysParam(SysParam sysParam, int pageSize) {
    PaginatedList list = null;
    try {
      this.startTransation();
      list = this.executeQueryForPaginatedList("searchSysParam", sysParam, pageSize);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    return list;
  }

  //根据ID得到一条参数
  public SysParam getSysParam(String sysParamID) {
    SysParam sysParamInfo = null;
    try {
      this.startTransation();
      sysParamInfo = (SysParam)this.executeQueryForObject("getSysParamByID",
          sysParamID);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    return sysParamInfo;
  }

  //根据类型和值得到一条参数
  public SysParam getSysParamByTypeAndValue(String sysParamType, String sysParamValue) {
    SysParam sysParamInfo = null;
    try {
      this.startTransation();
      HashMap paramters = new HashMap();
      paramters.put("sysParamType",sysParamType);
      paramters.put("sysParamValue",sysParamValue);
      sysParamInfo = (SysParam)this.executeQueryForObject("getSysParamByTypeAndValue",
          paramters);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    return sysParamInfo;
  }

  //根据类型得到参数列表
  public List getSysParamByType(String type) {
    List list = null;
    try {
      this.startTransation();
      list = this.executeQueryForList("getSysParamByType", type);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    return list;
  }

  //增加参数
  public int addSysParam(SysParam sysParam) {
    int result = 0;
    try {
      this.startTransation();
      result = this.executeUpdate("addSysParam", sysParam);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    return result;

  }

//删除参数
  public int delSysParam(String sysParamId) {
    int result = 0;
    try {
      this.startTransation();
      result = this.executeUpdate("deleteSysParamByID", sysParamId);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    return result;
  }

//修改参数
  public int modifySysParam(SysParam sysParam) {
    int result = 0;
    try {
      this.startTransation();
      result = this.executeUpdate("updateSysParam", sysParam);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    return result;
  }
}