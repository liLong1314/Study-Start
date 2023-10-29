package com.sunyard.hgam.persistence.dao.iface.arm;

import com.sunyard.hgam.persistence.dao.beans.arm.WatchExamineDenote;

/**
 * <p>Title: 总局工作指示</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 华良东
 * @version 1.0
 */

public interface WatchExamineDenoteDao {
  public  WatchExamineDenote  getWatchExamineDenote(String watchId);
  public int addWatchExamineDenote(WatchExamineDenote watchExamineDenote);
}