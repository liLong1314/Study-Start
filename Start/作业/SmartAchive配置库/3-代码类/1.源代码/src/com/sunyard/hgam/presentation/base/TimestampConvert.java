package com.sunyard.hgam.presentation.base;

/**
 * <p>Title: 时间戳转换类</p>
 * <p>Description: 用于时间戳转换</p>
 * <p>File： TimestampConvert.java</p>
 * <p>Copyright 2001 Hangzhou Sunyard Com,Ltd.</p>
 * @version 1.0
*/

import java.io.PrintStream;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

public class TimestampConvert
{

    private static final TimestampConvert instance = new TimestampConvert();
    private static final String copyright = "Copyright 2001 Hangzhou Sunyard System Engineering， Ltd. All right reserved.";
    private static Random r = new Random();

    private TimestampConvert()
    {
    }

    public static TimestampConvert getInstance()
    {
        return instance;
    }

    public static synchronized String toGMT(Timestamp timestamp)
    {
        GregorianCalendar gregoriancalendar = (GregorianCalendar)Calendar.getInstance();
        gregoriancalendar.setTime(timestamp);
        long l = gregoriancalendar.get(15) + gregoriancalendar.get(16);
        BigInteger biginteger = BigInteger.valueOf(gregoriancalendar.getTime().getTime()).subtract(BigInteger.valueOf(l));
        Timestamp timestamp1 = new Timestamp(biginteger.longValue());
        timestamp1.setNanos(timestamp.getNanos());
        String s;
        for(s = timestamp1.toString(); s.length() < 26; s = s + "0");
        return s;
    }

    public static synchronized Timestamp toGMT(String s)
    {
        GregorianCalendar gregoriancalendar = (GregorianCalendar)Calendar.getInstance();
        Timestamp timestamp = valueOf(s);
        gregoriancalendar.setTime(timestamp);
        long l = gregoriancalendar.get(15) + gregoriancalendar.get(16);
        BigInteger biginteger = BigInteger.valueOf(gregoriancalendar.getTime().getTime()).subtract(BigInteger.valueOf(l));
        Timestamp timestamp1 = new Timestamp(biginteger.longValue());
        timestamp1.setNanos(timestamp.getNanos());
        return timestamp1;
    }

    public static synchronized String toLocal(Timestamp timestamp)
    {
        GregorianCalendar gregoriancalendar = (GregorianCalendar)Calendar.getInstance();
        gregoriancalendar.setTime(timestamp);
        long l = gregoriancalendar.get(15) + gregoriancalendar.get(16);
        BigInteger biginteger = BigInteger.valueOf(gregoriancalendar.getTime().getTime()).add(BigInteger.valueOf(l));
        Timestamp timestamp1 = new Timestamp(biginteger.longValue());
        timestamp1.setNanos(timestamp.getNanos());
        String s;
        for(s = timestamp1.toString(); s.length() < 26; s = s + "0");
        return s;
    }

    public static synchronized Timestamp toLocal(String s)
    {
        GregorianCalendar gregoriancalendar = (GregorianCalendar)Calendar.getInstance();
        Timestamp timestamp = valueOf(s);
        gregoriancalendar.setTime(timestamp);
        long l = gregoriancalendar.get(15) + gregoriancalendar.get(16);
        BigInteger biginteger = BigInteger.valueOf(gregoriancalendar.getTime().getTime()).add(BigInteger.valueOf(l));
        Timestamp timestamp1 = new Timestamp(biginteger.longValue());
        timestamp1.setNanos(timestamp.getNanos());
        return timestamp1;
    }

    public static Timestamp currentGMTTime()
    {
        GregorianCalendar gregoriancalendar = (GregorianCalendar)Calendar.getInstance();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        gregoriancalendar.setTime(timestamp);
        long l = gregoriancalendar.get(15) + gregoriancalendar.get(16);
        BigInteger biginteger = BigInteger.valueOf(gregoriancalendar.getTime().getTime()).subtract(BigInteger.valueOf(l));
        return new Timestamp(biginteger.longValue() + (long)(timestamp.getNanos() / 0xf4240));
    }

    public static synchronized Timestamp currentTime()
    {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        timestamp.setNanos(timestamp.getNanos() + r.nextInt(999) * 1000);
        return timestamp;
    }

    public static synchronized String currentTimeString()
    {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        timestamp.setNanos(timestamp.getNanos() + r.nextInt(999) * 1000);
        String s;
        for(s = timestamp.toString(); s.length() < 26; s = s + "0");
        return s;
    }

    public static Timestamp currentTime(int i)
    {
        return new Timestamp(System.currentTimeMillis() + (long)i * 0x5265c00L);
    }

    public static Date currentDate()
    {
        return new Date(System.currentTimeMillis());
    }

    public static Date currentDate(int i)
    {
        return new Date(System.currentTimeMillis() + (long)i * 0x5265c00L);
    }

    public static Timestamp valueOf(String s)
    {
        char ac[] = s.toCharArray();
        if(ac.length > 10)
            ac[10] = ' ';
        return Timestamp.valueOf(new String(ac));
    }

    public static void main(String args[])
    {
        Timestamp timestamp = currentTime();
        System.out.println("current time    : " + timestamp.toString());
        System.out.println("convert to GMT  : " + toGMT(timestamp));
        System.out.println("");
        Timestamp timestamp1 = currentGMTTime();
        System.out.println("GMT     time    : " + timestamp1.toString());
        System.out.println("convert to Local: " + toLocal(timestamp1));
        System.out.println("");
        String s = currentGMTTime().toString();
        System.out.println("req sends this date, in GMT time: " + s);
        timestamp = toLocal(s);
        System.out.println("we format to local time         : " + timestamp.toString());
        s = "2002-08-09 13:14:15.123456";
        System.out.println("req sends this date, in GMT time: " + s);
        timestamp = toLocal(s);
        System.out.println("we format to local time         : " + timestamp.toString());
        s = "2002-01-09 13:14:15.123456";
        System.out.println("req sends this date, in GMT time: " + s);
        timestamp = toLocal(s);
        System.out.println("we format to local time         : " + timestamp.toString());
        s = "2002-01-09 13:14:15.123456";
        System.out.println("req sends this date, in local time: " + s);
        timestamp = toGMT(s);
        System.out.println("we format to GMT time         : " + timestamp.toString());
        System.out.println("we send GMT        time         : " + toGMT(timestamp));
        System.out.println("current date + 3 days: " + currentTime(3));
        System.out.println("\n also lenient parsing\n");
        Timestamp timestamp2 = currentTime();
        Timestamp timestamp3 = currentTime();
        System.out.println("curent time is: " + timestamp2.toString());
        System.out.println("curent time is: " + timestamp3.toString());
        String s1 = currentTimeString();
        String s2 = currentTimeString();
        System.out.println("curent time is: " + s1);
        System.out.println("curent time is: " + s2);
        timestamp2 = valueOf("2001-07-04 10:11:59.999999");
        System.out.println(" from this 2001-07-04 10:11:59.999999");
        System.out.println("to " + timestamp2.toString());
        timestamp2 = valueOf("2001-07-04-10:11:59.999999");
        System.out.println(" from this 2001-07-04-10:11:59.999999");
        System.out.println("to " + timestamp2.toString());
        timestamp2 = valueOf("2001-07-04:10:11:59.999999");
        System.out.println(" from this 2001-07-04:10:11:59.999999");
        System.out.println("to " + timestamp2.toString());
    }

}
