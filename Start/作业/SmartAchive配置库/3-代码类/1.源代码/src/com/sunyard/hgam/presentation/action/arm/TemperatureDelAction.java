package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.persistence.dao.iface.arm.TemperatureDao;

/**
 * <p>Title:删除温湿度</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 叶昊
 * @version 1.0
 */

public class TemperatureDelAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    String temperatureId;
    temperatureId=request.getParameter("temperatureId");
    TemperatureDao temperatureDao=(TemperatureDao) domainLogic.getDAO("Temperature");
    temperatureDao.delTemperature(temperatureId);
    return mapping.findForward("success");

  }

}