package com.sunyard.hgam.persistence.dao.iface.arm;

import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.beans.arm.Destroy;

/**
 * <p>Title: ���ٹ���</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author Ҷ�
 * @version 1.0
 */

public interface DestroyDao {
  public PaginatedList getAllDestroy();
  public PaginatedList getAllDestroy(int pageSize);
  public int addDestory(Destroy destroy);
  public PaginatedList queryDestroyList(Destroy destroy);
  public PaginatedList queryDestroyList(Destroy destroy,int pageSize);
}