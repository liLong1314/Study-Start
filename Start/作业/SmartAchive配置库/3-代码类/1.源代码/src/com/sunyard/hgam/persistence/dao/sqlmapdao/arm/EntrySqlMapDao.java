package com.sunyard.hgam.persistence.dao.sqlmapdao.arm;

import com.sunyard.hgam.persistence.dao.base.BaseSqlMapDao;
import com.sunyard.hgam.persistence.dao.iface.arm.EntryDao;
import com.ibatis.common.util.PaginatedList;
import com.ibatis.db.dao.DaoException;
import com.sunyard.hgam.persistence.dao.beans.arm.Entry;
import java.util.List;

/**
 * <p>Title: 类目管理</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 叶昊
 * @version 1.0
 */

public class EntrySqlMapDao
    extends BaseSqlMapDao
    implements EntryDao {


//得到所有一级类目
  public List getFirstEntry() {
    List list = null;
    try {
      this.startTransation();
      list = this.executeQueryForList("getFirstEntry", null);
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

//得到所有二级类目
  public List getSecondEntry(String entryId) {
    List list = null;
    try {
      this.startTransation();
      list = this.executeQueryForList("getSecondEntry", entryId);
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

  //根据ID得到一条类目
  public Entry getEntry(String entryID) {
    Entry entryInfo = null;
    try {
      this.startTransation();
      entryInfo = (Entry)this.executeQueryForObject("getEntryByID", entryID);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    return entryInfo;
  }

  //增加类目
  public int addEntry(Entry entry) {
    int result = 0;
    try {
      this.startTransation();
      result = this.executeUpdate("addEntry", entry);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) {/* ignore */}
      ex.printStackTrace();
    }
    return result;
  }

  //修改类目
  public int modifyEntry(Entry entry) {
    int result = 0;
    try {
      this.startTransation();
      result = this.executeUpdate("updateEntry", entry);
      if(entry.getEntryLevel().equals("1")){
        result = this.executeUpdate("updateEntrySecondOpt", entry);
      }
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

  //删除类目
  public int delEntry(String entryId) {
    int result = 0;
    try {
      this.startTransation();
      result = this.executeUpdate("deleteEntryByID", entryId);
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

  //删除类目
  public int delEntryForFirstLvl(String entryId) {
    int result = 0;
    try {
      this.startTransation();
      result = this.executeUpdate("delEntryByFatherId", entryId);
      result = this.executeUpdate("deleteEntryByID", entryId);
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


  public int updateEntryIsCharge(Entry e) throws Exception {
    int nRet = 0;
    try {
      this.startTransation();
      nRet = this.executeUpdate("updateEntryIsCharge", e);
      this.commitTransation();
    }
    catch (Exception ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      throw ex;
    }
    return nRet;
  }

  public List queryAllSecondEntry() throws Exception {
    List list = null;
    try {
      this.startTransation();
      list = this.executeQueryForList("queryAllSecondEntry", null);
      this.commitTransation();
    }
    catch (Exception ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      throw ex;
    }
    return list;
  }

  public List queryChargeStandardSEntry(String sentryid) throws Exception {
    List list = null;
    try {
      this.startTransation();
      list = this.executeQueryForList("queryChargeStandardSEntry", sentryid);
      this.commitTransation();
    }
    catch (Exception ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      throw ex;
    }
    return list;
  }
  public List querySecondEntryForEformDefine() {
    List list = null;
    try {
      this.startTransation();
      list = this.executeQueryForList("querySecondEntryForEformDefine", null);
      this.commitTransation();
    }
    catch (Exception ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return list;
  }

}