package com.sunyard.hgam.presentation.action.adc;

import com.sunyard.hgam.presentation.base.BaseAction;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.presentation.form.adc.QueryArchivesViewForm;
import com.sunyard.hgam.persistence.dao.beans.adc.Archives;
import com.sunyard.hgam.persistence.dao.beans.adc.ArchivesPage;
import com.sunyard.hgam.presentation.base.PagedListHelper;
import com.sunyard.hgam.persistence.dao.iface.adc.ArchivesDao;
import com.sunyard.hgam.persistence.dao.iface.adc.ArchivesFileDao;
import com.sunyard.hgam.persistence.dao.iface.adc.ArchivesPageDao;
import java.util.List;

/**
 * <p>Title: HGAM</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author not attributable
 * @version 1.0
 */

public class QueryArchivesViewAction extends BaseAction {
  public QueryArchivesViewAction() {
  }

  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.Exception{
    String forwardJSP = "QueryAllArchives";
    QueryArchivesViewForm qavfForm = (QueryArchivesViewForm) form;
    String functionName = qavfForm.getFunctionName();
    String sRollMode = qavfForm.getArchives().getAROLL_MODE() ;
    qavfForm.setFunctionName("");
    PaginatedList archivesList = null;
    ArchivesDao adao = (ArchivesDao) domainLogic.getDAO("Archives");
    ArchivesPageDao apdao = (ArchivesPageDao) domainLogic.getDAO("ArchivesPage");

    //ǰһҳ����һҳ����ת��ʾ
    String page = request.getParameter("page") ;
    if (page!=null && page.length()>0){
      archivesList = (PaginatedList) request.getSession().getAttribute("queryAllArchives");
      if (archivesList!=null){
        PagedListHelper.pageTo(archivesList, page);
        forwardJSP = "QueryAllArchives";
        return (mapping.findForward(forwardJSP));
      }
    }

    //���鵵���ܡ� ==> �鵵
    if ("Roll".equalsIgnoreCase(functionName)) {
      if (qavfForm.getSelectID()!=null){
        for (int i = 0; i < qavfForm.getSelectID().length; i++) {
          List lst = null;
          String archives_id = qavfForm.getSelectID()[i];
          Archives a = new Archives();
          a.setAARCHIVES_ID(new Integer(archives_id));

          /*
          //1.�жϸõ����Ƿ���Ӱ��ҳ
          int nPageCount = apdao.getPageCountByArchivesID(new Integer(
              archives_id));
          if (nPageCount < 1) {
            a.setAARCHIVES_STATUS("2"); //�õ���û�е���ҳ
            adao.updateArchivesStatusByArchivesID(a);
            continue;
          }
          */

          //2.�ж��Ƿ��������ͬ��ҳ��
          lst = apdao.queryConflictPageNum(archives_id);
          if (lst != null)
            if (lst.size() > 0) {
              a.setAARCHIVES_STATUS("3"); //����ҳ��������ͬ��ҳ��
              adao.updateArchivesStatusByArchivesID(a);
              continue;
            }

          //3.�ж��Ƿ���δͨ������Ӱ��ҳ
          lst = apdao.queryArchivesPageNotPass(archives_id);
          if (lst != null)
            if (lst.size() > 0) {
              a.setAARCHIVES_STATUS("4"); //����ҳ�����С�δͨ����顱��Ӱ��ҳ
              adao.updateArchivesStatusByArchivesID(a);
              continue;
            }
          //4.����鵵
          a.setAARCHIVES_STATUS("1"); //�ѹ鵵
          adao.updateArchivesStatusByArchivesID(a);
        }
      }

      //���³ɹ���������ʾҳ��
      functionName = "QueryAllArchives";
    }

    //�����������ܡ� ==> δ�鵵
    if ("UnRoll".equalsIgnoreCase(functionName)) {
      if (qavfForm.getSelectID()!=null){
        for (int i = 0; i < qavfForm.getSelectID().length; i++) {
          String archives_id = qavfForm.getSelectID()[i];
          Archives a = new Archives();
          a.setAARCHIVES_ID(new Integer(archives_id));
          a.setAARCHIVES_STATUS("0"); //δ�鵵
          adao.updateArchivesStatusByArchivesID(a);
        }
      }

      //���³ɹ���������ʾҳ��
      functionName = "QueryAllArchives";
    }

    //����ѯ���ܡ�
    if ("QueryAllArchives".equalsIgnoreCase(functionName)) {
      archivesList = (PaginatedList) request.getAttribute("queryAllArchives");

      Archives archives = qavfForm.getArchives();
      //����
      String archivesNum = archives.getAARCHIVES_NUM();
      if (!archivesNum.equalsIgnoreCase("")){
        archives.setAARCHIVES_NUM("%" + archivesNum + "%") ;
      }
      //��������
      String archivesName = qavfForm.getArchives().getAARCHIVES_NAME();
      if (!archivesName.equalsIgnoreCase("")){
        archives.setAARCHIVES_NAME("%" + archivesName + "%") ;
      }

      archivesList = adao.queryArchivesListCheck(archives,
          Integer.parseInt(qavfForm.getPageSize()));

      //ͨ�� Session.queryArchivesRoll �������ݵ�ҳ��
      request.getSession().setAttribute("queryAllArchives", archivesList);
      archives.setAARCHIVES_NUM(archivesNum) ;
      archives.setAARCHIVES_NAME(archivesName) ;

      forwardJSP = "QueryAllArchives";
      return (mapping.findForward(forwardJSP));
    }

    return (mapping.findForward(forwardJSP));
  }

}