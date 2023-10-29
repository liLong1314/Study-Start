package com.sunyard.hgam.presentation.base;

import com.ibatis.common.util.PaginatedList;

/**
 * <p>Title: Hang Zhou Net Archives</p>
 * <p>Description: ���������ϵ����ݽ��裨һ�ڣ�</p>
 * <p>Copyright: Hangzhou Sunyard System Engineering�� Ltd. All rights reserved @2003</p>
 * <p>Company: </p>
 * @Date        Author      Changes
 * Nov 11,2003   yujx        created
 * @version 0.01
 */

public class PagedListHelper {

  /**
   * ҳ����ת���Ʒ���
   * @param paginatedList ���Bean���б�
   * @param page Ҫ��ת��Ŀ��,������["first","previous","next","last"],Ҳ�����������ַ���
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