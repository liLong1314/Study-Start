package com.sunyard.hgam.presentation.action.smm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.smm.ThemeForm;
import com.sunyard.hgam.persistence.dao.iface.smm.ThemeDao;

/**
 * <p>Title: ���������</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author ������
 * @version 1.0
 */

public class ThemeAddAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest httpServletRequest,
                                 HttpServletResponse httpServletResponse) {

    ThemeForm themeForm = (ThemeForm) form;
    ThemeDao themeDao = (ThemeDao) domainLogic.getDAO("Theme");
    themeDao.addTheme(themeForm.getThemeInfo());
    return mapping.findForward("success");
  }
}
