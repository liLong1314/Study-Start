package com.sunyard.hgam.persistence.dao.sqlmapdao.arm;

import com.sunyard.hgam.persistence.dao.base.BaseSqlMapDao;
import com.sunyard.hgam.persistence.dao.iface.arm.DestroyDao;
import com.ibatis.common.util.PaginatedList;
import com.ibatis.db.dao.DaoException;
import com.sunyard.hgam.persistence.dao.beans.arm.Destroy;

/**
 * <p>Title: ���ٹ���</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author Ҷ�
 * @version 1.0
 */

public class DestroySqlMapDao
    extends BaseSqlMapDao
    implements DestroyDao {
  //�õ����е������ټ�¼
  public PaginatedList getAllDestroy() {
    return getAllDestroy(this.PAGE_SIZE);
  }

  public PaginatedList getAllDestroy(int pageSize) {
    PaginatedList list = null;
    try {
      this.startTransation();
      list = this.executeQueryForPaginatedList("getAllDestroy", null, pageSize);
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

  //�������ټ�¼
  public int addDestory(Destroy destroy) {
    int result = 0;
    try {
      this.startTransation();
      result = this.executeUpdate("addDestroy", destroy);
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
  //��ѯ�����б�(Ĭ��)
public PaginatedList queryDestroyList(Destroy destroy){
return queryDestroyList(destroy,this.PAGE_SIZE);
}

//��ѯ�����б�(����ÿҳ��¼��)

public PaginatedList queryDestroyList(Destroy destroy,int pageSize){
PaginatedList list = null;
try {
this.startTransation();
list = this.executeQueryForPaginatedList("queryDestroyList", destroy, pageSize);
this.commitTransation();
}
catch (DaoException ex) {
try {
  this.rollbackTransation();
}
catch (Exception ex2) {}
ex.printStackTrace();
}
return list;
}

}