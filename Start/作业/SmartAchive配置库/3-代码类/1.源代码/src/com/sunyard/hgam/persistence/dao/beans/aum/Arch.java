package com.sunyard.hgam.persistence.dao.beans.aum;

import java.io.*;

public class Arch implements Serializable {
  private String applyID;
  private String entryName;
  private String rollNum;
  private String pieceNum;
  private String archivesName;
  private String fileTitle;
  private String pageNum;
  private String pageSize;
  private String chargeVersion;
  private String chargeMoney;
  private String pageID;
  private String eformInfoID;
  private String chargeID;
  private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
    ois.defaultReadObject();
  }
  private void writeObject(ObjectOutputStream oos) throws IOException {
    oos.defaultWriteObject();
  }
  public String getApplyID() {
    return applyID;
  }
  public void setApplyID(String applyID) {
    this.applyID = applyID;
  }
  public String getEntryName() {
    return entryName;
  }
  public void setEntryName(String entryName) {
    this.entryName = entryName;
  }
  public String getRollNum() {
    return rollNum;
  }
  public void setRollNum(String rollNum) {
    this.rollNum = rollNum;
  }
  public String getPieceNum() {
    return pieceNum;
  }
  public void setPieceNum(String pieceNum) {
    this.pieceNum = pieceNum;
  }
  public String getArchivesName() {
    return archivesName;
  }
  public void setArchivesName(String archivesName) {
    this.archivesName = archivesName;
  }
  public String getFileTitle() {
    return fileTitle;
  }
  public void setFileTitle(String fileTitle) {
    this.fileTitle = fileTitle;
  }
  public String getPageNum() {
    return pageNum;
  }
  public void setPageNum(String pageNum) {
    this.pageNum = pageNum;
  }
  public String getPageSize() {
    return pageSize;
  }
  public void setPageSize(String pageSize) {
    this.pageSize = pageSize;
  }
  public String getChargeVersion() {
    return chargeVersion;
  }
  public void setChargeVersion(String chargeVersion) {
    this.chargeVersion = chargeVersion;
  }
  public String getChargeMoney() {
    return chargeMoney;
  }
  public void setChargeMoney(String chargeMoney) {
    this.chargeMoney = chargeMoney;
  }
  public String getPageID() {
    return pageID;
  }
  public void setPageID(String pageID) {
    this.pageID = pageID;
  }
  public String getEformInfoID() {
    return eformInfoID;
  }
  public void setEformInfoID(String eformInfoID) {
    this.eformInfoID = eformInfoID;
  }
  public String getChargeID() {
    return chargeID;
  }
  public void setChargeID(String chargeID) {
    this.chargeID = chargeID;
  }

}