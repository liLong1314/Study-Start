package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.iface.arm.IdentifyDao;

/**
 * <p>Title: 鉴定统计</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author not attributable
 * @version 1.0
 */

public class FileIdentStatAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response){
    /*
    PaginatedList identifys=(PaginatedList) request.getSession().getAttribute("Identifys");
    if(identifys==null){
      IdentifyDao identifyDao=(IdentifyDao) domainLogic.getDAO("Identify");
      identifys=identifyDao.getAllIdentify();
      request.getSession().setAttribute("Identifys",identifys);
    }
    else{
      String page=request.getParameter("page");
      PagedListHelper.pageTo(identifys,page);
    }
    */
    return mapping.findForward("success");
  }

}