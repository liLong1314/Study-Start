package com.sunyard.hgam.presentation.action.aum;

import javax.servlet.http.*;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.struts.action.*;
import com.sunyard.hgam.presentation.base.*;
import com.sunyard.hgam.presentation.form.aum.UtilizeInfoForm;
import com.sunyard.hgam.persistence.dao.beans.aum.UtilizeInfo;
import com.sunyard.hgam.flowengine.FlowEngine;
import com.sunyard.rdc.flowdriver.*;
import com.sunyard.hgam.persistence.dao.iface.aum.UtilizeInfoDao;
import com.sunyard.hgam.persistence.dao.iface.aum.ConfirmInfoDao;
import com.sunyard.hgam.persistence.dao.beans.aum.ConfirmInfo;
import com.sunyard.hgam.util.common.DateTimeKit;
import java.util.Map;
import com.sunyard.hgam.presentation.form.smm.AccountForm;
import com.sunyard.hgam.persistence.dao.beans.smm.Account;
import com.sunyard.hgam.persistence.dao.iface.smm.AccountDAO;
import com.sunyard.hgam.persistence.dao.iface.adc.ArchivesFileDao;
import com.sunyard.hgam.persistence.dao.iface.aum.UtilizeDetailDao;
import com.sunyard.hgam.persistence.dao.beans.aum.UtilizeDetail;

/*********************************************************
 * <p>Title: HGAM(杭州市规划档案综合管理系统)</p>
 * <p>Description: 根据不同的处理环节提交当前工作项 </p>
 * <p>Copyright: Sunhoo Copyright (c) 2004 </p>
 * <p>Company: Sunhoo Software Co.,Ltd. </p>
 * @author wanghua
 * @version 1.0
 *********************************************************/

public class ViewCommitTaskAction
    extends BaseAction {

  /*********************************************************************
   * 功能: 根据不同的处理环节提交当前工作项
   *********************************************************************/
  public ActionForward doPerform(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {

    UtilizeInfoDao utilDao = (UtilizeInfoDao) domainLogic.getDAO(
        "UtilizeInfoDao");
    ConfirmInfoDao confirmDao = (ConfirmInfoDao) domainLogic.getDAO(
        "ConfirmInfo");
    UtilizeDetailDao utilizeDetailDao = (UtilizeDetailDao) domainLogic.getDAO(
        "UtilizeDetail");
    ArchivesFileDao archivesFileDao = (ArchivesFileDao)domainLogic.getDAO("ArchivesFile");
    UtilizeInfoForm uForm = (UtilizeInfoForm) form;
    UtilizeInfo uInfo = uForm.getUtilizeInfo();
    String sApplyID = uInfo.getApplyID();  //利用申请ID

    //获得流程实例ID
    UtilizeInfo tmpUtilizeInfo = new UtilizeInfo();
    Map applyIDMap = new HashMap();
    applyIDMap.put("applyID",sApplyID);
    tmpUtilizeInfo = utilDao.getUtilizeInfoByApplyID(applyIDMap);
    String flowInsID = tmpUtilizeInfo.getFlowInsID(); //流程实例ID

    //流程相关数据列表
    List listFormItem = new ArrayList();
    FormItemInfo oFormItem = new FormItemInfo();

    //获取登录信息
    String loginName = "";
    String pwd = "";
    Account account = new Account();
    AccountForm accountInfo = (AccountForm) request.getSession().getAttribute(
        "ACCOUNT_INFORMATION");
    if (accountInfo != null) {
      account = accountInfo.getAccount();
      loginName = account.getUserName();
    }
    AccountDAO accountDAO = (AccountDAO) domainLogic.getDAO("Account");
    pwd = accountDAO.getPasswordByUsername(loginName);

    try {
      //实例化引擎接口
      FlowEngine m_FlowEngine = new FlowEngine(loginName, pwd);

      //检出工作项
      TaskInfo oTaskInfo = m_FlowEngine.getTaskByApplyID(flowInsID);
      long lWorkitemID = oTaskInfo.getWorkItemID();
      System.out.println("WorkitemID:" + lWorkitemID);
      m_FlowEngine.checkOutTask(lWorkitemID);

      //流程实例状态
      String flowInsStatus = uInfo.getUtilizeStatus();
      //领导审批信息
      ConfirmInfo oConfirmInfo = new ConfirmInfo();

      //根据流程状态处理相应的环节
      /*** 查阅流程的"申请"处理环节 ***/
      //上一个环节是"领导审批"环节(领导不同意)
      HashMap hm = new HashMap();
      if (flowInsStatus.equals("UNCONFIRMED")) {
        //业务数据部分
        //修改流程实例状态为"已登记"
        hm.put("utilizeStatus", "APPLIED");
        hm.put("applyID", sApplyID);
        utilDao.updateUtilizeStatus(hm);
        //流程数据部分,检入工作项,参数1="查阅"流程;此时不需要修查阅管理改流程变量,因此第二个参数为null
        m_FlowEngine.checkInTask(lWorkitemID,null,1);
        return mapping.findForward("success");
      }

      /*** 查阅流程的"领导审批"处理环节 ***/
      String sIsAgree = uInfo.getAgree();
      //上一个环节是"查阅申请"环节
      if (flowInsStatus.equals("APPLIED")) {
        //设置HGAM的变量值
        oFormItem.setItemName("isAgree");
        if (sIsAgree.equals("1")) {
          oFormItem.setItemValue(new Boolean("true"));
          //修改流程实例状态为"已审批"
          hm.put("utilizeStatus","CONFIRMED");
          hm.put("applyID",sApplyID);
          oConfirmInfo.setIsAgree("1");
        }
        else {
          oFormItem.setItemValue(new Boolean("false"));
          //修改流程实例状态为"未审批"
          hm.put("utilizeStatus","UNCONFIRMED");
          hm.put("applyID",sApplyID);
          oConfirmInfo.setIsAgree("0");
        }
        utilDao.updateUtilizeStatus(hm);
        listFormItem.add(oFormItem);

        //检入工作项,参数1="查阅管理"流程
        m_FlowEngine.checkInTask(lWorkitemID,listFormItem,1);

        //插入领导审批信息
        oConfirmInfo.setApplyID(sApplyID);
        oConfirmInfo.setConfirmUserID(account.getUserID());//从登录信息中取得
        oConfirmInfo.setTaskID(m_FlowEngine.getActivityInsIDByWorkitemID(
            lWorkitemID));
        oConfirmInfo.setConfirmDate(DateTimeKit.getCurrentTimestamp().substring(
            0, 10));
        String confirmIdea = "";
        if (sIsAgree.equals("1")) {
          confirmIdea = "（同意）";
        }
        else {
          confirmIdea = "（不同意）";
        }
        oConfirmInfo.setConfirmIdea(uInfo.getLeadConfirmIdea() + confirmIdea);
        oConfirmInfo.setRemark("");//备注信息不用
        oConfirmInfo.setStatus("1");//表明是领导审批信息
        confirmDao.addConfirmInfo(oConfirmInfo);

        return mapping.findForward("success");
      }

      /*** 查阅流程的"登记"处理环节 ***/
      //上一个环节是"领导审批"环节
      if (flowInsStatus.equals("CONFIRMED") ||
          flowInsStatus.equals("UNREGCONFIRMED")) {
        //业务数据部分
        //修改流程实例状态为"已登记"
        hm.put("utilizeStatus", "REGISTED");
        hm.put("applyID", sApplyID);
        utilDao.updateUtilizeStatus(hm);
        //流程数据部分,检入工作项,参数1="查阅"流程;此时不需要修查阅管理改流程变量,因此第二个参数为null
        m_FlowEngine.checkInTask(lWorkitemID,null,1);

        //插入登记信息
        oConfirmInfo.setApplyID(sApplyID);
        oConfirmInfo.setConfirmUserID(account.getUserID());//从登录信息中取得
        oConfirmInfo.setTaskID(m_FlowEngine.getActivityInsIDByWorkitemID(
            lWorkitemID));
        oConfirmInfo.setConfirmDate(DateTimeKit.getCurrentTimestamp().substring(
            0, 10));
        oConfirmInfo.setConfirmIdea("已登记");
        oConfirmInfo.setIsAgree("1");
        oConfirmInfo.setRemark("");//备注信息不用
        oConfirmInfo.setStatus("");//状态信息不用
        confirmDao.addConfirmInfo(oConfirmInfo);

        return mapping.findForward("success");
      }

      /*** 查阅流程的"登记审批"处理环节 ***/
      String sIsAgreeOfReg = uInfo.getAgreeOfRegistration();
      //上一个环节是"登记"环节
      if (flowInsStatus.equals("REGISTED")) {
        //设置HGAM的变量值
        oFormItem.setItemName("isAgree");
        if (sIsAgreeOfReg.equals("1")) {
          oFormItem.setItemValue(new Boolean("true"));
          //修改流程实例状态为"登记审批已通过"
          hm.put("utilizeStatus","REGCONFIRMED");
          hm.put("applyID",sApplyID);
          oConfirmInfo.setIsAgree("1");
          //修改文件状态为出库
          Map queryMap = new HashMap();
          Map updateMap = new HashMap();
          queryMap.put("applyID", sApplyID);
          List detailList = utilizeDetailDao.queryUtilizeDetailByApplyID(
              queryMap);
          UtilizeDetail utilDetail = null;
          for (int i = 0; i < detailList.size(); i++) {
            utilDetail = new UtilizeDetail();
            utilDetail = (UtilizeDetail) detailList.get(i);
            updateMap.put("isBorrow", "1");
            updateMap.put("fileID", utilDetail.getFile_id());
            archivesFileDao.updateBorrowStatusByFileID(updateMap);
          }
        }
        else {
          oFormItem.setItemValue(new Boolean("false"));
          //修改流程实例状态为"登记审批未通过"
          hm.put("utilizeStatus","UNREGCONFIRMED");
          hm.put("applyID",sApplyID);
          oConfirmInfo.setIsAgree("0");
        }
        utilDao.updateUtilizeStatus(hm);
        listFormItem.add(oFormItem);

        //检入工作项,参数1="查阅管理"流程
        m_FlowEngine.checkInTask(lWorkitemID,listFormItem,1);

        //插入登记审批信息
        oConfirmInfo.setApplyID(sApplyID);
        oConfirmInfo.setConfirmUserID(account.getUserID());//从登录信息中取得
        oConfirmInfo.setTaskID(m_FlowEngine.getActivityInsIDByWorkitemID(
            lWorkitemID));
        oConfirmInfo.setConfirmDate(DateTimeKit.getCurrentTimestamp().substring(
            0, 10));
        String confirmIdea = "";
        if (sIsAgreeOfReg.equals("1")) {
          confirmIdea = "（同意）";
        }
        else {
          confirmIdea = "（不同意）";
        }
        oConfirmInfo.setConfirmIdea(uInfo.getRegistConfirmIdea() + confirmIdea);
        oConfirmInfo.setRemark("");//备注信息不用
        oConfirmInfo.setStatus("2");//表明是登记审批信息
        confirmDao.addConfirmInfo(oConfirmInfo);

        return mapping.findForward("success");
      }

      /*** 查阅流程的"登记"处理环节(登记审批不同意) ***/
      //上一个环节是"登记审批"环节
      if (flowInsStatus.equals("UNREGCONFIRMED")) {
        //业务数据部分
        //修改流程实例状态为"已登记",流程返回到"登记审批"环节
        hm.put("utilizeStatus", "REGISTED");
        hm.put("applyID", sApplyID);
        utilDao.updateUtilizeStatus(hm);
        //流程数据部分,检入工作项,参数1=""流程;此时不需要修查阅管理改流程变量,因此第二个参数为null
        m_FlowEngine.checkInTask(lWorkitemID,null,1);

        //插入登记信息
        oConfirmInfo.setApplyID(sApplyID);
        oConfirmInfo.setConfirmUserID(account.getUserID());//从登录信息中取得
        oConfirmInfo.setTaskID(m_FlowEngine.getActivityInsIDByWorkitemID(
            lWorkitemID));
        oConfirmInfo.setConfirmDate(DateTimeKit.getCurrentTimestamp().substring(
            0, 10));
        oConfirmInfo.setConfirmIdea("已登记");
        oConfirmInfo.setIsAgree("1");
        oConfirmInfo.setRemark("");//备注信息不用
        oConfirmInfo.setStatus("");//状态信息不用
        confirmDao.addConfirmInfo(oConfirmInfo);

        return mapping.findForward("success");
      }

      /*** 查阅流程的"归还"处理环节 ***/
      //上一个环节是"登记审批"环节
      if (flowInsStatus.equals("REGCONFIRMED") ||
          flowInsStatus.equals("UNRESCONFIRMED")) {
        //修改流程实例状态为"已归还"
        hm.put("utilizeStatus", "RESTORED");
        hm.put("applyID", sApplyID);
        utilDao.updateUtilizeStatus(hm);
        //检入工作项,参数1="查阅管理"流程;此时不需要修改流程变量,因此第二个参数为null
        m_FlowEngine.checkInTask(lWorkitemID,null,1);

        //插入归还信息
        oConfirmInfo.setApplyID(sApplyID);
        oConfirmInfo.setConfirmUserID(account.getUserID());//从登录信息中取得
        oConfirmInfo.setTaskID(m_FlowEngine.getActivityInsIDByWorkitemID(
            lWorkitemID));
        oConfirmInfo.setConfirmDate(DateTimeKit.getCurrentTimestamp().substring(
            0, 10));
        oConfirmInfo.setConfirmIdea("已归还");
        oConfirmInfo.setIsAgree("1");
        oConfirmInfo.setRemark("");//备注信息不用
        oConfirmInfo.setStatus("");//状态信息不用
        confirmDao.addConfirmInfo(oConfirmInfo);

        return mapping.findForward("success");
      }

      /*** 查阅流程的"归还审批"处理环节 ***/
      String sIsAgreeOfRestore = uInfo.getAgreeOfRestore();
      //上一个环节是"归还"环节
      if (flowInsStatus.equals("RESTORED")) {
        //设置HGAM的变量值
        oFormItem.setItemName("isAgree");
        if (sIsAgreeOfRestore.equals("1")) {
          oFormItem.setItemValue(new Boolean("true"));
          //修改流程实例状态为"归还审批同意"
          hm.put("utilizeStatus","RESCONFIRMED");
          hm.put("applyID",sApplyID);
          oConfirmInfo.setIsAgree("1");
          //修改文件状态为入库
          Map queryMap = new HashMap();
          Map updateMap = new HashMap();
          queryMap.put("applyID", sApplyID);
          List detailList = utilizeDetailDao.queryUtilizeDetailByApplyID(
              queryMap);
          UtilizeDetail utilDetail = null;
          for (int i = 0; i < detailList.size(); i++) {
            utilDetail = new UtilizeDetail();
            utilDetail = (UtilizeDetail) detailList.get(i);
            updateMap.put("isBorrow", "0");
            updateMap.put("fileID", utilDetail.getFile_id());
            archivesFileDao.updateBorrowStatusByFileID(updateMap);
          }
        }
        else {
          oFormItem.setItemValue(new Boolean("false"));
          //修改流程实例状态为"归还审批不同意"
          hm.put("utilizeStatus","UNRESCONFIRMED");
          hm.put("applyID",sApplyID);
          oConfirmInfo.setIsAgree("0");
        }
        utilDao.updateUtilizeStatus(hm);
        listFormItem.add(oFormItem);

        //检入工作项,参数1="查阅管理"流程
        m_FlowEngine.checkInTask(lWorkitemID,listFormItem,1);

        //插入归还审批信息
        oConfirmInfo.setApplyID(sApplyID);
        oConfirmInfo.setConfirmUserID(account.getUserID());//从登录信息中取得
        oConfirmInfo.setTaskID(m_FlowEngine.getActivityInsIDByWorkitemID(
            lWorkitemID));
        oConfirmInfo.setConfirmDate(DateTimeKit.getCurrentTimestamp().substring(
            0, 10));
        String confirmIdea = "";
        if (sIsAgreeOfRestore.equals("1")) {
          confirmIdea = "（同意）";
        }
        else {
          confirmIdea = "（不同意）";
        }
        oConfirmInfo.setConfirmIdea(uInfo.getRestoreConfirmIdea() + confirmIdea);
        oConfirmInfo.setRemark("");//备注信息不用
        oConfirmInfo.setStatus("3");//表明是归还审批信息
        confirmDao.addConfirmInfo(oConfirmInfo);

        return mapping.findForward("success");
      }

      /*** 查阅流程的"归还"处理环节(归还审批不同意) ***/
      //上一个环节是"归还审批"环节
      if (flowInsStatus.equals("UNRESCONFIRMED")) {
        //业务数据部分
        //修改流程实例状态为"已登记",流程返回到"归还审批"环节
        hm.put("utilizeStatus", "RESOTRED");
        hm.put("applyID", sApplyID);
        utilDao.updateUtilizeStatus(hm);
        //流程数据部分,检入工作项,参数1=""流程;此时不需要修查阅管理改流程变量,因此第二个参数为null
        m_FlowEngine.checkInTask(lWorkitemID,null,1);

        //插入归还信息
        oConfirmInfo.setApplyID(sApplyID);
        oConfirmInfo.setConfirmUserID(account.getUserID());//从登录信息中取得
        oConfirmInfo.setTaskID(m_FlowEngine.getActivityInsIDByWorkitemID(
            lWorkitemID));
        oConfirmInfo.setConfirmDate(DateTimeKit.getCurrentTimestamp().substring(
            0, 10));
        oConfirmInfo.setConfirmIdea("已归还");
        oConfirmInfo.setIsAgree("1");
        oConfirmInfo.setRemark("");//备注信息不用
        oConfirmInfo.setStatus("");//状态信息不用
        confirmDao.addConfirmInfo(oConfirmInfo);

        return mapping.findForward("success");
      }

      /*** 查阅流程的"反馈"处理环节 ***/
      //上一个环节是"归还已审批"环节
      if (flowInsStatus.equals("RESCONFIRMED")) {
        //修改流程实例状态为"已反馈"
        hm.put("utilizeStatus", "FEEDBACKED");
        hm.put("applyID", sApplyID);
        utilDao.updateUtilizeStatus(hm);
        //检入工作项,参数1="查阅管理"流程;此时不需要修改流程变量,因此第二个参数为null
        m_FlowEngine.checkInTask(lWorkitemID,null,1);

        //插入反馈信息
        oConfirmInfo.setApplyID(sApplyID);
        oConfirmInfo.setConfirmUserID(account.getUserID());//从登录信息中取得
        oConfirmInfo.setTaskID(m_FlowEngine.getActivityInsIDByWorkitemID(
            lWorkitemID));
        oConfirmInfo.setConfirmDate(DateTimeKit.getCurrentTimestamp().substring(
            0, 10));
        oConfirmInfo.setIsAgree("1");
        oConfirmInfo.setConfirmIdea(uInfo.getFeedbackIdea());
        oConfirmInfo.setRemark("");//备注信息不用
        oConfirmInfo.setStatus("4");//表明是反馈信息
        confirmDao.addConfirmInfo(oConfirmInfo);

        return mapping.findForward("success");
      }

      /*** 查阅流程的"收费"处理环节 ***/
      //上一个环节是"反馈"环节
      if (flowInsStatus.equals("FEEDBACKED")) {
        //修改流程实例状态为"已收费"
        hm.put("utilizeStatus", "CHARGED");
        hm.put("applyID", sApplyID);
        utilDao.updateUtilizeStatus(hm);
        //检入工作项,参数1="查阅管理"流程;此时不需要修改流程变量,因此第二个参数为null
        m_FlowEngine.checkInTask(lWorkitemID,null,1);

        //插入实收金额信息
        String totalCharge = uInfo.getRealGetMoney();
        hm = new HashMap();
        hm.put("realGetMoney",totalCharge);
        hm.put("applyID",sApplyID);
        int result = utilDao.updateChargeInfo(hm);
        if(result != 1){
          return mapping.findForward("endError");
        }

        //插入收费信息
        oConfirmInfo.setApplyID(sApplyID);
        oConfirmInfo.setConfirmUserID(account.getUserID());//从登录信息中取得
        oConfirmInfo.setTaskID(m_FlowEngine.getActivityInsIDByWorkitemID(
            lWorkitemID));
        oConfirmInfo.setConfirmDate(DateTimeKit.getCurrentTimestamp().substring(
            0, 10));
        oConfirmInfo.setConfirmIdea("已收费");
        oConfirmInfo.setIsAgree("1");
        oConfirmInfo.setRemark("");//备注信息不用
        oConfirmInfo.setStatus("");//状态信息不用
        confirmDao.addConfirmInfo(oConfirmInfo);

        return mapping.findForward("success");
      }

    }
    catch (Exception ex) {
      ex.printStackTrace();
    }

    //出错
    return mapping.findForward("endError");

  }

}