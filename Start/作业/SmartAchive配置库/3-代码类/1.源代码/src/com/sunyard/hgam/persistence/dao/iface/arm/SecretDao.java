package com.sunyard.hgam.persistence.dao.iface.arm;

import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.beans.arm.Secret;
import java.util.List;

/**
 * <p>Title: �ܼ�����</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author Ҷ�
 * @version 1.0
 */

public interface SecretDao {

  public List getAllSecret();
  public int addSecret(Secret secret);
  public Secret getSecret(String secretID);
  public int modifySecret(Secret secret);
  public int delSecret(String secretId);

}