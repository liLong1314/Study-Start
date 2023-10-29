package com.sunyard.hgam.presentation.form.adc;

import com.sunyard.hgam.presentation.base.BaseForm;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import com.sunyard.hgam.persistence.dao.beans.adc.EformDefine;
import java.util.ArrayList;
import com.sunyard.hgam.persistence.dao.iface.arm.EntryDao;
import com.sunyard.hgam.domain.logic.DomainLogic;
import java.util.Iterator;
import com.sunyard.hgam.presentation.base.OptionBean;
import com.sunyard.hgam.persistence.dao.beans.arm.Entry;

public class EformDefineForm extends BaseForm {

  private EformDefine eformDefine = new EformDefine();
  private java.util.List entry_idOptions = new ArrayList();

  private String operName = "";//�������ƣ������ж��û��Ĳ���
  private String msgError = "";//������Ϣ��ʾ

  public EformDefineForm() {
    //������Ŀ
    EntryDao entryDao = (EntryDao)DomainLogic.getInstance().getDAO("Entry");
    Iterator entryIterator = entryDao.querySecondEntryForEformDefine().iterator();
    while(entryIterator.hasNext()){
      Entry entry = (Entry) entryIterator.next();
      entry_idOptions.add(new OptionBean(entry.getEntryName(),entry.getEntryId()));
    }

  }


  public EformDefine getEformDefine() {
    return eformDefine;
  }
  public void setEformDefine(EformDefine eformDefine) {
    this.eformDefine = eformDefine;
  }
  public void reset(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {
  }
  public String getOperName() {
    return operName;
  }
  public void setOperName(String operName) {
    this.operName = operName;
  }
  public java.util.List getEntry_idOptions() {
    return entry_idOptions;
  }
  public String getMsgError() {
    return msgError;
  }
  public void setMsgError(String msgError) {
    this.msgError = msgError;
  }

}