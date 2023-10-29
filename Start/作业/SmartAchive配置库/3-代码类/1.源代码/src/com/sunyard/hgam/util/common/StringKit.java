package com.sunyard.hgam.util.common;

import java.sql.*;
import java.util.*;
import java.text.*;

/**
 * <p>Title: Hang Zhou Net Archives</p>
 * <p>Description: 杭州市网上档案馆建设（一期）</p>
 * <p>Copyright: Hangzhou Sunyard System Engineering， Ltd. All rights reserved @2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 0.01
 */

public class StringKit
{

  public static Hashtable getRightString(String input,String flag)
  {
    Hashtable h = new Hashtable();
    try
    {
      String temp = input;
      int total = getCharNumber(input,flag);
      for(int i=0;i<total;i++)
      {
        String item = temp.substring(temp.lastIndexOf("|")+1,temp.length());
        h.put(Integer.toString(i),item);
        temp = temp.substring(0,temp.lastIndexOf("|"));
      }
    }
    catch(Exception e)
    {
      h = new Hashtable();
    }
    return h;
  }

  public static int getCharNumber(String input,String flag)
  {
    int retValue = 0;
    String tempString = input;
    for (int i = 0; i < tempString.length(); i++) {
      try {
        if ((tempString.substring(i, i + 1)).equals(flag))
          retValue++;
      }
      catch (Exception e) {
      }
    }
    System.out.println(retValue);
    return retValue;
  }

  public static void main(String[] argv)
  {
    String test = "asdfffffffffff|1asdf|2asdf|3aa|4ff|5ffff|6ffff";
    String flag = "|";
    System.out.println(StringKit.getRightString(test,flag));
  }

}