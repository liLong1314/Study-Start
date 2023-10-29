package com.sunyard.hgam.util.adc;

import java.util.Properties;
import java.io.*;

/**
 * 从配置文件读取需要用到参数，比如ftp的配置，路径的配置等
 * @author zhangdong@sunyard.com
 * @version 1.00 2003-12-01
 */
public class PropertiesInfo {

  private Properties properties = null;

  //ftp配置
  private String serverName = "";
  private String serverPort = "";
  private String userName = "";
  private String password = "";
  private String ftproot = "";
  private String fileroot = "";

  //临时文件夹路径
  private String tempDir = "";

  /**
   * 初始化配置文件路径
   */
  public PropertiesInfo(String propertiesFileName) throws Exception {

    //构造文件名
    String pFilename = System.getProperty("user.dir");
    pFilename += System.getProperty("file.separator");
    pFilename += propertiesFileName;

    //调试语句
    //System.out.println(pFilename);

    properties = new Properties();

    FileInputStream in = null;
    try {
      in = new FileInputStream(pFilename); //构造文件的输入流
      properties.load(in); //读入属性
    }
    catch (Exception exc) {
      throw exc;
    }finally{
      if (in!=null)
        in.close();
    }
  }

  public String getPassword() {
    password = properties.getProperty("FTPPASSWORD");
    return password;
  }

  public String getUserName() {
    userName = properties.getProperty("FTPUSERNAME");
    return userName;
  }

  public String getServerPort() {
    serverPort = properties.getProperty("FTPSERVERPORT");
    return serverPort;
  }

  public String getServerName() {
    serverName = properties.getProperty("FTPSERVERNAME");
    return serverName;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setServerName(String serverName) {
    this.serverName = serverName;
  }

  public void setServerPort(String serverPort) {
    this.serverPort = serverPort;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getTempDir() {
    tempDir = properties.getProperty("TEMPDIR");
    return tempDir;
  }

  public void setTempDir(String tempDir) {
    this.tempDir = tempDir;
  }

  public String getFtproot() {
    ftproot = properties.getProperty("FTPROOT");
    return ftproot;
  }

  public void setFtproot(String ftproot) {
    this.ftproot = ftproot;
  }

  public String getFileroot() {
    fileroot = properties.getProperty("FILEROOT");
    return fileroot;
  }

  public void setFileroot(String fileroot) {
    this.fileroot = fileroot;
  }
  public Properties getProperties() {
    return properties;
  }

}