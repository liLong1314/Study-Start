package com.sunyard.hgam.persistence.dao.beans.arm;

import java.io.*;
/**
 * <p>Title: 类目管理</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 叶昊
 * @version 1.0
 */

public class Entry implements Serializable {
  private String entryId;
  private String fatherEntryId;
  private String entryLevel;
  private String entryName;
  private String isOperation;
  private String remark;
  private String is_charge;
  private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
    ois.defaultReadObject();
  }
  private void writeObject(ObjectOutputStream oos) throws IOException {
    oos.defaultWriteObject();
  }
  public String getEntryId() {
    return entryId;
  }
  public void setEntryId(String entryId) {
    this.entryId = entryId;
  }
  public String getFatherEntryId() {
    return fatherEntryId;
  }
  public void setFatherEntryId(String fatherEntryId) {
    this.fatherEntryId = fatherEntryId;
  }
  public String getEntryLevel() {
    return entryLevel;
  }
  public void setEntryLevel(String entryLevel) {
    this.entryLevel = entryLevel;
  }
  public String getEntryName() {
    return entryName;
  }
  public void setEntryName(String entryName) {
    this.entryName = entryName;
  }
  public String getIsOperation() {
    return isOperation;
  }
  public void setIsOperation(String isOperation) {
    this.isOperation = isOperation;
  }
  public String getRemark() {
    return remark;
  }
  public void setRemark(String remark) {
    this.remark = remark;
  }
  public String getIs_charge() {
    return is_charge;
  }
  public void setIs_charge(String is_charge) {
    this.is_charge = is_charge;
  }

}