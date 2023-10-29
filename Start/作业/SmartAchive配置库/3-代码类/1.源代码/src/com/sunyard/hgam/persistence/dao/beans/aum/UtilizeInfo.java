package com.sunyard.hgam.persistence.dao.beans.aum;

import java.io.Serializable;
import java.util.List;

public class UtilizeInfo
    implements Serializable {

  private String applyID = "";
  private String personID = "";
  private String userID = "";
  private String typeID = "";
  private String modeID = "";
  private String personName = "";
  private String personCorp = "";
  private String modeName = "";
  private String utilizeStatus = "";
  private String aim = "";
  private String utilizeTerm = ""; //利用期限
  private String beginDate = "";
  private String realReturnDate = "";
  private String applyDate = "";
  private String realGetMoney = ""; //实收金额
  private String handleMan = "";
  private String handleIdea = "";
  private String handleDate = "";
  private String latestRenewDate = ""; //最后续借时间
  private String latestDunDate = ""; //最后催收时间
  private String remark = "";
  private String taskoption = "";
  private String flagHandler = ""; //是否已经处理
  private String taskName = ""; //任务名称
  private String flowInsID = ""; //流程实例ID

  /*** wanghua add 2004-01-10 ***/
  private String leadConfirmIdea = ""; //领导审核意见
  private String registConfirmIdea = ""; //登记审核意见
  private String restoreConfirmIdea = ""; //归还审核意见
  private String feedbackIdea = ""; //反馈信息
  private String external = ""; //是否外单位人员
  private String self = ""; //是否查阅本单位
  private String employee = ""; //是否为机关人员
  /*** wanghua add end ***/

  /*** wanghua add 2004-01-11 ***/
  private String agree = ""; //领导审核是否同意
  private String agreeOfRegistration = ""; //登记审核是否同意(是否同意出库)
  private String agreeOfRestore = "";
  private String renew = ""; //是否续借
  private List listModeName;
  /*** wanghua add end ***/

  public UtilizeInfo() {
  }

  public String getAgree() {
    return agree;
  }

  public String getAgreeOfRegistration() {
    return agreeOfRegistration;
  }

  public String getAgreeOfRestore() {
    return agreeOfRestore;
  }

  public String getAim() {
    return aim;
  }

  public String getApplyDate() {
    return applyDate;
  }

  public String getApplyID() {
    return applyID;
  }

  public String getBeginDate() {
    return beginDate;
  }

  public String getExternal() {
    return external;
  }

  public String getFeedbackIdea() {
    return feedbackIdea;
  }

  public String getHandleDate() {
    return handleDate;
  }

  public String getHandleIdea() {
    return handleIdea;
  }

  public String getHandleMan() {
    return handleMan;
  }

  public String getLatestDunDate() {
    return latestDunDate;
  }

  public String getLatestRenewDate() {
    return latestRenewDate;
  }

  public String getLeadConfirmIdea() {
    return leadConfirmIdea;
  }

  public List getListModeName() {
    return listModeName;
  }

  public String getModeID() {
    return modeID;
  }

  public String getModeName() {
    return modeName;
  }

  public String getPersonCorp() {
    return personCorp;
  }

  public String getPersonID() {
    return personID;
  }

  public String getPersonName() {
    return personName;
  }

  public String getRealGetMoney() {
    return realGetMoney;
  }

  public String getRealReturnDate() {
    return realReturnDate;
  }

  public String getRegistConfirmIdea() {
    return registConfirmIdea;
  }

  public String getRemark() {
    return remark;
  }

  public String getRestoreConfirmIdea() {
    return restoreConfirmIdea;
  }

  public void setAgreeOfRegistration(String agreeOfRegistration) {
    this.agreeOfRegistration = agreeOfRegistration;
  }

  public void setAgree(String agree) {
    this.agree = agree;
  }

  public void setAgreeOfRestore(String agreeOfRestore) {
    this.agreeOfRestore = agreeOfRestore;
  }

  public void setAim(String aim) {
    this.aim = aim;
  }

  public void setApplyDate(String applyDate) {
    this.applyDate = applyDate;
  }

  public void setApplyID(String applyID) {
    this.applyID = applyID;
  }

  public void setBeginDate(String beginDate) {
    this.beginDate = beginDate;
  }

  public void setExternal(String external) {
    this.external = external;
  }

  public void setFeedbackIdea(String feedbackIdea) {
    this.feedbackIdea = feedbackIdea;
  }

  public void setHandleDate(String handleDate) {
    this.handleDate = handleDate;
  }

  public void setHandleIdea(String handleIdea) {
    this.handleIdea = handleIdea;
  }

  public void setHandleMan(String handleMan) {
    this.handleMan = handleMan;
  }

  public void setLatestDunDate(String latestDunDate) {
    this.latestDunDate = latestDunDate;
  }

  public void setLatestRenewDate(String latestRenewDate) {
    this.latestRenewDate = latestRenewDate;
  }

  public void setLeadConfirmIdea(String leadConfirmIdea) {
    this.leadConfirmIdea = leadConfirmIdea;
  }

  public void setListModeName(List listModeName) {
    this.listModeName = listModeName;
  }

  public void setModeID(String modeID) {
    this.modeID = modeID;
  }

  public void setModeName(String modeName) {
    this.modeName = modeName;
  }

  public void setPersonCorp(String personCorp) {
    this.personCorp = personCorp;
  }

  public void setPersonID(String personID) {
    this.personID = personID;
  }

  public void setPersonName(String personName) {
    this.personName = personName;
  }

  public void setRealGetMoney(String realGetMoney) {
    this.realGetMoney = realGetMoney;
  }

  public void setRealReturnDate(String realReturnDate) {
    this.realReturnDate = realReturnDate;
  }

  public void setRegistConfirmIdea(String registConfirmIdea) {
    this.registConfirmIdea = registConfirmIdea;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public void setRestoreConfirmIdea(String restoreConfirmIdea) {
    this.restoreConfirmIdea = restoreConfirmIdea;
  }

  public String getSelf() {
    return self;
  }

  public String getTaskoption() {
    return taskoption;
  }

  public String getTypeID() {
    return typeID;
  }

  public String getUserID() {
    return userID;
  }

  public String getUtilizeStatus() {
    return utilizeStatus;
  }

  public String getUtilizeTerm() {
    return utilizeTerm;
  }

  public void setSelf(String self) {
    this.self = self;
  }

  public void setTaskoption(String taskoption) {
    this.taskoption = taskoption;
  }

  public void setTypeID(String typeID) {
    this.typeID = typeID;
  }

  public void setUserID(String userID) {
    this.userID = userID;
  }

  public void setUtilizeStatus(String utilizeStatus) {
    this.utilizeStatus = utilizeStatus;
  }

  public void setUtilizeTerm(String utilizeTerm) {
    this.utilizeTerm = utilizeTerm;
  }

  public String getFlagHandler() {
    return flagHandler;
  }

  public void setFlagHandler(String flagHandler) {
    this.flagHandler = flagHandler;
  }

  public String getTaskName() {
    return taskName;
  }

  public void setTaskName(String taskName) {
    this.taskName = taskName;
  }

  public String getEmployee() {
    return employee;
  }

  public void setEmployee(String employee) {
    this.employee = employee;
  }

  public String getRenew() {
    return renew;
  }

  public void setRenew(String renew) {
    this.renew = renew;
  }

  public String getFlowInsID() {
    return flowInsID;
  }

  public void setFlowInsID(String flowInsID) {
    this.flowInsID = flowInsID;
  }

}