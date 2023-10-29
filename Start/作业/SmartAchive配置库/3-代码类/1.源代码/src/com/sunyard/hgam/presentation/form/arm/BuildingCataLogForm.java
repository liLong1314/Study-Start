package com.sunyard.hgam.presentation.form.arm;

import com.sunyard.hgam.presentation.base.BaseForm;
import com.sunyard.hgam.persistence.dao.beans.arm.BuildingCataLog;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;


/**
 * <p>Title: 建筑项目目录册管理</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 华良东
 * @version 1.0
 */

public class BuildingCataLogForm
    extends BaseForm{
  private BuildingCataLog BuildingCataLogInfo=new BuildingCataLog();
  public BuildingCataLog getBuildingCataLogInfo() {
    return BuildingCataLogInfo;
  }
  public void setBuildingCataLogInfo(BuildingCataLog BuildingCataLogInfo) {
    this.BuildingCataLogInfo = BuildingCataLogInfo;
  }
  public void reset(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {
  }
}