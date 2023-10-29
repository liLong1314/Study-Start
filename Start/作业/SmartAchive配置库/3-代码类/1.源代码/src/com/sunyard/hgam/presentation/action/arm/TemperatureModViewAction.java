package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.persistence.dao.iface.arm.TemperatureDao;
import com.sunyard.hgam.presentation.form.arm.TemperatureForm;
import com.sunyard.hgam.persistence.dao.beans.arm.Temperature;

/**
 * <p>Title: �鿴�޸���ʪ����Ϣ����</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author Ҷ�
 * @version 1.0
 */

public class TemperatureModViewAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    String temperatureId;
    temperatureId = request.getParameter("temperatureId");

    TemperatureDao temperatureDao = (TemperatureDao) domainLogic.getDAO("Temperature");

    Temperature temperatureInfo = null;
    temperatureInfo = temperatureDao.getTemperature(temperatureId);
    TemperatureForm modtemperatureForm = new TemperatureForm();
    if (temperatureInfo != null) {
      modtemperatureForm.setTemperatureInfo(temperatureInfo);
    }
    else {
      return mapping.findForward("Failed");
    }
    request.setAttribute("temperatureForm", modtemperatureForm);
    return mapping.findForward("success");

  }

}