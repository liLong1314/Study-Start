package com.sunyard.hgam.presentation.form.adc;

import com.sunyard.hgam.presentation.base.BaseForm;
import com.sunyard.hgam.persistence.dao.beans.adc.Archives;

/**
 * <p>Title: HGAM</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author not attributable
 * @version 1.0
 */

public class ScanFileViewForm extends BaseForm {
  private String functionName;
  private String pageSize;
  private Archives archives = new Archives();
  private String archives_id;

  public ScanFileViewForm() {
    if (pageSize==null)
      pageSize = "20";
  }

  public String getFunctionName() {
    return functionName;
  }
  public void setFunctionName(String functionName) {
    this.functionName = functionName;
  }
  public String getPageSize() {
    return pageSize;
  }
  public void setPageSize(String pageSize) {
    this.pageSize = pageSize;
  }
  public Archives getArchives() {
    return archives;
  }
  public void setArchives(Archives archives) {
    this.archives = archives;
  }
  public String getArchives_id() {
    return archives_id;
  }
  public void setArchives_id(String archives_id) {
    this.archives_id = archives_id;
  }
}