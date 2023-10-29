package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.arm.SecretForm;
import com.sunyard.hgam.persistence.dao.iface.arm.SecretDao;

/**
 * <p>Title: �޸��ܼ�</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author Ҷ�
 * @version 1.0
 */

public class SecretModifyAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response){
    SecretForm secretForm = (SecretForm) form;
    SecretDao secretDao = (SecretDao) domainLogic.getDAO("Secret");
    secretDao.modifySecret(secretForm.getSecretInfo());
    return mapping.findForward("success");
  }

}