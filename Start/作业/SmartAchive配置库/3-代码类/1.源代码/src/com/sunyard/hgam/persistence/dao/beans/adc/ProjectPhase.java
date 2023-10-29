package com.sunyard.hgam.persistence.dao.beans.adc;

import java.io.*;

public class ProjectPhase implements Serializable {
  private String phase_id;
  private String phase_name;
  private String remark;
  private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
    ois.defaultReadObject();
  }
  private void writeObject(ObjectOutputStream oos) throws IOException {
    oos.defaultWriteObject();
  }
  public String getPhase_id() {
    return phase_id;
  }
  public void setPhase_id(String phase_id) {
    this.phase_id = phase_id;
  }
  public String getPhase_name() {
    return phase_name;
  }
  public void setPhase_name(String phase_name) {
    this.phase_name = phase_name;
  }
  public String getRemark() {
    return remark;
  }
  public void setRemark(String remark) {
    this.remark = remark;
  }
}