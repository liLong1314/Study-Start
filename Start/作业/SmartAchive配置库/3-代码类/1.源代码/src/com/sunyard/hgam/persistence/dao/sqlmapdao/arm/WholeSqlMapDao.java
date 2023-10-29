package com.sunyard.hgam.persistence.dao.sqlmapdao.arm;

import com.sunyard.hgam.persistence.dao.base.BaseSqlMapDao;
import com.sunyard.hgam.persistence.dao.iface.arm.WholeDao;
import com.ibatis.common.util.PaginatedList;
import com.ibatis.db.dao.DaoException;
import com.sunyard.hgam.persistence.dao.beans.arm.Whole;
import java.util.List;

/**
 * <p>Title: ȫ�ھ���Ϣ����</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author Ҷ�
 * @version 1.0
 */

public class WholeSqlMapDao
    extends BaseSqlMapDao
    implements WholeDao {
  //�������͵õ�ȫ�ھ���Ϣ�б�
  public List getWholeByType(String wholetype) {
    List list = null;
    try {
      this.startTransation();
      list = this.executeQueryForList("getWholeByType", wholetype);
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

  //����ID�õ�һ��ȫ�ھ���Ϣ
  public Whole getWhole(String wholeID) {
    Whole wholeInfo = null;
    try {
      this.startTransation();
      wholeInfo = (Whole)this.executeQueryForObject("getWholeByID", wholeID);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    return wholeInfo;
  }

  //����ȫ�ھ���Ϣ
  public int addWhole(Whole whole) {
    int result = 0;
    try {
      this.startTransation();
      result = this.executeUpdate("addWhole", whole);
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

  //�޸�ȫ�ھ���Ϣ
  public int modifyWhole(Whole whole) {
    int result = 0;
    try {
      this.startTransation();
      result = this.executeUpdate("updateWhole", whole);
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

  //ɾ��ȫ�ھ���Ϣ
  public int delWhole(String wholeId) {
    int result = 0;
    try {
      this.startTransation();
      result = this.executeUpdate("deleteWholeByID", wholeId);
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