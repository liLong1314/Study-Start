package com.sunyard.hgam.presentation.action.aum;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.arm.ArchOperForm;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.iface.arm.ArchOperDao;

/**
 * <p>Title: 综合查询－模糊查询</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 叶昊
 * @version 1.0
 */

public class ArchBlurQueryAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    ArchOperForm archOperForm = (ArchOperForm) form;
    String flag=request.getParameter("flag");
    PaginatedList archOpers = (PaginatedList) request.getSession().getAttribute("QueryArchs");

    if (archOpers == null || "first".equalsIgnoreCase(flag)) {
      ArchOperDao archOperDao = (ArchOperDao) domainLogic.getDAO("ArchOper");
      archOpers = archOperDao.queryblurArchive(archOperForm.getArchOperInfo());
      request.getSession().setAttribute("QueryArchs", archOpers);
    }
    else {
      String page = request.getParameter("page");
      PagedListHelper.pageTo(archOpers, page);
    }

    return mapping.findForward("success");
  }

}