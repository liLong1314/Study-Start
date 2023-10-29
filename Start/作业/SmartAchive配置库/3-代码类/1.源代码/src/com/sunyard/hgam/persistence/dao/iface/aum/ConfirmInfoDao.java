package com.sunyard.hgam.persistence.dao.iface.aum;

import com.sunyard.hgam.persistence.dao.beans.aum.ConfirmInfo;
import java.util.List;


public interface ConfirmInfoDao {
  public int addConfirmInfo(ConfirmInfo cInfo);
  public List getConfirmInfoByApplyID(String applyID);
  public List getConfirmInfoByTaskID(String taskID);
}