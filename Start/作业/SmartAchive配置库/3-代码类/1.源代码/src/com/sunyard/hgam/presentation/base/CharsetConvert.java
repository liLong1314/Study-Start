/**
 * <p>Title: Hang Zhou Net Archives</p>
 * <p>Description: 杭州市网上档案馆建设（一期）</p>
 * <p>Copyright: Hangzhou Sunyard System Engineering， Ltd.co All rights reserved @2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0.0
 */

package com.sunyard.hgam.presentation.base;

import java.io.UnsupportedEncodingException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.io.NotSerializableException;

public class CharsetConvert {
	/**
	 * 把ISO-8859-1转换为GBK的字符串
	 * @param str
	 * @return String
	 */
	public static String toGBK(String str)throws Exception {
		String value ="";
		try {
			value = new String(str.getBytes("ISO-8859-1"),"GBK");
		} catch (UnsupportedEncodingException e) {
                    throw e;
		}
        return value;
	}

	/**
	 * 把GBK转换为ISO-8859-1的字符串
	 * @param str
	 * @return String
	 */
	public static String toISO(String str)throws Exception {
		String value ="";
		try {
			value = new String(str.getBytes("GBK"),"ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
                  throw e;
		}
		return value;
	}


        public int getSystemDate() {

                String y = null; //年
                String m = null; //月
                String d = null; //日
                String nowdate = null;
                int today = 0;
                Date nowtime = new Date();
                Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GB"));
                cal.setTime(nowtime);
                y = "" + cal.get(Calendar.YEAR);
                m = "" + (cal.get(Calendar.MONTH) + 1);
                if (m.length() < 2) {
                        m = "0" + m;
                }
                d = "" + cal.get(Calendar.DATE);
                if (d.length() < 2) {
                        d = "0" + d;
                }
                //nowdate = y+"-"+m+"-"+d;
                //System.out.print("nowdate="+nowdate);
                nowdate = y+m+d;
                today = Integer.parseInt(nowdate);
                System.out.println("today="+today);
           return today;
        }


        public String getSystemTime() {
               //return format is 'HH:MM:SS'
                        String h = null; //hour
                        String m = null; //minute
                        String s = null; //second
                        String time = null;

                        Date nowtime = new Date();
                        //Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("China Standard Time"));
                        Calendar cal = Calendar.getInstance();
                        cal.setTime(nowtime);
                        h = "" + cal.get(Calendar.HOUR_OF_DAY);
                        m = "" + (cal.get(Calendar.MINUTE) + 1);
                        s = "" + cal.get(Calendar.SECOND);

                        if (h.length() < 2) {
                                h = "0" + h;
                        }
                        if (m.length() < 2) {
                                                m = "0" + m;
                        }
                        if (s.length() < 2) {
                                                s = "0" + s;
                                        }
                        time = h+":"+m+":"+s;
                        //today = Integer.parseInt(nowdate);
                        //System.out.println("today time ="+time);
                        //System.out.println("today time ="+DateFormat.getInstance().format(nowtime));
                   return time;
        }

}
