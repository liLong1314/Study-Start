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
public class EformFieldValue implements Serializable {
  private String value_id;
  private String file_id;
  private String field_id;
  private String field_value;
  private String field_type_id;
  private String field_cname;
  private String field_ename;
  private String field_len;
  private String field_isNull;
  private String field_isBrief;
  private String field_seq;
  private String field_isEdit;
  private String eform_id;

  private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
    ois.defaultReadObject();
  }
  private void writeObject(ObjectOutputStream oos) throws IOException {
    oos.defaultWriteObject();
  }
  public String getValue_id() {
    return value_id;
  }
  public void setValue_id(String value_id) {
    this.value_id = value_id;
  }
  public String getFile_id() {
    return file_id;
  }
  public void setFile_id(String file_id) {
    this.file_id = file_id;
  }
  public String getField_id() {
    return field_id;
  }
  public void setField_id(String field_id) {
    this.field_id = field_id;
  }
  public String getField_value() {
    return field_value;
  }
  public void setField_value(String field_value) {
    this.field_value = field_value;
  }
  public String getField_type_id() {
    return field_type_id;
  }
  public void setField_type_id(String field_type_id) {
    this.field_type_id = field_type_id;
  }
  public String getField_cname() {
    return field_cname;
  }
  public void setField_cname(String field_cname) {
    this.field_cname = field_cname;
  }
  public String getField_ename() {
    return field_ename;
  }
  public void setField_ename(String field_ename) {
    this.field_ename = field_ename;
  }
  public String getField_len() {
    return field_len;
  }
  public void setField_len(String field_len) {
    this.field_len = field_len;
  }
  public String getField_isNull() {
    return field_isNull;
  }
  public void setField_isNull(String field_isNull) {
    this.field_isNull = field_isNull;
  }
  public String getField_isBrief() {
    return field_isBrief;
  }
  public void setField_isBrief(String field_isBrief) {
    this.field_isBrief = field_isBrief;
  }
  public String getField_seq() {
    return field_seq;
  }
  public void setField_seq(String field_seq) {
    this.field_seq = field_seq;
  }
  public String getField_isEdit() {
    return field_isEdit;
  }
  public void setField_isEdit(String field_isEdit) {
    this.field_isEdit = field_isEdit;
  }
  public String getEform_id() {
    return eform_id;
  }
  public void setEform_id(String eform_id) {
    this.eform_id = eform_id;
  }
}