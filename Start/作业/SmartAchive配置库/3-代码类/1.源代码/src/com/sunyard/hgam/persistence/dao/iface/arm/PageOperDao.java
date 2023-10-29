package com.sunyard.hgam.persistence.dao.iface.arm;

import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.beans.arm.PageOper;

/**
 * <p>Title: ������Ϣ����-ҳ�沿��</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author Ҷ�
 * @version 1.0
 */

public interface PageOperDao {
  public PaginatedList getPages(String fileId);
  public PaginatedList getPages(String fileId,int pageSize);
  public PaginatedList queryPages(PageOper pageOper);
  public PaginatedList queryPages(PageOper pageOper,int pageSize);
  public PageOper getPage(String pageID);
}