package com.sunyard.hgam.persistence.dao.sqlmapdao.arm;




import com.sunyard.hgam.persistence.dao.base.BaseSqlMapDao;
import com.ibatis.common.util.PaginatedList;
import com.ibatis.db.dao.DaoException;

import com.sunyard.hgam.persistence.dao.iface.arm.SubRollCatalogDao;
import com.sunyard.hgam.persistence.dao.beans.arm.SubRollCatalog;

/**
 * <p>Title:�־�Ŀ¼����</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author ������
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
  //����ID�õ��ල����¼
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
  //����һ���ල����¼
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
  //��ѯ�־�Ŀ¼�б�(Ĭ��)
  public PaginatedList querySubRollCatalogList(SubRollCatalog subRollCatalog){
    return querySubRollCatalogList(subRollCatalog,this.PAGE_SIZE);
  }
   //��ѯ�־�Ŀ¼�б�(����ÿҳ��¼��)
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
