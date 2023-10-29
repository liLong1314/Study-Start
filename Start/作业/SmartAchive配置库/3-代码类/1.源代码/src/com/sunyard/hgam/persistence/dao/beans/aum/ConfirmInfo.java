package com.sunyard.hgam.persistence.dao.beans.aum;

import java.io.Serializable;

public class ConfirmInfo implements Serializable {
  private String confirmID;
  private String applyID;
  private String isAgree;
  private String confirmUserID;
  private String confirmIdea;
  private String remark;
  private String confirmDate;
  private String status;
  private long taskID;
  public String getApplyID() {
    return applyID;
  }
  public void setApplyID(String applyID) {
    this.applyID = applyID;
  }
  public String getConfirmUserID() {
    return confirmUserID;
  }
  public void setConfirmUserID(String confirmUserID) {
    this.confirmUserID = confirmUserID;
  }
  public String getConfirmIdea() {
    return confirmIdea;
  }
  public void setConfirmIdea(String confirmIdea) {
    this.confirmIdea = confirmIdea;
  }
  public String getRemark() {
    return remark;
  }
  public void setRemark(String remark) {
    this.remark = remark;
  }
  public String getConfirmDate() {
    return confirmDate;
  }
  public void setConfirmDate(String confirmDate) {
    this.confirmDate = confirmDate;
  }
  public String getConfirmID() {
    return confirmID;
  }
  public void setConfirmID(String confirmID) {
    this.confirmID = confirmID;
  }
  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }
  public String getIsAgree() {
    return isAgree;
  }
  public void setIsAgree(String isAgree) {
    this.isAgree = isAgree;
  }
  public long getTaskID() {
    return taskID;
  }
  public void setTaskID(long taskID) {
    this.taskID = taskID;
  }

}