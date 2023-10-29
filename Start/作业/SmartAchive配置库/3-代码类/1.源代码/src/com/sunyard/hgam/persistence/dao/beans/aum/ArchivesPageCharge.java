package com.sunyard.hgam.persistence.dao.beans.aum;

/**
 * <p>Title: HGAM</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author not attributable
 * @version 1.0
 */

public class ArchivesPageCharge {
  private String page_id;
  private String page_size;
  private String charge_id;
  private String charge_money;
  private String archives_id;
  private String file_id;
  private String entry_id;
  public ArchivesPageCharge() {
  }

  public String getPage_id() {
    return page_id;
  }

  public void setPage_id(String page_id) {
    this.page_id = page_id;
  }

  public String getPage_size() {
    return page_size;
  }

  public void setPage_size(String page_size) {
    this.page_size = page_size;
  }

  public String getCharge_id() {
    return charge_id;
  }

  public void setCharge_id(String charge_id) {
    this.charge_id = charge_id;
  }

  public String getCharge_money() {
    return charge_money;
  }

  public void setCharge_money(String charge_money) {
    this.charge_money = charge_money;
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

  public String getEntry_id() {
    return entry_id;
  }

  public void setEntry_id(String entry_id) {
    this.entry_id = entry_id;
  }

}