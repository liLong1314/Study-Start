package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.arm.WholeForm;
import com.sunyard.hgam.persistence.dao.iface.arm.WholeDao;

/**
 * <p>Title: ����ȫ�ھ���Ϣ</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author Ҷ�
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