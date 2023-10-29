package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.persistence.dao.iface.arm.WholeDao;
import com.sunyard.hgam.persistence.dao.beans.arm.Whole;

/**
 * <p>Title: 查看全宗卷信息</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 叶昊
 * @version 1.0
 */

public class WholeInfoViewAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    String wholeId=request.getParameter("wholeId");
    WholeDao wholeDao=(WholeDao) domainLogic.getDAO("Whole");
    Whole wholeInfo=new Whole();
    wholeInfo=wholeDao.getWhole(wholeId);
    if(wholeInfo!=null){
      request.setAttribute("WholeInfo",wholeInfo);
    }
    else{
      return mapping.findForward("Failed");
    }
    return mapping.findForward("success");

  }

}