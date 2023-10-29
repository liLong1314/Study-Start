package com.sunyard.hgam.persistence.dao.beans.arm;
import java.io.*;
/**
 * <p>Title: 全宗卷信息</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 叶昊
 * @version 1.0
 */

public class Whole implements Serializable{
  private String wholeId;
  private String wholeType;
  private String wholeYear;
  private String wholeName;
  private String wholeMakeMan;
  private String wholeMakeDate;
  private String wholeContent;
  private String remark;
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
  public String getWholeContent() {
    return wholeContent;
  }
  public void setWholeContent(String wholeContent) {
    this.wholeContent = wholeContent;
  }
  public String getWholeId() {
    return wholeId;
  }
  public void setWholeId(String wholeId) {
    this.wholeId = wholeId;
  }
  public String getWholeMakeDate() {
    return wholeMakeDate;
  }
  public void setWholeMakeDate(String wholeMakeDate) {
    this.wholeMakeDate = wholeMakeDate;
  }
  public String getWholeMakeMan() {
    return wholeMakeMan;
  }
  public void setWholeMakeMan(String wholeMakeMan) {
    this.wholeMakeMan = wholeMakeMan;
  }
  public String getWholeName() {
    return wholeName;
  }
  public void setWholeName(String wholeName) {
    this.wholeName = wholeName;
  }
  public String getWholeType() {
    return wholeType;
  }
  public void setWholeType(String wholeType) {
    this.wholeType = wholeType;
  }
  public String getWholeYear() {
    return wholeYear;
  }
  public void setWholeYear(String wholeYear) {
    this.wholeYear = wholeYear;
  }
}