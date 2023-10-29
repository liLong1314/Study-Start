package com.sunyard.hgam.presentation.action.aum;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.aum.UtilizeInfoForm;
import com.sunyard.hgam.persistence.dao.beans.aum.UtilizeInfo;
import com.sunyard.hgam.persistence.dao.iface.aum.UtilizeInfoDao;
import java.util.List;
import com.sunyard.hgam.presentation.form.smm.AccountForm;
import com.sunyard.hgam.persistence.dao.beans.smm.Account;
import com.sunyard.hgam.util.common.DateTimeKit;

/*********************************************************
 * <p>Title: HGAM(杭州市规划档案综合管理系统)</p>
 * <p>Description: 新建申请表单 </p>
 * <p>Copyright: Sunhoo Copyright (c) 2004 </p>
 * <p>Company: Sunhoo Software Co.,Ltd. </p>
 * @author wanghua
 * @version 1.0
 *********************************************************/

public class BorrowNewApplyFormAction
    extends BaseAction {

  public ActionForward doPerform(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {

    UtilizeInfoForm utilForm = (UtilizeInfoForm) form;
    UtilizeInfo utilInfo = new UtilizeInfo();
    UtilizeInfoDao utilDao = (UtilizeInfoDao) domainLogic.getDAO(
        "UtilizeInfoDao");

    String showFlag = request.getParameter("showFlag");

    if (showFlag == null) {
      //设置申请人员信息,缺省情况是登录人即为申请人
      AccountForm accountInfo = (AccountForm) request.getSession().getAttribute(
          "ACCOUNT_INFORMATION");
      if (accountInfo != null) {
        Account account = accountInfo.getAccount();
        utilInfo.setPersonName(account.getName());
        utilInfo.setPersonCorp(account.getDepartment());
      }
      request.getSession().setAttribute("isSelf", "1");
    }
    else {
      request.getSession().setAttribute("personID",
                                        utilForm.getUtilizeInfo().getPersonID());
      request.getSession().setAttribute("isSelf", "0");
      utilInfo.setPersonID(utilForm.getUtilizeInfo().getPersonID());
      utilInfo.setPersonName(utilForm.getUtilizeInfo().getPersonName());
      utilInfo.setPersonCorp(utilForm.getUtilizeInfo().getPersonCorp());
    }

    //获取所有的利用方式名称
    List listModeName = utilDao.getAllUtilModeName();
    utilInfo.setListModeName(listModeName);

    //设置申请日期为系统当前日期
    utilInfo.setBeginDate(DateTimeKit.getCurrentTimestamp().substring(0, 10));
    utilForm.setUtilizeInfo(utilInfo);

    request.getSession().setAttribute("utilForm", utilForm);

    //设置标志位用来识别启动的流程,"2"=借阅流程
    request.getSession().setAttribute("flowDefID", "2");

    System.out.println("显示申请表单成功!");
    return mapping.findForward("success");
  }

}