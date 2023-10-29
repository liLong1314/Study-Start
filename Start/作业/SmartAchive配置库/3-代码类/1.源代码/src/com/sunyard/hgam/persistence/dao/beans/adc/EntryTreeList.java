package com.sunyard.hgam.persistence.dao.beans.adc;

import java.io.*;

/**
 * <p>Title: HGAM</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 郑先全
 * @version 1.0
 */

public class EntryTreeList implements Serializable {
  private String entryName;
  private String remark;
  private int entryLevel;
  private Integer entryId;
  private Integer fatherEntryId;
  private String isOperation;
  private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
    ois.defaultReadObject();
  }
  private void writeObject(ObjectOutputStream oos) throws IOException {
    oos.defaultWriteObject();
  }
  public Integer getEntryId() {
    return entryId;
  }
  public void setEntryId(Integer entryId) {
    this.entryId = entryId;
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
  public Integer getFatherEntryId() {
    return fatherEntryId;
  }
  public void setFatherEntryId(Integer fatherEntryId) {
    this.fatherEntryId = fatherEntryId;
  }
  public int getEntryLevel() {
    return entryLevel;
  }
  public void setEntryLevel(int entryLevel) {
    this.entryLevel = entryLevel;
  }
}