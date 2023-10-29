package com.sunyard.hgam.presentation.action.smm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.persistence.dao.iface.smm.SysParamDao;
import com.ibatis.common.util.PaginatedList;

/**
 * <p>Title: ��ʾ���еĲ�����Ϣ</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author ������
 * @version 1.0
 */

public class ViewAllSysParamAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.
      Exception {
    PaginatedList sysParams = (PaginatedList) request.getSession().getAttribute(
        "SysParams");
    String isView = request.getParameter("view");
    if ( (isView != null && isView.equalsIgnoreCase("true")) || (sysParams == null)) {
      SysParamDao sysParamDao = (SysParamDao) domainLogic.getDAO("SysParam");
      request.getSession().setAttribute("SysParams", sysParamDao.getAllSysParam());
    }
    else {
      String page = request.getParameter("page");
      PagedListHelper.pageTo(sysParams, page);
    }
    return mapping.findForward("success");
  }
}