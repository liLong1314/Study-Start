package com.sunyard.hgam.persistence.dao.iface.adc;

import com.sunyard.hgam.persistence.dao.beans.adc.ArchivesPage;
import java.util.List;
import com.ibatis.common.util.PaginatedList;

/**
 * <p>Title: HGAM</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author not attributable
 * @version 1.0
 */

public interface ArchivesPageDao {
  //�õ���Ӱ��ҳ��������pageID
  public int getMaxPageID() throws Exception;

  //�õ���Ӱ��ҳ����ĳ��������ҳ��pageNum
  public int getMaxPageNum(Integer archives_id) throws Exception;

  //����Ӱ��ҳpage_id���ص���ID
  public int getArchivesIdByPageId(Integer page_id) throws Exception;

  //����Ӱ��ҳPageID����Ӱ��ҳ��Ϣ
  public ArchivesPage getArchivesPageByPageID(Integer pageID) throws Exception;

  //����Ӱ��ҳPageID��ѯӰ��ҳ��Ϣ
  public PaginatedList queryArchivesPageByPageID(Integer pageID,
                                                 int pageSize) throws Exception;

  //�����ļ�FileID��ѯ���е�Ӱ��ҳ��Ϣ
  public PaginatedList queryArchivesPageByFileID(Integer FileID,
                                                 int pageSize) throws Exception;

  //���ݵ���ArchivesID��ѯ���е�Ӱ��ҳ��Ϣ
  public PaginatedList queryArchivesPageByArchivesID(Integer archivesID,
      int pageSize) throws Exception;

  //���ݵ���ArchivesID��ѯ���е�Ӱ��ҳ��Ϣ
  public PaginatedList queryArchivesPage(int pageSize) throws Exception;

  //����archives_id��ѯ��ҳ����ͬ����page_id
  public List queryConflictPageNum(String archives_id) throws Exception ;

  //���ݵ���ID��ѯ���еġ�δͨ����顱��Ӱ��ҳ
  public List queryArchivesPageNotPass(String archives_id) throws Exception ;

  //ɨ��¼�뱣��һ��Ӱ��ҳ
  public int addArchivesPage(ArchivesPage archivesPage) throws Exception;

  //����page_id����Ӱ��ҳ��Ϣ
  public int updateArchivesPage(ArchivesPage archivesPage) throws Exception;

  //����page_id����Ӱ��ҳ��ҳ�롱�ֶ���Ϣ
  public int updateArchivesPageNum(ArchivesPage archivesPage) throws Exception;

  //����page_id����Ӱ��ҳ���ļ�ID���ֶ���Ϣ
  public int updateArchivesPageFileID(ArchivesPage archivesPage) throws Exception;

  //����page_id����Ӱ��ҳ������Ȩ�ޡ��ֶ���Ϣ
  public int updateArchivesPageOperate(ArchivesPage archivesPage) throws Exception;

  //����page_id����Ӱ��ҳ��״̬���ֶ���Ϣ
  public int updateArchivesPageStatus(ArchivesPage archivesPage) throws Exception;

  //����page_id����Ӱ��ҳ��ҳ�����ֶ���Ϣ
  public int updateArchivesPageSize(ArchivesPage archivesPage) throws Exception;

  //����page_id����������Ӱ��ҳ���ļ�file_id���ֶ���Ϣ
  public int updateListArchivesPageNum(String[] sPageId, String pagenum) throws Exception;

  //����page_id����������Ӱ��ҳ���ļ�file_id���ֶ���Ϣ
  public int updateListArchivesPageFileID(String[] sPageId, String file_id) throws Exception;

  //����page_id����������Ӱ��ҳ������Ȩ�ޡ��ֶ���Ϣ
  public int updateListArchivesPageOperate(String[] sPageId, String operate) throws Exception;

  //����page_id����������Ӱ��ҳ��״̬���ֶ���Ϣ
  public int updateListArchivesPageStatus(String[] sPageId, String status) throws Exception;

  //����page_id����������Ӱ��ҳ��ҳ�����ֶ���Ϣ
  public int updateListArchivesPageSize(String[] sPageId, String size) throws Exception;

  //����page_id������ɾ��Ӱ��ҳ
  public int deleteListArchivesPageByPageID(String[] sPageId) throws Exception;

  //����page_idɾ��Ӱ��ҳ
  public int deleteArchivesPageByPageID(Integer page_id) throws Exception;

  //����file_idɾ�����е�Ӱ��ҳ
  public int deleteArchivesPageByFileID(Integer file_id) throws Exception;

  //����archives_idɾ�����е�Ӱ��ҳ
  public int deleteArchivesPageByArchivesID(Integer archives_id) throws Exception;

  //�õ�pageID����һҳID
  public int getNextPageId(ArchivesPage ap) throws Exception ;

  //�õ�pageID����һҳID
  public int getPreviousPageId(ArchivesPage ap) throws Exception ;

  //��archives_id�����ع��ж���ҳ
  public int getPageCountByArchivesID(Integer archives_id) throws Exception ;

  //��file_id�����ع��ж���ҳ
  public int getPageCountByFileID(Integer file_id) throws Exception ;

}