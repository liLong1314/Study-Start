package com.sunyard.hgam.persistence.dao.beans.aum;

import java.io.*;

/**
 * <p>Title: HGAM</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author not attributable
 * @version 1.0
 */

public class ChargeStandard implements Serializable {
  private String charge_id;
  private String sentryid;
  private String charge_mode;
  private String charge_version;
  private String charge_begin_date;
  private String charge_end_date;
  private String charge_money;
  private String charge_base;
  private String remark;

  public ChargeStandard() {
  }
  private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
    ois.defaultReadObject();
  }
  private void writeObject(ObjectOutputStream oos) throws IOException {
    oos.defaultWriteObject();
  }
  public String getCharge_id() {
    return charge_id;
  }
  public void setCharge_id(String charge_id) {
    this.charge_id = charge_id;
  }
  public String getSentryid() {
    return sentryid;
  }
  public void setSentryid(String sentryid) {
    this.sentryid = sentryid;
  }
  public String getCharge_mode() {
    return charge_mode;
  }
  public void setCharge_mode(String charge_mode) {
    this.charge_mode = charge_mode;
  }
  public String getCharge_version() {
    return charge_version;
  }
  public void setCharge_version(String charge_version) {
    this.charge_version = charge_version;
  }
  public String getCharge_begin_date() {
    return charge_begin_date;
  }
  public void setCharge_begin_date(String charge_begin_date) {
    this.charge_begin_date = charge_begin_date;
  }
  public String getCharge_end_date() {
    return charge_end_date;
  }
  public void setCharge_end_date(String charge_end_date) {
    this.charge_end_date = charge_end_date;
  }
  public String getCharge_money() {
    return charge_money;
  }
  public void setCharge_money(String charge_money) {
    this.charge_money = charge_money;
  }
  public String getCharge_base() {
    return charge_base;
  }
  public void setCharge_base(String charge_base) {
    this.charge_base = charge_base;
  }
  public String getRemark() {
    return remark;
  }
  public void setRemark(String remark) {
    this.remark = remark;
  }

}