package com.sunyard.hgam.util.common;

/**
 * <p>Title: Hang Zhou Net Archives</p>
 * <p>Description: 杭州市网上档案馆建设（一期）</p>
 * <p>Copyright: Hangzhou Sunyard System Engineering， Ltd. All rights reserved @2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 0.01
 */

public class UtilKit {

  /**
   * 判断字符串是否为空
   * @param str 字符串
   * @return 如果str为null或者"",返回true;否则返回false
   */
  public static boolean isEmpty(String str) {
    return ((str == null) || (str.length() < 1));
  }

  /**
   * 判断字符串是否为空
   * @param str 字符串
   * @return 如果str为null或者"",返回false;否则返回true
   */
  public static boolean isNotEmpty(String str) {
    return !isEmpty(str);
  }

  /**
   * 为模糊查询字符串增加前后缀
   * @param str 查询条件字符串
   * @return 增加了前后缀的字符串或者null
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
   * 为模糊查询字符串增加前缀
   * @param str 查询条件字符串
   * @return 增加了前缀的字符串或者null
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
   * 为模糊查询字符串增加后缀
   * @param str 查询条件字符串
   * @return 增加了后缀的字符串或者null
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