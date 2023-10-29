package com.sunyard.hgam.presentation.form.adc;

import com.sunyard.hgam.presentation.base.BaseForm;
import java.io.*;
import com.sunyard.hgam.persistence.dao.beans.adc.*;

/**
 * <p>Title: HGAM</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author xuxj
 * @version 1.0
 */

public class ScanArchivesViewForm extends BaseForm{
  private String functionName;
  private String archives_id;
  private String roll_mode;
  private String piece_catalog_num;
  private String piece_num;
  private String piece_name;
  private String roll_catalog_num;
  private String roll_num;
  private String archives_name;
  private String pageSize;
  private Archives archives = new Archives();

  public ScanArchivesViewForm() {
    if (pageSize==null)
      pageSize = "20";
    if (archives.getAROLL_MODE()==null)
      archives.setAROLL_MODE("1") ;
    if (roll_mode==null)
      roll_mode = "1";
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
  public String getRoll_mode() {
    return roll_mode;
  }
  public void setRoll_mode(String roll_mode) {
    this.roll_mode = roll_mode;
  }
  public String getPiece_catalog_num() {
    return piece_catalog_num;
  }
  public void setPiece_catalog_num(String piece_catalog_num) {
    this.piece_catalog_num = piece_catalog_num;
  }
  public String getPiece_num() {
    return piece_num;
  }
  public void setPiece_num(String piece_num) {
    this.piece_num = piece_num;
  }
  public String getPiece_name() {
    return piece_name;
  }
  public void setPiece_name(String piece_name) {
    this.piece_name = piece_name;
  }
  public String getRoll_catalog_num() {
    return roll_catalog_num;
  }
  public void setRoll_catalog_num(String roll_catalog_num) {
    this.roll_catalog_num = roll_catalog_num;
  }
  public String getRoll_num() {
    return roll_num;
  }
  public void setRoll_num(String roll_num) {
    this.roll_num = roll_num;
  }
  public String getArchives_name() {
    return archives_name;
  }
  public void setArchives_name(String archives_name) {
    this.archives_name = archives_name;
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

}