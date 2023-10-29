package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.arm.ContainForm;
import com.sunyard.hgam.persistence.dao.iface.arm.ContainDao;
import com.sunyard.hgam.persistence.dao.beans.arm.Contain;

/**
 * <p>Title: 增加密集架</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 叶昊
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

    //根据用户输入的密集架参数循环生成密集架

    //库柜号循环
    for(long i=containCodeFrom;i<=containCodeTo;i++){

      //层循环
      for(long j=containRowFrom;j<=containRowTo;j++){

        //格循环
        for(long k=containColFrom;k<=containColTo;k++){

          newContain.setRoomCode(RoomCode);
          newContain.setContainType(containType);
          newContain.setContainCode(String.valueOf(i));
          newContain.setContainColumn(String.valueOf(j));
          newContain.setContainRow(String.valueOf(k));
          newContain.setRemark("");

          //增加库柜的左面
          newContain.setContainSide("左面");
          containDao.addContain(newContain);

          //增加库柜的右面
          newContain.setContainSide("右面");
          containDao.addContain(newContain);
        }
      }
    }
    return mapping.findForward("success");
  }

}