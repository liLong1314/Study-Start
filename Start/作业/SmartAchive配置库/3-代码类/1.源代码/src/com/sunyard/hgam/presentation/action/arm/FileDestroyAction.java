package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.arm.DestroyForm;
import com.sunyard.hgam.persistence.dao.iface.arm.FileOperDao;
import com.sunyard.hgam.persistence.dao.iface.arm.DestroyDao;

/**
 * <p>Title: 档案文件销毁</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 叶昊
 * @version 1.0
 */

public class FileDestroyAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    DestroyForm destroyForm = (DestroyForm) form;
    FileOperDao fileOperDao = (FileOperDao) domainLogic.getDAO("FileOper");
    DestroyDao destroyDao = (DestroyDao) domainLogic.getDAO("Destroy");
    String[] filelist = destroyForm.getDestroyInfo().getFilelist();
    int filelength = filelist.length;
    for (int i = 0; i < filelist.length; i++) {
      destroyForm.getDestroyInfo().setFileId(filelist[i]);
      fileOperDao.updateDestroyFile(destroyForm.getDestroyInfo());
     // destroyDao.addDestory(destroyForm.getDestroyInfo());
    }

    return mapping.findForward("success");
  }

}