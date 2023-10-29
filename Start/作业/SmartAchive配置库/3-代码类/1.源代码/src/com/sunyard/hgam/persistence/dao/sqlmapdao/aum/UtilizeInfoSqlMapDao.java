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
 * <p>Title: 档案利用管理</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 曹峰, wanghua
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
   * 功能: 根据applyID得到申请信息 getUtilizePersonByID
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
   * 功能: 增加查阅申请
   * @param uInfo  UtilizeInfo对象
   * @date 2004-01-15 wanghua added
   ******************************************************/
  public String addApply(UtilizeInfo uInfo) {

    String temp = null;
    try {
      this.startTransation();
      int result = this.executeUpdate("insertUtilizeInfo", uInfo);
      //获取插入的主键值
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
   * 功能: 根据查阅方式名称得到查阅ID
   * @param   pModeName  查阅方式名称
   * @return  查阅ID
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
   * 功能: 删除申请信息
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
   * 功能: 根据利用申请ID更新流程实例状态
   * @param hm  利用申请ID和更新后的流程状态的HashMap表
   * @return 返回更新影响的记录数
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
   * 功能: 根据利用申请ID更新流程实例ID
   * @param hm  利用申请ID和更新后的流程状态的HashMap表
   * @return 返回更新影响的记录数
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
   * 功能: 根据利用申请ID更新收费信息
   * @param hm  利用申请ID和收费的HashMap表
   * @return 返回更新影响的记录数
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
   * 功能: 获得所有档案利用方式名称
   * @return 利用方式名称的列表getAllTask
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
   * 功能: 根据任务处理的状态获得属于某一个流程的所有任务
   * @param   procDefID 流程定义ID,1="查阅管理"流程,2="借阅管理"流程,3="查证管理"流程...
   *                              -1=所有流程
   * @return  所有任务的列表
   * @date  2004-01-12 wanghua add
   ****************************************************************************/
  public List getAllTaskByUser(String pLoginName, String pPassword, String type,
                               int procDefID) {

    List retListTask = new ArrayList();

    try {
      this.startTransation();
      //获取引擎中某一个用户的所有任务
      FlowEngine m_FlowEngine = new FlowEngine(pLoginName, pPassword);
      Iterator iterSunflowTask = m_FlowEngine.getAllTaskOfCurrentUser(procDefID);
      UtilizeInfo utilInfo = new UtilizeInfo();
      while (iterSunflowTask.hasNext()) {
        TaskInfo taskInfo = (TaskInfo) iterSunflowTask.next();
        String sApplyID = (java.lang.String)this.executeQueryForObject(
            "getApplyIDByFlowInsID", Long.toString(taskInfo.getProcInstanceID()));
        if (sApplyID == null || sApplyID.equals(""))
          //||taskInfo.getWorkitemName().equals("查阅申请"))
          continue;

        Map applyIDMap = new HashMap();
        applyIDMap.put("applyID",sApplyID);
        utilInfo = (UtilizeInfo)this.executeQueryForObject("getUtilizeInfoByApplyID",
            applyIDMap);
        if (utilInfo == null) {
          continue;
        }
        //转化任务状态为易读懂字符串
/*        String taskStatus = utilInfo.getUtilizeStatus();
        String statusForShow = "";
        if (taskStatus.equals("APPLIED")) {
          statusForShow = "已申请";
        }
        else if (taskStatus.equals("CONFIRMED")) {
          statusForShow = "领导审核已通过";
        }
        else if (taskStatus.equals("UNCONFIRMED")) {
          statusForShow = "领导审核未通过";
        }
        else if (taskStatus.equals("REGISTED")) {
          statusForShow = "已登记";
        }
        else if (taskStatus.equals("REGCONFIRMED")) {
          statusForShow = "出库审核已通过";
        }
        else if (taskStatus.equals("UNREGCONFIRMED")) {
          statusForShow = "出库审核未通过";
        }
        else if (taskStatus.equals("RESTORED")) {
          statusForShow = "已归还";
        }
        else if (taskStatus.equals("RESCONFIRMED")) {
          statusForShow = "归还审核已通过";
        }
        else if (taskStatus.equals("UNRESCONFIRMED")) {
          statusForShow = "归还审核未通过";
        }
        else if (taskStatus.equals("FEEDBACKED")) {
          statusForShow = "已反馈";
        }
        else if (taskStatus.equals("CHARGED")) {
          statusForShow = "已收费";
        }
        utilInfo.setUtilizeStatus(statusForShow);
*/
        //设置处理环节的名称
        utilInfo.setTaskName(taskInfo.getWorkitemName());

        //根据任务状态过滤任务
        //所有任务
        if (type.equals("0")) {
          //设置任务是否已经处理
          if (taskInfo.getFlagHandler().equals("2"))
            utilInfo.setFlagHandler("未处理");
          else if (taskInfo.getFlagHandler().equals("4"))
            utilInfo.setFlagHandler("正在处理");
          else if (taskInfo.getFlagHandler().equals("6"))
            utilInfo.setFlagHandler("已处理");

          //增加任务列表
          if (utilInfo != null)
            retListTask.add(utilInfo);
        }
        //未办任务
        else if (type.equals("1")) {
          utilInfo.setFlagHandler("未处理");
          if (taskInfo.getFlagHandler().equals("2") && utilInfo != null)
              retListTask.add(utilInfo);
        }
        //已办任务
        else if (type.equals("2")) {
          utilInfo.setFlagHandler("已处理");
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
   * 功能: 根据任务处理的状态和日期获得属于某一个流程的所有任务获得所有利用者信息
   * @param   procDefID 流程定义ID,1="查阅管理"流程,2="借阅管理"流程,3="查证管理"流程...
   *                              -1=所有流程
   * @return  所有任务的列表
   * @date  2004-01-12 wanghua add
   ****************************************************************************/
  public List getAllTaskByUserSpan(String pLoginName, String pPassword,
                               String type, int procDefID, Date beginTime,
                               Date endTime) {

    List retListTask = new ArrayList();

    try {
      this.startTransation();
      //获取引擎中某一个用户的所有任务
      FlowEngine m_FlowEngine = new FlowEngine(pLoginName, pPassword);
      Iterator iterSunflowTask = m_FlowEngine.getAllTaskByUserNameSpan(
          procDefID, beginTime, endTime);
      UtilizeInfo utilInfo = new UtilizeInfo();
      while (iterSunflowTask.hasNext()) {
        TaskInfo taskInfo = (TaskInfo) iterSunflowTask.next();
        String sApplyID = (java.lang.String)this.executeQueryForObject(
            "getApplyIDByFlowInsID", Long.toString(taskInfo.getProcInstanceID()));
        if (sApplyID == null || sApplyID.equals(""))
          //||taskInfo.getWorkitemName().equals("查阅申请"))
          continue;

        Map applyIDMap = new HashMap();
        applyIDMap.put("applyID",sApplyID);
        utilInfo = (UtilizeInfo)this.executeQueryForObject("getUtilizeInfoByApplyID",
            applyIDMap);
        if (utilInfo == null) {
          continue;
        }
        //转化任务状态为易读懂字符串
/*        String taskStatus = utilInfo.getUtilizeStatus();
        String statusForShow = "";
        if (taskStatus.equals("APPLIED")) {
          statusForShow = "已申请";
        }
        else if (taskStatus.equals("CONFIRMED")) {
          statusForShow = "领导审核已通过";
        }
        else if (taskStatus.equals("UNCONFIRMED")) {
          statusForShow = "领导审核未通过";
        }
        else if (taskStatus.equals("REGISTED")) {
          statusForShow = "已登记";
        }
        else if (taskStatus.equals("REGCONFIRMED")) {
          statusForShow = "出库审核已通过";
        }
        else if (taskStatus.equals("UNREGCONFIRMED")) {
          statusForShow = "出库审核未通过";
        }
        else if (taskStatus.equals("RESTORED")) {
          statusForShow = "已归还";
        }
        else if (taskStatus.equals("RESCONFIRMED")) {
          statusForShow = "归还审核已通过";
        }
        else if (taskStatus.equals("UNRESCONFIRMED")) {
          statusForShow = "归还审核未通过";
        }
        else if (taskStatus.equals("FEEDBACKED")) {
          statusForShow = "已反馈";
        }
        else if (taskStatus.equals("CHARGED")) {
          statusForShow = "已收费";
        }
        utilInfo.setUtilizeStatus(statusForShow);
*/
        //设置处理环节的名称
        utilInfo.setTaskName(taskInfo.getWorkitemName());

        //根据任务状态过滤任务
        //所有任务
        if (type.equals("0")) {
          //设置任务是否已经处理
          if (taskInfo.getFlagHandler().equals("2"))
            utilInfo.setFlagHandler("未处理");
          else if (taskInfo.getFlagHandler().equals("4"))
            utilInfo.setFlagHandler("正在处理");
          else if (taskInfo.getFlagHandler().equals("6"))
            utilInfo.setFlagHandler("已处理");

          //增加任务列表
          if (utilInfo != null)
            retListTask.add(utilInfo);
        }
        //未办任务
        else if (type.equals("1")) {
          utilInfo.setFlagHandler("未处理");
          if (taskInfo.getFlagHandler().equals("2") && utilInfo != null)
              retListTask.add(utilInfo);
        }
        //已办任务
        else if (type.equals("2")) {
          utilInfo.setFlagHandler("已处理");
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
   * 功能: 获得所有利用者信息
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
   * 功能: 根据查询条件获得属于某一个流程的所有任务
   * @param   procDefID 流程定义ID,1="查阅管理"流程,2="借阅管理"流程,3="查证管理"流程...
   *                              -1=所有流程
   *          type 1="未办任务",2="已办任务",0="所有任务"
   *          deliverBeginTime,deliverEndTime 表示任务的产生时间
   *          applyBeginTime,applyEndTime 表示申请的时间
   *          utilizer 申请人
   * @return  所有任务的列表
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
   * 功能: 根据利用申请ID更新利用期限
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
   * 功能: 增加申请人信息
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
   * 功能: 更新申请人信息
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
   * 功能: 删除申请人信息
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
   * 功能: 根据person ID得到申请信息
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
