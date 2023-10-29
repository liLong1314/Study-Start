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
import com.sunyard.hgam.persistence.dao.iface.rcv.IfaceArchivesFileDao;
import java.util.ArrayList;


public class ViewIfaceArchivesFileAction extends BaseAction {

  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.Exception{

    //˵�������ݵ���ID����ʾ�õ����������ļ���Ϣ��ͬʱ��ʾ�ð�����Ϣ
    String strForwardTo = "SUCCESS";
    ArchivesFileForm archivesFileForm = (ArchivesFileForm)form;

    try {
      //ȡ���ļ�ID��1. �Ӳ������ȡ �� 2.��session�л�ȡ
      String file_id = request.getParameter("file_id");
      if (file_id == null || file_id.equalsIgnoreCase("")) {
        file_id = (String) request.getSession().getAttribute("file_id");
      }

      //��ȡ�ļ���Ϣ
      IfaceArchivesFileDao IfacearchivesFileDao = (IfaceArchivesFileDao) domainLogic.getDAO("IfaceArchivesFile");
      ArchivesFile archivesFile = IfacearchivesFileDao.getIfaceArchivesFileByFileId(file_id);
      archivesFileForm.setArchivesFile(archivesFile);

      if(archivesFile.getEform_id()==null || archivesFile.getEform_id().equalsIgnoreCase("")){
        //�޵��ӱ��������������Ϊ��
        archivesFileForm.setEformFieldValueList(new ArrayList());
      }else {
        //�е��ӱ������ñ�ֵ�б�
        archivesFileForm.setEformFieldValueList(
            IfacearchivesFileDao.getIfaceEformFieldValueInfoByFileId(
            archivesFile.getFile_id()));
      }

      request.getSession().setAttribute("ArchivesFileForm", archivesFileForm);
      request.getSession().setAttribute("file_id", file_id);
    }catch (Exception ex) {
      ex.printStackTrace();
      strForwardTo = "FAILURE";
    }finally{
      return mapping.findForward(strForwardTo);
    }
  }

}
