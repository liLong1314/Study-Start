package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.arm.LawForm;
import com.sunyard.hgam.persistence.dao.iface.arm.LawDao;

/**
 * <p>Title: �޸ķ��ɷ���</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author Ҷ�
 * @version 1.0
 */

public class LawModifyAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    LawForm lawForm=(LawForm) form;
    LawDao lawDao=(LawDao) domainLogic.getDAO("Law");
    lawDao.modifyLaw(lawForm.getLawInfo());
    return mapping.findForward("success");
  }

}