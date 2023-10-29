package com.sunyard.hgam.persistence.dao.beans.arm;


import java.io.*;
/**
 * <p>Title: 监督检查管理</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 华良东
 * @version 1.0
 */

public class WatchExamine implements  Serializable {
  private String watchId;
  private String subCode;
  private String watchTitle;
  private String watchContent;
  private String watchTime;
  private String watchAuthor;
  private String remark;
  private String refWatchId;
  private String watchTimeFrom;
  private String watchTimeTo;
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
  public String getSubCode() {
    return subCode;
  }
  public void setSubCode(String subCode) {
    this.subCode = subCode;
  }
  public String getWatchAuthor() {
    return watchAuthor;
  }
  public void setWatchAuthor(String watchAuthor) {
    this.watchAuthor = watchAuthor;
  }
  public String getWatchContent() {
    return watchContent;
  }
  public void setWatchContent(String watchContent) {
    this.watchContent = watchContent;
  }
  public String getWatchId() {
    return watchId;
  }
  public void setWatchId(String watchId) {
    this.watchId = watchId;
  }
  public String getWatchTime() {
    return watchTime;
  }
  public void setWatchTime(String watchTime) {
    this.watchTime = watchTime;
  }
  public String getWatchTitle() {
    return watchTitle;
  }
  public void setWatchTitle(String watchTitle) {
    this.watchTitle = watchTitle;
  }
  public String getRefWatchId() {
    return refWatchId;
  }
  public void setRefWatchId(String refWatchId) {
    this.refWatchId = refWatchId;
  }
  public String getWatchTimeFrom() {
    return watchTimeFrom;
  }
  public void setWatchTimeFrom(String watchTimeFrom) {
    this.watchTimeFrom = watchTimeFrom;
  }
  public String getWatchTimeTo() {
    return watchTimeTo;
  }
  public void setWatchTimeTo(String watchTimeTo) {
    this.watchTimeTo = watchTimeTo;
  }

}