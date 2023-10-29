package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.iface.arm.TemperatureDao;

/**
 * <p>Title: 显示所有温湿度记录</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 叶昊
 * @version 1.0
 */

public class TemperatureViewAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    /*
    PaginatedList temperatures = (PaginatedList) request.getAttribute("Temperatures");
    if (temperatures == null) {
      TemperatureDao temperatureDao = (TemperatureDao) domainLogic.getDAO("Temperature");
      request.getSession().setAttribute("Temperatures", temperatureDao.getAllTemperature());
    } else {
      String page = request.getParameter("page");
      PagedListHelper.pageTo(temperatures, page);
    }
    */
    return mapping.findForward("success");

  }

}