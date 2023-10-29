package com.sunyard.hgam.persistence.dao.sqlmapdao.arm;

import com.sunyard.hgam.persistence.dao.base.BaseSqlMapDao;
import com.sunyard.hgam.persistence.dao.iface.arm.TemperatureDao;
import com.ibatis.common.util.PaginatedList;
import com.ibatis.db.dao.DaoException;
import com.sunyard.hgam.persistence.dao.beans.arm.Temperature;

/**
 * <p>Title: 温湿度管理</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 温湿度管理
 * @version 1.0
 */

public class TemperatureSqlMapDao
    extends BaseSqlMapDao
    implements TemperatureDao{

  //得到所有温湿度记录
  public PaginatedList getAllTemperature() {
    return getAllTemperature(this.PAGE_SIZE);
  }

  public PaginatedList getAllTemperature(int pageSize) {
    PaginatedList list = null;
    try {
      this.startTransation();
      list = this.executeQueryForPaginatedList("getAllTemperature", null, pageSize);
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

  //查询温湿度记录
  public PaginatedList searchTemperature(Temperature temperature) {
    return searchTemperature(temperature,this.PAGE_SIZE);
  }

  public PaginatedList searchTemperature(Temperature temperature,int pageSize) {
    PaginatedList list = null;
    try {
      this.startTransation();
      list = this.executeQueryForPaginatedList("searchTemperature", temperature, pageSize);
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

  //根据ID得到一条温湿度记录
  public Temperature getTemperature(String temperatureID) {
    Temperature temperatureInfo = null;
    try {
      this.startTransation();
      temperatureInfo = (Temperature)this.executeQueryForObject("getTemperatureByID", temperatureID);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    return temperatureInfo;
  }

  //增加温湿度
  public int addTemperature(Temperature temperature) {
    int result = 0;
    try {
      this.startTransation();
      result = this.executeUpdate("addTemperature", temperature);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    return result;
  }

  //修改温湿度
  public int modifyTemperature(Temperature temperature) {
    int result = 0;
    try {
      this.startTransation();
      result = this.executeUpdate("updateTemperature", temperature);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    return result;
  }

  //删除温湿度
  public int delTemperature(String temperatureId) {
    int result = 0;
    try {
      this.startTransation();
      result = this.executeUpdate("deleteTemperatureByID", temperatureId);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    return result;
  }

}