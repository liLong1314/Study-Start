package com.sunyard.hgam.util.common;

public class Charset{
    /**
     * 功能：字符串编码转换
     * @param sConvert:要转换的字符串
     * @param 返回：返回转换后的字符串
     */
    public static String charsetConvert(String sConvert)
    {
        String bRet ="";
        try
        {
            bRet=new String(sConvert.getBytes("ISO-8859-1"),"GB2312");
        }
        catch(Exception e)
        {
            bRet = sConvert;
        }
        return bRet;
    }

    /**
     * 功能：字符串编码转换
     * @param sConvert:要转换的字符串数组
     * @param 返回：返回转换后的字符串数组
     */
    public static String[] charsetConvert(String[] sConvert)
    {
        String[] sRet = sConvert;
        try
        {
            for (int i=0;i<sRet.length;i++)
                sRet[i]=new String(sConvert[i].getBytes("ISO-8859-1"),"GB2312");
        }
        catch(Exception e)
        {
            sRet = sConvert;
        }
        return sRet;
    }

}