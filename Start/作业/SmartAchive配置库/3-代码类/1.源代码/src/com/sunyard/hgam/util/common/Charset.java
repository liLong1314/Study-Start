package com.sunyard.hgam.util.common;

public class Charset{
    /**
     * ���ܣ��ַ�������ת��
     * @param sConvert:Ҫת�����ַ���
     * @param ���أ�����ת������ַ���
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
     * ���ܣ��ַ�������ת��
     * @param sConvert:Ҫת�����ַ�������
     * @param ���أ�����ת������ַ�������
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