package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.persistence.dao.iface.arm.EntryDao;

/**
 * <p>Title: HGAM</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author not attributable
 * @version 1.0
 */

public class EntryDelAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    String flag;
    String entryId;
    flag = request.getParameter("flag");
    entryId = request.getParameter("entryId");
    String strForwardTo = "";

    EntryDao entryDao=(EntryDao) domainLogic.getDAO("Entry");

    if(flag.equalsIgnoreCase("1")){
      entryDao.delEntryForFirstLvl(entryId);
      strForwardTo = "FirstEntry";
    }
    else if(flag.equalsIgnoreCase("2")){
      entryDao.delEntry(entryId);
      strForwardTo = "SecondEntry";
    }

    return mapping.findForward(strForwardTo);
  }
}