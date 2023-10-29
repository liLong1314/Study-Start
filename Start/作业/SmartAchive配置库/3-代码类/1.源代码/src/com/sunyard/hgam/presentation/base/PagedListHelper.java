package com.sunyard.hgam.presentation.base;

import com.ibatis.common.util.PaginatedList;

/**
 * <p>Title: Hang Zhou Net Archives</p>
 * <p>Description: 杭州市网上档案馆建设（一期）</p>
 * <p>Copyright: Hangzhou Sunyard System Engineering， Ltd. All rights reserved @2003</p>
 * <p>Company: </p>
 * @Date        Author      Changes
 * Nov 11,2003   yujx        created
 * @version 0.01
 */

public class PagedListHelper {

  /**
   * 页面跳转控制方法
   * @param paginatedList 存放Bean的列表
   * @param page 要跳转的目标,可以是["first","previous","next","last"],也可以是数字字符串
   */
  public static void pageTo(PaginatedList paginatedList, String page) {
    if (paginatedList == null) {
      return;
    }
    if (page == null || page.length() < 1) {
      return;
    }
    if ("next".equals(page)) {
      paginatedList.nextPage();
    }
    else if ("previous".equals(page)) {
      paginatedList.previousPage();
    }
    else if ("first".equals(page)) {
      paginatedList.firsPage();
    }
    else if ("last".equals(page)) {
      paginatedList.lastPage();
    }
    else if ("refresh".equals(page)) {
      paginatedList.refresh();
    }
    else {
      int pageIndex = Integer.parseInt(page);
      paginatedList.gotoPage(pageIndex);
    }
  }

}