package com.sunyard.hgam.presentation.action.smm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.smm.*;
import com.sunyard.hgam.persistence.dao.iface.smm.*;
import com.ibatis.db.dao.*;
import com.sunyard.hgam.persistence.dao.beans.smm.*;

/**
 * <p>Title: Hang Zhou Net Archives</p>
 * <p>Description: 杭州市网上档案馆建设（一期）</p>
 * <p>Copyright: Hangzhou Sunyard System Engineering， Ltd. All rights reserved @2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 0.01
 */

public class DeleteOrgAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    String forwardString = "success";
    String orgID = (String) request.getParameter("ids");
    String[] orgIDList = orgID.split(",");
    int size = orgIDList.length;

    OrgDao orgDAO = (OrgDao) domainLogic.getDAO("Org");
    for (int i = 0; i < size; i++) {
      String id = orgIDList[i];
      if (orgDAO.getSubOrg(id).size() == 0) {
        orgDAO.deleteOrganization(id);
      }
      else {
        request.getSession().setAttribute("message", "提示：某些组织下有子组织，不能删除。请把所有子组织删除后 再删除该组织。");
      }
    }
    return mapping.findForward(forwardString);
  }
}