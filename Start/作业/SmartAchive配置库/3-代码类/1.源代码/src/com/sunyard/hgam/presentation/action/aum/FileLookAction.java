package com.sunyard.hgam.presentation.action.aum;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.iface.arm.FileOperDao;

/**
 * <p>Title: 综合查询－显示文件</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 叶昊
 * @version 1.0
 */

public class FileLookAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    String archiveId = request.getParameter("archiveId");
    String page = request.getParameter("page");
    PaginatedList fileOpers = (PaginatedList) request.getSession().getAttribute("FileOpers");

    //根据需要将档案ID保存到SESSION中
    if (archiveId != null && archiveId != "") {
      request.getSession().setAttribute("tmparchId", archiveId);
    }
    else {
      archiveId = request.getSession().getAttribute("tmparchId").toString();
    }

    //修订：郑先全，20040204，设置为可翻页
    if(page==null || fileOpers==null){
      FileOperDao fileOperDao = (FileOperDao) domainLogic.getDAO("FileOper");
      fileOpers = fileOperDao.getFiles(archiveId);
      request.getSession().setAttribute("FileOpers", fileOpers);
    }else{
      PagedListHelper.pageTo(fileOpers, page);
    }

    return mapping.findForward("success");
  }

}