package com.sunyard.hgam.persistence.dao.sqlmapdao.arm;

import com.sunyard.hgam.persistence.dao.base.BaseSqlMapDao;
import com.sunyard.hgam.persistence.dao.iface.arm.PageOperDao;
import com.ibatis.common.util.PaginatedList;
import com.ibatis.db.dao.DaoException;
import com.sunyard.hgam.persistence.dao.beans.arm.PageOper;

/**
 * <p>Title: ������Ϣ����-ҳ�沿��</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author Ҷ�
 * @version 1.0
 */

public class PageOperSqlMapDao
    extends BaseSqlMapDao
    implements PageOperDao {
  //�����ļ�ID�õ�ҳ���б�
  public PaginatedList getPages(String fileId) {
    return getPages(fileId,this.PAGE_SIZE);
  }

  public PaginatedList getPages(String fileId,int pageSize) {
    PaginatedList list = null;
    try {
      this.startTransation();
      list = this.executeQueryForPaginatedList("getPages", fileId, pageSize);
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

  //��ѯҳ�棭����������ϵͳ
  public PaginatedList queryPages(PageOper pageOper) {
    return queryPages(pageOper,this.PAGE_SIZE);
  }

  public PaginatedList queryPages(PageOper pageOper,int pageSize) {
    PaginatedList list = null;
    try {
      this.startTransation();
      list = this.executeQueryForPaginatedList("queryPages", pageOper, pageSize);
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

  //����ID�õ�һ��Ӱ���¼
  public PageOper getPage(String pageID) {
    PageOper pageOperInfo = null;
    try {
      this.startTransation();
      pageOperInfo = (PageOper)this.executeQueryForObject("getPageByID", pageID);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    return pageOperInfo;
  }

}