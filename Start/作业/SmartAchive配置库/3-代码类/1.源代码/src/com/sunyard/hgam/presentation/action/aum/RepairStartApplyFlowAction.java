package com.sunyard.hgam.presentation.action.aum;

import javax.servlet.http.*;
import java.sql.Timestamp;
import java.util.*;
import org.apache.struts.action.*;
import com.sunyard.rdc.flowdriver.*;
import com.sunyard.hgam.presentation.form.aum.UtilizeInfoForm;
import com.sunyard.hgam.persistence.dao.beans.aum.UtilizeInfo;
import com.sunyard.hgam.persistence.dao.iface.aum.UtilizeInfoDao;
import com.sunyard.hgam.util.common.*;
import com.sunyard.rdc.flowdriver.FlowDriver;
import com.sunyard.hgam.flowengine.FlowEngine;
import com.sunyard.hgam.presentation.base.*;
import com.sunyard.hgam.presentation.form.smm.AccountForm;
import com.sunyard.hgam.persistence.dao.beans.smm.Account;
import com.sunyard.hgam.persistence.dao.iface.smm.AccountDAO;

/************************************************************
 * <p>Title: HGAM(杭州市规划档案综合管理系统)</p>
 * <p>Description: 启动补证申请流程Action </p>
 * <p>Copyright: Sunhoo Copyright (c) 2004 </p>
 * <p>Company: Sunhoo Software Co.,Ltd. </p>
 * @author wanghua
 * @version 1.0
 *************************************************************/

public class RepairStartApplyFlowAction extends BaseAction {


  /***************************************************************************
   * 功能: 启动补证管理流程,产生第一个工作项(补证申请)并提交,生成下一个工作项;
   *      同时在UTILIZE_APPLY表插入一条记录;
   ***************************************************************************/
  public ActionForward doPerform(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {

    UtilizeInfoDao utilDao = (UtilizeInfoDao)domainLogic.getDAO("UtilizeInfoDao");

    String applyID = request.getParameter("applyID");
    String sModeID = "";
    UtilizeInfoForm uform = (UtilizeInfoForm) form;
    UtilizeInfo uInfo = uform.getUtilizeInfo();
    Map applyIDMap = new HashMap();
    applyIDMap.put("applyID",applyID);
    uInfo = utilDao.getUtilizeInfoByApplyID(applyIDMap);
    String flowInsID = "";

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
      flowInsID = m_FlowEngine.startFlow(3,listFormItem);  //参数"3"表明是"补证管理"流程

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

      //修改流程实例ID
      HashMap hm = new HashMap();
      hm.put("flowInsID",flowInsID);
      hm.put("applyID", applyID);
      utilDao.updateFlowInsID(hm);

      //修改流程状态
      hm = new HashMap();
      hm.put("utilizeStatus", "APPLIED");
      hm.put("applyID", applyID);
      utilDao.updateUtilizeStatus(hm);

      //检入工作项,参数3="补证管理"流程
      m_FlowEngine.checkInTask(lWorkitemID, listFormItem, 3);

      //断开引擎的连接
      m_FlowEngine.disconnect();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    return mapping.findForward("success");
  }

}