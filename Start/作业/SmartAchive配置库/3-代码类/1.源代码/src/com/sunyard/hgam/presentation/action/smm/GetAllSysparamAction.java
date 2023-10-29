package com.sunyard.hgam.presentation.action.smm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.persistence.dao.iface.smm.SysParamDao;
import com.ibatis.common.util.PaginatedList;

public class GetAllSysparamAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm actionForm,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    SysParamDao sysparamDao = (SysParamDao) domainLogic.getDAO("Sysparam");
    PaginatedList sysparamList = sysparamDao.getAllSysParam();
    request.setAttribute("sysparamList", sysparamList);
    return mapping.findForward("success");
  }
}