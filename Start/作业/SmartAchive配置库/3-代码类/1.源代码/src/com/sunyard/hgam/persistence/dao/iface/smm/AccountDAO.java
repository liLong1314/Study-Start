package com.sunyard.hgam.persistence.dao.iface.smm;

import java.util.List;
import com.sunyard.hgam.persistence.dao.beans.smm.*;
import com.ibatis.common.util.*;
import com.ibatis.db.dao.*;
/**
 * <p>Title: Hang Zhou Net Archives</p>
 * <p>Description: 杭州市网上档案馆建设（一期）</p>
 * <p>Copyright: Hangzhou Sunyard System Engineering， Ltd. All rights reserved @2003</p>
 * <p>Company: </p>
 * @author xcf
 * @version 1.00
 */

public interface AccountDAO {
  public List getAccounts();
  public PaginatedList getAllAccount(Account account);
  public Account getAccountByUserID(String userID) ;
  public Account getAccountByUsernameAndPassword(String userName,String password);
  public String getAccountByUsername(String userName);
  public int insertAccount(Account account);
  public int updateAccountLMD(Account account);
  public int updateAccountPassword(Account account);
  public int updateLoginInfo(Account account);
  public int deleteAccount(String account);
  public List getUserFuncPerm(String userID, String groupID);
  public List getUserDataPerm(String userID, String groupID);
  public List getUserGroups(String userID);
  //wanghua add 2004-02-20
  public String getPasswordByUsername(String userName);
}