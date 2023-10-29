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
 * <p>Description: ���������ϵ����ݽ��裨һ�ڣ�</p>
 * <p>Copyright: Hangzhou Sunyard System Engineering�� Ltd. All rights reserved @2003</p>
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
          af.setOperResults("ϵͳ����Ա����ɾ����ɾ��ʧ�ܣ�");
          request.setAttribute("accountForm", af);
          forwardString = "failure";
        }
      }
    }
    return mapping.findForward(forwardString);
  }

  private int deleteOneAccount(String userID) {
    AccountDAO accountDAO = (AccountDAO) domainLogic.getDAO("Account");
    //ɾ���û�����Ϣ֮ǰ��Ҫɾ������������Ķ�Ӧ����Ϣ��
    //���û����û��������û�Ȩ�޹�����
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