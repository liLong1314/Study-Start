package com.sunyard.hgam.persistence.dao.sqlmapdao.arm;

import com.sunyard.hgam.persistence.dao.base.BaseSqlMapDao;
import com.sunyard.hgam.persistence.dao.iface.arm.TemperatureDao;
import com.ibatis.common.util.PaginatedList;
import com.ibatis.db.dao.DaoException;
import com.sunyard.hgam.persistence.dao.beans.arm.Temperature;

/**
 * <p>Title: ��ʪ�ȹ���</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author ��ʪ�ȹ���
 * @version 1.0
 */

public class TemperatureSqlMapDao
    extends BaseSqlMapDao
    implements TemperatureDao{

  //�õ�������ʪ�ȼ�¼
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

  //��ѯ��ʪ�ȼ�¼
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

  //����ID�õ�һ����ʪ�ȼ�¼
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

  //������ʪ��
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

  //�޸���ʪ��
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

  //ɾ����ʪ��
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