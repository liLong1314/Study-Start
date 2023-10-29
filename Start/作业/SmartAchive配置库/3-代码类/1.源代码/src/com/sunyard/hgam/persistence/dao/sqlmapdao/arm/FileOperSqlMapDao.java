package com.sunyard.hgam.persistence.dao.sqlmapdao.arm;

import com.sunyard.hgam.persistence.dao.base.BaseSqlMapDao;
import com.sunyard.hgam.persistence.dao.iface.arm.FileOperDao;
import com.ibatis.common.util.PaginatedList;
import com.ibatis.db.dao.DaoException;
import com.sunyard.hgam.persistence.dao.beans.arm.Identify;
import com.sunyard.hgam.persistence.dao.beans.arm.Destroy;
import com.sunyard.hgam.persistence.dao.beans.arm.FileOper;

/**
 * <p>Title: ������Ϣ�����ļ�����</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author Ҷ�
 * @version 1.0
 */

public class FileOperSqlMapDao
    extends BaseSqlMapDao
    implements FileOperDao{

  //�õ������ļ��б�
  public PaginatedList getFiles(String archiveId) {
    return getFiles(archiveId,this.PAGE_SIZE);
  }

  public PaginatedList getFiles(String archiveId,int pageSize) {
    PaginatedList list = null;
    try {
      this.startTransation();
      list = this.executeQueryForPaginatedList("getFiles", archiveId, pageSize);
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

  //��ѯ�ļ�������������ϵͳ
  public PaginatedList queryFiles(FileOper fileOper) {
    return queryFiles(fileOper,this.PAGE_SIZE);
  }

  public PaginatedList queryFiles(FileOper fileOper,int pageSize) {
    PaginatedList list = null;
    try {
      this.startTransation();
      list = this.executeQueryForPaginatedList("queryFiles", fileOper, pageSize);
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

  //�õ���Ҫ�����ĵ����ļ��б�
  public PaginatedList getIdentFiles(String archiveId) {
    return getIdentFiles(archiveId,this.PAGE_SIZE);
  }

  public PaginatedList getIdentFiles(String archiveId,int pageSize) {
    PaginatedList list = null;
    try {
      this.startTransation();
      list = this.executeQueryForPaginatedList("getIdentFiles", archiveId, pageSize);
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

  //�õ���Ҫ���ٵĵ����ļ��б�
  public PaginatedList getDestroyFiles(String archiveId) {
    return getDestroyFiles(archiveId,this.PAGE_SIZE);
  }

  public PaginatedList getDestroyFiles(String archiveId,int pageSize) {
    PaginatedList list = null;
    try {
      this.startTransation();
      list = this.executeQueryForPaginatedList("getDestroyFiles", archiveId, pageSize);
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

  //�������ļ����ϼ�����־
  public int updateIdentFile(Identify identify) {
    int result = 0;
    try {
      this.startTransation();
///////////////////////
      result = this.executeUpdate("updateIdentFile", identify);
//      if (identify.getIdentifyResult()=="0"){  //����Ϊ�޼�ֵ
      result = this.executeUpdate("updateIdentArv", identify);
      result = this.executeUpdate("addIdentifyCheck", identify);
///////////////////////
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

  //�������ļ��������ٱ�־
  public int updateDestroyFile(Destroy destroy) {
    int result = 0;
    try {
      this.startTransation();
      result = this.executeUpdate("updateDestroyFile", destroy);
      result = this.executeUpdate("updateDestroyArv", destroy);
      result = this.executeUpdate("addDestroy", destroy);
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