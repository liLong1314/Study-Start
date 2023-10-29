package com.sunyard.hgam.persistence.dao.beans.arm;

import java.io.*;
/**
 * <p>Title: 安全管理</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 叶昊
 * @version 1.0
 */

public class Safety implements Serializable{
 private String safetyId;
 private String roomCode;
 private String safetyType;
 private String safetySituation;
 private String safetyChecker;
 private String safetyCheckDate;
 private String safetyDealWithPerson;
 private String safetyDealedDate;
 private String safetyResult;
 private String remark;
 private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
   ois.defaultReadObject();
 }
 private void writeObject(ObjectOutputStream oos) throws IOException {
   oos.defaultWriteObject();
 }
  public String getRemark() {
    return remark;
  }
  public void setRemark(String remark) {
    this.remark = remark;
  }
  public String getRoomCode() {
    return roomCode;
  }
  public void setRoomCode(String roomCode) {
    this.roomCode = roomCode;
  }
  public String getSafetyCheckDate() {
    return safetyCheckDate;
  }
  public void setSafetyCheckDate(String safetyCheckDate) {
    this.safetyCheckDate = safetyCheckDate;
  }
  public String getSafetyChecker() {
    return safetyChecker;
  }
  public void setSafetyChecker(String safetyChecker) {
    this.safetyChecker = safetyChecker;
  }
  public String getSafetyDealedDate() {
    return safetyDealedDate;
  }
  public void setSafetyDealedDate(String safetyDealedDate) {
    this.safetyDealedDate = safetyDealedDate;
  }
  public String getSafetyDealWithPerson() {
    return safetyDealWithPerson;
  }
  public void setSafetyDealWithPerson(String safetyDealWithPerson) {
    this.safetyDealWithPerson = safetyDealWithPerson;
  }
  public String getSafetyId() {
    return safetyId;
  }
  public void setSafetyId(String safetyId) {
    this.safetyId = safetyId;
  }
  public String getSafetyResult() {
    return safetyResult;
  }
  public void setSafetyResult(String safetyResult) {
    this.safetyResult = safetyResult;
  }
  public String getSafetySituation() {
    return safetySituation;
  }
  public void setSafetySituation(String safetySituation) {
    this.safetySituation = safetySituation;
  }
  public String getSafetyType() {
    return safetyType;
  }
  public void setSafetyType(String safetyType) {
    this.safetyType = safetyType;
  }
}