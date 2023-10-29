package com.sunyard.hgam.persistence.dao.iface.arm;

import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.beans.arm.Study;

/**
 * <p>Title: ���й���</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author ���
 * @version 1.0
 */

public interface StudyDao {
  public PaginatedList getAllStudy();
  public PaginatedList getAllStudy(int pageSize);
  public PaginatedList searchStudy(Study study);
  public PaginatedList searchStudy(Study study,int pageSize);
  public int addStudy(Study study);
  public Study getStudy(String studyID);
  public int modifyStudy(Study study);
  public int delStudy(String studyId);
}
