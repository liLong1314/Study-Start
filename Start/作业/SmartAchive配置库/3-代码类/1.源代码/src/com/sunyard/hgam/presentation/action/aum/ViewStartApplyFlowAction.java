package com.sunyard.hgam.presentation.action.aum;

import javax.servlet.http.*;
import java.sql.Timestamp;
import java.util.*;
import org.apache.struts.action.*;
import com.sunyard.rdc.flowdriver.*;
import com.sunyard.hgam.presentation.base.BaseAction;
import com.sunyard.hgam.flowengine.FlowEngine;
import com.sunyard.hgam.persistence.dao.iface.aum.UtilizeInfoDao;
import com.sunyard.hgam.persistence.dao.beans.aum.UtilizeInfo;
import com.sunyard.hgam.presentation.form.smm.AccountForm;
import com.sunyard.hgam.persistence.dao.beans.smm.Account;
import com.sunyard.hgam.persistence.dao.iface.smm.AccountDAO;

/************************************************************
 * <p>Title: HGAM(杭州市规划档案综合管理系统)</p>
 * <p>Description: 启动查阅申请流程Action </p>
 * <p>Copyright: Sunhoo Copyright (c) 2004 </p>
 * <p>Company: Sunhoo Software Co.,Ltd. </p>
 * @author wanghua
 * @version 1.0
 *************************************************************/

public class ViewStartApplyFlowAction extends BaseAction {


  /***************************************************************************
   * 功能: 启动查阅管理流程,产生第一个工作项(查阅申请)并提交,生成下一个工作项(领导审批);
   *      同时在UTILIZE_APPLY表插入一条记录,返回applyID;
   ***************************************************************************/
  public ActionForward doPerform(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {

    UtilizeInfoDao utilDao = (UtilizeInfoDao)domainLogic.getDAO("UtilizeInfoDao");

    String applyID = request.getParameter("applyID");
    String flowInsID = "";
    UtilizeInfo utilizeInfo = new UtilizeInfo();
    Map applyIDMap = new HashMap();
    applyIDMap.put("applyID", applyID);
    utilizeInfo = utilDao.getUtilizeInfoByApplyID(applyIDMap);

    //获取登录信息
    String loginName = "";
    String pwd = "";
    AccountForm accountInfo = (AccountForm) request.getSession().getAttribute(
        "ACCOUNT_INFORMATION");
    if (accountInfo != null) {
      Account account = accountInfo.getAccount();
      loginName = account.getUserName();
    }
    AccountDAO accountDAO = (AccountDAO) domainLogic.getDAO("Account");
    pwd = accountDAO.getPasswordByUsername(loginName);

    try {

      /*** 流程控制部份 ***/
      //实例化引擎接口
      FlowEngine m_FlowEngine = new FlowEngine(loginName,pwd);

      //修改流程变量procState
      FormItemInfo oFormItem = new FormItemInfo();
      oFormItem.setItemName("utilizeStatus");
      oFormItem.setItemValue("APPLIED");
      List listFormItem = new ArrayList();
      listFormItem.add(oFormItem);

      //启动流程实例
      flowInsID = m_FlowEngine.startFlow(1,listFormItem);  //参数"1"表明是"查阅管理"流程

      //检出工作项
      TaskInfo oTaskInfo = m_FlowEngine.getTaskByApplyID(flowInsID);
      long lWorkitemID = oTaskInfo.getWorkItemID();
      System.out.println("WorkitemID:" + lWorkitemID);
      m_FlowEngine.checkOutTask(lWorkitemID);

      /*** 填充工作项的相关变量值 ***/
      listFormItem = new ArrayList();
      oFormItem = new FormItemInfo();

      //申请ID
      oFormItem = new FormItemInfo();
      oFormItem.setItemName("applyID");
      oFormItem.setItemValue(applyID);
      listFormItem.add(oFormItem);

      //是否为外来单位人员
      boolean bExternal = false;
      String userID = utilizeInfo.getUserID();
      if ( (userID == null) || (userID.equals("")))
        bExternal = true;

      //设置工作项相关变量
      oFormItem = new FormItemInfo();
      oFormItem.setItemName("isExternal");
      if (bExternal)
        oFormItem.setItemValue(new Boolean(true));
      else
        oFormItem.setItemValue(new Boolean(false));
      listFormItem.add(oFormItem);

      //是否查阅本单位
      boolean bSelf = false;
      FormItemInfo oFormItem1 = new FormItemInfo();
      String isBrowseSelf = utilizeInfo.getSelf();
      if (isBrowseSelf.equals("1"))
        bSelf = true;

      //设置工作项相关变量
      oFormItem1.setItemName("isSelf");
      if (bSelf)
        oFormItem1.setItemValue(new Boolean(true));
      else
        oFormItem1.setItemValue(new Boolean(false));
      listFormItem.add(oFormItem1);

      //修改流程状态
      HashMap hm = new HashMap();
      if (bExternal) {
        if (bSelf)
          hm.put("utilizeStatus", "CONFIRMED");
        else
          hm.put("utilizeStatus", "APPLIED");
      }
      else {
        hm.put("utilizeStatus", "CONFIRMED");
      }
      hm.put("applyID", applyID);
      utilDao.updateUtilizeStatus(hm);

      //修改流程实例ID
      hm = new HashMap();
      hm.put("flowInsID",flowInsID);
      hm.put("applyID", applyID);
      utilDao.updateFlowInsID(hm);

      //检入工作项,参数1="查阅管理"流程
      m_FlowEngine.checkInTask(lWorkitemID, listFormItem, 1);

      //断开引擎的连接
      m_FlowEngine.disconnect();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    return mapping.findForward("success");
  }

}