package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.iface.arm.ArchOperDao;

/**
 * <p>Title: 档案资源管理－查看案卷</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 叶昊
 * @version 1.0
 */

public class ArchViewAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    //ENTRY_ID=15&ISOPERATION=1&ENTRY_LEVEL=2&flag=2
    //修订（郑先全，20040212）：完善编码，并实现翻页
    String strFlag = request.getParameter("flag");
    String entryId=request.getParameter("ENTRY_ID");

    if (strFlag == null || strFlag.equalsIgnoreCase("")) {
      strFlag = (String) request.getSession().getAttribute("flag");
    }
    if (entryId == null || entryId.equalsIgnoreCase("")) {
      entryId = (String) request.getSession().getAttribute("tmpEntryId");
    }

    //这是首先进来，没必要取出缓存（郑先全，0217）
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
        case 1://档案校验
          archOpers=archOperDao.getArchOper(entryId);
          break;
        case 2://鉴定管理
          archOpers=archOperDao.getArchOper(entryId);
          break;
        case 3://销毁管理
          archOpers=archOperDao.getArchivesDescByEntryID(entryId);
          break;
        case 4://变更管理
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
      case 1://档案校验
        return mapping.findForward("ArchVerify");
      case 2://鉴定管理
        return mapping.findForward("ArchIdentify");
      case 3://销毁管理
        return mapping.findForward("ArchDestroy");
      case 4://变更管理
        return mapping.findForward("ArchChange");
        default:
        return mapping.findForward("unknown-error");
    }
  }

}