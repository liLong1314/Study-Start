package com.sunyard.hgam.persistence.dao.beans.arm;

import java.io.*;
/**
 * <p>Title: 分局目录管理</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 华良东
 * @version 1.0
 */

public class SubRollCatalog
 implements Serializable{
  private String rollCataId;
  private String subCode;
  private String rollCataTitle;
  private String rollCataMegn;
  private String rollCataDate;
  private String rollCataStor;
  private String remark;
  private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
  ois.defaultReadObject();
}
private void writeObject(ObjectOutputStream oos) throws IOException {
  oos.defaultWriteObject();
}
public String getRollCataId() {
 return rollCataId;
}
public void setRollCataId(String rollCataId) {
 this.rollCataId = rollCataId;
}

  public String getSubCode() {
    return subCode;
  }
  public void setSubCode(String subCode) {
    this.subCode = subCode;
  }
  public String getRollCataTitle() {
    return rollCataTitle;
  }
  public void setRollCataTitle(String rollCataTitle) {
    this.rollCataTitle = rollCataTitle;
  }
  public String getRollCataMegn() {
    return rollCataMegn;
  }
  public void setRollCataMegn(String rollCataMegn) {
    this.rollCataMegn = rollCataMegn;
  }
  public String getRollCataDate() {
    return rollCataDate;
  }
  public void setRollCataDate(String rollCataDate) {
    this.rollCataDate = rollCataDate;
  }
  public String getRollCataStor() {
    return rollCataStor;
  }
  public void setRollCataStor(String rollCataStor) {
    this.rollCataStor = rollCataStor;
  }
  public String getRemark() {
    return remark;
  }
  public void setRemark(String remark) {
    this.remark = remark;
  }

}