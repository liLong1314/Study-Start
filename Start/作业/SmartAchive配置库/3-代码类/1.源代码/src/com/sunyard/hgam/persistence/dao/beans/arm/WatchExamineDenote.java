package com.sunyard.hgam.persistence.dao.beans.arm;

import java.io.Serializable;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

/**
 * <p>Title:总局指示</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 华良东
 * @version 1.0
 */

public class WatchExamineDenote implements  Serializable{
  private String denoteId;
  private String denoteTitle;
  private String denoteContent;
  private String denoteSuperinrtendent;
  private String leadshiperSignature;
  private String denoteDate;
  private String watchId;
  private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
  ois.defaultReadObject();
}
private void writeObject(ObjectOutputStream oos) throws IOException {
  oos.defaultWriteObject();
}

  public String getDenoteId() {
    return denoteId;
  }
  public void setDenoteId(String denoteId) {
    this.denoteId = denoteId;
  }
  public String getDenoteTitle() {
    return denoteTitle;
  }
  public void setDenoteTitle(String denoteTitle) {
    this.denoteTitle = denoteTitle;
  }
  public String getDenoteContent() {
    return denoteContent;
  }
  public void setDenoteContent(String denoteContent) {
    this.denoteContent = denoteContent;
  }
  public String getDenoteSuperinrtendent() {
    return denoteSuperinrtendent;
  }
  public void setDenoteSuperinrtendent(String denoteSuperinrtendent) {
    this.denoteSuperinrtendent = denoteSuperinrtendent;
  }
  public String getLeadshiperSignature() {
    return leadshiperSignature;
  }
  public void setLeadshiperSignature(String leadshiperSignature) {
    this.leadshiperSignature = leadshiperSignature;
  }
  public String getDenoteDate() {
    return denoteDate;
  }
  public void setDenoteDate(String denoteDate) {
    this.denoteDate = denoteDate;
  }
  public String getWatchId() {
    return watchId;
  }
  public void setWatchId(String watchId) {
    this.watchId = watchId;
  }


}