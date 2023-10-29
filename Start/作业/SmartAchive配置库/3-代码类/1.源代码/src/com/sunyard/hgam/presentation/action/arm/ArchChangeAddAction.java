package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.arm.ArchOperForm;
import com.sunyard.hgam.persistence.dao.iface.arm.ArchOperDao;

/**
 * <p>Title: 档案变更</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 叶昊
 * @version 1.0
 */

public class ArchChangeAddAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {

    ArchOperForm archOperForm =(ArchOperForm) form;
    ArchOperDao archOperDao=(ArchOperDao) domainLogic.getDAO("ArchOper");
    archOperDao.addChangedArchive(archOperForm.getArchOperInfo());
    return mapping.findForward("success");
  }

}