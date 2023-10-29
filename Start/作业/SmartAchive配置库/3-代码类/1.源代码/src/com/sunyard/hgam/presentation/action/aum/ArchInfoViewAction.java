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
 * <p>Title: 查看变更页面</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 叶昊
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
      //修订：郑先全（20040204），增加项目概要信息的处理
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