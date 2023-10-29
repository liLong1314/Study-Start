package com.sunyard.hgam.presentation.action.adc;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.iface.adc.EntryTreeListDao;
import java.util.List;
import java.util.Iterator;
import com.sunyard.hgam.persistence.dao.beans.adc.EntryTreeList;
import com.sunyard.hgam.util.adc.Tree;

/**
 * <p>Title: HGAM</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author ֣��ȫ
 * @version 1.0
 */
public class ViewAllEntryTreeListAction
    extends BaseAction {
  //����������ӳ���
  protected static final String URL_ROLL = "inputRollNavigator.do";
  protected static final String URL_PIECE = "inputPieceNavigator.do";
  protected static final String URL_FILE = "inputFileNavigator.do";
  protected static final String URL_ARCHIVES = "ViewArcList.do";
  protected static final String URL_UTILIZE = "/aum/queryFileNavigator.do";

  public ActionForward doPerform(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.Exception {

    //����������ʾ��ͬ����Ŀ��
    String entryType = request.getParameter("type");
    String strEntryTree = "";
    String strForwardTo = "";
    try {
      if (entryType == null)
        return mapping.findForward("FAILURE");
      String strEntryTreeName = "EntryTree";
      String strURL = "";
      switch (Integer.parseInt(entryType)) {
        case 1://1��������¼
          strEntryTreeName = "EntryTree";
          strURL = URL_ROLL;
          strForwardTo = "ROLL";
          break;
        case 2://2������¼
          strEntryTreeName = "EntryTree";
          strURL = URL_PIECE;
          strForwardTo = "PIECE";
          break;
        case 3://3���ļ���¼
          strEntryTreeName = "EntryTree";
          strURL = URL_FILE;
          strForwardTo = "FILE";
          break;
        case 4://4����������
          strEntryTreeName = "EntryTree";
          strURL = URL_ARCHIVES;
          strForwardTo = "ARCHIVES";
          break;
        case 5://5����������
          strEntryTreeName = "EntryTree";
          strURL = URL_UTILIZE;
          strForwardTo = "UTILIZE";
          break;
        default://����
          strEntryTreeName = "";
          strURL = "";
          strForwardTo = "FAILURE";
          break;
      }

      EntryTreeListDao entryTreeListDao = (EntryTreeListDao) domainLogic.getDAO("EntryTreeList");
      strEntryTree = Tree.getEntryTreeListByType(entryTreeListDao,entryType,strURL,"");
      request.setAttribute(strEntryTreeName, strEntryTree);
    }
    catch (Exception ex) {
      ex.printStackTrace();
      strForwardTo = "FAILURE";
    }finally{
      //return mapping.findForward("SUCCESS");
      return mapping.findForward(strForwardTo);
    }
  }

}
