package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.persistence.dao.iface.arm.SecretDao;
import com.ibatis.common.util.PaginatedList;
import java.util.List;

/**
 * <p>Title: ��ʾ���������ܼ�</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author Ҷ�
 * @version 1.0
 */

public class SecretAllViewAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    List secrets = null;
    SecretDao secretDao = (SecretDao) domainLogic.getDAO("Secret");
    request.getSession().setAttribute("Secrets", secretDao.getAllSecret());

    return mapping.findForward("success");
  }
}