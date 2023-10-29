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

    //˵�������ݵ���ID����ʾ�õ����������ļ���Ϣ��ͬʱ��ʾ�ð�����Ϣ

    String strForwardTo = "";
    PaginatedList archivesFilesList = null;
    String archivesFileTree = "";
    String page = request.getParameter("page");
    ArchivesFileForm archivesFileForm = (ArchivesFileForm) form;

    try {
      //ȡ�õ���ID��1. �Ӳ������ȡ �� 2.��session�л�ȡ
      String archives_id = request.getParameter("ARCHIVES_ID");
      if (archives_id == null || archives_id.equalsIgnoreCase("")) {
        archives_id = String.valueOf(request.getSession().getAttribute(
            "ARCHIVES_ID"));
      }

      //��ȡ������Ϣ
      ArchivesDao archivesDao = (ArchivesDao) domainLogic.getDAO("Archives");
      ArchivesFileDao archivesFileDao = (ArchivesFileDao) domainLogic.getDAO(
          "ArchivesFile");
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
      if (archives.getAIS_OPERATION().equalsIgnoreCase("0")) {
        //������
        strForwardTo = "WENSHU";
        //��ȡ�����ļ��б�
        archivesFilesList = (PaginatedList) request.getSession().getAttribute("archivesFilesList");
        if(archivesFilesList==null || page==null){
          archivesFilesList = archivesFileDao.queryArchivesFileByArchivesID(archives_id);
        }else{
          PagedListHelper.pageTo(archivesFilesList, page);
        }

        //����SESSION
        request.getSession().setAttribute("archivesFilesList",
                                          archivesFilesList);
      }else if (archives.getAIS_OPERATION().equalsIgnoreCase("1")) {
        //ҵ����
        strForwardTo = "YEWU";
        //��ȡ�����ļ��ṹ��
        //archivesFileTree = Tree.getArchivesProjPhaseTree(archives,archivesFileDao,"1");
        //��ȡ��Ŀ�ļ��ṹ��
        archivesFileTree = Tree.getAllProjPhaseTree(archives, archivesFileDao);

        //����SESSION
        request.setAttribute("archivesFilesList", archivesFileTree);
      }else{
        //������
        strForwardTo = "OTHER";
        //��ȡ�����ļ��б�
        archivesFilesList = (PaginatedList) request.getSession().getAttribute("archivesFilesList");
        if(archivesFilesList==null || page==null){
          archivesFilesList = archivesFileDao.queryArchivesFileByArchivesID(archives_id);
        }else{
          PagedListHelper.pageTo(archivesFilesList, page);
        }
        //����SESSION
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