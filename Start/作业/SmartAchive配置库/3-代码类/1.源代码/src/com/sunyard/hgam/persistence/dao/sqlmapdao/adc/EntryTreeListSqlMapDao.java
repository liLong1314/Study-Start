package com.sunyard.hgam.persistence.dao.sqlmapdao.adc;

import com.sunyard.hgam.persistence.dao.base.BaseSqlMapDao;
import java.util.List;
import com.sunyard.hgam.persistence.dao.iface.adc.EntryTreeListDao;
import com.ibatis.db.dao.DaoException;

/**
 * <p>Title: HGAM</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 郑先全
 * @version 1.0
 */

public class EntryTreeListSqlMapDao extends BaseSqlMapDao implements EntryTreeListDao {
  //得到第一级别的类目列表
  public List getAllFirstLevelTree() {
    List list = null;
    try {
      this.startTransation();
      list = this.executeQueryForList("getAllFirstLevelTree", null);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return list;
  }

  //得到第一级别的类目列表(案卷)
  public List getFirstLevelTreeForRoll(){
    List list = null;
    try {
      this.startTransation();
      list = this.executeQueryForList("getFirstLevelTreeForRoll", null);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return list;

  }


  //得到第一级别的类目列表(件)
  public List getFirstLevelTreeForPiece(){
    List list = null;
    try {
      this.startTransation();
      list = this.executeQueryForList("getFirstLevelTreeForPiece", null);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return list;

  }

  //根据父节点找到隶属的类目列表
  public List getSecondLevelTreeByFatherId(Integer entryId) {
    List list = null;
    try {
      this.startTransation();
      list = this.executeQueryForList("getSecondLevelTreeByFatherId", entryId);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return list;
  }

  //根据父节点找到隶属的类目列表
  public List getSecondLevelTreeByFatherIdForPiece(Integer entryId){
    List list = null;
    try {
      this.startTransation();
      list = this.executeQueryForList("getSecondLevelTreeByFatherIdForPiece", entryId);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return list;

  }
}