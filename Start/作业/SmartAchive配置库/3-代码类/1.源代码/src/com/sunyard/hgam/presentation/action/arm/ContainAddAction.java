package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.arm.ContainForm;
import com.sunyard.hgam.persistence.dao.iface.arm.ContainDao;
import com.sunyard.hgam.persistence.dao.beans.arm.Contain;

/**
 * <p>Title: �����ܼ���</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author Ҷ�
 * @version 1.0
 */

public class ContainAddAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    long containCodeFrom;
    long containCodeTo;
    long containRowFrom;
    long containRowTo;
    long containColFrom;
    long containColTo;
    String RoomCode;
    String containType;
    ContainForm containForm = (ContainForm) form;

    containCodeFrom = Long.parseLong(containForm.getContainInfo().getContainCodeFrom());
    containCodeTo = Long.parseLong(containForm.getContainInfo().getContainCodeTo());
    containRowFrom = Long.parseLong(containForm.getContainInfo().getContainRowFrom());
    containRowTo = Long.parseLong(containForm.getContainInfo().getContainRowTo());
    containColFrom = Long.parseLong(containForm.getContainInfo().getContainColumnFrom());
    containColTo = Long.parseLong(containForm.getContainInfo().getContainColumnTo());
    RoomCode=containForm.getContainInfo().getRoomCode();
    containType=containForm.getContainInfo().getContainType();

    ContainDao containDao = (ContainDao) domainLogic.getDAO("Contain");
    Contain newContain=new Contain();

    //�����û�������ܼ��ܲ���ѭ�������ܼ���

    //����ѭ��
    for(long i=containCodeFrom;i<=containCodeTo;i++){

      //��ѭ��
      for(long j=containRowFrom;j<=containRowTo;j++){

        //��ѭ��
        for(long k=containColFrom;k<=containColTo;k++){

          newContain.setRoomCode(RoomCode);
          newContain.setContainType(containType);
          newContain.setContainCode(String.valueOf(i));
          newContain.setContainColumn(String.valueOf(j));
          newContain.setContainRow(String.valueOf(k));
          newContain.setRemark("");

          //���ӿ�������
          newContain.setContainSide("����");
          containDao.addContain(newContain);

          //���ӿ�������
          newContain.setContainSide("����");
          containDao.addContain(newContain);
        }
      }
    }
    return mapping.findForward("success");
  }

}