package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.iface.arm.ContainDao;

/**
 * <p>Title: ��ʾ�����ܼ��ܼ�¼</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author Ҷ�
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