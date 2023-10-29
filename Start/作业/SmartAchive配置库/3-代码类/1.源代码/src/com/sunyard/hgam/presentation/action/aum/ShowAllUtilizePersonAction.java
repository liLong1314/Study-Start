package com.sunyard.hgam.presentation.action.aum;

import com.sunyard.hgam.presentation.base.BaseAction;
import org.apache.struts.action.ActionMapping;
import com.ibatis.common.util.PaginatedList;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.ArrayList;
import com.sunyard.hgam.persistence.dao.beans.adc.ArchivesPage;
import com.sunyard.hgam.persistence.dao.beans.aum.UtilizeDetail;
import com.sunyard.hgam.presentation.form.aum.UtilizeDetailForm;
import com.sunyard.hgam.persistence.dao.iface.aum.UtilizeDetailDao;
import com.sunyard.hgam.persistence.dao.iface.adc.ArchivesPageDao;
import com.sunyard.hgam.persistence.dao.iface.aum.UtilizeInfoDao;
import com.sunyard.hgam.presentation.form.aum.UtilizeInfoForm;
import com.sunyard.hgam.util.aum.PagingHelper;

/**
 * <p>Title: HGAM(杭州市规划档案综合管理系统) </p>
 * <p>Description: 显示某一个用户的所有任务action </p>
 * <p>Copyright: Sunhoo Copyright (c) 2004 </p>
 * <p>Company: Sunhoo Software Co.,Ltd. </p>
 * @author wanghua
 * @version 1.0
 */

public class ShowAllUtilizePersonAction
    extends BaseAction {

  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.
      Exception {

    UtilizeInfoDao utilDao = (UtilizeInfoDao) domainLogic.getDAO(
        "UtilizeInfoDao");
    String type = request.getParameter("type");
    if (type == null || type.equals("")) {
      type = (String) request.getSession().getAttribute("type");
    }

    //for paging
    String pageIndex = request.getParameter("pageIndex");
    String pagingFlag = request.getParameter("pagingFlag");

    String strForwardTo = "";
    List personList = new ArrayList();

    try {

      //for paging,initial page
      if (pageIndex == null || pageIndex.equals("")) {
        personList = utilDao.getAllUtilizePersonInfo();
        request.getSession().setAttribute("personList", personList);
        PagingHelper pagingHelper = new PagingHelper(personList, 10);

        if (pagingHelper.getAmountOfObject() != 0) {
          request.getSession().setAttribute("personListForPaging",
                                            pagingHelper.goFirst());
        }
        else {
          request.getSession().setAttribute("personListForPaging",
                                            null);
          pagingHelper.setFirstPage("1");
          pagingHelper.setLastPage("1");
        }
        request.getSession().setAttribute("pageIndex", "1");
        request.setAttribute("pagingHelper",pagingHelper);
      }
      //all page, except for the initial page
      else {
        List aUtilizes = (List) request.getSession().getAttribute("personList");
        PagingHelper pagingHelper = new PagingHelper(aUtilizes, 10);
        pagingHelper.setPageIndex(Integer.parseInt(pageIndex));

        //根据翻页的要求执行相应的动作
        if (pagingFlag.equals("next")) {
          request.getSession().setAttribute("personListForPaging",
                                            pagingHelper.goNext());
        }
        else if (pagingFlag.equals("previous")) {
          request.getSession().setAttribute("personListForPaging",
                                            pagingHelper.goPrevious());
        }
        else if (pagingFlag.equals("first")) {
          request.getSession().setAttribute("personListForPaging",
                                            pagingHelper.goFirst());
        }
        else if (pagingFlag.equals("last")) {
          request.getSession().setAttribute("personListForPaging",
                                            pagingHelper.goLast());
        }
        else if (pagingFlag.equals("any")) {
          int selectedPageIndex = Integer.parseInt(request.getParameter(
              "pageIndex"));
          request.getSession().setAttribute("personListForPaging",
                                            pagingHelper.goSelectedPage(
              selectedPageIndex));
        }

        //设置paging信息
        if (pagingHelper.firstPage())
          pagingHelper.setFirstPage("1");
        else
          pagingHelper.setFirstPage("0");

        if (pagingHelper.lastPage())
          pagingHelper.setLastPage("1");
        else
          pagingHelper.setLastPage("0");

        request.getSession().setAttribute("pagingHelper", pagingHelper);
      }
      if (type.equals("1"))
        strForwardTo = "VIEW";
      else if (type.equals("2"))
        strForwardTo = "BORROW";
      else if (type.equals("3"))
        strForwardTo = "REPAIR";
    }
    catch (Exception ex) {
      ex.printStackTrace();
      strForwardTo = "FAILURE";
    }
    finally {
      request.getSession().setAttribute("type", type);
      return mapping.findForward(strForwardTo);
    }
  }

}