package com.sunyard.hgam.persistence.dao.beans.smm;

import java.io.*;

/**
 * <p>Title: Hang Zhou Net Archives</p>
 * <p>Description: ���������ϵ����ݽ��裨һ�ڣ�</p>
 * <p>Copyright: Hangzhou Sunyard System Engineering�� Ltd. All rights reserved @2003</p>
 * <p>Company: </p>
 * @author xcf
 * @version 1.00
 */

public class Permission implements Serializable {
  private String permID;//Ȩ��ID
  private String permCode;//Ȩ�޴���
  private String permContent;//Ȩ��˵��
  private String permType;//Ȩ�����ͣ�1�����ܣ��˵���Ȩ�ޣ�2�����ݣ�������Ȩ��

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