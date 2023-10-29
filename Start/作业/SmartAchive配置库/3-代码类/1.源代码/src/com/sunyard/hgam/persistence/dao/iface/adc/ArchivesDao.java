package com.sunyard.hgam.persistence.dao.iface.adc;

import com.sunyard.hgam.persistence.dao.beans.adc.Archives;
import java.util.List;
import com.ibatis.common.util.PaginatedList;

public interface ArchivesDao {
  //根据档案ID，返回档案信息
  public Archives getArchivesByArchivesID(int archives_id);

  //根据档案ID，返回档案备考信息
  public Archives getArchivesByArchivesID_BK(int archives_id);

  /*下面三个全部以addArchives替代
  //新增文书类案卷
  public int addWenshuRollArchives(Archives archives);
  //新增业务类案卷
  public int addYewuRollArchives(Archives archives);
  //新增件
  public int addPieceArchives(Archives archives);
  */
  //新增档案（卷、件）
  public int addArchives(Archives archives);

  //取得最大的档案号
  public Integer getMaxArchivesId();
  //取得最大的案卷号
  public Integer getMaxRollNum();
  //取得最大的件号（室编件号）
  public Integer getMaxPieceNum();
  //取得档号是否存在的判断
  public Boolean getIsExistArchivesNum(String archivesNum);
  //取得案卷号是否存在的判断
  public Boolean getIsExistRollNum(String rollNum);
  //取得件号是否存在的判断
  public Boolean getIsExistPieceNum(String pieceNum);

  //查询档案列表(默认)
  public PaginatedList queryArchivesList(Archives archives);
  //查询档案列表(定制每页记录数)
  public PaginatedList queryArchivesList(Archives archives,int pageSize);

  //查询档案列表(默认) xuxj
  public PaginatedList queryArchivesListCheck(Archives archives);
  //查询档案列表(定制每页记录数)
  public PaginatedList queryArchivesListCheck(Archives archives,int pageSize);
  //根据档案ID更新档案“状态” archives_status
  public int updateArchivesStatusByArchivesID(Archives archives) throws Exception;
  //修订档案信息
  public int updateArchives(Archives archives) throws Exception;

}