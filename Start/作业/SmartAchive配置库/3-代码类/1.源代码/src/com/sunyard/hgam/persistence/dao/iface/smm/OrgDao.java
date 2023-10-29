package com.sunyard.hgam.persistence.dao.iface.smm;

import com.ibatis.common.util.PaginatedList;
import com.ibatis.db.dao.*;
import com.sunyard.hgam.persistence.dao.beans.smm.*;
import java.util.*;

/**
 * <p>Title: Hang Zhou Net Archives</p>
 * <p>Description: 杭州市网上档案馆建设（一期）</p>
 * <p>Copyright: Hangzhou Sunyard System Engineering， Ltd. All rights reserved @2003</p>
 * <p>Company: sunhoo.com</p>
 * @author not attributable
 * @version 1.00
 */

public interface OrgDao {

  public PaginatedList getAllOrg();

  public PaginatedList searchOrg(Organization org);

  public Organization getOrgByID(String orgID);

  public String getOrgIDByName(String orgName);

  public String getOrgNameByID(String orgId);

  public PaginatedList getSubOrg(String orgID);

  public int insertOrganization(Organization org);

  public int updateOrganization(Organization org);

  public int deleteOrganization(String orgId);

}