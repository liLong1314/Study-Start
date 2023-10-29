package com.sunyard.hgam.presentation.form.adc;

import com.sunyard.hgam.presentation.base.BaseForm;
import com.sunyard.hgam.persistence.dao.beans.adc.ArchivesPage;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.util.adc.PropertiesInfo;

/**
 * <p>Title: HGAM</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author xuxj
 * @version 1.0
 */

public class ArchivesPageForm extends BaseForm {


  private String functionName;
  private String archives_id;//����ID//1=����   2=����
  private String file_id;//�ļ�ID
  private String folderName;

  private String file_title;
  private String archives_num;
  private String archives_name;

  /** �������ļ�ȡ����*/
  private PropertiesInfo properiesInfo = null;

  public ArchivesPageForm() {

  }

  public void reset(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {
  }
  public String getFunctionName() {
    return functionName;
  }
  public void setFunctionName(String functionName) {
    this.functionName = functionName;
  }
  public String getArchives_id() {
    return archives_id;
  }
  public void setArchives_id(String archives_id) {
    this.archives_id = archives_id;
  }
  public String getFile_id() {
    return file_id;
  }
  public void setFile_id(String file_id) {
    this.file_id = file_id;
  }

  public PropertiesInfo getProperiesInfo() throws Exception {
    if (properiesInfo == null) {
      properiesInfo = new PropertiesInfo("adc.properties");
    }
    return properiesInfo;
  }
  public String getFolderName() {
    return folderName;
  }
  public void setFolderName(String folderName) {
    this.folderName = folderName;
  }
  public String getFile_title() {
    return file_title;
  }
  public void setFile_title(String file_title) {
    this.file_title = file_title;
  }
  public String getArchives_num() {
    return archives_num;
  }
  public void setArchives_num(String archives_num) {
    this.archives_num = archives_num;
  }
  public String getArchives_name() {
    return archives_name;
  }
  public void setArchives_name(String archives_name) {
    this.archives_name = archives_name;
  }

}