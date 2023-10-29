package com.sunyard.hgam.persistence.dao.sqlmapdao.smm;

import com.sunyard.hgam.persistence.dao.base.BaseSqlMapDao;
import com.ibatis.common.util.PaginatedList;
import com.ibatis.db.dao.*;
import com.sunyard.hgam.persistence.dao.beans.smm.*;
import java.util.*;
import com.sunyard.hgam.persistence.dao.iface.smm.*;

/**
 * <p>Title: Hang Zhou Net Archives</p>
 * <p>Description: 杭州市网上档案馆建设（一期）</p>
 * <p>Copyright: Hangzhou Sunyard System Engineering， Ltd. All rights reserved @2003</p>
 * <p>Company: sunhoo.com</p>
 * @author not attributable
 * @version 1.00
 */

public class OrganizationSqlMapDao
    extends BaseSqlMapDao
    implements OrgDao {

  public PaginatedList getAllOrg() {
    return getAllOrg(this.PAGE_SIZE);
  }

  public PaginatedList getAllOrg(int pageSize) {
    PaginatedList list = null;
    try {
      this.startTransation();

      list = this.executeQueryForPaginatedList("getAllOrg", null, pageSize);

      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) {
        /* ignore */}
      ex.printStackTrace();
    }
    return list;
  }

  public PaginatedList searchOrg(Organization org) {
    return searchOrg(org, this.PAGE_SIZE);
  }

  public PaginatedList searchOrg(Organization org, int pageSize) {
    PaginatedList list = null;
    try {
      this.startTransation();

      list = this.executeQueryForPaginatedList("searchOrg", org, pageSize);

      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) {
        /* ignore */}
      ex.printStackTrace();
    }
    return list;
  }

  public Organization getOrgByID(String orgID) {
    Organization org = null;
    try {
      this.startTransation();

      org = (Organization) this.executeQueryForObject("getOrgByID", orgID);

      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) {
        /* ignore */}
      ex.printStackTrace();
    }
    return org;
  }

  public String getOrgIDByName(String orgName) {
    String orgId = null;
    try {
      this.startTransation();

      orgId = (String) this.executeQueryForObject("getOrgByName", orgName);

      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) {
        /* ignore */}
      ex.printStackTrace();
    }
    return orgId;
  }

  public String getOrgNameByID(String orgId) {
    String orgName = null;
    try {
      this.startTransation();

      orgName = (String) this.executeQueryForObject("getOrgNameByID", orgId);

      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) {
        /* ignore */}
      ex.printStackTrace();
    }
    return orgName;
  }

  public PaginatedList getSubOrg(String orgID) {
    return getSubOrg(orgID,this.PAGE_SIZE);
  }

  public PaginatedList getSubOrg(String orgID, int pageSize) {
    PaginatedList list = null;
    try {
      this.startTransation();

      list = this.executeQueryForPaginatedList("getSubOrg", orgID, pageSize);

      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) {
        /* ignore */}
      ex.printStackTrace();
    }
    return list;
  }

  public int insertOrganization(Organization org) {
    int result = 0;
    try {
      this.startTransation();

      result = this.executeUpdate("insertOrganization", org);
      org.setId((String) executeQueryForObject("getOrgByName", org.getName()));
      result += this.executeUpdate("insertOrgOrg", org);

      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) {
        /* ignore */}
      ex.printStackTrace();
    }

    return result;
  }

  public int updateOrganization(Organization org) {
    int result = 0;
    try {
      this.startTransation();

      result = this.executeUpdate("updateOrganization", org);
      result += this.executeUpdate("updateOrgOrg", org);

      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) {
        /* ignore */}
      ex.printStackTrace();
    }

    return result;
  }

  public int deleteOrganization(String orgId) {
    int result = 0;
    try {
      this.startTransation();

      result = this.executeUpdate("deleteOrganization", orgId);

      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) {
        /* ignore */}
      ex.printStackTrace();
    }

    return result;
  }
}