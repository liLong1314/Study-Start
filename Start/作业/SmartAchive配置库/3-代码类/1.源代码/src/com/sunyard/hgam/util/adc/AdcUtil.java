package com.sunyard.hgam.util.adc;

import java.io.*;
import java.util.zip.*;
import java.util.*;
import java.text.*;
import com.sunyard.hgam.presentation.base.IDGenerator;
import com.sunyard.hgam.persistence.dao.beans.adc.ArchivesFile;
import com.sunyard.hgam.persistence.dao.iface.adc.ArchivesFileDao;
import com.sunyard.hgam.presentation.base.OptionBean;
import com.sunyard.hgam.domain.logic.DomainLogic;
import com.sunyard.hgam.persistence.dao.iface.smm.SysParamDao;
import com.sunyard.hgam.persistence.dao.sqlmapdao.smm.SysParamSqlMapDao;
import com.sunyard.hgam.persistence.dao.beans.smm.SysParam;
import com.sunyard.hgam.util.common.FtpClient;
import com.sunyard.hgam.persistence.dao.iface.arm.SecretDao;
import com.sunyard.hgam.persistence.dao.sqlmapdao.arm.SecretSqlMapDao;
import com.sunyard.hgam.persistence.dao.beans.arm.Secret;

/**
 * <p>Title: HGAM</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author not attributable
 * @version 1.0
 */

public class AdcUtil {

  /**
   *   判断 sSrc 字符串最后字符串是否为sAdd，如不是则增加sAdd并返回，否则返回sSrc
   * 该函数可用于增加“路径”中的分隔符等。
   * @param sSrc  源字符串
   * @param sAdd  增加的字符串
   * @return String
   */
  public static String AttachString(String sSrc, String sAdd) {
    if(sSrc.endsWith(sAdd) == false)
      sSrc += sAdd;
    return sSrc;
  }

  /**
   * 在sPath文件夹中，建立sFolderName文件夹
   * @param sPath
   * @param sFolderName     新建目录的名称
   * @return                如果sPath不存在，或建立失败，返回false，建立成功true
   * @throws java.lang.Exception
   */
  public static boolean createFolder(String sPath, String sFolderName) throws Exception{
    File path= new File(sPath);
    if (!path.exists())
      return false;

    path= new File(AttachString(sPath, System.getProperty("file.separator")) + sFolderName);
    return path.mkdirs();
  }

  /**
   * 删除path及其所有路径和文件
   * @param path String 路径名
   * @return
   * @throws Exception
   */
  public static boolean deletePath(String sPath) throws Exception {
    File path = new File(sPath);
    return deletePath(path);
  }

  /**
   * 删除path及其所有路径和文件
   * @param path  路径的File对象
   * @return
   * @throws Exception
   */
  public static boolean deletePath(File path) throws Exception {
    boolean retValue = false;
    try {
      File[] fileList = null;
      if(!path.exists())
        return true;
      else if(path.isFile()) {
        path.delete();
        return true;
      } else
        fileList = path.listFiles();
      if(fileList.length == 0)
        path.delete();
      else {
        for(int i = 0; i < fileList.length; i++) {
          if(fileList[i].isFile())
            fileList[i].delete();
          else if(fileList[i].isDirectory()) {
            deletePath(fileList[i]);
            fileList[i].delete();
          }
        }
        path.delete();
      }
      retValue = true;
    } catch(Exception e) {
      throw e;
    }
    return retValue;
  }

  /**
   * 拷贝文件srcFile 为 desFile，
   * @param srcFile   源文件
   * @param desFile   目标文件，如果已存在，则覆盖此文件
   * @return          拷贝成功标志
   * @throws java.lang.Exception
   */
  public static boolean fileCopy(String srcFile, String desFile) throws Exception {
    File file_in = new File(srcFile);
    if (!file_in.exists())
      return false;
    File file_out = new File(desFile);
    FileInputStream in1 = new FileInputStream(file_in);
    FileOutputStream out1 = new FileOutputStream(file_out);
    byte[] bytes = new byte[1024];
    int c;
    while ( (c = in1.read(bytes)) != -1)
      out1.write(bytes, 0, c);
    in1.close();
    out1.close();
    return (true); //if success then return true
  }

  /**
   * 根据文件名（绝对路径），返回该文件所在的绝对路径
   * @param sFileName
   * @return
   */
  public static String getFilePath(String sFileName){
    String sRet = "";
    try{
      File f = new File(sFileName);
      sRet = f.getParent() ;
    }catch(Exception e){

    }
    return sRet;
  }

  /**
   * 根据全路径文件名，返回该文件名称
   * @param sFileName
   * @return
   */
  public static String getFileName(String sFileName){
    String sRet = "";
    try{
      File f = new File(sFileName);
      sRet = f.getName() ;
    }catch(Exception e){

    }
    return sRet;
  }

  /**
   * 函数功能：压缩文件
    输入参数：
      ZipOutputStream zipo  传入NULL值
      zipFileName   压缩文件全路径名
      beZipPath 待压缩文件全路径
      String excludepath 压缩文件中不需要记录的路径部分，一般取beZipPath的父目录的全路径名
    输出参数：
      返回值：
       true：操作成功
       false:操作失败
   * 创建日期：(2002-3-23 11:10:43)
   */
  public static boolean zipFile(ZipOutputStream zipos, String zipFileName,
                                String beZipPath, String excludepath) {
    try {
      java.io.File filePath = new File(beZipPath);
      FileInputStream is;
      BufferedInputStream bis;
      //ZipOutputStream zipos=null;
      ZipEntry zeW = null;
      String sTemp = beZipPath + ".tmp";
      String path;
      //byte[] buffer=new byte[10240];
      boolean isRoot = false;
      if(!filePath.exists())
        return false;
      if(zipos == null) {
        isRoot = true;
        zipos = new ZipOutputStream(new FileOutputStream(sTemp));
        if((!excludepath.equals(""))
           && (beZipPath.indexOf(excludepath) == 0)) {
          path = beZipPath.substring(excludepath.length() + 1);
        } else
          path = beZipPath;
        zipos.putNextEntry(new ZipEntry(path + "/"));
        zipos.closeEntry();
      }
      zipos.setMethod(ZipOutputStream.DEFLATED);


      File[] fl = filePath.listFiles();
      for(int i = 0; i < fl.length; i++) {
        path = fl[i].getPath();
        if((!excludepath.equals("")) && (path.indexOf(excludepath) == 0)) {
          path = path.substring(excludepath.length() + 1);
        }

        if(fl[i].isDirectory()) {
          zipos.putNextEntry(new ZipEntry(path + "/"));
          zipos.closeEntry();
          zipFile(zipos, zipFileName, fl[i].getAbsolutePath(),
                  excludepath);
        } else {
          zeW = new ZipEntry(path);
          zeW.setTime(fl[i].lastModified());
          zeW.setSize(fl[i].length());
          zipos.putNextEntry(zeW);
          //System.out.println(fl[i].getPath());
          DataOutputStream os = new DataOutputStream(zipos);
          is = new FileInputStream(fl[i]);
          bis = new BufferedInputStream(is);
          int c;
          while((c = bis.read()) != -1) {
            os.write((byte) c);
          }
          is.close();
          bis.close();
        }
      }
      zipos.flush();
      if(isRoot) {
        zipos.finish();
        zipos.close();
        File zipfile = new File(zipFileName);
        if(zipfile.exists())
          zipfile.delete();
        new File(sTemp).renameTo(new File(zipFileName));
      }
      return true;
    } catch(Exception e) {
      System.out.println(e.getMessage());
      return false;
    }
  }

  /*
   * 函数功能：解压缩文件
   输入参数：
     zipFileName:压缩文件全路径
   输出参数：
     返回值：
      true：操作成功
      false:操作失败
   * 创建日期：(2002-3-23 11:10:43)
   */
  public static boolean UnzipFile(String zipFileName) throws Exception{
    try {
      //System.out.println("zipfilename:"+zipFileName);
      File f = new File(zipFileName);
      ZipFile zipFile = new ZipFile(zipFileName);
      if((!f.exists()) && (f.length() <= 0)) {
          throw new Exception("要解压的文件不存在!");
      }
      String strPath, gbkPath, strtemp;
      File tempFile = new File(f.getParent());
      strPath = tempFile.getAbsolutePath();
      java.util.Enumeration e = zipFile.entries();
      while(e.hasMoreElements()) {
        ZipEntry zipEnt = (ZipEntry) e.nextElement();
        File file = new File(zipEnt.getName());
        if(zipEnt.isDirectory()) {
          //System.out.println(strPath+"/"+zipEnt.getName());
          strtemp = strPath + "/" + zipEnt.getName();
          gbkPath = new String(strtemp.getBytes("GBK"));
          File dir = new File(gbkPath);
          dir.mkdirs();
          continue;
        } else {
          //读写文件
          InputStream is = zipFile.getInputStream(zipEnt);
          BufferedInputStream bis = new BufferedInputStream(is);

          strtemp = strPath + "/" + zipEnt.getName();
          //gbkPath=new String(strtemp.getBytes("GBK"));
          //String  strsubdir=gbkPath.substring(0,gbkPath.lastIndexOf("/"));
          //strsubdir=strsubdir.replace('/','\\');
          //System.out.println(strsubdir);
          //建目录
          String strsubdir = zipEnt.getName();
          for(int i = 0; i < strsubdir.length(); i++) {
            if(strsubdir.substring(i, i + 1).equalsIgnoreCase("/")) {
              String temp = strPath + "/"
                + strsubdir.substring(0, i);
              //System.out.println(temp);
              File subdir = new File(temp);
              if(!subdir.exists())
                subdir.mkdir();
            }
          }
          //System.out.println(gbkPath);

          FileOutputStream fos = new FileOutputStream(strtemp);
          BufferedOutputStream bos = new BufferedOutputStream(fos);
          //System.out.println( strPath+"\\"+UnzipFileName);

          int c;
          while((c = bis.read()) != -1) {
            bos.write((byte) c);
          }
          bos.close();
          fos.close();
        }

      }
      return true;
    } catch(Exception e) {
      System.out.println("error:" + e.getMessage());
      throw e;
    }

  }


  /**
   *
   * @param sFileName
   * @return
   */
  public static String getFileExtentName(String sFileName) {
    if(sFileName.lastIndexOf(".") > 0) {
      return sFileName.substring(sFileName.lastIndexOf(".") + 1,
                                 sFileName.length());
    } else
      return "";
  }

  /**
   * 返回21位的时间字符串 YYYYMMDD hhmmssSSSxxxx
   * @return
   */
  public static String getTimeString(){
    Random r = new Random();
    String sRet = Integer.toString(r.nextInt(10)).substring(0, 1);
    sRet = IDGenerator.getTimeString() + sRet ;
    return sRet;
  }

  /**
   * 根据archives_id，得到一个案卷内的所有文件的信息，用OptionBean封装，所需要的信息包括
   * value=file_num+file_title, label=file_id，
   * 用于用户在修改所属文件时选择。
   *
   * @param archives_id 档案ID
   * @return 查询的结果，封装了OptionBean对象的Iterator（按file_id，即label排序）
   */
  public static List getArchivesFilesByArchivesID(String archives_id) throws
      Exception {
    OptionBean optionBean;

    ArchivesFileDao filedao = (ArchivesFileDao) DomainLogic.getInstance().
        getDAO("ArchivesFile");
    List lstFiles = filedao.queryArchivesFileByArchivesID(archives_id, 1000) ;

    ArrayList arrayList_ArchivesFiles = new ArrayList();
    int size = 0;
    if (lstFiles != null)
      size = lstFiles.size();
    for (int i = 1; i <= size; i++) {
      ArchivesFile afRow = (ArchivesFile) lstFiles.get(i - 1);
      optionBean = new OptionBean(afRow.getFile_num() + "-" +
                                  afRow.getFile_title(), afRow.getFile_id());
      arrayList_ArchivesFiles.add(optionBean);
    }

    return arrayList_ArchivesFiles;
  }

  /**
   * 根据file_id，返回文件编号+文件题名(file_num + file_title)
   * ( 用于界面显示file_id===>文件题名 )
   *
   * @param file_id 文件ID
   * @return file_num + file_title
   */
  public static String getArchivesFileCaptionByFileID(String file_id) throws
    Exception {
    ArchivesFileDao filedao = (ArchivesFileDao) DomainLogic.getInstance().
        getDAO("ArchivesFile");
    ArchivesFile af = filedao.getArchivesFileByFileID(file_id) ;
    String sRet = file_id;
    if (af!=null)
      sRet = af.getFile_num() + "-" + af.getFile_title() ;
    return sRet;
  }

  /**
   * 返回系统参数Operator操作权限，用OptionBean封装，所需要的信息包括
   * value=name, label=id，
   *
   * @return 查询的结果，封装了OptionBean对象的Iterator
   */
  public static List getSystemParamOperator() throws
      Exception {
    List lst = null;
    List lstRet = new ArrayList();
    SysParamDao dao = (SysParamDao) DomainLogic.getInstance().getDAO(
        "SysParam");
    lst = dao.getSysParamByType("PAGE_OPERATOR");
    if (lst==null)
      lst = new ArrayList();
    for (int i=0; i<lst.size(); i++){
      SysParam sysParam = (SysParam)lst.get(i);
      OptionBean optionBean = new OptionBean(sysParam.getSysParamName(), sysParam.getSysParamValue());
      lstRet.add(optionBean) ;
    }
    return lstRet;
  }

  /**
   * 返回系统参数“页幅”，用OptionBean封装，所需要的信息包括
   * value=name, label=id，
   *
   * @return 查询的结果，封装了OptionBean对象的Iterator
   */
  public static List getSystemParamPageSize() throws
      Exception {
    List lst = null;
    List lstRet = new ArrayList();
    SysParamDao dao = (SysParamDao) DomainLogic.getInstance().getDAO(
        "SysParam");
    lst = dao.getSysParamByType("PAGE_SIZE");
    if (lst==null)
      lst = new ArrayList();
    for (int i=0; i<lst.size(); i++){
      SysParam sysParam = (SysParam)lst.get(i);
      OptionBean optionBean = new OptionBean(sysParam.getSysParamName(), sysParam.getSysParamValue());
      lstRet.add(optionBean) ;
    }
    return lstRet;
  }

  /**
   * 根据参数类型type、参数值value，返回参数名称name
   * @param type    参数类型
   * @param value   参数编码
   * @return name   返回参数名称，如果value不存在，则返回value
   * @throws java.lang.Exception
   */
  public static String getSysParamByTypeAndValue(String sType, String sValue) throws
      Exception {
    if (sValue==null)
      return "";
    SysParam sysParam = null;
    String sName = sValue;
    SysParamDao dao = (SysParamDao) DomainLogic.getInstance().getDAO(
        "SysParam");
    sysParam = (SysParam)dao.getSysParamByTypeAndValue(sType, sValue);
    if (sysParam!=null)
      sName = sysParam.getSysParamName() ;
    return sName;
  }

  /**
   * 在OptionBean集合中根据一个value，得到对应的label
   * @param iterator 封装了OptionBean的集合
   * @param value 要查找的value
   * @return value对应的label
   */
  public static String getLabelByValue(List list, String value) {
    OptionBean optionBean;
    Iterator ite = null;
    if (list==null)
      return "";
    ite = list.iterator() ;
    if (value==null)
      return "";
    while(ite.hasNext()) {
      optionBean = (OptionBean) ite.next();
      if(optionBean.getValue().equalsIgnoreCase(value)) {
        value = optionBean.getLabel();
        break;
      }
    }
    return value;
  }

  /**
   * 根据密级编码secretId 返回名称
   * @param secretId
   * @return
   * @throws java.lang.Exception
   */
  public static String getSecretNameById(String secretId) throws Exception{
    if (secretId==null || secretId.length()<1)
      return "";
    Secret secret = null;
    String sName = secretId;
    SecretDao dao = (SecretDao) DomainLogic.getInstance().getDAO("Secret");
    secret = (Secret)dao.getSecret(secretId);
    if (secret!=null)
      sName = secret.getSecretName();
    return sName;
  }

  /**
   * FTP服务器删除路径path下的文件file，如果该路径下没有文件或只有一个文件file，则删除该路径
   * @param path String 路径名
   * @return
   * @throws Exception
   */
  public static boolean deleteFtpPath(String sPath, String sFile) throws Exception {
    try{
      PropertiesInfo p = new PropertiesInfo("adc.properties");
      String s = p.getFtproot();
      FtpClient f = new FtpClient(p.getServerName());
      f.login(p.getUserName(), p.getPassword());

      //删除文件sFile
      if (sFile!=null && sFile.length()>0){
        String path = sFile;
        if (sPath!=null && sPath.length()>0)
          path = sPath + System.getProperty("file.separator") + sFile;
        try{
          f.delete(path);
        }catch(Exception e){

        }
      }

      //删除目录
      try{
        if (sPath!=null && sPath.length()>0)
          f.rmdir(sPath);
      }catch(Exception e){

      }
      f.closeServer();
    }catch(Exception e){
      e.printStackTrace() ;
    }
    return true;
  }

  /**
   * 从Ftp服务器下载sRemoteFile文件到本地文件中
   * @param sRemoteFile    ftp服务器中的文件
   * @param sLocalFile     下载后的本地文件
   * @throws java.lang.Exception
   */
  public static void ftpDownloadFile(String sRemoteFile, String sLocalFile) throws Exception{
    PropertiesInfo p = new PropertiesInfo("adc.properties");
    FtpClient fc = new FtpClient(p.getServerName());
    fc.login(p.getUserName(), p.getPassword()) ;
    fc.setPassive(true) ;
    fc.getFile(sRemoteFile, sLocalFile) ;
    fc.closeServer() ;
    return ;
  }

  /**
   * 上传sLocalFile文件到ftp服务器中sRemoteFile
   * @param sLocalFile     待上传的本地文件
   * @param sRemoteFile    上传后ftp服务器中的文件
   * @throws java.lang.Exception
   */
  public static void ftpUploadFile(String sLocalFile, String sRemoteFile) throws Exception{
    PropertiesInfo p = new PropertiesInfo("adc.properties");
    FtpClient fc = new FtpClient(p.getServerName());
    fc.login(p.getUserName(), p.getPassword()) ;
    fc.setPassive(true) ;
    fc.putFile(sRemoteFile, sLocalFile) ;
    fc.closeServer() ;
    return ;
  }

  public static void main(String[] argv) {
    try{
      ftpDownloadFile("abc.exe", "f:\\abc.exe") ;
      ftpUploadFile("f:\\abc.exe", "aa\\abc.exe") ;
      //deleteFtpPath("bb", "SubmitTemp.zip") ;
      String s = "f:\\aa\\3.txt";
      //System.out.println(fileCopy("f:\\aa\\1.txt", "f:\\aa\\2.txt"));
      System.out.println(getFileName(s) );
      System.out.println(getFileExtentName(s) );
      System.out.println(getFilePath(s) );

      s= getTimeString() ;
      System.out.println(s);
      System.out.println(s.substring(0, 6));
      System.out.println(s.substring(6, s.length()));

      s = "aa.ba.cd.hg";
      System.out.println(s.replace('.', '\0'));
      System.out.println(s.replaceAll(".", ""));

    }catch(Exception e){
      e.printStackTrace() ;
    }
  }


}