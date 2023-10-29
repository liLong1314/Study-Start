package com.sunyard.hgam.persistence.dao.iface.aum;

import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.beans.aum.UtilizeDetail;
import java.util.List;
import java.util.Map;
import java.util.Date;
import com.sunyard.hgam.persistence.dao.beans.aum.UrgeInfoForOA;
import java.util.HashMap;

/**
 * <p>Title: HGAM</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author not attributable
 * @version 1.0
 */

public interface UtilizeDetailDao {
  public PaginatedList queryFileIDByApplyID(String apply_id) throws Exception;
  public PaginatedList queryUtilizeDetailByApplyID(Map applyIDMap) throws Exception;
  public int deleteByApplyID(String apply_id) throws Exception;
  public int deleteByPageID(String page_id) throws Exception;
  public int deleteByFileID(String file_id) throws Exception;
  public int insert(UtilizeDetail  ud) throws Exception;
  public List queryPageChargeByFileID(String file_id) throws Exception;
  public UtilizeDetail getUtilizeDetailByPageID(String pageID) throws Exception;
  public long getTotalChargeByApplyID(String applyID) throws Exception;
  public List queryOverdueArchByApplyID(String applyID) throws Exception;
  public List queryUtilizeDetailByCondition(Map conditionMap) throws Exception;
  public int insertUrgeInfoForOA(UrgeInfoForOA urgeInfoForOA) throws Exception;
  public int updateUrgeStatusForOA(Map hm) throws Exception;
  }