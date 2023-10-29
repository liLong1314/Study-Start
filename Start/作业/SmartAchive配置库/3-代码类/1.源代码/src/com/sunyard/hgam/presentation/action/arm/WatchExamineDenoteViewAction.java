package com.sunyard.hgam.presentation.action.arm;
import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.persistence.dao.iface.arm.WatchExamineDenoteDao;
import com.sunyard.hgam.persistence.dao.beans.arm.WatchExamineDenote;

/**
 * <p>Title: HGAM</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author not attributable
 * @version 1.0
 */

public class WatchExamineDenoteViewAction extends BaseAction{
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    String watchId=request.getParameter("watchId");
    WatchExamineDenoteDao watchExamineDenoteDao=(WatchExamineDenoteDao) domainLogic.getDAO("WatchExamineDenote");
    WatchExamineDenote watchExamineDenoteInfo=new WatchExamineDenote();
    watchExamineDenoteInfo=watchExamineDenoteDao.getWatchExamineDenote(watchId);
    if(watchExamineDenoteInfo!=null){

      request.setAttribute("watchExamineDenoteInfo",watchExamineDenoteInfo);
    }
    else{
      return mapping.findForward("Failed");
    }
    return mapping.findForward("success");

  }


}