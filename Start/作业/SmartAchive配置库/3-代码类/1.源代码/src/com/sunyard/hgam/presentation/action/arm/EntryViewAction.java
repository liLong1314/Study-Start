package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.iface.arm.EntryDao;
import java.util.List;
import com.sunyard.hgam.persistence.dao.beans.arm.Entry;

/**
 * <p>Title: �鿴��Ŀ</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author Ҷ�
 * @version 1.0
 */

public class EntryViewAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    String flag;
    String entryId;
    flag = request.getParameter("flag");
    entryId = request.getParameter("entryId");
    if (request.getSession().getAttribute("fatherEntryId") != null &&
        request.getSession().getAttribute("fatherEntryId") != "") {
      entryId = request.getSession().getAttribute("fatherEntryId").toString();
      request.getSession().removeAttribute("fatherEntryId");
    }
    List entrys = null;
    List secondentrys = null;
    if (flag.equalsIgnoreCase("1")) {
      //һ����Ŀ
      EntryDao entryDao = (EntryDao) domainLogic.getDAO("Entry");
      request.getSession().setAttribute("Entrys", entryDao.getFirstEntry());
      return mapping.findForward("FirstEntry");
    }
    else if (flag.equalsIgnoreCase("2")) {
      //������Ŀ
      EntryDao entryDao = (EntryDao) domainLogic.getDAO("Entry");

      //ȡ�ø���Ŀ����Ŀ���Ͳ�����SESSION��
      String entryType = ((Entry)entryDao.getEntry(entryId)).getIsOperation();
      request.getSession().setAttribute("entryType", entryType);

      request.getSession().setAttribute("SecondEntrys",
                                        entryDao.getSecondEntry(entryId));
      request.getSession().setAttribute("fatherEntryId", entryId);
      return mapping.findForward("SecondEntry");
    }
    else {
      return mapping.findForward("unknown-error");
    }
  }
}