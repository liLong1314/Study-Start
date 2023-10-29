package com.sunyard.hgam.presentation.action.aum;

import com.sunyard.hgam.presentation.base.BaseAction;
import org.apache.struts.action.ActionMapping;
import com.ibatis.common.util.PaginatedList;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sunyard.hgam.persistence.dao.iface.adc.ArchivesFileDao;
import com.sunyard.hgam.presentation.form.adc.ArchivesForm;
import com.sunyard.hgam.persistence.dao.iface.adc.ArchivesDao;
import com.sunyard.hgam.persistence.dao.beans.adc.Archives;
import com.sunyard.hgam.util.adc.Tree;
import com.sunyard.hgam.presentation.form.adc.ArchivesFileForm;
import com.sunyard.hgam.presentation.base.SysParamOper;
import com.sunyard.hgam.persistence.dao.iface.arm.SecretDao;
import com.sunyard.hgam.domain.logic.DomainLogic;
import com.sunyard.hgam.persistence.dao.beans.arm.Secret;
import com.sunyard.hgam.presentation.base.PagedListHelper;

public class ViewArchivesFileListAction
    extends BaseAction {

  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.
      Exception {

    //说明：根据档案ID，显示该档案的所有文件信息，同时显示该案卷信息

    String strForwardTo = "";
    PaginatedList archivesFilesList = null;
    String archivesFileTree = "";
    String page = request.getParameter("page");
    ArchivesFileForm archivesFileForm = (ArchivesFileForm) form;

    try {
      //取得档案ID：1. 从参数表获取 ， 2.从session中获取
      String archives_id = request.getParameter("ARCHIVES_ID");
      if (archives_id == null || archives_id.equalsIgnoreCase("")) {
        archives_id = String.valueOf(request.getSession().getAttribute(
            "ARCHIVES_ID"));
      }

      //获取档案信息
      ArchivesDao archivesDao = (ArchivesDao) domainLogic.getDAO("Archives");
      ArchivesFileDao archivesFileDao = (ArchivesFileDao) domainLogic.getDAO(
          "ArchivesFile");
      Archives archives = archivesDao.getArchivesByArchivesID(Integer.parseInt(
          archives_id));
      //修订：郑先全，2004－1－16
      //设置：立档单位 密级 保管期限
      SysParamOper sysParamOper = SysParamOper.getInstance();
      archives.setAARCHIVES_FOUND_UNIT(sysParamOper.getSysParamName(
          "ARCHIVES_FOUND_UNIT", archives.getAARCHIVES_FOUND_UNIT()));
      archives.setASTORE_TERM(sysParamOper.getSysParamName("ArchiveStore",
          archives.getASTORE_TERM()));
      SecretDao secretDao = (SecretDao) DomainLogic.getInstance().getDAO(
          "Secret");
      if (archives.getASECRET_ID() != null) {
        Secret secret = secretDao.getSecret(archives.getASECRET_ID());
        if (secret != null)
          archives.setASECRET_ID(secret.getSecretName());
      }

      archivesFileForm.setArchives(archives);
      if (archives.getAIS_OPERATION().equalsIgnoreCase("0")) {
        //文书类
        strForwardTo = "WENSHU";
        //获取档案文件列表
        archivesFilesList = (PaginatedList) request.getSession().getAttribute("archivesFilesList");
        if(archivesFilesList==null || page==null){
          archivesFilesList = archivesFileDao.queryArchivesFileByArchivesID(archives_id);
        }else{
          PagedListHelper.pageTo(archivesFilesList, page);
        }

        //设置SESSION
        request.getSession().setAttribute("archivesFilesList",
                                          archivesFilesList);
      }else if (archives.getAIS_OPERATION().equalsIgnoreCase("1")) {
        //业务类
        strForwardTo = "YEWU";
        //获取档案文件结构树
        //archivesFileTree = Tree.getArchivesProjPhaseTree(archives,archivesFileDao,"1");
        //获取项目文件结构树
        archivesFileTree = Tree.getAllProjPhaseTree(archives, archivesFileDao);

        //设置SESSION
        request.setAttribute("archivesFilesList", archivesFileTree);
      }else{
        //其他类
        strForwardTo = "OTHER";
        //获取档案文件列表
        archivesFilesList = (PaginatedList) request.getSession().getAttribute("archivesFilesList");
        if(archivesFilesList==null || page==null){
          archivesFilesList = archivesFileDao.queryArchivesFileByArchivesID(archives_id);
        }else{
          PagedListHelper.pageTo(archivesFilesList, page);
        }
        //设置SESSION
        request.getSession().setAttribute("archivesFilesList", archivesFilesList);
      }

      request.setAttribute("ArchivesFileForm", archivesFileForm);
      request.getSession().setAttribute("ARCHIVES_ID", archives_id);
    }
    catch (Exception ex) {
      ex.printStackTrace();
      strForwardTo = "FAILURE";
    }
    finally {
      return mapping.findForward(strForwardTo);
    }
  }

}