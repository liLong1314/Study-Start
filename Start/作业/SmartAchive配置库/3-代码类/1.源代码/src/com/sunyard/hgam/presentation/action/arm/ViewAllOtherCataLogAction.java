package com.sunyard.hgam.presentation.action.arm;



import com.sunyard.hgam.presentation.base.BaseAction;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.iface.arm.OtherCataLogDao;
import com.sunyard.hgam.presentation.base.PagedListHelper;


/**
 * <p>Title: 显示所有的杂项工程目录信息</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 华良东
 * @version 1.0
 */

public class ViewAllOtherCataLogAction extends BaseAction {
    public ActionForward doPerform(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.
    Exception {
      PaginatedList otherCataLogs=(PaginatedList) request.getAttribute("OtherCataLogs");
      String page = request.getParameter("page");
    if (page == null){
        OtherCataLogDao otherCataLogDao=(OtherCataLogDao) domainLogic.getDAO("OtherCataLog");
        request.getSession().setAttribute("OtherCataLogs", otherCataLogDao.getAllOtherCataLog());
      }
      else{ PaginatedList list = (PaginatedList) request.getSession().getAttribute("OtherCataLogs");
      if (list!=null){
        PagedListHelper.pageTo(list, page);
        return (mapping.findForward("success"));
      }

    }


   return mapping.findForward("success");


}
}
