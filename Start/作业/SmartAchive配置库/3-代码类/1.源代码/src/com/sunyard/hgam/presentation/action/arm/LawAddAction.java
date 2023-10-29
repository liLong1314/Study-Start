package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.arm.LawForm;
import com.sunyard.hgam.persistence.dao.iface.arm.LawDao;

/**
 * <p>Title: 增加法律法规</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 叶昊
 * @version 1.0
 */

public class LawAddAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    LawForm lawForm=(LawForm) form;
    LawDao lawDao=(LawDao) domainLogic.getDAO("Law");
    lawDao.addLaw(lawForm.getLawInfo());
    return mapping.findForward("success");
  }

}