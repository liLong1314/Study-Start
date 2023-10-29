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

public class Log implements Serializable {
  private String logID;
  private String userID;
  private String ip;
  private String operID;
  private String resultCode;
  private String logMsg;
  private String type;
  private String occurTime;
  private String userName;
  public String getLogID() {
    return logID;
  }
  public void setLogID(String logID) {
    this.logID = logID;
  }
  public String getUserID() {
    return userID;
  }
  public void setUserID(String userID) {
    this.userID = userID;
  }
  public String getIp() {
    return ip;
  }
  public void setIp(String ip) {
    this.ip = ip;
  }
  public String getOperID() {
    return operID;
  }
  public void setOperID(String operID) {
    this.operID = operID;
  }
  public String getResultCode() {
    return resultCode;
  }
  public void setResultCode(String resultCode) {
    this.resultCode = resultCode;
  }
  public String getLogMsg() {
    return logMsg;
  }
  public void setLogMsg(String logMsg) {
    this.logMsg = logMsg;
  }
  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }
  public String getOccurTime() {
    return occurTime;
  }
  public void setOccurTime(String occurTime) {
    this.occurTime = occurTime;
  }
  private void writeObject(ObjectOutputStream oos) throws IOException {
    oos.defaultWriteObject();
  }
  private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
    ois.defaultReadObject();
  }
  public String getUserName() {
    return userName;
  }
  public void setUserName(String userName) {
    this.userName = userName;
  }
}