package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.iface.arm.SafetyDao;
import com.sunyard.hgam.persistence.dao.beans.arm.Safety;
import com.sunyard.hgam.presentation.form.arm.SafetyForm;

/**
 * <p>Title: ��ȫ��¼��ѯ</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author Ҷ�
 * @version 1.0
 */

public class SafetySearchAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    SafetyForm safetyForm=(SafetyForm) form;
    String flag=request.getParameter("flag");
    PaginatedList safetys = (PaginatedList) request.getSession().getAttribute("Safetys");

    if (safetys == null || "first".equalsIgnoreCase(flag)) {
      SafetyDao safetyDao = (SafetyDao) domainLogic.getDAO("Safety");
      safetys = safetyDao.searchSafety(safetyForm.getSafetyInfo());
      //�滻��ȫ������Ϣ
      for (int i = 0; i < safetys.size(); i++) {
        Safety onesafety = (Safety) safetys.get(i);
        int safetyType = Integer.parseInt(onesafety.getSafetyType());
        switch (safetyType) {
          case 1:
            onesafety.setSafetyType("��ù����");
            break;
          case 2:
            onesafety.setSafetyType("��������");
            break;
          case 3:
            onesafety.setSafetyType("�������");
            break;
          case 4:
            onesafety.setSafetyType("��������");
            break;
          case 5:
            onesafety.setSafetyType("��������");
            break;
          default:
            onesafety.setSafetyType("����");
            break;
        }
      }
      request.getSession().setAttribute("Safetys", safetys);
    }
    else {
      String page = request.getParameter("page");
      PagedListHelper.pageTo(safetys, page);
    }

    return mapping.findForward("success");
  }

}