package com.sunyard.hgam.presentation.form.arm;

import com.sunyard.hgam.presentation.base.BaseForm;
import com.sunyard.hgam.persistence.dao.beans.arm.BuildingCataLog;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;


/**
 * <p>Title: ������ĿĿ¼�����</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author ������
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