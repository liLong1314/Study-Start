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
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author not attributable
 * @version 1.0
 */

public class CheckArchivesPageForm
    extends BaseForm {
  private String functionName = "";
  private ArchivesPage archivesPage = new ArchivesPage();

  /** 封装了一个案卷中所有文件的集合*/
  private List list_ArchivesFiles;

  /** 封装了一个所有操作权限的集合*/
  private List list_operator;

  /** 封装了所有“页幅”集合*/
  private List list_pageSize;

  private String serverDir;
  private String serverFileName;

  /** 从配置文件取参数*/
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

  /** 得到一个案卷内的所有文件信息*/
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
    if (list_ArchivesFiles == null) { //防止返回null
      list_ArchivesFiles = new ArrayList();
    }
    return list_ArchivesFiles;
  }

  /** 封装了一个所有操作权限的集合*/
  public List getList_operator() throws Exception {
    //if (list_operator==null)
      list_operator = AdcUtil.getSystemParamOperator() ;
    if (list_operator == null) { //防止返回null
      list_operator = new ArrayList();
    }
    return list_operator;
  }

  /** 封装了一个所有“页幅”的集合*/
  public List getList_pageSize() throws Exception {
    //if (list_pageSize==null)
      list_pageSize = AdcUtil.getSystemParamPageSize() ;
    if (list_pageSize == null) { //防止返回null
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