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

public class AccountSqlMapDao
    extends BaseSqlMapDao
    implements AccountDAO {

  public PaginatedList getAllAccount(Account account) {
    return this.getAllAccount(this.PAGE_SIZE, account);
  }

  public Account getAccountByUserID(String userID) {
    Account account = null;
    try {
      this.startTransation();
      account = (Account)this.executeQueryForObject(
          "getAccountByUserID", userID);

      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) {
      }
      ex.printStackTrace();
    }
    return account;
  }

  public PaginatedList getAllAccount(int pageSize, Account account) {
    PaginatedList accountList = null;
    try {
      this.startTransation();

      accountList = this.executeQueryForPaginatedList("getAllAccount", account,
          pageSize);

      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return accountList;
  }

  public List getAccounts() {
    List list = null;
    try {
      this.startTransation();

      list = this.executeQueryForList("getAccounts", new Account());

      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return list;
  }

  public Account getAccountByUsernameAndPassword(String userName,
                                                 String password) {
    Account account = null;
    try {
      this.startTransation();
      Account act = new Account();
      act.setUserName(userName);
      act.setPassword(password);
      account = (Account)this.executeQueryForObject(
          "getAccountByUsernameAndPassword", act);

      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return account;
  }

  public String getAccountByUsername(String userName) {
    String account = null;
    try {
      this.startTransation();
      account = (java.lang.String)this.executeQueryForObject(
          "getAccountByUsername", userName);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return account;
  }

  public int insertAccount(Account account) {
    int result = 0;
    try {
      this.startTransation();

      result = this.executeUpdate("insertAccount", account);

      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return result;
  }

  public int updateAccountLMD(Account account) {
    int result = 0;
    try {
      this.startTransation();

      result = this.executeUpdate("updateAccountLMD", account);

      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return result;
  }

  public int updateAccountPassword(Account account) {
    int result = 0;
    try {
      this.startTransation();

      result = this.executeUpdate("updateAccountPassword", account);

      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return result;
  }

  public int updateLoginInfo(Account account) {
    int result = 0;
    try {
      this.startTransation();

      result = this.executeUpdate("updateLoginInfo", account);

      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return result;
  }

  public int deleteAccount(String userID) {
    int result = 0;
    try {
      this.startTransation();

      result = this.executeUpdate("deleteAccount", userID);

      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return result;
  }

  public List getUserFuncPerm(String userID, String groupID) {
    List list = null;
    try {
      this.startTransation();

      HashMap params = new HashMap();
      params.put("userID", userID);
      params.put("groupID", groupID);
      list = this.executeQueryForList("getUserFuncPerm", params);

      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return list;
  }

  public List getUserDataPerm(String userID, String groupID) {
    List list = null;
    try {
      this.startTransation();

      HashMap params = new HashMap();
      params.put("userID", userID);
      params.put("groupID", groupID);
      list = this.executeQueryForList("getUserDataPerm", params);

      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return list;
  }

  public List getUserGroups(String userID) {
    List list = null;
    try {
      this.startTransation();

      HashMap user = new HashMap();
      user.put("userID",userID);
      list = this.executeQueryForList("getUserGroups", user);

      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return list;
  }


  public String getPasswordByUsername(String userName) {
    String pwd = null;
    try {
      this.startTransation();
      pwd = (java.lang.String)this.executeQueryForObject(
          "getPasswordByUsername", userName);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return pwd;
  }

}