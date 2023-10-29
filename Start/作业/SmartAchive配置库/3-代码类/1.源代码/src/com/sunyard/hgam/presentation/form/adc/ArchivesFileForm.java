package com.sunyard.hgam.presentation.form.adc;

import com.sunyard.hgam.presentation.base.BaseForm;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import com.sunyard.hgam.presentation.base.OptionBean;
import java.util.ArrayList;
import com.sunyard.hgam.persistence.dao.beans.adc.ArchivesFile;
import com.sunyard.hgam.persistence.dao.beans.adc.Archives;
import com.sunyard.hgam.persistence.dao.iface.arm.SecretDao;
import com.sunyard.hgam.domain.logic.DomainLogic;
import java.util.Iterator;
import com.sunyard.hgam.persistence.dao.beans.arm.Secret;
import com.sunyard.hgam.persistence.dao.iface.adc.EformDao;
import com.sunyard.hgam.persistence.dao.beans.adc.EformDefine;
import com.sunyard.hgam.persistence.dao.beans.adc.ProjectPhase;
import com.sunyard.hgam.presentation.base.SysParamOper;

/**
 * 档案文件Form
 * <p>Title: HGAM</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 郑先全
 * @version 1.0
 * 修订记录：
 * 1、创建
 * 2、增加电子表单字段值列表属性（郑先全，2003－12－30）
 */
public class ArchivesFileForm extends BaseForm {

  private Archives archives = new Archives();
  private ArchivesFile archivesFile = new ArchivesFile();
  private String operName = "";    //操作名称，用于判断用户的操作
  private String msgError = null;  //错误信息提示

  //选择项目对象
  private List media_typeOptions = new ArrayList();
  private List file_specOptions = new ArrayList();
  private List file_store_termOptions = new ArrayList();
  private List file_typeOptions = new ArrayList();
  private List secret_idOptions = new ArrayList();
  private List eform_idOptions = new ArrayList();
  private List up_phase_idOptions = new ArrayList();
  private List phase_idOptions = new ArrayList();

  //电子表单字段列表
  private List eformFieldDefineList = new ArrayList();
  //电子表单字段值列表
  private List eformFieldValueList = new ArrayList();

  //构造函数用以初始化
  public ArchivesFileForm(){
    SysParamOper sysParamOper = SysParamOper.getInstance();
    media_typeOptions = sysParamOper.getSysParamByType("MEDIA_TYPE");
    file_specOptions = sysParamOper.getSysParamByType("SPEC");
    file_typeOptions = sysParamOper.getSysParamByType("FILE_TYPE");
    file_store_termOptions = sysParamOper.getSysParamByType("ArchiveStore");

    //文件密级
    SecretDao secretDao = (SecretDao)DomainLogic.getInstance().getDAO("Secret");
    Iterator secretIterator = secretDao.getAllSecret().iterator();
    while(secretIterator.hasNext()){
      Secret secret = (Secret) secretIterator.next();
      secret_idOptions.add(new OptionBean(secret.getSecretName(),secret.getSecretId()));
    }
    //电子表单定义列表
    EformDao eformDao = (EformDao)DomainLogic.getInstance().getDAO("Eform");
    Iterator eformIterator = eformDao.getAllEformDefine().iterator();
    while(eformIterator.hasNext()){
      EformDefine eformDefine = (EformDefine) eformIterator.next();
      eform_idOptions.add(new OptionBean(eformDefine.getEform_name(),eformDefine.getEform_id()));
    }
    //工程阶段定义
    Iterator phaseIterator = eformDao.getProjectPhaseList().iterator();
    up_phase_idOptions.add(new OptionBean("",""));
    while(phaseIterator.hasNext()){
      ProjectPhase projectPhase = (ProjectPhase) phaseIterator.next();
      phase_idOptions.add(new OptionBean(projectPhase.getPhase_name(),projectPhase.getPhase_id()));
      up_phase_idOptions.add(new OptionBean(projectPhase.getPhase_name(),projectPhase.getPhase_id()));
    }

  }

  public ArchivesFile getArchivesFile() {
    return archivesFile;
  }
  public void setArchivesFile(ArchivesFile archivesFile) {
    this.archivesFile = archivesFile;
  }
  public Archives getArchives() {
    return archives;
  }
  public void setArchives(Archives archives) {
    this.archives = archives;
  }

  public String getOperName() {
    return operName;
  }
  public void setOperName(String operName) {
    this.operName = operName;
  }


  public void reset(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {
  }
  public java.util.List getFile_specOptions() {
    return file_specOptions;
  }
  public java.util.List getFile_store_termOptions() {
    return file_store_termOptions;
  }
  public java.util.List getMedia_typeOptions() {
    return media_typeOptions;
  }
  public java.util.List getSecret_idOptions() {
    return secret_idOptions;
  }
  public String getMsgError() {
    return msgError;
  }
  public void setMsgError(String msgError) {
    this.msgError = msgError;
  }
  public List getEformFieldDefineList() {
    return eformFieldDefineList;
  }
  public void setEformFieldDefineList(List eformFieldDefineList) {
    this.eformFieldDefineList = eformFieldDefineList;
  }
  public List getFile_typeOptions() {
    return file_typeOptions;
  }
  public List getEform_idOptions() {
    return eform_idOptions;
  }
  public List getUp_phase_idOptions() {
    return up_phase_idOptions;
  }
  public List getPhase_idOptions() {
    return phase_idOptions;
  }
  public List getEformFieldValueList() {
    return eformFieldValueList;
  }
  public void setEformFieldValueList(List eformFieldValueList) {
    this.eformFieldValueList = eformFieldValueList;
  }

}