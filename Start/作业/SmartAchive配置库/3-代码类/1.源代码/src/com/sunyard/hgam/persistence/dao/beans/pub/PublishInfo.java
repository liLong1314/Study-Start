package com.sunyard.hgam.persistence.dao.beans.pub;

import java.io.*;

public class PublishInfo implements Serializable {
  private String info_id = "";
  private String info_type = "";
  private String info_title = "";
  private String info_content = "";
  private String info_is_out = "";
  private String info_publish_person = "";
  private String info_publish_datetime = "";
  private String info_feedback_content = "";
  private String info_feedback_person = "";
  private String info_feedback_datetime = "";
  private String info_is_confirm = "";
  private String info_confirm_person = "";
  private String info_confirm_datetime = "";
  private String remark = "";
  private String info_status = "";
  private String info_confirm_idea = "";
  private String accessory_title = "";
  private String accessory_filename = "";
  private org.apache.struts.upload.FormFile accessory_file;

  private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
    ois.defaultReadObject();
  }
  private void writeObject(ObjectOutputStream oos) throws IOException {
    oos.defaultWriteObject();
  }
  public String getInfo_id() {
    return info_id;
  }
  public void setInfo_id(String info_id) {
    this.info_id = info_id;
  }
  public String getInfo_type() {
    return info_type;
  }
  public void setInfo_type(String info_type) {
    this.info_type = info_type;
  }
  public String getInfo_title() {
    return info_title;
  }
  public void setInfo_title(String info_title) {
    this.info_title = info_title;
  }
  public String getInfo_content() {
    return info_content;
  }
  public void setInfo_content(String info_content) {
    this.info_content = info_content;
  }
  public String getInfo_is_out() {
    return info_is_out;
  }
  public void setInfo_is_out(String info_is_out) {
    this.info_is_out = info_is_out;
  }
  public String getInfo_publish_person() {
    return info_publish_person;
  }
  public void setInfo_publish_person(String info_publish_person) {
    this.info_publish_person = info_publish_person;
  }
  public String getInfo_publish_datetime() {
    return info_publish_datetime;
  }
  public void setInfo_publish_datetime(String info_publish_datetime) {
    this.info_publish_datetime = info_publish_datetime;
  }
  public String getInfo_feedback_content() {
    return info_feedback_content;
  }
  public void setInfo_feedback_content(String info_feedback_content) {
    this.info_feedback_content = info_feedback_content;
  }
  public String getInfo_feedback_person() {
    return info_feedback_person;
  }
  public void setInfo_feedback_person(String info_feedback_person) {
    this.info_feedback_person = info_feedback_person;
  }
  public String getInfo_feedback_datetime() {
    return info_feedback_datetime;
  }
  public void setInfo_feedback_datetime(String info_feedback_datetime) {
    this.info_feedback_datetime = info_feedback_datetime;
  }
  public String getInfo_is_confirm() {
    return info_is_confirm;
  }
  public void setInfo_is_confirm(String info_is_confirm) {
    this.info_is_confirm = info_is_confirm;
  }
  public String getInfo_confirm_person() {
    return info_confirm_person;
  }
  public void setInfo_confirm_person(String info_confirm_person) {
    this.info_confirm_person = info_confirm_person;
  }
  public String getInfo_confirm_datetime() {
    return info_confirm_datetime;
  }
  public void setInfo_confirm_datetime(String info_confirm_datetime) {
    this.info_confirm_datetime = info_confirm_datetime;
  }
  public String getRemark() {
    return remark;
  }
  public void setRemark(String remark) {
    this.remark = remark;
  }
  public String getInfo_status() {
    return info_status;
  }
  public void setInfo_status(String info_status) {
    this.info_status = info_status;
  }
  public String getInfo_confirm_idea() {
    return info_confirm_idea;
  }
  public void setInfo_confirm_idea(String info_confirm_idea) {
    this.info_confirm_idea = info_confirm_idea;
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
  public org.apache.struts.upload.FormFile getAccessory_file() {
    return accessory_file;
  }
  public void setAccessory_file(org.apache.struts.upload.FormFile accessory_file) {
    this.accessory_file = accessory_file;
  }
}