package com.sunyard.hgam.util.aum;

import java.util.Date;
import java.util.Calendar;

/**
 * <p>Title: HGAM</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author wanghua
 * @version 1.0
 */

public class Blackbox {

  /********************************************************
   * 功能:获取两个时间点之间的时间间隔,以天为计算单位
   * @param   beginDate  开始时间
   * @param   endDate    结束时间
   * @return  在beginDate和endDate之间的时间间隔
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
   * 功能:把日期转化成为中文格式,如:2004年2月18日
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

    retChineseFormat = year + "年" + month + "月" + day + "日";
    return retChineseFormat;
  }

  /**********************************************************************
   * 功能:计算某一个日期之后隔若干天后的日期
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
    String str = "2004年1月28日";
    str.replaceAll("年","-");
    str.replaceAll("月","-");
    str.replaceAll("日","-");
    System.out.println(computeContinueTime(str, 24));
  }

}