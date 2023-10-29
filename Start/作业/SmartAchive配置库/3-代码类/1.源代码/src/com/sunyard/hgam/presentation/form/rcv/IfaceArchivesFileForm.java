package com.sunyard.hgam.presentation.form.rcv;

import com.sunyard.hgam.presentation.base.BaseForm;
import com.sunyard.hgam.persistence.dao.beans.rcv.IfaceArchivesFile;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.ArrayList;
import com.sunyard.hgam.presentation.base.OptionBean;
import com.sunyard.hgam.persistence.dao.iface.arm.SecretDao;
import com.sunyard.hgam.domain.logic.DomainLogic;
import java.util.Iterator;
import com.sunyard.hgam.persistence.dao.beans.arm.Secret;
import com.sunyard.hgam.persistence.dao.iface.adc.EformDao;
import com.sunyard.hgam.persistence.dao.beans.adc.EformDefine;
import com.sunyard.hgam.persistence.dao.beans.adc.ProjectPhase;

public class IfaceArchivesFileForm extends BaseForm {
  private IfaceArchivesFile ifaceArchivesFile = new IfaceArchivesFile();
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

  //���ӱ��ֶ�ֵ�б�
  private List eformFieldValueList = new ArrayList();

  //���캯�����Գ�ʼ��
  public IfaceArchivesFileForm(){
    media_typeOptions.add(new OptionBean("ý������", ""));
    file_specOptions.add(new OptionBean("������", ""));
    file_store_termOptions.add(new OptionBean("��������", ""));
    file_typeOptions.add(new OptionBean("�屾����", ""));
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
  public void reset(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {
  }
  public String getMsgError() {
    return msgError;
  }
  public void setMsgError(String msgError) {
    this.msgError = msgError;
  }
  public IfaceArchivesFile getIfaceArchivesFile() {
    return ifaceArchivesFile;
  }
  public void setIfaceArchivesFile(IfaceArchivesFile ifaceArchivesFile) {
    this.ifaceArchivesFile = ifaceArchivesFile;
  }
  public String getOperName() {
    return operName;
  }
  public void setOperName(String operName) {
    this.operName = operName;
  }
  public List getEformFieldValueList() {
    return eformFieldValueList;
  }
  public void setEformFieldValueList(List eformFieldValueList) {
    this.eformFieldValueList = eformFieldValueList;
  }
}