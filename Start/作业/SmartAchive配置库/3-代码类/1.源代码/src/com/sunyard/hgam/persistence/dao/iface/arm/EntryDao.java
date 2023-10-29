package com.sunyard.hgam.persistence.dao.iface.arm;

import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.beans.arm.Entry;
import java.util.List;
/**
 * <p>Title: ��Ŀ����</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author Ҷ�
 * @version 1.0
 */

public interface EntryDao {
  public List getFirstEntry();
  public List getSecondEntry(String entryId);
  public int addEntry(Entry entry);
  public Entry getEntry(String entryID);
  public int modifyEntry(Entry entry);
  public int delEntry(String entryId);
  public int delEntryForFirstLvl(String entryId);
  public int updateEntryIsCharge(Entry e) throws Exception ;
  public List queryAllSecondEntry() throws Exception ;
  public List queryChargeStandardSEntry(String sentryid) throws Exception ;
  public List querySecondEntryForEformDefine();

}