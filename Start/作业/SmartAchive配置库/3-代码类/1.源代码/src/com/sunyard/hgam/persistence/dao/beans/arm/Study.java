package com.sunyard.hgam.persistence.dao.beans.arm;

import java.io.*;
/**
 * <p>Title: 档案编研管理</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 胡铮
 * @version 1.0
 */

public class Study implements Serializable{
  private String studyId;
  private String studyType;
  private String studyTitle;
  private String studyPre;
  private String studyContent;
  private String studyAuthor;
  private String studyDate;
  private String remark;
  public String getStudyId() {
    return studyId;
  }
  public void setStudyId(String studyId) {
    this.studyId = studyId;
  }
  public String getStudyType() {
    return studyType;
  }
  public void setStudyType(String studyType) {
    this.studyType = studyType;
  }
  public String getStudyTitle() {
   return studyTitle;
  }
  public void setStudyTitle(String studyTitle) {
   this.studyTitle = studyTitle;
  }
  public String getStudyPre() {
   return studyPre;
  }
  public void setStudyPre(String studyPre) {
   this.studyPre = studyPre;
  }
  public String getStudyContent() {
   return studyContent;
  }
  public void setStudyContent(String studyContent) {
   this.studyContent = studyContent;
  }
  public String getStudyAuthor() {
    return studyAuthor;
  }
  public void setStudyAuthor(String studyAuthor) {
    this.studyAuthor = studyAuthor;
  }
  public String getStudyDate() {
    return studyDate;
  }
  public void setStudyDate(String studyDate) {
    this.studyDate = studyDate;
  }
  public String getRemark() {
    return remark;
  }
  public void setRemark(String remark) {
    this.remark = remark;
  }
  private void writeObject(ObjectOutputStream oos) throws IOException {
    oos.defaultWriteObject();
  }
  private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
    ois.defaultReadObject();
  }
}
