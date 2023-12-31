package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.iface.arm.PageOperDao;

/**
 * <p>Title: 查看文件页面</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 叶昊
 * @version 1.0
 */

public class ArchPageViewAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    String fileId=request.getParameter("fileId");
    PaginatedList pageOpers=(PaginatedList) request.getSession().getAttribute("PageOpers");

    if(pageOpers==null){
      PageOperDao pageOperDao=(PageOperDao) domainLogic.getDAO("PageOper");
      pageOpers=pageOperDao.getPages(fileId);
      request.getSession().setAttribute("PageOpers",pageOpers);
    }
    else{
      String page=request.getParameter("page");
      PagedListHelper.pageTo(pageOpers,page);
    }

    return mapping.findForward("success");
  }

}