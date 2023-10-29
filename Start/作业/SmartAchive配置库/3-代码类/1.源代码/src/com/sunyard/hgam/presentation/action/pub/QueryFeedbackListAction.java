package com.sunyard.hgam.presentation.action.pub;

import com.sunyard.hgam.presentation.base.BaseAction;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.presentation.base.PagedListHelper;
import com.sunyard.hgam.presentation.form.pub.PublishInfoForm;
import com.sunyard.hgam.persistence.dao.beans.pub.PublishInfo;
import com.sunyard.hgam.persistence.dao.iface.pub.PublishInfoDao;

public class QueryFeedbackListAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.Exception{
    String ACT = request.getParameter("ACT");
    if (ACT == null || ACT.equalsIgnoreCase("")) {
      ACT = String.valueOf(request.getSession().getAttribute("ACT"));
    }
    request.getSession().setAttribute("ACT", ACT);

    String page = request.getParameter("page");
    PaginatedList feedbackInfoList = (PaginatedList) request.getSession().getAttribute("feedbackInfoList");

    if(feedbackInfoList==null || page == null){
      PublishInfoForm publishInfoForm = (PublishInfoForm) form;
      PublishInfo publishInfo = publishInfoForm.getPublishInfo();
      //publishInfo.setInfo_status("0");
      PublishInfoDao publishInfoDao = (PublishInfoDao) domainLogic.getDAO("PublishInfo");
      publishInfo.setInfo_type("BUG");
      feedbackInfoList = publishInfoDao.queryFeedbackList(publishInfo);

      //∑≈»Îª∫¥Ê
      request.getSession().setAttribute("feedbackInfoList", feedbackInfoList);
    }else{
      PagedListHelper.pageTo(feedbackInfoList, page);
    }

    //
    return (mapping.findForward("SUCCESS"));
  }

}