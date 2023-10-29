package com.sunyard.hgam.persistence.dao.iface.adc;

import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.beans.adc.Archives;
import com.sunyard.hgam.persistence.dao.beans.adc.ArchivesFile;
import java.util.Map;
import java.util.List;

/**
 * <p>Title: HGAM</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 郑先全
 * @version 1.0
 */

public interface ArchivesFileDao {
  //新增档案文件信息(一般文书类)
  public int addArchivesFile(ArchivesFile archivesFile);

  //新增档案文件信息(具有电子表单的业务类)
  public int addArchivesFile(ArchivesFile archivesFile,List eformFieldValueList);

  //取得最大的文件ID编码
  public Integer getMaxFileId();

  //根据档案ArchivesID查询所有的文件信息
  public PaginatedList queryArchivesFileByArchivesID(String archivesID) throws Exception;
  public PaginatedList queryArchivesFileByArchivesID(String archivesID,
      int pageSize) throws Exception;

  //根据文件FileID查询所有的文件信息
  public PaginatedList queryArchivesFileByFileID(String fileID, int pageSize) throws
      Exception;

  //根据文件FileID查询文件信息
  public ArchivesFile getArchivesFileByFileID(String fileID) throws Exception;

  //根据项目、档号找到顶级项目阶段和文件列表（郑先全）
  public List queryTopArchivesProjPhaseList(Archives archives);

  //根据项目、档号找到除了顶级项目阶段外的其他项目阶段和文件列表（郑先全）
  public List queryOtherArchivesProjPhaseList(ArchivesFile archivesFile);

  //根据项目找到所有顶级项目阶段和文件列表（郑先全）
  public List queryAllTopProjPhaseList(Archives archives);

  //根据项目找到除了顶级项目阶段外的s所有其他项目阶段和文件列表（郑先全）
  public List queryAllOtherProjPhaseList(ArchivesFile archivesFile);

  //更新文件信息(无电子表单信息)
  public int updateArchivesFile(ArchivesFile archivesFile);

  //更新文件信息(有电子表单信息)
  public int updateArchivesFile(ArchivesFile archivesFile,List eformFieldValueList);

  //取得接收的文件列表
  public PaginatedList getReceivedArchivesFiles(ArchivesFile archivesFile) throws Exception;
  public PaginatedList getReceivedArchivesFiles(ArchivesFile archivesFile,int pageSize) throws Exception;

  //选定已接收的文件
  public int updateReceivedArchivesFiles(List archivesFileList);

  //列出档案某个阶段的所有文件
  public PaginatedList queryArchivesFileByPhaseID(ArchivesFile archivesFile);
  public PaginatedList queryArchivesFileByPhaseID(ArchivesFile archivesFile,int pageSize);
 public PaginatedList queryArchivesFileJianByArchivesID(String archivesID) throws Exception ;
 //查询档案列表 hukp add
 public List queryArchivesJianByID(Map projIdMap);

 //根据fileID更新是否借出的标志位,wanghua add,2004-03-15
 public int updateBorrowStatusByFileID(Map fileIDMap);

 //查询文件列表
  public PaginatedList queryArchivesFile(ArchivesFile archivesFile) throws Exception;
  public PaginatedList queryArchivesFile(ArchivesFile archivesFile, int pageSize) throws Exception;

}