package com.sunyard.hgam.presentation.action.aum;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.iface.aum.UtilizeInfoDao;
import java.util.List;
import com.sunyard.hgam.persistence.dao.beans.aum.UtilizeInfo;
import java.util.Date;
import com.sunyard.hgam.util.aum.Blackbox;
import com.sunyard.hgam.presentation.form.smm.AccountForm;
import com.sunyard.hgam.persistence.dao.beans.smm.Account;
import com.sunyard.hgam.persistence.dao.iface.smm.AccountDAO;
import com.sunyard.hgam.util.aum.PagingHelper;

/**
 * <p>Title: HGAM(杭州市规划档案综合管理系统) </p>
 * <p>Description: 显示某一个用户的所有任务action </p>
 * <p>Copyright: Sunhoo Copyright (c) 2004 </p>
 * <p>Company: Sunhoo Software Co.,Ltd. </p>
 * @author wanghua
 * @version 1.0
 */

public class BorrowTaskListAction
    extends BaseAction {

  public ActionForward doPerform(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {

    List utilizes = null;
    String flag = request.getParameter("flag");
    String anotherFlag = request.getParameter("anotherFlag");
    String filterFlag = (String)request.getSession().getAttribute("filterFlag");
    if ( (flag == null) || (flag.equals("")))
      flag = "0";
    String strApplyBeginTime = request.getParameter("applyBeginTime");
    String strApplyEndTime = request.getParameter("applyEndTime");
    Date dateApplyBeginTime = null;
    Date dateApplyEndTime = null;
    String strDeliverBeginTime = request.getParameter("deliverBeginTime");
    String strDeliverEndTime = request.getParameter("deliverEndTime");
    Date dateDeliverBeginTime = null;
    Date dateDeliverEndTime = null;

    if (strApplyBeginTime != null && !strApplyBeginTime.equals(""))
      dateApplyBeginTime = Blackbox.changeStr2DateTime(strApplyBeginTime);
    if (strApplyEndTime != null && !strApplyEndTime.equals(""))
      dateApplyEndTime = Blackbox.changeStr2DateTime(strApplyEndTime);

    if (strDeliverBeginTime != null && !strDeliverBeginTime.equals(""))
      dateDeliverBeginTime = Blackbox.changeStr2DateTime(strDeliverBeginTime);
    if (strDeliverEndTime != null && !strDeliverEndTime.equals(""))
      dateDeliverEndTime = Blackbox.changeStr2DateTime(strDeliverEndTime);

    String utilizer = request.getParameter("utilizer");
    String queryFlag = request.getParameter("queryFlag");

    //翻页用
    String pageIndex = request.getParameter("pageIndex");
    String pagingFlag = request.getParameter("pagingFlag");

    //获取登录信息
    String loginName = "";
    String pwd = "";
    AccountForm accountInfo = (AccountForm) request.getSession().getAttribute(
        "ACCOUNT_INFORMATION");
    if (accountInfo != null) {
      Account account = accountInfo.getAccount();
      loginName = account.getUserName();
    }
    AccountDAO accountDAO = (AccountDAO) domainLogic.getDAO("Account");
    pwd = accountDAO.getPasswordByUsername(loginName);

    UtilizeInfoDao utilDao = (UtilizeInfoDao) domainLogic.getDAO(
        "UtilizeInfoDao");
    if (pageIndex == null || pageIndex.equals("")) {
    if (flag.equals("0")) {
      utilizes = utilDao.getAllTaskByUser(loginName, pwd, "0", 2);
    }
    else if (flag.equals("1")) {
      utilizes = utilDao.getAllTaskByUser(loginName, pwd, "1", 2);
    }
    else if (flag.equals("2")) {
      utilizes = utilDao.getAllTaskByUser(loginName, pwd, "2", 2);
    }

    if (queryFlag != null) {
      if (!queryFlag.equals("3")) {
        if (queryFlag.equals("0")) {
          utilizes = utilDao.getAllTaskByCondition(loginName, pwd, "0", 2,
              dateDeliverBeginTime, dateDeliverEndTime, dateApplyBeginTime,
              dateApplyEndTime, utilizer);
        }
        else if (queryFlag.equals("1")) {
          utilizes = utilDao.getAllTaskByCondition(loginName, pwd, "1", 2,
              dateDeliverBeginTime, dateDeliverEndTime, dateApplyBeginTime,
              dateApplyEndTime, utilizer);
        }
        else if (queryFlag.equals("2")) {
          utilizes = utilDao.getAllTaskByCondition(loginName, pwd, "2", 2,
              dateDeliverBeginTime, dateDeliverEndTime, dateApplyBeginTime,
              dateApplyEndTime, utilizer);
        }
      }
      else if (filterFlag.equals("1")) {
        utilizes = utilDao.getAllTaskByCondition(loginName, pwd, "1", 2,
            dateDeliverBeginTime, dateDeliverEndTime, dateApplyBeginTime,
            dateApplyEndTime, utilizer);
        flag = "1";
      }
      else if (filterFlag.equals("2")) {
        utilizes = utilDao.getAllTaskByCondition(loginName, pwd, "2", 2,
            dateDeliverBeginTime, dateDeliverEndTime, dateApplyBeginTime,
            dateApplyEndTime, utilizer);
        flag = "2";
      }
      else if (filterFlag.equals("0")) {
        utilizes = utilDao.getAllTaskByCondition(loginName, pwd, "0", 2,
            dateDeliverBeginTime, dateDeliverEndTime, dateApplyBeginTime,
            dateApplyEndTime, utilizer);
        flag = "0";
      }
    }

    //先显示一个初始页面
    request.getSession().setAttribute("filterFlag", flag);
    request.getSession().setAttribute("taskList", utilizes);
    PagingHelper pagingHelper = new PagingHelper(utilizes, 8);
    if (pagingHelper.getAmountOfObject() != 0) {
      request.getSession().setAttribute("taskListForPaging",
                                        pagingHelper.goFirst());
    }
    else {
      request.getSession().setAttribute("taskListForPaging",
                                        null);
      pagingHelper.setFirstPage("1");
      pagingHelper.setLastPage("1");
    }
    request.setAttribute("pagingHelper",pagingHelper);
  }
  else {
    List aUtilizes = (List)request.getSession().getAttribute("taskList");
    PagingHelper pagingHelper = new PagingHelper(aUtilizes, 8);
    pagingHelper.setPageIndex(Integer.parseInt(pageIndex));

    //根据翻页的要求执行相应的动作
    if (pagingFlag.equals("next")) {
      request.getSession().setAttribute("taskListForPaging",
                                        pagingHelper.goNext());
    }
    else if (pagingFlag.equals("previous")) {
      request.getSession().setAttribute("taskListForPaging",
                                        pagingHelper.goPrevious());
    }
    else if (pagingFlag.equals("first")) {
      request.getSession().setAttribute("taskListForPaging",
                                        pagingHelper.goFirst());
    }
    else if (pagingFlag.equals("last")) {
      request.getSession().setAttribute("taskListForPaging",
                                        pagingHelper.goLast());
    }
    else if (pagingFlag.equals("any")) {
      int selectedPageIndex = Integer.parseInt(request.getParameter("pageIndex"));
      request.getSession().setAttribute("taskListForPaging",
                                        pagingHelper.goSelectedPage(selectedPageIndex));
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

    request.getSession().setAttribute("pagingHelper",pagingHelper);

  }

    System.out.println("显示任务列表Action成功!");
    return mapping.findForward("success");

  }

}