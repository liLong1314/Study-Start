package com.sunyard.hgam.presentation.form.arm;

import com.sunyard.hgam.presentation.base.BaseForm;
import com.sunyard.hgam.persistence.dao.beans.arm.Entry;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import com.sunyard.hgam.presentation.base.SysParamOper;

/**
 * <p>Title: 类目管理</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 叶昊
 * @version 1.0
 * @log
 * 1.完善类目类型的参数化设置：郑先全，20040227
 */

public class EntryForm extends BaseForm {
  private Entry entryInfo = new Entry();
  private java.util.List entryTypeOptions = new ArrayList();

  public EntryForm(){
    SysParamOper sysParamOper = SysParamOper.getInstance();
    entryTypeOptions = sysParamOper.getSysParamByType("ENTRY_TYPE");
  }
  public Entry getEntryInfo() {
    return entryInfo;
  }
  public void setEntryInfo(Entry secretInfo) {
    this.entryInfo = secretInfo;
  }
  public void reset(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {
  }
  public java.util.List getEntryTypeOptions() {
    return entryTypeOptions;
  }
}