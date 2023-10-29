package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.persistence.dao.beans.arm.ArchOper;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.iface.arm.ArchOperDao;
import com.sunyard.hgam.presentation.form.arm.ArchOperForm;

/**
 * <p>Title: 查看档案的各变更版本</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 叶昊
 * @version 1.0
 */

public class ArchChangeStatAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    String archiveId=request.getParameter("archiveId");
    PaginatedList archChanges=(PaginatedList) request.getAttribute("ArchChanges");

    //从SESSION中取得档案ID值
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