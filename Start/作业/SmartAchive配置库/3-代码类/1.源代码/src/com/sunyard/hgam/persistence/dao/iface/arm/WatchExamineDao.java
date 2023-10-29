package com.sunyard.hgam.persistence.dao.iface.arm;

import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.beans.arm.WatchExamine;

/**
 * <p>Title: ����Ŀ¼�����</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author ������
 * @version 1.0
 */

public interface WatchExamineDao {
 public PaginatedList getAllWatchExamine();
 public PaginatedList getAllWatchExamine(int pageSize);
 public  WatchExamine  getWatchExamine(String watchId);
 public int addWatchExamine(WatchExamine watchExamine);
 public PaginatedList queryWatchExamineList(WatchExamine watchExamine,int pageSize);
 public PaginatedList queryWatchExamineList(WatchExamine watchExamine);


}