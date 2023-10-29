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
 * �����ļ�Form
 * <p>Title: HGAM</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author ֣��ȫ
 * @version 1.0
 * �޶���¼��
 * 1������
 * 2�����ӵ��ӱ��ֶ�ֵ�б����ԣ�֣��ȫ��2003��12��30��
 */
public class ArchivesFileForm extends BaseForm {

  private Archives archives = new Archives();
  private ArchivesFile archivesFile = new ArchivesFile();
  private String operName = "";    //�������ƣ������ж��û��Ĳ���
  private String msgError = null;  //������Ϣ��ʾ

  //ѡ����Ŀ����
  private List media_typeOptions = new ArrayList();
  private List file_specOptions = new ArrayList();
  private List file_store_termOptions = new ArrayList();
  private List file_typeOptions = new ArrayList();
  private List secret_idOptions = new ArrayList();
  private List eform_idOptions = new ArrayList();
  private List up_phase_idOptions = new ArrayList();
  private List phase_idOptions = new ArrayList();

  //���ӱ��ֶ��б�
  private List eformFieldDefineList = new ArrayList();
  //���ӱ��ֶ�ֵ�б�
  private List eformFieldValueList = new ArrayList();

  //���캯�����Գ�ʼ��
  public ArchivesFileForm(){
    SysParamOper sysParamOper = SysParamOper.getInstance();
    media_typeOptions = sysParamOper.getSysParamByType("MEDIA_TYPE");
    file_specOptions = sysParamOper.getSysParamByType("SPEC");
    file_typeOptions = sysParamOper.getSysParamByType("FILE_TYPE");
    file_store_termOptions = sysParamOper.getSysParamByType("ArchiveStore");

    //�ļ��ܼ�
    SecretDao secretDao = (SecretDao)DomainLogic.getInstance().getDAO("Secret");
    Iterator secretIterator = secretDao.getAllSecret().iterator();
    while(secretIterator.hasNext()){
      Secret secret = (Secret) secretIterator.next();
      secret_idOptions.add(new OptionBean(secret.getSecretName(),secret.getSecretId()));
    }
    //���ӱ������б�
    EformDao eformDao = (EformDao)DomainLogic.getInstance().getDAO("Eform");
    Iterator eformIterator = eformDao.getAllEformDefine().iterator();
    while(eformIterator.hasNext()){
      EformDefine eformDefine = (EformDefine) eformIterator.next();
      eform_idOptions.add(new OptionBean(eformDefine.getEform_name(),eformDefine.getEform_id()));
    }
    //���̽׶ζ���
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