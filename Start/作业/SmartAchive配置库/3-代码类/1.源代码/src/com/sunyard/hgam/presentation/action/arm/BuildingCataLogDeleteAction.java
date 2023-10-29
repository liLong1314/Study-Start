package com.sunyard.hgam.presentation.action.arm;



import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.arm.BuildingCataLogForm;
import com.sunyard.hgam.persistence.dao.iface.arm.BuildingCataLogDao;
import com.sunyard.hgam.persistence.dao.beans.arm.BuildingCataLog;

/**
 * <p>Title: 增加建筑项目目录信息</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 郑先全
 * @version 1.0
 * @log
 * 1、新增功能
 */

public class BuildingCataLogDeleteAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {

    String cataId = request.getParameter("cataId");

    BuildingCataLogDao buildingCataLogDao = (BuildingCataLogDao) domainLogic.getDAO("BuildingCataLog");
    buildingCataLogDao.deleteBuildingCataLog(cataId);

    return mapping.findForward("success");
  }
}
