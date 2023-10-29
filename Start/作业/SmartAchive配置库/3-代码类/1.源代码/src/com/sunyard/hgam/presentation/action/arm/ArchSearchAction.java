package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.iface.arm.ArchOperDao;
import com.sunyard.hgam.presentation.form.arm.ArchOperForm;
import com.sunyard.hgam.persistence.dao.beans.arm.ArchOper;

/**
 * <p>Title: ��ѯ��������</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author Ҷ�
 * @version 1.0
 */

public class ArchSearchAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    //�޶���֣��ȫ��20040212�������Ʊ��룬��ʵ�ַ�ҳ
    String strFlag = request.getParameter("flag");
    String entryId=request.getParameter("ENTRY_ID");
    String page=request.getParameter("page");

    if (strFlag == null || strFlag.equalsIgnoreCase("")) {
      strFlag = (String) request.getSession().getAttribute("flag");
    }
    if (entryId == null || entryId.equalsIgnoreCase("")) {
      entryId = (String) request.getSession().getAttribute("tmpEntryId");
    }

    //
    request.getSession().setAttribute("flag",strFlag);
    request.getSession().setAttribute("tmpEntryId",entryId);

    PaginatedList archOpers=(PaginatedList) request.getSession().getAttribute("ArchOpers");

    ArchOperForm archOperForm=(ArchOperForm) form;
    ArchOper archOperInfo = archOperForm.getArchOperInfo();
    archOperInfo.setEntryId(entryId);

    int flag=Integer.parseInt(strFlag);
    if(archOpers==null || page==null || page.equals("")){
      ArchOperDao archOperDao=(ArchOperDao) domainLogic.getDAO("ArchOper");
      //archOpers=archOperDao.searchArchive(archOperInfo);
      switch(flag){
        case 1://����У��
          archOpers=archOperDao.searchArchive(archOperInfo);
          break;
        case 2://��������
          archOpers=archOperDao.searchArchive(archOperInfo);
          break;
        case 3://���ٹ���
          archOpers=archOperDao.searchArchiveDest(archOperInfo);
          break;
        case 4://�������
          archOpers=archOperDao.searchArchive(archOperInfo);
          break;
        default:
          return mapping.findForward("unknown-error");
      }
      request.getSession().setAttribute("ArchOpers",archOpers);
    }
    else{
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