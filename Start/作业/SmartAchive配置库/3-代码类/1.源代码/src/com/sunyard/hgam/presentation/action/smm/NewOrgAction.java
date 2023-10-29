package com.sunyard.hgam.presentation.action.smm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.smm.*;
import com.sunyard.hgam.persistence.dao.iface.smm.*;
import com.sunyard.hgam.persistence.dao.beans.smm.*;
import com.sunyard.hgam.util.common.*;

/**
 * <p>Title: Hang Zhou Net Archives</p>
 * <p>Description: 杭州市网上档案馆建设（一期）</p>
 * <p>Copyright: Hangzhou Sunyard System Engineering， Ltd. All rights reserved @2003</p>
 * <p>Company: </p>
 * @author xcf
 * @version 1.00
 */

public class NewOrgAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response)
  {
    String forwardString = "";
      OrgForm orgForm = (OrgForm) form;
      Organization org = orgForm.getOrg();

      OrgDao orgDao = (OrgDao) domainLogic.getDAO("Org");
      if (orgDao.getOrgIDByName(org.getName()) == null)
      {
        orgDao.insertOrganization(org);
        orgForm.setOperResults("新建组织成功！");
        forwardString = "success";
      }
      else
      {
        orgForm.setOperResults("该组织已经存在！");
        forwardString = "failure";
      }
    return mapping.findForward(forwardString);
  }
}