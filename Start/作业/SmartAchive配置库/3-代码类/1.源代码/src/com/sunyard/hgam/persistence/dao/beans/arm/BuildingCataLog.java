package com.sunyard.hgam.persistence.dao.beans.arm;

import java.io.*;
/**
 * <p>Title: 建筑目录册管理</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 华良东
 * @version 1.0
 */
public class BuildingCataLog implements Serializable {
  private String cataId;
  private String cataBeginDate;
  private String cataOrder;
  private String cataCardNum;
  private String cataAdress;
  private String cataArea;
  private String cataArkNum;
  private String cataUnit;
  private String cataItem;
  private String cataMapNum;
  private String cataLevel;
  private String cataStruts;
  private String cataEndData;
  private String remark;
  private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
   ois.defaultReadObject();
 }
 private void writeObject(ObjectOutputStream oos) throws IOException {
   oos.defaultWriteObject();
 }

  public String getCataId() {
    return cataId;
  }
  public void setCataId(String cataId) {
    this.cataId = cataId;
  }
  public String getCataBeginDate() {
    return cataBeginDate;
  }
  public void setCataBeginDate(String cataBeginDate) {
    this.cataBeginDate = cataBeginDate;
  }
  public String getCataOrder() {
    return cataOrder;
  }
  public void setCataOrder(String cataOrder) {
    this.cataOrder = cataOrder;
  }
  public String getCataCardNum() {
    return cataCardNum;
  }
  public void setCataCardNum(String cataCardNum) {
    this.cataCardNum = cataCardNum;
  }
  public String getCataAdress() {
    return cataAdress;
  }
  public void setCataAdress(String cataAdress) {
    this.cataAdress = cataAdress;
  }
  public String getCataArea() {
    return cataArea;
  }
  public void setCataArea(String cataArea) {
    this.cataArea = cataArea;
  }
  public String getCataArkNum() {
    return cataArkNum;
  }
  public void setCataArkNum(String cataArkNum) {
    this.cataArkNum = cataArkNum;
  }
  public String getCataUnit() {
    return cataUnit;
  }
  public void setCataUnit(String cataUnit) {
    this.cataUnit = cataUnit;
  }
  public String getCataItem() {
    return cataItem;
  }
  public void setCataItem(String cataItem) {
    this.cataItem = cataItem;
  }
  public String getCataMapNum() {
    return cataMapNum;
  }
  public void setCataMapNum(String cataMapNum) {
    this.cataMapNum = cataMapNum;
  }
  public String getCataLevel() {
    return cataLevel;
  }
  public void setCataLevel(String cataLevel) {
    this.cataLevel = cataLevel;
  }
  public String getCataStruts() {
    return cataStruts;
  }
  public void setCataStruts(String cataStruts) {
    this.cataStruts = cataStruts;
  }
  public String getCataEndData() {
    return cataEndData;
  }
  public void setCataEndData(String cataEndData) {
    this.cataEndData = cataEndData;
  }
  public String getRemark() {
    return remark;
  }
  public void setRemark(String remark) {
    this.remark = remark;
  }

}