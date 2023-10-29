package com.sunyard.hgam.presentation.action.pub;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import java.util.List;
import java.util.ArrayList;
import com.sunyard.hgam.presentation.form.pub.PublishInfoForm;
import com.sunyard.hgam.persistence.dao.beans.pub.PublishInfo;
import com.sunyard.hgam.persistence.dao.iface.pub.PublishInfoDao;

public class DeletePublishInfoAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.Exception {
    //ѡ���ļ�¼
    String infoId[] = null;
    String strForwardTo = "";

    PublishInfoForm publishInfoForm = (PublishInfoForm) form;

    try {
      if(request.getParameterValues("info_id")!=null){
        infoId=request.getParameterValues("info_id");
      }else{
        throw new Exception("�������ԣ�û��ָ����Ϣ��ţ�infoId��");
      }

      PublishInfoDao publishInfoDao = (PublishInfoDao)domainLogic.getDAO("PublishInfo");

      //ѭ��ɾ��
      List publishInfoList = new ArrayList();
      for (int i = 0; i < infoId.length; i++) {
        publishInfoDao.deletePublishInfo(infoId[i].toString());
      }

      //����
      String act = publishInfoForm.getOperName();
      if(act!=null && act.equals("PUBLISH")){
        strForwardTo = "PUBLISH";
      }else{
        strForwardTo = "FEEDBACK";
      }
    }catch (Exception ex) {
      strForwardTo = "FAILURE";
      publishInfoForm.setMsgError(ex.toString());
    }

    //����
    return (mapping.findForward(strForwardTo));
  }

}