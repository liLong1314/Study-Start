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

public class ModifyGroupPermissionAction extends BaseAction
{
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.Exception
  {
    String forwardString = "success";
      String groupID = (String)request.getParameter("groupID");
      String flag = (String) request.getParameter("flag");
      String permissions = "";
      if (flag.equals("1")){
        permissions = (String) request.getParameter("funGPermissions");
        forwardString = "func";
      }
      else{
        permissions = (String) request.getParameter("dataGPermissions");
        forwardString = "data";
      }
      Hashtable h = StringKit.getRightString(permissions,"|");
      String permID = "";
      GroupPermission gp = new GroupPermission();
      gp.setGroupID(groupID);
      if (flag.equals("1"))
        gp.setPermType("1");
      else
        gp.setPermType("2");

      GroupPermissionDao gpd = (GroupPermissionDao) domainLogic.getDAO(
          "GroupPermission");
      gpd.deleteAllGP(gp);
      for(int i=0;i<h.size();i++)
      {
        gp.setPermID((String)h.get(Integer.toString(i)));
        if (flag.equals("1"))
          gp.setPermType("1");
        else
          gp.setPermType("2");
        gpd.insertGP(gp);
      }
      GroupDao groupDAO = (GroupDao) domainLogic.getDAO("Group");
      Group group = new Group();
      group.setGroupID(groupID);
      group.setModifiedDate(DateTimeKit.getCurrentDateTime());
      groupDAO.updateGroupMD(group);

    return mapping.findForward(forwardString);
  }

}