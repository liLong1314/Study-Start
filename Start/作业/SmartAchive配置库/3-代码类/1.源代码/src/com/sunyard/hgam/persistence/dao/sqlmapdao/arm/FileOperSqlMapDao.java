package com.sunyard.hgam.persistence.dao.sqlmapdao.arm;

import com.sunyard.hgam.persistence.dao.base.BaseSqlMapDao;
import com.sunyard.hgam.persistence.dao.iface.arm.FileOperDao;
import com.ibatis.common.util.PaginatedList;
import com.ibatis.db.dao.DaoException;
import com.sunyard.hgam.persistence.dao.beans.arm.Identify;
import com.sunyard.hgam.persistence.dao.beans.arm.Destroy;
import com.sunyard.hgam.persistence.dao.beans.arm.FileOper;

/**
 * <p>Title: 档案信息管理－文件部分</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 叶昊
 * @version 1.0
 */

public class FileOperSqlMapDao
    extends BaseSqlMapDao
    implements FileOperDao{

  //得到档案文件列表
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

  //查询文件－档案利用子系统
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

  //得到需要鉴定的档案文件列表
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

  //得到需要销毁的档案文件列表
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

  //给档案文件打上鉴定标志
  public int updateIdentFile(Identify identify) {
    int result = 0;
    try {
      this.startTransation();
///////////////////////
      result = this.executeUpdate("updateIdentFile", identify);
//      if (identify.getIdentifyResult()=="0"){  //鉴定为无价值
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

  //给档案文件打上销毁标志
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