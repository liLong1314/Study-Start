package com.sunyard.hgam.util.aum;

import java.util.List;
import java.util.ArrayList;

/**
 * <p>Title: HGAM</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author wanghua
 * @version 1.0
 */

public class PagingHelper {

  private List aList = new ArrayList(); //包含所有数据的列表
  private int pageAmount = 0;           //总页面数
  private int pageIndex = 1;            //当前页面
  private int pageSize = 10;            //页面大小
  private int amountOfObject = 0;       //总记录数
  private String firstPage = "";        //是否为第一页
  private String lastPage = "";         //是否为最后一页


  /**
   * 构造函数
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
   * 到第一页
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
   * 到下一页
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
   * 判断是否为最后一页
   */
  public boolean lastPage() {
    boolean isLast = true;
    if (pageIndex < pageAmount)
      isLast = false;

    return isLast;
  }


  /**
   * 到前一页
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
   * 到最后一页
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
   * 转到指定页面
   * @param selectedPageNumber 指定页面
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
   * 是否为第一页
   */
  public boolean firstPage() {
    boolean isFirst = false;
    if (pageIndex == 1)
      isFirst = true;
    return isFirst;
  }


  /**
   * 当前页游标后移一页
   */
  public void increasePageIndex() {
    this.pageIndex++;
  }


  /**
   * 当前游标向前移一页
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