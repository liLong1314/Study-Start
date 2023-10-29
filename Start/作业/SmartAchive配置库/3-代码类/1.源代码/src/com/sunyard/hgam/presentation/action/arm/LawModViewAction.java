package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.persistence.dao.iface.arm.LawDao;
import com.sunyard.hgam.persistence.dao.beans.arm.Law;
import com.sunyard.hgam.presentation.form.arm.LawForm;

/**
 * <p>Title: �鿴�޸ķ��ɷ���ҳ��</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author Ҷ�
 * @version 1.0
 */

public class LawModViewAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    String lawId=request.getParameter("lawId");
    LawDao lawDao=(LawDao) domainLogic.getDAO("Law");
    Law lawInfo=new Law();
    lawInfo=lawDao.getLaw(lawId);
    LawForm modLawForm=new LawForm();
    if(lawInfo!=null){
      modLawForm.setLawInfo(lawInfo);
      request.setAttribute("lawForm",modLawForm);
    }
    else{
      return mapping.findForward("Failed");
    }
    return mapping.findForward("success");
  }

}