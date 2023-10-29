package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.BaseAction;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.iface.arm.BuildingCataLogDao;
import com.sunyard.hgam.presentation.base.PagedListHelper;


/**
 * <p>Title: ��ʾ���еĽ�����ĿĿ¼��Ϣ</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author ������
 * @version 1.0
 */

public class ViewAllBuildingCataLogAction extends BaseAction {
    public ActionForward doPerform(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.
    Exception {
      PaginatedList buildingCataLogs=(PaginatedList) request.getAttribute("BuildingCataLogs");
      String page = request.getParameter("page");
    if (page == null){
        BuildingCataLogDao buildingCataLogDao=(BuildingCataLogDao) domainLogic.getDAO("BuildingCataLog");
        request.getSession().setAttribute("BuildingCataLogs", buildingCataLogDao.getAllBuildingCataLog());
      }
      else{ PaginatedList list = (PaginatedList) request.getSession().getAttribute("BuildingCataLogs");
      if (list!=null){
        PagedListHelper.pageTo(list, page);
        return (mapping.findForward("success"));
      }

    }


   return mapping.findForward("success");


}
}
