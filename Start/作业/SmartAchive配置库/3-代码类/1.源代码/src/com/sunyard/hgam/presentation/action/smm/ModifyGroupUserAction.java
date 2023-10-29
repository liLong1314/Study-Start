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

public class ModifyGroupUserAction extends BaseAction
{
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.Exception
  {
    String forwardString = "";
      String groupID = (String)request.getParameter("groupID");
      String users = "";
      users=(String)request.getParameter("users");
      Hashtable h = StringKit.getRightString(users,"|");
      String userID = "";
//      GroupDAO groupDAO = (GroupDAO) domainLogic.getDAO("Group");
      GroupUser gu = new GroupUser();
      gu.setGroupID(groupID);
      GroupUserDao gud = (GroupUserDao) domainLogic.getDAO(
          "GroupUser");
      gud.deleteAllGU(gu);
      for(int i=0;i<h.size();i++)
      {
        gu.setUserID((String)h.get(Integer.toString(i)));
        gud.insertGU(gu);
      }
      GroupDao groupDAO = (GroupDao) domainLogic.getDAO("Group");
      Group group = new Group();
      group.setGroupID(groupID);
      group.setModifiedDate(DateTimeKit.getCurrentDateTime());
      groupDAO.updateGroupMD(group);
      forwardString = "success";
    return mapping.findForward(forwardString);
  }

}