package com.sunyard.hgam.persistence.dao.iface.smm;

import java.util.*;
import com.sunyard.hgam.persistence.dao.beans.smm.*;

/**
 * <p>Title: Hang Zhou Net Archives</p>
 * <p>Description: ���������ϵ����ݽ��裨һ�ڣ�</p>
 * <p>Copyright: Hangzhou Sunyard System Engineering�� Ltd. All rights reserved @2003</p>
 * <p>Company: </p>
 * @author xcf
 * @version 1.00
 */

public interface AccountPermissionDao
{
  public List getPermissionByUserID(String userID);
  public int insertAP(AccountPermission ap);
  public int deleteOneAP(AccountPermission ap);
  public int deleteAllAP(AccountPermission ap);
}