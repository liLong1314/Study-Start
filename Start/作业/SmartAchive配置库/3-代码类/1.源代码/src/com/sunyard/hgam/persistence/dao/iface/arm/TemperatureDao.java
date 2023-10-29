package com.sunyard.hgam.persistence.dao.iface.arm;

import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.beans.arm.Temperature;

/**
 * <p>Title: 温湿度管理</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 温湿度管理
 * @version 1.0
 */

public interface TemperatureDao {
  public PaginatedList getAllTemperature();
  public PaginatedList getAllTemperature(int pageSize);
  public PaginatedList searchTemperature(Temperature temperature);
  public PaginatedList searchTemperature(Temperature temperature,int pageSize);
  public int addTemperature(Temperature temperature);
  public Temperature getTemperature(String temperatureID);
  public int modifyTemperature(Temperature temperature);
  public int delTemperature(String temperatureId);
}