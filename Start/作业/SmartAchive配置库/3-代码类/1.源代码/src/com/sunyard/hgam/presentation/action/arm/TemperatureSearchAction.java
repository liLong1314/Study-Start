package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.iface.arm.TemperatureDao;
import com.sunyard.hgam.presentation.form.arm.TemperatureForm;

/**
 * <p>Title: ��ʪ�Ȳ�ѯ</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author Ҷ�
 * @version 1.0
 */

public class TemperatureSearchAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    TemperatureForm temperatureForm = (TemperatureForm) form;
    String flag = request.getParameter("flag");
    PaginatedList temperatures = (PaginatedList) request.getSession().
        getAttribute("Temperatures");
    if (temperatures == null || "first".equalsIgnoreCase(flag)) {
      TemperatureDao temperatureDao = (TemperatureDao) domainLogic.getDAO(
          "Temperature");
      request.getSession().setAttribute("Temperatures",
                                        temperatureDao.
                                        searchTemperature(temperatureForm.
          getTemperatureInfo()));
    }
    else {
      String page = request.getParameter("page");
      PagedListHelper.pageTo(temperatures, page);
    }

    return mapping.findForward("success");
  }

}