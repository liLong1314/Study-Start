package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.iface.arm.LawDao;

/**
 * <p>Title: �鿴���з��ɷ����¼</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author Ҷ�
 * @version 1.0
 */

public class LawViewAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    /*
    PaginatedList laws = (PaginatedList) request.getSession().getAttribute("Laws");
    if (laws == null) {
      LawDao lawDao = (LawDao) domainLogic.getDAO("Law");
      laws=lawDao.getAllLaw();
      request.getSession().setAttribute("Laws",laws);
    }
    else {
      String page=request.getParameter("page");
      PagedListHelper.pageTo(laws,page);
    }
    */
    return mapping.findForward("success");
  }

}