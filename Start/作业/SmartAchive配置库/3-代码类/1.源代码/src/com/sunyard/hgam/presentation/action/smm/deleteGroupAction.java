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

public class deleteGroupAction
    extends BaseAction {
  public deleteGroupAction() {
  }

  public ActionForward doPerform(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    String forwardString = "success";
    String groupID = (String) request.getParameter("groupID");
    String[] groupIDList = groupID.split(",");
    GroupForm gf = (GroupForm) form;
    int size = groupIDList.length;
    int count = 0;
    for (int i = 0; i < size; i++) {
      String id = groupIDList[i];
      deleteOneGroup(id);
      count++;
    }

    if (count < size) {
      forwardString = "failure";
      if (gf.getGroup().getGroupID() != null) {
        gf.setOperResults("用户组删除失败");
        request.setAttribute("groupForm", gf);
      }
    }

    return mapping.findForward(forwardString);
  }

  private int deleteOneGroup(String groupID) {
    GroupDao groupDAO = (GroupDao) domainLogic.getDAO("Group");
    GroupPermissionDao gpd = (GroupPermissionDao) domainLogic.getDAO(
        "GroupPermission");
    GroupUserDao gud = (GroupUserDao) domainLogic.getDAO("GroupUser");

    GroupPermission gp = new GroupPermission();
    gp.setGroupID(groupID);
    gpd.deleteAllGP(gp);
    GroupUser gu = new GroupUser();
    gu.setGroupID(groupID);
    gud.deleteAllGU(gu);
    return groupDAO.deleteGroup(groupID);
  }

}