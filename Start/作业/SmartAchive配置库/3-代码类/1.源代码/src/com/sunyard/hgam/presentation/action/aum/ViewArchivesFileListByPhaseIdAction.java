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
import com.sunyard.hgam.persistence.dao.beans.adc.ArchivesFile;
import java.util.List;
import com.sunyard.hgam.presentation.base.SysParamOper;
import com.sunyard.hgam.persistence.dao.beans.arm.Secret;
import com.sunyard.hgam.persistence.dao.iface.arm.SecretDao;
import com.sunyard.hgam.domain.logic.DomainLogic;
import com.sunyard.hgam.presentation.base.PagedListHelper;

public class ViewArchivesFileListByPhaseIdAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.
      Exception {

    String strForwardTo = "SUCCESS";
    String page = request.getParameter("page");
    PaginatedList archivesFilesList = null;
    ArchivesFileForm archivesFileForm = (ArchivesFileForm) form;

    //ȡ���ļ����ڵ���ID��1. �Ӳ������ȡ �� 2.��session�л�ȡ
    String archives_id = request.getParameter("ARCHIVES_ID");
    if (archives_id == null || archives_id.equalsIgnoreCase("")) {
      archives_id = (String) request.getSession().getAttribute("ARCHIVES_ID");
    }
    //ȡ�ý׶�ID��1. �Ӳ������ȡ �� 2.��session�л�ȡ
    String phase_id = request.getParameter("PHASE_ID");
    if (phase_id == null || phase_id.equalsIgnoreCase("")) {
      phase_id = (String) request.getSession().getAttribute("PHASE_ID");
    }

    try {
      //��ȡ������Ϣ
      ArchivesDao archivesDao = (ArchivesDao) domainLogic.getDAO("Archives");
      Archives archives = archivesDao.getArchivesByArchivesID(Integer.parseInt(
          archives_id));
      //�޶���֣��ȫ��2004��1��16
      //���ã�������λ �ܼ� ��������
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
      request.setAttribute("ArchivesFileForm", archivesFileForm);

      //���ӷ�ҳ����
      archivesFilesList = (PaginatedList) request.getSession().getAttribute(
          "archivesFilesList");
      if (archivesFilesList == null || page == null) {
        //
        ArchivesFileDao archivesFileDao = (ArchivesFileDao) domainLogic.getDAO(
            "ArchivesFile");
        ArchivesFile archivesFile = new ArchivesFile();
        archivesFile.setArchives_id(archives_id);
        archivesFile.setPhase_id(phase_id);
        //�޶���֣��ȫ��20040308������ʾ�������е����ý׶ε��ļ��б�
        archivesFile.setProj_id(archives.getAPROJ_ID());

        //��ȡ�����ļ��б�
        archivesFilesList = archivesFileDao.queryArchivesFileByPhaseID(
            archivesFile);
        //����SESSION
        request.getSession().setAttribute("archivesFilesList", archivesFilesList);
        request.getSession().setAttribute("ARCHIVES_ID", archives_id);
        request.getSession().setAttribute("PHASE_ID", phase_id);
      }else {
        PagedListHelper.pageTo(archivesFilesList, page);
      }
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