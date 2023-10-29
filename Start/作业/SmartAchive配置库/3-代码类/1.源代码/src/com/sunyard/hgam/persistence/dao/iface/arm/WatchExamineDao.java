package com.sunyard.hgam.persistence.dao.iface.arm;

import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.beans.arm.WatchExamine;

/**
 * <p>Title: 杂项目录册管理</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 华良东
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