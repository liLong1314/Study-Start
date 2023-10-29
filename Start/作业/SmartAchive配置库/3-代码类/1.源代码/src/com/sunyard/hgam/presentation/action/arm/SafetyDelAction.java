package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.persistence.dao.iface.arm.SafetyDao;

/**
 * <p>Title: ɾ����ȫ��¼</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author Ҷ�
 * @version 1.0
 */

public class SafetyDelAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    String safetyId=request.getParameter("safetyId");
    SafetyDao safetyDao=(SafetyDao) domainLogic.getDAO("Safety");
    safetyDao.delSafety(safetyId);
    return mapping.findForward("success");
  }

}