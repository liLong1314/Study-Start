package com.sunyard.hgam.persistence.dao.sqlmapdao.smm;

import com.sunyard.hgam.persistence.dao.base.BaseSqlMapDao;
import com.ibatis.common.util.PaginatedList;
import com.ibatis.db.dao.*;
import com.sunyard.hgam.persistence.dao.beans.smm.*;
import java.util.*;
import com.sunyard.hgam.persistence.dao.iface.smm.*;

/**
 * <p>Title: Hang Zhou Net Archives</p>
 * <p>Description: 杭州市网上档案馆建设（一期）</p>
 * <p>Copyright: Hangzhou Sunyard System Engineering， Ltd. All rights reserved @2003</p>
 * <p>Company: sunhoo.com</p>
 * @author not attributable
 * @version 1.00
 */

public class LogSqlMapDao
    extends BaseSqlMapDao
    implements LogDao {

  /**
   * 分页返回所有日志，默认页大小
   * @return 日志列表
   */
  public PaginatedList getAllLog() {
    return getAllLog(this.PAGE_SIZE);
  }

  /**
   * 分页返回所有日志
   * @param pageSize 页大小
   * @return 日志列表
   */
  public PaginatedList getAllLog(int pageSize) {
    PaginatedList list = null;
    try {
      this.startTransation();

      list = this.executeQueryForPaginatedList("getAllLog", null, pageSize);

      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) {
        /* ignore */}
      ex.printStackTrace();
    }
    return list;
  }

  /**
   * 根据日志ID获取日志信息
   * @param logID 日志ID
   * @return 日志信息Bean
   */
  public Log getLogByID(String logID) {
    Log log = null;
    try {
      this.startTransation();

      log = (Log) this.executeQueryForObject("getLogByID", logID);

      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) {
        /* ignore */}
      ex.printStackTrace();
    }
    return log;
  }

  public int insertLog(Log log) {
    int result = 0;
    try {
      this.startTransation();

      result = this.executeUpdate("insertLog", log);

      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) {
        /* ignore */}
      ex.printStackTrace();
    }

    return result;
  }

  public int deleteLog(String logId) {
    int result = 0;
    try {
      this.startTransation();

      result = this.executeUpdate("deleteLog", logId);

      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) {
        /* ignore */}
      ex.printStackTrace();
    }

    return result;
  }

  public List getAllOperationUrl() {
    List list = null;
    try {
      this.startTransation();

      list = this.executeQueryForList("getAllOperationUrl", null);

      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) {
        /* ignore */}
      ex.printStackTrace();
    }
    return list;
  }

  public int updateOperationUrl(OperationUrl operationUrl) {
    int result = 0;
    try {
      this.startTransation();

      result = this.executeUpdate("updateOperationUrl", operationUrl);

      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) {
        /* ignore */}
      ex.printStackTrace();
    }

    return result;
  }
}