package com.sunyard.hgam.persistence.dao.sqlmapdao.arm;

import com.sunyard.hgam.persistence.dao.base.BaseSqlMapDao;
import com.ibatis.common.util.PaginatedList;
import com.ibatis.db.dao.DaoException;
import com.sunyard.hgam.persistence.dao.beans.arm.OtherCataLog;
import com.sunyard.hgam.persistence.dao.iface.arm.OtherCataLogDao;

/**
 * <p>Title:杂项工程目录册管理</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 华良东
 * @version 1.0
 */

public class OtherCataLogSqlMapDao
    extends BaseSqlMapDao
    implements OtherCataLogDao{
   public PaginatedList getAllOtherCataLog() {
    return getAllOtherCataLog(this.PAGE_SIZE);
  }

  public PaginatedList getAllOtherCataLog(int pageSize){
   PaginatedList list = null;
   try {
     this.startTransation();
     list = this.executeQueryForPaginatedList("getAllOtherCataLog",null,pageSize);
     this.commitTransation();
   }
   catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) { /* ignore */ }
      ex.printStackTrace();
    }
    return list;
  }
  //根据ID得到一条建筑项目目录册记录
  public  OtherCataLog  getOtherCataLog(OtherCataLog cataLogId){
    OtherCataLog otherCataLogInfo=null;
    try {
       this.startTransation();
       otherCataLogInfo = (OtherCataLog)this.executeQueryForObject("getOtherCataLogByID",cataLogId);
       this.commitTransation();
     }
     catch (DaoException ex) {
       try {
         this.rollbackTransation();
       }
       catch (Exception ex2) { /* ignore */}
       ex.printStackTrace();
     }
     return otherCataLogInfo;
  }
  //增加一条建筑项目目录册记录
  public int addOtherCataLog(OtherCataLog otherCataLog){
  int result=0;
  try {
      this.startTransation();
      result=this.executeUpdate("addOtherCataLog",otherCataLog);
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
  //查询杂项目录册列表(默认)
public PaginatedList queryOtherCataLogList(OtherCataLog otherCataLog){
 return queryOtherCataLogList(otherCataLog,this.PAGE_SIZE);
}

//查询建筑目录册列表(定制每页记录数)

public PaginatedList queryOtherCataLogList(OtherCataLog otherCataLog,int pageSize){
PaginatedList list = null;
try {
 this.startTransation();
 list = this.executeQueryForPaginatedList("queryOtherCataLogList", otherCataLog, pageSize);
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
