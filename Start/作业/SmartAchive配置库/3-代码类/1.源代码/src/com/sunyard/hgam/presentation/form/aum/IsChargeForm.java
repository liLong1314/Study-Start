package com.sunyard.hgam.presentation.form.aum;

import com.sunyard.hgam.presentation.base.BaseForm;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>Title: HGAM</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author not attributable
 * @version 1.0
 */

public class IsChargeForm extends BaseForm {
  private String functionName = "";
  private String[] selectID;
  private List list_entry = new ArrayList();
  private String functionData = "";
  public IsChargeForm() {
  }
  public String getFunctionName() {
    return functionName;
  }
  public void setFunctionName(String functionName) {
    this.functionName = functionName;
  }
  public String[] getSelectID() {
    return selectID;
  }
  public void setSelectID(String[] selectID) {
    this.selectID = selectID;
  }
  public List getList_entry() {
    return list_entry;
  }
  public void setList_entry(List list_entry) {
    this.list_entry = list_entry;
  }
  public String getFunctionData() {
    return functionData;
  }
  public void setFunctionData(String functionData) {
    this.functionData = functionData;
  }

}