package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.arm.StudyForm;
import com.sunyard.hgam.persistence.dao.iface.arm.StudyDao;

/**
 * <p>Title: ���ӱ�����Ϣ</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author ���
 * @version 1.0
 */

public class StudyAddAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest httpServletRequest,
                                 HttpServletResponse httpServletResponse) {

    StudyForm studyForm = (StudyForm) form;
    StudyDao studyDao = (StudyDao) domainLogic.getDAO("Study");
    studyDao.addStudy(studyForm.getStudyInfo());
    return mapping.findForward("success");
  }
}
