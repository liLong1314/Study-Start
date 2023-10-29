package com.sunyard.hgam.presentation.form.arm;

import com.sunyard.hgam.presentation.base.BaseForm;
import com.sunyard.hgam.persistence.dao.beans.arm.Safety;
import org.apache.struts.action.*;
import javax.servlet.http.*;

/**
 * <p>Title: 安全管理</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 叶昊
 * @version 1.0
 */

public class SafetyForm extends BaseForm {
  private Safety safetyInfo = new Safety();
  public Safety getSafetyInfo() {
    return safetyInfo;
  }
  public void setSafetyInfo(Safety safetyInfo) {
    this.safetyInfo = safetyInfo;
  }
  public void reset(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {
  }

}