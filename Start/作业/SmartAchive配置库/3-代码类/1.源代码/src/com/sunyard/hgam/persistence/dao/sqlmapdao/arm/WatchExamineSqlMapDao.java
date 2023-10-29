package com.sunyard.hgam.persistence.dao.sqlmapdao.arm;



import com.sunyard.hgam.persistence.dao.base.BaseSqlMapDao;
import com.ibatis.common.util.PaginatedList;
import com.ibatis.db.dao.DaoException;

import com.sunyard.hgam.persistence.dao.iface.arm.WatchExamineDao;
import com.sunyard.hgam.persistence.dao.beans.arm.WatchExamine;

/**
 * <p>Title:监督检查管理</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 华良东
 * @version 1.0
 */

public class WatchExamineSqlMapDao
    extends BaseSqlMapDao
    implements WatchExamineDao{
   public PaginatedList getAllWatchExamine() {
    return getAllWatchExamine(this.PAGE_SIZE);
  }

  public PaginatedList getAllWatchExamine(int pageSize){
   PaginatedList list = null;
   try {
     this.startTransation();
     list = this.executeQueryForPaginatedList("getAllWatchExamine",null,pageSize);
     this.commitTransation();
   }
   catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) { /* ignore */ }
      ex.printStackTrace();
    }
    return list;
  }
  //根据ID得到监督检查记录
  public  WatchExamine  getWatchExamine(String watchId){
    WatchExamine watchExamineInfo=null;
    try {
       this.startTransation();
       watchExamineInfo = (WatchExamine)this.executeQueryForObject("getWatchExamineByID", watchId);
       this.commitTransation();
     }
     catch (DaoException ex) {
       try {
         this.rollbackTransation();
       }
       catch (Exception ex2) { /* ignore */}
       ex.printStackTrace();
     }
     return watchExamineInfo;
  }
  //增加一条监督检查记录
  public int addWatchExamine(WatchExamine watchExamine){
  int result=0;
  try {
      this.startTransation();
      result=this.executeUpdate("addWatchExamine",watchExamine);
      this.commitTransation();
    }
   catch (DaoException ex){
     try {
       this.rollbackTransation();
     }
     catch (Exception ex2){/* ignore*/}
     ex.printStackTrace();
   }
    return result;}
  //查询监督检查列表(默认)
  public PaginatedList queryWatchExamineList(WatchExamine watchExamine){
    return queryWatchExamineList(watchExamine,this.PAGE_SIZE);
  }

  //查询监督检查列表(定制每页记录数)

public PaginatedList queryWatchExamineList(WatchExamine watchExamine,int pageSize){
  PaginatedList list = null;
  try {
    this.startTransation();
    list = this.executeQueryForPaginatedList("queryWatchExamineList", watchExamine, pageSize);
    this.commitTransation();
  }
  catch (DaoException ex) {
    try {
      this.rollbackTransation();
    }
    catch (Exception ex2) {}
    ex.printStackTrace();
  }
  return list;
}

  }
