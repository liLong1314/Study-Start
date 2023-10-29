package com.sunyard.hgam.persistence.dao.sqlmapdao.smm;

import com.sunyard.hgam.persistence.dao.base.BaseSqlMapDao;
import com.sunyard.hgam.persistence.dao.iface.smm.ThemeDao;
import com.ibatis.common.util.PaginatedList;
import com.ibatis.db.dao.DaoException;
import com.sunyard.hgam.persistence.dao.beans.smm.Theme;

/**
 * <p>Title:����ʹ���</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author ������
 * @version 1.0
 */

public class ThemeSqlMapDao
    extends BaseSqlMapDao
    implements ThemeDao{
  public PaginatedList getAllTheme() {
    return getAllTheme(this.PAGE_SIZE);
  }

  public PaginatedList getAllTheme(int pageSize) {
    PaginatedList list = null;
    try {
      this.startTransation();
      list = this.executeQueryForPaginatedList("getAllTheme", null, pageSize);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) { /* ignore */ }
      ex.printStackTrace();
    }
    return list;
  }
  public PaginatedList searchTheme(Theme theme) {
      return searchTheme(theme, this.PAGE_SIZE);
    }

    public PaginatedList searchTheme(Theme theme, int pageSize) {
      PaginatedList list = null;
      try {
        this.startTransation();
        list = this.executeQueryForPaginatedList("searchTheme", theme, pageSize);
        this.commitTransation();
      }
      catch (DaoException ex) {
        try { this.rollbackTransation(); } catch (Exception ex2) { /* ignore */ }
        ex.printStackTrace();
      }
      return list;
    }
    //����ID�õ�һ�������
  public Theme getTheme(String themeID) {
    Theme themeInfo = null;
    try {
      this.startTransation();
      themeInfo = (Theme)this.executeQueryForObject("getThemeByID", themeID);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    return themeInfo;
  }

    //���������
    public int addTheme(Theme theme) {
        int result = 0;
        try {
          this.startTransation();
          result = this.executeUpdate("addTheme", theme);
          this.commitTransation();
        }
        catch (DaoException ex) {
          try { this.rollbackTransation(); }
          catch (Exception ex2) { /* ignore */ }
          ex.printStackTrace();
        }

        return result;
      }
      //ɾ�������
 public int delTheme(String themeId) {
   int result = 0;
   try {
     this.startTransation();
     result = this.executeUpdate("deleteThemeByID", themeId);
     this.commitTransation();
   }
   catch (DaoException ex) {
     try {
       this.rollbackTransation();
     }
     catch (Exception ex2) { /* ignore */}
     ex.printStackTrace();
   }
   return result;
 }
 //�޸������
  public int modifyTheme(Theme theme) {
    int result = 0;
    try {
      this.startTransation();
      result = this.executeUpdate("updateTheme", theme);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) { /* ignore */}
      ex.printStackTrace();
    }
    return result;
  }




}