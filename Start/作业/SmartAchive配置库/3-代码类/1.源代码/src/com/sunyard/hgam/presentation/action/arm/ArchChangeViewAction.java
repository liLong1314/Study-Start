package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.persistence.dao.iface.arm.ArchOperDao;
import com.sunyard.hgam.persistence.dao.beans.arm.ArchOper;
import com.sunyard.hgam.presentation.form.arm.ArchOperForm;

/**
 * <p>Title: �鿴���ҳ��</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author Ҷ�
 * @version 1.0
 */

public class ArchChangeViewAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    int flag=Integer.parseInt(request.getParameter("flag"));
    String archiveId=request.getParameter("archiveId");
    ArchOperDao archOperDao=(ArchOperDao) domainLogic.getDAO("ArchOper");
    ArchOper archOperInfo=new ArchOper();
    archOperInfo=archOperDao.getOneArchive(archiveId);
    ArchOperForm newarchOperForm=new ArchOperForm();

    if(archOperInfo!=null){
      switch(flag){
        case 1://�鿴���ҳ��
          newarchOperForm.setArchOperInfo(archOperInfo);
          request.setAttribute("archOperForm",newarchOperForm);
          request.getSession().setAttribute("tmparchiveId",archiveId);
          return mapping.findForward("changeadd");
        case 2://�鿴������ϸ��Ϣ
          request.setAttribute("ArchOperInfo",archOperInfo);
          return mapping.findForward("changeinfo");
        default:
          return mapping.findForward("Failed");
      }
    }
    else{
      return mapping.findForward("Failed");
    }
  }

}