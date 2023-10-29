package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.iface.arm.ContainDao;
import com.sunyard.hgam.presentation.form.arm.ContainForm;

/**
 * <p>Title: ��ѯ�ܼ���</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author Ҷ�
 * @version 1.0
 */

public class ContainSearchAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    ContainForm containForm=(ContainForm) form;
    String flag=request.getParameter("flag");
    PaginatedList contains = (PaginatedList) request.getSession().getAttribute("Contains");
    if (contains == null || "first".equalsIgnoreCase(flag)) {
      ContainDao containDao = (ContainDao) domainLogic.getDAO("Contain");
      contains = containDao.searchContain(containForm.getContainInfo());
      request.getSession().setAttribute("Contains", contains);
    }
    else {
      String page = request.getParameter("page");
      PagedListHelper.pageTo(contains, page);
    }

    return mapping.findForward("success");
  }

}