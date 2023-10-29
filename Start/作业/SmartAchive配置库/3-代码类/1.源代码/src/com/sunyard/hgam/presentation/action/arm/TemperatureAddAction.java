package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.arm.TemperatureForm;
import com.sunyard.hgam.persistence.dao.iface.arm.TemperatureDao;

/**
 * <p>Title: 增加温湿度</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 叶昊
 * @version 1.0
 */

public class TemperatureAddAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    TemperatureForm temperatureForm = (TemperatureForm) form;
    TemperatureDao temperatureDao = (TemperatureDao) domainLogic.getDAO("Temperature");
    temperatureDao.addTemperature(temperatureForm.getTemperatureInfo());
    return mapping.findForward("success");

  }

}