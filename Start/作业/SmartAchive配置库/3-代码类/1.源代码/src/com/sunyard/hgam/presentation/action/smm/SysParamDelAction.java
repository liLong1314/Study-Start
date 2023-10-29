package com.sunyard.hgam.presentation.action.smm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.persistence.dao.iface.smm.SysParamDao;

/**
 * <p>Title: ɾ��ϵͳ����</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author ������
 * @version 1.0
 */

public class SysParamDelAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response){
    String sysParamId;
    sysParamId = request.getParameter("sysParamId");
    SysParamDao sysParamDao = (SysParamDao) domainLogic.getDAO("SysParam");
    sysParamDao.delSysParam(sysParamId);

    return mapping.findForward("success");
  }

}
