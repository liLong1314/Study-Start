package com.sunyard.hgam.presentation.form.arm;
import java.util.List;
import com.sunyard.hgam.presentation.base.BaseForm;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import com.sunyard.hgam.persistence.dao.beans.arm.WatchExamine;
import java.util.ArrayList;
import com.sunyard.hgam.presentation.base.SysParamOper;
import com.sunyard.hgam.presentation.base.OptionBean;


/**
 * <p>Title: �ල������</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author ������
 * @version 1.0
 */

public class WatchExamineForm
  extends BaseForm{
  private WatchExamine watchExamineInfo=new WatchExamine();
  private List subCodeOptions = new ArrayList();

  //�޶���֣��ȫ��20040316��
  public WatchExamineForm(){
    SysParamOper sysParamOper = SysParamOper.getInstance();
    subCodeOptions = sysParamOper.getSysParamByType("SubCode");
  }
  public WatchExamine getWatchExamineInfo() {
    return watchExamineInfo;
  }
  public void setWatchExamineInfo(WatchExamine watchExamineInfo) {
    this.watchExamineInfo = watchExamineInfo;
  }
  public void reset(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {
  }
  public List getSubCodeOptions() {
    return subCodeOptions;
  }

}