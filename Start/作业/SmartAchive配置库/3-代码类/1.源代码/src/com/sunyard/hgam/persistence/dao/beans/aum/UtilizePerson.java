package com.sunyard.hgam.persistence.dao.beans.aum;

import java.io.Serializable;

/**
 * <p>Title: HGAM</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author not attributable
 * @version 1.0
 */

public class UtilizePerson
    implements Serializable {

  private String person_id = "";
  private String person_name = "";
  private String person_corp = "";
  private String person_tel = "";
  private String person_address = "";
  private String certificate_type = "";
  private String certificate_num = "";
  private String remark = "";

  public UtilizePerson() {
  }

  public String getCertificate_num() {
    return certificate_num;
  }

  public String getCertificate_type() {
    return certificate_type;
  }

  public String getPerson_address() {
    return person_address;
  }

  public String getPerson_corp() {
    return person_corp;
  }

  public String getPerson_id() {
    return person_id;
  }

  public String getPerson_name() {
    return person_name;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public void setPerson_tel(String person_tel) {
    this.person_tel = person_tel;
  }

  public void setPerson_name(String person_name) {
    this.person_name = person_name;
  }

  public void setPerson_id(String person_id) {
    this.person_id = person_id;
  }

  public void setPerson_corp(String person_corp) {
    this.person_corp = person_corp;
  }

  public void setPerson_address(String person_address) {
    this.person_address = person_address;
  }

  public void setCertificate_type(String certificate_type) {
    this.certificate_type = certificate_type;
  }

  public void setCertificate_num(String certificate_num) {
    this.certificate_num = certificate_num;
  }

  public String getPerson_tel() {
    return person_tel;
  }

}