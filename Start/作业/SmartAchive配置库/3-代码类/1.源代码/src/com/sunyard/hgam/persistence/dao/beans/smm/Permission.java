package com.sunyard.hgam.persistence.dao.beans.smm;

import java.io.*;

/**
 * <p>Title: Hang Zhou Net Archives</p>
 * <p>Description: 杭州市网上档案馆建设（一期）</p>
 * <p>Copyright: Hangzhou Sunyard System Engineering， Ltd. All rights reserved @2003</p>
 * <p>Company: </p>
 * @author xcf
 * @version 1.00
 */

public class Permission implements Serializable {
  private String permID;//权限ID
  private String permCode;//权限代码
  private String permContent;//权限说明
  private String permType;//权限类型：1、功能（菜单）权限；2、数据（操作）权限

  private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
    ois.defaultReadObject();
  }
  private void writeObject(ObjectOutputStream oos) throws IOException {
    oos.defaultWriteObject();
  }
  public String getPermID() {
    return permID;
  }
  public void setPermID(String permID) {
    this.permID = permID;
  }
  public String getPermCode() {
    return permCode;
  }
  public void setPermCode(String permCode) {
    this.permCode = permCode;
  }
  public String getPermContent() {
    return permContent;
  }
  public void setPermContent(String permContent) {
    this.permContent = permContent;
  }
  public String getPermType() {
    return permType;
  }
  public void setPermType(String permType) {
    this.permType = permType;
  }

}