package com.sunyard.hgam.persistence.dao.sqlmapdao.arm;

import com.sunyard.hgam.persistence.dao.base.BaseSqlMapDao;
import com.sunyard.hgam.persistence.dao.iface.arm.PageOperDao;
import com.ibatis.common.util.PaginatedList;
import com.ibatis.db.dao.DaoException;
import com.sunyard.hgam.persistence.dao.beans.arm.PageOper;

/**
 * <p>Title: 档案信息管理-页面部分</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 叶昊
 * @version 1.0
 */

public class PageOperSqlMapDao
    extends BaseSqlMapDao
    implements PageOperDao {
  //根据文件ID得到页面列表
  public PaginatedList getPages(String fileId) {
    return getPages(fileId,this.PAGE_SIZE);
  }

  public PaginatedList getPages(String fileId,int pageSize) {
    PaginatedList list = null;
    try {
      this.startTransation();
      list = this.executeQueryForPaginatedList("getPages", fileId, pageSize);
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

  //查询页面－档案利用子系统
  public PaginatedList queryPages(PageOper pageOper) {
    return queryPages(pageOper,this.PAGE_SIZE);
  }

  public PaginatedList queryPages(PageOper pageOper,int pageSize) {
    PaginatedList list = null;
    try {
      this.startTransation();
      list = this.executeQueryForPaginatedList("queryPages", pageOper, pageSize);
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

  //根据ID得到一条影像记录
  public PageOper getPage(String pageID) {
    PageOper pageOperInfo = null;
    try {
      this.startTransation();
      pageOperInfo = (PageOper)this.executeQueryForObject("getPageByID", pageID);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    return pageOperInfo;
  }

}