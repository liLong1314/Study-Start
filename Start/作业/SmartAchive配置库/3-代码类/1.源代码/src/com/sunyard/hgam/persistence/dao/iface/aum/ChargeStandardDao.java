package com.sunyard.hgam.persistence.dao.iface.aum;

import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.beans.aum.ChargeStandard;
import java.util.List;
/**
 * <p>Title: HGAM</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author not attributable
 * @version 1.0
 */

public interface ChargeStandardDao {
  /** �õ����ID�� */
  public int getMaxId() throws Exception;

  /** ���� */
  public int insert(ChargeStandard cs) throws Exception;

  /** �޸� */
  public int updateByChargeID(ChargeStandard cs) throws Exception;

  /** ɾ�� */
  public int deleteByChargeID(String charge_id) throws Exception;

  /** ��ѯ���е��շѱ�׼ */
  public List queryChargeStandard() throws Exception;

  /** ����charge_id��ѯ���շѱ�׼ */
  public ChargeStandard queryChargeStandardByChargeID(String charge_id) throws Exception;

}