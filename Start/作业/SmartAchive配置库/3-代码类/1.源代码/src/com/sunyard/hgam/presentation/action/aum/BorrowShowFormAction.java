package com.sunyard.hgam.presentation.action.aum;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.persistence.dao.iface.aum.UtilizeInfoDao;
import com.sunyard.hgam.persistence.dao.beans.aum.UtilizeInfo;
import com.sunyard.hgam.presentation.form.aum.UtilizeInfoForm;
import com.sunyard.hgam.persistence.dao.iface.aum.ConfirmInfoDao;
import com.sunyard.hgam.persistence.dao.beans.aum.ConfirmInfo;
import java.util.List;
import java.util.ArrayList;
import com.sunyard.hgam.flowengine.FlowEngine;
import com.sunyard.rdc.flowdriver.*;
import com.sunyard.hgam.persistence.dao.iface.aum.UtilizeDetailDao;
import java.util.Map;
import java.util.HashMap;
import com.sunyard.hgam.persistence.dao.beans.smm.Account;
import com.sunyard.hgam.persistence.dao.iface.smm.AccountDAO;
import com.sunyard.hgam.presentation.form.smm.AccountForm;
import java.util.Date;
import com.sunyard.hgam.util.aum.Blackbox;
import com.sunyard.hgam.persistence.dao.beans.aum.UrgeInfoForOA;
import com.sunyard.hgam.persistence.dao.beans.aum.UtilizeDetail;

/**
 * <p>Title: HGAM(杭州市规划档案综合管理系统) </p>
 * <p>Description: 显示某一个任务的表单Action </p>
 * <p>Copyright: Sunhoo Copyright (c) 2004 </p>
 * <p>Company: Sunhoo Software Co.,Ltd. </p>
 * @author wanghua
 * @version 1.0
 */

public class BorrowShowFormAction
    extends BaseAction {


  public ActionForward doPerform(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response)  {

    String flag = request.getParameter("flag");
    String flagHandler = request.getParameter("flagHandler");
    String forwardJSP = "";

    UtilizeInfoForm utilForm = (UtilizeInfoForm) form;
    UtilizeInfo utilInfo = new UtilizeInfo();
    UtilizeInfoDao utilDao = (UtilizeInfoDao) domainLogic.getDAO(
        "UtilizeInfoDao");
    ConfirmInfoDao confirmDao = (ConfirmInfoDao) domainLogic.getDAO(
        "ConfirmInfo");
    UtilizeDetailDao utilizeDetailDao = (UtilizeDetailDao) domainLogic.getDAO(
        "UtilizeDetail");
    AccountDAO accountDAO = (AccountDAO) domainLogic.getDAO("Account");

    //获取登录信息
    String loginName = "";
    String pwd = "";
    Account oAccount = new Account();
    AccountForm accountInfo = (AccountForm) request.getSession().getAttribute(
        "ACCOUNT_INFORMATION");
    if (accountInfo != null) {
      oAccount = accountInfo.getAccount();
      loginName = oAccount.getUserName();
    }
    pwd = accountDAO.getPasswordByUsername(loginName);

    String applyID = utilForm.getUtilizeInfo().getTaskoption();
    if (applyID==null || applyID.equals("")) {
      applyID = (String)request.getSession().getAttribute("applyID");
    }
    Map applyIDMap = new HashMap();
    applyIDMap.put("applyID",applyID);
    utilInfo = utilDao.getUtilizeInfoByApplyID(applyIDMap);
    String flowInsID = utilInfo.getFlowInsID();

    ConfirmInfo confirmInfo = new ConfirmInfo();
    List listConfirmInfo = new ArrayList();
    listConfirmInfo = confirmDao.getConfirmInfoByApplyID(applyID);

    //处理任务
    if (flag.equals("HANDLER")) {

      try {
        //设置是否为机关人员
        if (utilInfo.getSelf().equals("0")) {
          utilInfo.setEmployee("0");
        }
        else {
          utilInfo.setEmployee("1");
        }

        //设置审批和反馈信息
        if (listConfirmInfo.size() <= 0) {
          utilInfo.setAgreeOfRegistration(null);
          utilInfo.setAgreeOfRestore(null);
        }
        else {
          for (int i = 0; i < listConfirmInfo.size(); i++) {
            confirmInfo = (ConfirmInfo) listConfirmInfo.get(i);
            String type = confirmInfo.getStatus();
            String isAgree = confirmInfo.getIsAgree();
            String confirmIdea = confirmInfo.getConfirmIdea();

            if (type != null) {

              //领导审批信息
              if (type.equals("1")) {
                if (isAgree.equals("1")) {
                  utilInfo.setAgree("1");
                }
                else {
                  utilInfo.setAgree("0");
                }
                utilInfo.setLeadConfirmIdea(confirmIdea);
              }

              //登记审批信息
              if (type.equals("2")) {
                if (isAgree.equals("1")) {
                  utilInfo.setAgreeOfRegistration("1");
                }
                else {
                  utilInfo.setAgreeOfRegistration("0");
                }
                utilInfo.setRegistConfirmIdea(confirmIdea);
              }

              //归还审批信息
              if (type.equals("3")) {
                if (isAgree.equals("1")) {
                  utilInfo.setAgreeOfRestore("1");
                }
                else {
                  utilInfo.setAgreeOfRestore("0");
                }
                utilInfo.setRestoreConfirmIdea(confirmIdea);
              }

            }
          }
        }

        //设置提交按钮的值
        String status = utilInfo.getUtilizeStatus();
        String btnCaption = "";

        if (status.equals("UNCONFIRMED")) {
          btnCaption = "申请";
        }
        else if (status.equals("APPLIED")) {
          btnCaption = "领导审批";
        }
        else if (status.equals("CONFIRMED") || status.equals("UNREGCONFIRMED")) {
          btnCaption = "登记";
        }
        else if (status.equals("REGISTED")) {
          btnCaption = "出库审核";
        }
        else if (status.equals("REGCONFIRMED") || status.equals("URGED") ||
                 status.equals("RENEWED")) {
          btnCaption = "归还";
        }
        else if (status.equals("EXPIRED")) {
          btnCaption = "催收";
        }
        else if (status.equals("RESTORED")) {
          btnCaption = "收费";
        }
        else if (status.equals("CHARGED")) {
          btnCaption = "申请结束";
        }

        //设置应收金额
        long totalCharge = utilizeDetailDao.getTotalChargeByApplyID(applyID);

        //设置是否打印催收单
        String bPrintUrgeForm = "0";
        String modeID = utilInfo.getModeID();
        //ModeID:"1"=纸资文档
        if ((btnCaption.equals("催收"))&&(modeID.equals("1")))
          bPrintUrgeForm = "1";

        request.getSession().setAttribute("utilFormbtnCaption", utilForm);
        request.getSession().setAttribute("utilInfo", utilInfo);
        request.getSession().setAttribute("totalCharge",
                                          Long.toString(totalCharge));
        request.getSession().setAttribute("bPrintUrgeForm", bPrintUrgeForm);
        request.getSession().setAttribute("btnCaption", btnCaption);

        //设置是否已经处理的标志
        if (flagHandler == null || flagHandler.equals("已处理"))
          request.getSession().setAttribute("isHandler","1");
        else
          request.getSession().setAttribute("isHandler","0");

        //计算是否超期
        String bExpire = "0";
        UtilizeInfo tempUtilInfo = new UtilizeInfo();
        tempUtilInfo = utilDao.getUtilizeInfoByApplyID(applyIDMap);
        Date beginDate = Blackbox.changeStr2DateTime(tempUtilInfo.getBeginDate());
        Date now = new Date();
        Date endDate = Blackbox.changeStr2DateTime(now.toLocaleString());
        long term = Long.parseLong(tempUtilInfo.getUtilizeTerm());
        if (term < Blackbox.computeInterval(beginDate, endDate))
          bExpire = "1";

        if (btnCaption.equals("登记")) {
          //插入催还信息for OA
          if (bExpire.equals("1")) {
            UrgeInfoForOA urgeInfoForOA = null;
            //设置超期的档案号
            List overdueArchives = utilizeDetailDao.queryOverdueArchByApplyID(
                applyID);
            UtilizeDetail uDetail = null;
            UtilizeInfo utilizeInfo = null;
            String archivesNum = "";
            for (int i = 0; i < overdueArchives.size(); i++) {
              uDetail = new UtilizeDetail();
              uDetail = (UtilizeDetail) overdueArchives.get(i);
              urgeInfoForOA = new UrgeInfoForOA();
              urgeInfoForOA.setArchives_num(uDetail.getArchives_num());
              urgeInfoForOA.setArchives_name(uDetail.getArchives_name());
              if (uDetail.getPage_count()==null)
                urgeInfoForOA.setPage_amount("0");
              else
                urgeInfoForOA.setPage_amount(uDetail.getPage_count());
              utilizeInfo = new UtilizeInfo();
              utilizeInfo = utilDao.getUtilizeInfoByApplyID(applyIDMap);
              urgeInfoForOA.setBorrow_person(utilizeInfo.getPersonName());
              //设置实际应该归还日期
              String oughtReturn = Blackbox.computeContinueTime(utilizeInfo.
                  getBeginDate(), Integer.parseInt(utilizeInfo.getUtilizeTerm()));
              urgeInfoForOA.setMust_return_date(oughtReturn);
              urgeInfoForOA.setIs_return("0");
              urgeInfoForOA.setRemark("超期");
              utilizeDetailDao.insertUrgeInfoForOA(urgeInfoForOA);
            }
          }
        }

        request.getSession().setAttribute("bExpire",bExpire);

        request.getSession().setAttribute("flowDefID","2");

        forwardJSP = "HANDLER";
      }
      catch (Exception ex1) {
        ex1.printStackTrace();
      }
    }

    //跟踪流程实例
    else if (flag.equals("TRACE")) {

      try {
        TaskInfo taskInfo = null;
        FlowEngine m_FlowEngine = new FlowEngine(loginName, pwd);
        String taskName = "";
        List taskList = m_FlowEngine.getAllTaskByProInsID(Long.parseLong(
            flowInsID));
        List confirmList = new ArrayList();
        List retTaskList = new ArrayList();
        for (int i = 0; i < taskList.size(); i++) {
          utilInfo = new UtilizeInfo();
          taskInfo = new TaskInfo();
          taskInfo = (TaskInfo)taskList.get(i);
          taskName = taskInfo.getWorkitemName();
          if (taskName.equals("借阅申请") || taskName.equals("领导审核"))
            continue;
          confirmList = confirmDao.getConfirmInfoByTaskID(Long.toString(
              taskInfo.getWorkItemID()));
          if (confirmList.size() == 0) {
            utilInfo.setTaskName(taskInfo.getWorkitemName());
            utilInfo.setFlagHandler(taskInfo.getFlagHandler());
            retTaskList.add(utilInfo);
          }
          else {
            Account account = null;
            for (int j = 0; j < confirmList.size(); j++) {
              confirmInfo = new ConfirmInfo();
              utilInfo = new UtilizeInfo();
              confirmInfo = (ConfirmInfo) confirmList.get(j);
              utilInfo.setTaskName(taskInfo.getWorkitemName());
              account = new Account();
              account = accountDAO.getAccountByUserID(confirmInfo.getConfirmUserID());
              utilInfo.setHandleMan(account.getName());
              utilInfo.setHandleDate(confirmInfo.getConfirmDate());
              utilInfo.setHandleIdea(confirmInfo.getConfirmIdea());
              utilInfo.setFlagHandler(taskInfo.getFlagHandler());
              retTaskList.add(utilInfo);
            }
          }
        }

        request.getSession().setAttribute("actList", retTaskList);
        //导航到跟踪页面
        forwardJSP = "TRACE";
      }
      catch (Exception ex) {
        ex.printStackTrace();
        forwardJSP = "ERROR";
      }

    }

    System.out.println("显示任务表单成功!");
    return mapping.findForward(forwardJSP);

  }

}