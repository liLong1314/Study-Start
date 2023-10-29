package com.sunyard.hgam.flowengine;

import com.sunyard.rdc.flowdriver.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Date;

/**
 * <p>Title: HGAM(�����й滮�����ۺϹ���ϵͳ) </p>
 * <p>Description: Sunflow���洦���� </p>
 * <p>Copyright: Sunhoo Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd. </p>
 * @author wanghua
 * @version 1.0
 */

public class FlowEngine {

  private FlowDriver m_FlowDriver = null;  //Sunflow����ӿ�

  /***************************************************************
   * ����: ���캯��,��������
   * @param  pLoginName  ��¼��
   * @param  pPassword   ��¼����
   * @exception  SunflowException
   ***************************************************************/
  public FlowEngine(String pLoginName, String pPassword) throws SunflowException {

    try {
      //��������
      m_FlowDriver = new FlowDriver();
      m_FlowDriver.connect(pLoginName, pPassword);
      System.out.println("���ӹ���������ɹ�!");
    }
    catch (SunflowException ex) {
      throw ex;
    }

  }

  /**************************************************************************
   * ����: ��������ʵ��
   * @param  pFlowID  ���̶���ID,1="���Ĺ���"����,2="���Ĺ���"����,3="��֤����"����...
   * @param  pList    ��ʼ������ʵ��������ݵ���Ϣ�б�
   * @exception  SunflowException
   **************************************************************************/
  public String startFlow(int pFlowID, List pList) throws SunflowException {

    long flowInsID = 0;
    try {
      String sFlowDefName = "";
      /* ��������ID�õ���������,��ʱӲ����,�Ժ����ͨ��һ��map��ӳ��HGAM���̶���ID��
         Sunflow�����̶���ID֮��Ĺ�ϵ */
      switch (pFlowID) {
        case 1:
          sFlowDefName = "���Ĺ���";
          break;
        case 2:
          sFlowDefName = "���Ĺ���";
          break;
        case 3:
          sFlowDefName = "��֤����";
          break;
        default:
          break;
      }
      //��������������Sunflow���̶���ID
      long lFlowDefID = m_FlowDriver.getProcDefIDByName(sFlowDefName);
      //��������ʵ��
      flowInsID = m_FlowDriver.createProcessInstance(lFlowDefID,
          sFlowDefName + (new Timestamp(System.currentTimeMillis())).toString(),
          "");
      //��ʼ������ʵ�����������
      //m_FlowDriver.modifyProcessInstanceRelevantData(pList, pFlowID);
      //��������ʵ��
      m_FlowDriver.startProcessInstance();
      System.out.println("��������ʵ���ɹ�!");
    }
    catch (SunflowException e) {
      throw e;
    }
    return Long.toString(flowInsID);
  }


  /***************************************************************
   * ����: �Ͽ�����������
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
   * ����: ���ݹ�����IDǩ�ոù�����
   * @param      pWorkitemID    ������ID
   * @exception  SunflowException
   ****************************************************************/
  public void checkOutTask(long pWorkitemID) throws SunflowException {

    try {
      m_FlowDriver.signforTask(pWorkitemID);
      System.out.println("CheckOut������ɹ�!");
    }
    catch (SunflowException ex) {
      throw ex;
    }

  }

  /*********************************************************************
   * ����: �ύĳһ������
   * @param      pWorkitemID          ������ID
   * @param      pFormItemInfoList    ������ر����б�,����item name��item value
   * @param      pProDefType          ���̶�������:1=����,2=����,3=��֤...
   * @exception  SunflowException
   **********************************************************************/
  public void checkInTask(long pWorkitemID, List pFormItemInfoList,
                       int pProDefType) throws SunflowException {

    try {
      m_FlowDriver.complete(pWorkitemID, pFormItemInfoList, pProDefType);
      System.out.println("CheckIn������ɹ�!");
    }
    catch (SunflowException ex) {
      throw ex;
    }

  }

  /************************************************************
   * ����: �������̶���ID��ȡ��ǰ�û�Ҫ�������������
   * @param      procDefID ���̶���ID,1="���Ĺ���"����,2="���Ĺ���"����,3="��֤����"����...
   * @exception  SunflowException
   * @return     Taskinfo���󼯺�
   ************************************************************/
  public Iterator getAllTaskOfCurrentUser(int procDefID) throws SunflowException {

    try {
      Iterator retIterTask = m_FlowDriver.getAllTaskByUserName(procDefID);
      System.out.println("��ȡ����ɹ�!");
      return retIterTask;
    }
    catch (SunflowException ex) {
      throw ex;
    }

  }

  /************************************************************
   * �����û�����ȡĳһ���׶ε�������ĳһ�����̵���������
   * @param      procDefID  ���̶���ID,1="���Ĺ���"����,2="���Ĺ���"����,3="��֤����"����...
   *             ��procDefID=-1�򷵻���������
   * @exception  com.sunhoo.documentsmart.common.SunflowException
   * @return     Taskinfo���󼯺�
   ************************************************************/
  public Iterator getAllTaskByUserNameSpan(int procDefID, Date beginTime,
                                           Date endTime) throws
      SunflowException {

    try {
      Iterator retIterTask = m_FlowDriver.getAllTaskByUserNameSpan(procDefID,
          beginTime, endTime);
      System.out.println("��ȡ����ɹ�!");
      return retIterTask;
    }
    catch (SunflowException ex) {
      throw ex;
    }

  }

  /************************************************************
   * ����: ����sessionID,applyID��ȡĳ�û�Ҫ�����ĳ������
   * @param      String applyID
   * @exception  SunflowException
   * @return     TaskInfo��
   ************************************************************/
  public TaskInfo getTaskByApplyID(String applyID) throws Exception {

    TaskInfo retTaskInfo = new TaskInfo();
    retTaskInfo = m_FlowDriver.getTaskByApplyID(applyID);
    System.out.println("��ȡ����ɹ�!");
    return retTaskInfo;

  }

  /************************************************************
   * ����: ���ݹ�����ID�õ��ù���������������ʵ����״̬
   * @param      pWorkitemID ������ID
   * @exception  SunflowException
   * @return     ����ʵ����״̬
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
   * ���ݹ�����ID�õ��ù����������Ļʵ��ID
   * @param      workitemID   SunflowEngine������ID
   * @exception  com.sunyard.hgam.flowdriver.SunflowException
   * @return     �ù����������Ļʵ��ID
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
   * ��ȡĳһ����ʵ������Ϣ
   * @param      proInsID   SunflowEngine����ʵ��ID
   * @exception  com.sunhoo.documentsmart.common.SunflowException
   * @return     FlowInfo����
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