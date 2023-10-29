package com.sunyard.hgam.presentation.action.smm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.persistence.dao.iface.smm.ThemeDao;
import com.ibatis.common.util.PaginatedList;

/**
 * <p>Title: ��ʾ���е��������Ϣ</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author ������
 * @version 1.0
 */

 public class ViewAllThemeAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.
      Exception {
    PaginatedList themes = (PaginatedList) request.getSession().getAttribute("Themes");
    String isView = request.getParameter("view");
    if ( (isView != null && isView.equalsIgnoreCase("true")) || (themes == null)) {
      ThemeDao themeDao = (ThemeDao) domainLogic.getDAO("Theme");
      request.getSession().setAttribute("Themes", themeDao.getAllTheme());
    } else {
      String page = request.getParameter("page");
      PagedListHelper.pageTo(themes, page);
    }

    return mapping.findForward("success");
  }
}
