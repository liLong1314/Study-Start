package com.sunyard.hgam.persistence.dao.sqlmapdao.smm;

import com.sunyard.hgam.persistence.dao.base.BaseSqlMapDao;
import com.sunyard.hgam.persistence.dao.iface.smm.*;
import java.util.*;
import com.ibatis.db.dao.*;
import java.sql.*;
import com.sunyard.hgam.persistence.dao.beans.smm.*;
import com.ibatis.common.util.*;

/**
 * <p>Title: Hang Zhou Net Archives</p>
 * <p>Description: 杭州市网上档案馆建设（一期）</p>
 * <p>Copyright: Hangzhou Sunyard System Engineering， Ltd. All rights reserved @2003</p>
 * <p>Company: </p>
 * @author xcf
 * @version 1.00
 */

public class GroupSqlMapDao
    extends BaseSqlMapDao
    implements GroupDao
{
  public GroupSqlMapDao()
  {
  }

  public String getGroupByGroupName(String groupName)
  {
    String ret = null;
    try
    {
      this.startTransation();
      ret = (java.lang.String)this.executeQueryForObject(
          "getGroupByGroupName", groupName);
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
    return ret;

  }

  public Group getGroupByGroupID(String groupID)
  {
    Group group = null;
    try
    {
      this.startTransation();
      group = (Group)this.executeQueryForObject(
          "getGroupByGroupID", groupID);

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
    return group;
  }

  /**
   * 获取所有用户组，分页大小为默认分页大小
   * @return
   */
  public PaginatedList getGroups()
  {
    PaginatedList list = null;
    try
    {
      this.startTransation();

      list = this.executeQueryForPaginatedList("getGroups", null,
                                               this.PAGE_SIZE);

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

  /**
   * 获取所有用户组，按pageSize分页显示
   * @param pageSize
   * @return
   */
  public PaginatedList getGroups(int pageSize)
  {
    PaginatedList list = null;
    try
    {
      this.startTransation();

      list = this.executeQueryForPaginatedList("getGroups", null, pageSize);

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

  /**
   * 按查询条件获取用户组，返回分页显示，分页大小为默认分页大小
   * @param group
   * @return
   */
  public PaginatedList getGroups(Group group)
  {
    PaginatedList list = null;
    try
    {
      this.startTransation();

      list = this.executeQueryForPaginatedList("getGroups", group,
                                               this.PAGE_SIZE);

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

  /**
   * 按查询条件获取用户组，分页大小为pageSize
   * @param group
   * @param pageSize
   * @return
   */
  public PaginatedList getGroups(Group group, int pageSize)
  {
    PaginatedList list = null;
    try
    {
      this.startTransation();

      list = this.executeQueryForPaginatedList("getGroups", group, pageSize);

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

  /**
   * 在用户组表中插入一条新记录
   * @param account
   * @return
   */
  public int insertGroup(Group group)
  {
    int result = 0;
    try
    {
      this.startTransation();

      result = this.executeUpdate("insertGroup", group);

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

  /**
   * 修改一条用户组记录
   * @param group
   * @return
   */
  public int updateGroup(Group group)
  {
    int result = 0;
    try
    {
      this.startTransation();

      result = this.executeUpdate("updateGroup", group);

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

  public int updateGroupMD(Group group)
  {
    int result = 0;
    try
    {
      this.startTransation();

      result = this.executeUpdate("updateGroupMD", group);

      this.commitTransation();
    }
    catch (DaoException ex)
    {
      try
      {
        this.rollbackTransation();
      }
      catch (Exception ex2)
      {}
      ex.printStackTrace();
    }
    return result;
  }

  /**
   * 删除一条用户组记录
   * @param group
   * @return
   */
  public int deleteGroup(String groupID)
  {
    int result = 0;
    try
    {
      this.startTransation();

      result = this.executeUpdate("deleteGroup", groupID);

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