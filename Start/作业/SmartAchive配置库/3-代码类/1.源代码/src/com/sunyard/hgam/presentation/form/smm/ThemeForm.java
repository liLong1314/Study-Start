package com.sunyard.hgam.presentation.form.smm;

import com.sunyard.hgam.presentation.base.BaseForm;
import com.sunyard.hgam.persistence.dao.beans.smm.Theme;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>Title: 参数管理</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 华良东
 * @version 1.0
 */

public class  ThemeForm extends BaseForm {
  private Theme ThemeInfo = new Theme();
  public Theme getThemeInfo() {
    return ThemeInfo ;
  }
  public void setThemeInfo(Theme ThemeInfo) {
    this.ThemeInfo = ThemeInfo ;
  }
  public void reset(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {
  }
}
