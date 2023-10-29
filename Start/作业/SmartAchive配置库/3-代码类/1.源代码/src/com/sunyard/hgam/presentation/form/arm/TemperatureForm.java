package com.sunyard.hgam.presentation.form.arm;

import com.sunyard.hgam.presentation.base.BaseForm;
import com.sunyard.hgam.persistence.dao.beans.arm.Temperature;
import org.apache.struts.action.*;
import javax.servlet.http.*;

/**
 * <p>Title: 温湿度管理</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 叶昊
 * @version 1.0
 */

public class TemperatureForm extends BaseForm {
  private Temperature temperatureInfo = new Temperature();
  public Temperature getTemperatureInfo() {
    return temperatureInfo;
  }
  public void setTemperatureInfo(Temperature temperatureInfo) {
    this.temperatureInfo = temperatureInfo;
  }
  public void reset(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {
  }

}