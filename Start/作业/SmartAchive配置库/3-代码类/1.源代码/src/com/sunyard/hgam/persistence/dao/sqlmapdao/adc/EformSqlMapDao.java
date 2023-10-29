package com.sunyard.hgam.persistence.dao.sqlmapdao.adc;

import com.sunyard.hgam.persistence.dao.base.BaseSqlMapDao;
import com.sunyard.hgam.persistence.dao.iface.adc.EformDao;
import com.ibatis.db.dao.DaoException;
import com.sunyard.hgam.persistence.dao.beans.adc.EformFieldValue;
import java.util.List;
import com.sunyard.hgam.persistence.dao.beans.adc.EformDefine;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.beans.adc.EformFieldDefine;

/**
 *
 * <p>Title: HGAM</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author ֣��ȫ
 * @version 1.0
 */
public class EformSqlMapDao extends BaseSqlMapDao implements EformDao {
  //ȡ�����еĵ��ӱ�����
  public List getAllEformDefine(){
    List list = null;
    try {
      this.startTransation();
      list = this.executeQueryForList("getAllEformDefine", null);
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

  //���ݵ��ӱ�IDȡ�õ��ӱ����ֶζ���
  public List getEformFieldDefineByEformId(String eformId){
    List list = null;
    try {
      this.startTransation();
      list = this.executeQueryForList("getEformFieldDefineByEformId", eformId);
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

  //����һ�����ӱ��ֶ�ֵ��¼
  public int addEformFieldValue(EformFieldValue eformFieldValue){
    int iResult = 0;
    try {
      //����
      //ִ�в������
      this.startTransation();
      iResult = this.executeUpdate("addEformFieldValue", eformFieldValue);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return iResult;
  }

  //ȡ�õ��ӱ����ֶ�ֵ��Ϣ
  public List getEformFieldValueInfoByFileId(String fileId){
    List list = null;
    try {
      this.startTransation();
      list = this.executeQueryForList("getEformFieldValueInfoByFileId", fileId);
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

  //��ȡ���̽׶ζ����¼
  public List getProjectPhaseList(){
    List list = null;
    try {
      this.startTransation();
      list = this.executeQueryForList("getProjectPhaseList", null);
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

  //��ȡ�ֶ����Ͷ����¼
  public List getFieldTypeList(){
    List list = null;
    try {
      this.startTransation();
      list = this.executeQueryForList("getFieldTypeList", null);
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

  //ɾ��һ�����ӱ��ֶ�ֵ��¼
  public int deleteEformFieldValueByFileId(String fileId){
    int iResult = 0;
    try {
      //����
      this.startTransation();
      iResult = this.executeUpdate("deleteEformFieldValueByFileId", fileId);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return iResult;

  }

  //������Ŀ���ȡ����Ŀ��Ҫ��Ϣ
  public List getProjBriefByProjId(Map projIdMap){
    List list = null;
    try {
      this.startTransation();
      list = this.executeQueryForList("getProjBriefByProjId", projIdMap);
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

  //ȡ����Ŀ��Ҫ�ֶμ���
  public List getProjBriefFields(){
    List list = null;
    try {
      this.startTransation();
      list = this.executeQueryForList("getProjBriefFields", null);
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

  //ȡ����Ҫ��ӡ���ֶ�
  public List getPrintFieldValue(String archivesId){
    List list = null;
    try {
      this.startTransation();
      list = this.executeQueryForList("getPrintFieldValue", archivesId);
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

  //����2�������࣬������Ŀ����ȡ�ø������չ�ֶ����ڵı�
  public EformDefine getEformDefineByEntryId(String entryId){
    EformDefine eformDefine = null;
    try {
      this.startTransation();
      eformDefine = (EformDefine) this.executeQueryForObject("getEformDefineByEntryId",entryId);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return eformDefine;
  }

  //����2�������࣬���ݶ�����Ŀ����ȡ�ø������չ�ֶζ�����Ϣ
  public List getEformFieldsByEntryId(String entryId){
    List list = null;
    try {
      this.startTransation();
      list = this.executeQueryForList("getEformFieldsByEntryId", entryId);
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

  //����2�������࣬����һ����Ŀ����ȡ�ø������չ�ֶζ�����Ϣ
  public List getEformFieldsByFirstEntryId(String entryId){
    List list = null;
    try {
      this.startTransation();
      list = this.executeQueryForList("getEformFieldsByFirstEntryId", entryId);
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

  //���ӱ�������
  //��ѯ���ӱ��б�
  public PaginatedList queryEformDefineList(EformDefine eformDefine){
    return queryEformDefineList(eformDefine,this.PAGE_SIZE);
  }
  public PaginatedList queryEformDefineList(EformDefine eformDefine,int pageSize){
    PaginatedList list = null;
    try {
      this.startTransation();
      list = this.executeQueryForPaginatedList("queryEformDefineList", eformDefine, pageSize);
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

  //��ѯ���ֶ��б�
  public PaginatedList queryFieldDefineList(EformFieldDefine eformFieldDefine){
    return queryFieldDefineList(eformFieldDefine,this.PAGE_SIZE);
  }
  public PaginatedList queryFieldDefineList(EformFieldDefine eformFieldDefine,int pageSize){
    PaginatedList list = null;
    try {
      this.startTransation();
      list = this.executeQueryForPaginatedList("queryFieldDefineList", eformFieldDefine, pageSize);
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
  //���ݱ�IDȡ�õ��ӱ���Ϣ
  public EformDefine getEformDefineByEformId(String eformId){
    EformDefine eformDefine = null;
    try {
      this.startTransation();
      eformDefine = (EformDefine) this.executeQueryForObject("getEformDefineByEformId",eformId);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return eformDefine;
  }

  //�����ֶ�IDȡ��ָ���ֶ���Ϣ
  public EformFieldDefine getFieldDefineByFieldId(String field_id){
    EformFieldDefine eformFieldDefine = null;
    try {
      this.startTransation();
      eformFieldDefine = (EformFieldDefine) this.executeQueryForObject("getFieldDefineByFieldId",field_id);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return eformFieldDefine;
  }
  //���µ��ӱ���Ϣ
  public int updateEformDefine(EformDefine eformDefine){
    int nRet = 0;
    try {
      this.startTransation();
      nRet = this.executeUpdate("updateEformDefine", eformDefine);
      this.commitTransation();
    }
    catch (Exception ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return nRet;
  }
  //�������ӱ���Ϣ
  public int addEformDefine(EformDefine eformDefine){
    int iResult = 0;
    try {
      this.startTransation();
      iResult = this.executeUpdate("addEformDefine", eformDefine);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return iResult;
  }

  //ɾ�����ӱ���Ϣ
  public int deleteEformDefine(String eform_id) throws Exception{
    int iResult = 0;
    try {
      this.startTransation();
      iResult = this.executeUpdate("deleteEformDefine", eform_id);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) {}
      throw new Exception("���ڱ��Ѿ�ʹ�ã��ʲ���ɾ����\n������ϢΪ��\n" + ex);
    }
    return iResult;
  }

  //�����ֶ���Ϣ
  public int updateFieldDefine(EformFieldDefine eformFieldDefine){
    int nRet = 0;
    try {
      this.startTransation();
      nRet = this.executeUpdate("updateFieldDefine", eformFieldDefine);
      this.commitTransation();
    }
    catch (Exception ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return nRet;
  }

  //�����ֶ���Ϣ
  public int addFieldDefine(EformFieldDefine eformFieldDefine){
    int iResult = 0;
    try {
      this.startTransation();
      iResult = this.executeUpdate("addFieldDefine", eformFieldDefine);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return iResult;
  }

  //ɾ���ֶ���Ϣ
  public int deleteFieldDefine(String field_id) throws Exception{
    int iResult = 0;
    try {
      this.startTransation();
      iResult = this.executeUpdate("deleteFieldDefine", field_id);
      this.commitTransation();
    }
    catch (DaoException ex) {
      try {
        this.rollbackTransation();
      }
      catch (Exception ex2) {}
      throw new Exception("�����ֶ��ѱ����ã��ʲ���ɾ����\n������ϢΪ��\n" + ex);
    }
    return iResult;
  }


  //��ѯ����ѡ�ֶ��б�
  public PaginatedList getFieldDefineListForSelectByEformId(EformFieldDefine eformFieldDefine){
    return getFieldDefineListForSelectByEformId(eformFieldDefine,this.PAGE_SIZE);
  }
  public PaginatedList getFieldDefineListForSelectByEformId(EformFieldDefine eformFieldDefine,int pageSize){
    PaginatedList list = null;
    try {
      this.startTransation();
      list = this.executeQueryForPaginatedList("getFieldDefineListForSelectByEformId", eformFieldDefine, pageSize);
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
  //ɾ����ָ�����ֶ�
  public int deleteEformField(List eformField){
    int iResult = 0;
    try {
      this.startTransation();
      EformFieldDefine eformFieldDefine = null;
      for(int i=0;i<eformField.size();i++){
        eformFieldDefine = (EformFieldDefine) eformField.get(i);
        iResult = this.executeUpdate("deleteEformField", eformFieldDefine);
      }
      this.commitTransation();
    }
    catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return iResult;
  }

  //���±�ָ�����ֶΣ��ֶ�˳��
  public int updateEformField(List eformField){
    int iResult = 0;
    try {
      this.startTransation();
      EformFieldDefine eformFieldDefine = null;
      for(int i=0;i<eformField.size();i++){
        eformFieldDefine = (EformFieldDefine) eformField.get(i);
        iResult = this.executeUpdate("updateEformField", eformFieldDefine);
      }
      this.commitTransation();
    }
    catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return iResult;
  }

  //���ӱ�ָ�����ֶΣ�����������Դ���
  public int addEformField(List eformField){
    int iResult = 0;
    try {
      this.startTransation();
      EformFieldDefine eformFieldDefine = null;
      for(int i=0;i<eformField.size();i++){
        eformFieldDefine = (EformFieldDefine) eformField.get(i);
        iResult = this.executeUpdate("addEformField", eformFieldDefine);
      }
      this.commitTransation();
    }
    catch (DaoException ex) {
      try { this.rollbackTransation(); } catch (Exception ex2) {}
      ex.printStackTrace();
    }
    return iResult;
  }

  //��ѯ�ֶζ�Ӧ�ĵ��ӱ��б�
  public List queryFieldEformList(String field_id){
    List list = null;
    try {
      this.startTransation();
      list = this.executeQueryForList("queryFieldEformList", field_id);
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


}