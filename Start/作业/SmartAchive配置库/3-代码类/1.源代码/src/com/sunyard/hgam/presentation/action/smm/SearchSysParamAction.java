package com.sunyard.hgam.presentation.action.smm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.persistence.dao.iface.smm.SysParamDao;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.presentation.form.smm.SysParamForm;
import com.sunyard.hgam.persistence.dao.beans.smm.SysParam;
import com.sunyard.hgam.util.common.*;
import org.apache.commons.beanutils.BeanUtils;

/**
 * <p>Title: 显示所有的参数信息</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 华良东
 * @version 1.0
 */

public class SearchSysParamAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.
      Exception {
    PaginatedList sysParams = (PaginatedList) request.getSession().getAttribute("SysParams");
    String isSearch = request.getParameter("search");
    if (isSearch != null && isSearch.equalsIgnoreCase("true")) {
      SysParamForm sysParamForm = (SysParamForm) form;
      SysParam sysParam = (SysParam) BeanUtils.cloneBean(sysParamForm.
          getSysParamInfo());
      sysParam.setSysParamType(UtilKit.addFuzzy(sysParam.getSysParamType()));
      sysParam.setSysParamName(UtilKit.addFuzzy(sysParam.getSysParamName()));
      sysParam.setSysParamValue(UtilKit.addFuzzy(sysParam.getSysParamValue()));

      SysParamDao sysParamDao = (SysParamDao) domainLogic.getDAO("SysParam");

      request.getSession().setAttribute("SysParams",
                                        sysParamDao.searchSysParam(sysParam));
    }
    else {
      String page = request.getParameter("page");
      PagedListHelper.pageTo(sysParams, page);
    }
    return mapping.findForward("success");
  }
}