/**
 *File： PrintInfo.java
 *Copyright 2003 Hangzhou Sunyard System Engineering， Ltd.
 *All right reserved.
 *
 *Date               Author                     Changes
 *2004-2-9  hld@sunyard.com             Created
 *
 */
package com.sunyard.hgam.util.common;

import java.util.ArrayList;

/**
 * 封装打印信息的类。
 *
 * @author hld@sunyard.com
 * @version 1.00
 */
public class PrintInfo {
  private int left = 1; //打印的起始列
  private int height = 1; //打印的起始行
  private String templetFileName = ""; //模板文件
  private ArrayList printData = null; //封装要打印的数据

  //构造打印vbs函数代码
  public String getVBSCode() throws Exception{
    String VBSCode = "";

    //如果没有设置模板，直接返回空字符串
    if(this.templetFileName.length() == 0) {
      return VBSCode;
    }

    //如果ArrayList为null，返回空字符串
    if(printData == null) {
      return VBSCode;
    }

    VBSCode += "<script language=\"VBScript\">\n";
    VBSCode += "<!--\n";

    VBSCode += "Set xlApp = CreateObject(\"EXCEL.APPLICATION\")\n";
    VBSCode += "Set xlBook = xlApp.Workbooks.Open(\""+ this.templetFileName +"\")\n";
    VBSCode += "set xlsheet1 = xlBook.ActiveSheet\n";

    //设置excel单元格数据
    try {
      for (int iRow = 0; iRow < printData.size(); iRow++) {
        ArrayList myRow = (ArrayList) (printData.get(iRow));
        for (int iCol = 0; iCol < myRow.size(); iCol++) {
          int x = this.left + iCol;
          int y = this.height + iRow;
          String cellContent = (String) myRow.get(iCol);
          VBSCode += "xlSheet1.cells(" + y + "," + x + " ).value=\"" +
              cellContent + "\"\n";
        }
      }
    }catch(Exception ex) {
      ex.printStackTrace();
      throw ex;
    }

    VBSCode += "xlSheet1.Application.Visible = True\n";
    //VBSCode += "Set xlApp = Nothing\n";

    VBSCode += "-->\n";
    VBSCode += "</script>\n";

    return VBSCode;
  }

  public void test() {
    this.setTempletFileName("c:\\rollCatelog.xls");

    ArrayList arrayListCol = new ArrayList();
    ArrayList arrayListRow = null;
   // for(int i=0; i<20; i++) {
      arrayListRow = new ArrayList();
      arrayListRow.add(0,"杭州袜厂");
      arrayListCol.add(0,arrayListRow);

      arrayListRow = new ArrayList();
      arrayListRow.add(0,"特种载体类");
      arrayListCol.add(1,arrayListRow);

      arrayListRow = new ArrayList();
      arrayListRow.add(0,"杭州袜厂著名袜子商标的照片");
      arrayListCol.add(2,arrayListRow);

      arrayListRow = new ArrayList(4) ;

      arrayListRow.add(0,"自1993年12月至1993年12月");
      arrayListRow.add(1,"保管期限");
      arrayListRow.add(2,"");
      arrayListRow.add(3,"永久");
      arrayListCol.add(3,arrayListRow);

      arrayListRow = new ArrayList();
      arrayListRow.add(0,"本卷供2件2页");
      arrayListRow.add(1,"归档号");
      arrayListRow.add(2,"自1993年12月至1993年12月");
      arrayListRow.add(3,"");
      arrayListCol.add(4,arrayListRow);

      arrayListCol.add(5,new ArrayList());
      arrayListCol.add(6,new ArrayList());

      arrayListRow = new ArrayList();
      arrayListRow.add(0,"");
      arrayListRow.add(1,"J243");
      arrayListRow.add(2,"2");
      arrayListRow.add(3,"");
      arrayListRow.add(4,"401");
      arrayListCol.add(7,arrayListRow);

   // }

    this.setPrintData(arrayListCol);
  }

  public String getTempletFileName() {
    return templetFileName;
  }
  public ArrayList getPrintData() {
    return printData;
  }
  public int getLeft() {
    return left;
  }
  public int getHeight() {
    return height;
  }
  public void setHeight(int height) {
    this.height = height;
  }
  public void setLeft(int left) {
    this.left = left;
  }
  public void setPrintData(ArrayList printData) {
    this.printData = printData;
  }
  public void setTempletFileName(String templetFileName) {
    this.templetFileName = templetFileName;
  }

}
