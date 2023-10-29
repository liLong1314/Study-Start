package com.sunyard.hgam.persistence.dao.iface.rcv;

import java.util.List;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.beans.adc.ArchivesFile;

public interface IfaceArchivesFileDao {
  //根据查询条件，返回文件列表(默认)
  public PaginatedList queryIfaceArchivesFileList(ArchivesFile ifaceFile);
  //根据查询条件，返回文件列表(定制每页记录数)
  public PaginatedList queryIfaceArchivesFileList(ArchivesFile ifaceFile,int pageSize);
  //根据file_id，取得接口库文件信息
  public ArchivesFile getIfaceArchivesFileByFileId(String fileId);
  //根据file_id，取得接口库文件所对于的所有影像页列表
  public List getIfaceArchivesPageByFileID(String fileId);
  //根据file_id,取得电子表单字段定义及其字段值
  public List getIfaceEformFieldValueInfoByFileId(String fileId);
  //导入接口库的电子表单
  public int insertAllEformFromOA();
  //事务化接收接口档案文件著录信息、文件附件、影像页著录信息、影像页文件、元数据（无电子表单）
  public int receiveIfaceInfoInTrans(ArchivesFile archivesFile,String ifaceFileId,
                                     List archivesPageList, List fileUrlList,
                                     List metadataList) throws java.lang.Exception;

  //事务化接收接口档案文件著录信息、文件附件、影像页著录信息、影像页文件、元数据（有电子表单）
  public int receiveIfaceInfoInTrans(ArchivesFile archivesFile,String ifaceFileId,
                                     List archivesPageList, List fileUrlList,
                                     List metadataList,
                                     List eformFieldValueList) throws java.lang.Exception;

  //更新接口库文件状态为“已接收”
  public int updateIfaceArchivesFileStatusToReceivedByFileId(String fileId);
  //更新接口库文件状态为“已退回”
  public int updateIfaceArchivesFileStatusToBackByFileIds(String fileIds);

}
