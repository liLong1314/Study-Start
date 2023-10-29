package com.sunyard.hgam.presentation.form.adc;

import com.sunyard.hgam.presentation.base.BaseForm;
import java.io.*;
import com.sunyard.hgam.persistence.dao.beans.adc.*;

/**
 * <p>Title: HGAM</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author xuxj
 * @version 1.0
 */

public class QueryArchivesViewForm extends BaseForm{
  private String functionName;
  private String pageSize;
  private Archives archives = new Archives();
  private String[] selectID;

  public QueryArchivesViewForm() {
    if (pageSize==null)
      pageSize = "20";
    if (archives.getAROLL_MODE()==null)
      archives.setAROLL_MODE("1") ;//��������
    if (archives.getAARCHIVES_STATUS()==null)
      archives.setAARCHIVES_STATUS("") ;//���� ���Ƿ��ѹ鵵��
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
  public Archives getArchives() {
    return archives;
  }
  public void setArchives(Archives archives) {
    this.archives = archives;
  }
  public String[] getSelectID() {
    return selectID;
  }
  public void setSelectID(String[] selectID) {
    this.selectID = selectID;
  }

}