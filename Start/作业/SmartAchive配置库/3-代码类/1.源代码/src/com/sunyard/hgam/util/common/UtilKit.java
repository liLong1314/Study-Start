package com.sunyard.hgam.util.common;

/**
 * <p>Title: Hang Zhou Net Archives</p>
 * <p>Description: ���������ϵ����ݽ��裨һ�ڣ�</p>
 * <p>Copyright: Hangzhou Sunyard System Engineering�� Ltd. All rights reserved @2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 0.01
 */

public class UtilKit {

  /**
   * �ж��ַ����Ƿ�Ϊ��
   * @param str �ַ���
   * @return ���strΪnull����"",����true;���򷵻�false
   */
  public static boolean isEmpty(String str) {
    return ((str == null) || (str.length() < 1));
  }

  /**
   * �ж��ַ����Ƿ�Ϊ��
   * @param str �ַ���
   * @return ���strΪnull����"",����false;���򷵻�true
   */
  public static boolean isNotEmpty(String str) {
    return !isEmpty(str);
  }

  /**
   * Ϊģ����ѯ�ַ�������ǰ��׺
   * @param str ��ѯ�����ַ���
   * @return ������ǰ��׺���ַ�������null
   */
  public static String addFuzzy(String str) {
    if (isNotEmpty(str)) {
      return "%" + str + "%";
    }
    else {
      return str;
    }
  }

  /**
   * Ϊģ����ѯ�ַ�������ǰ׺
   * @param str ��ѯ�����ַ���
   * @return ������ǰ׺���ַ�������null
   */
  public static String addFuzzyPrefix(String str) {
    if (isNotEmpty(str)) {
      return "%" + str;
    }
    else {
      return str;
    }
  }

  /**
   * Ϊģ����ѯ�ַ������Ӻ�׺
   * @param str ��ѯ�����ַ���
   * @return �����˺�׺���ַ�������null
   */
  public static String addFuzzySuffix(String str) {
    if (isNotEmpty(str)) {
      return str + "%";
    }
    else {
      return str;
    }
  }

}