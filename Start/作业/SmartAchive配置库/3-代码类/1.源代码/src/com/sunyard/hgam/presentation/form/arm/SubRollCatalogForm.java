package com.sunyard.hgam.presentation.form.arm;


import com.sunyard.hgam.presentation.base.BaseForm;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import com.sunyard.hgam.persistence.dao.beans.arm.SubRollCatalog;



/**
 * <p>Title: 分局目录管理</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 华良东
 * @version 1.0
 */

public class SubRollCatalogForm
  extends BaseForm{
  private SubRollCatalog subRollCatalogInfo=new SubRollCatalog();
  public SubRollCatalog getSubRollCatalogInfo() {
    return subRollCatalogInfo;
  }
  public void setSubRollCatalogInfo(SubRollCatalog subRollCatalogInfo) {
    this.subRollCatalogInfo = subRollCatalogInfo;
  }
  public void reset(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {
  }
}
