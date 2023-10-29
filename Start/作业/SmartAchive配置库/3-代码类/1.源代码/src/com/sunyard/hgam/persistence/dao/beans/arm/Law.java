package com.sunyard.hgam.persistence.dao.beans.arm;

import java.io.*;

/**
 * <p>Title: 法律法规管理</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 叶昊
 * @version 1.0
 */

public class Law implements Serializable{
  private String lawId;
  private String lawType;
  private String lawCode;
  private String lawDept;
  private String lawTitle;
  private String lawDate;
  private String lawContent;
  private String remark;
  private String lawDateFrom;
  private String lawDateTo;
  private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
    ois.defaultReadObject();
  }
  private void writeObject(ObjectOutputStream oos) throws IOException {
    oos.defaultWriteObject();
  }
  public String getLawContent() {
    return lawContent;
  }
  public void setLawContent(String lawContent) {
    this.lawContent = lawContent;
  }
  public String getLawDate() {
    return lawDate;
  }
  public void setLawDate(String lawDate) {
    this.lawDate = lawDate;
  }
  public String getLawDept() {
    return lawDept;
  }
  public void setLawDept(String lawDept) {
    this.lawDept = lawDept;
  }
  public String getLawId() {
    return lawId;
  }
  public void setLawId(String lawId) {
    this.lawId = lawId;
  }
  public String getLawType() {
    return lawType;
  }
  public void setLawType(String lawType) {
    this.lawType = lawType;
  }
  public String getRemark() {
    return remark;
  }
  public void setRemark(String remark) {
    this.remark = remark;
  }
  public String getLawTitle() {
    return lawTitle;
  }
  public void setLawTitle(String lawTitle) {
    this.lawTitle = lawTitle;
  }
  public String getLawCode() {
    return lawCode;
  }
  public void setLawCode(String lawCode) {
    this.lawCode = lawCode;
  }
  public String getLawDateFrom() {
    return lawDateFrom;
  }
  public void setLawDateFrom(String lawDateFrom) {
    this.lawDateFrom = lawDateFrom;
  }
  public String getLawDateTo() {
    return lawDateTo;
  }
  public void setLawDateTo(String lawDateTo) {
    this.lawDateTo = lawDateTo;
  }
}