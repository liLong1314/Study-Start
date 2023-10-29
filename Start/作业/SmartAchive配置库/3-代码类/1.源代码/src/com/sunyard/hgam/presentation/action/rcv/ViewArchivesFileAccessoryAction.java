package com.sunyard.hgam.presentation.action.rcv;

import com.sunyard.hgam.presentation.base.BaseAction;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sunyard.hgam.presentation.form.adc.ArchivesFileForm;
import com.sunyard.hgam.persistence.dao.iface.adc.ArchivesFileDao;
import com.sunyard.hgam.persistence.dao.beans.adc.ArchivesFile;
import com.sunyard.hgam.util.common.FileUtil;


public class ViewArchivesFileAccessoryAction extends BaseAction {

  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.Exception{

    String strForwardTo = "SUCCESS";

    try {
      String filePathName = request.getParameter("filePathName");
      if (filePathName == null || filePathName.equalsIgnoreCase("")) {
        response.getWriter().println("错误：文件路径参数没有提供！");
      }

      String ftpPathName = FileUtil.viewFileByPathName(filePathName);
      System.out.println(ftpPathName);

      response.sendRedirect(ftpPathName);

    }catch (Exception ex) {
      ex.printStackTrace();
      response.getWriter().println("错误：查看文件过程中发现错误，请确认文件是否存在！");
      strForwardTo = "FAILURE";
    }

    return null;
  }

}
