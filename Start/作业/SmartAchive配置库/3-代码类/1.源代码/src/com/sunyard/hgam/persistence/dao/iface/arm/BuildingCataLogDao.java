package com.sunyard.hgam.persistence.dao.iface.arm;

import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.beans.arm.BuildingCataLog;

/**
 * <p>Title: ������ĿĿ¼�����</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author ������
 * @version 1.0
 */

public interface BuildingCataLogDao {
  public PaginatedList getAllBuildingCataLog();
  public PaginatedList getAllBuildingCataLog(int pageSize);
  public BuildingCataLog  getBuildingCataLog(String cataId);
  public int addBuildingCataLog(BuildingCataLog buildingCataLog);
  public PaginatedList queryBuildingCataLogList(BuildingCataLog buildingCataLog);
  public PaginatedList queryBuildingCataLogList(BuildingCataLog buildingCataLog,int pageSize);
  public int updateBuildingCataLog(BuildingCataLog buildingCataLog);
  public int deleteBuildingCataLog(String cataId);
}