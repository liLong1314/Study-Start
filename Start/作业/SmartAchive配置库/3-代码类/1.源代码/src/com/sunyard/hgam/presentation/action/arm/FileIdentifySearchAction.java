package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.presentation.form.arm.IdentifyForm;
import com.sunyard.hgam.persistence.dao.beans.arm.Identify;
import com.sunyard.hgam.persistence.dao.iface.arm.IdentifyDao;

/**
 * <p>Title: 鉴定查询</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 华良东
 * @version 1.0
 */

public class FileIdentifySearchAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    String flag = request.getParameter("flag");
    PaginatedList Identifys = (PaginatedList) request.getSession().getAttribute(
        "Identifys");
    String page = request.getParameter("page");
    //第一次或者重新查询了
    if (Identifys == null || "first".equalsIgnoreCase(page)) {
      IdentifyForm identifyForm = (IdentifyForm) form;
      Identify identify = identifyForm.getIdentifyInfo();
      IdentifyDao identifyDao = (IdentifyDao) domainLogic.
          getDAO("Identify");
      Identifys = identifyDao.queryIdentifyList(identify);
      //放入缓存
      request.getSession().setAttribute("Identifys", Identifys);
    }else{
      PagedListHelper.pageTo(Identifys, page);
    }

    //
    return (mapping.findForward("success"));
  }
}