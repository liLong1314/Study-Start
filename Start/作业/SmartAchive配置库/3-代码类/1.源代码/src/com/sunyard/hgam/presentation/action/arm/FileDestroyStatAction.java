package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.iface.arm.DestroyDao;

/**
 * <p>Title: ����ͳ��</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author Ҷ�
 * @version 1.0
 */

public class FileDestroyStatAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    /*
    PaginatedList destroys = (PaginatedList) request.getSession().getAttribute("Destroys");
    if (destroys == null) {
      DestroyDao destroyDao = (DestroyDao) domainLogic.getDAO("Destroy");
      destroys = destroyDao.getAllDestroy();
      request.getSession().setAttribute("Destroys", destroys);
    }
    else {
      String page = request.getParameter("page");
      PagedListHelper.pageTo(destroys, page);
    }
    */
    return mapping.findForward("success");
  }
}

