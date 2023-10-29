package com.sunyard.hgam.persistence.dao.sqlmapdao.aum;

import com.sunyard.hgam.persistence.dao.base.BaseSqlMapDao;
import com.sunyard.hgam.persistence.dao.beans.aum.*;
import java.util.*;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.iface.aum.UtilizeDetailDao;
import com.ibatis.db.dao.DaoException;
import com.sunyard.rdc.flowdriver.ShareFunc;
import com.sunyard.hgam.persistence.dao.iface.aum.UtilizeInfoDao;
import com.sunyard.hgam.domain.logic.DomainLogic;

/**
 * <p>Title: HGAM</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author not attributable
 * @version 1.0
 */

public class UtilizeDetailSqlMapDao
    extends BaseSqlMapDao
    implements UtilizeDetailDao {

  public int insert(UtilizeDetail ud) throws Exception {
    int n;
    try {
      this.startTransation();
      n = this.executeUpdate("insertUD", ud);
      this.commitTransation();
    }
    catch (Exception e) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      throw e;
    }
    return n;
  }

  public int deleteByApplyID(String apply_id) throws Exception {
    int n;
    try {
      this.startTransation();
      n = this.executeUpdate("deleteByApplyID", apply_id);
      this.commitTransation();
    }
    catch (Exception e) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      throw e;
    }
    return n;
  }

  public int deleteByFileID(String file_id) throws Exception {
    int n;
    try {
      this.startTransation();
      n = this.executeUpdate("deleteByFileID", file_id);
      this.commitTransation();
    }
    catch (Exception e) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      throw e;
    }
    return n;
  }

  public int deleteByPageID(String page_id) throws Exception {
    int n;
    try {
      this.startTransation();
      n = this.executeUpdate("deleteByPageID", page_id);
      this.commitTransation();
    }
    catch (Exception e) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      throw e;
    }
    return n;
  }

  public PaginatedList queryUtilizeDetailByApplyID(Map applyIDMap) throws
      Exception {
    PaginatedList list = null;
    try {
      this.startTransation();
      list = this.executeQueryForPaginatedList("queryUtilizeDetailByApplyID",
                                               applyIDMap, this.PAGE_SIZE);
      this.commitTransation();
    }
    catch (Exception e) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      throw e;
    }
    return list;
  }

  /******************************************************
   * 功能: 查询出入库信息
   * @date  2004-03-14 wanghua added
   ******************************************************/
  public List queryUtilizeDetailByCondition(Map conditionMap) throws
      Exception {

    List list = null;
    try {
      this.startTransation();
      list = this.executeQueryForList("queryUtilizeDetailByCondition",
                                      conditionMap);
      this.commitTransation();
    }
    catch (Exception e) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      throw e;
    }
    return list;
  }

  public PaginatedList queryFileIDByApplyID(String apply_id) throws Exception {
    PaginatedList list = null;
    try {
      this.startTransation();
      list = this.executeQueryForPaginatedList("queryFileIDByApplyID", apply_id,
                                               1000);
      this.commitTransation();
    }
    catch (Exception e) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      throw e;
    }
    return list;
  }

  public List queryPageChargeByFileID(String file_id) throws Exception {
    List list = null;
    try {
      this.startTransation();
      list = this.executeQueryForList("queryPageChargeByFileID", file_id);
      this.commitTransation();
    }
    catch (Exception e) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      throw e;
    }
    return list;
  }

  public UtilizeDetail getUtilizeDetailByPageID(String pageID) throws Exception {

    UtilizeDetail uDetail = null;
    try {
      this.startTransation();
      uDetail = (UtilizeDetail)this.executeQueryForObject(
          "queryPageChargeByPageID", pageID);
      this.commitTransation();
    }
    catch (Exception ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      throw ex;
    }
    return uDetail;

  }

  /******************************************************
   * 功能: 获得某次利用ID得到应收金额
   * @date  2004-02-16 wanghua added
   ******************************************************/
  public long getTotalChargeByApplyID(String applyID) throws Exception {

    long totalCharge = 0;
    PaginatedList list = null;

    try {
      this.startTransation();
      Map applyIDMap = new HashMap();
      applyIDMap.put("applyID", applyID);
      list = this.executeQueryForPaginatedList("queryUtilizeDetailByApplyID",
                                               applyIDMap, this.PAGE_SIZE);
      UtilizeDetail uDetail = null;
      for (int i = 0; i < list.size(); i++) {
        uDetail = new UtilizeDetail();
        uDetail = (UtilizeDetail) list.get(i);
        totalCharge += Long.parseLong(uDetail.getCharge_money());
      }
      this.commitTransation();
    }
    catch (Exception ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
      throw new Exception(ex);
    }
    return totalCharge;
  }

  /******************************************************
   * 功能: 获得某次利用的所有超期档案信息
   * @date  2004-02-18 wanghua added
   ******************************************************/
  public List queryOverdueArchByApplyID(String applyID) throws Exception {
    List list = null;
    try {
      this.startTransation();
      list = this.executeQueryForList("queryOverdueArchByApplyID", applyID);
      this.commitTransation();
    }
    catch (Exception e) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      throw e;
    }
    return list;
  }

  public int insertUrgeInfoForOA(UrgeInfoForOA urgeInfoForOA) throws Exception {
    int n;
    try {
      this.startTransation();
      n = this.executeUpdate("insertUrgeInfoForOA", urgeInfoForOA);
      this.commitTransation();
    }
    catch (Exception e) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      throw e;
    }
    return n;
  }

  public int updateUrgeStatusForOA(Map hm) throws Exception {
    int result = 0;
    try {
      this.startTransation();
      result = this.executeUpdate("updateUrgeStatusForOA", hm);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception e) { /* ignore */}
      throw ex;
    }
    return result;
  }

}