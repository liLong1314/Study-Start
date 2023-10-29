package com.sunyard.hgam.persistence.dao.sqlmapdao.smm;

import com.sunyard.hgam.persistence.dao.base.BaseSqlMapDao;
import com.sunyard.hgam.persistence.dao.iface.smm.*;
import java.util.*;
import com.ibatis.db.dao.*;
import java.sql.*;
import com.sunyard.hgam.persistence.dao.beans.smm.*;

/**
 * <p>Title: Hang Zhou Net Archives</p>
 * <p>Description: 杭州市网上档案馆建设（一期）</p>
 * <p>Copyright: Hangzhou Sunyard System Engineering， Ltd. All rights reserved @2003</p>
 * <p>Company: </p>
 * @author xcf
 * @version 1.00
 */

public class PermissionSqlMapDao
    extends BaseSqlMapDao
    implements PermissionDao
{
  public PermissionSqlMapDao()
  {
  }

  public List getAllPermission()
  {
    List list = null;
    try
    {
      this.startTransation();

      list = this.executeQueryForList("getAllPermission", null);

      this.commitTransation();
    }
    catch (DaoException ex)
    {
      try
      {
        this.rollbackTransation();
      }
      catch (Exception ex2)
      {
      /* ignore */}
      ex.printStackTrace();
    }
    return list;
  }
  public List getAllPermissionByType(Permission p)
  {
    List list = null;
    try
    {
      this.startTransation();

      list = this.executeQueryForList("getAllPermissionByType", p);

      this.commitTransation();
    }
    catch (DaoException ex)
    {
      try
      {
        this.rollbackTransation();
      }
      catch (Exception ex2)
      {
      /* ignore */}
      ex.printStackTrace();
    }
    return list;
  }


  public List getPermissionByCode(String permissionCode)
  {
    List list = null;
    try
    {
      this.startTransation();

      list = this.executeQueryForList("getPermissionByCode", permissionCode);

      this.commitTransation();
    }
    catch (DaoException ex)
    {
      try
      {
        this.rollbackTransation();
      }
      catch (Exception ex2)
      {/* ignore */}
      ex.printStackTrace();
    }
    return list;
  }

  public int insertPermission(Permission permission)
  {
    int result = 0;
    try
    {
      this.startTransation();

      result = this.executeUpdate("insertPermission", permission);

      this.commitTransation();
    }
    catch (DaoException ex) {
      try
      {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    return result;
  }

  public int updatePermission(Permission permission)
  {
    int result = 0;
    try
    {
      this.startTransation();

      result = this.executeUpdate("updatePermission", permission);

      this.commitTransation();
    }
    catch (DaoException ex) {
      try
      {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    return result;
  }

  public int deletePermission(Permission permission)
  {
    int result = 0;
    try
    {
      this.startTransation();

      result = this.executeUpdate("deletePermission", permission);

      this.commitTransation();
    }
    catch (DaoException ex) {
      try
      {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    return result;
  }

}