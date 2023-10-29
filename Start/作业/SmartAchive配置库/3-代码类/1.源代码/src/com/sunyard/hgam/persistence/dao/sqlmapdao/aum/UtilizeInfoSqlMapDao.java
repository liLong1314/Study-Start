package com.sunyard.hgam.persistence.dao.sqlmapdao.aum;

import com.sunyard.hgam.persistence.dao.base.BaseSqlMapDao;
import com.ibatis.common.util.PaginatedList;
import com.ibatis.db.dao.DaoException;
import java.util.*;
import com.sunyard.hgam.persistence.dao.iface.aum.UtilizeInfoDao;
import com.sunyard.hgam.persistence.dao.beans.aum.*;
import com.sunyard.hgam.flowengine.FlowEngine;
import com.sunyard.rdc.flowdriver.SunflowException;
import com.sunyard.rdc.flowdriver.TaskInfo;
import java.util.Date;
import com.sunyard.rdc.flowdriver.ShareFunc;

/**
 * <p>Title: �������ù���</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author �ܷ�, wanghua
 * @version 1.0
 */
public class UtilizeInfoSqlMapDao extends BaseSqlMapDao implements UtilizeInfoDao{

  public PaginatedList getUtilizeInfoByParams(HashMap hm) {
    PaginatedList list = null;
    try {
      this.startTransation();
      list = this.executeQueryForPaginatedList("getUtilizeInfoByNameStatusType", hm, this.PAGE_SIZE);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    return list;
  }

  /******************************************************
   * ����: ����applyID�õ�������Ϣ getUtilizePersonByID
   * @param   hm
   * @return
   ******************************************************/
  public UtilizeInfo getUtilizeInfoByApplyID(Map applyIDMap){

    UtilizeInfo uInfo = null;
    try{
      this.startTransation();
      uInfo = (UtilizeInfo)this.executeQueryForObject("getUtilizeInfoByApplyID",
          applyIDMap);
      this.commitTransation();
    }catch(DaoException ex){
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    return uInfo;

  }

  /******************************************************
   * ����: ���Ӳ�������
   * @param uInfo  UtilizeInfo����
   * @date 2004-01-15 wanghua added
   ******************************************************/
  public String addApply(UtilizeInfo uInfo) {

    String temp = null;
    try {
      this.startTransation();
      int result = this.executeUpdate("insertUtilizeInfo", uInfo);
      //��ȡ���������ֵ
      temp = (String) this.executeQueryForObject("getApplyID",uInfo);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    return temp;

  }

  /******************************************************
   * ����: ���ݲ��ķ�ʽ���Ƶõ�����ID
   * @param   pModeName  ���ķ�ʽ����
   * @return  ����ID
   ******************************************************/
  public int getUtilizeModeIDByName(String pModeName) {

    int retModeID = 0;

    try {
      this.startTransation();
      Integer oIntModeID = ( (Integer)this.executeQueryForObject(
          "getUtilModeIDByName", pModeName));
      this.commitTransation();
      retModeID = oIntModeID.intValue();
    }
    catch (DaoException ex) {
    }
    return retModeID;

  }


  public int addApplyDetail(HashMap[] hm) {
    int result = 0;
    try {
      this.startTransation();
      for(int i=0;i<hm.length;i++){
        result = this.executeUpdate("insertUtilizeDetail", hm[i]);
      }
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    return result;
  }

  /******************************************************
   * ����: ɾ��������Ϣ
   * @date 2004-02-17 wanghua added
   ******************************************************/
  public int deleteApplyInfoByApplyID(String applyID) {

    int result = 0;
    try {
      this.startTransation();
      result = this.executeUpdate("deleteUtilInfoByApplyID", applyID);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    return result;

  }


  public int updateUtilizeInfoForConfirm(HashMap hm) {
    int result = 0;
    try {
      this.startTransation();
      result = this.executeUpdate("updateUtilizeInfoForConfirm", hm);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    return result;
  }


  public int updateUtilizeInfoForRegi(HashMap hm) {
    int result = 0;
    try {
      this.startTransation();
      result = this.executeUpdate("updateUtilizeInfoForRegi", hm);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    return result;
  }


  public int updateUtilizeInfoForReturn(HashMap hm) {
    int result = 0;
    try {
      this.startTransation();
      result = this.executeUpdate("updateUtilizeInfoForReturn", hm);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    return result;
  }

  public int updateUtilizeInfoForCharge(HashMap hm) {
    int result = 0;
    try {
      this.startTransation();
      result = this.executeUpdate("updateUtilizeInfoForCharge", hm);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    return result;
  }

  /******************************************************
   * ����: ������������ID��������ʵ��״̬
   * @param hm  ��������ID�͸��º������״̬��HashMap��
   * @return ���ظ���Ӱ��ļ�¼��
   * @date  2004-01-11 wanghua add
   ******************************************************/
  public int updateUtilizeStatus(HashMap hm) {

    int result = 0;
    try {
      this.startTransation();
      result = this.executeUpdate("updateUtilizeStatus", hm);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    return result;
  }

  /******************************************************
   * ����: ������������ID��������ʵ��ID
   * @param hm  ��������ID�͸��º������״̬��HashMap��
   * @return ���ظ���Ӱ��ļ�¼��
   * @date  2004-01-11 wanghua add
   ******************************************************/
  public int updateFlowInsID(HashMap hm) {

    int result = 0;
    try {
      this.startTransation();
      result = this.executeUpdate("updateFlowInsID", hm);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    return result;
  }

  /******************************************************
   * ����: ������������ID�����շ���Ϣ
   * @param hm  ��������ID���շѵ�HashMap��
   * @return ���ظ���Ӱ��ļ�¼��
   * @date  2004-01-12 wanghua add
   ******************************************************/
  public int updateChargeInfo(HashMap hm) {
    int result = 0;
    try {
      this.startTransation();
      result = this.executeUpdate("updateChargeInfo", hm);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    return result;
  }

  /******************************************************
   * ����: ������е������÷�ʽ����
   * @return ���÷�ʽ���Ƶ��б�getAllTask
   * @date  2004-01-12 wanghua add
   ******************************************************/
  public List getAllUtilModeName() {

    List listModeName = new ArrayList();
    try {
      this.startTransation();
      listModeName = this.executeQueryForList("getAllUtilModeName", null);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    return listModeName;
  }

  /****************************************************************************
   * ����: �����������״̬�������ĳһ�����̵���������
   * @param   procDefID ���̶���ID,1="���Ĺ���"����,2="���Ĺ���"����,3="��֤����"����...
   *                              -1=��������
   * @return  ����������б�
   * @date  2004-01-12 wanghua add
   ****************************************************************************/
  public List getAllTaskByUser(String pLoginName, String pPassword, String type,
                               int procDefID) {

    List retListTask = new ArrayList();

    try {
      this.startTransation();
      //��ȡ������ĳһ���û�����������
      FlowEngine m_FlowEngine = new FlowEngine(pLoginName, pPassword);
      Iterator iterSunflowTask = m_FlowEngine.getAllTaskOfCurrentUser(procDefID);
      UtilizeInfo utilInfo = new UtilizeInfo();
      while (iterSunflowTask.hasNext()) {
        TaskInfo taskInfo = (TaskInfo) iterSunflowTask.next();
        String sApplyID = (java.lang.String)this.executeQueryForObject(
            "getApplyIDByFlowInsID", Long.toString(taskInfo.getProcInstanceID()));
        if (sApplyID == null || sApplyID.equals(""))
          //||taskInfo.getWorkitemName().equals("��������"))
          continue;

        Map applyIDMap = new HashMap();
        applyIDMap.put("applyID",sApplyID);
        utilInfo = (UtilizeInfo)this.executeQueryForObject("getUtilizeInfoByApplyID",
            applyIDMap);
        if (utilInfo == null) {
          continue;
        }
        //ת������״̬Ϊ�׶����ַ���
/*        String taskStatus = utilInfo.getUtilizeStatus();
        String statusForShow = "";
        if (taskStatus.equals("APPLIED")) {
          statusForShow = "������";
        }
        else if (taskStatus.equals("CONFIRMED")) {
          statusForShow = "�쵼�����ͨ��";
        }
        else if (taskStatus.equals("UNCONFIRMED")) {
          statusForShow = "�쵼���δͨ��";
        }
        else if (taskStatus.equals("REGISTED")) {
          statusForShow = "�ѵǼ�";
        }
        else if (taskStatus.equals("REGCONFIRMED")) {
          statusForShow = "���������ͨ��";
        }
        else if (taskStatus.equals("UNREGCONFIRMED")) {
          statusForShow = "�������δͨ��";
        }
        else if (taskStatus.equals("RESTORED")) {
          statusForShow = "�ѹ黹";
        }
        else if (taskStatus.equals("RESCONFIRMED")) {
          statusForShow = "�黹�����ͨ��";
        }
        else if (taskStatus.equals("UNRESCONFIRMED")) {
          statusForShow = "�黹���δͨ��";
        }
        else if (taskStatus.equals("FEEDBACKED")) {
          statusForShow = "�ѷ���";
        }
        else if (taskStatus.equals("CHARGED")) {
          statusForShow = "���շ�";
        }
        utilInfo.setUtilizeStatus(statusForShow);
*/
        //���ô����ڵ�����
        utilInfo.setTaskName(taskInfo.getWorkitemName());

        //��������״̬��������
        //��������
        if (type.equals("0")) {
          //���������Ƿ��Ѿ�����
          if (taskInfo.getFlagHandler().equals("2"))
            utilInfo.setFlagHandler("δ����");
          else if (taskInfo.getFlagHandler().equals("4"))
            utilInfo.setFlagHandler("���ڴ���");
          else if (taskInfo.getFlagHandler().equals("6"))
            utilInfo.setFlagHandler("�Ѵ���");

          //���������б�
          if (utilInfo != null)
            retListTask.add(utilInfo);
        }
        //δ������
        else if (type.equals("1")) {
          utilInfo.setFlagHandler("δ����");
          if (taskInfo.getFlagHandler().equals("2") && utilInfo != null)
              retListTask.add(utilInfo);
        }
        //�Ѱ�����
        else if (type.equals("2")) {
          utilInfo.setFlagHandler("�Ѵ���");
          if (taskInfo.getFlagHandler().equals("6") && utilInfo != null)
              retListTask.add(utilInfo);
        }

      }
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    catch (SunflowException se) {
      se.printStackTrace();
    }
    return retListTask;
  }

  /****************************************************************************
   * ����: �����������״̬�����ڻ������ĳһ�����̵�����������������������Ϣ
   * @param   procDefID ���̶���ID,1="���Ĺ���"����,2="���Ĺ���"����,3="��֤����"����...
   *                              -1=��������
   * @return  ����������б�
   * @date  2004-01-12 wanghua add
   ****************************************************************************/
  public List getAllTaskByUserSpan(String pLoginName, String pPassword,
                               String type, int procDefID, Date beginTime,
                               Date endTime) {

    List retListTask = new ArrayList();

    try {
      this.startTransation();
      //��ȡ������ĳһ���û�����������
      FlowEngine m_FlowEngine = new FlowEngine(pLoginName, pPassword);
      Iterator iterSunflowTask = m_FlowEngine.getAllTaskByUserNameSpan(
          procDefID, beginTime, endTime);
      UtilizeInfo utilInfo = new UtilizeInfo();
      while (iterSunflowTask.hasNext()) {
        TaskInfo taskInfo = (TaskInfo) iterSunflowTask.next();
        String sApplyID = (java.lang.String)this.executeQueryForObject(
            "getApplyIDByFlowInsID", Long.toString(taskInfo.getProcInstanceID()));
        if (sApplyID == null || sApplyID.equals(""))
          //||taskInfo.getWorkitemName().equals("��������"))
          continue;

        Map applyIDMap = new HashMap();
        applyIDMap.put("applyID",sApplyID);
        utilInfo = (UtilizeInfo)this.executeQueryForObject("getUtilizeInfoByApplyID",
            applyIDMap);
        if (utilInfo == null) {
          continue;
        }
        //ת������״̬Ϊ�׶����ַ���
/*        String taskStatus = utilInfo.getUtilizeStatus();
        String statusForShow = "";
        if (taskStatus.equals("APPLIED")) {
          statusForShow = "������";
        }
        else if (taskStatus.equals("CONFIRMED")) {
          statusForShow = "�쵼�����ͨ��";
        }
        else if (taskStatus.equals("UNCONFIRMED")) {
          statusForShow = "�쵼���δͨ��";
        }
        else if (taskStatus.equals("REGISTED")) {
          statusForShow = "�ѵǼ�";
        }
        else if (taskStatus.equals("REGCONFIRMED")) {
          statusForShow = "���������ͨ��";
        }
        else if (taskStatus.equals("UNREGCONFIRMED")) {
          statusForShow = "�������δͨ��";
        }
        else if (taskStatus.equals("RESTORED")) {
          statusForShow = "�ѹ黹";
        }
        else if (taskStatus.equals("RESCONFIRMED")) {
          statusForShow = "�黹�����ͨ��";
        }
        else if (taskStatus.equals("UNRESCONFIRMED")) {
          statusForShow = "�黹���δͨ��";
        }
        else if (taskStatus.equals("FEEDBACKED")) {
          statusForShow = "�ѷ���";
        }
        else if (taskStatus.equals("CHARGED")) {
          statusForShow = "���շ�";
        }
        utilInfo.setUtilizeStatus(statusForShow);
*/
        //���ô����ڵ�����
        utilInfo.setTaskName(taskInfo.getWorkitemName());

        //��������״̬��������
        //��������
        if (type.equals("0")) {
          //���������Ƿ��Ѿ�����
          if (taskInfo.getFlagHandler().equals("2"))
            utilInfo.setFlagHandler("δ����");
          else if (taskInfo.getFlagHandler().equals("4"))
            utilInfo.setFlagHandler("���ڴ���");
          else if (taskInfo.getFlagHandler().equals("6"))
            utilInfo.setFlagHandler("�Ѵ���");

          //���������б�
          if (utilInfo != null)
            retListTask.add(utilInfo);
        }
        //δ������
        else if (type.equals("1")) {
          utilInfo.setFlagHandler("δ����");
          if (taskInfo.getFlagHandler().equals("2") && utilInfo != null)
              retListTask.add(utilInfo);
        }
        //�Ѱ�����
        else if (type.equals("2")) {
          utilInfo.setFlagHandler("�Ѵ���");
          if (taskInfo.getFlagHandler().equals("6") && utilInfo != null)
              retListTask.add(utilInfo);
        }

      }
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    catch (SunflowException se) {
      se.printStackTrace();
    }
    return retListTask;
  }

  /*********************************************************************
   * ����: ���������������Ϣ
   * @date  2004-02-19 wanghua add
   *********************************************************************/
  public List getAllUtilizePersonInfo() {
    List list = null;
    try {
      this.startTransation();
      list = this.executeQueryForList("getAllUtilizePersonInfo", null);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    return list;
  }

  /****************************************************************************
   * ����: ���ݲ�ѯ�����������ĳһ�����̵���������
   * @param   procDefID ���̶���ID,1="���Ĺ���"����,2="���Ĺ���"����,3="��֤����"����...
   *                              -1=��������
   *          type 1="δ������",2="�Ѱ�����",0="��������"
   *          deliverBeginTime,deliverEndTime ��ʾ����Ĳ���ʱ��
   *          applyBeginTime,applyEndTime ��ʾ�����ʱ��
   *          utilizer ������
   * @return  ����������б�
   * @date  2004-03-13 wanghua add;2004-03-30 wanghua modify
   ****************************************************************************/
  public List getAllTaskByCondition(String pLoginName, String pPassword,
                                String type, int procDefID,
                                Date deliverBeginTime, Date deliverEndTime,
                                Date applyBeginTime, Date applyEndTime,
                                String utilizer) {
    List retListTask = new ArrayList();
    List tmpListTask = new ArrayList();
    UtilizeInfo utilInfo = null;
    tmpListTask = this.getAllTaskByUserSpan(pLoginName, pPassword, type,
                                            procDefID, deliverBeginTime,
                                            deliverEndTime);
    if (applyBeginTime == null) {
      if (applyEndTime == null) {
        applyBeginTime = ShareFunc.changeStr2DateTime("1900-01-01");
        applyEndTime = ShareFunc.changeStr2DateTime("2100-01-01");
      }
      else
        applyBeginTime = ShareFunc.changeStr2DateTime("1900-01-01");
    }
    else {
      if (applyEndTime == null)
        applyEndTime = ShareFunc.changeStr2DateTime("2100-01-01");
    }

    for (int i = 0; i < tmpListTask.size(); i++) {
      utilInfo = new UtilizeInfo();
      utilInfo = (UtilizeInfo) tmpListTask.get(i);
      Date aDate = ShareFunc.changeStr2DateTime(utilInfo.getBeginDate());
      if (utilizer == null || utilizer.equals("")) {
        if (aDate.after(applyBeginTime) && aDate.before(applyEndTime)) {
          retListTask.add(utilInfo);
        }
      }
      else if (utilInfo.getPersonName().equals(utilizer)) {
        if (aDate.after(applyBeginTime) && aDate.before(applyEndTime)) {
          retListTask.add(utilInfo);
        }
      }
    }
    return retListTask;
  }

  /******************************************************
   * ����: ������������ID������������
   * @date  2004-03-18 wanghua add
   ******************************************************/
  public int updateUtilizeTerm(HashMap hm) {

    int result = 0;
    try {
      this.startTransation();
      result = this.executeUpdate("updateUtilizeTerm", hm);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    return result;
  }

  /******************************************************
   * ����: ������������Ϣ
   * @date  2004-03-31 wanghua add
   ******************************************************/
  public int insertUtilizePerson(UtilizePerson utilizePerson) {

    int result = 0;
    try {
      this.startTransation();
      result = this.executeUpdate("insertUtilizePerson", utilizePerson);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    return result;
  }

  /******************************************************
   * ����: ������������Ϣ
   * @date  2004-03-31 wanghua add
   ******************************************************/
  public int updateUtilizePerson(UtilizePerson utilizePerson) {

    int result = 0;
    try {
      this.startTransation();
      result = this.executeUpdate("updateUtilizePerson", utilizePerson);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    return result;
  }

  /******************************************************
   * ����: ɾ����������Ϣ
   * @date  2004-03-31 wanghua add
   ******************************************************/
  public int deleteUtilizePerson(String person_id) {

    int result = 0;
    try {
      this.startTransation();
      result = this.executeUpdate("deleteUtilizePerson", person_id);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    return result;
  }

  /******************************************************
   * ����: ����person ID�õ�������Ϣ
   * @param   hm
   * @return
   ******************************************************/
  public UtilizePerson getUtilizePersonByID(String personID){

    UtilizePerson uPerson = null;
    try{
      this.startTransation();
      uPerson = (UtilizePerson)this.executeQueryForObject("getUtilizePersonByID",
          personID);
      this.commitTransation();
    }catch(DaoException ex){
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    return uPerson;

  }

}
