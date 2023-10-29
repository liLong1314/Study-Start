package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.iface.arm.SafetyDao;
import com.sunyard.hgam.persistence.dao.beans.arm.Safety;

/**
 * <p>Title: 查看安全信息列表</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 叶昊
 * @version 1.0
 */

public class SafetyViewAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    /*
    PaginatedList safetys = (PaginatedList) request.getSession().getAttribute("Safetys");
    if (safetys == null) {
      SafetyDao safetyDao = (SafetyDao) domainLogic.getDAO("Safety");
      safetys = safetyDao.getAllSafety();
      //替换安全类型信息
      for (int i = 0; i < safetys.size(); i++) {
        Safety onesafety = (Safety) safetys.get(i);
        int safetyType = Integer.parseInt(onesafety.getSafetyType());
        switch (safetyType) {
          case 1:
            onesafety.setSafetyType("虫霉防治");
            break;
          case 2:
            onesafety.setSafetyType("除尘管理");
            break;
          case 3:
            onesafety.setSafetyType("防火管理");
            break;
          case 4:
            onesafety.setSafetyType("防盗管理");
            break;
          case 5:
            onesafety.setSafetyType("照明管理");
            break;
          default:
            onesafety.setSafetyType("其他");
            break;
        }
      }
      request.getSession().setAttribute("Safetys", safetys);
    }
    else {
      String page = request.getParameter("page");
      PagedListHelper.pageTo(safetys, page);
    }
    */
    return mapping.findForward("success");
  }

}