package com.sunyard.hgam.persistence.dao.beans.arm;
import java.io.*;
/**
 * <p>Title: 鉴定清册</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 叶昊
 * @version 1.0
 */

public class Identify implements Serializable{
  private String checkupId;
  private String fileId;
  private String checkupOperator;
  private String checkupSituation;
  private String checkupDate;
  private String remark;
  private String isIdentify;
  private String identifyResult;
  private String[] filelist;
  private String checkupDateFrom;
  private String checkupDateTo;
  private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
    ois.defaultReadObject();
  }
  private void writeObject(ObjectOutputStream oos) throws IOException {
    oos.defaultWriteObject();
  }
  public String getCheckupDate() {
    return checkupDate;
  }
  public void setCheckupDate(String checkupDate) {
    this.checkupDate = checkupDate;
  }
  public String getCheckupId() {
    return checkupId;
  }
  public void setCheckupId(String checkupId) {
    this.checkupId = checkupId;
  }
  public String getCheckupOperator() {
    return checkupOperator;
  }
  public void setCheckupOperator(String checkupOperator) {
    this.checkupOperator = checkupOperator;
  }
  public String getCheckupSituation() {
    return checkupSituation;
  }
  public void setCheckupSituation(String checkupSituation) {
    this.checkupSituation = checkupSituation;
  }
  public String getFileId() {
    return fileId;
  }
  public void setFileId(String fileId) {
    this.fileId = fileId;
  }
  public String getRemark() {
    return remark;
  }
  public void setRemark(String remark) {
    this.remark = remark;
  }
  public String getIdentifyResult() {
    return identifyResult;
  }
  public void setIdentifyResult(String identifyResult) {
    this.identifyResult = identifyResult;
  }
  public String getIsIdentify() {
    return isIdentify;
  }
  public void setIsIdentify(String isIdentify) {
    this.isIdentify = isIdentify;
  }
  public String[] getFilelist() {
    return filelist;
  }
  public void setFilelist(String[] filelist) {
    this.filelist = filelist;
  }
  public String getCheckupDateFrom() {
    return checkupDateFrom;
  }
  public void setCheckupDateFrom(String checkupDateFrom) {
    this.checkupDateFrom = checkupDateFrom;
  }
  public String getCheckupDateTo() {
    return checkupDateTo;
  }
  public void setCheckupDateTo(String checkupDateTo) {
    this.checkupDateTo = checkupDateTo;
  }
}