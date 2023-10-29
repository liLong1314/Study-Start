package com.sunyard.hgam.persistence.dao.sqlmapdao.arm;

import com.sunyard.hgam.persistence.dao.base.BaseSqlMapDao;
import com.ibatis.common.util.PaginatedList;
import com.ibatis.db.dao.DaoException;
import com.sunyard.hgam.persistence.dao.beans.arm.OtherCataLog;
import com.sunyard.hgam.persistence.dao.iface.arm.OtherCataLogDao;

/**
 * <p>Title:�����Ŀ¼�����</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author ������
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
  //����ID�õ�һ��������ĿĿ¼���¼
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
  //����һ��������ĿĿ¼���¼
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
  //��ѯ����Ŀ¼���б�(Ĭ��)
public PaginatedList queryOtherCataLogList(OtherCataLog otherCataLog){
 return queryOtherCataLogList(otherCataLog,this.PAGE_SIZE);
}

//��ѯ����Ŀ¼���б�(����ÿҳ��¼��)

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
