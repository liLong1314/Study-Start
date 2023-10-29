package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.iface.arm.LawDao;
import com.sunyard.hgam.presentation.form.arm.LawForm;

/**
 * <p>Title: ��ѯ���ɷ���</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author Ҷ�
 * @version 1.0
 */

public class LawSearchAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    LawForm lawForm = (LawForm) form;
    String flag = request.getParameter("flag");
    PaginatedList laws = (PaginatedList) request.getSession().getAttribute(
        "Laws");
    if (laws == null || "first".equalsIgnoreCase(flag)) {
      LawDao lawDao = (LawDao) domainLogic.getDAO("Law");
      laws = lawDao.searchLaw(lawForm.getLawInfo());
      request.getSession().setAttribute("Laws", laws);
    }
    else {
      String page = request.getParameter("page");
      PagedListHelper.pageTo(laws, page);
    }

    return mapping.findForward("success");
  }

}