package com.sunyard.hgam.presentation.form.arm;

import com.sunyard.hgam.presentation.base.BaseForm;
import com.sunyard.hgam.persistence.dao.beans.arm.FileOper;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>Title: ������Ϣ����-�ļ�����</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author Ҷ�
 * @version 1.0
 */

public class FileOperForm extends BaseForm {
  private FileOper fileOperInfo = new FileOper();
  public FileOper getFileOperInfo() {
    return fileOperInfo;
  }
  public void setFileOperInfo(FileOper fileOperInfo) {
    this.fileOperInfo = fileOperInfo;
  }
  public void reset(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {
  }

}