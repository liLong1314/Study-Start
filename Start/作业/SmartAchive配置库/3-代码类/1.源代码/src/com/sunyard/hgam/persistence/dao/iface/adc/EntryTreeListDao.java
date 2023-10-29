package com.sunyard.hgam.persistence.dao.iface.adc;

import java.util.List;

/**
 * <p>Title: HGAM</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 郑先全
 * @version 1.0
 */

public interface EntryTreeListDao {
  public List getAllFirstLevelTree();
  public List getFirstLevelTreeForRoll();
  public List getFirstLevelTreeForPiece();
  public List getSecondLevelTreeByFatherId(Integer entryId);
  public List getSecondLevelTreeByFatherIdForPiece(Integer entryId);
}