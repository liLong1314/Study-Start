package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.iface.arm.FileOperDao;

/**
 * <p>Title: 查看文件列表</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 叶昊
 * @version 1.0
 */

public class FileViewAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    int flag = Integer.parseInt(request.getParameter("flag"));
    String archiveId = request.getParameter("archiveId");
    PaginatedList fileOpers = (PaginatedList) request.getAttribute("FileOpers");

    //根据需要将档案ID保存到SESSION中
    if (archiveId != null && archiveId != "") {
      request.getSession().setAttribute("tmparchId", archiveId);
    }
    else{
      archiveId=request.getSession().getAttribute("tmparchId").toString();
    }

    switch (flag) {
      case 1: //档案校验
        if (fileOpers == null) {
          FileOperDao fileOperDao = (FileOperDao) domainLogic.getDAO("FileOper");
          fileOpers = fileOperDao.getFiles(archiveId);
          request.getSession().setAttribute("FileOpers", fileOpers);
        }
        else {
          String page = request.getParameter("page");
          PagedListHelper.pageTo(fileOpers, page);
        }
        return mapping.findForward("ArchVerify");
      case 2: //鉴定管理
        if (fileOpers == null) {
          FileOperDao fileOperDao = (FileOperDao) domainLogic.getDAO("FileOper");
          fileOpers = fileOperDao.getIdentFiles(archiveId);
          request.getSession().setAttribute("FileOpers", fileOpers);
        }
        else {
          String page = request.getParameter("page");
          PagedListHelper.pageTo(fileOpers, page);
        }
        return mapping.findForward("ArchIdentify");
      case 3: //销毁管理
        if (fileOpers == null) {
          FileOperDao fileOperDao = (FileOperDao) domainLogic.getDAO("FileOper");
          fileOpers = fileOperDao.getDestroyFiles(archiveId);
          request.getSession().setAttribute("FileOpers", fileOpers);
        }
        else {
          String page = request.getParameter("page");
          PagedListHelper.pageTo(fileOpers, page);
        }
        return mapping.findForward("ArchDestroy");
      default:
        return mapping.findForward("unknown-error");
    }
  }

}