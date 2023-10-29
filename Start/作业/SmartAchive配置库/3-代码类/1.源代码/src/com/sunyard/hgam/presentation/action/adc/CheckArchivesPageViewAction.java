package com.sunyard.hgam.presentation.action.adc;

import com.sunyard.hgam.presentation.base.BaseAction;
import java.util.*;
import com.sunyard.hgam.presentation.base.BaseAction;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.adc.*;
import com.sunyard.hgam.persistence.dao.iface.adc.*;
import com.sunyard.hgam.persistence.dao.beans.adc.*;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.presentation.base.PagedListHelper;

/**
 * <p>Title: HGAM</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author not attributable
 * @version 1.0
 */

public class CheckArchivesPageViewAction extends BaseAction {
  public CheckArchivesPageViewAction() {
  }

  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.
      Exception {
    String forwardJSP = "ShowPage";
    ArchivesPageDao pageDao = (ArchivesPageDao) domainLogic.getDAO("ArchivesPage");
    CheckArchivesPageViewForm capvForm = (CheckArchivesPageViewForm) form;
    String functionName = capvForm.getFunctionName();
    String[] selectPageID = capvForm.getSelectedPageID() ;
    capvForm.setFunctionName("");
    if (functionName.equalsIgnoreCase(""))
      functionName = "ShowPage";

    //ǰһҳ����һҳ����ת��ʾ
    String page = request.getParameter("page") ;
    if (page!=null && page.length()>0){
      PaginatedList list = (PaginatedList) request.getSession().getAttribute("queryArchivesPage");
      if (list!=null){
        PagedListHelper.pageTo(list, page);
        forwardJSP = "ShowPage";
        return (mapping.findForward(forwardJSP));
      }
    }

    if ("DeletePage".equalsIgnoreCase(functionName)) {
      //����ɾ��Ӱ��ҳ����

      if (pageDao.deleteListArchivesPageByPageID(selectPageID)>0)
        capvForm.setFunctionName("DeleteOK") ;
      else
        capvForm.setFunctionName("DeleteFailure") ;

      //������ʾҳ������
      functionName = "ShowPage";
    }
    if ("UpdatePageNum".equalsIgnoreCase(functionName)){
      //��������ҳ��

      if (pageDao.updateListArchivesPageNum(selectPageID, capvForm.getFunctionData())>0)
        capvForm.setFunctionName("UpdateOK") ;
      else
        capvForm.setFunctionName("UpdateFailure") ;

      //������ʾҳ������
      functionName = "ShowPage";
    }
    if ("UpdateFileID".equalsIgnoreCase(functionName)){
      //�������µ���״̬

      if (pageDao.updateListArchivesPageFileID(selectPageID, capvForm.getFunctionData())>0)
        capvForm.setFunctionName("UpdateOK") ;
      else
        capvForm.setFunctionName("UpdateFailure") ;

      //������ʾҳ������
      functionName = "ShowPage";
    }
    if ("UpdateStatus".equalsIgnoreCase(functionName)){
      //�������µ���״̬

      if (pageDao.updateListArchivesPageStatus(selectPageID, capvForm.getFunctionData())>0)
        capvForm.setFunctionName("UpdateOK") ;
      else
        capvForm.setFunctionName("UpdateFailure") ;

      //������ʾҳ������
      functionName = "ShowPage";
    }
    if ("UpdatePageSize".equalsIgnoreCase(functionName)){
      //�������¡�ҳ����

      if (pageDao.updateListArchivesPageSize(selectPageID, capvForm.getFunctionData())>0)
        capvForm.setFunctionName("UpdateOK") ;
      else
        capvForm.setFunctionName("UpdateFailure") ;

      //������ʾҳ������
      functionName = "ShowPage";
    }
    if ("UpdateOperator".equalsIgnoreCase(functionName)){
      //�������¡�����Ȩ�ޡ�

      if (pageDao.updateListArchivesPageOperate(selectPageID, capvForm.getFunctionData())>0)
        capvForm.setFunctionName("UpdateOK") ;
      else
        capvForm.setFunctionName("UpdateFailure") ;

      //������ʾҳ������
      functionName = "ShowPage";
    }
    if ("ShowPage".equalsIgnoreCase(functionName)) {
      //��ʾ������Ӱ��ҳ�б���

      //1.�Ӳ����л�ȡ����ID������ȡ��������
      String sArchives_ID = request.getParameter("archives_id");
      int archives_id = 0;
      try{
        archives_id = Integer.parseInt(sArchives_ID);
      }catch(Exception e){

      }
      if (archives_id==0){
        archives_id = capvForm.getArchives().getAARCHIVES_ID().intValue() ;
      }
      ArchivesDao dao = (ArchivesDao) domainLogic.getDAO("Archives");
      Archives a= dao.getArchivesByArchivesID(archives_id);
      capvForm.setArchives(a) ;

      //2.���ݵ���ID��ѯ���е�Ӱ��ҳ
      ArchivesPageDao pagedao = (ArchivesPageDao) domainLogic.getDAO(
          "ArchivesPage");
      PaginatedList pageList = pagedao.queryArchivesPageByArchivesID(
          new Integer(archives_id),
          Integer.parseInt(capvForm.getPageSize()));

      //3.ͨ�� Session.queryArchivesPage �������ݵ�ҳ��
      request.getSession().setAttribute("queryArchivesPage", pageList);

      forwardJSP = "ShowPage";
      return (mapping.findForward(forwardJSP));
    }

    return (mapping.findForward(forwardJSP));
  }

}