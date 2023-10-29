package com.sunyard.hgam.presentation.action.smm;

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

public class ModifyAccountAction
    extends BaseAction
{
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response)
  {
    String forwardString = "";
    AccountForm af = (AccountForm) form;
    AccountDAO accountDAO = (AccountDAO) domainLogic.getDAO("Account");
    Account account = af.getAccount();
    account.setLastModifiedDate(DateTimeKit.getCurrentDateTime());
    accountDAO.updateAccountLMD(account);
    //修改用户所在组织
    GroupUserDao guDao = (GroupUserDao) domainLogic.getDAO("GroupUser");
    GroupUser gu = new GroupUser();
    gu.setUserID(account.getUserID());
    gu.setOrgID(account.getOrgID());
    guDao.updateUserOrgID(gu);

    af.setAccount(account);
    af.setOperResults("成功修改用户信息！");
    forwardString = "success";
    request.setAttribute("accountForm", af);
    return mapping.findForward(forwardString);
  }
}