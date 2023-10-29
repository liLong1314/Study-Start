package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.persistence.dao.iface.arm.EntryDao;
import com.sunyard.hgam.presentation.form.arm.EntryForm;
import com.sunyard.hgam.persistence.dao.beans.arm.Entry;

/**
 * <p>Title: 查看修改类目页面</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author not attributable
 * @version 1.0
 */

public class EntryModViewAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    String flag;
    String entryId;
    flag = request.getParameter("flag");
    entryId = request.getParameter("entryId");

    EntryDao entryDao = (EntryDao) domainLogic.getDAO("Entry");

    Entry entryInfo = null;
    entryInfo = entryDao.getEntry(entryId);
    EntryForm modentryForm = new EntryForm();

    if (flag.equalsIgnoreCase("1")) {
      if (entryInfo != null) {
        modentryForm.setEntryInfo(entryInfo);
        request.setAttribute("entryForm",modentryForm);
        return mapping.findForward("FirstEntry");
      }
      else {
        return mapping.findForward("Failed");
      }

    }
    else if (flag.equalsIgnoreCase("2")) {
      if (entryInfo != null) {
        modentryForm.setEntryInfo(entryInfo);
        request.setAttribute("entryForm",modentryForm);
        return mapping.findForward("SecondEntry");
      }
      else {
        return mapping.findForward("Failed");
      }

    }
    else {
      return mapping.findForward("unknown-error");
    }

  }

}