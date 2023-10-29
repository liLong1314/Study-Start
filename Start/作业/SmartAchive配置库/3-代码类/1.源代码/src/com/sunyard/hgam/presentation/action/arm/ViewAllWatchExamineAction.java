package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.BaseAction;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.iface.arm.WatchExamineDao;
import com.sunyard.hgam.presentation.base.PagedListHelper;
import com.sunyard.hgam.persistence.dao.beans.arm.WatchExamine;

public class ViewAllWatchExamineAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    PaginatedList watchExamineList = (PaginatedList) request.getAttribute("watchExamineList");
    String page = request.getParameter("page");
    if (page == null) {
      WatchExamineDao watchExamineDao = (WatchExamineDao) domainLogic.getDAO("WatchExamine");
      watchExamineList = watchExamineDao.getAllWatchExamine();
      //�滻�־ִ���Ϊ�־�����
      if (watchExamineList != null){
        for (int i = 0; i < watchExamineList.size(); i++) {
          WatchExamine oneWatchExamine = (WatchExamine) watchExamineList.get(i);
          String refWatchId=oneWatchExamine.getRefWatchId();
          if(refWatchId==null || refWatchId.equalsIgnoreCase("�ܾ�δ��ʾ")){
            oneWatchExamine.setRefWatchId("�ܾ�δ��ʾ");
          }else{
            oneWatchExamine.setRefWatchId("�ܾ�����ʾ");}
          int subCode=0;
          try{
            subCode = Integer.parseInt(oneWatchExamine.getSubCode());
          }catch(Exception e){
            subCode=0;
          }

        //  int subCode = Integer.parseInt(oneWatchExamine.getSubCode());
          switch (subCode) {
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
          }
        }
      }
      request.getSession().setAttribute("watchExamineList", watchExamineList);
    }
    else {
      PaginatedList list = (PaginatedList) request.getSession().getAttribute( "watchExamineList");
      if (list != null) {
        PagedListHelper.pageTo(list, page);
        for (int i = 0; i < list.size(); i++) {
          WatchExamine oneWatchExamine = (WatchExamine) list.get(i);
          String refWatchId=oneWatchExamine.getRefWatchId();
          if(refWatchId==null || refWatchId.equalsIgnoreCase("�ܾ�δ��ʾ")){
            oneWatchExamine.setRefWatchId("�ܾ�δ��ʾ");
          }else{
            oneWatchExamine.setRefWatchId("�ܾ�����ʾ");}
          int subCode=0;
          try{
            subCode = Integer.parseInt(oneWatchExamine.getSubCode());
          }catch(Exception e){
            subCode=0;
          }

         // int subCode = Integer.parseInt(oneWatchExamine.getSubCode());
          switch (subCode) {
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
          }
        }

        return (mapping.findForward("success"));
      }

    }

    return mapping.findForward("success");
  }
}