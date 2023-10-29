package com.sunyard.hgam.presentation.form.aum;

import com.sunyard.hgam.presentation.base.BaseForm;
import com.sunyard.hgam.persistence.dao.beans.adc.*;

/**
 * <p>Title: HGAM</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author not attributable
 * @version 1.0
 */

public class SelectArchivesFileForm
    extends BaseForm {
  private String archives_id = "";
  private String[] selectID;
  private Archives archives = new Archives();
  private String functionName = "";
  public SelectArchivesFileForm() {
  }

  public String getArchives_id() {
    return archives_id;
  }

  public void setArchives_id(String archives_id) {
    this.archives_id = archives_id;
  }

  public String[] getSelectID() {
    return selectID;
  }

  public void setSelectID(String[] selectID) {
    this.selectID = selectID;
  }

  public Archives getArchives() {
    return archives;
  }

  public void setArchives(Archives archives) {
    this.archives = archives;
  }

  public String getFunctionName() {
    return functionName;
  }

  public void setFunctionName(String functionName) {
    this.functionName = functionName;
  }

}