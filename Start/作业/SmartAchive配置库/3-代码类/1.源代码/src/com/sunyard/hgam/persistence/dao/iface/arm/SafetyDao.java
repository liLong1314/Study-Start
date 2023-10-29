package com.sunyard.hgam.persistence.dao.iface.arm;

import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.beans.arm.Safety;

/**
 * <p>Title: ��ȫ����</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author ��ȫ����
 * @version 1.0
 */

public interface SafetyDao {
  public PaginatedList getAllSafety();
  public PaginatedList getAllSafety(int pageSize);
  public PaginatedList searchSafety(Safety safety);
  public PaginatedList searchSafety(Safety safety,int pageSize);
  public Safety getSafety(String safetyID);
  public int addSafety(Safety safety);
  public int modifySafety(Safety safety);
  public int delSafety(String safetyId);
}