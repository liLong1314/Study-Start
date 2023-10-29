package com.sunyard.hgam.persistence.dao.iface.aum;

import com.ibatis.common.util.PaginatedList;

import java.util.*;
import com.sunyard.hgam.persistence.dao.beans.aum.UtilizeInfo;
import com.sunyard.hgam.persistence.dao.beans.aum.UtilizePerson;

public interface UtilizeInfoDao {
  public PaginatedList getUtilizeInfoByParams(HashMap hm);
  public UtilizeInfo getUtilizeInfoByApplyID(Map applyIDMap);
  public String addApply(UtilizeInfo uInfo);
  public int addApplyDetail(HashMap[] hm);
  public int deleteApplyInfoByApplyID(String applyID);
  public int updateUtilizeInfoForConfirm(HashMap hm);
  public int updateUtilizeInfoForRegi(HashMap hm);
  public int updateUtilizeInfoForReturn(HashMap hm);
  public int updateUtilizeInfoForCharge(HashMap hm);
  public int getUtilizeModeIDByName(String pModeName);
  public int updateUtilizeStatus(HashMap hm);
  public int updateChargeInfo(HashMap hm);
  public List getAllUtilModeName();
  public List getAllTaskByUser(String pLoginName, String pPassword, String type,
                               int procDefID);
  public List getAllTaskByUserSpan(String pLoginName, String pPassword,
                               String type, int procDefID, Date beginTime,
                               Date endTime);
  public int updateFlowInsID(HashMap hm);
  public List getAllUtilizePersonInfo();
  public List getAllTaskByCondition(String pLoginName, String pPassword,
                                String type, int procDefID,
                                Date deliverBeginTime, Date deliverEndTime,
                                Date applyBeginTime, Date applyEndTime,
                                String utilizer);
  public int updateUtilizeTerm(HashMap hm);
  public int insertUtilizePerson(UtilizePerson utilizePerson);
  public int updateUtilizePerson(UtilizePerson utilizePerson);
  public int deleteUtilizePerson(String person_id);
  public UtilizePerson getUtilizePersonByID(String personID);

}
