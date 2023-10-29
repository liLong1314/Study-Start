package com.sunyard.hgam.persistence.dao.iface.smm;

import com.ibatis.common.util.PaginatedList;
import com.ibatis.db.dao.*;
import com.sunyard.hgam.persistence.dao.beans.smm.*;
import java.util.*;

/**
 * <p>Title: Hang Zhou Net Archives</p>
 * <p>Description: ���������ϵ����ݽ��裨һ�ڣ�</p>
 * <p>Copyright: Hangzhou Sunyard System Engineering�� Ltd. All rights reserved @2003</p>
 * <p>Company: sunhoo.com</p>
 * @author not attributable
 * @version 1.00
 */

public interface LogDao {

  /**
   * ��ҳ����������־��Ĭ��ҳ��С
   * @return ��־�б�
   */
  public PaginatedList getAllLog();

  /**
   * ������־ID��ȡ��־��Ϣ
   * @param logID ��־ID
   * @return ��־��ϢBean
   */
  public Log getLogByID(String logID);

  public int insertLog(Log log);

  public int deleteLog(String logId);

  public List getAllOperationUrl();

  public int updateOperationUrl(OperationUrl operationUrl);

}