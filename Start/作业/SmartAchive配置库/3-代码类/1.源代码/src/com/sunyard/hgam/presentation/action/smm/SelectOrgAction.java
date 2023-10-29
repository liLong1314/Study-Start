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

public class SelectOrgAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {

    String forwardString = "success";
    PaginatedList selectOrgs = (PaginatedList) request.getSession().getAttribute("selectOrg");
    if (selectOrgs == null) {
      OrgDao orgDAO = (OrgDao) domainLogic.getDAO("Org");
      selectOrgs = orgDAO.getAllOrg();
      request.getSession().setAttribute("selectOrg", selectOrgs);
      forwardString = "success";
    }

    String page = request.getParameter("page");
    PagedListHelper.pageTo(selectOrgs, page);

    return mapping.findForward(forwardString);

  }
}