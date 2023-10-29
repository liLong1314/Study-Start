package com.sunyard.hgam.presentation.action.adc;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.adc.ArchivesFileForm;
import com.sunyard.hgam.persistence.dao.beans.adc.ArchivesFile;
import com.sunyard.hgam.persistence.dao.iface.adc.ArchivesFileDao;
import com.sunyard.hgam.persistence.dao.beans.adc.Archives;
import java.util.List;
import java.util.ArrayList;

public class SelectReceivedFilesAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.Exception {
    //选定的文件
    String fileId[] = null;
    String strForwardTo = "SUCCESS";

    try {
      if(request.getParameterValues("file_id")!=null){
        fileId=request.getParameterValues("file_id");
      }else{
        throw new Exception("参数不对，没有指定文件编号（fileId）");
      }

      ArchivesFileForm archivesFileForm = (ArchivesFileForm) form;
      ArchivesFile archivesFile = archivesFileForm.getArchivesFile();
      String archivesId = archivesFile.getArchives_id();
      ArchivesFileDao archivesFileDao = (ArchivesFileDao)domainLogic.getDAO("ArchivesFile");

      //更新选定的文件
      List archivesFileList = new ArrayList();
      for (int i = 0; i < fileId.length; i++) {
        //初始化文件实例
        archivesFile = archivesFileDao.getArchivesFileByFileID(fileId[i]);

        //设置文件的档案属性
        archivesFile.setArchives_id(archivesId);

        //封装起来先
        archivesFileList.add(archivesFile);
      }

      //事务化更新操作
      archivesFileDao.updateReceivedArchivesFiles(archivesFileList);

    }catch (Exception ex) {
      strForwardTo = "FAILURE";
      ex.printStackTrace();
    }

    //返回
    return (mapping.findForward(strForwardTo));
  }

}