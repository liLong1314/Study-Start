package com.sunyard.hgam.persistence.dao.iface.adc;

import java.util.List;

/**
 * <p>Title: HGAM</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author ֣��ȫ
 * @version 1.0
 */

public interface EntryTreeListDao {
  public List getAllFirstLevelTree();
  public List getFirstLevelTreeForRoll();
  public List getFirstLevelTreeForPiece();
  public List getSecondLevelTreeByFatherId(Integer entryId);
  public List getSecondLevelTreeByFatherIdForPiece(Integer entryId);
}