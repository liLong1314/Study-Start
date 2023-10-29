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
 * <p>Title: ������Ϣ����</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author Ҷ�
 * @version 1.0
 */

public class ArchOperForm extends BaseForm {
  private ArchOper archOperInfo=new ArchOper();
  private List fieldNames = new ArrayList();
  private List fieldValues = new ArrayList();
  //���ӣ�֣��ȫ��20040206
  //�޶���֣��ȫ��20040227�����������˵���ACTION��ɾ���ϴε����Ӳ��֣�
  public ArchOperForm(){
    //��ʼ����Ŀ��Ҫ��Ϣ�ֶ�
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