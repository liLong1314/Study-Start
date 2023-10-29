package com.sunyard.hgam.persistence.dao.iface.aum;

import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.beans.aum.ChargeStandard;
import java.util.List;
/**
 * <p>Title: HGAM</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author not attributable
 * @version 1.0
 */

public interface ChargeStandardDao {
  /** 得到最大ID号 */
  public int getMaxId() throws Exception;

  /** 增加 */
  public int insert(ChargeStandard cs) throws Exception;

  /** 修改 */
  public int updateByChargeID(ChargeStandard cs) throws Exception;

  /** 删除 */
  public int deleteByChargeID(String charge_id) throws Exception;

  /** 查询所有的收费标准 */
  public List queryChargeStandard() throws Exception;

  /** 根据charge_id查询的收费标准 */
  public ChargeStandard queryChargeStandardByChargeID(String charge_id) throws Exception;

}