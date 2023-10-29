package com.sunyard.hgam.persistence.dao.beans.aum;

import java.io.Serializable;

/**
 * <p>Title: HGAM </p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author wanghua
 * @version 1.0
 */

public class UrgeInfoForOA
    implements Serializable {

  public UrgeInfoForOA() {
  }

  private String urge_id;
  private String archives_num;
  private String archives_name;
  private String page_amount;
  private String borrow_person;
  private String must_return_date;
  private String is_return;
  private String remark;

  public String getPage_amount() {
    return page_amount;
  }

  public String getArchives_name() {
    return archives_name;
  }

  public String getArchives_num() {
    return archives_num;
  }

  public String getBorrow_person() {
    return borrow_person;
  }

  public String getIs_return() {
    return is_return;
  }

  public String getMust_return_date() {
    return must_return_date;
  }

  public String getRemark() {
    return remark;
  }

  public String getUrge_id() {
    return urge_id;
  }

  public void setPage_amount(String page_amount) {
    this.page_amount = page_amount;
  }

  public void setArchives_name(String archives_name) {
    this.archives_name = archives_name;
  }

  public void setArchives_num(String archives_num) {
    this.archives_num = archives_num;
  }

  public void setBorrow_person(String borrow_person) {
    this.borrow_person = borrow_person;
  }

  public void setIs_return(String is_return) {
    this.is_return = is_return;
  }

  public void setMust_return_date(String must_return_date) {
    this.must_return_date = must_return_date;
  }

  public void setUrge_id(String urge_id) {
    this.urge_id = urge_id;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

}