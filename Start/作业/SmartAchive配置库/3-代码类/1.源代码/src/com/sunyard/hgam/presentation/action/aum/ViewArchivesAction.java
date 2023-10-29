package com.sunyard.hgam.presentation.action.aum;


import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.adc.ArchivesFileForm;
import com.sunyard.hgam.persistence.dao.iface.adc.ArchivesFileDao;
import com.sunyard.hgam.persistence.dao.iface.adc.EformDao;
import com.sunyard.hgam.persistence.dao.beans.adc.ArchivesFile;
import java.util.ArrayList;
import com.sunyard.hgam.persistence.dao.iface.adc.ArchivesDao;
import com.sunyard.hgam.persistence.dao.beans.adc.Archives;
import com.sunyard.hgam.presentation.form.adc.ArchivesForm;
import java.util.Map;
import java.util.HashMap;
import java.util.List;


public class ViewArchivesAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.
      Exception {

    String strForwardTo = "";
    ArchivesForm archivesForm = (ArchivesForm)form;

    try {
      //取得档案ID：1. 从参数表获取 ， 2.从session中获取
      String archives_id = request.getParameter("ARCHIVES_ID");
      if (archives_id == null || archives_id.equalsIgnoreCase("")) {
        archives_id = String.valueOf(request.getSession().getAttribute("ARCHIVES_ID"));
      }

      //获取档案信息
      ArchivesDao archivesDao = (ArchivesDao) domainLogic.getDAO("Archives");
      Archives archives = archivesDao.getArchivesByArchivesID((new Integer(archives_id)).intValue());
      archivesForm.setArchives(archives);

      if(archives.getAROLL_MODE().equals("1")){
        //案卷
        if (archives.getAIS_OPERATION() == null ||
            archives.getAIS_OPERATION().equals("0")) {
          //一般文书类
          strForwardTo = "WENSHU";
        }else if(archives.getAIS_OPERATION().equals("1")){
          //业务类
          strForwardTo = "YEWU";
          //修订：郑先全（20040204），增加项目概要信息的处理
          //begin
          String projId = archives.getAPROJ_ID();
          if (archives.getAIS_OPERATION().equals("1") && projId != null &&
              !projId.equals("")) {
            Map projIdMap = new HashMap();
            projIdMap.put("projId", projId);
            EformDao eformDao = (EformDao) domainLogic.getDAO("Eform");
            List list = eformDao.getProjBriefByProjId(projIdMap);
            request.setAttribute("ProjBriefList", list);
          }
        }else{
          //其他类
          strForwardTo = "OTHER";
        }
      }else{
        //件
          strForwardTo = "PIECE";
      }

      request.setAttribute("ArchivesForm", archivesForm);
      request.getSession().setAttribute("ARCHIVES_ID", archives_id);
    }catch (Exception ex) {
      ex.printStackTrace();
      strForwardTo = "FAILURE";
    }finally{
      return mapping.findForward(strForwardTo);
    }
  }

}