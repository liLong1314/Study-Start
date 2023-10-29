package com.sunyard.hgam.presentation.action.arm;



import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.arm.BuildingCataLogForm;
import com.sunyard.hgam.persistence.dao.iface.arm.BuildingCataLogDao;
import com.sunyard.hgam.persistence.dao.beans.arm.BuildingCataLog;

/**
 * <p>Title: ���ӽ�����ĿĿ¼��Ϣ</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author ֣��ȫ
 * @version 1.0
 * @log
 * 1������
 */

public class BuildingCataLogUpdateAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {

    BuildingCataLogForm buildingCataLogForm = (BuildingCataLogForm) form;
    BuildingCataLog buildingCataLog = buildingCataLogForm.getBuildingCataLogInfo();

    BuildingCataLogDao buildingCataLogDao = (BuildingCataLogDao) domainLogic.getDAO("BuildingCataLog");
    buildingCataLogDao.updateBuildingCataLog(buildingCataLog);

    return mapping.findForward("success");
  }
}
