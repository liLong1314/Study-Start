package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.iface.arm.SecretDao;
import com.sunyard.hgam.persistence.dao.beans.arm.Secret;
import com.sunyard.hgam.presentation.form.arm.SecretForm;

/**
 * <p>Title: 显示修改密级界面</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 叶昊
 * @version 1.0
 */

public class SecretModViewAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    String secretId;
    secretId = request.getParameter("secretId");

    SecretDao secretDao = (SecretDao) domainLogic.getDAO("Secret");

    Secret secretInfo = null;
    secretInfo = secretDao.getSecret(secretId);
    SecretForm newsecretForm = new SecretForm();
    if (secretInfo != null) {
      newsecretForm.setSecretInfo(secretInfo);
    }
    else {
      return mapping.findForward("Failed");
    }
    request.setAttribute("secretForm", newsecretForm);
    return mapping.findForward("success");
  }

}