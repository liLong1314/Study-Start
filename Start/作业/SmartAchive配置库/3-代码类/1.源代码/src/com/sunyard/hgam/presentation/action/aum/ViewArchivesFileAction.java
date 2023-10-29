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

public class ViewArchivesFileAction extends BaseAction {
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

      //��ȡ������Ϣ
      ArchivesDao archivesDao = (ArchivesDao) domainLogic.getDAO("Archives");
      Archives archives = archivesDao.getArchivesByArchivesID((new Integer(archivesFile.getArchives_id())).intValue());
      archivesFileForm.setArchives(archives);

      //�޶���֣��ȫ��20040226�������������ˡ�2������������Ŀ���ͣ��ʱ���Ҫ�޶��߼�
      if (archives.getAIS_OPERATION().trim().equals("0")) {
        //������
        strForwardTo = "WENSHU";
      }else if (archives.getAIS_OPERATION().trim().equals("1")) {
        //ҵ����
        strForwardTo = "YEWU";
        if (archivesFile.getEform_id() == null ||
            archivesFile.getEform_id().equalsIgnoreCase("")) {
          //�����������Ϊ��
          archivesFileForm.setEformFieldValueList(new ArrayList());
        }
        else {
          //�е��ӱ������ñ�ֵ�б�
          archivesFileForm.setEformFieldValueList(
              eformDao.getEformFieldValueInfoByFileId(
              archivesFile.getFile_id()));
        }
      }else if (archives.getAIS_OPERATION().trim().equals("2")) {
        //������
        strForwardTo = "OTHER";

        if (archivesFile.getEform_id() == null ||
            archivesFile.getEform_id().equalsIgnoreCase("")) {
          //�����������Ϊ��
          archivesFileForm.setEformFieldValueList(new ArrayList());
        }
        else {
          //�е��ӱ������ñ�ֵ�б�
          archivesFileForm.setEformFieldValueList(
              eformDao.getEformFieldValueInfoByFileId(
              archivesFile.getFile_id()));
        }
      }

      request.setAttribute("ArchivesFileForm", archivesFileForm);
      request.getSession().setAttribute("file_id", file_id);
    }catch (Exception ex) {
      ex.printStackTrace();
      strForwardTo = "FAILURE";
    }finally{
      return mapping.findForward(strForwardTo);
    }
  }

}