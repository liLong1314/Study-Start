package com.sunyard.hgam.persistence.dao.sqlmapdao.aum;

import com.sunyard.hgam.persistence.dao.base.BaseSqlMapDao;
import com.ibatis.common.util.PaginatedList;
import com.ibatis.db.dao.DaoException;
import java.util.*;
import com.sunyard.hgam.persistence.dao.iface.aum.*;
import com.sunyard.hgam.persistence.dao.beans.aum.*;

/**
 * <p>Title: 档案利用管理</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 曹峰
 * @version 1.0
 */
public class ConfirmInfoSqlMapDao extends BaseSqlMapDao implements ConfirmInfoDao{

  public int addConfirmInfo(ConfirmInfo cInfo) {
    int result = 0;
    try {
      this.startTransation();
      result = this.executeUpdate("insertConfirmInfo", cInfo);
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

  public List getConfirmInfoByApplyID(String applyID) {
    List list = null;
    try {
      this.startTransation();
      list = this.executeQueryForList("getConfirmInfoByApplyID", applyID);
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

  public List getConfirmInfoByTaskID(String taskID) {
    List list = null;
    try {
      this.startTransation();
      list = this.executeQueryForList("getConfirmInfoByTaskID", taskID);
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

}