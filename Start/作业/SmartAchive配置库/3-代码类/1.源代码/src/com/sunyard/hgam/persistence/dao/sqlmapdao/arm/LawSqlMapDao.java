package com.sunyard.hgam.persistence.dao.sqlmapdao.arm;

import com.sunyard.hgam.persistence.dao.base.BaseSqlMapDao;
import com.sunyard.hgam.persistence.dao.iface.arm.LawDao;
import com.ibatis.common.util.PaginatedList;
import com.ibatis.db.dao.DaoException;
import com.sunyard.hgam.persistence.dao.beans.arm.Law;

/**
 * <p>Title: 法律法规管理</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 叶昊
 * @version 1.0
 */

public class LawSqlMapDao
    extends BaseSqlMapDao
    implements LawDao{

  //得到所有法律法规记录
  public PaginatedList getAllLaw() {
    return getAllLaw(this.PAGE_SIZE);
  }

  public PaginatedList getAllLaw(int pageSize) {
    PaginatedList list = null;
    try {
      this.startTransation();
      list = this.executeQueryForPaginatedList("getAllLaw", null, pageSize);
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

  //查询法律法规记录
  public PaginatedList searchLaw(Law law) {
    return searchLaw(law,this.PAGE_SIZE);
  }

  public PaginatedList searchLaw(Law law,int pageSize) {
    PaginatedList list = null;
    try {
      this.startTransation();
      list = this.executeQueryForPaginatedList("searchLaw", law, pageSize);
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

  //根据ID得到一条法律法规记录
  public Law getLaw(String lawID) {
    Law LawInfo = null;
    try {
      this.startTransation();
      LawInfo = (Law)this.executeQueryForObject("getLawByID", lawID);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    return LawInfo;
  }

  //增加法律法规
  public int addLaw(Law law) {
    int result = 0;
    try {
      this.startTransation();
      result = this.executeUpdate("addLaw", law);
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

  //修改法律法规
  public int modifyLaw(Law law) {
    int result = 0;
    try {
      this.startTransation();
      result = this.executeUpdate("updateLaw", law);
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

  //删除法律法规
  public int delLaw(String lawId) {
    int result = 0;
    try {
      this.startTransation();
      result = this.executeUpdate("deleteLawByID", lawId);
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