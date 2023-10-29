package com.sunyard.hgam.presentation.action.arm;




import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.persistence.dao.iface.arm.OtherCataLogDao;
import com.sunyard.hgam.presentation.form.arm.OtherCataLogForm;

/**
 * <p>Title: ���������Ŀ¼��Ϣ</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author ������
 * @version 1.0
 */

public class OtherCataLogAddAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest httpServletRequest,
                                 HttpServletResponse httpServletResponse) {

    OtherCataLogForm otherCataLogForm = (OtherCataLogForm) form;
    OtherCataLogDao otherCataLogDao = (OtherCataLogDao) domainLogic.getDAO("OtherCataLog");
    otherCataLogDao.addOtherCataLog(otherCataLogForm.getOtherCataLogInfo());
    return mapping.findForward("success");
  }
}
