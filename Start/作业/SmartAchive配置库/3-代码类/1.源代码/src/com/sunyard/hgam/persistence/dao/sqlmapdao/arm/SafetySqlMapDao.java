package com.sunyard.hgam.persistence.dao.sqlmapdao.arm;

import com.sunyard.hgam.persistence.dao.base.BaseSqlMapDao;
import com.sunyard.hgam.persistence.dao.iface.arm.SafetyDao;
import com.ibatis.common.util.PaginatedList;
import com.ibatis.db.dao.DaoException;
import com.sunyard.hgam.persistence.dao.beans.arm.Safety;

/**
 * <p>Title: ��ȫ����</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author Ҷ�
 * @version 1.0
 */

public class SafetySqlMapDao
    extends BaseSqlMapDao
    implements SafetyDao{

  //�õ����а�ȫ��¼
  public PaginatedList getAllSafety() {
    return getAllSafety(this.PAGE_SIZE);
  }

  public PaginatedList getAllSafety(int pageSize) {
    PaginatedList list = null;
    try {
      this.startTransation();
      list = this.executeQueryForPaginatedList("getAllSafety", null, pageSize);
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

  //��ѯ��ȫ��¼
  public PaginatedList searchSafety(Safety safety) {
    return searchSafety(safety,this.PAGE_SIZE);
  }

  public PaginatedList searchSafety(Safety safety,int pageSize) {
    PaginatedList list = null;
    try {
      this.startTransation();
      list = this.executeQueryForPaginatedList("searchSafety", safety, pageSize);
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

  //����ID�õ�һ����ȫ��Ϣ��¼
  public Safety getSafety(String safetyID) {
    Safety safetyInfo = null;
    try {
      this.startTransation();
      safetyInfo = (Safety)this.executeQueryForObject("getSafetyByID", safetyID);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    return safetyInfo;
  }

  //���Ӱ�ȫ��Ϣ
  public int addSafety(Safety safety) {
    int result = 0;
    try {
      this.startTransation();
      result = this.executeUpdate("addSafety", safety);
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

  //�޸İ�ȫ��Ϣ
  public int modifySafety(Safety safety) {
    int result = 0;
    try {
      this.startTransation();
      result = this.executeUpdate("updateSafety", safety);
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

  //ɾ����ȫ��Ϣ
  public int delSafety(String safetyId) {
    int result = 0;
    try {
      this.startTransation();
      result = this.executeUpdate("deleteSafetyByID", safetyId);
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