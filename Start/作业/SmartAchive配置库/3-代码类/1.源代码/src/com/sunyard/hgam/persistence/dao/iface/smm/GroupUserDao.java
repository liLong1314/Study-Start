package com.sunyard.hgam.persistence.dao.iface.smm;

import java.util.List;
import com.sunyard.hgam.persistence.dao.beans.smm.*;
import com.ibatis.common.util.*;
/**
 * <p>Title: Hang Zhou Net Archives</p>
 * <p>Description: 杭州市网上档案馆建设（一期）</p>
 * <p>Copyright: Hangzhou Sunyard System Engineering， Ltd. All rights reserved @2003</p>
 * <p>Company: </p>
 * @author xcf
 * @version 1.00
 */

public interface GroupUserDao
{
  public List getUserIDBygroupID(GroupUser gu);
  public List getGroupIDByUserID(GroupUser gu);
  public String getOrgIDByUserID(String userID);
  public int insertGU(GroupUser gu);
   public int updateUserOrgID(GroupUser gu);
  public int deleteOneGU(GroupUser gu);
  public int deleteAllGU(GroupUser gu);
  public int deleteAllUG(GroupUser gu);
}