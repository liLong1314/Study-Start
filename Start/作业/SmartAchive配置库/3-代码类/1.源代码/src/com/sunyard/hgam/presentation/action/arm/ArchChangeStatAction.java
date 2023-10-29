package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.persistence.dao.beans.arm.ArchOper;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.iface.arm.ArchOperDao;
import com.sunyard.hgam.presentation.form.arm.ArchOperForm;

/**
 * <p>Title: �鿴�����ĸ�����汾</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author Ҷ�
 * @version 1.0
 */

public class ArchChangeStatAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    String archiveId=request.getParameter("archiveId");
    PaginatedList archChanges=(PaginatedList) request.getAttribute("ArchChanges");

    //��SESSION��ȡ�õ���IDֵ
    if (archiveId == null || archiveId == "") {
      archiveId=request.getSession().getAttribute("tmparchiveId").toString();
      request.getSession().removeAttribute("tmparchiveId");
    }

    if(archChanges==null){
      ArchOperDao archOperDao=(ArchOperDao) domainLogic.getDAO("ArchOper");
      archChanges=archOperDao.getChangedArchives(archiveId);
      request.setAttribute("ArchChanges",archChanges);
    }
    else{
      String page=request.getParameter("page");
      PagedListHelper.pageTo(archChanges,page);
    }
    return mapping.findForward("success");
  }

}