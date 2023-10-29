package com.sunyard.hgam.persistence.dao.iface.smm;

import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.beans.smm.Theme;
/**
 * <p>Title: 主题词管理</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 华良东
 * @version 1.0
 */
public interface ThemeDao {

  public PaginatedList getAllTheme();
  public PaginatedList getAllTheme(int pageSize);
  public PaginatedList searchTheme(Theme theme);
  public int addTheme(Theme theme);
  public int delTheme(String themeId);
  public int modifyTheme(Theme theme);
  public Theme getTheme(String themeID);

}
