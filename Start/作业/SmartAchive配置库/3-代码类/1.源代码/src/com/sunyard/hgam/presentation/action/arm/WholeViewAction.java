package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.iface.arm.WholeDao;
import java.util.List;

/**
 * <p>Title: ����鿴ȫ����Ϣ�б�</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author Ҷ�
 * @version 1.0
 */

public class WholeViewAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    String wholeType = request.getParameter("type");
    String wholeTypeName;

    if (wholeType == null) {
      wholeType = request.getSession().getAttribute("tmpwholeType").toString();
    }
    else {
      request.getSession().setAttribute("tmpwholeType", wholeType);
    }

    switch (Integer.parseInt(wholeType)) {
      case 1:
        wholeTypeName = "ȫ�ڽ���";
        break;
      case 2:
        wholeTypeName = "�����ռ�����";
        break;
      case 3:
        wholeTypeName = "�����������";
        break;
      case 4:
        wholeTypeName = "������������";
        break;
      case 5:
        wholeTypeName = "�������ܲ���";
        break;
      case 6:
        wholeTypeName = "����ͳ�Ʋ���";
        break;
      case 7:
        wholeTypeName = "�������ò���";
        break;
      case 8:
        wholeTypeName = "�����ִ�������";
        break;
      case 9:
        wholeTypeName = "���¼�";
        break;
      default:
        wholeTypeName = "����";
    }

    List wholes = null;
    WholeDao wholeDao = (WholeDao) domainLogic.getDAO("Whole");
    wholes = wholeDao.getWholeByType(wholeType);
    request.getSession().setAttribute("Wholes", wholes);
    request.getSession().setAttribute("WholeTypeName", wholeTypeName);

    return mapping.findForward("success");
  }

}