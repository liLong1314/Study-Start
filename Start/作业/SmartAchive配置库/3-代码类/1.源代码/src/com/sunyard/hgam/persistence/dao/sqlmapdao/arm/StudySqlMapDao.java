package com.sunyard.hgam.persistence.dao.sqlmapdao.arm;

import com.sunyard.hgam.persistence.dao.base.BaseSqlMapDao;
import com.ibatis.common.util.PaginatedList;
import com.ibatis.db.dao.DaoException;
import com.sunyard.hgam.persistence.dao.iface.arm.StudyDao;
import com.sunyard.hgam.persistence.dao.beans.arm.Study;

/**
 * <p>Title: 编研管理</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 胡铮
 * @version 1.0
 */

public class StudySqlMapDao
    extends BaseSqlMapDao
    implements StudyDao {

  //得到所有编研信息
  public PaginatedList getAllStudy() {
    return getAllStudy(this.PAGE_SIZE);
  }

  public PaginatedList getAllStudy(int pageSize) {
    PaginatedList list = null;
    try {
      this.startTransation();
      list = this.executeQueryForPaginatedList("getAllStudy", null, pageSize);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    return list;
  }

  //查询编研信息记录
  public PaginatedList searchStudy(Study study) {
    return searchStudy(study,this.PAGE_SIZE);
  }

  public PaginatedList searchStudy(Study study,int pageSize) {
    PaginatedList list = null;
    try {
      this.startTransation();
      list = this.executeQueryForPaginatedList("searchStudy", study, pageSize);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    return list;
  }


  //根据ID得到一条编研信息
  public Study getStudy(String studyID) {
    Study studyInfo = null;
    try {
      this.startTransation();
      studyInfo = (Study)this.executeQueryForObject("getStudyByID", studyID);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    return studyInfo;
  }

  //增加编研信息
  public int addStudy(Study study) {
    int result = 0;
    try {
      this.startTransation();
      result = this.executeUpdate("addStudy", study);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    return result;
  }

  //修改编研信息
  public int modifyStudy(Study study) {
    int result = 0;
    try {
      this.startTransation();
      result = this.executeUpdate("updateStudy", study);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    return result;
  }

  //删除编研信息
  public int delStudy(String studyId) {
    int result = 0;
    try {
      this.startTransation();
      result = this.executeUpdate("deleteStudyByID", studyId);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    return result;
  }

}
