package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.BaseAction;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sunyard.hgam.presentation.form.arm.WatchExamineDenoteForm;
import com.sunyard.hgam.persistence.dao.iface.arm.WatchExamineDenoteDao;
import com.sunyard.hgam.persistence.dao.beans.arm.WatchExamineDenote;

/**
 * <p>Title: 增加一条总局指示</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 华良东
 * @version 1.0
 */

public class WatchExamineDenoteAddAction extends BaseAction{
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    WatchExamineDenoteForm watchExamineDenoteForm=(WatchExamineDenoteForm)form;
    WatchExamineDenoteDao aDAO=(WatchExamineDenoteDao) domainLogic.getDAO("WatchExamineDenote");
    WatchExamineDenote ss = watchExamineDenoteForm.getWatchExamineDenoteInfo();
    aDAO.addWatchExamineDenote(ss);
    return mapping.findForward("success");
  }


}