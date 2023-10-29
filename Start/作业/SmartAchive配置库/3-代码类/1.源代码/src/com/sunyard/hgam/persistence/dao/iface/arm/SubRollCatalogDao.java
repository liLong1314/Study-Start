package com.sunyard.hgam.persistence.dao.iface.arm;

import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.beans.arm.SubRollCatalog;

/**
 * <p>Title: �־�Ŀ¼����</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author ������
 * @version 1.0
 */

public interface SubRollCatalogDao {
 public PaginatedList getAllSubRollCatalog();
 public PaginatedList getAllSubRollCatalog(int pageSize);
 public  SubRollCatalog  getSubRollCatalog(SubRollCatalog rollCataId);
 public int addSubRollCatalog(SubRollCatalog subRollCatalog);
  public PaginatedList querySubRollCatalogList(SubRollCatalog subRollCatalog);
  public PaginatedList querySubRollCatalogList(SubRollCatalog subRollCatalog,int pageSize);
}