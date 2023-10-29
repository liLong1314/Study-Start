package com.sunyard.hgam.presentation.action.smm;

import java.util.*;
import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.smm.*;
import com.sunyard.hgam.persistence.dao.iface.smm.*;
import com.sunyard.hgam.persistence.dao.beans.smm.*;
import com.sunyard.hgam.util.common.*;
import com.ibatis.common.util.*;

/**
 * <p>Title: Hang Zhou Net Archives</p>
 * <p>Description: ���������ϵ����ݽ��裨һ�ڣ�</p>
 * <p>Copyright: Hangzhou Sunyard System Engineering�� Ltd. All rights reserved @2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 0.01
 */

public class ViewGroupAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    String forwardString = "";
    boolean flag = false;
    List defaultFunPermissions = new ArrayList();
    List defaultDataPermissions = new ArrayList();
    List funPermissions = new ArrayList();
    List dataPermissions = new ArrayList();
    List defaultUsers = new ArrayList();
    List users = new ArrayList();
    Group group = null;
    Account account = null;
    String groupID = "";
    String flag1 = (String) request.getParameter("flag");
    if (flag1 != null) {
      if (flag1.equals("1"))
        groupID = (String) request.getSession().getAttribute("groupID");
    }
    else
      groupID = (String) request.getParameter("groupID");
    GroupDao groupDAO = (GroupDao) domainLogic.getDAO("Group");
    group = groupDAO.getGroupByGroupID(groupID);
    AccountDAO accountDao = (AccountDAO) domainLogic.getDAO("Account");
    //��ȡϵͳ�������û�
    defaultUsers = accountDao.getAccounts();
    GroupUserDao gud = (GroupUserDao) domainLogic.getDAO("GroupUser");
    GroupUser gu = new GroupUser();
    gu.setGroupID(groupID);
    //��ȡ���û����µ������û�ID
    List gus = gud.getUserIDBygroupID(gu);
    //�����û��������û���δ�����û�����
    if (gus != null)
      if (gus.size() > 0) {
        for (int i = 0; i < gus.size(); i++) {
          GroupUser tgu = (GroupUser) gus.get(i);
          String userID = tgu.getUserID();
          Account user = accountDao.getAccountByUserID(userID);
          users.add(user);
          for (int j = 0; j < defaultUsers.size(); j++) {
            Account ru = (Account) defaultUsers.get(j);
            if (ru.getUserID().equals(user.getUserID())) {
              defaultUsers.remove(j);
              break;
            }
          }
        }
      }
    GroupPermissionDao gpd = (GroupPermissionDao) domainLogic.getDAO(
        "GroupPermission");
    PermissionDao pd = (PermissionDao) domainLogic.getDAO("Permission");
    //ͨ��groupID��ȡ���û�������Ȩ���б�
    List gps = gpd.getPermissionBygroupID(groupID);
    Permission tp = new Permission();
    //��ȡ����Ĭ�Ϲ��ܲ˵�Ȩ��
    tp.setPermType("1");
    defaultFunPermissions = pd.getAllPermissionByType(tp);
    //��ȡ����Ĭ�����ݲ���Ȩ��
    tp.setPermType("2");
    defaultDataPermissions = pd.getAllPermissionByType(tp);
    //������Ȩ�޺�δ��Ȩ�޷���
    if (gps != null) {
      if (gps.size() > 0) {
        for (int i = 0; i < gps.size(); i++) {
          GroupPermission gp = (GroupPermission) gps.get(i);
          String permID = gp.getPermID();
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
      GroupForm af = new GroupForm();
      af.setGroup(group);
      request.getSession().setAttribute("groupID", groupID);
      request.setAttribute("groupForm", af);
      request.getSession().setAttribute("defaultUsers", defaultUsers);
      request.getSession().setAttribute("users", users);
      request.getSession().setAttribute("funGPermissions", funPermissions);
      request.getSession().setAttribute("dataGPermissions", dataPermissions);
      request.getSession().setAttribute("defaultGFunPermissions",
                                        defaultFunPermissions);
      request.getSession().setAttribute("defaultGDataPermissions",
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