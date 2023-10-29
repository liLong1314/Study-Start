package com.sunyard.hgam.presentation.action.smm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.smm.SysParamForm;
import com.sunyard.hgam.persistence.dao.iface.smm.SysParamDao;

/**
 * <p>Title: 修改系统参数</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 华良东
 * @version 1.0
 */

public class SysParamModifyAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response){
    SysParamForm sysParamForm = (SysParamForm) form;
    SysParamDao sysParamDao = (SysParamDao) domainLogic.getDAO("SysParam");
    sysParamDao.modifySysParam(sysParamForm.getSysParamInfo());
    return mapping.findForward("success");
  }

}
