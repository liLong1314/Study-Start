package com.sunyard.hgam.persistence.dao.beans.arm;

import java.io.*;

/**
 * <p>Title: 档案装具管理</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 叶昊
 * @version 1.0
 */

public class Contain implements Serializable{
  private String containId;
  private String containType;
  private String containCode;
  private String containCodeFrom;
  private String containCodeTo;
  private String containRow;
  private String containRowFrom;
  private String containRowTo;
  private String containSide;
  private String containColumn;
  private String containColumnFrom;
  private String containColumnTo;
  private String remark;
  private String roomCode;
  private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
    ois.defaultReadObject();
  }
  private void writeObject(ObjectOutputStream oos) throws IOException {
    oos.defaultWriteObject();
  }
  public String getContainCode() {
    return containCode;
  }
  public void setContainCode(String containCode) {
    this.containCode = containCode;
  }
  public String getContainCodeFrom() {
    return containCodeFrom;
  }
  public void setContainCodeFrom(String containCodeFrom) {
    this.containCodeFrom = containCodeFrom;
  }
  public String getContainCodeTo() {
    return containCodeTo;
  }
  public void setContainCodeTo(String containCodeTo) {
    this.containCodeTo = containCodeTo;
  }
  public String getContainColumn() {
    return containColumn;
  }
  public void setContainColumn(String containColumn) {
    this.containColumn = containColumn;
  }
  public String getContainColumnFrom() {
    return containColumnFrom;
  }
  public void setContainColumnFrom(String containColumnFrom) {
    this.containColumnFrom = containColumnFrom;
  }
  public String getContainColumnTo() {
    return containColumnTo;
  }
  public void setContainColumnTo(String containColumnTo) {
    this.containColumnTo = containColumnTo;
  }
  public String getContainId() {
    return containId;
  }
  public void setContainId(String containId) {
    this.containId = containId;
  }
  public String getContainRow() {
    return containRow;
  }
  public void setContainRow(String containRow) {
    this.containRow = containRow;
  }
  public String getContainRowFrom() {
    return containRowFrom;
  }
  public void setContainRowFrom(String containRowFrom) {
    this.containRowFrom = containRowFrom;
  }
  public String getContainRowTo() {
    return containRowTo;
  }
  public void setContainRowTo(String containRowTo) {
    this.containRowTo = containRowTo;
  }
  public String getContainSide() {
    return containSide;
  }
  public void setContainSide(String containSide) {
    this.containSide = containSide;
  }
  public String getContainType() {
    return containType;
  }
  public void setContainType(String containType) {
    this.containType = containType;
  }
  public String getRemark() {
    return remark;
  }
  public void setRemark(String remark) {
    this.remark = remark;
  }
  public String getRoomCode() {
    return roomCode;
  }
  public void setRoomCode(String roomCode) {
    this.roomCode = roomCode;
  }
}