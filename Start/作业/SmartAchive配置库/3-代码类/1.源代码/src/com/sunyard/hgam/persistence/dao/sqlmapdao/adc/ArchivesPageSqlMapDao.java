package com.sunyard.hgam.persistence.dao.sqlmapdao.adc;

import com.sunyard.hgam.persistence.dao.base.BaseSqlMapDao;
import java.util.List;
import com.sunyard.hgam.persistence.dao.iface.adc.ArchivesDao;
import com.ibatis.db.dao.DaoException;
import com.sunyard.hgam.persistence.dao.beans.adc.ArchivesPage;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.iface.adc.ArchivesPageDao;

/**
 * <p>Title: HGAM</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author not attributable
 * @version 1.0
 */

public class ArchivesPageSqlMapDao
    extends BaseSqlMapDao
    implements ArchivesPageDao{
  public ArchivesPageSqlMapDao() {
  }

  //得到“影像页”表最大的pageID
  public int getMaxPageID() throws Exception {
    Integer nRet = new Integer(0);
    try{
      this.startTransation();
      nRet = (Integer)this.executeQueryForObject("getMaxArchivesPageId", null);
      this.commitTransation();
    }catch(Exception e){
      try { this.rollbackTransation(); } catch (Exception ex2) { /* ignore */ }
      throw e;
    }
    if (nRet==null)
      nRet = new Integer(0);
    return nRet.intValue() ;
  }

  //得到“影像页”表某档案最大的页码pageNum
  public int getMaxPageNum(Integer archives_id) throws Exception {
    Integer nRet = new Integer(0);
    try {
      this.startTransation();
      nRet = (Integer)this.executeQueryForObject("getMaxArchivesPageNum",
                                                 archives_id);
      this.commitTransation();
    }
    catch (Exception e) {
      try {this.rollbackTransation();} catch (Exception ex2) { /* ignore */}
      throw e;
    }
    if (nRet==null)
      nRet = new Integer(0);
    return nRet.intValue() ;
  }

  //根据影像页page_id返回档案ID
  public int getArchivesIdByPageId(Integer page_id) throws Exception {
    Integer nRet = new Integer(0);
    try {
      this.startTransation();
      nRet = (Integer)this.executeQueryForObject("getArchivesIdByPageId",
                                                 page_id);
      this.commitTransation();
    }
    catch (Exception e) {
      try {this.rollbackTransation();} catch (Exception ex2) { /* ignore */}
      throw e;
    }
    if (nRet==null)
      nRet = new Integer(0);
    return nRet.intValue() ;
  }

  //扫描录入保存影像页
  public int addArchivesPage(ArchivesPage archivesPage) throws Exception{
    int iResult = 0;
    try {
      this.startTransation();
      iResult = this.executeUpdate("addArchivesPage", archivesPage);
      this.commitTransation();
    }
    catch (Exception ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) { /* ignore */ }
      throw ex;
    }
    return iResult;
  }

  //根据page_id更新影像页信息
  public int updateArchivesPage(ArchivesPage archivesPage) throws Exception{
    int iResult = 0;
    try {
      this.startTransation();
      iResult = this.executeUpdate("updateArchivesPage", archivesPage);
      this.commitTransation();
    }
    catch (Exception ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) { /* ignore */ }
      throw ex;
    }
    return iResult;
  }

  //根据page_id，批量更新影像页“文件file_id”字段信息
  public int updateListArchivesPageNum(String[] sPageId, String pagenum) throws Exception{
    int nResult = 0;
    ArchivesPage apUpdate = null;
    if (sPageId!=null)
      for (int i = 0; i < sPageId.length; i++) {
        Integer num = new Integer(pagenum);
        apUpdate = new ArchivesPage();
        apUpdate.setPage_num(num.toString());
        apUpdate.setPage_id(sPageId[i]);

        if (updateArchivesPageNum(apUpdate) > 0)
          nResult++;
      }
    return nResult ;
  }

  //根据page_id更新影像页“页码”字段信息
  public int updateArchivesPageNum(ArchivesPage archivesPage) throws Exception{
    int iResult = 0;
    try {
      this.startTransation();
      iResult = this.executeUpdate("updateArchivesPageNum", archivesPage);
      this.commitTransation();
    }
    catch (Exception ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) { /* ignore */ }
      throw ex;
    }
    return iResult;
  }

  //根据page_id，批量更新影像页“文件file_id”字段信息
  public int updateListArchivesPageFileID(String[] sPageId, String file_id) throws Exception{
    int nResult = 0;
    ArchivesPage apUpdate = null;
    if (sPageId!=null)
      for (int i = 0; i < sPageId.length; i++) {
        apUpdate = new ArchivesPage();
        apUpdate.setFile_id(file_id);
        apUpdate.setPage_id(sPageId[i]);

        if (updateArchivesPageFileID(apUpdate) > 0)
          nResult++;
      }
    return nResult ;
  }

  //根据page_id更新影像页“文件ID”字段信息
  public int updateArchivesPageFileID(ArchivesPage archivesPage) throws Exception{
    int iResult = 0;
    try {
      this.startTransation();
      iResult = this.executeUpdate("updateArchivesPageFileID", archivesPage);
      this.commitTransation();
    }
    catch (Exception ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) { /* ignore */ }
      throw ex;
    }
    return iResult;
  }

  //根据page_id，批量更新影像页“操作权限”字段信息
  public int updateListArchivesPageOperate(String[] sPageId, String operate) throws Exception{
    int nResult = 0;
    ArchivesPage apUpdate = null;
    if (sPageId!=null)
      for (int i = 0; i < sPageId.length; i++) {
        apUpdate = new ArchivesPage();
        apUpdate.setPage_operate(operate);
        apUpdate.setPage_id(sPageId[i]);

        if (updateArchivesPageOperate(apUpdate) > 0)
          nResult++;
      }
    return nResult ;
  }

  //根据page_id更新影像页“操作权限”字段信息
  public int updateArchivesPageOperate(ArchivesPage archivesPage) throws Exception{
    int iResult = 0;
    try {
      this.startTransation();
      iResult = this.executeUpdate("updateArchivesPageOperate", archivesPage);
      this.commitTransation();
    }
    catch (Exception ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) { /* ignore */ }
      throw ex;
    }
    return iResult;
  }

  //根据page_id，批量更新影像页“状态”字段信息
  public int updateListArchivesPageStatus(String[] sPageId, String status) throws Exception{
    int nResult = 0;
    ArchivesPage apUpdate = null;
    if (sPageId!=null)
      for (int i = 0; i < sPageId.length; i++) {
        apUpdate = new ArchivesPage();
        apUpdate.setPage_status(status);
        apUpdate.setPage_id(sPageId[i]);

        if (updateArchivesPageStatus(apUpdate) > 0)
          nResult++;
      }
    return nResult ;
  }

  //根据page_id更新影像页“状态”字段信息
  public int updateArchivesPageStatus(ArchivesPage archivesPage) throws Exception{
    int iResult = 0;
    try {
      this.startTransation();
      iResult = this.executeUpdate("updateArchivesPageStatus", archivesPage);
      this.commitTransation();
    }
    catch (Exception ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) { /* ignore */ }
      throw ex;
    }
    return iResult;
  }

  //根据page_id，批量更新影像页“页幅”字段信息
  public int updateListArchivesPageSize(String[] sPageId, String size) throws Exception{
    int nResult = 0;
    ArchivesPage apUpdate = null;
    if (sPageId!=null)
      for (int i = 0; i < sPageId.length; i++) {
        apUpdate = new ArchivesPage();
        apUpdate.setPage_size(size);
        apUpdate.setPage_id(sPageId[i]);

        if (updateArchivesPageSize(apUpdate) > 0)
          nResult++;
      }
    return nResult ;
  }

  //根据page_id更新影像页“页幅”字段信息
  public int updateArchivesPageSize(ArchivesPage archivesPage) throws Exception{
    int iResult = 0;
    try {
      this.startTransation();
      iResult = this.executeUpdate("updateArchivesPageSize", archivesPage);
      this.commitTransation();
    }
    catch (Exception ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) { /* ignore */ }
      throw ex;
    }
    return iResult;
  }

  //根据page_id，批量删除影像页
  public int deleteListArchivesPageByPageID(String[] sPageId) throws Exception{
    int nResult = 0;
    if (sPageId!=null)
      for (int i = 0; i < sPageId.length; i++) {
        if (deleteArchivesPageByPageID(new Integer(sPageId[i])) > 0)
          nResult++;
      }
    return nResult ;
  }

  //根据page_id删除影像页
  public int deleteArchivesPageByPageID(Integer page_id) throws Exception{
    int iResult = 0;
    try {
      this.startTransation();
      iResult = this.executeUpdate("deleteArchivesPageByPageID", page_id);
      this.commitTransation();
    }
    catch (Exception ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) { /* ignore */ }
      throw ex;
    }
    return iResult;
  }

  //根据file_id删除所有的影像页
  public int deleteArchivesPageByFileID(Integer file_id) throws Exception{
    int iResult = 0;
    try {
      this.startTransation();
      iResult = this.executeUpdate("deleteArchivesPageByFileID", file_id);
      this.commitTransation();
    }
    catch (Exception ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) { /* ignore */ }
      throw ex;
    }
    return iResult;
  }

  //根据archives_id删除所有的影像页
  public int deleteArchivesPageByArchivesID(Integer archives_id) throws Exception{
    int iResult = 0;
    try {
      this.startTransation();
      iResult = this.executeUpdate("deleteArchivesPageByArchivesID", archives_id);
      this.commitTransation();
    }
    catch (Exception ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) { /* ignore */ }
      throw ex;
    }
    return iResult;
  }



  //查询所有的影像页信息
  public PaginatedList queryArchivesPage(int pageSize) throws Exception {
    PaginatedList lstRet = null;
    try{
      this.startTransation();
      lstRet = this.executeQueryForPaginatedList("queryArchivesPage",
                                               null, pageSize);
      this.commitTransation();
    }catch(Exception e){
      try { this.rollbackTransation(); } catch (Exception ex2) { /* ignore */ }
      throw e;
    }
    return lstRet ;
  }

  //根据档案ID查询所有的“未通过检查”的影像页
  public List queryArchivesPageNotPass(String archives_id) throws Exception {
    List lstRet = null;
    try{
      this.startTransation();
      lstRet = (List)this.executeQueryForList("queryArchivesPageNotPass", archives_id);
      this.commitTransation();
    }catch(Exception e){
      try { this.rollbackTransation(); } catch (Exception ex2) { /* ignore */ }
      throw e;
    }
    return lstRet ;
  }

  //根据archives_id查询“页码相同”的page_id
  public List queryConflictPageNum(String archives_id) throws Exception {
    List lstRet = null;
    try{
      this.startTransation();
      lstRet = (List)this.executeQueryForList("queryConflictPageNum", archives_id);
      this.commitTransation();
    }catch(Exception e){
      try { this.rollbackTransation(); } catch (Exception ex2) { /* ignore */ }
      throw e;
    }
    return lstRet ;
  }

  //根据档案ArchivesID查询所有的影像页信息
  public PaginatedList queryArchivesPageByArchivesID(Integer archivesID,
      int pageSize) throws Exception {
    PaginatedList lstRet = null;
    try{
      this.startTransation();
      lstRet = this.executeQueryForPaginatedList("queryArchivesPageByArchivesID",
                                               archivesID, pageSize);
      this.commitTransation();
    }catch(Exception e){
      try { this.rollbackTransation(); } catch (Exception ex2) { /* ignore */ }
      throw e;
    }
    return lstRet ;
  }

  //根据文件FileID查询所有的影像页信息
  public PaginatedList queryArchivesPageByFileID(Integer fileID,
                                                 int pageSize) throws Exception {
    PaginatedList lstRet = null;
    try{
      this.startTransation();
      lstRet = this.executeQueryForPaginatedList("queryArchivesPageByFileID",
                                               fileID, pageSize);
      this.commitTransation();
    }catch(Exception e){
      try { this.rollbackTransation(); } catch (Exception ex2) { /* ignore */ }
      throw e;
    }
    return lstRet ;
  }

  //根据影像页PageID查询影像页信息
  public PaginatedList queryArchivesPageByPageID(Integer pageID,
                                                 int pageSize) throws Exception {
    PaginatedList lstRet = null;
    try{
      this.startTransation();
      lstRet = this.executeQueryForPaginatedList("queryArchivesPageByPageID",
                                               pageID, pageSize);
      this.commitTransation();
    }catch(Exception e){
      try { this.rollbackTransation(); } catch (Exception ex2) { /* ignore */ }
      throw e;
    }
    return lstRet ;
  }

  //根据影像页PageID返回影像页信息
  public ArchivesPage getArchivesPageByPageID(Integer pageID) throws Exception {
    ArchivesPage agRet = null;
    try{
      this.startTransation();
      agRet = (ArchivesPage)this.executeQueryForObject("queryArchivesPageByPageID", pageID);
      this.commitTransation();
    }catch(Exception e){
      try { this.rollbackTransation(); } catch (Exception ex2) { /* ignore */ }
      throw e;
    }
    return agRet ;
  }

  //得到pageID的上一页ID
  public int getPreviousPageId(ArchivesPage ap) throws Exception {
    Integer nRet = null;
    try{
      this.startTransation();
      nRet = (Integer)this.executeQueryForObject("getPreviousPageId", ap);
      this.commitTransation();
    }catch(Exception e){
      try { this.rollbackTransation(); } catch (Exception ex2) { /* ignore */ }
      throw e;
    }
    if (nRet==null)
      nRet = new Integer(0);
    return nRet.intValue() ;
  }

  //得到pageID的下一页ID
  public int getNextPageId(ArchivesPage ap) throws Exception {
    Integer nRet = null;
    try{
      this.startTransation();
      nRet = (Integer)this.executeQueryForObject("getNextPageId", ap);
      this.commitTransation();
    }catch(Exception e){
      try { this.rollbackTransation(); } catch (Exception ex2) { /* ignore */ }
      throw e;
    }
    if (nRet==null)
      nRet = new Integer(0);
    return nRet.intValue() ;
  }

  //按file_id，返回共有多少页
  public int getPageCountByFileID(Integer file_id) throws Exception {
    Integer nRet = new Integer(0);
    try{
      this.startTransation();
      nRet = (Integer)this.executeQueryForObject("getPageCountByFileID", file_id);
      this.commitTransation();
    }catch(Exception e){
      try { this.rollbackTransation(); } catch (Exception ex2) { /* ignore */ }
      throw e;
    }
    if (nRet==null)
      nRet = new Integer(0);
    return nRet.intValue() ;
  }

  //按archives_id，返回共有多少页
  public int getPageCountByArchivesID(Integer archives_id) throws Exception {
    Integer nRet = new Integer(0);
    try{
      this.startTransation();
      nRet = (Integer)this.executeQueryForObject("getPageCountByArchivesID", archives_id);
      this.commitTransation();
    }catch(Exception e){
      try { this.rollbackTransation(); } catch (Exception ex2) { /* ignore */ }
      throw e;
    }
    if (nRet==null)
      nRet = new Integer(0);
    return nRet.intValue() ;
  }
}