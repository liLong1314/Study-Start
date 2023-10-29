package com.sunyard.hgam.persistence.dao.sqlmapdao.arm;

import com.sunyard.hgam.persistence.dao.base.BaseSqlMapDao;
import com.ibatis.common.util.PaginatedList;
import com.ibatis.db.dao.DaoException;
import com.sunyard.hgam.persistence.dao.iface.arm.StudyDao;
import com.sunyard.hgam.persistence.dao.beans.arm.Study;

/**
 * <p>Title: ���й���</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author ���
 * @version 1.0
 */

public class StudySqlMapDao
    extends BaseSqlMapDao
    implements StudyDao {

  //�õ����б�����Ϣ
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

  //��ѯ������Ϣ��¼
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


  //����ID�õ�һ��������Ϣ
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

  //���ӱ�����Ϣ
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

  //�޸ı�����Ϣ
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

  //ɾ��������Ϣ
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
