package com.sunyard.hgam.persistence.dao.sqlmapdao.adc;

import com.sunyard.hgam.persistence.dao.base.BaseSqlMapDao;
import java.util.List;
import com.sunyard.hgam.persistence.dao.iface.adc.ArchivesDao;
import com.ibatis.db.dao.DaoException;
import com.sunyard.hgam.persistence.dao.beans.adc.Archives;
import com.ibatis.common.util.PaginatedList;

public class ArchivesSqlMapDao extends BaseSqlMapDao implements ArchivesDao {
  /*下面三个全部以addArchives替代
  //新增文书类案卷
  public int addWenshuRollArchives(Archives archives){
    int iResult = 0;
    try {
      //执行插入操作
      this.startTransation();
      iResult = this.executeUpdate("addWenshuRollArchives", archives);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return iResult;
  }

  //新增业务类案卷
  public int addYewuRollArchives(Archives archives){
    int iResult = 0;
    try {
      //执行插入操作
      this.startTransation();
      iResult = this.executeUpdate("addYewuRollArchives", archives);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return iResult;
  }

  public int addPieceArchives(Archives archives){
    int iResult = 0;
    try {
      //执行插入操作
      this.startTransation();
      iResult = this.executeUpdate("addPieceArchives", archives);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return iResult;
  }*/

  //新增档案（卷、件）
  public int addArchives(Archives archives){
    int iResult = 0;
    try {
      //执行插入操作
      this.startTransation();
      iResult = this.executeUpdate("addArchives", archives);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return iResult;
  }


  //取得最大的档案ID
  public Integer getMaxArchivesId() {
    Integer maxId = null;
    try {
      this.startTransation();
      maxId = (Integer)this.executeQueryForObject("getMaxArchivesId", null);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return maxId;
  }

  //取得最大的案卷号
  public Integer getMaxRollNum() {
    Integer maxId = null;
    try {
      this.startTransation();
      maxId = (Integer)this.executeQueryForObject("getMaxRollNum", null);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return maxId;
  }

  //取得最大的件号（室编件号）
  public Integer getMaxPieceNum(){
    Integer maxId = null;
    try {
      this.startTransation();
      maxId = (Integer)this.executeQueryForObject("getMaxPieceNum", null);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return maxId;

  }

  //取得档号是否存在的判断
  public Boolean getIsExistArchivesNum(String archivesNum) {
    boolean blnResult = false;
    int rowCount = 0;
    try {
      this.startTransation();
      rowCount = ((Integer)this.executeQueryForObject("getIsExistArchivesNum", archivesNum)).intValue();
      if (rowCount>0){
        blnResult = true;
      }
      this.commitTransation();
    }
    catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return Boolean.valueOf(blnResult);
  }

  //取得案卷号是否存在的判断
  public Boolean getIsExistRollNum(String rollNum) {
    boolean blnResult = false;
    int rowCount = 0;
    try {
      this.startTransation();
      rowCount = ((Integer)this.executeQueryForObject("getIsExistRollNum", rollNum)).intValue();
      if (rowCount>0){
        blnResult = true;
      }
      this.commitTransation();
    }
    catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return Boolean.valueOf(blnResult);
  }

  //取得案卷号是否存在的判断
  public Boolean getIsExistPieceNum(String pieceNum) {
    boolean blnResult = false;
    int rowCount = 0;
    try {
      this.startTransation();
      rowCount = ((Integer)this.executeQueryForObject("getIsExistPieceNum", pieceNum)).intValue();
      if (rowCount>0){
        blnResult = true;
      }
      this.commitTransation();
    }
    catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return Boolean.valueOf(blnResult);
  }

  //查询档案列表(默认)
  public PaginatedList queryArchivesList(Archives archives){
    return queryArchivesList(archives,this.PAGE_SIZE);
  }
  //查询档案列表(定制每页记录数)
  public PaginatedList queryArchivesList(Archives archives,int pageSize){
    PaginatedList list = null;
    try {
      this.startTransation();
      list = this.executeQueryForPaginatedList("queryArchivesList", archives, pageSize);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return list;
  }

  //查询档案列表(默认)
  public PaginatedList queryArchivesListCheck(Archives archives){
    return queryArchivesListCheck(archives,this.PAGE_SIZE);
  }
  //查询档案列表(定制每页记录数)
  public PaginatedList queryArchivesListCheck(Archives archives,int pageSize){
    PaginatedList list = null;
    try {
      this.startTransation();
      list = this.executeQueryForPaginatedList("queryArchivesListCheck", archives, pageSize);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return list;
  }

  //根据档案ID，返回档案信息
  public Archives getArchivesByArchivesID(int archives_id){
    Archives aRet = null;
    try {
      this.startTransation();
      aRet = (Archives)this.executeQueryForObject("getArchivesByArchivesID",
                                                  new Integer(archives_id));
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return aRet;
  }

  //根据档案ID更新档案“状态” archives_status
  public int updateArchivesStatusByArchivesID(Archives archives) throws Exception{
    int nRet = 0;
    try {
      this.startTransation();
      nRet = this.executeUpdate("updateArchivesStatusByArchivesID",
                                                 archives);
      this.commitTransation();
    }
    catch (Exception ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      throw ex;
    }
    return nRet;
  }

  //修订档案信息
  public int updateArchives(Archives archives) throws Exception{
    int nRet = 0;
    try {
      this.startTransation();
      nRet = this.executeUpdate("updateArchives",archives);
      this.commitTransation();
    }
    catch (Exception ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      throw ex;
    }
    return nRet;
  }

  //根据档案ID，返回档案与备考表信息
  public Archives getArchivesByArchivesID_BK(int archives_id){
    Archives aRet = null;
    try {
      this.startTransation();
      aRet = (Archives)this.executeQueryForObject("getArchivesByArchivesID_BK",
                                                  new Integer(archives_id));
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return aRet;
  }


}
