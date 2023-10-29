package com.sunyard.hgam.presentation.form.aum;

import com.sunyard.hgam.presentation.base.BaseForm;
import com.sunyard.hgam.persistence.dao.beans.aum.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import java.util.*;
import com.sunyard.hgam.presentation.base.OptionBean;
import com.sunyard.hgam.presentation.base.SysParamOper;

/**
 * <p>Title: HGAM</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author not attributable
 * @version 1.0
 */

public class UtilizePersonForm
    extends BaseForm {

  private UtilizePerson utilizePerson = new UtilizePerson();
  private java.util.List certificate_type_options = new ArrayList();

  public UtilizePersonForm() {
    SysParamOper sysParamOper = SysParamOper.getInstance();
    certificate_type_options = sysParamOper.getSysParamByType(
        "CERTIFICATE_TYPE");
  }

  public UtilizePerson getUtilizePerson() {
    return utilizePerson;
  }

  public void setUtilizePerson(UtilizePerson utilizePerson) {
    this.utilizePerson = utilizePerson;
  }

  public void reset(ActionMapping actionMapping,
                    HttpServletRequest httpServletRequest) {
  }

  public java.util.List getCertificate_type_options() {
    return certificate_type_options;
  }

  public void setCertificate_type_options(java.util.List
                                          certificate_type_options) {
    this.certificate_type_options = certificate_type_options;
  }

}