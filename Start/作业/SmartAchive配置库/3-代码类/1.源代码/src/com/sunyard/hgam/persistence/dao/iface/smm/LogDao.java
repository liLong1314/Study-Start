package com.sunyard.hgam.persistence.dao.iface.smm;

import com.ibatis.common.util.PaginatedList;
import com.ibatis.db.dao.*;
import com.sunyard.hgam.persistence.dao.beans.smm.*;
import java.util.*;

/**
 * <p>Title: Hang Zhou Net Archives</p>
 * <p>Description: 杭州市网上档案馆建设（一期）</p>
 * <p>Copyright: Hangzhou Sunyard System Engineering， Ltd. All rights reserved @2003</p>
 * <p>Company: sunhoo.com</p>
 * @author not attributable
 * @version 1.00
 */

public interface LogDao {

  /**
   * 分页返回所有日志，默认页大小
   * @return 日志列表
   */
  public PaginatedList getAllLog();

  /**
   * 根据日志ID获取日志信息
   * @param logID 日志ID
   * @return 日志信息Bean
   */
  public Log getLogByID(String logID);

  public int insertLog(Log log);

  public int deleteLog(String logId);

  public List getAllOperationUrl();

  public int updateOperationUrl(OperationUrl operationUrl);

}