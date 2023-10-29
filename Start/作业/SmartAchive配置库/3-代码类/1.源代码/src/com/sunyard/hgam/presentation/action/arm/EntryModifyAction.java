package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.arm.EntryForm;
import com.sunyard.hgam.persistence.dao.iface.arm.EntryDao;

/**
 * <p>Title: 修改类目</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 叶昊
 * @version 1.0
 */

public class EntryModifyAction extends BaseAction {
  public EntryModifyAction() {
  }
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    String flag;
    flag = request.getParameter("flag");

    EntryForm entryForm=(EntryForm) form;
    EntryDao entryDao=(EntryDao) domainLogic.getDAO("Entry");
    if (flag.equalsIgnoreCase("1")) {
      entryDao.modifyEntry(entryForm.getEntryInfo());
      return mapping.findForward("FirstEntry");
    }
    else if (flag.equalsIgnoreCase("2")) {
      entryDao.modifyEntry(entryForm.getEntryInfo());
      return mapping.findForward("SecondEntry");
    }
    else {
      return mapping.findForward("unknown-error");
    }

  }

}