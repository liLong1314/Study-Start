package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.BaseAction;
import com.sunyard.hgam.presentation.form.arm.WatchExamineForm;
import com.sunyard.hgam.persistence.dao.iface.arm.WatchExamineDao;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>Title: 增加工作汇报信息</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 华良东
 * @version 1.0
 */

public class WatchExamineAddAction  extends BaseAction{
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    WatchExamineForm watchExamineForm=(WatchExamineForm)form;
    WatchExamineDao watchExamineDao=(WatchExamineDao) domainLogic.getDAO("WatchExamine");
    watchExamineDao.addWatchExamine(watchExamineForm.getWatchExamineInfo());
    return mapping.findForward("success");
  }


}