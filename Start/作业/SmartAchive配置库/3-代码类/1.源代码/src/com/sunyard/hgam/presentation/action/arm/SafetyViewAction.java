package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.iface.arm.SafetyDao;
import com.sunyard.hgam.persistence.dao.beans.arm.Safety;

/**
 * <p>Title: �鿴��ȫ��Ϣ�б�</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author Ҷ�
 * @version 1.0
 */

public class SafetyViewAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    /*
    PaginatedList safetys = (PaginatedList) request.getSession().getAttribute("Safetys");
    if (safetys == null) {
      SafetyDao safetyDao = (SafetyDao) domainLogic.getDAO("Safety");
      safetys = safetyDao.getAllSafety();
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
    */
    return mapping.findForward("success");
  }

}