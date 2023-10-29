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

public class GroupUser implements Serializable
{
  private String userID;
  private String groupID;
  private String creationDate;
  private String orgID;
  public GroupUser()
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
  public String getGroupID()
  {
    return groupID;
  }
  public void setGroupID(String groupID)
  {
    this.groupID = groupID;
  }
  public String getCreationDate()
  {
    return creationDate;
  }
  public void setCreationDate(String creationDate)
  {
    this.creationDate = creationDate;
  }
  public String getOrgID() {
    return orgID;
  }
  public void setOrgID(String orgID) {
    this.orgID = orgID;
  }

}