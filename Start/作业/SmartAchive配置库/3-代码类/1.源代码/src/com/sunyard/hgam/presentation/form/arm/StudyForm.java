package com.sunyard.hgam.presentation.form.arm;

import com.sunyard.hgam.presentation.base.*;
import com.sunyard.hgam.persistence.dao.beans.arm.Study;
import org.apache.struts.action.*;
import javax.servlet.http.*;

/**
 * <p>Title: ���й���</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author ���
 * @version 1.0
 */

public class StudyForm extends BaseForm {
  private Study studyInfo = new Study();
  public Study getStudyInfo() {
    return studyInfo;
  }
  public void setStudyInfo(Study studyInfo) {
    this.studyInfo = studyInfo;
  }
  public void reset(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {
  }
}