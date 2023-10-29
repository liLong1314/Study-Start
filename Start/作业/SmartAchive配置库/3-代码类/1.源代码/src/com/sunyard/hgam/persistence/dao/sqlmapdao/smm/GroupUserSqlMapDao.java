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
 * <p>Description: ���������ϵ����ݽ��裨һ�ڣ�</p>
 * <p>Copyright: Hangzhou Sunyard System Engineering�� Ltd. All rights reserved @2003</p>
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
   * ������ID��ȡ�����û�ID�б�
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
   * �����û�ID��ȡ�û�������ID�б�
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
   * �����û�ID��ȡ�û�������֯
   * @param userID �û�ID
   * @return ��֯ID
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