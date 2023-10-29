package com.sunyard.hgam.presentation.action.aum;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.persistence.dao.iface.arm.ArchOperDao;
import com.sunyard.hgam.persistence.dao.beans.arm.ArchOper;
import com.sunyard.hgam.presentation.form.arm.ArchOperForm;
import com.sunyard.hgam.persistence.dao.iface.adc.EformDao;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

/**
 * <p>Title: �鿴���ҳ��</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author Ҷ�
 * @version 1.0
 */

public class ArchInfoViewAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    String archiveId=request.getParameter("archiveId");
    ArchOperDao archOperDao=(ArchOperDao) domainLogic.getDAO("ArchOper");
    ArchOper archOperInfo=new ArchOper();
    archOperInfo=archOperDao.getOneArchive(archiveId);

    if (archOperInfo != null) {
      //�޶���֣��ȫ��20040204����������Ŀ��Ҫ��Ϣ�Ĵ���
      //begin
      String projId = archOperInfo.getProjId();
      if(archOperInfo.getIsOperation().equals("1") && projId!=null && !projId.equals("")){
        Map projIdMap = new HashMap();
        projIdMap.put("projId", projId);
        EformDao eformDao=(EformDao) domainLogic.getDAO("Eform");
        List list = eformDao.getProjBriefByProjId(projIdMap);
        request.setAttribute("ProjBriefList", list);
      }
      //end
      request.setAttribute("ArchOperInfo", archOperInfo);
      return mapping.findForward("success");
    }
    else {
      return mapping.findForward("Failed");
    }
  }

}