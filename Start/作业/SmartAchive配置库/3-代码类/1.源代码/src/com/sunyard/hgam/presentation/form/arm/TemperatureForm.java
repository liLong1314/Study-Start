package com.sunyard.hgam.presentation.form.arm;

import com.sunyard.hgam.presentation.base.BaseForm;
import com.sunyard.hgam.persistence.dao.beans.arm.Temperature;
import org.apache.struts.action.*;
import javax.servlet.http.*;

/**
 * <p>Title: ��ʪ�ȹ���</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author Ҷ�
 * @version 1.0
 */

public class TemperatureForm extends BaseForm {
  private Temperature temperatureInfo = new Temperature();
  public Temperature getTemperatureInfo() {
    return temperatureInfo;
  }
  public void setTemperatureInfo(Temperature temperatureInfo) {
    this.temperatureInfo = temperatureInfo;
  }
  public void reset(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {
  }

}