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

public class Group implements Serializable
{
  private String groupID;
  private String groupName;
  private String description;
  private String creationDate;
  private String modifiedDate;
  public Group()
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
  public String getGroupID()
  {
    return groupID;
  }
  public void setGroupID(String groupID)
  {
    this.groupID = groupID;
  }
  public String getGroupName()
  {
    return groupName;
  }
  public void setGroupName(String groupName)
  {
    this.groupName = groupName;
  }
  public String getDescription()
  {
    return description;
  }
  public void setDescription(String description)
  {
    this.description = description;
  }
  public String getCreationDate()
  {
    return creationDate;
  }
  public void setCreationDate(String creationDate)
  {
    this.creationDate = creationDate;
  }
  public String getModifiedDate()
  {
    return modifiedDate;
  }
  public void setModifiedDate(String modifiedDate)
  {
    this.modifiedDate = modifiedDate;
  }

}