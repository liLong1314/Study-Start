package com.sunyard.hgam.persistence.dao.beans.arm;
import java.io.*;
import java.util.List;
/**
 * <p>Title: 档案资源管理－案卷部分</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 叶昊
 * @version 1.0
 */

public class ArchOper implements Serializable{
  private String archivesId;
  private String refarchivesId;
  private String entryId;
  private String archivesNum;
  private String rollMode;
  private String archivesYear;
  private String archivesName;
  private String storeTerm;
  private String archRoomCode;
  private String regNum;
  private String archUnit;
  private String mediaType;
  private String specification;
  private String archAmount;
  private String archFoundUnit;
  private String archFoundMan;
  private String archFoundDate;
  private String projId;
  private String projName;
  private String archivesStatus;
  private String isChange;
  private String isOperation;
  private String remark;
  private String[] archlist;
  private String blurquery;
  private String buildsub;
  private String proaddress;
  private String name1;
  private String name2;
  private java.util.List fieldValues;
  private java.util.List fieldNames;
  private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
    ois.defaultReadObject();
  }
  private void writeObject(ObjectOutputStream oos) throws IOException {
    oos.defaultWriteObject();
  }
  public String getArchAmount() {
    return archAmount;
  }
  public void setArchAmount(String archAmount) {
    this.archAmount = archAmount;
  }
  public String getArchFoundDate() {
    return archFoundDate;
  }
  public void setArchFoundDate(String archFoundDate) {
    this.archFoundDate = archFoundDate;
  }
  public String getArchFoundMan() {
    return archFoundMan;
  }
  public void setArchFoundMan(String archFoundMan) {
    this.archFoundMan = archFoundMan;
  }
  public String getArchFoundUnit() {
    return archFoundUnit;
  }
  public void setArchFoundUnit(String archFoundUnit) {
    this.archFoundUnit = archFoundUnit;
  }
  public String getArchivesId() {
    return archivesId;
  }
  public void setArchivesId(String archivesId) {
    this.archivesId = archivesId;
  }
  public String getArchivesName() {
    return archivesName;
  }
  public void setArchivesName(String archivesName) {
    this.archivesName = archivesName;
  }
  public String getArchivesNum() {
    return archivesNum;
  }
  public void setArchivesNum(String archivesNum) {
    this.archivesNum = archivesNum;
  }
  public String getArchivesStatus() {
    return archivesStatus;
  }
  public void setArchivesStatus(String archivesStatus) {
    this.archivesStatus = archivesStatus;
  }
  public String getArchivesYear() {
    return archivesYear;
  }
  public void setArchivesYear(String archivesYear) {
    this.archivesYear = archivesYear;
  }
  public String getArchRoomCode() {
    return archRoomCode;
  }
  public void setArchRoomCode(String archRoomCode) {
    this.archRoomCode = archRoomCode;
  }
  public String getArchUnit() {
    return archUnit;
  }
  public void setArchUnit(String archUnit) {
    this.archUnit = archUnit;
  }
  public String getEntryId() {
    return entryId;
  }
  public void setEntryId(String entryId) {
    this.entryId = entryId;
  }
  public String getIsChange() {
    return isChange;
  }
  public void setIsChange(String isChange) {
    this.isChange = isChange;
  }
  public String getIsOperation() {
    return isOperation;
  }
  public void setIsOperation(String isOperation) {
    this.isOperation = isOperation;
  }
  public String getMediaType() {
    return mediaType;
  }
  public void setMediaType(String mediaType) {
    this.mediaType = mediaType;
  }
  public String getProjId() {
    return projId;
  }
  public void setProjId(String projId) {
    this.projId = projId;
  }
  public String getProjName() {
    return projName;
  }
  public void setProjName(String projName) {
    this.projName = projName;
  }
  public String getRefarchivesId() {
    return refarchivesId;
  }
  public void setRefarchivesId(String refarchivesId) {
    this.refarchivesId = refarchivesId;
  }
  public String getRegNum() {
    return regNum;
  }
  public void setRegNum(String regNum) {
    this.regNum = regNum;
  }
  public String getRemark() {
    return remark;
  }
  public void setRemark(String remark) {
    this.remark = remark;
  }
  public String getRollMode() {
    return rollMode;
  }
  public void setRollMode(String rollMode) {
    this.rollMode = rollMode;
  }
  public String getSpecification() {
    return specification;
  }
  public void setSpecification(String specification) {
    this.specification = specification;
  }
  public String getStoreTerm() {
    return storeTerm;
  }
  public void setStoreTerm(String storeTerm) {
    this.storeTerm = storeTerm;
  }
  public String[] getArchlist() {
    return archlist;
  }
  public void setArchlist(String[] archlist) {
    this.archlist = archlist;
  }
  public String getBlurquery() {
    return blurquery;
  }
  public void setBlurquery(String blurquery) {
    this.blurquery = blurquery;
  }
  public String getBuildsub() {
    return buildsub;
  }
  public void setBuildsub(String buildsub) {
    this.buildsub = buildsub;
  }
  public String getProaddress() {
    return proaddress;
  }
  public void setProaddress(String proaddress) {
    this.proaddress = proaddress;
  }
  public String getName1() {
    return name1;
  }
  public void setName1(String name1) {
    this.name1 = name1;
  }
  public String getName2() {
    return name2;
  }
  public void setName2(String name2) {
    this.name2 = name2;
  }
  public java.util.List getFieldValues() {
    return fieldValues;
  }
  public void setFieldValues(java.util.List fieldValues) {
    this.fieldValues = fieldValues;
  }
  public java.util.List getFieldNames() {
    return fieldNames;
  }
  public void setFieldNames(java.util.List fieldNames) {
    this.fieldNames = fieldNames;
  }
}