package com.sunyard.hgam.persistence.dao.sqlmapdao.arm;

import com.sunyard.hgam.persistence.dao.base.BaseSqlMapDao;
import com.sunyard.hgam.persistence.dao.iface.arm.IdentifyDao;
import com.sunyard.hgam.persistence.dao.beans.arm.Identify;
import com.ibatis.db.dao.DaoException;
import com.ibatis.common.util.PaginatedList;

/**
 * <p>Title: ��������</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author Ҷ�
 * @version 1.0
 */

public class IdentifySqlMapDao
    extends BaseSqlMapDao
    implements IdentifyDao {
  //�õ����е���������¼
  public PaginatedList getAllIdentify() {
    return getAllIdentify(this.PAGE_SIZE);
  }

  public PaginatedList getAllIdentify(int pageSize) {
    PaginatedList list = null;
    try {
      this.startTransation();
      list = this.executeQueryForPaginatedList("getAllIdentify", null, pageSize);
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

  //���Ӽ�����¼
  public int addIdentify(Identify identify) {
    int result = 0;
    try {
      this.startTransation();
      result = this.executeUpdate("addIdentify", identify);
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
public PaginatedList queryIdentifyList(Identify identify){
return queryIdentifyList(identify,this.PAGE_SIZE);
}

//��ѯ�����б�(����ÿҳ��¼��)

public PaginatedList queryIdentifyList(Identify identify,int pageSize){
PaginatedList list = null;
try {
this.startTransation();
list = this.executeQueryForPaginatedList("queryIdentifyList", identify, pageSize);
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