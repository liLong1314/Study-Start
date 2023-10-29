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
 */

public class GetAllAccountAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    String forwardString = "";
    String flag = (String) request.getParameter("flag");
    AccountForm accountForm = (AccountForm) form;
    Account account = null;
    if (flag == null)
      account = accountForm.getAccount();
    else if (flag.equals("1"))
      account = (Account) request.getSession().getAttribute(
          "queryConditionAccount");
    else
      account = accountForm.getAccount();

    String page = request.getParameter("page");
    PaginatedList accounts = (PaginatedList) request.getSession().getAttribute(
        "allAccountList");
    if (page != null && page.length() > 0 && accounts != null) {
      PagedListHelper.pageTo(accounts, page);
    }
    else {
      AccountDAO accountDAO = (AccountDAO) domainLogic.getDAO("Account");
      accounts = accountDAO.getAllAccount(account);
      request.getSession().setAttribute("allAccountList", accounts);
      request.getSession().setAttribute("queryConditionAccount", account);
    }
    forwardString = "success";
    return mapping.findForward(forwardString);
  }
}