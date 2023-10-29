package com.sunyard.hgam.presentation.action.smm;

import java.util.*;
import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.smm.*;
import com.sunyard.hgam.persistence.dao.iface.smm.*;
import com.sunyard.hgam.persistence.dao.beans.smm.*;
import com.ibatis.common.util.*;

/**
 * <p>Title: Hang Zhou Net Archives</p>
 * <p>Description: 杭州市网上档案馆建设（一期）</p>
 * <p>Copyright: Hangzhou Sunyard System Engineering， Ltd. All rights reserved @2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 0.01
 */

public class GetGroupsAction
    extends BaseAction {
  public GetGroupsAction() {
  }

  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    String forwardString = "";
    String flag = (String) request.getParameter("flag");
    GroupForm groupForm = (GroupForm) form;
    Group group = null;
    if (flag == null)
      group = groupForm.getGroup();
    else if (flag.equals("1"))
      group = (Group) request.getSession().getAttribute("queryConditionGroup");
    else
      group = groupForm.getGroup();

    String page = request.getParameter("page");
    PaginatedList groups = (PaginatedList) request.getSession().getAttribute(
        "allGroupList");
    if (page != null && page.length() > 0 && groups != null) {
      PagedListHelper.pageTo(groups, page);
    }
    else {
      GroupDao groupDao = (GroupDao) domainLogic.getDAO("Group");
      groups = groupDao.getGroups(group);
      request.getSession().setAttribute("allGroupList", groups);
      request.getSession().setAttribute("queryConditionGroup", group);
    }
    forwardString = "success";
    return mapping.findForward(forwardString);
  }
}