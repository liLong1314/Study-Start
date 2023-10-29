package com.sunyard.hgam.persistence.dao.iface.arm;

import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.beans.arm.PageOper;

/**
 * <p>Title: 档案信息管理-页面部分</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 叶昊
 * @version 1.0
 */

public interface PageOperDao {
  public PaginatedList getPages(String fileId);
  public PaginatedList getPages(String fileId,int pageSize);
  public PaginatedList queryPages(PageOper pageOper);
  public PaginatedList queryPages(PageOper pageOper,int pageSize);
  public PageOper getPage(String pageID);
}