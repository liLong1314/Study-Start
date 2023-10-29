package com.sunyard.hgam.presentation.action.pub;

import com.sunyard.hgam.presentation.base.BaseAction;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sunyard.hgam.persistence.dao.iface.pub.PublishInfoDao;
import java.util.List;
import java.util.ArrayList;
import com.sunyard.hgam.persistence.dao.iface.smm.SysParamDao;
import com.sunyard.hgam.persistence.dao.beans.smm.SysParam;

public class ViewAllPublishInfoListAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.Exception{
    String strForwardTo = "SUCCESS";

    //˼·����ȡ���������е��б��������ȡ���б��ɡ�
    try{
      SysParamDao sysParamDAO = (SysParamDao) domainLogic.getDAO("SysParam");
      List publishInfoTypeList = sysParamDAO.getSysParamByType(
          "PUBLISH_INFO_TYPE");
      List list = new ArrayList();
      PublishInfoDao publishInfoDao = (PublishInfoDao) domainLogic.getDAO(
          "PublishInfo");
      //���ȴ�������Ϣ
      //list = publishInfoDao.queryPublishInfoListByType("0");
      //request.setAttribute("BUGList", list);

      //�ٴ������õķ�����Ϣ
      String strType = "";
      for (int i = 0; i < publishInfoTypeList.size(); i++) {
        SysParam item = (SysParam) publishInfoTypeList.get(i);
        //item.getSysParamName()
        strType = item.getSysParamValue();
        list = publishInfoDao.queryPublishInfoListByType(strType);
        //���뻺��
        request.setAttribute(strType + "List", list);

      }
    }catch(Exception e){
      strForwardTo = "FAILURE";
    }

    return (mapping.findForward(strForwardTo));
  }

}