package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.persistence.dao.iface.arm.StudyDao;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.beans.arm.Safety;
import com.sunyard.hgam.persistence.dao.beans.arm.Study;

/**
 * <p>Title: ��ʾ���б�����Ϣ</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author ���
 * @version 1.0
 */

public class StudyAllViewAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    /*
    PaginatedList studys = (PaginatedList) request.getSession().getAttribute(
        "Studys");
    if (studys == null) {
      StudyDao studyDao = (StudyDao) domainLogic.getDAO("Study");
      studys = studyDao.getAllStudy();
      //�滻��ȫ������Ϣ
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

      request.getSession().setAttribute("Studys", studyDao.getAllStudy());
    }
    else {
      String page = request.getParameter("page");
      PagedListHelper.pageTo(studys, page);
    }
    */
    return mapping.findForward("success");
  }
}