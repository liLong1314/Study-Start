package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.arm.WholeForm;
import com.sunyard.hgam.persistence.dao.iface.arm.WholeDao;

/**
 * <p>Title: 增加全宗卷信息</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 叶昊
 * @version 1.0
 */

public class WholeAddAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    WholeForm wholeForm=(WholeForm) form;
    WholeDao wholeDao=(WholeDao) domainLogic.getDAO("Whole");
    wholeDao.addWhole(wholeForm.getWholeInfo());
    return mapping.findForward("success");
  }

}