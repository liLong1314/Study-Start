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

public interface GroupDao
{
  public PaginatedList getGroups();
  public PaginatedList getGroups(int pageSize);
  public PaginatedList getGroups(Group group);
  public PaginatedList getGroups(Group group,int pageSize);
  public int insertGroup(Group group);
  public int updateGroup(Group group);
  public int updateGroupMD(Group group);
  public int deleteGroup(String groupID);
  public String getGroupByGroupName(String groupName);
  public Group getGroupByGroupID(String groupID);
}