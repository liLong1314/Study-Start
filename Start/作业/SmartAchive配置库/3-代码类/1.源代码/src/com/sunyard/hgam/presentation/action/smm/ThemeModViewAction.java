package com.sunyard.hgam.presentation.action.smm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.iface.smm.ThemeDao;
import com.sunyard.hgam.persistence.dao.beans.smm.Theme;
import com.sunyard.hgam.presentation.form.smm.ThemeForm;

/**
 * <p>Title: ��ʾ�޸�����ʽ���</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author ������
 * @version 1.0
 */

public class ThemeModViewAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    String themeId;
    themeId = request.getParameter("themeId");

   ThemeDao themeDao = (ThemeDao) domainLogic.getDAO("Theme");
    ThemeForm themeForm = (ThemeForm) form;

    Theme themeInfo = null;
    themeInfo = themeDao.getTheme(themeId);
    ThemeForm newthemeForm = new ThemeForm();
    if (themeInfo != null) {
      newthemeForm.setThemeInfo(themeInfo);
    }
    else {
      return mapping.findForward("Failed");
    }
    request.setAttribute("themeForm", newthemeForm);
    return mapping.findForward("success");
  }

}
