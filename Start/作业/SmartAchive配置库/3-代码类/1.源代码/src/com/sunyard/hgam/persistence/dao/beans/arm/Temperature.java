package com.sunyard.hgam.persistence.dao.beans.arm;

import java.io.*;
/**
 * <p>Title: 温湿度管理</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 叶昊
 * @version 1.0
 */

public class Temperature implements Serializable{
  private String temperatureId;
  private String roomCode;
  private String temperatureDegree;
  private String temperatureWet;
  private String temperatureDate;
  private String temDateFrom;
  private String temDateTo;
  private String temperatureMan;
  private String remark;
  private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
    ois.defaultReadObject();
  }
  private void writeObject(ObjectOutputStream oos) throws IOException {
    oos.defaultWriteObject();
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
  public String getTemperatureDate() {
    return temperatureDate;
  }
  public void setTemperatureDate(String temperatureDate) {
    this.temperatureDate = temperatureDate;
  }
  public String getTemperatureDegree() {
    return temperatureDegree;
  }
  public void setTemperatureDegree(String temperatureDegree) {
    this.temperatureDegree = temperatureDegree;
  }
  public String getTemperatureId() {
    return temperatureId;
  }
  public void setTemperatureId(String temperatureId) {
    this.temperatureId = temperatureId;
  }
  public String getTemperatureWet() {
    return temperatureWet;
  }
  public void setTemperatureWet(String temperatureWet) {
    this.temperatureWet = temperatureWet;
  }
  public String getTemperatureMan() {
    return temperatureMan;
  }
  public void setTemperatureMan(String temperatureMan) {
    this.temperatureMan = temperatureMan;
  }
  public String getTemDateFrom() {
    return temDateFrom;
  }
  public void setTemDateFrom(String temDateFrom) {
    this.temDateFrom = temDateFrom;
  }
  public String getTemDateTo() {
    return temDateTo;
  }
  public void setTemDateTo(String temDateTo) {
    this.temDateTo = temDateTo;
  }
}