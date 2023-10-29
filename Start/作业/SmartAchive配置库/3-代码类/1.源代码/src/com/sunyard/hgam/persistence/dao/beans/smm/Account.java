package com.sunyard.hgam.persistence.dao.beans.smm;

import java.io.Serializable;

/**
 * <p>Title: Hang Zhou Net Archives</p>
 * <p>Description: 杭州市网上档案馆建设（一期）</p>
 * <p>Copyright: Hangzhou Sunyard System Engineering， Ltd. All rights reserved @2003</p>
 * <p>Company: </p>
 * @author xcf
 * @version 1.00
 */

public class Account implements Serializable {

  /* Private Fields */

  private String userID;
  private String userName;
  private String password;
  private String name;
  private String department;
  private String email;
  private String accessTimes;
  private String lastAccessDate;
  private String creationDate;
  private String lastModifiedDate;
  private String remark;
  private String roleID;
  private String orgID;
  private String orgName;

  /* JavaBeans Properties */

  public String getUserID() { return userID; }
  public void setUserID(String userID) { this.userID = userID; }

  public String getUserName() { return userName; }
  public void setUserName(String userName) { this.userName = userName; }

  public String getPassword() { return password; }
  public void setPassword(String password) { this.password = password; }

  public String getName() { return name; }
  public void setName(String name) { this.name = name; }

  public String getDepartment() { return department; }
  public void setDepartment(String department) { this.department = department; }

  public String getEmail() { return email; }
  public void setEmail(String email) { this.email = email; }

  public String getAccessTimes() { return accessTimes; }
  public void setAccessTimes(String accessTimes) { this.accessTimes = accessTimes; }

  public String getLastAccessDate() { return lastAccessDate; }
  public void setLastAccessDate(String lastAccessDate) { this.lastAccessDate = lastAccessDate; }

  public String getCreationDate() { return creationDate; }
  public String setCreationDate(String creationDate) { return this.creationDate = creationDate; }

  public String getLastModifiedDate() { return lastModifiedDate; }
  public void setLastModifiedDate(String lastModifiedDate) { this.lastModifiedDate = lastModifiedDate; }

  public String getRemark() { return remark; }
  public void setRemark(String remark) { this.remark = remark; }
  public String getRoleID() {
    return roleID;
  }
  public void setRoleID(String roleID) {
    this.roleID = roleID;
  }
  public String getOrgID() {
    return orgID;
  }
  public void setOrgID(String orgID) {
    this.orgID = orgID;
  }
  public String getOrgName() {
    return orgName;
  }
  public void setOrgName(String orgName) {
    this.orgName = orgName;
  }

}
