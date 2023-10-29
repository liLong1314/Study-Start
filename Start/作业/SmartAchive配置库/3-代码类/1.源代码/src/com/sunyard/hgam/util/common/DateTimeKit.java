package com.sunyard.hgam.util.common;

import java.sql.*;
import java.util.*;
import java.text.*;

/**
 * <p>Title: Hang Zhou Net Archives</p>
 * <p>Description: ���������ϵ����ݽ��裨һ�ڣ�</p>
 * <p>Copyright: Hangzhou Sunyard System Engineering�� Ltd. All rights reserved @2003</p>
 * <p>Company: </p>
 * @Date        Author      Changes
 * Nov 6,2003   yujx        created
 * @version 0.01
 */

public class DateTimeKit {

  /**
   * �õ���ǰʱ�䴮
   * @return ʱ�䴮(yyyy-MM-dd hh-mm-ss:SSSxxx)������λ����̬�ֲ�α�����
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
   * ��ȡ20λ�����ֵ��ַ���
   * @return 20λ�������ַ������ɵ�ǰʱ������������(yyyyMMddhhmmssSSSxxx)
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
   * ��ȡ��ǰ������ʱ��
   * @return ��ǰ����ʱ�䣨yy-MM-dd HH:mm:ss��
   */
  public static String getCurrentDateTime() {
    return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new java.util.Date());
  }

  /**
   * ��ȡ��ǰ������
   * @return ��ǰ���ڣ�yy-MM-dd��
   */
  public static String getCurrentDate() {
    return (new SimpleDateFormat("yyyy-MM-dd")).format(new java.util.Date());
  }

  /**
   * ��ȡ��ǰ��ʱ��
   * @return ��ǰʱ�䣨HH:mm:ss��
   */
  public static String getCurrentTime() {
    return (new SimpleDateFormat("HH:mm:ss")).format(new java.util.Date());
  }

  /**
   * ��ȡ��ǰ��ʱ���
   * @return ��ǰʱ�����yy-MM-dd hh:mm:ss.SSS��
   */
  public static String getCurrentTimestamp() {
    return new Timestamp(System.currentTimeMillis()).toString();
  }


  public static void main(String[] argv) {
    System.out.println(getIDByCurrentTime());
    System.out.println(getCurrentTimestamp());
  }
}