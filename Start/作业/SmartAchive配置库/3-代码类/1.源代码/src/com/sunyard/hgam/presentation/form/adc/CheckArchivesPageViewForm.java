package com.sunyard.hgam.presentation.form.adc;

import com.sunyard.hgam.presentation.base.BaseForm;

import com.sunyard.hgam.presentation.base.BaseForm;
import com.sunyard.hgam.persistence.dao.beans.adc.ArchivesPage;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.util.adc.PropertiesInfo;
import com.sunyard.hgam.persistence.dao.beans.adc.Archives;
import java.util.Iterator;
import com.sunyard.hgam.util.adc.AdcUtil;

/**
 * <p>Title: HGAM</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author not attributable
 * @version 1.0
 */

public class CheckArchivesPageViewForm extends BaseForm {

  private Archives archives = new Archives ();
  private String functionName = "";
  private String pageSize;

  //选中的批量操作对象
  private String[] selectedPageID;
  private String functionData;

  /** 封装了一个案卷中所有文件的集合*/
  private List list_ArchivesFiles;

  /** 封装了一个所有操作权限的集合*/
  private List list_operator;

  /** 封装了所有“页幅”集合*/
  private List list_pageSize;

  public CheckArchivesPageViewForm() {
    if (pageSize==null)
      pageSize = "20";
  }

  /** 得到一个案卷内的所有文件信息*/
  public List getList_ArchivesFiles() throws Exception {
    //if (list_ArchivesFiles == null)
      if (archives.getAARCHIVES_ID() != null) {
        list_ArchivesFiles = AdcUtil.getArchivesFilesByArchivesID(archives.
            getAARCHIVES_ID().toString());
      }
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

  public Archives getArchives() {
    return archives;
  }
  public void setArchives(Archives archives) {
    this.archives = archives;
  }
  public String getFunctionName() {
    return functionName;
  }
  public void setFunctionName(String functionName) {
    this.functionName = functionName;
  }
  public String getPageSize() {
    return pageSize;
  }
  public void setPageSize(String pageSize) {
    this.pageSize = pageSize;
  }
  public String[] getSelectedPageID() {
    return selectedPageID;
  }
  public void setSelectedPageID(String[] selectedPageID) {
    this.selectedPageID = selectedPageID;
  }
  public String getFunctionData() {
    return functionData;
  }
  public void setFunctionData(String functionData) {
    this.functionData = functionData;
  }
}