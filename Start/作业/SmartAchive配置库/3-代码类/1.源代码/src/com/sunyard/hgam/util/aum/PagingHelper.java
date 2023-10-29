package com.sunyard.hgam.util.aum;

import java.util.List;
import java.util.ArrayList;

/**
 * <p>Title: HGAM</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author wanghua
 * @version 1.0
 */

public class PagingHelper {

  private List aList = new ArrayList(); //�����������ݵ��б�
  private int pageAmount = 0;           //��ҳ����
  private int pageIndex = 1;            //��ǰҳ��
  private int pageSize = 10;            //ҳ���С
  private int amountOfObject = 0;       //�ܼ�¼��
  private String firstPage = "";        //�Ƿ�Ϊ��һҳ
  private String lastPage = "";         //�Ƿ�Ϊ���һҳ


  /**
   * ���캯��
   */
  public PagingHelper(List aList, int pageSize) {
    this.aList = aList;
    this.pageSize = pageSize;
    this.amountOfObject = aList.size();
    if (aList.size() % pageSize == 0)
      this.pageAmount = aList.size() / pageSize;
    else
      this.pageAmount = aList.size() / pageSize + 1;
    if (aList == null || aList.size() <= 0) {
      this.setPageIndex(0);
      this.setAmountOfObject(0);
    }
  }


  /**
   * ����һҳ
   */
  public List goFirst() {
    List retList = new ArrayList();
    List tmpList = new ArrayList();
    tmpList = aList.subList(0, this.getAmountOfObject());
    if (tmpList.size() > pageSize) {
      retList = aList.subList(0, pageSize);
      this.setFirstPage("1");
      this.setLastPage("0");
    }
    else {
      retList = tmpList;
      this.setFirstPage("1");
      this.setLastPage("1");
    }
    this.setPageIndex(1);
    return retList;
  }


  /**
   * ����һҳ
   */
  public List goNext() {
    List retList = new ArrayList();
    if (!this.lastPage()) {
      List tmpList = new ArrayList();
      tmpList = aList.subList(pageIndex * pageSize,
                              this.getAmountOfObject());
      if (tmpList.size() >= pageSize)
        retList = aList.subList(pageIndex * pageSize,
                                pageIndex * pageSize + pageSize);
      else
        retList = tmpList;
    }
    this.increasePageIndex();
    return retList;
  }


  /**
   * �ж��Ƿ�Ϊ���һҳ
   */
  public boolean lastPage() {
    boolean isLast = true;
    if (pageIndex < pageAmount)
      isLast = false;

    return isLast;
  }


  /**
   * ��ǰһҳ
   */
  public List goPrevious() {
    List retList = new ArrayList();
    if (!this.firstPage()) {
      int tmpPageIndex = pageIndex - 2;
      retList = this.aList.subList(tmpPageIndex * pageSize,
                                   tmpPageIndex * pageSize + pageSize);
    }
    this.decreasePageIndex();
    return retList;
  }


  /**
   * �����һҳ
   */
  public List goLast() {
    List retList = new ArrayList();
    if (!this.lastPage()) {
      int tmpPageIndex = this.getPageAmount() - 1;
      retList = this.aList.subList(tmpPageIndex * pageSize,
                                   this.getAmountOfObject());
    }
    this.setPageIndex(this.getPageAmount());
    return retList;
  }


  /**
   * ת��ָ��ҳ��
   * @param selectedPageNumber ָ��ҳ��
   */
  public List goSelectedPage(int selectedPageNumber) {
    List retList = new ArrayList();
    int tmpPageIndex = 0;
    tmpPageIndex = selectedPageNumber - 1;
    this.setPageIndex(selectedPageNumber);
    if (!this.lastPage()) {
      retList = this.aList.subList(tmpPageIndex * pageSize,
                                   tmpPageIndex * pageSize + pageSize);
    }
    else {
      retList = this.aList.subList(tmpPageIndex * pageSize,
                                   this.getAmountOfObject());
    }
    return retList;
  }


  /**
   * �Ƿ�Ϊ��һҳ
   */
  public boolean firstPage() {
    boolean isFirst = false;
    if (pageIndex == 1)
      isFirst = true;
    return isFirst;
  }


  /**
   * ��ǰҳ�α����һҳ
   */
  public void increasePageIndex() {
    this.pageIndex++;
  }


  /**
   * ��ǰ�α���ǰ��һҳ
   */
  public void decreasePageIndex() {
    this.pageIndex--;
  }

  public int getPageIndex() {
    return pageIndex;
  }

  public int getPageAmount() {
    return pageAmount;
  }

  public void setPageAmount(int pageAmount) {
    this.pageAmount = pageAmount;
  }

  public void setPageIndex(int pageIndex) {
    this.pageIndex = pageIndex;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  public int getPageSize() {
    return pageSize;
  }

  public List getAList() {
    return aList;
  }

  public void setAList(List aList) {
    this.aList = aList;
  }

  public int getAmountOfObject() {
    return amountOfObject;
  }

  public void setAmountOfObject(int amountOfObject) {
    this.amountOfObject = amountOfObject;
  }

  public void setFirstPage(String firstPage) {
    this.firstPage = firstPage;
  }

  public String getFirstPage() {
    return this.firstPage;
  }

  public void setLastPage(String lastPage) {
    this.lastPage = lastPage;
  }

  public String getLastPage() {
    return this.lastPage;
  }

  public static void main(String[] args) {
    List aList = new ArrayList();
    List bList = new ArrayList();
    for (int i = 1; i < 98; i++) {
      aList.add(Integer.toString(i));
    }
    PagingHelper o = new PagingHelper(aList, 10);
//    System.out.println(o.isFirstPage());
//    System.out.println(o.isLastPage());
//    System.out.println("----------------");
//    o.setPageIndex(8);
//    bList = o.goNext();
//    for (int i = 0; i < bList.size(); i++) {
//      System.out.println(bList.get(i));
//    }
//    System.out.println("----------------");
//    bList.clear();
//    bList = o.goPrevious();
//    for (int i = 0; i < bList.size(); i++) {
//      System.out.println(bList.get(i));
//    }

//    for (int i = 0; i < 9; i++) {
//      o.goNext();
//    }
//    System.out.println(o.isFirstPage());
//    System.out.println(o.isLastPage());

//    bList = o.goLast();
//    for (int i = 0; i < bList.size(); i++) {
//      System.out.println(bList.get(i));
//    }
//    System.out.println("current page:" + o.getPageIndex());

//    bList = o.goSelectedPage(10);
//    for (int i = 0; i < bList.size(); i++) {
//      System.out.println(bList.get(i));
//    }
//    System.out.println("current page:" + o.getPageIndex());

    o.goSelectedPage(10);
    bList = o.goFirst();
    for (int i = 0; i < bList.size(); i++) {
      System.out.println(bList.get(i));
    }
    System.out.println("current page:" + o.getPageIndex());

  }

}