package com.sunyard.hgam.presentation.action.smm;

import java.util.*;
import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.smm.*;
import com.sunyard.hgam.persistence.dao.iface.smm.*;
import com.ibatis.db.dao.*;
import com.sunyard.hgam.persistence.dao.beans.smm.*;
import com.sunyard.hgam.util.common.*;

/**
 * <p>Title: Hang Zhou Net Archives</p>
 * <p>Description: 杭州市网上档案馆建设（一期）</p>
 * <p>Copyright: Hangzhou Sunyard System Engineering， Ltd. All rights reserved @2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 0.01
 */

public class ModifyAccountPermissionAction
    extends BaseAction
{
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response)
  {
    String forwardString = "success";
      String userID = (String)request.getParameter("userID");
      String flag = (String) request.getParameter("flag");
      String permissions = "";
      if (flag.equals("1")) {
        permissions = (String) request.getParameter("funPermissions");
        forwardString = "func";
      }
      else {
        permissions = (String) request.getParameter("dataPermissions");
        forwardString = "data";
      }
      Hashtable h = StringKit.getRightString(permissions,"|");
      String permID = "";
//      AccountDAO accountDAO = (AccountDAO) domainLogic.getDAO("Account");
      AccountPermission ap = new AccountPermission();
      ap.setUserID(userID);
      if (flag.equals("1"))
        ap.setPermType("1");
      else
        ap.setPermType("2");

      AccountPermissionDao apd = (AccountPermissionDao) domainLogic.getDAO(
          "AccountPermission");
      apd.deleteAllAP(ap);
      for(int i=0;i<h.size();i++)
      {
        ap.setPermID((String)h.get(Integer.toString(i)));
        if (flag.equals("1"))
          ap.setPermType("1");
        else
          ap.setPermType("2");
        apd.insertAP(ap);
      }
      AccountDAO accountDAO = (AccountDAO) domainLogic.getDAO("Account");
      Account account = new Account();
      account.setUserID(userID);
      account.setLastModifiedDate(DateTimeKit.getCurrentDateTime());
      accountDAO.updateAccountLMD(account);
    return mapping.findForward(forwardString);
  }
}