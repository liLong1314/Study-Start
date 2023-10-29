package com.sunyard.hgam.persistence.dao.sqlmapdao.arm;

import com.sunyard.hgam.persistence.dao.base.BaseSqlMapDao;
import com.sunyard.hgam.persistence.dao.iface.arm.ArchOperDao;
import com.sunyard.hgam.persistence.dao.beans.arm.ArchOper;
import com.ibatis.db.dao.DaoException;
import com.ibatis.common.util.PaginatedList;
import java.util.Map;
import java.util.List;

/**
 * <p>Title: ������Դ����������</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author Ҷ�
 * @version 1.0
 */

public class ArchOperSqlMapDao
    extends BaseSqlMapDao
    implements ArchOperDao{

  //���ݵ�����ĿID�õ������б�
  public PaginatedList getArchOper(String entryId) {
    return getArchOper(entryId,this.PAGE_SIZE);
  }

  public PaginatedList getArchOper(String entryId,int pageSize) {
    PaginatedList list = null;
    try {
      this.startTransation();
      list = this.executeQueryForPaginatedList("getArchivesByEntryID", entryId, pageSize);
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

  //��ѯ��������
  public PaginatedList searchArchive(ArchOper archOper) {
    return searchArchive(archOper,this.PAGE_SIZE);
  }

  public PaginatedList searchArchive(ArchOper archOper,int pageSize) {
    PaginatedList list = null;
    try {
      this.startTransation();
      list = this.executeQueryForPaginatedList("searchArchive", archOper, pageSize);
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

  //��ѯ��������--������ѯ������ϵͳ
  public PaginatedList queryArchive(ArchOper archOper) {
    return queryArchive(archOper,this.PAGE_SIZE);
  }

  public PaginatedList queryArchive(ArchOper archOper,int pageSize) {
    PaginatedList list = null;
    try {
      this.startTransation();
      list = this.executeQueryForPaginatedList("queryArchive", archOper, pageSize);
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

//hukp add
  public PaginatedList queryArchiveDest(ArchOper archOper,int pageSize) {
    PaginatedList list = null;
    try {
      this.startTransation();
      list = this.executeQueryForPaginatedList("queryArchiveDest", archOper, pageSize);
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

  //ҵ����Ϣ��ѯ--������ѯ������ϵͳ
  public PaginatedList queryOperArchive(ArchOper archOper) {
    return queryOperArchive(archOper,this.PAGE_SIZE);
  }

  public PaginatedList queryOperArchive(ArchOper archOper,int pageSize) {
    PaginatedList list = null;
    try {
      this.startTransation();
      list = this.executeQueryForPaginatedList("queryOperArchive", archOper, pageSize);
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

  //ģ����ѯ--������ѯ������ϵͳ
  public PaginatedList queryblurArchive(ArchOper archOper) {
    return queryblurArchive(archOper,this.PAGE_SIZE);
  }

  public PaginatedList queryblurArchive(ArchOper archOper,int pageSize) {
    PaginatedList list = null;
    try {
      this.startTransation();
      list = this.executeQueryForPaginatedList("queryblurArchive", archOper, pageSize);
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

  //����ID�õ�һ��������¼
  public ArchOper getOneArchive(String archiveID) {
    ArchOper archOperInfo = null;
    try {
      this.startTransation();
      archOperInfo = (ArchOper)this.executeQueryForObject("getOneArchive", archiveID);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    return archOperInfo;
  }

  //���ݵ���ID�õ������ĸ��ֱ���汾��Ϣ
  public PaginatedList getChangedArchives(String archiveId) {
    return getChangedArchives(archiveId,this.PAGE_SIZE);
  }

  public PaginatedList getChangedArchives(String archiveId,int pageSize) {
    PaginatedList list = null;
    try {
      this.startTransation();
      list = this.executeQueryForPaginatedList("getChangedArchives", archiveId, pageSize);
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

  //�������
  public int breakArchive(String archiveId) {
    int result = 0;
    try {
      this.startTransation();
      result = this.executeUpdate("breakArchive", archiveId);
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

  //���ӵ������
  public int addChangedArchive(ArchOper archOper) {
    int result = 0;
    try {
      this.startTransation();
      result = this.executeUpdate("addChangedArchive", archOper);
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

  //ADD BY ZHENGXQ
  public PaginatedList queryArchiveX(ArchOper archOper) {
    return queryArchiveX(archOper,this.PAGE_SIZE);
  }

  public PaginatedList queryArchiveX(ArchOper archOper,int pageSize) {
    PaginatedList list = null;
    try {
      this.startTransation();
      list = this.executeQueryForPaginatedList("queryArchiveX", archOper, pageSize);
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

  public PaginatedList queryblurArchiveX(ArchOper archOper) {
    return queryblurArchiveX(archOper, this.PAGE_SIZE);
  }

  public PaginatedList queryblurArchiveX(ArchOper archOper, int pageSize) {
    PaginatedList list = null;
    try {
      this.startTransation();
      list = this.executeQueryForPaginatedList("queryblurArchiveX", archOper,
                                               pageSize);
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

  public PaginatedList queryOperArchiveX(ArchOper archOper) {
    return queryOperArchiveX(archOper,this.PAGE_SIZE);
  }

  public PaginatedList queryOperArchiveX(ArchOper archOper,int pageSize) {
    PaginatedList list = null;
    try {
      this.startTransation();
      list = this.executeQueryForPaginatedList("queryOperArchiveX", archOper, pageSize);
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

  public PaginatedList getArchivesDescByEntryID(String entryId){
    return getArchivesDescByEntryID(entryId,this.PAGE_SIZE);
  }

  public PaginatedList getArchivesDescByEntryID(String entryId,int pageSize){
    PaginatedList list = null;
    try {
      this.startTransation();
      list = this.executeQueryForPaginatedList("getArchivesDescByEntryID", entryId, pageSize);
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

  public PaginatedList searchArchiveDest(ArchOper archOper){
    return searchArchiveDest(archOper,this.PAGE_SIZE);
  }

  public PaginatedList searchArchiveDest(ArchOper archOper,int pageSize){
    PaginatedList list = null;
    try {
      this.startTransation();
      list = this.executeQueryForPaginatedList("searchArchiveDest", archOper, pageSize);
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




}