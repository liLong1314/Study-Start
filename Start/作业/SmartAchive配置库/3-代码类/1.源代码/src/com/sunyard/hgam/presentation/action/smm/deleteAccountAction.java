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

public class deleteAccountAction extends BaseAction
{
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response)
  {
    String forwardString = "success";
    String userID = (String) request.getParameter("userID");
    String[] userIDList = userID.split(",");
    AccountForm af = (AccountForm) form;
    int size = userIDList.length;
    for (int i = 0; i < size; i++) {
      String id = userIDList[i];
      if (!"0".equals(id)) {
        deleteOneAccount(id);
      }
      else {
        if (af.getAccount().getUserID() != null) {
          af.setOperResults("系统管理员不可删除！删除失败！");
          request.setAttribute("accountForm", af);
          forwardString = "failure";
        }
      }
    }
    return mapping.findForward(forwardString);
  }

  private int deleteOneAccount(String userID) {
    AccountDAO accountDAO = (AccountDAO) domainLogic.getDAO("Account");
    //删除用户表信息之前还要删除所有相关联的对应的信息，
    //如用户组用户关联表，用户权限关联表
    AccountPermissionDao apd = (AccountPermissionDao) domainLogic.getDAO(
        "AccountPermission");
    GroupUserDao gud = (GroupUserDao) domainLogic.getDAO("GroupUser");
    AccountPermission ap = new AccountPermission();
    ap.setUserID(userID);
    apd.deleteAllAP(ap);
    GroupUser gu = new GroupUser();
    gu.setUserID(userID);
    gud.deleteAllUG(gu);
    return accountDAO.deleteAccount(userID);
  }
}