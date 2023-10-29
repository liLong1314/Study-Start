package com.sunyard.hgam.persistence.dao.sqlmapdao.arm;



import com.sunyard.hgam.persistence.dao.base.BaseSqlMapDao;
import com.ibatis.common.util.PaginatedList;
import com.ibatis.db.dao.DaoException;

import com.sunyard.hgam.persistence.dao.iface.arm.WatchExamineDao;
import com.sunyard.hgam.persistence.dao.beans.arm.WatchExamine;

/**
 * <p>Title:�ල������</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author ������
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
  //����ID�õ��ල����¼
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
  //����һ���ල����¼
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
  //��ѯ�ල����б�(Ĭ��)
  public PaginatedList queryWatchExamineList(WatchExamine watchExamine){
    return queryWatchExamineList(watchExamine,this.PAGE_SIZE);
  }

  //��ѯ�ල����б�(����ÿҳ��¼��)

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
