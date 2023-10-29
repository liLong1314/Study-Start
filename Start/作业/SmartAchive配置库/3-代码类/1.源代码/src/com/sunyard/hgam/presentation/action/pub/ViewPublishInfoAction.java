package com.sunyard.hgam.presentation.action.pub;


import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.pub.PublishInfoForm;
import com.sunyard.hgam.persistence.dao.iface.pub.PublishInfoDao;
import com.sunyard.hgam.persistence.dao.beans.pub.PublishInfo;
import java.util.List;


public class ViewPublishInfoAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.
      Exception {

    String info_id=request.getParameter("info_id");
    //������־���鿴(VIW)���༭(EDT)����˱�־(CFM)
    String ACT=request.getParameter("ACT");
    String strForwardTo = "";
    PublishInfoForm publishInfoForm = (PublishInfoForm)form;

    try {
      PublishInfoDao publishInfoDao = (PublishInfoDao) domainLogic.getDAO("PublishInfo");
      //ȡ�÷�����Ϣ
      PublishInfo publishInfo = publishInfoDao.getPublishInfoById(info_id);
      publishInfoForm.setPublishInfo(publishInfo);
      //ȡ����ظ����б�
      List publishInfoAccessoryList = publishInfoDao.getPublishInfoAccessoryListByInfoId(info_id);

      request.setAttribute("publishInfoForm", publishInfoForm);
      request.setAttribute("publishInfoAccessoryList", publishInfoAccessoryList);
      String strType = publishInfo.getInfo_type();
      if(strType==null || strType.equals("BUG")){
        //������Ϣ
        strForwardTo = "FEEDBACK_VIEW";
        if (ACT != null && ACT.equals("REP")){
          strForwardTo = "FEEDBACK_REPLY";
        }
      }else{
        strForwardTo = "PUBLISH_VIEW";
        if (ACT != null) {
          if (ACT.equals("EDT")) {
            strForwardTo = "PUBLISH_EDIT";
          }
          else if (ACT.equals("CFM")) {
            strForwardTo = "PUBLISH_CONFIRM";
          }
        }
      }
    }catch (Exception ex) {
      strForwardTo = "FAILURE";
    }

    return mapping.findForward(strForwardTo);
  }

}