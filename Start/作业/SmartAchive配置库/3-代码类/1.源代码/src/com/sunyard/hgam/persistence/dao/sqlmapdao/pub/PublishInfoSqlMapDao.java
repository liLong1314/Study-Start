package com.sunyard.hgam.persistence.dao.sqlmapdao.pub;

import com.sunyard.hgam.persistence.dao.base.BaseSqlMapDao;
import com.sunyard.hgam.persistence.dao.iface.pub.PublishInfoDao;
import com.sunyard.hgam.persistence.dao.beans.pub.PublishInfo;
import com.ibatis.db.dao.DaoException;
import java.util.List;
import com.ibatis.common.util.PaginatedList;

public class PublishInfoSqlMapDao
    extends BaseSqlMapDao
    implements PublishInfoDao {
  //新增发布信息
  public int addPublishInfo(PublishInfo publishInfo) throws DaoException {
    int iResult = 0;
    try {
      this.startTransation();
      iResult = this.executeUpdate("addPublishInfo", publishInfo);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      throw ex;
    }
    return iResult;
  }
  //新增发布信息(有附件)
  public int addPublishInfo(PublishInfo publishInfo,List publishInfoAccessoryList) throws DaoException {
    int iResult = 0;
    try {
      this.startTransation();
      iResult = this.executeUpdate("addPublishInfo", publishInfo);
      for(int i=0;i<publishInfoAccessoryList.size();i++){
        this.executeUpdate("addPublishInfoAccessory", publishInfoAccessoryList.get(i));
      }
      this.commitTransation();
    }
    catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      throw ex;
    }
    return iResult;
  }


  //取得最大的INFO_ID
  public int getMaxInfoId() throws Exception {
    Integer nRet;
    try{
      this.startTransation();
      nRet = (Integer)this.executeQueryForObject("getMaxInfoId", null);
      this.commitTransation();
    }catch(Exception e){
      try { this.rollbackTransation(); } catch (Exception ex2) { /* ignore */ }
      throw e;
    }
    if (nRet==null)
      nRet = new Integer(0);
    return nRet.intValue() ;
  }

  //根据类别列出前N个记录
  public List queryPublishInfoListByType(String strType) throws Exception{
    return queryPublishInfoListByType(strType,this.PAGE_SIZE) ;
  }
  public List queryPublishInfoListByType(String strType,int pageSize) throws Exception{
    List lstRet = null;
    try{
      this.startTransation();
      lstRet = this.executeQueryForPaginatedList("queryPublishInfoListByType",
                                               strType, pageSize);
      this.commitTransation();
    }catch(Exception e){ /* ignore  Exception*/
      try { this.rollbackTransation(); } catch (Exception ex2) { /* ignore */ }
      throw e;
    }
    return lstRet ;
  }

  //根据ID取出发布信息
  public PublishInfo getPublishInfoById(String info_id) throws Exception{
    PublishInfo lstRet = null;
    try{
      this.startTransation();
      lstRet = (PublishInfo) this.executeQueryForObject("getPublishInfoById",info_id);
      this.commitTransation();
    }catch(Exception e){ /* ignore  Exception*/
      try { this.rollbackTransation(); } catch (Exception ex2) { /* ignore */ }
      throw e;
    }
    return lstRet ;
  }
  //更新发布信息
  public int updatePublishInfo(PublishInfo publishInfo) throws Exception{
    int iResult = 0;
    try {
      this.startTransation();
      iResult = this.executeUpdate("updatePublishInfo", publishInfo);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      throw ex;
    }
    return iResult;
  }

  //查询发布信息
  public PaginatedList queryPublishInfoList(PublishInfo publishInfo) throws Exception{
    return queryPublishInfoList(publishInfo,this.PAGE_SIZE);
  }
  public PaginatedList queryPublishInfoList(PublishInfo publishInfo,int pageSize) throws Exception{
    PaginatedList iResult = null;
    try {
      this.startTransation();
      iResult = this.executeQueryForPaginatedList("queryPublishInfoList", publishInfo,pageSize);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      throw ex;
    }
    return iResult;
  }

  //审核发布信息
  public int updatePublishInfoForConfirm(PublishInfo publishInfo) throws Exception{
    int iResult = 0;
    try {
      this.startTransation();
      iResult = this.executeUpdate("updatePublishInfoForConfirm", publishInfo);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      throw ex;
    }
    return iResult;
  }

  //查询反馈信息
  public PaginatedList queryFeedbackList(PublishInfo publishInfo) throws Exception{
    return queryFeedbackList(publishInfo,this.PAGE_SIZE);
  }
  public PaginatedList queryFeedbackList(PublishInfo publishInfo,int pageSize) throws Exception{
    PaginatedList iResult = null;
    try {
      this.startTransation();
      iResult = this.executeQueryForPaginatedList("queryFeedbackList", publishInfo,pageSize);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      throw ex;
    }
    return iResult;
  }

  //回复用户反馈
  public int updatePublishInfoForFeedback(PublishInfo publishInfo) throws Exception{
    int iResult = 0;
    try {
      this.startTransation();
      iResult = this.executeUpdate("updatePublishInfoForFeedback", publishInfo);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      throw ex;
    }
    return iResult;
  }

  //删除记录
  public int deletePublishInfo(String info_id) throws Exception{
    int iResult = 0;
    try {
      this.startTransation();
      iResult = this.executeUpdate("deletePublishInfoAccessoryByInfoId", info_id);
      iResult = this.executeUpdate("deletePublishInfo", info_id);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      throw ex;
    }
    return iResult;
  }
  //根据INFO_ID取得附件列表
  public List getPublishInfoAccessoryListByInfoId(String info_id) throws Exception{
    List iResult = null;
    try {
      this.startTransation();
      iResult = this.executeQueryForList("getPublishInfoAccessoryListByInfoId", info_id);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      throw ex;
    }
    return iResult;
  }



}