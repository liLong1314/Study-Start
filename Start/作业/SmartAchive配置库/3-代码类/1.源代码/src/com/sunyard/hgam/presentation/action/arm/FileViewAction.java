package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.iface.arm.FileOperDao;

/**
 * <p>Title: �鿴�ļ��б�</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author Ҷ�
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

    //������Ҫ������ID���浽SESSION��
    if (archiveId != null && archiveId != "") {
      request.getSession().setAttribute("tmparchId", archiveId);
    }
    else{
      archiveId=request.getSession().getAttribute("tmparchId").toString();
    }

    switch (flag) {
      case 1: //����У��
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
      case 2: //��������
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
      case 3: //���ٹ���
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