package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.arm.SafetyForm;
import com.sunyard.hgam.persistence.dao.iface.arm.SafetyDao;

/**
 * <p>Title: ���Ӱ�ȫ��Ϣ</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author Ҷ�
 * @version 1.0
 */

public class SafetyAddAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    SafetyForm safetyForm=(SafetyForm) form;
    SafetyDao safetyDao=(SafetyDao) domainLogic.getDAO("Safety");
    safetyDao.addSafety(safetyForm.getSafetyInfo());
    return mapping.findForward("success");
  }

}