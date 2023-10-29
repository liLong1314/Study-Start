package com.sunyard.hgam.persistence.dao.beans.arm;

import java.io.*;
/**
 * <p>Title:杂项工程目录册管理</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 华良东
 * @version 1.0
 */

public class OtherCataLog implements Serializable{
  private String cataLogId;
  private String cataDate;
  private String cataNum;
  private String cataUnit;
  private String cataAddress;
  private String cataItem;
  private String cataBuid;
  private String cataSec;
  private String cataValue;
  private String cataCardDate;
  private String cataCardNum;
  private String cataMan;
  private String cataArea;
  private String remark;
  private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
  ois.defaultReadObject();
}
private void writeObject(ObjectOutputStream oos) throws IOException {
  oos.defaultWriteObject();
}

  public String getCataLogId() {
    return cataLogId;
  }
  public void setCataLogId(String cataLogId) {
    this.cataLogId = cataLogId;
  }
  public String getCataDate() {
    return cataDate;
  }
  public void setCataDate(String cataDate) {
    this.cataDate = cataDate;
  }
  public String getCataNum() {
    return cataNum;
  }
  public void setCataNum(String cataNum) {
    this.cataNum = cataNum;
  }
  public String getCataUnit() {
    return cataUnit;
  }
  public void setCataUnit(String cataUnit) {
    this.cataUnit = cataUnit;
  }
  public String getCataAddress() {
    return cataAddress;
  }
  public void setCataAddress(String cataAddress) {
    this.cataAddress = cataAddress;
  }
  public String getCataItem() {
    return cataItem;
  }
  public void setCataItem(String cataItem) {
    this.cataItem = cataItem;
  }
  public String getCataBuid() {
    return cataBuid;
  }
  public void setCataBuid(String cataBuid) {
    this.cataBuid = cataBuid;
  }
  public String getCataSec() {
    return cataSec;
  }
  public void setCataSec(String cataSec) {
    this.cataSec = cataSec;
  }
  public String getCataValue() {
    return cataValue;
  }
  public void setCataValue(String cataValue) {
    this.cataValue = cataValue;
  }
  public String getCataCardDate() {
    return cataCardDate;
  }
  public void setCataCardDate(String cataCardDate) {
    this.cataCardDate = cataCardDate;
  }
  public String getCataCardNum() {
    return cataCardNum;
  }
  public void setCataCardNum(String cataCardNum) {
    this.cataCardNum = cataCardNum;
  }
  public String getCataMan() {
    return cataMan;
  }
  public void setCataMan(String cataMan) {
    this.cataMan = cataMan;
  }
  public String getCataArea() {
    return cataArea;
  }
  public void setCataArea(String cataArea) {
    this.cataArea = cataArea;
  }
  public String getRemark() {
    return remark;
  }
  public void setRemark(String remark) {
    this.remark = remark;
  }


}