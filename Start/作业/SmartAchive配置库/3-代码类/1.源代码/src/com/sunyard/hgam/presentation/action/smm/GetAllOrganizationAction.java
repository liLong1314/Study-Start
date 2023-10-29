package com.sunyard.hgam.presentation.action.smm;

import java.util.*;
import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.smm.*;
import com.sunyard.hgam.persistence.dao.iface.smm.*;
import com.sunyard.hgam.persistence.dao.beans.smm.*;
import com.ibatis.common.util.*;
import com.sunyard.hgam.util.common.*;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

/**
 * <p>Title: Hang Zhou Net Archives</p>
 * <p>Description: 杭州市网上档案馆建设（一期）</p>
 * <p>Copyright: Hangzhou Sunyard System Engineering， Ltd. All rights reserved @2003</p>
 * <p>Company: </p>
 */

public class GetAllOrganizationAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws
      NoSuchMethodException, InvocationTargetException, InstantiationException,
      IllegalAccessException {
    String forwardString = "";
    String flag = (String) request.getParameter("flag");
    OrgForm orgForm = (OrgForm) form;
    Organization org = null;

    if (flag != null && flag.equals("1"))
      org = (Organization) request.getSession().getAttribute("queryConditionOrg");
    else {
      org = (Organization) BeanUtils.cloneBean( (orgForm.getOrg()));
      org.setName(UtilKit.addFuzzy(org.getName()));
    }

    String page = request.getParameter("page");
    PaginatedList orgs = (PaginatedList) request.getSession().getAttribute("allOrgList");
    if (page != null && page.length() > 0 && orgs != null) {
      PagedListHelper.pageTo(orgs, page);
    }
    else {
      OrgDao orgDAO = (OrgDao) domainLogic.getDAO("Org");
      orgs = orgDAO.searchOrg(org);
      request.getSession().setAttribute("allOrgList", orgs);
      request.getSession().setAttribute("queryConditionOrg", org);
    }
    forwardString = "success";
    return mapping.findForward(forwardString);
  }
}