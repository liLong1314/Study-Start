package com.sunyard.hgam.presentation.action.aum;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.ibatis.common.util.PaginatedList;
import java.util.HashMap;
import com.sunyard.hgam.presentation.form.aum.SelectArchivesFileForm;

import com.sunyard.hgam.persistence.dao.beans.adc.*;
import com.sunyard.hgam.persistence.dao.iface.adc.*;

import com.sunyard.hgam.persistence.dao.beans.aum.UtilizeDetail;
import com.sunyard.hgam.persistence.dao.iface.aum.UtilizeDetailDao;

import com.ibatis.common.util.PaginatedList;
import java.util.List;
import com.sunyard.hgam.persistence.dao.beans.aum.ArchivesPageCharge;
/**
 * <p>Title: HGAM</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author not attributable
 * @version 1.0
 */

public class SelectArchivesFileAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws Exception{
    String forward="ShowSuccess";
    SelectArchivesFileForm safForm = (SelectArchivesFileForm)form;
    String functionName = safForm.getFunctionName() ;
    String apply_id= (String)request.getSession().getAttribute("ADD_apply_id");
    String archives_id= (String)request.getSession().getAttribute("archives_id");
    if (functionName.equalsIgnoreCase(""))
      functionName="ShowAllFiles";

    if (functionName.equalsIgnoreCase("Save")){
      UtilizeDetailDao udDao = (UtilizeDetailDao)domainLogic.getDAO("UtilizeDetail");
      if (safForm.getSelectID()!=null)
      for(int i=0;i<safForm.getSelectID().length; i++){
        String file_id = safForm.getSelectID()[i];
        List list_page = udDao.queryPageChargeByFileID(file_id);
        for(int j=0; j<list_page.size(); j++){
          ArchivesPageCharge ap = (ArchivesPageCharge)list_page.get(j);
          UtilizeDetail ud = new UtilizeDetail();
          ud.setApply_id(apply_id);
          ud.setCharge_id(ap.getCharge_id());
          ud.setFile_id(ap.getFile_id());
          ud.setPage_id(ap.getPage_id());
          ud.setRemark("");
          udDao.insert(ud);
        }
      }
    }

    if (functionName.equalsIgnoreCase("ShowAllFiles")){
      ArchivesDao aDao = (ArchivesDao)domainLogic.getDAO("Archives");
      Archives a = aDao.getArchivesByArchivesID(Integer.parseInt(archives_id));
      ArchivesFileDao afDao = (ArchivesFileDao) domainLogic.getDAO(
          "ArchivesFile");
      PaginatedList list = afDao.queryArchivesFileByArchivesID(archives_id,
          10000);

      safForm.setArchives(a);
      safForm.setArchives_id(archives_id) ;
      request.getSession().setAttribute("file_list", list);
    }
    return mapping.findForward(forward);
  }
}