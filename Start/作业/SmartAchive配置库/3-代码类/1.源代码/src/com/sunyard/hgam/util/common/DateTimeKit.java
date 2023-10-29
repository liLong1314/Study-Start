package com.sunyard.hgam.util.common;

import java.sql.*;
import java.util.*;
import java.text.*;

/**
 * <p>Title: Hang Zhou Net Archives</p>
 * <p>Description: 杭州市网上档案馆建设（一期）</p>
 * <p>Copyright: Hangzhou Sunyard System Engineering， Ltd. All rights reserved @2003</p>
 * <p>Company: </p>
 * @Date        Author      Changes
 * Nov 6,2003   yujx        created
 * @version 0.01
 */

public class DateTimeKit {

  /**
   * 得到当前时间串
   * @return 时间串(yyyy-MM-dd hh-mm-ss:SSSxxx)，后三位是正态分布伪随机数
   */
  public static synchronized String currentTimeString() {
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    timestamp.setNanos(timestamp.getNanos() + new Random().nextInt(1000) * 1000);
    StringBuffer s;
    for (s = new StringBuffer(timestamp.toString()); s.length() < 26;
         s.append("0"));
    return s.toString();
  }

  /**
   * 获取20位的数字的字符串
   * @return 20位的数字字符串，由当前时间加随机数生成(yyyyMMddhhmmssSSSxxx)
   */
  public static String getIDByCurrentTime() {
    StringBuffer retValue = new StringBuffer();
    String tempString = currentTimeString().trim();
    for (int i = 0; i < tempString.length(); i++) {
      try {
        if (Integer.parseInt(tempString.substring(i, i + 1)) < 10)
          retValue.append(tempString.substring(i, i + 1));
      }
      catch (Exception e) {
      }
    }
    return retValue.toString();
  }

  /**
   * 获取当前的日期时间
   * @return 当前日期时间（yy-MM-dd HH:mm:ss）
   */
  public static String getCurrentDateTime() {
    return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new java.util.Date());
  }

  /**
   * 获取当前的日期
   * @return 当前日期（yy-MM-dd）
   */
  public static String getCurrentDate() {
    return (new SimpleDateFormat("yyyy-MM-dd")).format(new java.util.Date());
  }

  /**
   * 获取当前的时间
   * @return 当前时间（HH:mm:ss）
   */
  public static String getCurrentTime() {
    return (new SimpleDateFormat("HH:mm:ss")).format(new java.util.Date());
  }

  /**
   * 获取当前的时间戳
   * @return 当前时间戳（yy-MM-dd hh:mm:ss.SSS）
   */
  public static String getCurrentTimestamp() {
    return new Timestamp(System.currentTimeMillis()).toString();
  }


  public static void main(String[] argv) {
    System.out.println(getIDByCurrentTime());
    System.out.println(getCurrentTimestamp());
  }
}