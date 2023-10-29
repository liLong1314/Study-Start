package com.sunyard.hgam.persistence.dao.sqlmapdao.arm;

import com.sunyard.hgam.persistence.dao.base.BaseSqlMapDao;
import com.sunyard.hgam.persistence.dao.iface.arm.ContainDao;
import com.ibatis.common.util.PaginatedList;
import com.ibatis.db.dao.DaoException;
import com.sunyard.hgam.persistence.dao.beans.arm.Contain;

/**
 * <p>Title: ����װ�߹���</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author Ҷ�
 * @version 1.0
 */

public class ContainSqlMapDao
    extends BaseSqlMapDao
    implements ContainDao{

  //�õ������ܼ��ܼ�¼
  public PaginatedList getAllContain() {
    return getAllContain(this.PAGE_SIZE);
  }

  public PaginatedList getAllContain(int pageSize) {
    PaginatedList list = null;
    try {
      this.startTransation();
      list = this.executeQueryForPaginatedList("getAllContain", null, pageSize);
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

  //��ѯ�ܼ��ܼ�¼
  public PaginatedList searchContain(Contain contain) {
    return searchContain(contain,this.PAGE_SIZE);
  }

  public PaginatedList searchContain(Contain contain,int pageSize) {
    PaginatedList list = null;
    try {
      this.startTransation();
      list = this.executeQueryForPaginatedList("searchContain", contain, pageSize);
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

  //����ID�õ�һ���ܼ��ܼ�¼
  public Contain getContain(String containID) {
    Contain ContainInfo = null;
    try {
      this.startTransation();
      ContainInfo = (Contain)this.executeQueryForObject("getContainByID", containID);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    return ContainInfo;
  }

  //�����ܼ���
  public int addContain(Contain contain) {
    int result = 0;
    try {
      this.startTransation();
      result = this.executeUpdate("addContain", contain);
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

  //�޸��ܼ���
  public int modifyContain(Contain contain) {
    int result = 0;
    try {
      this.startTransation();
      result = this.executeUpdate("updateContain", contain);
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

  //ɾ���ܼ���
  public int delContain(String containId) {
    int result = 0;
    try {
      this.startTransation();
      result = this.executeUpdate("deleteContainByID", containId);
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