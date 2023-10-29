package com.sunyard.hgam.presentation.form.smm;

import com.sunyard.hgam.presentation.base.*;
import com.sunyard.hgam.persistence.dao.beans.smm.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

/**
 * <p>Title: Hang Zhou Net Archives</p>
 * <p>Description: 杭州市网上档案馆建设（一期）</p>
 * <p>Copyright: Hangzhou Sunyard System Engineering， Ltd. All rights reserved @2003</p>
 * <p>Company: </p>
 * @author xcf
 * @version 1.00
 */

public class PermissionForm extends BaseForm implements Serializable
{
  private com.sunyard.hgam.persistence.dao.beans.smm.Permission permission;
  private String operResults;
  public PermissionForm()
  {
  }
  public com.sunyard.hgam.persistence.dao.beans.smm.Permission getPermission()
  {
    return permission;
  }
  public void setPermission(com.sunyard.hgam.persistence.dao.beans.smm.Permission permission)
  {
    this.permission = permission;
  }
  private void writeObject(ObjectOutputStream oos) throws IOException
  {
    oos.defaultWriteObject();
  }
  private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException
  {
    ois.defaultReadObject();
  }
  public String getOperResults()
  {
    return operResults;
  }
  public void setOperResults(String operResults)
  {
    this.operResults = operResults;
  }

}