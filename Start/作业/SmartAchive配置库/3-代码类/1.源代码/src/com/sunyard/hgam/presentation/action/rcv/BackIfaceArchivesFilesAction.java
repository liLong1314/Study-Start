package com.sunyard.hgam.presentation.action.rcv;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.presentation.form.adc.ArchivesFileForm;
import com.sunyard.hgam.persistence.dao.beans.adc.ArchivesFile;
import com.sunyard.hgam.persistence.dao.iface.rcv.IfaceArchivesFileDao;


public class BackIfaceArchivesFilesAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.Exception {

    //选定的文件
    String fileIds = request.getParameter("fileIds2");

    try {
      if(fileIds==null || fileIds.equals("")){
        throw new Exception("参数不对，没有指定文件编号（fileId）");
      }

      ArchivesFileForm archivesFileForm = (ArchivesFileForm) form;
      ArchivesFile archivesFile = null;
      IfaceArchivesFileDao ifaceArchivesFileDao = (IfaceArchivesFileDao)
          domainLogic.getDAO("IfaceArchivesFile");

      //退回指定的所有文件：更新状态为“已退回－3”
      ifaceArchivesFileDao.updateIfaceArchivesFileStatusToBackByFileIds(fileIds);

    }catch (Exception ex) {
      ex.printStackTrace();
    }

    //返回
    return (mapping.findForward("SUCCESS"));
  }
}
