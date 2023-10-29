package com.sunyard.hgam.util.aum;

import java.util.Date;
import java.util.Calendar;

/**
 * <p>Title: HGAM</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author wanghua
 * @version 1.0
 */

public class Blackbox {

  /********************************************************
   * ����:��ȡ����ʱ���֮���ʱ����,����Ϊ���㵥λ
   * @param   beginDate  ��ʼʱ��
   * @param   endDate    ����ʱ��
   * @return  ��beginDate��endDate֮���ʱ����
   ********************************************************/
  public static long computeInterval(Date beginDate, Date endDate) {
    long retInterval = 0;
    long beginMillisec = beginDate.getTime();
    long endMillisec = endDate.getTime();
    retInterval = ( (endMillisec - beginMillisec) / 3600000) / 24;
    return retInterval;
  }

  public static java.util.Date changeStr2DateTime(String strInputDateTime) {

    java.util.Date myDate;
    Calendar dateSet = Calendar.getInstance();
    int yea = 0;
    int mon = 0;
    int day = 0;
    int hou = 0;
    int min = 0;
    int sec = 0;

    try {
      String splitResult[] = strInputDateTime.split("-");
      yea = Integer.parseInt(splitResult[0]);
      mon = Integer.parseInt(splitResult[1]) - 1;
      day = Integer.parseInt(splitResult[2].substring(0, 2).trim());
      min = 0;
      sec = 0;
      dateSet.set(yea, mon, day, hou, min, sec);
      myDate = dateSet.getTime();
      return myDate;
    }
    catch (Exception e) {
      return null;
    }
  }

  /********************************************************
   * ����:������ת����Ϊ���ĸ�ʽ,��:2004��2��18��
   ********************************************************/
  public static String toChinesDateFormt(String aDateString) {
    String retChineseFormat = "";
    String splitArray[] = aDateString.split("-");
    String year = splitArray[0];
    String month = splitArray[1];
    String day = splitArray[2];

    if (month.startsWith("0"))
      month = month.substring(1);
    if (day.startsWith("0"))
      day = day.substring(1);

    retChineseFormat = year + "��" + month + "��" + day + "��";
    return retChineseFormat;
  }

  /**********************************************************************
   * ����:����ĳһ������֮���������������
   **********************************************************************/
  public static String computeContinueTime(String beginDateString, int interval) {

    java.util.Date myDate;
    Calendar dateSet = Calendar.getInstance();
    int yea = 0;
    int mon = 0;
    int day = 0;
    int hou = 0;
    int min = 0;
    int sec = 0;
    Date beginTime;

    try {
      String splitResult[] = beginDateString.split("-");
      yea = Integer.parseInt(splitResult[0]);
      mon = Integer.parseInt(splitResult[1]) - 1;
      day = Integer.parseInt(splitResult[2]);
      min = 0;
      sec = 0;
      dateSet.set(yea, mon, day, hou, min, sec);
      myDate = dateSet.getTime();
      beginTime = myDate;
    }
    catch (Exception e) {
      return null;
    }

    long lBeginTime = beginTime.getTime();
    long lInterval = interval * 24 * 3600 * 1000;
    long lResult = lBeginTime + lInterval;
    Date retResult = new Date();
    retResult.setTime(lResult);
    String strRetResult = retResult.toLocaleString();
    String tmp[] = strRetResult.split(" ");
    return tmp[0];
  }

  public static void main(String[] args) {
    String str = "2004��1��28��";
    str.replaceAll("��","-");
    str.replaceAll("��","-");
    str.replaceAll("��","-");
    System.out.println(computeContinueTime(str, 24));
  }

}