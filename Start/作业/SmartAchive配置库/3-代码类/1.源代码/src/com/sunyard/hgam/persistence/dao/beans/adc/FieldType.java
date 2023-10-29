package com.sunyard.hgam.persistence.dao.beans.adc;

import java.io.*;

public class FieldType implements Serializable {
  private String field_type_id;
  private String field_type_cname;
  private String field_type_ename;
  private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
    ois.defaultReadObject();
  }
  private void writeObject(ObjectOutputStream oos) throws IOException {
    oos.defaultWriteObject();
  }
  public String getField_type_id() {
    return field_type_id;
  }
  public void setField_type_id(String field_type_id) {
    this.field_type_id = field_type_id;
  }
  public String getField_type_cname() {
    return field_type_cname;
  }
  public void setField_type_cname(String field_type_cname) {
    this.field_type_cname = field_type_cname;
  }
  public String getField_type_ename() {
    return field_type_ename;
  }
  public void setField_type_ename(String field_type_ename) {
    this.field_type_ename = field_type_ename;
  }
}