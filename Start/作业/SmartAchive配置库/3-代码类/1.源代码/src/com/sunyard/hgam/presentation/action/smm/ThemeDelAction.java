package com.sunyard.hgam.presentation.action.smm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.persistence.dao.iface.smm.ThemeDao;

/**
 * <p>Title: 删除主题词</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 华良东
 * @version 1.0
 */

public class ThemeDelAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response){
    String themeId;
    themeId = request.getParameter("themeId");
    ThemeDao themeDao = (ThemeDao) domainLogic.getDAO("Theme");
    themeDao.delTheme(themeId);

    return mapping.findForward("success");
  }

}
