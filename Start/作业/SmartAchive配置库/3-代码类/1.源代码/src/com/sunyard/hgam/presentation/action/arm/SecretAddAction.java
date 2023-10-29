package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.arm.SecretForm;
import com.sunyard.hgam.persistence.dao.iface.arm.SecretDao;

/**
 * <p>Title: 增加密级</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 叶昊
 * @version 1.0
 */

public class SecretAddAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest httpServletRequest,
                                 HttpServletResponse httpServletResponse) {

    SecretForm secretForm = (SecretForm) form;
    SecretDao secretDao = (SecretDao) domainLogic.getDAO("Secret");
    secretDao.addSecret(secretForm.getSecretInfo());
    return mapping.findForward("success");
  }
}