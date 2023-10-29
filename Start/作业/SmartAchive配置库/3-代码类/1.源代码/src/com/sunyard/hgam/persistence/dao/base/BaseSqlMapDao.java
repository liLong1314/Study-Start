package com.sunyard.hgam.persistence.dao.base;

import com.ibatis.db.dao.*;
import com.ibatis.db.dao.jdbc.*;
import com.ibatis.db.sqlmap.*;
import com.ibatis.common.util.*;

import java.util.*;
import java.sql.*;
import java.sql.SQLException;

/**
 * <p>Title: Hang Zhou Net Archives</p>
 * <p>Description: 杭州市网上档案馆建设（一期）</p>
 * <p>Copyright: Hangzhou Sunyard System Engineering， Ltd. All rights reserved @2003</p>
 * <p>Company: </p>
 * @Date        Author      Changes
 * Nov 3,2003   yujx        created
 * @version 0.01
 */

public class BaseSqlMapDao
    implements Dao {

  protected static final int PAGE_SIZE = 10;

  /**
   * Looks up the parent DaoManager, gets the local transaction
   * (which should be a SqlMapDaoTransaction) and returns the
   * SqlMap associated with this DAO.
   * @return The SqlMap instance for this DAO.
   * @throws DaoException If a DAO exception is thrown
   */
  protected SqlMap getLocalSqlMap() throws DaoException {
    DaoManager daoManager = DaoManager.getInstance(this);
    SqlMapDaoTransaction trans = (SqlMapDaoTransaction) daoManager.
        getLocalTransaction();
    return trans.getSqlMap();
  }

  /**
   * Starts a new transaction.
   *
   * @throws SQLException If a transaction has already been started, or if a database exception is thrown.
   * @throws DaoException If a DAO exception is thrown If a DAO exception is thrown
   */
  protected void startTransation() throws DaoException {
    DaoManager daoManager = DaoManager.getInstance(this);
    daoManager.startTransaction();
  }

  /**
   * Commits the current transaction
   * @throws SQLException If a database exception is thrown, or no transaction is in progress
       * @throws DaoException If a DAO exception is thrown If a DAO exception is thrown
   */
  protected void commitTransation() throws DaoException {
    DaoManager daoManager = DaoManager.getInstance(this);
    daoManager.commitTransaction();
  }

  /**
   * Rolls back the current transaction
   * @throws SQLException If a database exception is thrown
       * @throws DaoException If a DAO exception is thrown If a DAO exception is thrown
   */
  protected void rollbackTransation() throws DaoException {
    DaoManager daoManager = DaoManager.getInstance(this);
    daoManager.rollbackTransaction();
  }

  /**
   * Simple convenience method to wrap the SqlMap method of the same name.
   * Wraps the exception with a DaoException to isolate the SqlMap framework.
   * @param statementName The mapped statement name The mapped statement name
   * @param parameterObject The parameter object The parameter object
   * @return List The object list returned
   * @throws DaoException If a DAO exception is thrown
   */
  protected List executeQueryForList(String statementName,
                                     Object parameterObject) throws
      DaoException {
    SqlMap sqlMap = getLocalSqlMap();
    try {
      return sqlMap.executeQueryForList(statementName, parameterObject);
    }
    catch (SQLException e) {
      throw new DaoException("Error executing query for list.  Cause: " + e, e);
    }
  }

  /**
   * Simple convenience method to wrap the SqlMap method of the same name.
   * Wraps the exception with a DaoException to isolate the SqlMap framework.
   * @param statementName The mapped statement name
   * @param parameterObject The parameter object
   * @param skipResults the result to skip
   * @param maxResults the max results to query
   * @return The object list returned
   * @throws DaoException If a DAO exception is thrown
   */
  protected List executeQueryForList(String statementName,
                                     Object parameterObject, int skipResults,
                                     int maxResults) throws DaoException {
    SqlMap sqlMap = getLocalSqlMap();
    try {
      return sqlMap.executeQueryForList(statementName, parameterObject,
                                        skipResults, maxResults);
    }
    catch (SQLException e) {
      throw new DaoException("Error executing query for list.  Cause: " + e, e);
    }
  }

  /**
   * Simple convenience method to wrap the SqlMap method of the same name.
   * Wraps the exception with a DaoException to isolate the SqlMap framework.
   * @param statementName The mapped statement name
   * @param parameterObject The parameter object
   * @param pageSize page size
   * @return Paginated List
   * @throws DaoException If a DAO exception is thrown
   */
  protected PaginatedList executeQueryForPaginatedList(String statementName,
      Object parameterObject, int pageSize) throws DaoException {
    SqlMap sqlMap = getLocalSqlMap();
    try {
      return sqlMap.executeQueryForPaginatedList(statementName, parameterObject,
                                                 pageSize);
    }
    catch (SQLException e) {
      throw new DaoException(
          "Error executing query for paginated list.  Cause: " + e, e);
    }
  }

  /**
   * Simple convenience method to wrap the SqlMap method of the same name.
   * Wraps the exception with a DaoException to isolate the SqlMap framework.
   * @param statementName The mapped statement name
   * @param parameterObject The parameter object
   * @return the object returned
   * @throws DaoException If a DAO exception is thrown
   */
  protected Object executeQueryForObject(String statementName,
                                         Object parameterObject) throws
      DaoException {
    SqlMap sqlMap = getLocalSqlMap();
    try {
      return sqlMap.executeQueryForObject(statementName, parameterObject);
    }
    catch (SQLException e) {
      throw new DaoException("Error executing query for object.  Cause: " + e,
                             e);
    }
  }

  /**
   * Simple convenience method to wrap the SqlMap method of the same name.
   * Wraps the exception with a DaoException to isolate the SqlMap framework.
   * @param statementName The mapped statement name
   * @param parameterObject The parameter object
   * @return
   *      either (1) the row count for <code>INSERT</code>, <code>UPDATE</code>,
   *         or <code>DELETE</code> statements
   *         or (2) 0 for SQL statements that return nothing
   * @throws DaoException If a DAO exception is thrown
   */
  protected int executeUpdate(String statementName, Object parameterObject) throws
      DaoException {
    SqlMap sqlMap = getLocalSqlMap();
    try {
      return sqlMap.executeUpdate(statementName, parameterObject);
    }
    catch (SQLException e) {
      throw new DaoException("Error executing update.  Cause: " + e, e);
    }
  }

}