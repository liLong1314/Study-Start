package com.sunyard.hgam.persistence.dao.sqlmapdao.smm;

import com.sunyard.hgam.persistence.dao.base.BaseSqlMapDao;
import com.sunyard.hgam.persistence.dao.iface.smm.*;
import java.util.*;
import com.ibatis.db.dao.*;
import java.sql.*;
import com.sunyard.hgam.persistence.dao.beans.smm.*;

/**
 * <p>Title: Hang Zhou Net Archives</p>
 * <p>Description: 对“用户权限表”的操作，包括增加，修改，删除</p>
 * <p>Copyright: Hangzhou Sunyard System Engineering， Ltd. All rights reserved @2003</p>
 * <p>Company: </p>
 * @author xcf
 * @version 1.00
 */

public class AccountPermissionSqlMapDao extends BaseSqlMapDao implements AccountPermissionDao
{
  public List getPermissionByUserID(String userID)
  {
    List list = null;
    try
    {
      this.startTransation();
      list = this.executeQueryForList("getPermissionByUserID", userID);
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

  public int insertAP(AccountPermission ap)
  {
    int result = 0;
    try
    {
      this.startTransation();

      result = this.executeUpdate("insertAP", ap);

      this.commitTransation();
    }
    catch (DaoException ex)
    {
      try
      {
        this.rollbackTransation();
      }
      catch (Exception ex2)
      { /* ignore */}
      ex.printStackTrace();
    }
    return result;
  }

  public int deleteOneAP(AccountPermission ap)
  {
    int result = 0;
    try
    {
      this.startTransation();

      result = this.executeUpdate("deleteOneAP", ap);

      this.commitTransation();
    }
    catch (DaoException ex)
    {
      try
      {
        this.rollbackTransation();
      }
      catch (Exception ex2)
      { /* ignore */}
      ex.printStackTrace();
    }
    return result;
  }

  public int deleteAllAP(AccountPermission ap)
  {
    int result = 0;
    try
    {
      this.startTransation();

      result = this.executeUpdate("deleteAllAP", ap);

      this.commitTransation();
    }
    catch (DaoException ex)
    {
      try
      {
        this.rollbackTransation();
      }
      catch (Exception ex2)
      { /* ignore */}
      ex.printStackTrace();
    }
    return result;
  }

}