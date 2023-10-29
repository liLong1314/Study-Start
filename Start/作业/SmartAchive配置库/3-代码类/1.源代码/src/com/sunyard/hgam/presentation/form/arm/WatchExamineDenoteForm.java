package com.sunyard.hgam.presentation.form.arm;

import com.sunyard.hgam.presentation.base.BaseForm;
import com.sunyard.hgam.persistence.dao.beans.arm.WatchExamineDenote;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>Title: 总局指示</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 华良东
 * @version 1.0
 */

public class WatchExamineDenoteForm extends BaseForm {
  private WatchExamineDenote watchExamineDenoteInfo=new WatchExamineDenote();
  public WatchExamineDenote getWatchExamineDenoteInfo() {
    return watchExamineDenoteInfo;
  }
  public void setWatchExamineDenoteInfo(WatchExamineDenote watchExamineDenoteInfo) {
    this.watchExamineDenoteInfo = watchExamineDenoteInfo;
  }
  public void reset(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {
  }


}