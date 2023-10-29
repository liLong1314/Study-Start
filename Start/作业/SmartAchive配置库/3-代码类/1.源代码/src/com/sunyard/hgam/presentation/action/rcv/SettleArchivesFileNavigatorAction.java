package com.sunyard.hgam.presentation.action.rcv;

import com.sunyard.hgam.presentation.base.BaseAction;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sunyard.hgam.presentation.form.adc.ArchivesForm;
import com.sunyard.hgam.presentation.form.adc.ArchivesFileForm;
import com.sunyard.hgam.persistence.dao.iface.adc.ArchivesFileDao;
import com.sunyard.hgam.persistence.dao.beans.adc.ArchivesFile;
import com.sunyard.hgam.persistence.dao.iface.adc.EformDao;
import java.util.ArrayList;

public class SettleArchivesFileNavigatorAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.
      Exception {

    //˵��������file_id��ȡ���ļ������ԣ����������߼�����
    //1������ļ���proj_id��˵�����ļ������з�eform_id����ҵ�����ļ��������Ե���
    String strForwardTo = "";
    ArchivesFileForm archivesFileForm = (ArchivesFileForm)form;

    try {
      //ȡ���ļ�ID��1. �Ӳ������ȡ �� 2.��session�л�ȡ
      String file_id = request.getParameter("file_id");
      if (file_id == null || file_id.equalsIgnoreCase("")) {
        file_id = (String) request.getSession().getAttribute("file_id");
      }

      //��ȡ�ļ���Ϣ
      ArchivesFileDao archivesFileDao = (ArchivesFileDao) domainLogic.getDAO("ArchivesFile");
      EformDao eformDao = (EformDao) domainLogic.getDAO("Eform");
      ArchivesFile archivesFile = archivesFileDao.getArchivesFileByFileID(file_id);
      archivesFileForm.setArchivesFile(archivesFile);

      if(archivesFile.getProj_id()==null || archivesFile.getProj_id().equals("")){
        //һ��������
        strForwardTo = "WENSHU";
      }else{
        //ҵ����
        strForwardTo = "YEWU";
        if (archivesFile.getEform_id() == null ||
            archivesFile.getEform_id().equalsIgnoreCase("")) {
          //�����������Ϊ��
          archivesFileForm.setEformFieldValueList(new ArrayList());
        }else {
          //�е��ӱ������ñ�ֵ�б�
          archivesFileForm.setEformFieldValueList(
              eformDao.getEformFieldValueInfoByFileId(
              archivesFile.getFile_id()));
        }
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

