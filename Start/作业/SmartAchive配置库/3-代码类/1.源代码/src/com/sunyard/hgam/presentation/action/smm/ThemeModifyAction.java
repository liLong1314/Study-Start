package com.sunyard.hgam.presentation.action.smm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.smm.ThemeForm;
import com.sunyard.hgam.persistence.dao.iface.smm.ThemeDao;

/**
 * <p>Title: �޸������</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author ������
 * @version 1.0
 */

public class ThemeModifyAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response){
    ThemeForm themeForm = (ThemeForm) form;
    ThemeDao themeDao = (ThemeDao) domainLogic.getDAO("Theme");
    themeDao.modifyTheme(themeForm.getThemeInfo());
    return mapping.findForward("success");
  }

}
