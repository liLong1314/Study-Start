package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.iface.arm.StudyDao;
import com.sunyard.hgam.persistence.dao.beans.arm.Study;
import com.sunyard.hgam.presentation.form.arm.StudyForm;

/**
 * <p>Title: 显示修改编研信息界面</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 胡铮
 * @version 1.0
 */

public class StudyModViewAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    String studyId = request.getParameter("studyId");

    StudyDao studyDao = (StudyDao) domainLogic.getDAO("Study");
    Study studyInfo = new Study();
    studyInfo = studyDao.getStudy(studyId);

    StudyForm newstudyForm = new StudyForm();
    if (studyInfo != null) {
      newstudyForm.setStudyInfo(studyInfo);
      request.setAttribute("studyForm", newstudyForm);
    }
    else {
      return mapping.findForward("Failed");
    }

    return mapping.findForward("success");
  }

}