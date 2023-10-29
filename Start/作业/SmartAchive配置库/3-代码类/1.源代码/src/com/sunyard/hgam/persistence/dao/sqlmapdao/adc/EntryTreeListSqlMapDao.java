package com.sunyard.hgam.persistence.dao.sqlmapdao.adc;

import com.sunyard.hgam.persistence.dao.base.BaseSqlMapDao;
import java.util.List;
import com.sunyard.hgam.persistence.dao.iface.adc.EntryTreeListDao;
import com.ibatis.db.dao.DaoException;

/**
 * <p>Title: HGAM</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author ֣��ȫ
 * @version 1.0
 */

public class EntryTreeListSqlMapDao extends BaseSqlMapDao implements EntryTreeListDao {
  //�õ���һ�������Ŀ�б�
  public List getAllFirstLevelTree() {
    List list = null;
    try {
      this.startTransation();
      list = this.executeQueryForList("getAllFirstLevelTree", null);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return list;
  }

  //�õ���һ�������Ŀ�б�(����)
  public List getFirstLevelTreeForRoll(){
    List list = null;
    try {
      this.startTransation();
      list = this.executeQueryForList("getFirstLevelTreeForRoll", null);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return list;

  }


  //�õ���һ�������Ŀ�б�(��)
  public List getFirstLevelTreeForPiece(){
    List list = null;
    try {
      this.startTransation();
      list = this.executeQueryForList("getFirstLevelTreeForPiece", null);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return list;

  }

  //���ݸ��ڵ��ҵ���������Ŀ�б�
  public List getSecondLevelTreeByFatherId(Integer entryId) {
    List list = null;
    try {
      this.startTransation();
      list = this.executeQueryForList("getSecondLevelTreeByFatherId", entryId);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return list;
  }

  //���ݸ��ڵ��ҵ���������Ŀ�б�
  public List getSecondLevelTreeByFatherIdForPiece(Integer entryId){
    List list = null;
    try {
      this.startTransation();
      list = this.executeQueryForList("getSecondLevelTreeByFatherIdForPiece", entryId);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return list;

  }
}