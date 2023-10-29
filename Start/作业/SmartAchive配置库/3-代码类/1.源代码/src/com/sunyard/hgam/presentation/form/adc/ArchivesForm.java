package com.sunyard.hgam.presentation.form.adc;

import com.sunyard.hgam.presentation.base.BaseForm;
import com.sunyard.hgam.persistence.dao.beans.adc.Archives;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import com.sunyard.hgam.presentation.base.OptionBean;
import java.util.ArrayList;
import com.sunyard.hgam.presentation.base.SysParamOper;
import com.sunyard.hgam.persistence.dao.iface.arm.SecretDao;
import com.sunyard.hgam.domain.logic.DomainLogic;
import java.util.Iterator;
import com.sunyard.hgam.persistence.dao.beans.arm.Secret;
import java.util.Date;
import java.util.Calendar;

public class ArchivesForm extends BaseForm {

  private Archives archives = new Archives();
  private java.util.List aARCHIVES_UNITOptions = new ArrayList();
  private java.util.List aMEDIA_TYPEOptions = new ArrayList();
  private java.util.List aSPECIFICATIONOptions = new ArrayList();
  private java.util.List aCONTAINER_IDOptions = new ArrayList();
  private java.util.List aSTORE_TERMOptions = new ArrayList();
  private List secret_idOptions = new ArrayList();

  private java.util.List aARCHIVES_FOUND_UNITOptions = new ArrayList();

  private String operName = "";//操作名称，用于判断用户的操作
  private String msgArchivesNumCheck = "";//档号检查提示
  private String msgError;//错误信息提示

  public ArchivesForm() {
    SysParamOper sysParamOper = SysParamOper.getInstance();
    archives.setAFONDS_NUM("J070");
    //修订（郑先全，20040211）：增加档案年度的初始化
    archives.setAARCHIVES_YEAR((Calendar.getInstance()).get(Calendar.YEAR)+"");
    aARCHIVES_UNITOptions = sysParamOper.getSysParamByType("ARCHIVES_UNIT");
    aMEDIA_TYPEOptions = sysParamOper.getSysParamByType("MEDIA_TYPE");
    aSPECIFICATIONOptions = sysParamOper.getSysParamByType("SPEC");
    aCONTAINER_IDOptions.add(new OptionBean("TODO",""));
    aSTORE_TERMOptions = sysParamOper.getSysParamByType("ArchiveStore");

    //密级
    SecretDao secretDao = (SecretDao)DomainLogic.getInstance().getDAO("Secret");
    Iterator secretIterator = secretDao.getAllSecret().iterator();
    while(secretIterator.hasNext()){
      Secret secret = (Secret) secretIterator.next();
      secret_idOptions.add(new OptionBean(secret.getSecretName(),secret.getSecretId()));
    }
    //业务类特有的列表属性
    //立档单位
    aARCHIVES_FOUND_UNITOptions = sysParamOper.getSysParamByType("ARCHIVES_FOUND_UNIT");

    msgArchivesNumCheck = "请先检查档号是否可用！";
    msgError = "";
  }

  public Archives getArchives() {
    return archives;
  }
  public void setArchives(Archives archives) {
    this.archives = archives;
  }
  public void reset(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {
  }
  public java.util.List getAARCHIVES_UNITOptions() {
    return aARCHIVES_UNITOptions;
  }
  public java.util.List getAMEDIA_TYPEOptions() {
    return aMEDIA_TYPEOptions;
  }
  public java.util.List getASPECIFICATIONOptions() {
    return aSPECIFICATIONOptions;
  }
  public java.util.List getACONTAINER_IDOptions() {
    return aCONTAINER_IDOptions;
  }
  public java.util.List getASTORE_TERMOptions() {
    return aSTORE_TERMOptions;
  }
  public String getOperName() {
    return operName;
  }
  public java.util.List getSecret_idOptions() {
    return secret_idOptions;
  }

  public void setOperName(String operName) {
    this.operName = operName;
  }
  public String getMsgArchivesNumCheck() {
    return msgArchivesNumCheck;
  }
  public void setMsgArchivesNumCheck(String msgArchivesNumCheck) {
    this.msgArchivesNumCheck = msgArchivesNumCheck;
  }

  public List getAARCHIVES_FOUND_UNITOptions() {
    return aARCHIVES_FOUND_UNITOptions;
  }
  public String getMsgError() {
    return msgError;
  }
  public void setMsgError(String msgError) {
    this.msgError = msgError;
  }

}
