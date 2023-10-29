package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.iface.arm.StudyDao;
import com.sunyard.hgam.persistence.dao.beans.arm.Study;
import com.sunyard.hgam.presentation.form.arm.StudyForm;

/**
 * <p>Title: 查询编研管理</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 胡铮
 * @version 1.0
 */

public class StudySearchAction
    extends BaseAction {

  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    StudyForm studyForm = (StudyForm) form;
    String flag = request.getParameter("flag");
    PaginatedList studys = (PaginatedList) request.getSession().getAttribute(
        "Studys");
    if (studys == null || "first".equalsIgnoreCase(flag)) {
      StudyDao studyDao = (StudyDao) domainLogic.getDAO("Study");
      studys = studyDao.searchStudy(studyForm.getStudyInfo());
      //替换编研类别信息
      for (int i = 0; i < studys.size(); i++) {
        Study onestudy = (Study) studys.get(i);
        int studyType = Integer.parseInt(onestudy.getStudyType());
        switch (studyType) {
          case 1:
            onestudy.setStudyType("组织机构沿革");
            break;
          case 2:
            onestudy.setStudyType("基础数字汇编");
            break;
          case 3:
            onestudy.setStudyType("会议简介");
            break;
          case 4:
            onestudy.setStudyType("大事记");
            break;
        }
      }
      request.getSession().setAttribute("Studys", studys);
    }
    else {
      String page = request.getParameter("page");
      PagedListHelper.pageTo(studys, page);
    }

    return mapping.findForward("success");
  }

}