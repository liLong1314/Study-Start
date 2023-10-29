package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.presentation.form.arm.OtherCataLogForm;
import com.sunyard.hgam.persistence.dao.beans.arm.OtherCataLog;
import com.sunyard.hgam.persistence.dao.iface.arm.OtherCataLogDao;

/**
 * <p>Title: ��ʾ�����Ŀ¼</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author ������
 * @version 1.0
 */

public class QueryOtherCataLogListAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                ActionForm form,
                                HttpServletRequest request,
                                HttpServletResponse response) throws java.lang.
     Exception {

   PaginatedList OtherCataLogs = (PaginatedList) request.getAttribute(
      "OtherCataLogs");
  String page = request.getParameter("page");
  if (page == null) {
    OtherCataLogForm otherCataLogForm = (OtherCataLogForm) form;
    OtherCataLog otherCataLog = otherCataLogForm.
        getOtherCataLogInfo();
    OtherCataLogDao otherCataLogDao = (OtherCataLogDao) domainLogic.
        getDAO("OtherCataLog");
    OtherCataLogs = otherCataLogDao.queryOtherCataLogList(
        otherCataLog);
    //���뻺��
    request.getSession().setAttribute("OtherCataLogs", OtherCataLogs);
    PagedListHelper.pageTo(OtherCataLogs, page);
  }
  else{ PaginatedList list = (PaginatedList) request.getSession().getAttribute("OtherCataLogs");
      if (list!=null){
        PagedListHelper.pageTo(list, page);
        return (mapping.findForward("success"));
      }

    }


  //
  return (mapping.findForward("success"));
}
}




