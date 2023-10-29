package com.sunyard.hgam.persistence.dao.beans.arm;
import java.io.*;
/**
 * <p>Title: 销毁清册</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 叶昊
 * @version 1.0
 */

public class Destroy {
  private String destroyId;
  private String fileId;
  private String destroyOperator;
  private String destroySupervisor;
  private String destroySituation;
  private String destroyDate;
  private String destroyPlace;
  private String remark;
  private String isDestroy;
  private String[] filelist;
  private String destroyDateFrom;
  private String destroyDateTo;
  private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
    ois.defaultReadObject();
  }
  private void writeObject(ObjectOutputStream oos) throws IOException {
    oos.defaultWriteObject();
  }
  public String getDestroyDate() {
    return destroyDate;
  }
  public void setDestroyDate(String destroyDate) {
    this.destroyDate = destroyDate;
  }
  public String getDestroyId() {
    return destroyId;
  }
  public void setDestroyId(String destroyId) {
    this.destroyId = destroyId;
  }
  public String getDestroyOperator() {
    return destroyOperator;
  }
  public void setDestroyOperator(String destroyOperator) {
    this.destroyOperator = destroyOperator;
  }
  public String getDestroySituation() {
    return destroySituation;
  }
  public void setDestroySituation(String destroySituation) {
    this.destroySituation = destroySituation;
  }
  public String getDestroySupervisor() {
    return destroySupervisor;
  }
  public void setDestroySupervisor(String destroySupervisor) {
    this.destroySupervisor = destroySupervisor;
  }
  public String getFileId() {
    return fileId;
  }
  public void setFileId(String fileId) {
    this.fileId = fileId;
  }
  public String getIsDestroy() {
    return isDestroy;
  }
  public void setIsDestroy(String isDestroy) {
    this.isDestroy = isDestroy;
  }
  public String getRemark() {
    return remark;
  }
  public void setRemark(String remark) {
    this.remark = remark;
  }
  public String[] getFilelist() {
    return filelist;
  }
  public void setFilelist(String[] filelist) {
    this.filelist = filelist;
  }
  public String getDestroyPlace() {
    return destroyPlace;
  }
  public void setDestroyPlace(String destroyPlace) {
    this.destroyPlace = destroyPlace;
  }
  public String getDestroyDateFrom() {
    return destroyDateFrom;
  }
  public void setDestroyDateFrom(String destroyDateFrom) {
    this.destroyDateFrom = destroyDateFrom;
  }
  public String getDestroyDateTo() {
    return destroyDateTo;
  }
  public void setDestroyDateTo(String destroyDateTo) {
    this.destroyDateTo = destroyDateTo;
  }
}