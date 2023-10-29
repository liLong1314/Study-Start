package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.presentation.form.arm.DestroyForm;
import com.sunyard.hgam.persistence.dao.beans.arm.Destroy;
import com.sunyard.hgam.persistence.dao.iface.arm.DestroyDao;

/**
 * <p>Title: 销毁查询</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 华良东
 * @version 1.0
 */

public class FileDestroySearchAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                ActionForm form,
                                HttpServletRequest request,
                                HttpServletResponse response) {
   String flag=request.getParameter("flag");
   PaginatedList Destroys = (PaginatedList) request.getSession().getAttribute(
      "Destroys");
  String page = request.getParameter("page");
  if (page == null || "first".equalsIgnoreCase(flag)) {
  DestroyForm destroyForm = (DestroyForm) form;
    Destroy destory = destroyForm.getDestroyInfo();
    DestroyDao destroyDao = (DestroyDao) domainLogic.
        getDAO("Destroy");
    Destroys = destroyDao.queryDestroyList(destory);
    //放入缓存
    request.getSession().setAttribute("Destroys", Destroys);
    PagedListHelper.pageTo(Destroys, page);
  }
  else{
        PagedListHelper.pageTo(Destroys, page);
      }

  //
  return (mapping.findForward("success"));
}
}
