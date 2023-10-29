package com.sunyard.hgam.presentation.action.aum;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.iface.aum.UtilizeInfoDao;
import java.util.List;
import com.sunyard.hgam.persistence.dao.beans.aum.UtilizeInfo;
import com.sunyard.hgam.presentation.form.aum.UtilizeInfoForm;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import com.sunyard.hgam.persistence.dao.iface.aum.UtilizeDetailDao;
import com.sunyard.hgam.persistence.dao.beans.aum.UtilizeDetail;
import com.sunyard.hgam.util.aum.Blackbox;

/**
 * <p>Title: HGAM(�����й滮�����ۺϹ���ϵͳ) </p>
 * <p>Description: ��ʾ���յ�action </p>
 * <p>Copyright: Sunhoo Copyright (c) 2004 </p>
 * <p>Company: Sunhoo Software Co.,Ltd. </p>
 * @author wanghua
 * @version 1.0
 */

public class DisplayUrgeFormAction
    extends BaseAction {

  public ActionForward doPerform(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {

    try {
      UtilizeInfo uInfo = null;
      uInfo = new UtilizeInfo();
      UtilizeInfoDao utilDao = (UtilizeInfoDao) domainLogic.getDAO(
          "UtilizeInfoDao");
      UtilizeDetailDao utilizeDetailDao = (UtilizeDetailDao) domainLogic.getDAO(
          "UtilizeDetail");

      String applyID = request.getParameter("applyID");
      Map applyIDMap = new HashMap();
      applyIDMap.put("applyID", applyID);
      uInfo = utilDao.getUtilizeInfoByApplyID(applyIDMap);

      //��ȡ��ǰ����
      Date currentTime = new Date();
      String[] temp = currentTime.toLocaleString().split(" ");
      uInfo.setRemark(temp[0]); //����remark�ֶ�

      //���ó��ڵĵ�����
      List overdueArchives = utilizeDetailDao.queryOverdueArchByApplyID(applyID);
      UtilizeDetail uDetail = null;
      String archivesNum = "";
      if (overdueArchives.size()==1) {
        uDetail = new UtilizeDetail();
        uDetail = (UtilizeDetail) overdueArchives.get(0);
        archivesNum = uDetail.getArchives_num();
      }
      else {
        for (int i = 0; i < overdueArchives.size(); i++) {
          uDetail = new UtilizeDetail();
          uDetail = (UtilizeDetail) overdueArchives.get(i);
          archivesNum += uDetail.getArchives_num() + ",";
        }
      }
      uInfo.setHandleIdea(archivesNum);//����HandleIdea�ֶ�

      //����ʵ��Ӧ�ù黹����
      String oughtReturn = Blackbox.computeContinueTime(uInfo.getBeginDate(),
          Integer.parseInt(uInfo.getUtilizeTerm()));
      uInfo.setLatestRenewDate(oughtReturn);//����"LatestRenewDate"�ֶ�

      //��ʾΪ�������ڸ�ʽ
      uInfo.setBeginDate(Blackbox.toChinesDateFormt(uInfo.getBeginDate()));

      request.getSession().setAttribute("utilizeInfo", uInfo);
      System.out.println("��ʾ���յ�Action�ɹ�!");
      return mapping.findForward("success");
    }
    catch (Exception ex) {
      ex.printStackTrace();
      return mapping.findForward("error");
    }


  }

}