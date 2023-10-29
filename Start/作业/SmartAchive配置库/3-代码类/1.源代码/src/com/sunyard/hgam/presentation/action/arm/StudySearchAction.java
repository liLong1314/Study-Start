package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.iface.arm.StudyDao;
import com.sunyard.hgam.persistence.dao.beans.arm.Study;
import com.sunyard.hgam.presentation.form.arm.StudyForm;

/**
 * <p>Title: ��ѯ���й���</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author ���
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
      //�滻���������Ϣ
      for (int i = 0; i < studys.size(); i++) {
        Study onestudy = (Study) studys.get(i);
        int studyType = Integer.parseInt(onestudy.getStudyType());
        switch (studyType) {
          case 1:
            onestudy.setStudyType("��֯�����ظ�");
            break;
          case 2:
            onestudy.setStudyType("�������ֻ��");
            break;
          case 3:
            onestudy.setStudyType("������");
            break;
          case 4:
            onestudy.setStudyType("���¼�");
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