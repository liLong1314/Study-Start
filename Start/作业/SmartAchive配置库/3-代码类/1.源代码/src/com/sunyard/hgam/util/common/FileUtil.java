package com.sunyard.hgam.util.common;

import com.sunyard.hgam.util.common.FtpClient;
import com.sunyard.hgam.util.adc.PropertiesInfo;
import com.sunyard.hgam.util.adc.AdcUtil;
import java.io.File;

public class FileUtil {

  public static String viewFileByPathName(String filePathName) throws
      Exception {
    String fileSeparator = System.getProperty("file.separator");
    PropertiesInfo p = new PropertiesInfo("adc.properties");
    String sRemoteFile = "";
    String sLocalFile = "";
    if (fileSeparator.equalsIgnoreCase("\\"))
      filePathName = filePathName.replace('/', '\\') ;
    else
      filePathName = filePathName.replace('\\', '/') ;

    //FTP远程文件名
    sRemoteFile = filePathName;

    //本地文件名
    sLocalFile = AdcUtil.AttachString(p.getFileroot(), fileSeparator) ;
    if (filePathName.indexOf(fileSeparator)==0)
      filePathName = filePathName.substring(1, filePathName.length());
    sLocalFile += filePathName ;

    //FTP上传
    FtpClient fc = new FtpClient(p.getServerName());
    fc.login(p.getUserName(), p.getPassword()) ;
    fc.setPassive(true) ;

    //创建远程路径
    String sPath = AdcUtil.getFilePath(filePathName);
    if (sPath!=null && sPath.length() >0)
      try{
        fc.mkdir(sPath);
      }catch(Exception e){

      }

    fc.putFile(sRemoteFile, sLocalFile) ;
    fc.closeServer() ;

    String sURL = "ftp://";
    if (!p.getUserName().equalsIgnoreCase("anonymouse"))
      sURL += p.getUserName() + ":" + p.getPassword() + "@" ;
    sURL += p.getServerName() + "/" + sRemoteFile.replace('\\', '/');
    return sURL;
  }

  public static void main(String[] argv) {
    try{
      String filePathName = "200312/abc.exe";
      System.out.println(viewFileByPathName(filePathName));
    }catch(Exception e){
      e.printStackTrace() ;
    }
  }


}
