package com.sunyard.hgam.presentation.action.aum;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.iface.arm.PageOperDao;

/**
 * <p>Title: �ۺϲ�ѯ����ʾҳ��</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author Ҷ�
 * @version 1.0
 */

public class PageLookAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    String fileId=request.getParameter("fileId");
    PaginatedList pageOpers=(PaginatedList) request.getAttribute("PageOpers");
    //������Ҫ���ļ�ID���浽SESSION��
    if (fileId != null && fileId != "") {
      request.getSession().setAttribute("tmpfileId", fileId);
    }
    else {
      fileId = request.getSession().getAttribute("tmpfileId").toString();
    }

    if(pageOpers==null){
      PageOperDao pageOperDao=(PageOperDao) domainLogic.getDAO("PageOper");
      pageOpers=pageOperDao.getPages(fileId);
      request.getSession().setAttribute("PageOpers",pageOpers);
    }
    else{
      String page=request.getParameter("page");
      PagedListHelper.pageTo(pageOpers,page);
    }

    return mapping.findForward("success");

  }

}