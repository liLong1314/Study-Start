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

public class ViewAccountAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    String forwardString = "";
    boolean flag = false;
    List defaultFunPermissions = new ArrayList();
    List defaultDataPermissions = new ArrayList();
    List funPermissions = new ArrayList();
    List dataPermissions = new ArrayList();
    Account account = null;
    String userID = "";
    String flag1 = (String) request.getParameter("flag");
    if (flag1 != null) {
      if (flag1.equals("1"))
        userID = (String) request.getSession().getAttribute("userID");
    }
    else
      userID = (String) request.getParameter("userID");
    AccountDAO accountDAO = (AccountDAO) domainLogic.getDAO("Account");
    account = accountDAO.getAccountByUserID(userID);
    //获取用户组织信息
    GroupUserDao guDao = (GroupUserDao) domainLogic.getDAO("GroupUser");
    String orgId = guDao.getOrgIDByUserID(userID);
    OrgDao orgDao = (OrgDao) domainLogic.getDAO("Org");
    //修订（郑先全，20040216）：作出NULL判断处理
    if (orgId!=null) {
      account.setOrgID(orgId);
      account.setOrgName(orgDao.getOrgNameByID(account.getOrgID()));
    }

    AccountPermissionDao apd = (AccountPermissionDao) domainLogic.getDAO(
        "AccountPermission");
    PermissionDao pd = (PermissionDao) domainLogic.getDAO("Permission");
    List aps = apd.getPermissionByUserID(userID);
    Permission tp = new Permission();
    tp.setPermType("1");
    defaultFunPermissions = pd.getAllPermissionByType(tp);
    tp.setPermType("2");
    defaultDataPermissions = pd.getAllPermissionByType(tp);

    if (aps != null) {
      if (aps.size() > 0) {
        for (int i = 0; i < aps.size(); i++) {
          AccountPermission ap = (AccountPermission) aps.get(i);
          String permID = ap.getPermID();
          List list = pd.getPermissionByCode(permID);
          Permission p = (Permission) list.get(0);

          if (p.getPermType().equals("1")) {
            funPermissions.add(p);
            for (int j = 0; j < defaultFunPermissions.size(); j++) {
              Permission rfp = (Permission) defaultFunPermissions.get(j);
              if (rfp.getPermID().equals(p.getPermID())) {
                defaultFunPermissions.remove(j);
                break;
              }
            }
          }
          else {
            dataPermissions.add(p);
            for (int k = 0; k < defaultDataPermissions.size(); k++) {
              Permission rdp = (Permission) defaultDataPermissions.get(k);
              if (rdp.getPermID().equals(p.getPermID())) {
                defaultDataPermissions.remove(k);
                break;
              }
            }
          }
        }
      }
    }
    flag = true;

    if (flag) {
      AccountForm af = new AccountForm();
      af.setAccount(account);
      request.getSession().setAttribute("userID", userID);
      request.setAttribute("accountForm", af);

      request.getSession().setAttribute("funPermissions", funPermissions);

      request.getSession().setAttribute("dataPermissions", dataPermissions);

      request.getSession().setAttribute("defaultFunPermissions",
                                        defaultFunPermissions);

      request.getSession().setAttribute("defaultDataPermissions",
                                        defaultDataPermissions);
      forwardString = "success";
      String target = request.getParameter("target");
      if (target != null && target.length() > 0) {
        forwardString = target;
      }
    }
    else {
      forwardString = "failure";
    }
    return mapping.findForward(forwardString);
  }

}