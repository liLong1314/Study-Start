package com.sunyard.hgam.persistence.dao.iface.arm;

import com.sunyard.hgam.persistence.dao.beans.arm.WatchExamineDenote;

/**
 * <p>Title: �ֹܾ���ָʾ</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author ������
 * @version 1.0
 */

public interface WatchExamineDenoteDao {
  public  WatchExamineDenote  getWatchExamineDenote(String watchId);
  public int addWatchExamineDenote(WatchExamineDenote watchExamineDenote);
}