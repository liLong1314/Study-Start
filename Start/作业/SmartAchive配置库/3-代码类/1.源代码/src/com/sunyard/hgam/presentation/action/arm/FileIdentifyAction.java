package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.arm.IdentifyForm;
import com.sunyard.hgam.persistence.dao.iface.arm.FileOperDao;
import com.sunyard.hgam.persistence.dao.iface.arm.IdentifyDao;

/**
 * <p>Title: 文件鉴定</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 叶昊
 * @version 1.0
 */

public class FileIdentifyAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    IdentifyForm identifyForm = (IdentifyForm) form;
    FileOperDao fileOperDao = (FileOperDao) domainLogic.getDAO("FileOper");
    IdentifyDao identifyDao = (IdentifyDao) domainLogic.getDAO("Identify");
    String[] filelist=identifyForm.getIdentifyInfo().getFilelist();
    int filelength=filelist.length;
    for(int i=0;i<filelist.length;i++){
      identifyForm.getIdentifyInfo().setFileId(filelist[i]);
      fileOperDao.updateIdentFile(identifyForm.getIdentifyInfo());
//      identifyDao.addIdentify(identifyForm.getIdentifyInfo());
    }
    return mapping.findForward("success");
  }

}