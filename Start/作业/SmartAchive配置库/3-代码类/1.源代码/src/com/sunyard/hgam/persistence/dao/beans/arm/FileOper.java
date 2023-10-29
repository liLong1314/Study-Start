package com.sunyard.hgam.persistence.dao.beans.arm;
import java.io.*;
/**
 * <p>Title: 档案信息管理－文件部分</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 叶昊
 * @version 1.0
 */

public class FileOper implements Serializable{
  private String fileId;
  private String archivesId;
  private String fileNum;
  private String fileTitle;
  private String fileDuty;
  private String fileDate;
  private String isIdentify;
  private String identifyResult;
  private String isDestroy;
  private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
    ois.defaultReadObject();
  }
  private void writeObject(ObjectOutputStream oos) throws IOException {
    oos.defaultWriteObject();
  }
  public String getArchivesId() {
    return archivesId;
  }
  public void setArchivesId(String archivesId) {
    this.archivesId = archivesId;
  }
  public String getFileDate() {
    return fileDate;
  }
  public void setFileDate(String fileDate) {
    this.fileDate = fileDate;
  }
  public String getFileDuty() {
    return fileDuty;
  }
  public void setFileDuty(String fileDuty) {
    this.fileDuty = fileDuty;
  }
  public String getFileId() {
    return fileId;
  }
  public void setFileId(String fileId) {
    this.fileId = fileId;
  }
  public String getFileNum() {
    return fileNum;
  }
  public void setFileNum(String fileNum) {
    this.fileNum = fileNum;
  }
  public String getFileTitle() {
    return fileTitle;
  }
  public void setFileTitle(String fileTitle) {
    this.fileTitle = fileTitle;
  }
  public String getIdentifyResult() {
    return identifyResult;
  }
  public void setIdentifyResult(String identifyResult) {
    this.identifyResult = identifyResult;
  }
  public String getIsDestroy() {
    return isDestroy;
  }
  public void setIsDestroy(String isDestroy) {
    this.isDestroy = isDestroy;
  }
  public String getIsIdentify() {
    return isIdentify;
  }
  public void setIsIdentify(String isIdentify) {
    this.isIdentify = isIdentify;
  }
}