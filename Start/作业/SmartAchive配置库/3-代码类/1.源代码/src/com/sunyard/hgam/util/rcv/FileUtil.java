package com.sunyard.hgam.util.rcv;

import com.sunyard.hgam.util.common.FtpClient;
import com.sunyard.hgam.util.adc.PropertiesInfo;
import com.sunyard.hgam.util.adc.AdcUtil;
import java.io.File;

public class FileUtil {
  private static String path = "OA";

  public static void receiveFileFromIfaceByPathName(String filePathName) throws Exception{
    String fileSeparator = System.getProperty("file.separator");
    PropertiesInfo p = new PropertiesInfo("adc.properties");
    String sRemoteFile = "";
    String sLocalFile = "";

    //FTPԶ���ļ���
    if (path!=null && path.length()>0)
      sRemoteFile = path ;
    if (filePathName.indexOf(fileSeparator)!=0)
      sRemoteFile += fileSeparator ;
    sRemoteFile += filePathName ;

    //�����ļ���
    sLocalFile = AdcUtil.AttachString(p.getFileroot(), fileSeparator) ;
    if (filePathName.indexOf(fileSeparator)==0)
      filePathName = filePathName.substring(1, filePathName.length());
    sLocalFile += filePathName ;
    //��������·��
    File f = new File(AdcUtil.getFilePath(sLocalFile));
    if (!f.exists())
      f.mkdirs() ;

    //FTP����
    FtpClient fc = new FtpClient(p.getServerName());
    fc.login(p.getUserName(), p.getPassword()) ;
    fc.setPassive(true) ;
    fc.getFile(sRemoteFile, sLocalFile) ;
    fc.closeServer() ;
  }

  public static String viewIfaceArchivesFileAccessoryByPathName(String filePathName) throws Exception{
    String ftpFilePathName = "";
    return ftpFilePathName;
  }


  public static void main(String[] argv) {
    try{
      receiveFileFromIfaceByPathName("aa\\abc.exe");
      System.out.println("ok");
    }catch(Exception e){
      e.printStackTrace() ;
    }
  }


}
