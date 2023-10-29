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

public interface GroupPermissionDao
{
  public List getPermissionBygroupID(String groupID);
  public int insertGP(GroupPermission gp);
  public int deleteOneGP(GroupPermission gp);
  public int deleteAllGP(GroupPermission gp);
}