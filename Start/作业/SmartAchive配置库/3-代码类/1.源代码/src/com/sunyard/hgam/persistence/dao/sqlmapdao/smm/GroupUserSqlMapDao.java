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
 * @author not attributable
 * @version 0.01
 */

public class GroupUserSqlMapDao
    extends BaseSqlMapDao
    implements GroupUserDao
{
  public GroupUserSqlMapDao()
  {
  }

  /**
   * 根据组ID获取组内用户ID列表
   * @param gu
   * @return
   */
  public List getUserIDBygroupID(GroupUser gu)
  {
    List list = null;
    try
    {
      this.startTransation();
      list = this.executeQueryForList("getUserIDBygroupID", gu);
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

  /**
   * 根据用户ID获取用户所在组ID列表
   * @param gu
   * @return
   */
  public List getGroupIDByUserID(GroupUser gu)
  {
    List list = null;
    try
    {
      this.startTransation();
      list = this.executeQueryForList("getGroupIDByUserID", gu);
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

  /**
   * 根据用户ID获取用户所在组织
   * @param userID 用户ID
   * @return 组织ID
   */
  public String getOrgIDByUserID(String userID)
  {
    String orgId = null;
    try
    {
      this.startTransation();
      orgId = (String) this.executeQueryForObject("getOrgIDByUserID", userID);
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
    return orgId;
  }

  public int insertGU(GroupUser gu)
  {
    int result = 0;
    try
    {
      this.startTransation();

      if (gu.getOrgID() == null) {
        gu.setOrgID("");
      }

      result = this.executeUpdate("insertGU", gu);

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
    return result;
  }

  public int updateUserOrgID(GroupUser gu)
  {
    int result = 0;
    try
    {
      this.startTransation();

      result = this.executeUpdate("updateUserOrgID", gu);

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
    return result;
  }

  public int deleteOneGU(GroupUser gu)
  {
    int result = 0;
    try
    {
      this.startTransation();

      result = this.executeUpdate("deleteOneGU", gu);

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
    return result;
  }

  public int deleteAllGU(GroupUser gu)
  {
    int result = 0;
    try
    {
      this.startTransation();

      result = this.executeUpdate("deleteAllGU", gu);

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
    return result;
  }

  public int deleteAllUG(GroupUser gu)
  {
    int result = 0;
    try
    {
      this.startTransation();

      result = this.executeUpdate("deleteAllUG", gu);

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
    return result;
  }

}