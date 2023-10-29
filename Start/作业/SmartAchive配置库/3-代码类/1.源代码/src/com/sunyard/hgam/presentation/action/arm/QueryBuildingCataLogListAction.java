package com.sunyard.hgam.presentation.action.arm;
import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.presentation.form.arm.BuildingCataLogForm;
import com.sunyard.hgam.persistence.dao.beans.arm.BuildingCataLog;
import com.sunyard.hgam.persistence.dao.iface.arm.BuildingCataLogDao;
/**
 * <p>Title: ��ѯ����Ŀ¼��Ϣ</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author ������
 * @version 1.0
 */
public class QueryBuildingCataLogListAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.
      Exception {

    PaginatedList BuildingCataLogs = (PaginatedList) request.getAttribute(
        "BuildingCataLogs");
    String page = request.getParameter("page");
    if (page == null) {
      BuildingCataLogForm buildingCataLogForm = (BuildingCataLogForm) form;
      BuildingCataLog buildingCataLog = buildingCataLogForm.
          getBuildingCataLogInfo();
      BuildingCataLogDao buildingCataLogDao = (BuildingCataLogDao) domainLogic.
          getDAO("BuildingCataLog");
      BuildingCataLogs = buildingCataLogDao.queryBuildingCataLogList(
          buildingCataLog);
      //���뻺��
      request.getSession().setAttribute("BuildingCataLogs", BuildingCataLogs);
      PagedListHelper.pageTo(BuildingCataLogs, page);
    }

    //
    return (mapping.findForward("success"));
  }
}


