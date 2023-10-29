package com.sunyard.hgam.presentation.action.smm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.iface.smm.SysParamDao;
import com.sunyard.hgam.persistence.dao.beans.smm.SysParam;
import com.sunyard.hgam.presentation.form.smm.SysParamForm;

/**
 * <p>Title: 显示修改系统参数界面</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 华良东
 * @version 1.0
 */

public class SysParamModViewAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    String sysParamId;
    sysParamId = request.getParameter("sysParamId");

   SysParamDao sysParamDao = (SysParamDao) domainLogic.getDAO("SysParam");
    SysParamForm sysParamForm = (SysParamForm) form;

    SysParam sysParamInfo = null;
    sysParamInfo = sysParamDao.getSysParam(sysParamId);
    SysParamForm newsysParamForm = new SysParamForm();
    if (sysParamInfo != null) {
      newsysParamForm.setSysParamInfo(sysParamInfo);
    }
    else {
      return mapping.findForward("Failed");
    }
    request.setAttribute("sysParamForm", newsysParamForm);
    return mapping.findForward("success");
  }

}
