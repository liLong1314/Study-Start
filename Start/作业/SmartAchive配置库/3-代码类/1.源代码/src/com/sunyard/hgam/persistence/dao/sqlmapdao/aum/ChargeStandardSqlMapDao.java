package com.sunyard.hgam.persistence.dao.sqlmapdao.aum;

import com.sunyard.hgam.persistence.dao.beans.aum.ChargeStandard;
import com.sunyard.hgam.persistence.dao.base.BaseSqlMapDao;
import com.sunyard.hgam.persistence.dao.iface.aum.ChargeStandardDao;
import java.util.List;

/**
 * <p>Title: HGAM</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author not attributable
 * @version 1.0
 */

public class ChargeStandardSqlMapDao extends BaseSqlMapDao implements ChargeStandardDao{
  public ChargeStandardSqlMapDao() {
  }

  /**
   * 得到最大的ID号
   * @return
   * @throws java.lang.Exception
   */
  public int getMaxId() throws Exception{
    Integer Ret = new Integer(0);
    try{
      this.startTransation();
      Ret = (Integer)this.executeQueryForObject("getMaxId", null);
      this.commitTransation();
    }catch(Exception ex){
      try {this.rollbackTransation();} catch (Exception ex2) { /* ignore */}
      throw ex;
    }
    if (Ret == null)
      Ret = new Integer(0);
    return Ret.intValue() ;
  }

  /**
   * 增加
   * @return
   * @throws java.lang.Exception
   */
  public int insert(ChargeStandard cs) throws Exception{
    int Ret = 0;
    try{
      this.startTransation();
      Ret = this.executeUpdate("insert", cs);
      this.commitTransation();
    }catch(Exception ex){
      try {this.rollbackTransation();} catch (Exception ex2) { /* ignore */}
      throw ex;
    }
    return Ret;
  }

  /**
   * 修改
   * @return
   * @throws java.lang.Exception
   */
  public int updateByChargeID(ChargeStandard cs) throws Exception{
    int Ret = 0;
    try{
      this.startTransation();
      Ret = this.executeUpdate("updateByChargeID", cs);
      this.commitTransation();
    }catch(Exception ex){
      try {this.rollbackTransation();} catch (Exception ex2) { /* ignore */}
      throw ex;
    }
    return Ret;
  }

  /**
   * 删除
   * @return
   * @throws java.lang.Exception
   */
  public int deleteByChargeID(String charge_id) throws Exception{
    int Ret = 0;
    try{
      this.startTransation();
      Ret = this.executeUpdate("deleteByChargeID", charge_id);
      this.commitTransation();
    }catch(Exception ex){
      try {this.rollbackTransation();} catch (Exception ex2) { /* ignore */}
      throw ex;
    }
    return Ret;
  }

  /**
   * 查询所有的收费标准
   * @return
   * @throws java.lang.Exception
   */
  public List queryChargeStandard() throws Exception{
    List lstRet = null;
    try{
      this.startTransation();
      lstRet = this.executeQueryForList("queryChargeStandard", null);
      this.commitTransation();
    }catch(Exception ex){
      try {this.rollbackTransation();} catch (Exception ex2) { /* ignore */}
      throw ex;
    }
    return lstRet;
  }

  /**
   * 根据charge_id查询的收费标准
   * @param charge_id
   * @return
   * @throws ChargeStandard
   */
  public ChargeStandard queryChargeStandardByChargeID(String charge_id) throws Exception{
    ChargeStandard Ret = null;
    try{
      this.startTransation();
      Ret = (ChargeStandard)this.executeQueryForObject("queryChargeStandardByChargeID", charge_id);
      this.commitTransation();
    }catch(Exception ex){
      try {this.rollbackTransation();} catch (Exception ex2) { /* ignore */}
      throw ex;
    }
    return Ret;
  }

}