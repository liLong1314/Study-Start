package com.sunyard.hgam.presentation.action.aum;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.arm.ArchOperForm;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.iface.arm.ArchOperDao;
import java.util.List;
import java.util.ArrayList;
import com.sunyard.hgam.persistence.dao.beans.arm.ArchOper;

/**
 * <p>Title: �����ۺϲ�ѯ�������ѯ</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author ֣��ȫ
 * @version 1.0
 */

public class QueryArchivesAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    ArchOperForm archOperForm=(ArchOperForm) form;
    String flag=request.getParameter("flag");
    String entryLevel=request.getParameter("entryLevel");
    String actionName=request.getParameter("actionName");
    PaginatedList archOpers=(PaginatedList) request.getSession().getAttribute("QueryArchs");

    if(archOpers==null || "first".equalsIgnoreCase(flag)){
      ArchOperDao archOperDao=(ArchOperDao) domainLogic.getDAO("ArchOper");
      if(actionName.equals("1")){
        //һ���ѯ
        if (entryLevel!=null && entryLevel.equals("1")){
          archOpers = archOperDao.queryArchiveX(archOperForm.getArchOperInfo());
        }else{
          archOpers = archOperDao.queryArchive(archOperForm.getArchOperInfo());
        }
      }else if(actionName.equals("2")){
        //ģ����ѯ
        if (!archOperForm.getArchOperInfo().getBlurquery().equalsIgnoreCase("")) {
          archOperForm.getArchOperInfo().setBlurquery("%" +
              archOperForm.getArchOperInfo().
              getBlurquery() + "%");
        }
        if (entryLevel!=null && entryLevel.equals("1")){
          archOpers = archOperDao.queryblurArchiveX(archOperForm.getArchOperInfo());
        }else{
          archOpers = archOperDao.queryblurArchive(archOperForm.getArchOperInfo());
        }
      }else if(actionName.equals("3")){
        //ҵ���ѯ
        /*
        List fieldNames = new ArrayList();
        List fieldValues = new ArrayList();
        fieldNames.add("���赥λ");
        fieldNames.add("���̵ص�");
        fieldValues.add("����");
        fieldValues.add("����");
        archOperForm.getArchOperInfo().setFieldNames(fieldNames);
        archOperForm.getArchOperInfo().setFieldValues(fieldValues);
        */
        String fieldName1 = request.getParameter("fieldName");
        String fieldValue1 = request.getParameter("fieldValue");
        List tempNameList = new ArrayList();
        List tempValueList = new ArrayList();
        if (fieldName1 != null && fieldValue1 != null) {
          String[] fieldName = fieldName1.split(",");
          String[] fieldValue = fieldValue1.split(",");
          for (int i = 0; i < fieldValue.length; i++) {
            tempNameList.add(fieldName[i].toString());
            tempValueList.add(fieldValue[i].toString());
          }
        }
        ArchOper archOper = archOperForm.getArchOperInfo();
        archOper.setFieldNames(tempNameList);
        archOper.setFieldValues(tempValueList);
        if (entryLevel!=null && entryLevel.equals("1")){
          archOpers = archOperDao.queryOperArchiveX(archOper);
        }else{
          archOpers = archOperDao.queryOperArchive(archOper);
        }
      }
      request.getSession().setAttribute("QueryArchs",archOpers);
    }
    else{
      String page=request.getParameter("page");
      PagedListHelper.pageTo(archOpers,page);
    }

    return mapping.findForward("success");
  }

}
