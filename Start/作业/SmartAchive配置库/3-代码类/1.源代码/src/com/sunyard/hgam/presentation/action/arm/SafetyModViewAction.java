package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.persistence.dao.iface.arm.SafetyDao;
import com.sunyard.hgam.persistence.dao.beans.arm.Safety;
import com.sunyard.hgam.presentation.form.arm.SafetyForm;

/**
 * <p>Title: 查看修改安全信息页面</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 叶昊
 * @version 1.0
 */

public class SafetyModViewAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    String safetyId=request.getParameter("safetyId");

    SafetyDao safetyDao=(SafetyDao) domainLogic.getDAO("Safety");
    Safety safetyInfo=new Safety();
    safetyInfo=safetyDao.getSafety(safetyId);

    SafetyForm modSafetyForm=new SafetyForm();
    if(safetyInfo!=null){
      modSafetyForm.setSafetyInfo(safetyInfo);
      request.setAttribute("safetyForm",modSafetyForm);
    }
    else{
      return mapping.findForward("Failed");
    }
    return mapping.findForward("success");
  }

}