package com.sunyard.hgam.presentation.base;

import java.io.*;

/**
 * <p>Title: Hang Zhou Net Archives</p>
 * <p>Description: 杭州市网上档案馆建设（一期）</p>
 * <p>Copyright: Hangzhou Sunyard System Engineering， Ltd. All rights reserved @2003</p>
 * <p>Company: </p>
 * @Date        Author      Changes
 * Nov 19,2003   yujx        created
 * @version 0.01
 */

public class OptionBean implements Serializable {
  private String label;
  private String value;
  public OptionBean() {
  }
  public OptionBean(String label, String value) {
    this.label = label;
    this.value = value;
  }
  public String getLabel() {
    return label;
  }
  public void setLabel(String label) {
    this.label = label;
  }
  public String getValue() {
    return value;
  }
  public void setValue(String value) {
    this.value = value;
  }
  private void writeObject(ObjectOutputStream oos) throws IOException {
    oos.defaultWriteObject();
  }
  private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
    ois.defaultReadObject();
  }

}