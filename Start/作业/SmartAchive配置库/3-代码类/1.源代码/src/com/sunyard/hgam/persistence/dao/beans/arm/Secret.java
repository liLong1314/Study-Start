package com.sunyard.hgam.persistence.dao.beans.arm;

import java.io.*;
/**
 * <p>Title: �����ܼ�����</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author Ҷ�
 * @version 1.0
 */

public class Secret implements Serializable {
  private String secretId;
  private String secretCode;
  private String secretName;
  private String remark;
  private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
    ois.defaultReadObject();
  }
  private void writeObject(ObjectOutputStream oos) throws IOException {
    oos.defaultWriteObject();
  }
  public String getSecretId() {
    return secretId;
  }
  public void setSecretId(String secretId) {
    this.secretId = secretId;
  }
  public String getSecretCode() {
    return secretCode;
  }
  public void setSecretCode(String secretCode) {
    this.secretCode = secretCode;
  }
  public String getSecretName() {
    return secretName;
  }
  public void setSecretName(String secretName) {
    this.secretName = secretName;
  }
  public String getRemark() {
    return remark;
  }
  public void setRemark(String remark) {
    this.remark = remark;
  }
}