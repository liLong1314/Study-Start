package com.sunyard.hgam.presentation.form.smm;

import com.sunyard.hgam.presentation.base.BaseForm;
import java.io.*;

/**
 * <p>Title: Hang Zhou Net Archives</p>
 * <p>Description: 杭州市网上档案馆建设（一期）</p>
 * <p>Copyright: Hangzhou Sunyard System Engineering， Ltd. All rights reserved @2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 0.01
 */

public class GroupForm extends BaseForm implements Serializable
{
  private String operResults;
  private com.sunyard.hgam.persistence.dao.beans.smm.Group group;
  public GroupForm()
  {
    group = new com.sunyard.hgam.persistence.dao.beans.smm.Group();
  }
  private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException
  {
    ois.defaultReadObject();
  }
  private void writeObject(ObjectOutputStream oos) throws IOException
  {
    oos.defaultWriteObject();
  }
  public String getOperResults()
  {
    return operResults;
  }
  public void setOperResults(String operResults)
  {
    this.operResults = operResults;
  }
  public com.sunyard.hgam.persistence.dao.beans.smm.Group getGroup()
  {
    return group;
  }
  public void setGroup(com.sunyard.hgam.persistence.dao.beans.smm.Group group)
  {
    this.group = group;
  }

}