package com.sunyard.hgam.persistence.dao.sqlmapdao.arm;

import com.sunyard.hgam.persistence.dao.base.BaseSqlMapDao;
import com.sunyard.hgam.persistence.dao.iface.arm.WholeDao;
import com.ibatis.common.util.PaginatedList;
import com.ibatis.db.dao.DaoException;
import com.sunyard.hgam.persistence.dao.beans.arm.Whole;
import java.util.List;

/**
 * <p>Title: 全宗卷信息管理</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 叶昊
 * @version 1.0
 */

public class WholeSqlMapDao
    extends BaseSqlMapDao
    implements WholeDao {
  //根据类型得到全宗卷信息列表
  public List getWholeByType(String wholetype) {
    List list = null;
    try {
      this.startTransation();
      list = this.executeQueryForList("getWholeByType", wholetype);
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

  //根据ID得到一条全宗卷信息
  public Whole getWhole(String wholeID) {
    Whole wholeInfo = null;
    try {
      this.startTransation();
      wholeInfo = (Whole)this.executeQueryForObject("getWholeByID", wholeID);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    return wholeInfo;
  }

  //增加全宗卷信息
  public int addWhole(Whole whole) {
    int result = 0;
    try {
      this.startTransation();
      result = this.executeUpdate("addWhole", whole);
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

  //修改全宗卷信息
  public int modifyWhole(Whole whole) {
    int result = 0;
    try {
      this.startTransation();
      result = this.executeUpdate("updateWhole", whole);
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

  //删除全宗卷信息
  public int delWhole(String wholeId) {
    int result = 0;
    try {
      this.startTransation();
      result = this.executeUpdate("deleteWholeByID", wholeId);
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