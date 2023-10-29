package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.arm.SafetyForm;
import com.sunyard.hgam.persistence.dao.iface.arm.SafetyDao;

/**
 * <p>Title: 增加安全信息</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 叶昊
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