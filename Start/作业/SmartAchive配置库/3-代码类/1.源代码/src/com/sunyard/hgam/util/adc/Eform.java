package com.sunyard.hgam.util.adc;

import com.sunyard.hgam.persistence.dao.iface.adc.EformDao;
import java.util.Iterator;
import com.sunyard.hgam.persistence.dao.beans.adc.EformFieldDefine;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * <p>Title: HGAM</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author ֣��ȫ
 * @version 1.0
 */
public class Eform {
  public static List getProjBriefByProjId(String projId){
    List list=new ArrayList();

    try {
      /*
      Iterator fieldDefineIterator = eformDao.getEformFieldDefineByEformId(eformId).iterator();

      EformFieldDefine fieldDefine= null;
      while (fieldDefineIterator.hasNext()) {
        fieldDefine = (EformFieldDefine) fieldDefineIterator.next();
        //��װ�ֶ�
        strResult += "\n";
      }*/
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }finally{
      return list;
    }

  }

}
