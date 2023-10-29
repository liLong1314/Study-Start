package com.sunyard.hgam.persistence.dao.beans.arm;

import java.io.*;

/**
 * <p>Title: 档案信息管理-页面部分</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 叶昊
 * @version 1.0
 */

public class PageOper implements Serializable{
  private String pageId;
  private String fileId;
  private String pageName;
  private String pageType;
  private String pageSize;
  private String pageNum;
  private String pageDate;
  private String pageOperate;
  private String pageStatus;
  private String pagePathName;
  private String remark;
  private String pageArea;
  private void readObject(ObjectInputStream ois) throws ClassNotFoundException,
      IOException {
    ois.defaultReadObject();
  }

  private void writeObject(ObjectOutputStream oos) throws IOException {
    oos.defaultWriteObject();
  }

  public String getFileId() {
    return fileId;
  }

  public void setFileId(String fileId) {
    this.fileId = fileId;
  }

  public String getPageDate() {
    return pageDate;
  }

  public void setPageDate(String pageDate) {
    this.pageDate = pageDate;
  }

  public String getPageId() {
    return pageId;
  }

  public void setPageId(String pageId) {
    this.pageId = pageId;
  }

  public String getPageName() {
    return pageName;
  }

  public void setPageName(String pageName) {
    this.pageName = pageName;
  }

  public String getPageNum() {
    return pageNum;
  }

  public void setPageNum(String pageNum) {
    this.pageNum = pageNum;
  }

  public String getPageOperate() {
    return pageOperate;
  }

  public void setPageOperate(String pageOperate) {
    this.pageOperate = pageOperate;
  }

  public String getPagePathName() {
    return pagePathName;
  }

  public void setPagePathName(String pagePathName) {
    this.pagePathName = pagePathName;
  }

  public String getPageSize() {
    return pageSize;
  }

  public void setPageSize(String pageSize) {
    this.pageSize = pageSize;
  }

  public String getPageStatus() {
    return pageStatus;
  }

  public void setPageStatus(String pageStatus) {
    this.pageStatus = pageStatus;
  }

  public String getPageType() {
    return pageType;
  }

  public void setPageType(String pageType) {
    this.pageType = pageType;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }
  public String getPageArea() {
    return pageArea;
  }
  public void setPageArea(String pageArea) {
    this.pageArea = pageArea;
  }

}