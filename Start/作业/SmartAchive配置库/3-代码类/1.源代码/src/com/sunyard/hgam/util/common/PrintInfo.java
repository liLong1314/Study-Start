/**
 *File�� PrintInfo.java
 *Copyright 2003 Hangzhou Sunyard System Engineering�� Ltd.
 *All right reserved.
 *
 *Date               Author                     Changes
 *2004-2-9  hld@sunyard.com             Created
 *
 */
package com.sunyard.hgam.util.common;

import java.util.ArrayList;

/**
 * ��װ��ӡ��Ϣ���ࡣ
 *
 * @author hld@sunyard.com
 * @version 1.00
 */
public class PrintInfo {
  private int left = 1; //��ӡ����ʼ��
  private int height = 1; //��ӡ����ʼ��
  private String templetFileName = ""; //ģ���ļ�
  private ArrayList printData = null; //��װҪ��ӡ������

  //�����ӡvbs��������
  public String getVBSCode() throws Exception{
    String VBSCode = "";

    //���û������ģ�壬ֱ�ӷ��ؿ��ַ���
    if(this.templetFileName.length() == 0) {
      return VBSCode;
    }

    //���ArrayListΪnull�����ؿ��ַ���
    if(printData == null) {
      return VBSCode;
    }

    VBSCode += "<script language=\"VBScript\">\n";
    VBSCode += "<!--\n";

    VBSCode += "Set xlApp = CreateObject(\"EXCEL.APPLICATION\")\n";
    VBSCode += "Set xlBook = xlApp.Workbooks.Open(\""+ this.templetFileName +"\")\n";
    VBSCode += "set xlsheet1 = xlBook.ActiveSheet\n";

    //����excel��Ԫ������
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
      arrayListRow.add(0,"�����೧");
      arrayListCol.add(0,arrayListRow);

      arrayListRow = new ArrayList();
      arrayListRow.add(0,"����������");
      arrayListCol.add(1,arrayListRow);

      arrayListRow = new ArrayList();
      arrayListRow.add(0,"�����೧���������̱����Ƭ");
      arrayListCol.add(2,arrayListRow);

      arrayListRow = new ArrayList(4) ;

      arrayListRow.add(0,"��1993��12����1993��12��");
      arrayListRow.add(1,"��������");
      arrayListRow.add(2,"");
      arrayListRow.add(3,"����");
      arrayListCol.add(3,arrayListRow);

      arrayListRow = new ArrayList();
      arrayListRow.add(0,"����2��2ҳ");
      arrayListRow.add(1,"�鵵��");
      arrayListRow.add(2,"��1993��12����1993��12��");
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
