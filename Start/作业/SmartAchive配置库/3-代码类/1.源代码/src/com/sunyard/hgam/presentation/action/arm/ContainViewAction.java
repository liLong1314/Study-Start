package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.iface.arm.ContainDao;

/**
 * <p>Title: 显示所有密集架记录</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 叶昊
 * @version 1.0
 */

public class ContainViewAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    /*
    PaginatedList contains = (PaginatedList) request.getSession().getAttribute("Contains");
    if (contains == null) {
      ContainDao containDao = (ContainDao) domainLogic.getDAO("Contain");
      contains = containDao.getAllContain();
      request.getSession().setAttribute("Contains", contains);
    }
    else {
      String page = request.getParameter("page");
      PagedListHelper.pageTo(contains, page);
    }
    */
    return mapping.findForward("success");
  }

}