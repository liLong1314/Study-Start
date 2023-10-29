package com.sunyard.hgam.flowengine;

import com.sunyard.rdc.flowdriver.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Date;

/**
 * <p>Title: HGAM(杭州市规划档案综合管理系统) </p>
 * <p>Description: Sunflow引擎处理类 </p>
 * <p>Copyright: Sunhoo Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd. </p>
 * @author wanghua
 * @version 1.0
 */

public class FlowEngine {

  private FlowDriver m_FlowDriver = null;  //Sunflow引擎接口

  /***************************************************************
   * 功能: 构造函数,连接引擎
   * @param  pLoginName  登录名
   * @param  pPassword   登录密码
   * @exception  SunflowException
   ***************************************************************/
  public FlowEngine(String pLoginName, String pPassword) throws SunflowException {

    try {
      //连接引擎
      m_FlowDriver = new FlowDriver();
      m_FlowDriver.connect(pLoginName, pPassword);
      System.out.println("连接工作流引擎成功!");
    }
    catch (SunflowException ex) {
      throw ex;
    }

  }

  /**************************************************************************
   * 功能: 启动流程实例
   * @param  pFlowID  流程定义ID,1="查阅管理"流程,2="借阅管理"流程,3="查证管理"流程...
   * @param  pList    初始化流程实例相关数据的信息列表
   * @exception  SunflowException
   **************************************************************************/
  public String startFlow(int pFlowID, List pList) throws SunflowException {

    long flowInsID = 0;
    try {
      String sFlowDefName = "";
      /* 根据流程ID得到流程名称,暂时硬编码,以后可以通过一张map表映射HGAM流程定义ID和
         Sunflow的流程定义ID之间的关系 */
      switch (pFlowID) {
        case 1:
          sFlowDefName = "查阅管理";
          break;
        case 2:
          sFlowDefName = "借阅管理";
          break;
        case 3:
          sFlowDefName = "补证管理";
          break;
        default:
          break;
      }
      //根据流程名查找Sunflow流程定义ID
      long lFlowDefID = m_FlowDriver.getProcDefIDByName(sFlowDefName);
      //创建流程实例
      flowInsID = m_FlowDriver.createProcessInstance(lFlowDefID,
          sFlowDefName + (new Timestamp(System.currentTimeMillis())).toString(),
          "");
      //初始化流程实例的相关数据
      //m_FlowDriver.modifyProcessInstanceRelevantData(pList, pFlowID);
      //启动流程实例
      m_FlowDriver.startProcessInstance();
      System.out.println("启动流程实例成功!");
    }
    catch (SunflowException e) {
      throw e;
    }
    return Long.toString(flowInsID);
  }


  /***************************************************************
   * 功能: 断开工作流引擎
   * @exception  SunflowException
   ***************************************************************/
  public void disconnect() throws SunflowException {

    try {
      m_FlowDriver.disconnect();
    }
    catch (SunflowException ex) {
      throw ex;
    }

  }


  /****************************************************************
   * 功能: 根据工作项ID签收该工作项
   * @param      pWorkitemID    工作项ID
   * @exception  SunflowException
   ****************************************************************/
  public void checkOutTask(long pWorkitemID) throws SunflowException {

    try {
      m_FlowDriver.signforTask(pWorkitemID);
      System.out.println("CheckOut工作项成功!");
    }
    catch (SunflowException ex) {
      throw ex;
    }

  }

  /*********************************************************************
   * 功能: 提交某一项任务
   * @param      pWorkitemID          工作项ID
   * @param      pFormItemInfoList    流程相关变量列表,包含item name和item value
   * @param      pProDefType          流程定义类型:1=查阅,2=借阅,3=补证...
   * @exception  SunflowException
   **********************************************************************/
  public void checkInTask(long pWorkitemID, List pFormItemInfoList,
                       int pProDefType) throws SunflowException {

    try {
      m_FlowDriver.complete(pWorkitemID, pFormItemInfoList, pProDefType);
      System.out.println("CheckIn工作项成功!");
    }
    catch (SunflowException ex) {
      throw ex;
    }

  }

  /************************************************************
   * 功能: 根据流程定义ID获取当前用户要处理的所有任务
   * @param      procDefID 流程定义ID,1="查阅管理"流程,2="借阅管理"流程,3="查证管理"流程...
   * @exception  SunflowException
   * @return     Taskinfo对象集合
   ************************************************************/
  public Iterator getAllTaskOfCurrentUser(int procDefID) throws SunflowException {

    try {
      Iterator retIterTask = m_FlowDriver.getAllTaskByUserName(procDefID);
      System.out.println("获取任务成功!");
      return retIterTask;
    }
    catch (SunflowException ex) {
      throw ex;
    }

  }

  /************************************************************
   * 根据用户名获取某一个阶段的隶属于某一个流程的所有任务
   * @param      procDefID  流程定义ID,1="查阅管理"流程,2="借阅管理"流程,3="查证管理"流程...
   *             若procDefID=-1则返回所有任务
   * @exception  com.sunhoo.documentsmart.common.SunflowException
   * @return     Taskinfo对象集合
   ************************************************************/
  public Iterator getAllTaskByUserNameSpan(int procDefID, Date beginTime,
                                           Date endTime) throws
      SunflowException {

    try {
      Iterator retIterTask = m_FlowDriver.getAllTaskByUserNameSpan(procDefID,
          beginTime, endTime);
      System.out.println("获取任务成功!");
      return retIterTask;
    }
    catch (SunflowException ex) {
      throw ex;
    }

  }

  /************************************************************
   * 功能: 根据sessionID,applyID获取某用户要处理的某个任务
   * @param      String applyID
   * @exception  SunflowException
   * @return     TaskInfo类
   ************************************************************/
  public TaskInfo getTaskByApplyID(String applyID) throws Exception {

    TaskInfo retTaskInfo = new TaskInfo();
    retTaskInfo = m_FlowDriver.getTaskByApplyID(applyID);
    System.out.println("获取任务成功!");
    return retTaskInfo;

  }

  /************************************************************
   * 功能: 根据工作项ID得到该工作项所属的流程实例的状态
   * @param      pWorkitemID 工作项ID
   * @exception  SunflowException
   * @return     流程实例的状态
   ************************************************************/
  public String getFlowInsStatusByWorkitemID(long pWorkitemID) throws SunflowException {

    try {
      return m_FlowDriver.getProcessInstanceStatusByWorkitemID(pWorkitemID);
    }
    catch (SunflowException ex) {
      throw ex;
    }

  }

  /**
   * 根据工作项ID得到该工作项所属的活动实例ID
   * @param      workitemID   SunflowEngine工作项ID
   * @exception  com.sunyard.hgam.flowdriver.SunflowException
   * @return     该工作项所属的活动实例ID
   */
  public long getActivityInsIDByWorkitemID(long workitemID) throws SunflowException {

    try {
      return m_FlowDriver.getActivityInsIDByWorkitemID(workitemID);
    }
    catch (SunflowException ex) {
      throw ex;
    }

  }

  /**
   * 获取某一流程实例的信息
   * @param      proInsID   SunflowEngine流程实例ID
   * @exception  com.sunhoo.documentsmart.common.SunflowException
   * @return     FlowInfo对象
   * @date       wanghua added 2004/02/04
   */
  public List getAllTaskByProInsID(long proInsID) throws SunflowException {

    try {
      return m_FlowDriver.getAllTaskByProInsID(proInsID);
    }
    catch (SunflowException ex) {
      throw ex;
    }

  }

}