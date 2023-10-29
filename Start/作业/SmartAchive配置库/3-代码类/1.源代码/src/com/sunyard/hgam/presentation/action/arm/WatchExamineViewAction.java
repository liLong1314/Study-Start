package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.persistence.dao.iface.arm.WatchExamineDao;
import com.sunyard.hgam.persistence.dao.beans.arm.WatchExamine;

/**
 * <p>Title: �鿴�ල�����Ϣ</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author ������
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
      watchExamineInfo.setRefWatchId("�ܾ�δ��ʾ");
    }else{
      watchExamineInfo.setRefWatchId("�ܾ�����ʾ");}

    if(watchExamineInfo!=null){
    int subCode=Integer.parseInt(watchExamineInfo.getSubCode());
    switch(subCode){
      case 8:
               watchExamineInfo.setSubCode("�ϳǹ滮�־�");
               break;
             case 9:
               watchExamineInfo.setSubCode("�³ǹ滮�־�");
               break;
             case 11:
               watchExamineInfo.setSubCode("���ɹ滮�־�");
               break;
             case 12:
               watchExamineInfo.setSubCode("�����滮�־�");
               break;
             case 10:
               watchExamineInfo.setSubCode("�����滮�־�");
               break;
             default:
               watchExamineInfo.setSubCode("����");
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
