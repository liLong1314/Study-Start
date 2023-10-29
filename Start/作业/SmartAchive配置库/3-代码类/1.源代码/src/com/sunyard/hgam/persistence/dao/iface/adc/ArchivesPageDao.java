package com.sunyard.hgam.persistence.dao.iface.adc;

import com.sunyard.hgam.persistence.dao.beans.adc.ArchivesPage;
import java.util.List;
import com.ibatis.common.util.PaginatedList;

/**
 * <p>Title: HGAM</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author not attributable
 * @version 1.0
 */

public interface ArchivesPageDao {
  //得到“影像页”表最大的pageID
  public int getMaxPageID() throws Exception;

  //得到“影像页”表某档案最大的页码pageNum
  public int getMaxPageNum(Integer archives_id) throws Exception;

  //根据影像页page_id返回档案ID
  public int getArchivesIdByPageId(Integer page_id) throws Exception;

  //根据影像页PageID返回影像页信息
  public ArchivesPage getArchivesPageByPageID(Integer pageID) throws Exception;

  //根据影像页PageID查询影像页信息
  public PaginatedList queryArchivesPageByPageID(Integer pageID,
                                                 int pageSize) throws Exception;

  //根据文件FileID查询所有的影像页信息
  public PaginatedList queryArchivesPageByFileID(Integer FileID,
                                                 int pageSize) throws Exception;

  //根据档案ArchivesID查询所有的影像页信息
  public PaginatedList queryArchivesPageByArchivesID(Integer archivesID,
      int pageSize) throws Exception;

  //根据档案ArchivesID查询所有的影像页信息
  public PaginatedList queryArchivesPage(int pageSize) throws Exception;

  //根据archives_id查询“页码相同”的page_id
  public List queryConflictPageNum(String archives_id) throws Exception ;

  //根据档案ID查询所有的“未通过检查”的影像页
  public List queryArchivesPageNotPass(String archives_id) throws Exception ;

  //扫描录入保存一批影像页
  public int addArchivesPage(ArchivesPage archivesPage) throws Exception;

  //根据page_id更新影像页信息
  public int updateArchivesPage(ArchivesPage archivesPage) throws Exception;

  //根据page_id更新影像页“页码”字段信息
  public int updateArchivesPageNum(ArchivesPage archivesPage) throws Exception;

  //根据page_id更新影像页“文件ID”字段信息
  public int updateArchivesPageFileID(ArchivesPage archivesPage) throws Exception;

  //根据page_id更新影像页“操作权限”字段信息
  public int updateArchivesPageOperate(ArchivesPage archivesPage) throws Exception;

  //根据page_id更新影像页“状态”字段信息
  public int updateArchivesPageStatus(ArchivesPage archivesPage) throws Exception;

  //根据page_id更新影像页“页幅”字段信息
  public int updateArchivesPageSize(ArchivesPage archivesPage) throws Exception;

  //根据page_id，批量更新影像页“文件file_id”字段信息
  public int updateListArchivesPageNum(String[] sPageId, String pagenum) throws Exception;

  //根据page_id，批量更新影像页“文件file_id”字段信息
  public int updateListArchivesPageFileID(String[] sPageId, String file_id) throws Exception;

  //根据page_id，批量更新影像页“操作权限”字段信息
  public int updateListArchivesPageOperate(String[] sPageId, String operate) throws Exception;

  //根据page_id，批量更新影像页“状态”字段信息
  public int updateListArchivesPageStatus(String[] sPageId, String status) throws Exception;

  //根据page_id，批量更新影像页“页幅”字段信息
  public int updateListArchivesPageSize(String[] sPageId, String size) throws Exception;

  //根据page_id，批量删除影像页
  public int deleteListArchivesPageByPageID(String[] sPageId) throws Exception;

  //根据page_id删除影像页
  public int deleteArchivesPageByPageID(Integer page_id) throws Exception;

  //根据file_id删除所有的影像页
  public int deleteArchivesPageByFileID(Integer file_id) throws Exception;

  //根据archives_id删除所有的影像页
  public int deleteArchivesPageByArchivesID(Integer archives_id) throws Exception;

  //得到pageID的下一页ID
  public int getNextPageId(ArchivesPage ap) throws Exception ;

  //得到pageID的上一页ID
  public int getPreviousPageId(ArchivesPage ap) throws Exception ;

  //按archives_id，返回共有多少页
  public int getPageCountByArchivesID(Integer archives_id) throws Exception ;

  //按file_id，返回共有多少页
  public int getPageCountByFileID(Integer file_id) throws Exception ;

}