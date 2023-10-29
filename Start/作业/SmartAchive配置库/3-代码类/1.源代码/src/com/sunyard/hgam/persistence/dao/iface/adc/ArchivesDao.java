package com.sunyard.hgam.persistence.dao.iface.adc;

import com.sunyard.hgam.persistence.dao.beans.adc.Archives;
import java.util.List;
import com.ibatis.common.util.PaginatedList;

public interface ArchivesDao {
  //���ݵ���ID�����ص�����Ϣ
  public Archives getArchivesByArchivesID(int archives_id);

  //���ݵ���ID�����ص���������Ϣ
  public Archives getArchivesByArchivesID_BK(int archives_id);

  /*��������ȫ����addArchives���
  //���������స��
  public int addWenshuRollArchives(Archives archives);
  //����ҵ���స��
  public int addYewuRollArchives(Archives archives);
  //������
  public int addPieceArchives(Archives archives);
  */
  //����������������
  public int addArchives(Archives archives);

  //ȡ�����ĵ�����
  public Integer getMaxArchivesId();
  //ȡ�����İ����
  public Integer getMaxRollNum();
  //ȡ�����ļ��ţ��ұ���ţ�
  public Integer getMaxPieceNum();
  //ȡ�õ����Ƿ���ڵ��ж�
  public Boolean getIsExistArchivesNum(String archivesNum);
  //ȡ�ð�����Ƿ���ڵ��ж�
  public Boolean getIsExistRollNum(String rollNum);
  //ȡ�ü����Ƿ���ڵ��ж�
  public Boolean getIsExistPieceNum(String pieceNum);

  //��ѯ�����б�(Ĭ��)
  public PaginatedList queryArchivesList(Archives archives);
  //��ѯ�����б�(����ÿҳ��¼��)
  public PaginatedList queryArchivesList(Archives archives,int pageSize);

  //��ѯ�����б�(Ĭ��) xuxj
  public PaginatedList queryArchivesListCheck(Archives archives);
  //��ѯ�����б�(����ÿҳ��¼��)
  public PaginatedList queryArchivesListCheck(Archives archives,int pageSize);
  //���ݵ���ID���µ�����״̬�� archives_status
  public int updateArchivesStatusByArchivesID(Archives archives) throws Exception;
  //�޶�������Ϣ
  public int updateArchives(Archives archives) throws Exception;

}