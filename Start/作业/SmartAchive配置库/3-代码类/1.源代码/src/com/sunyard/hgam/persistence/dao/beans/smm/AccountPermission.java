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

public class AccountPermission implements Serializable
{
  private String userID;
  private String permID;
    private String permType;
  public AccountPermission()
  {
  }
  private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException
  {
    ois.defaultReadObject();
  }
  private void writeObject(ObjectOutputStream oos) throws IOException
  {
    oos.defaultWriteObject();
  }
  public String getUserID()
  {
    return userID;
  }
  public void setUserID(String userID)
  {
    this.userID = userID;
  }
  public String getPermID()
  {
    return permID;
  }
  public void setPermID(String permID)
  {
    this.permID = permID;
  }
    public String getPermType() {
        return permType;
    }
    public void setPermType(String permType) {
        this.permType = permType;
    }

}