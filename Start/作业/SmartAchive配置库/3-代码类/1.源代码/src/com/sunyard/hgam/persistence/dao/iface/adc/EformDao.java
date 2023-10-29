package com.sunyard.hgam.persistence.dao.iface.adc;

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
public interface EformDao {
  //ȡ�����еĵ��ӱ�����
  public List getAllEformDefine();

  //���ݵ��ӱ�IDȡ�õ��ӱ����ֶζ���
  public List getEformFieldDefineByEformId(String eformId);

  //����һ�����ӱ��ֶ�ֵ��¼
  public int addEformFieldValue(EformFieldValue eformFieldValue);

  //ȡ�õ��ӱ����ֶ�ֵ��Ϣ
  public List getEformFieldValueInfoByFileId(String fileId);

  //��ȡ���̽׶ζ����¼
  public List getProjectPhaseList();

  //��ȡ�ֶ����Ͷ����¼
  public List getFieldTypeList();

  //ɾ��ָ���ļ������е��ӱ��ֶ�ֵ��¼
  public int deleteEformFieldValueByFileId(String fileId);

  //������Ŀ���ȡ����Ŀ��Ҫ��Ϣ
  public List getProjBriefByProjId(Map projIdMap);

  //ȡ����Ŀ��Ҫ�ֶμ���
  public List getProjBriefFields();

  //ȡ����Ҫ��ӡ���ֶ�
  public List getPrintFieldValue(String archivesId);

  //����2�������࣬���ݶ�����Ŀ����ȡ�ø������չ�ֶ����ڵı�
  public EformDefine getEformDefineByEntryId(String entryId);

  //����2�������࣬���ݶ�����Ŀ����ȡ�ø������չ�ֶζ�����Ϣ
  public List getEformFieldsByEntryId(String entryId);

  //����2�������࣬���ݶ�����Ŀ����ȡ�ø������չ�ֶζ�����Ϣ
  public List getEformFieldsByFirstEntryId(String entryId);

  //���ӱ�������
  //��ѯ���ӱ��б�
  public PaginatedList queryEformDefineList(EformDefine eformDefine);
  public PaginatedList queryEformDefineList(EformDefine eformDefine,int pageSize);
  //��ѯ���ֶ��б�
  public PaginatedList queryFieldDefineList(EformFieldDefine eformFieldDefine);
  public PaginatedList queryFieldDefineList(EformFieldDefine eformFieldDefine,int pageSize);
  //���ݱ�IDȡ�õ��ӱ���Ϣ
  public EformDefine getEformDefineByEformId(String eform_id);
  //�����ֶ�IDȡ��ָ���ֶ���Ϣ
  public EformFieldDefine getFieldDefineByFieldId(String field_id);
  //���µ��ӱ���Ϣ
  public int updateEformDefine(EformDefine eformDefine);
  //�������ӱ���Ϣ
  public int addEformDefine(EformDefine eformDefine);
  //ɾ�����ӱ���Ϣ
  public int deleteEformDefine(String eform_id) throws Exception;
  //�����ֶ���Ϣ
  public int updateFieldDefine(EformFieldDefine eformFieldDefine);
  //�����ֶ���Ϣ
  public int addFieldDefine(EformFieldDefine eformFieldDefine);
  //ɾ���ֶ���Ϣ
  public int deleteFieldDefine(String field_id) throws Exception;

  //��ѯ����ѡ�ֶ��б�
  public PaginatedList getFieldDefineListForSelectByEformId(EformFieldDefine eformFieldDefine);
  public PaginatedList getFieldDefineListForSelectByEformId(EformFieldDefine eformFieldDefine,int pageSize);
  //ɾ����ָ�����ֶ�
  public int deleteEformField(List eformField);
  //���±�ָ�����ֶΣ��ֶ�˳�򣩣�����������Դ���
  public int updateEformField(List eformField);
  //���ӱ�ָ�����ֶΣ�����������Դ���
  public int addEformField(List eformField);
  //��ѯ�ֶζ�Ӧ�ĵ��ӱ��б�
  public List queryFieldEformList(String field_id);

}