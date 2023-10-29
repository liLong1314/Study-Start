package com.sunyard.hgam.presentation.form.adc;

import com.sunyard.hgam.presentation.base.BaseForm;
import com.sunyard.hgam.persistence.dao.beans.adc.ArchivesPage;
import java.util.*;
import com.sunyard.hgam.presentation.base.OptionBean;
import com.sunyard.hgam.persistence.dao.iface.adc.*;
import com.sunyard.hgam.domain.logic.DomainLogic;
import com.sunyard.hgam.persistence.dao.beans.adc.ArchivesFile;
import com.sunyard.hgam.util.adc.*;

/**
 * <p>Title: HGAM</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author not attributable
 * @version 1.0
 */

public class CheckArchivesPageForm
    extends BaseForm {
  private String functionName = "";
  private ArchivesPage archivesPage = new ArchivesPage();

  /** ��װ��һ�������������ļ��ļ���*/
  private List list_ArchivesFiles;

  /** ��װ��һ�����в���Ȩ�޵ļ���*/
  private List list_operator;

  /** ��װ�����С�ҳ��������*/
  private List list_pageSize;

  private String serverDir;
  private String serverFileName;

  /** �������ļ�ȡ����*/
  private PropertiesInfo properiesInfo = null;
  private String functionReturn;

  public CheckArchivesPageForm() {
  }

  public PropertiesInfo getProperiesInfo() throws Exception {
    if (properiesInfo == null) {
      properiesInfo = new PropertiesInfo("adc.properties");
    }
    return properiesInfo;
  }

  /** �õ�һ�������ڵ������ļ���Ϣ*/
  public List getList_ArchivesFiles() throws Exception {
    //if (list_ArchivesFiles==null){
      if (archivesPage.getArchives_id() == null) {
        if (archivesPage.getPage_id() != null) {
          ArchivesPageDao dao = (ArchivesPageDao) DomainLogic.getInstance().
              getDAO("ArchivesPage");
          int archives_id = dao.getArchivesIdByPageId(new Integer(archivesPage.
              getPage_id()));
          archivesPage.setArchives_id(Integer.toString(archives_id));
        }
      }
      if (!archivesPage.getArchives_id().equalsIgnoreCase("")) {
        list_ArchivesFiles = AdcUtil.getArchivesFilesByArchivesID(
            archivesPage.getArchives_id());
      }
    //}
    if (list_ArchivesFiles == null) { //��ֹ����null
      list_ArchivesFiles = new ArrayList();
    }
    return list_ArchivesFiles;
  }

  /** ��װ��һ�����в���Ȩ�޵ļ���*/
  public List getList_operator() throws Exception {
    //if (list_operator==null)
      list_operator = AdcUtil.getSystemParamOperator() ;
    if (list_operator == null) { //��ֹ����null
      list_operator = new ArrayList();
    }
    return list_operator;
  }

  /** ��װ��һ�����С�ҳ�����ļ���*/
  public List getList_pageSize() throws Exception {
    //if (list_pageSize==null)
      list_pageSize = AdcUtil.getSystemParamPageSize() ;
    if (list_pageSize == null) { //��ֹ����null
      list_pageSize = new ArrayList();
    }
    return list_pageSize;
  }

  public String getFunctionName() {
    return functionName;
  }

  public void setFunctionName(String functionName) {
    this.functionName = functionName;
  }

  public ArchivesPage getArchivesPage() {
    return archivesPage;
  }

  public void setArchivesPage(ArchivesPage archivesPage) {
    this.archivesPage = archivesPage;
  }
  public String getServerDir() {
    return serverDir;
  }
  public void setServerDir(String serverDir) {
    this.serverDir = serverDir;
  }
  public String getServerFileName() {
    return serverFileName;
  }
  public void setServerFileName(String serverFileName) {
    this.serverFileName = serverFileName;
  }
  public String getFunctionReturn() {
    return functionReturn;
  }
  public void setFunctionReturn(String functionReturn) {
    this.functionReturn = functionReturn;
  }

}