package com.sunyard.hgam.persistence.dao.iface.pub;

import com.sunyard.hgam.persistence.dao.beans.pub.PublishInfo;
import com.ibatis.db.dao.DaoException;
import java.util.List;
import com.ibatis.common.util.PaginatedList;

public interface PublishInfoDao {
  //新增发布信息
  public int addPublishInfo(PublishInfo publishInfo) throws DaoException;
  //新增发布信息(包括附件)
  public int addPublishInfo(PublishInfo publishInfo,List publishInfoAccessoryList) throws DaoException;
  //取得最大的INFO_ID
  public int getMaxInfoId() throws Exception;
  //根据类别列出前N个记录
  public List queryPublishInfoListByType(String strType) throws Exception;
  public List queryPublishInfoListByType(String strType,int pageSize) throws Exception;
  //根据ID取出发布信息
  public PublishInfo getPublishInfoById(String info_id) throws Exception;
  //更新发布信息
  public int updatePublishInfo(PublishInfo publishInfo) throws Exception;
  //查询发布信息
  public PaginatedList queryPublishInfoList(PublishInfo publishInfo) throws Exception;
  public PaginatedList queryPublishInfoList(PublishInfo publishInfo,int pageSize) throws Exception;
  //审核发布信息
  public int updatePublishInfoForConfirm(PublishInfo publishInfo) throws Exception;
  //查询反馈信息
  public PaginatedList queryFeedbackList(PublishInfo publishInfo) throws Exception;
  public PaginatedList queryFeedbackList(PublishInfo publishInfo,int pageSize) throws Exception;
  //回复用户反馈
  public int updatePublishInfoForFeedback(PublishInfo publishInfo) throws Exception;
  //删除记录
  public int deletePublishInfo(String info_id) throws Exception;
  //根据INFO_ID取得附件列表
  public List getPublishInfoAccessoryListByInfoId(String info_id) throws Exception;

}