package com.sunyard.hgam.presentation.action.arm;




import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.persistence.dao.iface.arm.OtherCataLogDao;
import com.sunyard.hgam.presentation.form.arm.OtherCataLogForm;

/**
 * <p>Title: 增加杂项工程目录信息</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 华良东
 * @version 1.0
 */

public class OtherCataLogAddAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest httpServletRequest,
                                 HttpServletResponse httpServletResponse) {

    OtherCataLogForm otherCataLogForm = (OtherCataLogForm) form;
    OtherCataLogDao otherCataLogDao = (OtherCataLogDao) domainLogic.getDAO("OtherCataLog");
    otherCataLogDao.addOtherCataLog(otherCataLogForm.getOtherCataLogInfo());
    return mapping.findForward("success");
  }
}
