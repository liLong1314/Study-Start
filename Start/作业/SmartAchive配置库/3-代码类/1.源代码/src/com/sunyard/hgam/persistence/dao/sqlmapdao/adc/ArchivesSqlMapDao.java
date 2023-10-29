package com.sunyard.hgam.persistence.dao.sqlmapdao.adc;

import com.sunyard.hgam.persistence.dao.base.BaseSqlMapDao;
import java.util.List;
import com.sunyard.hgam.persistence.dao.iface.adc.ArchivesDao;
import com.ibatis.db.dao.DaoException;
import com.sunyard.hgam.persistence.dao.beans.adc.Archives;
import com.ibatis.common.util.PaginatedList;

public class ArchivesSqlMapDao extends BaseSqlMapDao implements ArchivesDao {
  /*��������ȫ����addArchives���
  //���������స��
  public int addWenshuRollArchives(Archives archives){
    int iResult = 0;
    try {
      //ִ�в������
      this.startTransation();
      iResult = this.executeUpdate("addWenshuRollArchives", archives);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return iResult;
  }

  //����ҵ���స��
  public int addYewuRollArchives(Archives archives){
    int iResult = 0;
    try {
      //ִ�в������
      this.startTransation();
      iResult = this.executeUpdate("addYewuRollArchives", archives);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return iResult;
  }

  public int addPieceArchives(Archives archives){
    int iResult = 0;
    try {
      //ִ�в������
      this.startTransation();
      iResult = this.executeUpdate("addPieceArchives", archives);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return iResult;
  }*/

  //����������������
  public int addArchives(Archives archives){
    int iResult = 0;
    try {
      //ִ�в������
      this.startTransation();
      iResult = this.executeUpdate("addArchives", archives);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return iResult;
  }


  //ȡ�����ĵ���ID
  public Integer getMaxArchivesId() {
    Integer maxId = null;
    try {
      this.startTransation();
      maxId = (Integer)this.executeQueryForObject("getMaxArchivesId", null);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return maxId;
  }

  //ȡ�����İ����
  public Integer getMaxRollNum() {
    Integer maxId = null;
    try {
      this.startTransation();
      maxId = (Integer)this.executeQueryForObject("getMaxRollNum", null);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return maxId;
  }

  //ȡ�����ļ��ţ��ұ���ţ�
  public Integer getMaxPieceNum(){
    Integer maxId = null;
    try {
      this.startTransation();
      maxId = (Integer)this.executeQueryForObject("getMaxPieceNum", null);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return maxId;

  }

  //ȡ�õ����Ƿ���ڵ��ж�
  public Boolean getIsExistArchivesNum(String archivesNum) {
    boolean blnResult = false;
    int rowCount = 0;
    try {
      this.startTransation();
      rowCount = ((Integer)this.executeQueryForObject("getIsExistArchivesNum", archivesNum)).intValue();
      if (rowCount>0){
        blnResult = true;
      }
      this.commitTransation();
    }
    catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return Boolean.valueOf(blnResult);
  }

  //ȡ�ð�����Ƿ���ڵ��ж�
  public Boolean getIsExistRollNum(String rollNum) {
    boolean blnResult = false;
    int rowCount = 0;
    try {
      this.startTransation();
      rowCount = ((Integer)this.executeQueryForObject("getIsExistRollNum", rollNum)).intValue();
      if (rowCount>0){
        blnResult = true;
      }
      this.commitTransation();
    }
    catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return Boolean.valueOf(blnResult);
  }

  //ȡ�ð�����Ƿ���ڵ��ж�
  public Boolean getIsExistPieceNum(String pieceNum) {
    boolean blnResult = false;
    int rowCount = 0;
    try {
      this.startTransation();
      rowCount = ((Integer)this.executeQueryForObject("getIsExistPieceNum", pieceNum)).intValue();
      if (rowCount>0){
        blnResult = true;
      }
      this.commitTransation();
    }
    catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return Boolean.valueOf(blnResult);
  }

  //��ѯ�����б�(Ĭ��)
  public PaginatedList queryArchivesList(Archives archives){
    return queryArchivesList(archives,this.PAGE_SIZE);
  }
  //��ѯ�����б�(����ÿҳ��¼��)
  public PaginatedList queryArchivesList(Archives archives,int pageSize){
    PaginatedList list = null;
    try {
      this.startTransation();
      list = this.executeQueryForPaginatedList("queryArchivesList", archives, pageSize);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return list;
  }

  //��ѯ�����б�(Ĭ��)
  public PaginatedList queryArchivesListCheck(Archives archives){
    return queryArchivesListCheck(archives,this.PAGE_SIZE);
  }
  //��ѯ�����б�(����ÿҳ��¼��)
  public PaginatedList queryArchivesListCheck(Archives archives,int pageSize){
    PaginatedList list = null;
    try {
      this.startTransation();
      list = this.executeQueryForPaginatedList("queryArchivesListCheck", archives, pageSize);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return list;
  }

  //���ݵ���ID�����ص�����Ϣ
  public Archives getArchivesByArchivesID(int archives_id){
    Archives aRet = null;
    try {
      this.startTransation();
      aRet = (Archives)this.executeQueryForObject("getArchivesByArchivesID",
                                                  new Integer(archives_id));
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return aRet;
  }

  //���ݵ���ID���µ�����״̬�� archives_status
  public int updateArchivesStatusByArchivesID(Archives archives) throws Exception{
    int nRet = 0;
    try {
      this.startTransation();
      nRet = this.executeUpdate("updateArchivesStatusByArchivesID",
                                                 archives);
      this.commitTransation();
    }
    catch (Exception ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      throw ex;
    }
    return nRet;
  }

  //�޶�������Ϣ
  public int updateArchives(Archives archives) throws Exception{
    int nRet = 0;
    try {
      this.startTransation();
      nRet = this.executeUpdate("updateArchives",archives);
      this.commitTransation();
    }
    catch (Exception ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      throw ex;
    }
    return nRet;
  }

  //���ݵ���ID�����ص����뱸������Ϣ
  public Archives getArchivesByArchivesID_BK(int archives_id){
    Archives aRet = null;
    try {
      this.startTransation();
      aRet = (Archives)this.executeQueryForObject("getArchivesByArchivesID_BK",
                                                  new Integer(archives_id));
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return aRet;
  }


}
