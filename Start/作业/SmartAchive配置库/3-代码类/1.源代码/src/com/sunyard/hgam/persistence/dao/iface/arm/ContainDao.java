package com.sunyard.hgam.persistence.dao.iface.arm;

import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.beans.arm.Contain;

/**
 * <p>Title: ����װ�߹���</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author Ҷ�
 * @version 1.0
 */

public interface ContainDao {
  public PaginatedList getAllContain();
  public PaginatedList getAllContain(int pageSize);
  public PaginatedList searchContain(Contain contain);
  public PaginatedList searchContain(Contain contain,int pageSize);
  public Contain getContain(String containID);
  public int addContain(Contain contain);
  public int modifyContain(Contain contain);
  public int delContain(String containId);

}