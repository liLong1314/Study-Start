package com.sunyard.hgam.persistence.dao.iface.arm;

import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.beans.arm.Whole;
import java.util.List;

/**
 * <p>Title: ȫ�ھ���Ϣ����</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author Ҷ�
 * @version 1.0
 */

public interface WholeDao {
  public List getWholeByType(String wholetype);
  public Whole getWhole(String wholeID);
  public int addWhole(Whole whole);
  public int modifyWhole(Whole whole);
  public int delWhole(String wholeId);

}