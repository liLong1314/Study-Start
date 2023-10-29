package com.sunyard.hgam.persistence.dao.beans.smm;

import java.io.*;

/**
 * <p>Title: HGAM</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author not attributable
 * @version 1.0
 */

public class Organization implements Serializable {
  private String id;
  private String name;
  private String type;
  private String sysPrivilege;
  private String isDelete;
  private String desc;
  private String superiorOrgId;
  private String superiorOrgName;
  private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
    ois.defaultReadObject();
  }
  private void writeObject(ObjectOutputStream oos) throws IOException {
    oos.defaultWriteObject();
  }
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }
  public String getSysPrivilege() {
    return sysPrivilege;
  }
  public void setSysPrivilege(String sysPrivilege) {
    this.sysPrivilege = sysPrivilege;
  }
  public String getIsDelete() {
    return isDelete;
  }
  public void setIsDelete(String isDelete) {
    this.isDelete = isDelete;
  }
  public String getDesc() {
    return desc;
  }
  public void setDesc(String desc) {
    this.desc = desc;
  }
  public String getSuperiorOrgId() {
    return superiorOrgId;
  }
  public void setSuperiorOrgId(String superiorOrgId) {
    this.superiorOrgId = superiorOrgId;
  }
  public String getSuperiorOrgName() {
    return superiorOrgName;
  }
  public void setSuperiorOrgName(String superiorOrgName) {
    this.superiorOrgName = superiorOrgName;
  }
}