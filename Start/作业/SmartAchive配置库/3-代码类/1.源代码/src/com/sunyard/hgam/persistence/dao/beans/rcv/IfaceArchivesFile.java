package com.sunyard.hgam.persistence.dao.beans.rcv;

import java.io.*;

/**
 * <p>Title: HGAM</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author xuxj
 * @version 1.0
 * 修订记录：
 * 1、暂从ArchivesFile拿过来修订，只去掉Archives_id字段（郑先全，2003-12-29）
 */

public class IfaceArchivesFile implements Serializable {
  private String file_id = "";
  private String secret_id = "";
  private String file_num = "";
  private String file_title = "";
  private String file_duty = "";
  private String file_date = "";
  private String file_page_amount = "";
  private String file_type = "";
  private String file_keywords = "";
  private String file_pathName = "";
  private String file_no = "";
  private String file_store_term = "";
  private String is_identify = "";
  private String identify_result = "";
  private String is_borrow = "";
  private String is_destroy = "";
  private String remark = "";
  private String eform_id = "";
  private String phase_id = "";
  private String up_phase_id = "";
  private String parent_file_id = "";
  private String proj_id = "";
  private String proj_name = "";
  private String file_seq = "";
  private String phase_name = "";
  private String file_status = "";
  private String file_spec = "";
  private String media_type = "";
  private String file_count = "";
  private String file_get_date = "";
  private String file_get_forward = "";
  private String file_get_person = "";
  private String file_to_unit = "";
  private String file_to_forward = "";
  private String file_to_createby = "";
  private String file_to_signby = "";
  private String is_private = "";
  private String file_page_seq = "";
  public IfaceArchivesFile() {
  }
  public String getFile_id() {
    return file_id;
  }
  public void setFile_id(String file_id) {
    this.file_id = file_id;
  }
  public String getSecret_id() {
    return secret_id;
  }
  public void setSecret_id(String secret_id) {
    this.secret_id = secret_id;
  }
  public String getFile_num() {
    return file_num;
  }
  public void setFile_num(String file_num) {
    this.file_num = file_num;
  }
  public String getFile_title() {
    return file_title;
  }
  public void setFile_title(String file_title) {
    this.file_title = file_title;
  }
  public String getFile_duty() {
    return file_duty;
  }
  public void setFile_duty(String file_duty) {
    this.file_duty = file_duty;
  }
  public String getFile_date() {
    return file_date;
  }
  public void setFile_date(String file_date) {
    this.file_date = file_date;
  }
  public String getFile_page_amount() {
    return file_page_amount;
  }
  public void setFile_page_amount(String file_page_amount) {
    this.file_page_amount = file_page_amount;
  }
  public String getFile_type() {
    return file_type;
  }
  public void setFile_type(String file_type) {
    this.file_type = file_type;
  }
  public String getFile_keywords() {
    return file_keywords;
  }
  public void setFile_keywords(String file_keywords) {
    this.file_keywords = file_keywords;
  }
  public String getFile_pathName() {
    return file_pathName;
  }
  public void setFile_pathName(String file_pathName) {
    this.file_pathName = file_pathName;
  }
  public String getFile_no() {
    return file_no;
  }
  public void setFile_no(String file_no) {
    this.file_no = file_no;
  }
  public String getFile_store_term() {
    return file_store_term;
  }
  public void setFile_store_term(String file_store_term) {
    this.file_store_term = file_store_term;
  }
  public String getIs_identify() {
    return is_identify;
  }
  public void setIs_identify(String is_identify) {
    this.is_identify = is_identify;
  }
  public String getIdentify_result() {
    return identify_result;
  }
  public void setIdentify_result(String identify_result) {
    this.identify_result = identify_result;
  }
  public String getIs_borrow() {
    return is_borrow;
  }
  public void setIs_borrow(String is_borrow) {
    this.is_borrow = is_borrow;
  }
  public String getIs_destroy() {
    return is_destroy;
  }
  public void setIs_destroy(String is_destroy) {
    this.is_destroy = is_destroy;
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
  public String getEform_id() {
    return eform_id;
  }
  public void setEform_id(String eform_id) {
    this.eform_id = eform_id;
  }
  public String getPhase_id() {
    return phase_id;
  }
  public void setPhase_id(String phase_id) {
    this.phase_id = phase_id;
  }
  public String getUp_phase_id() {
    return up_phase_id;
  }
  public void setUp_phase_id(String up_phase_id) {
    this.up_phase_id = up_phase_id;
  }
  public String getParent_file_id() {
    return parent_file_id;
  }
  public void setParent_file_id(String parent_file_id) {
    this.parent_file_id = parent_file_id;
  }
  public String getProj_id() {
    return proj_id;
  }
  public void setProj_id(String proj_id) {
    this.proj_id = proj_id;
  }
  public String getProj_name() {
    return proj_name;
  }
  public void setProj_name(String proj_name) {
    this.proj_name = proj_name;
  }
  public String getFile_seq() {
    return file_seq;
  }
  public void setFile_seq(String file_seq) {
    this.file_seq = file_seq;
  }
  public String getPhase_name() {
    return phase_name;
  }
  public void setPhase_name(String phase_name) {
    this.phase_name = phase_name;
  }
  public String getFile_status() {
    return file_status;
  }
  public void setFile_status(String file_status) {
    this.file_status = file_status;
  }
  public String getFile_spec() {
    return file_spec;
  }
  public void setFile_spec(String file_spec) {
    this.file_spec = file_spec;
  }
  public String getMedia_type() {
    return media_type;
  }
  public void setMedia_type(String media_type) {
    this.media_type = media_type;
  }
  public String getFile_count() {
    return file_count;
  }
  public void setFile_count(String file_count) {
    this.file_count = file_count;
  }
  public String getFile_get_date() {
    return file_get_date;
  }
  public void setFile_get_date(String file_get_date) {
    this.file_get_date = file_get_date;
  }
  public String getFile_get_forward() {
    return file_get_forward;
  }
  public void setFile_get_forward(String file_get_forward) {
    this.file_get_forward = file_get_forward;
  }
  public String getFile_get_person() {
    return file_get_person;
  }
  public void setFile_get_person(String file_get_person) {
    this.file_get_person = file_get_person;
  }
  public String getFile_to_unit() {
    return file_to_unit;
  }
  public void setFile_to_unit(String file_to_unit) {
    this.file_to_unit = file_to_unit;
  }
  public String getFile_to_forward() {
    return file_to_forward;
  }
  public void setFile_to_forward(String file_to_forward) {
    this.file_to_forward = file_to_forward;
  }
  public String getFile_to_createby() {
    return file_to_createby;
  }
  public void setFile_to_createby(String file_to_createby) {
    this.file_to_createby = file_to_createby;
  }
  public String getFile_to_signby() {
    return file_to_signby;
  }
  public void setFile_to_signby(String file_to_signby) {
    this.file_to_signby = file_to_signby;
  }
  public String getIs_private() {
    return is_private;
  }
  public void setIs_private(String is_private) {
    this.is_private = is_private;
  }
  public String getFile_page_seq() {
    return file_page_seq;
  }
  public void setFile_page_seq(String file_page_seq) {
    this.file_page_seq = file_page_seq;
  }

}
