package com.sunyard.hgam.presentation.action.smm;

import java.util.*;
import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.smm.*;
import com.sunyard.hgam.persistence.dao.iface.smm.*;
import com.sunyard.hgam.persistence.dao.beans.smm.*;
import com.ibatis.common.util.*;
import com.sunyard.hgam.util.common.UtilKit;

/**
 * <p>Title: Hang Zhou Net Archives</p>
 * <p>Description: 杭州市网上档案馆建设（一期）</p>
 * <p>Copyright: Hangzhou Sunyard System Engineering， Ltd. All rights reserved @2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 0.01
 */

public class ViewOrgAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {

    String forwardString = "";
    String firstView = request.getParameter("first");
    PaginatedList subOrgs = (PaginatedList) request.getSession().getAttribute("subOrg");
    if (firstView != null && firstView.equalsIgnoreCase("true")) {
      String orgId = request.getParameter("orgid");
      if (orgId == null) {
        orgId = (String) request.getSession().getAttribute("ORGID");
        request.getSession().removeAttribute("ORGID");
      }
      OrgDao orgDAO = (OrgDao) domainLogic.getDAO("Org");
      Organization org = orgDAO.getOrgByID(orgId);
      subOrgs = orgDAO.getSubOrg(orgId);
      request.getSession().setAttribute("oneOrg", org);
      request.getSession().setAttribute("subOrg", subOrgs);
      forwardString = "success";
    }

    String page = request.getParameter("page");
    PagedListHelper.pageTo(subOrgs, page);

    return mapping.findForward(forwardString);

  }
}