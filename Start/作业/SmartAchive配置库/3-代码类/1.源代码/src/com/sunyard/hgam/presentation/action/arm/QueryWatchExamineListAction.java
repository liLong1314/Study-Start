package com.sunyard.hgam.presentation.action.arm;
import com.sunyard.hgam.presentation.base.BaseAction;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.beans.arm.WatchExamine;
import com.sunyard.hgam.presentation.base.PagedListHelper;
import com.sunyard.hgam.persistence.dao.iface.arm.WatchExamineDao;
import com.sunyard.hgam.presentation.form.arm.WatchExamineForm;

/**
 * <p>Title: ��ѯ�ල������</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author ������
 * @version 1.0
 */




public class QueryWatchExamineListAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.Exception{

    PaginatedList watchExamineList = (PaginatedList) request.getAttribute("watchExamineList");

    String page = request.getParameter("page");

    if(page == null){
      WatchExamineForm watchExamineForm = (WatchExamineForm) form;
      WatchExamine watchExamine = watchExamineForm.getWatchExamineInfo();

      WatchExamineDao watchExamineDao = (WatchExamineDao) domainLogic.getDAO("WatchExamine");
      watchExamineList = watchExamineDao.queryWatchExamineList(watchExamine);
      //�滻�־ִ���Ϊ�־�����
   for(int i=0;i<watchExamineList.size();i++){
    WatchExamine oneWatchExamine=(WatchExamine)watchExamineList.get(i);
    String refWatchId=oneWatchExamine.getRefWatchId();
    if(refWatchId==null){
      oneWatchExamine.setRefWatchId("�ܾ�δ��ʾ");
    }else{
      oneWatchExamine.setRefWatchId("�ܾ�����ʾ");}

    int subCode=Integer.parseInt(oneWatchExamine.getSubCode());
    switch(subCode){
      case 8:
               oneWatchExamine.setSubCode("�ϳǹ滮�־�");
               break;
             case 9:
               oneWatchExamine.setSubCode("�³ǹ滮�־�");
               break;
             case 11:
               oneWatchExamine.setSubCode("���ɹ滮�־�");
               break;
             case 12:
               oneWatchExamine.setSubCode("�����滮�־�");
               break;
             case 10:
               oneWatchExamine.setSubCode("�����滮�־�");
               break;
             default:
               oneWatchExamine.setSubCode("����");
               break;
    }
   }

      //���뻺��
      request.getSession().setAttribute("watchExamineList", watchExamineList);
      PagedListHelper.pageTo(watchExamineList, page);
      }
      else{ PaginatedList list = (PaginatedList) request.getSession().getAttribute("watchExamineList");
        if (list!=null){
          PagedListHelper.pageTo(list, page);
          return (mapping.findForward("success"));
        }

      }

    //
    return (mapping.findForward("success"));
  }

}

