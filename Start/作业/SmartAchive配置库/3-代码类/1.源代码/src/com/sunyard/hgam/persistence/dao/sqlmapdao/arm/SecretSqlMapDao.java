package com.sunyard.hgam.persistence.dao.sqlmapdao.arm;

import com.sunyard.hgam.persistence.dao.base.BaseSqlMapDao;
import com.ibatis.common.util.PaginatedList;
import com.ibatis.db.dao.DaoException;
import com.sunyard.hgam.persistence.dao.iface.arm.SecretDao;
import com.sunyard.hgam.persistence.dao.beans.arm.Secret;
import java.util.List;

/**
 * <p>Title: 密级管理</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 叶昊
 * @version 1.0
 */

public class SecretSqlMapDao
    extends BaseSqlMapDao
    implements SecretDao {

  //得到所有密级
  public List getAllSecret() {
    List list = null;
    try {
      this.startTransation();
      list = this.executeQueryForList("getAllSecret", null);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    return list;
  }

  //根据ID得到一条密级
  public Secret getSecret(String secretID) {
    Secret secretInfo = null;
    try {
      this.startTransation();
      secretInfo = (Secret)this.executeQueryForObject("getSecretByID", secretID);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    return secretInfo;
  }

  //增加密级
  public int addSecret(Secret secret) {
    int result = 0;
    try {
      this.startTransation();
      result = this.executeUpdate("addSecret", secret);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    return result;
  }

  //修改密级
  public int modifySecret(Secret secret) {
    int result = 0;
    try {
      this.startTransation();
      result = this.executeUpdate("updateSecret", secret);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    return result;
  }

  //删除密级
  public int delSecret(String secretId) {
    int result = 0;
    try {
      this.startTransation();
      result = this.executeUpdate("deleteSecretByID", secretId);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    return result;
  }

}