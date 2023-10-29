package com.sunyard.hgam.persistence.dao.beans.adc;

import java.io.*;

/**
 *
 * <p>Title: HGAM</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 郑先全
 * @version 1.0
 */
public class EformDefine implements Serializable {
  private String eform_id;
  private String eform_name;
  private String eform_version;
  private String eform_begin_date;
  private String eform_end_date;
  private String entry_id;
  private String remark;

  private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
    ois.defaultReadObject();
  }
  private void writeObject(ObjectOutputStream oos) throws IOException {
    oos.defaultWriteObject();
  }
  public String getEform_id() {
    return eform_id;
  }
  public void setEform_id(String eform_id) {
    this.eform_id = eform_id;
  }
  public String getEform_name() {
    return eform_name;
  }
  public void setEform_name(String eform_name) {
    this.eform_name = eform_name;
  }
  public String getEform_version() {
    return eform_version;
  }
  public void setEform_version(String eform_version) {
    this.eform_version = eform_version;
  }
  public String getEform_begin_date() {
    return eform_begin_date;
  }
  public void setEform_begin_date(String eform_begin_date) {
    this.eform_begin_date = eform_begin_date;
  }
  public String getEform_end_date() {
    return eform_end_date;
  }
  public void setEform_end_date(String eform_end_date) {
    this.eform_end_date = eform_end_date;
  }
  public String getEntry_id() {
    return entry_id;
  }
  public void setEntry_id(String entry_id) {
    this.entry_id = entry_id;
  }
  public String getRemark() {
    return remark;
  }
  public void setRemark(String remark) {
    this.remark = remark;
  }
}