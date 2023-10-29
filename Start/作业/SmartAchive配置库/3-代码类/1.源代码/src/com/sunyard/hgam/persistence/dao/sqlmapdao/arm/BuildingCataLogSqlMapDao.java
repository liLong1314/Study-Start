package com.sunyard.hgam.persistence.dao.sqlmapdao.arm;

import com.sunyard.hgam.persistence.dao.base.BaseSqlMapDao;
import com.ibatis.common.util.PaginatedList;
import com.ibatis.db.dao.DaoException;
import com.sunyard.hgam.persistence.dao.beans.arm.BuildingCataLog;
import com.sunyard.hgam.persistence.dao.iface.arm.BuildingCataLogDao;

/**
 * <p>Title:建筑项目目录册管理</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 华良东
 * @version 1.0
 */

public class BuildingCataLogSqlMapDao
    extends BaseSqlMapDao
    implements BuildingCataLogDao {
  public PaginatedList getAllBuildingCataLog() {
    return getAllBuildingCataLog(this.PAGE_SIZE);
  }

  public PaginatedList getAllBuildingCataLog(int pageSize) {
    PaginatedList list = null;
    try {
      this.startTransation();
      list = this.executeQueryForPaginatedList("getAllBuildingCataLog", null,
                                               pageSize);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    return list;
  }

  //根据ID得到一条建筑项目目录册记录
  public BuildingCataLog getBuildingCataLog(String cataId) {
    BuildingCataLog buildingCataLogInfo = null;
    try {
      this.startTransation();
      buildingCataLogInfo = (BuildingCataLog)this.executeQueryForObject(
          "getBuildingCataLogByID", cataId);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    return buildingCataLogInfo;
  }

  //增加一条建筑项目目录册记录
  public int addBuildingCataLog(BuildingCataLog buildingCataLog) {
    int result = 0;
    try {
      this.startTransation();
      result = this.executeUpdate("addBuildingCataLog", buildingCataLog);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore*/}
      ex.printStackTrace();
    }
    return result;
  }

  //查询建筑目录册列表(默认)
  public PaginatedList queryBuildingCataLogList(BuildingCataLog buildingCataLog) {
    return queryBuildingCataLogList(buildingCataLog, this.PAGE_SIZE);
  }

//查询建筑目录册列表(定制每页记录数)

  public PaginatedList queryBuildingCataLogList(BuildingCataLog buildingCataLog,
                                                int pageSize) {
    PaginatedList list = null;
    try {
      this.startTransation();
      list = this.executeQueryForPaginatedList("queryBuildingCataLogList",
                                               buildingCataLog, pageSize);
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


  public int updateBuildingCataLog(BuildingCataLog buildingCataLog){
    int result = 0;
    try {
      this.startTransation();
      result = this.executeUpdate("updateBuildingCataLog", buildingCataLog);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore*/}
      ex.printStackTrace();
    }
    return result;
  }


  public int deleteBuildingCataLog(String cataId){
    int result = 0;
    try {
      this.startTransation();
      result = this.executeUpdate("deleteBuildingCataLog", cataId);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore*/}
      ex.printStackTrace();
    }
    return result;
  }


}