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
 * @author not attributable
 * @version 0.01
 */

public class GroupPermissionSqlMapDao extends BaseSqlMapDao implements GroupPermissionDao
{
  public GroupPermissionSqlMapDao()
  {
  }
  public List getPermissionBygroupID(String groupID)
  {
    List list = null;
    try
    {
      this.startTransation();
      list = this.executeQueryForList("getPermissionBygroupID", groupID);
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
      }
      ex.printStackTrace();
    }
    return list;
  }

  public int insertGP(GroupPermission gp)
  {
    int result = 0;
    try
    {
      this.startTransation();

      result = this.executeUpdate("insertGP", gp);

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
      }
      ex.printStackTrace();
    }
    return result;
  }

  public int deleteOneGP(GroupPermission gp)
  {
    int result = 0;
    try
    {
      this.startTransation();

      result = this.executeUpdate("deleteOneGP", gp);

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
      }
      ex.printStackTrace();
    }
    return result;
  }

  public int deleteAllGP(GroupPermission gp)
  {
    int result = 0;
    try
    {
      this.startTransation();

      result = this.executeUpdate("deleteAllGP", gp);

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
      }
      ex.printStackTrace();
    }
    return result;
  }

}