package com.sunyard.hgam.persistence.dao.sqlmapdao.arm;




import com.sunyard.hgam.persistence.dao.base.BaseSqlMapDao;
import com.ibatis.common.util.PaginatedList;
import com.ibatis.db.dao.DaoException;

import com.sunyard.hgam.persistence.dao.iface.arm.SubRollCatalogDao;
import com.sunyard.hgam.persistence.dao.beans.arm.SubRollCatalog;

/**
 * <p>Title:分局目录管理</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 华良东
 * @version 1.0
 */

public class SubRollCatalogSqlMapDao
    extends BaseSqlMapDao
    implements SubRollCatalogDao{
   public PaginatedList getAllSubRollCatalog() {
    return getAllSubRollCatalog(this.PAGE_SIZE);
  }

  public PaginatedList getAllSubRollCatalog(int pageSize){
   PaginatedList list = null;
   try {
     this.startTransation();
     list = this.executeQueryForPaginatedList("getAllSubRollCatalog",null,pageSize);
     this.commitTransation();
   }
   catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) { /* ignore */ }
      ex.printStackTrace();
    }
    return list;
  }
  //根据ID得到监督检查记录
  public  SubRollCatalog  getSubRollCatalog(SubRollCatalog rollCataId){
    SubRollCatalog subRollCatalogInfo=null;
    try {
       this.startTransation();
       subRollCatalogInfo = (SubRollCatalog)this.executeQueryForObject("getAllSubRollCatalog", rollCataId);
       this.commitTransation();
     }
     catch (DaoException ex) {
       try {
         this.rollbackTransation();
       }
       catch (Exception ex2) { /* ignore */}
       ex.printStackTrace();
     }
     return subRollCatalogInfo;
  }
  //增加一条监督检查记录
  public int addSubRollCatalog(SubRollCatalog subRollCatalog){
  int result=0;
  try {
      this.startTransation();
      result=this.executeUpdate("addSubRollCatalog",subRollCatalog);
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
  //查询分局目录列表(默认)
  public PaginatedList querySubRollCatalogList(SubRollCatalog subRollCatalog){
    return querySubRollCatalogList(subRollCatalog,this.PAGE_SIZE);
  }
   //查询分局目录列表(定制每页记录数)
  public PaginatedList querySubRollCatalogList(SubRollCatalog subRollCatalog,int pageSize){
  PaginatedList list = null;
  try {
    this.startTransation();
    list = this.executeQueryForPaginatedList("querySubRollCatalogList", subRollCatalog, pageSize);
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
