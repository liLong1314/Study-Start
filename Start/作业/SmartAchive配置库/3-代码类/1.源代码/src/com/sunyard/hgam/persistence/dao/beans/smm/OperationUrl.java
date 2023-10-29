package com.sunyard.hgam.persistence.dao.beans.smm;

import java.io.*;

/**
 * <p>Title: Hang Zhou Net Archives</p>
 * <p>Description: 杭州市网上档案馆建设（一期）</p>
 * <p>Copyright: Hangzhou Sunyard System Engineering， Ltd. All rights reserved @2003</p>
 * <p>Company: sunhoo.com</p>
 * @author not attributable
 * @version 1.00
 */

public class OperationUrl implements Serializable {
  private String operID;
  private String operCode;
  private String url;
  private String operDesc;
  private String isLog;
  private String remark;
  private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
    ois.defaultReadObject();
  }
  private void writeObject(ObjectOutputStream oos) throws IOException {
    oos.defaultWriteObject();
  }
  public String getOperID() {
    return operID;
  }
  public void setOperID(String operID) {
    this.operID = operID;
  }
  public String getOperCode() {
    return operCode;
  }
  public void setOperCode(String operCode) {
    this.operCode = operCode;
  }
  public String getUrl() {
    return url;
  }
  public void setUrl(String url) {
    this.url = url;
  }
  public String getOperDesc() {
    return operDesc;
  }
  public void setOperDesc(String operDesc) {
    this.operDesc = operDesc;
  }
  public String getIsLog() {
    return isLog;
  }
  public void setIsLog(String isLog) {
    this.isLog = isLog;
  }
  public String getRemark() {
    return remark;
  }
  public void setRemark(String remark) {
    this.remark = remark;
  }
}