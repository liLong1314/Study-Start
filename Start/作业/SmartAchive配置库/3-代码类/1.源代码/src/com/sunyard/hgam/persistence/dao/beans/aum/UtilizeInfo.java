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
  private String utilizeTerm = ""; //��������
  private String beginDate = "";
  private String realReturnDate = "";
  private String applyDate = "";
  private String realGetMoney = ""; //ʵ�ս��
  private String handleMan = "";
  private String handleIdea = "";
  private String handleDate = "";
  private String latestRenewDate = ""; //�������ʱ��
  private String latestDunDate = ""; //������ʱ��
  private String remark = "";
  private String taskoption = "";
  private String flagHandler = ""; //�Ƿ��Ѿ�����
  private String taskName = ""; //��������
  private String flowInsID = ""; //����ʵ��ID

  /*** wanghua add 2004-01-10 ***/
  private String leadConfirmIdea = ""; //�쵼������
  private String registConfirmIdea = ""; //�Ǽ�������
  private String restoreConfirmIdea = ""; //�黹������
  private String feedbackIdea = ""; //������Ϣ
  private String external = ""; //�Ƿ��ⵥλ��Ա
  private String self = ""; //�Ƿ���ı���λ
  private String employee = ""; //�Ƿ�Ϊ������Ա
  /*** wanghua add end ***/

  /*** wanghua add 2004-01-11 ***/
  private String agree = ""; //�쵼����Ƿ�ͬ��
  private String agreeOfRegistration = ""; //�Ǽ�����Ƿ�ͬ��(�Ƿ�ͬ�����)
  private String agreeOfRestore = "";
  private String renew = ""; //�Ƿ�����
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