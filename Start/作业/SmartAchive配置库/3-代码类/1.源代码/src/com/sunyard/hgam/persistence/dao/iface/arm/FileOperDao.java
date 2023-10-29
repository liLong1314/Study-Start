package com.sunyard.hgam.persistence.dao.iface.arm;

import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.beans.arm.Identify;
import com.sunyard.hgam.persistence.dao.beans.arm.Destroy;
import com.sunyard.hgam.persistence.dao.beans.arm.FileOper;

/**
 * <p>Title: ������Ϣ�����ļ�����</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author Ҷ�
 * @version 1.0
 */

public interface FileOperDao {
  public PaginatedList getFiles(String archiveId);
  public PaginatedList getFiles(String archiveId,int pageSize);
  public PaginatedList queryFiles(FileOper fileOper);
  public PaginatedList queryFiles(FileOper fileOper,int pageSize);
  public PaginatedList getIdentFiles(String archiveId);
  public PaginatedList getIdentFiles(String archiveId,int pageSize);
  public int updateIdentFile(Identify identify);
  public PaginatedList getDestroyFiles(String archiveId);
  public PaginatedList getDestroyFiles(String archiveId,int pageSize);
  public int updateDestroyFile(Destroy destroy);
}