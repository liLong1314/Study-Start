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
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
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

  //�õ���Ӱ��ҳ��������pageID
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

  //�õ���Ӱ��ҳ����ĳ��������ҳ��pageNum
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

  //����Ӱ��ҳpage_id���ص���ID
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

  //ɨ��¼�뱣��Ӱ��ҳ
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

  //����page_id����Ӱ��ҳ��Ϣ
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

  //����page_id����������Ӱ��ҳ���ļ�file_id���ֶ���Ϣ
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

  //����page_id����Ӱ��ҳ��ҳ�롱�ֶ���Ϣ
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

  //����page_id����������Ӱ��ҳ���ļ�file_id���ֶ���Ϣ
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

  //����page_id����Ӱ��ҳ���ļ�ID���ֶ���Ϣ
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

  //����page_id����������Ӱ��ҳ������Ȩ�ޡ��ֶ���Ϣ
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

  //����page_id����Ӱ��ҳ������Ȩ�ޡ��ֶ���Ϣ
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

  //����page_id����������Ӱ��ҳ��״̬���ֶ���Ϣ
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

  //����page_id����Ӱ��ҳ��״̬���ֶ���Ϣ
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

  //����page_id����������Ӱ��ҳ��ҳ�����ֶ���Ϣ
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

  //����page_id����Ӱ��ҳ��ҳ�����ֶ���Ϣ
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

  //����page_id������ɾ��Ӱ��ҳ
  public int deleteListArchivesPageByPageID(String[] sPageId) throws Exception{
    int nResult = 0;
    if (sPageId!=null)
      for (int i = 0; i < sPageId.length; i++) {
        if (deleteArchivesPageByPageID(new Integer(sPageId[i])) > 0)
          nResult++;
      }
    return nResult ;
  }

  //����page_idɾ��Ӱ��ҳ
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

  //����file_idɾ�����е�Ӱ��ҳ
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

  //����archives_idɾ�����е�Ӱ��ҳ
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



  //��ѯ���е�Ӱ��ҳ��Ϣ
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

  //���ݵ���ID��ѯ���еġ�δͨ����顱��Ӱ��ҳ
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

  //����archives_id��ѯ��ҳ����ͬ����page_id
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

  //���ݵ���ArchivesID��ѯ���е�Ӱ��ҳ��Ϣ
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

  //�����ļ�FileID��ѯ���е�Ӱ��ҳ��Ϣ
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

  //����Ӱ��ҳPageID��ѯӰ��ҳ��Ϣ
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

  //����Ӱ��ҳPageID����Ӱ��ҳ��Ϣ
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

  //�õ�pageID����һҳID
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

  //�õ�pageID����һҳID
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

  //��file_id�����ع��ж���ҳ
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

  //��archives_id�����ع��ж���ҳ
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