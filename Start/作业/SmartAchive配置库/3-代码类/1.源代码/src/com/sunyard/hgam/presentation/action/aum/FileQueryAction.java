package com.sunyard.hgam.presentation.action.aum;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.iface.arm.FileOperDao;
import com.sunyard.hgam.presentation.form.arm.FileOperForm;

/**
 * <p>Title: 综合查询－查询文件</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 叶昊
 * @version 1.0
 */

public class FileQueryAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    FileOperForm fileOperForm=(FileOperForm) form;
    PaginatedList fileOpers = (PaginatedList) request.getSession().getAttribute("FileOpers");

    if (fileOpers == null) {
      FileOperDao fileOperDao = (FileOperDao) domainLogic.getDAO("FileOper");
      fileOpers = fileOperDao.queryFiles(fileOperForm.getFileOperInfo());
      request.getSession().setAttribute("FileOpers", fileOpers);
    }
    else {
      String page = request.getParameter("page");
      PagedListHelper.pageTo(fileOpers, page);
    }

    return mapping.findForward("success");

  }

}