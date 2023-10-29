package com.sunyard.hgam.persistence.dao.beans.pub;

import java.io.*;

public class PublishInfoAccessory implements Serializable {
  private String accessory_id = "";
  private String accessory_title = "";
  private String accessory_filename = "";
  private String remark = "";
  private String info_id = "";
  private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
    ois.defaultReadObject();
  }
  private void writeObject(ObjectOutputStream oos) throws IOException {
    oos.defaultWriteObject();
  }
  public String getAccessory_id() {
    return accessory_id;
  }
  public void setAccessory_id(String accessory_id) {
    this.accessory_id = accessory_id;
  }
  public String getAccessory_title() {
    return accessory_title;
  }
  public void setAccessory_title(String accessory_title) {
    this.accessory_title = accessory_title;
  }
  public String getAccessory_filename() {
    return accessory_filename;
  }
  public void setAccessory_filename(String accessory_filename) {
    this.accessory_filename = accessory_filename;
  }
  public String getRemark() {
    return remark;
  }
  public void setRemark(String remark) {
    this.remark = remark;
  }
  public String getInfo_id() {
    return info_id;
  }
  public void setInfo_id(String info_id) {
    this.info_id = info_id;
  }
}