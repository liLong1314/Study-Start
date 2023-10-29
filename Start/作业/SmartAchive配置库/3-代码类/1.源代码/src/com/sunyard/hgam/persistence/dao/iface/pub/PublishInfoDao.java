package com.sunyard.hgam.persistence.dao.iface.pub;

import com.sunyard.hgam.persistence.dao.beans.pub.PublishInfo;
import com.ibatis.db.dao.DaoException;
import java.util.List;
import com.ibatis.common.util.PaginatedList;

public interface PublishInfoDao {
  //����������Ϣ
  public int addPublishInfo(PublishInfo publishInfo) throws DaoException;
  //����������Ϣ(��������)
  public int addPublishInfo(PublishInfo publishInfo,List publishInfoAccessoryList) throws DaoException;
  //ȡ������INFO_ID
  public int getMaxInfoId() throws Exception;
  //��������г�ǰN����¼
  public List queryPublishInfoListByType(String strType) throws Exception;
  public List queryPublishInfoListByType(String strType,int pageSize) throws Exception;
  //����IDȡ��������Ϣ
  public PublishInfo getPublishInfoById(String info_id) throws Exception;
  //���·�����Ϣ
  public int updatePublishInfo(PublishInfo publishInfo) throws Exception;
  //��ѯ������Ϣ
  public PaginatedList queryPublishInfoList(PublishInfo publishInfo) throws Exception;
  public PaginatedList queryPublishInfoList(PublishInfo publishInfo,int pageSize) throws Exception;
  //��˷�����Ϣ
  public int updatePublishInfoForConfirm(PublishInfo publishInfo) throws Exception;
  //��ѯ������Ϣ
  public PaginatedList queryFeedbackList(PublishInfo publishInfo) throws Exception;
  public PaginatedList queryFeedbackList(PublishInfo publishInfo,int pageSize) throws Exception;
  //�ظ��û�����
  public int updatePublishInfoForFeedback(PublishInfo publishInfo) throws Exception;
  //ɾ����¼
  public int deletePublishInfo(String info_id) throws Exception;
  //����INFO_IDȡ�ø����б�
  public List getPublishInfoAccessoryListByInfoId(String info_id) throws Exception;

}