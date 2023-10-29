package com.sunyard.hgam.persistence.dao.sqlmapdao.aum;

import com.sunyard.hgam.persistence.dao.base.BaseSqlMapDao;
import com.ibatis.db.dao.DaoException;
import java.util.HashMap;
import com.sunyard.hgam.persistence.dao.iface.aum.*;
import java.util.List;
/**
 * <p>Title: 档案利用管理</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 曹峰
 * @version 1.0
 */
public class ArchivesSqlMapDao extends BaseSqlMapDao implements ArchivesDao {
  public List getAllArchivesByApplyID(String applyID) {
    List list = null;
    try {
      this.startTransation();
      list = this.executeQueryForList("getArchivesByApplyID", applyID);
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