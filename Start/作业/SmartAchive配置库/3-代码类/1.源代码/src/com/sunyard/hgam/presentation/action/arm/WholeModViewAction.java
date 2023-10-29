package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.persistence.dao.iface.arm.WholeDao;
import com.sunyard.hgam.persistence.dao.beans.arm.Whole;
import com.sunyard.hgam.presentation.form.arm.WholeForm;

/**
 * <p>Title: �鿴�޸�ȫ�ھ���Ϣҳ��</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author Ҷ�
 * @version 1.0
 */

public class WholeModViewAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    String wholeId=request.getParameter("wholeId");
    WholeDao wholeDao=(WholeDao) domainLogic.getDAO("Whole");
    Whole wholeInfo=new Whole();
    wholeInfo=wholeDao.getWhole(wholeId);
    if(wholeInfo!=null){
      WholeForm wholeForm=new WholeForm();
      wholeForm.setWholeInfo(wholeInfo);
      request.setAttribute("wholeForm",wholeForm);
    }
    else{
      return mapping.findForward("Failed");
    }
    return mapping.findForward("success");
  }

}