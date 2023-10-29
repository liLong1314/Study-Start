package com.sunyard.hgam.persistence.dao.beans.smm;

import java.io.*;
/**
 * <p>Title: 参数管理</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 华良东
 * @version 1.0
 */

public class SysParam implements Serializable{
  private String sysParamId;
  private String sysParamType;
  private String sysParamName;
  private String sysParamValue;
  private String remark;
  private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
    ois.defaultReadObject();
  }
  private void writeObject(ObjectOutputStream oos) throws IOException {
    oos.defaultWriteObject();
  }

  public String getSysParamId() {
    return sysParamId;
  }
  public void setSysParamId(String sysParamId) {
    this.sysParamId = sysParamId;
  }
  public String getSysParamType() {
    return sysParamType;
  }
  public void setSysParamType(String sysParamType) {
    this.sysParamType = sysParamType;
  }
  public String getSysParamName() {
    return sysParamName;
  }
  public void setSysParamName(String sysParamName) {
    this.sysParamName = sysParamName;
  }
  public String getSysParamValue() {
    return sysParamValue;
  }
  public void setSysParamValue(String sysParamValue) {
    this.sysParamValue = sysParamValue;
  }
  public String getRemark() {
    return remark;
  }
  public void setRemark(String remark) {
    this.remark = remark;
  }

}