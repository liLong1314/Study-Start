package com.sunyard.hgam.persistence.dao.beans.smm;


import java.io.*;
/**
 * <p>Title: ����ʹ���</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author ������
 * @version 1.0
 */

public class Theme implements Serializable {
  private String themeId;
  private String themeName;
  private String themeCode;
  private String themeMessage;
  private String remark;
  private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
    ois.defaultReadObject();
  }
  private void writeObject(ObjectOutputStream oos) throws IOException {
    oos.defaultWriteObject();
  }

  public String getThemeId() {
    return themeId;
  }
  public void setThemeId(String themeId) {
    this.themeId = themeId;
  }
  public String getThemeName() {
    return themeName;
  }
  public void setThemeName(String themeName) {
    this.themeName = themeName;
  }
  public String getThemeCode() {
    return themeCode;
  }
  public void setThemeCode(String themeCode) {
    this.themeCode = themeCode;
  }
  public String getThemeMessage() {
    return themeMessage;
  }
  public void setThemeMessage(String themeMessage) {
    this.themeMessage = themeMessage;
  }
  public String getremark() {
     return remark;
   }
   public void setremark(String remark) {
     this.remark = remark;
   }

}
