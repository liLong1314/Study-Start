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
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author not attributable
 * @version 1.0
 */

public class AdcUtil {

  /**
   *   �ж� sSrc �ַ�������ַ����Ƿ�ΪsAdd���粻��������sAdd�����أ����򷵻�sSrc
   * �ú������������ӡ�·�����еķָ����ȡ�
   * @param sSrc  Դ�ַ���
   * @param sAdd  ���ӵ��ַ���
   * @return String
   */
  public static String AttachString(String sSrc, String sAdd) {
    if(sSrc.endsWith(sAdd) == false)
      sSrc += sAdd;
    return sSrc;
  }

  /**
   * ��sPath�ļ����У�����sFolderName�ļ���
   * @param sPath
   * @param sFolderName     �½�Ŀ¼������
   * @return                ���sPath�����ڣ�����ʧ�ܣ�����false�������ɹ�true
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
   * ɾ��path��������·�����ļ�
   * @param path String ·����
   * @return
   * @throws Exception
   */
  public static boolean deletePath(String sPath) throws Exception {
    File path = new File(sPath);
    return deletePath(path);
  }

  /**
   * ɾ��path��������·�����ļ�
   * @param path  ·����File����
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
   * �����ļ�srcFile Ϊ desFile��
   * @param srcFile   Դ�ļ�
   * @param desFile   Ŀ���ļ�������Ѵ��ڣ��򸲸Ǵ��ļ�
   * @return          �����ɹ���־
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
   * �����ļ���������·���������ظ��ļ����ڵľ���·��
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
   * ����ȫ·���ļ��������ظ��ļ�����
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
   * �������ܣ�ѹ���ļ�
    ���������
      ZipOutputStream zipo  ����NULLֵ
      zipFileName   ѹ���ļ�ȫ·����
      beZipPath ��ѹ���ļ�ȫ·��
      String excludepath ѹ���ļ��в���Ҫ��¼��·�����֣�һ��ȡbeZipPath�ĸ�Ŀ¼��ȫ·����
    ���������
      ����ֵ��
       true�������ɹ�
       false:����ʧ��
   * �������ڣ�(2002-3-23 11:10:43)
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
   * �������ܣ���ѹ���ļ�
   ���������
     zipFileName:ѹ���ļ�ȫ·��
   ���������
     ����ֵ��
      true�������ɹ�
      false:����ʧ��
   * �������ڣ�(2002-3-23 11:10:43)
   */
  public static boolean UnzipFile(String zipFileName) throws Exception{
    try {
      //System.out.println("zipfilename:"+zipFileName);
      File f = new File(zipFileName);
      ZipFile zipFile = new ZipFile(zipFileName);
      if((!f.exists()) && (f.length() <= 0)) {
          throw new Exception("Ҫ��ѹ���ļ�������!");
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
          //��д�ļ�
          InputStream is = zipFile.getInputStream(zipEnt);
          BufferedInputStream bis = new BufferedInputStream(is);

          strtemp = strPath + "/" + zipEnt.getName();
          //gbkPath=new String(strtemp.getBytes("GBK"));
          //String  strsubdir=gbkPath.substring(0,gbkPath.lastIndexOf("/"));
          //strsubdir=strsubdir.replace('/','\\');
          //System.out.println(strsubdir);
          //��Ŀ¼
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
   * ����21λ��ʱ���ַ��� YYYYMMDD hhmmssSSSxxxx
   * @return
   */
  public static String getTimeString(){
    Random r = new Random();
    String sRet = Integer.toString(r.nextInt(10)).substring(0, 1);
    sRet = IDGenerator.getTimeString() + sRet ;
    return sRet;
  }

  /**
   * ����archives_id���õ�һ�������ڵ������ļ�����Ϣ����OptionBean��װ������Ҫ����Ϣ����
   * value=file_num+file_title, label=file_id��
   * �����û����޸������ļ�ʱѡ��
   *
   * @param archives_id ����ID
   * @return ��ѯ�Ľ������װ��OptionBean�����Iterator����file_id����label����
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
   * ����file_id�������ļ����+�ļ�����(file_num + file_title)
   * ( ���ڽ�����ʾfile_id===>�ļ����� )
   *
   * @param file_id �ļ�ID
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
   * ����ϵͳ����Operator����Ȩ�ޣ���OptionBean��װ������Ҫ����Ϣ����
   * value=name, label=id��
   *
   * @return ��ѯ�Ľ������װ��OptionBean�����Iterator
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
   * ����ϵͳ������ҳ��������OptionBean��װ������Ҫ����Ϣ����
   * value=name, label=id��
   *
   * @return ��ѯ�Ľ������װ��OptionBean�����Iterator
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
   * ���ݲ�������type������ֵvalue�����ز�������name
   * @param type    ��������
   * @param value   ��������
   * @return name   ���ز������ƣ����value�����ڣ��򷵻�value
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
   * ��OptionBean�����и���һ��value���õ���Ӧ��label
   * @param iterator ��װ��OptionBean�ļ���
   * @param value Ҫ���ҵ�value
   * @return value��Ӧ��label
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
   * �����ܼ�����secretId ��������
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
   * FTP������ɾ��·��path�µ��ļ�file�������·����û���ļ���ֻ��һ���ļ�file����ɾ����·��
   * @param path String ·����
   * @return
   * @throws Exception
   */
  public static boolean deleteFtpPath(String sPath, String sFile) throws Exception {
    try{
      PropertiesInfo p = new PropertiesInfo("adc.properties");
      String s = p.getFtproot();
      FtpClient f = new FtpClient(p.getServerName());
      f.login(p.getUserName(), p.getPassword());

      //ɾ���ļ�sFile
      if (sFile!=null && sFile.length()>0){
        String path = sFile;
        if (sPath!=null && sPath.length()>0)
          path = sPath + System.getProperty("file.separator") + sFile;
        try{
          f.delete(path);
        }catch(Exception e){

        }
      }

      //ɾ��Ŀ¼
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
   * ��Ftp����������sRemoteFile�ļ��������ļ���
   * @param sRemoteFile    ftp�������е��ļ�
   * @param sLocalFile     ���غ�ı����ļ�
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
   * �ϴ�sLocalFile�ļ���ftp��������sRemoteFile
   * @param sLocalFile     ���ϴ��ı����ļ�
   * @param sRemoteFile    �ϴ���ftp�������е��ļ�
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