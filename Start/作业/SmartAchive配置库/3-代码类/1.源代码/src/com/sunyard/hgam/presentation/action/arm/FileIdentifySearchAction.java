package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.presentation.form.arm.IdentifyForm;
import com.sunyard.hgam.persistence.dao.beans.arm.Identify;
import com.sunyard.hgam.persistence.dao.iface.arm.IdentifyDao;

/**
 * <p>Title: ������ѯ</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author ������
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
    //��һ�λ������²�ѯ��
    if (Identifys == null || "first".equalsIgnoreCase(page)) {
      IdentifyForm identifyForm = (IdentifyForm) form;
      Identify identify = identifyForm.getIdentifyInfo();
      IdentifyDao identifyDao = (IdentifyDao) domainLogic.
          getDAO("Identify");
      Identifys = identifyDao.queryIdentifyList(identify);
      //���뻺��
      request.getSession().setAttribute("Identifys", Identifys);
    }else{
      PagedListHelper.pageTo(Identifys, page);
    }

    //
    return (mapping.findForward("success"));
  }
}