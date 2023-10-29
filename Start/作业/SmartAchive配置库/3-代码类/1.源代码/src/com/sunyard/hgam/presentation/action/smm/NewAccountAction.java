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
 * <p>Description: ���������ϵ����ݽ��裨һ�ڣ����������û�������Ȩ</p>
 * <p>Copyright: Hangzhou Sunyard System Engineering�� Ltd. All rights reserved @2003</p>
 * <p>Company: </p>
 * @author xcf
 * @version 1.00
 */

public class NewAccountAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response)
  {
    String forwardString = "";
      AccountForm accountForm = (AccountForm) form;
      Account account = accountForm.getAccount();
      account.setUserName(account.getUserName().trim());
      account.setAccessTimes("0");
      account.setCreationDate(DateTimeKit.getCurrentDateTime());
      AccountDAO accountDAO = (AccountDAO) domainLogic.getDAO("Account");
      if (accountDAO.getAccountByUsername(account.getUserName()) == null)
      {
        accountDAO.insertAccount(accountForm.getAccount());
        String userID = accountDAO.getAccountByUsername(account.getUserName());

        //����û���Ĭ�Ͻ�ɫ
        GroupUserDao guDao = (GroupUserDao) domainLogic.getDAO("GroupUser");
        GroupUser gu = new GroupUser();
        gu.setUserID(userID);
        gu.setGroupID(account.getRoleID());
        gu.setOrgID(account.getOrgID());
        guDao.insertGU(gu);

        accountForm.setOperResults("�û�ע��ɹ���");
        forwardString = "success";
      }
      else
      {
        accountForm.setOperResults("���û��Ѿ����ڣ�");
        forwardString = "failure";
      }
    return mapping.findForward(forwardString);
  }
}