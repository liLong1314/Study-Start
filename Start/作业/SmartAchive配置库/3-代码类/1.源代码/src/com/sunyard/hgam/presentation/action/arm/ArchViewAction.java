package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.iface.arm.ArchOperDao;

/**
 * <p>Title: ������Դ�����鿴����</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author Ҷ�
 * @version 1.0
 */

public class ArchViewAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    //ENTRY_ID=15&ISOPERATION=1&ENTRY_LEVEL=2&flag=2
    //�޶���֣��ȫ��20040212�������Ʊ��룬��ʵ�ַ�ҳ
    String strFlag = request.getParameter("flag");
    String entryId=request.getParameter("ENTRY_ID");

    if (strFlag == null || strFlag.equalsIgnoreCase("")) {
      strFlag = (String) request.getSession().getAttribute("flag");
    }
    if (entryId == null || entryId.equalsIgnoreCase("")) {
      entryId = (String) request.getSession().getAttribute("tmpEntryId");
    }

    //�������Ƚ�����û��Ҫȡ�����棨֣��ȫ��0217��
    PaginatedList archOpers= null;
    //PaginatedList archOpers=(PaginatedList) request.getSession().getAttribute("ArchOpers");

    //
    request.getSession().setAttribute("flag",strFlag);
    request.getSession().setAttribute("tmpEntryId",entryId);

    int flag=Integer.parseInt(strFlag);
    if(archOpers==null || strFlag==null || strFlag.equals("")){
      ArchOperDao archOperDao=(ArchOperDao) domainLogic.getDAO("ArchOper");
      //archOpers=archOperDao.getArchOper(entryId);
      switch(flag){
        case 1://����У��
          archOpers=archOperDao.getArchOper(entryId);
          break;
        case 2://��������
          archOpers=archOperDao.getArchOper(entryId);
          break;
        case 3://���ٹ���
          archOpers=archOperDao.getArchivesDescByEntryID(entryId);
          break;
        case 4://�������
          archOpers=archOperDao.getArchOper(entryId);
          break;
        default:
          return mapping.findForward("unknown-error");
      }
      request.getSession().setAttribute("ArchOpers",archOpers);
    }
    else{
      String page=request.getParameter("page");
      PagedListHelper.pageTo(archOpers,page);
    }
    switch(flag){
      case 1://����У��
        return mapping.findForward("ArchVerify");
      case 2://��������
        return mapping.findForward("ArchIdentify");
      case 3://���ٹ���
        return mapping.findForward("ArchDestroy");
      case 4://�������
        return mapping.findForward("ArchChange");
        default:
        return mapping.findForward("unknown-error");
    }
  }

}