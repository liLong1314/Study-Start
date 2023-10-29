package com.sunyard.hgam.presentation.form.arm;

import com.sunyard.hgam.presentation.base.BaseForm;
import com.sunyard.hgam.persistence.dao.beans.arm.PageOper;

/**
 * <p>Title: 档案查询－页面部分</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 叶昊
 * @version 1.0
 */

public class PageOperForm extends BaseForm {
  PageOper pageOperInfo=new PageOper();
  public PageOper getPageOperInfo() {
    return pageOperInfo;
  }
  public void setPageOperInfo(PageOper pageOperInfo) {
    this.pageOperInfo = pageOperInfo;
  }
}