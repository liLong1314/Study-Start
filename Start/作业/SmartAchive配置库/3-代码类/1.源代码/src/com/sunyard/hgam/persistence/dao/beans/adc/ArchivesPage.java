package com.sunyard.hgam.persistence.dao.beans.adc;

import java.io.*;

/**
 * <p>Title: HGAM</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author xuxj
 * @version 1.0
 */

public class ArchivesPage implements Serializable {
  private String page_id;
  private String file_id;
  private String page_type;
  private String page_size;
  private String page_num;
  private String page_date;
  private String page_pathName;
  private String remark;
  private String archives_id;
  private String data_file_id;
  private String page_operate;
  private String page_status;
  private String page_area;
  private String orderby;
  public ArchivesPage() {
    if (orderby==null || orderby.length()<1)
      orderby = "page_id";
  }
  public static void main(String[] args) {
    ArchivesPage archivesPage1 = new ArchivesPage();
  }
  public String getPage_id() {
    return page_id;
  }
  public void setPage_id(String page_id) {
    this.page_id = page_id;
  }
  public String getFile_id() {
    return file_id;
  }
  public void setFile_id(String file_id) {
    this.file_id = file_id;
  }
  public String getPage_type() {
    return page_type;
  }
  public void setPage_type(String page_type) {
    this.page_type = page_type;
  }
  public String getPage_size() {
    return page_size;
  }
  public void setPage_size(String page_size) {
    this.page_size = page_size;
  }
  public String getPage_num() {
    return page_num;
  }
  public void setPage_num(String page_num) {
    this.page_num = page_num;
  }
  public String getPage_date() {
    return page_date;
  }
  public void setPage_date(String page_date) {
    this.page_date = page_date;
  }
  public String getPage_pathName() {
    return page_pathName;
  }
  public void setPage_pathName(String page_pathName) {
    this.page_pathName = page_pathName;
  }
  public String getRemark() {
    return remark;
  }
  public void setRemark(String remark) {
    this.remark = remark;
  }
  public String getArchives_id() {
    return archives_id;
  }
  public void setArchives_id(String archives_id) {
    this.archives_id = archives_id;
  }
  private void writeObject(ObjectOutputStream oos) throws IOException {
    oos.defaultWriteObject();
  }
  private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
    ois.defaultReadObject();
  }
  public String getData_file_id() {
    return data_file_id;
  }
  public void setData_file_id(String data_file_id) {
    this.data_file_id = data_file_id;
  }
  public String getPage_operate() {
    return page_operate;
  }
  public void setPage_operate(String page_operate) {
    this.page_operate = page_operate;
  }
  public String getPage_status() {
    return page_status;
  }
  public void setPage_status(String page_status) {
    this.page_status = page_status;
  }
  public String getPage_area() {
    return page_area;
  }
  public void setPage_area(String page_area) {
    this.page_area = page_area;
  }
  public String getOrderby() {
    return orderby;
  }
  public void setOrderby(String orderby) {
    this.orderby = orderby;
  }

}