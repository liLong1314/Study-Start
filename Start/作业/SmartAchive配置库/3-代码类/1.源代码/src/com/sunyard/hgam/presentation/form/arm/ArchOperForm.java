package com.sunyard.hgam.presentation.form.arm;

import com.sunyard.hgam.presentation.base.BaseForm;
import com.sunyard.hgam.persistence.dao.beans.arm.ArchOper;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import com.sunyard.hgam.persistence.dao.iface.adc.EformDao;
import com.sunyard.hgam.domain.logic.DomainLogic;
import java.util.List;
import java.util.Iterator;
import com.sunyard.hgam.persistence.dao.beans.adc.EformFieldValue;
import com.sunyard.hgam.presentation.base.OptionBean;
import java.util.ArrayList;

/**
 * <p>Title: 档案信息管理</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 叶昊
 * @version 1.0
 */

public class ArchOperForm extends BaseForm {
  private ArchOper archOperInfo=new ArchOper();
  private List fieldNames = new ArrayList();
  private List fieldValues = new ArrayList();
  //增加：郑先全，20040206
  //修订：郑先全，20040227，由于增加了导航ACTION，删除上次的增加部分；
  public ArchOperForm(){
    //初始化项目概要信息字段
    //EformDao eformDao = (EformDao)DomainLogic.getInstance().getDAO("Eform");
    //this.setFieldNames(eformDao.getProjBriefFields());
  }
  public ArchOper getArchOperInfo() {
    return archOperInfo;
  }
  public void setArchOperInfo(ArchOper archOperInfo) {
    this.archOperInfo = archOperInfo;
  }
  public void reset(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {
  }
  public List getFieldNames() {
    return fieldNames;
  }
  public void setFieldNames(List fieldNames) {
    this.fieldNames = fieldNames;
  }
  public List getFieldValues() {
    return fieldValues;
  }
  public void setFieldValues(List fieldValues) {
    this.fieldValues = fieldValues;
  }

}