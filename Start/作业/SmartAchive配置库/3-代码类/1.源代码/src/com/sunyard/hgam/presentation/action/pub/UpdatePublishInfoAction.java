package com.sunyard.hgam.presentation.action.pub;


import com.sunyard.hgam.presentation.base.BaseAction;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sunyard.hgam.presentation.form.smm.AccountForm;
import com.sunyard.hgam.persistence.dao.beans.smm.Account;
import com.sunyard.hgam.presentation.form.pub.PublishInfoForm;
import com.sunyard.hgam.persistence.dao.beans.pub.PublishInfo;
import com.sunyard.hgam.persistence.dao.iface.pub.PublishInfoDao;


public class UpdatePublishInfoAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.Exception{


    PublishInfoForm publishInfoForm = (PublishInfoForm)form;
    PublishInfo publishInfo = publishInfoForm.getPublishInfo();

    String operName = publishInfoForm.getOperName();
    String strForwardTo = "";

    try {

      //���ò�����ʶ
      publishInfoForm.setOperName("");

      PublishInfoDao publishInfoDao = (PublishInfoDao) domainLogic.getDAO(
          "PublishInfo");
      if (operName.equalsIgnoreCase("EDIT")) { //�༭
        //���÷�����Ա
        publishInfo.setInfo_publish_person("");
        AccountForm accountInfo = (AccountForm) request.getSession().
            getAttribute("ACCOUNT_INFORMATION");
        if (accountInfo != null && accountInfo instanceof AccountForm) {
          Account account = accountInfo.getAccount();
          if (account != null) {
            publishInfo.setInfo_publish_person(account.getName());
          }
        }

        publishInfoDao.updatePublishInfo(publishInfo);
        strForwardTo = "EDIT";
      }else if (operName.equalsIgnoreCase("CONFIRM")) { //���
        //���������Ա
        publishInfo.setInfo_confirm_person("");
        AccountForm accountInfo = (AccountForm) request.getSession().
            getAttribute("ACCOUNT_INFORMATION");
        if (accountInfo != null && accountInfo instanceof AccountForm) {
          Account account = accountInfo.getAccount();
          if (account != null) {
            publishInfo.setInfo_confirm_person(account.getName());
          }
        }

        publishInfoDao.updatePublishInfoForConfirm(publishInfo);
        strForwardTo = "CONFIRM";
      }else if (operName.equalsIgnoreCase("REPLY")) { //�ظ�
        //���ûظ���Ա
        publishInfo.setInfo_feedback_person("");
        AccountForm accountInfo = (AccountForm) request.getSession().
            getAttribute("ACCOUNT_INFORMATION");
        if (accountInfo != null && accountInfo instanceof AccountForm) {
          Account account = accountInfo.getAccount();
          if (account != null) {
            publishInfo.setInfo_feedback_person(account.getName());
          }
        }

        publishInfoDao.updatePublishInfoForFeedback(publishInfo);
        strForwardTo = "REPLY";
      }



      request.setAttribute("PublishInfoFileForm", publishInfoForm);
    }
    catch (Exception ex) {
      publishInfoForm.setMsgError(ex.toString());
      strForwardTo = "FAILURE";
    }

    return mapping.findForward(strForwardTo);
  }

}