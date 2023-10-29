package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.persistence.dao.iface.arm.WatchExamineDao;
import com.sunyard.hgam.persistence.dao.beans.arm.WatchExamine;

/**
 * <p>Title: 查看监督检查信息</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 华良东
 * @version 1.0
 */

public class WatchExamineViewAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    String watchId=request.getParameter("watchId");
    WatchExamineDao watchExamineDao=(WatchExamineDao) domainLogic.getDAO("WatchExamine");
    WatchExamine watchExamineInfo=new WatchExamine();
    watchExamineInfo=watchExamineDao.getWatchExamine(watchId);

    String refWatchId=watchExamineInfo.getRefWatchId();
    if(refWatchId==null){
      watchExamineInfo.setRefWatchId("总局未批示");
    }else{
      watchExamineInfo.setRefWatchId("总局已批示");}

    if(watchExamineInfo!=null){
    int subCode=Integer.parseInt(watchExamineInfo.getSubCode());
    switch(subCode){
      case 8:
               watchExamineInfo.setSubCode("上城规划分局");
               break;
             case 9:
               watchExamineInfo.setSubCode("下城规划分局");
               break;
             case 11:
               watchExamineInfo.setSubCode("江干规划分局");
               break;
             case 12:
               watchExamineInfo.setSubCode("拱墅规划分局");
               break;
             case 10:
               watchExamineInfo.setSubCode("西湖规划分局");
               break;
             default:
               watchExamineInfo.setSubCode("其他");
               break;
    }

      request.setAttribute("watchExamineInfo",watchExamineInfo);
    }
    else{
      return mapping.findForward("Failed");
    }
    return mapping.findForward("success");

  }

}
