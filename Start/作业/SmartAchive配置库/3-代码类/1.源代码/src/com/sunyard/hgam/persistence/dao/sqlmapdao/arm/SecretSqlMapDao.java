package com.sunyard.hgam.persistence.dao.sqlmapdao.arm;

import com.sunyard.hgam.persistence.dao.base.BaseSqlMapDao;
import com.ibatis.common.util.PaginatedList;
import com.ibatis.db.dao.DaoException;
import com.sunyard.hgam.persistence.dao.iface.arm.SecretDao;
import com.sunyard.hgam.persistence.dao.beans.arm.Secret;
import java.util.List;

/**
 * <p>Title: �ܼ�����</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author Ҷ�
 * @version 1.0
 */

public class SecretSqlMapDao
    extends BaseSqlMapDao
    implements SecretDao {

  //�õ������ܼ�
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

  //����ID�õ�һ���ܼ�
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

  //�����ܼ�
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

  //�޸��ܼ�
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

  //ɾ���ܼ�
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