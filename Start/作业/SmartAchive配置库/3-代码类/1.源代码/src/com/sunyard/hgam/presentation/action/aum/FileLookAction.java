package com.sunyard.hgam.presentation.action.aum;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.iface.arm.FileOperDao;

/**
 * <p>Title: �ۺϲ�ѯ����ʾ�ļ�</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author Ҷ�
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

    //������Ҫ������ID���浽SESSION��
    if (archiveId != null && archiveId != "") {
      request.getSession().setAttribute("tmparchId", archiveId);
    }
    else {
      archiveId = request.getSession().getAttribute("tmparchId").toString();
    }

    //�޶���֣��ȫ��20040204������Ϊ�ɷ�ҳ
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