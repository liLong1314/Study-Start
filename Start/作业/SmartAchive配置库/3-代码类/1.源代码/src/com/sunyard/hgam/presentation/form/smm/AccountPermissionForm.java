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

public class AccountPermissionForm extends BaseForm implements Serializable
{
  private com.sunyard.hgam.persistence.dao.beans.smm.Account account;
  private com.sunyard.hgam.persistence.dao.beans.smm.Permission permission;
  private String operResults;
  public AccountPermissionForm()
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
  public com.sunyard.hgam.persistence.dao.beans.smm.Account getAccount()
  {
    return account;
  }
  public void setAccount(com.sunyard.hgam.persistence.dao.beans.smm.Account account)
  {
    this.account = account;
  }
  public com.sunyard.hgam.persistence.dao.beans.smm.Permission getPermission()
  {
    return permission;
  }
  public void setPermission(com.sunyard.hgam.persistence.dao.beans.smm.Permission permission)
  {
    this.permission = permission;
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