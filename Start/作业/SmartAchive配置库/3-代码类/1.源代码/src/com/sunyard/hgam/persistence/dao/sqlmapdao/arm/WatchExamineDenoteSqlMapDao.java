package com.sunyard.hgam.persistence.dao.sqlmapdao.arm;

import com.sunyard.hgam.persistence.dao.base.BaseSqlMapDao;
import com.sunyard.hgam.persistence.dao.beans.arm.WatchExamineDenote;
import com.ibatis.db.dao.DaoException;
import com.sunyard.hgam.persistence.dao.iface.arm.WatchExamineDenoteDao;

/**
 * <p>Title: HGAM</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author not attributable
 * @version 1.0
 */

public class WatchExamineDenoteSqlMapDao
  extends BaseSqlMapDao
  implements WatchExamineDenoteDao{
//根据ID得到总局指示记录
public  WatchExamineDenote  getWatchExamineDenote(String watchId){
  WatchExamineDenote watchExamineDenoteInfo=null;
  try {
     this.startTransation();
     watchExamineDenoteInfo = (WatchExamineDenote)this.executeQueryForObject("getWatchExamineDenoteByID", watchId);
     this.commitTransation();
   }
   catch (DaoException ex) {
     try {
       this.rollbackTransation();
     }
     catch (Exception ex2) { /* ignore */}
     ex.printStackTrace();
   }
   return watchExamineDenoteInfo;
}
//增加一条总局指示记录
public int addWatchExamineDenote(WatchExamineDenote watchExamineDenote){
int result=0;
try {
    this.startTransation();
    result=this.executeUpdate("addWatchExamineDenote",watchExamineDenote);
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


}