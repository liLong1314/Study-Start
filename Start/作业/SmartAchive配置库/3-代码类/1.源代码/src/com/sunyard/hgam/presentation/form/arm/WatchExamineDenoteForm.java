package com.sunyard.hgam.presentation.form.arm;

import com.sunyard.hgam.presentation.base.BaseForm;
import com.sunyard.hgam.persistence.dao.beans.arm.WatchExamineDenote;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>Title: �ܾ�ָʾ</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author ������
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