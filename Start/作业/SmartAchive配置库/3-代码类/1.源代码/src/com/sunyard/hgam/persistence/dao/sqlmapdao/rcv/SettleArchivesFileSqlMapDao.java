package com.sunyard.hgam.persistence.dao.sqlmapdao.rcv;

import java.util.List;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.beans.adc.ArchivesFile;
import com.sunyard.hgam.persistence.dao.base.BaseSqlMapDao;
import com.ibatis.db.dao.DaoException;
import com.sunyard.hgam.persistence.dao.beans.adc.ArchivesPage;
import com.sunyard.hgam.util.rcv.FileUtil;
import com.sunyard.hgam.persistence.dao.iface.rcv.SettleArchivesFileDao;

public class SettleArchivesFileSqlMapDao
    extends BaseSqlMapDao
    implements SettleArchivesFileDao {
  public SettleArchivesFileSqlMapDao() {
  }
  //根据查询条件，返回文件列表(默认)
  public PaginatedList querySettleArchivesFileList(ArchivesFile archivesFile){
    return querySettleArchivesFileList(archivesFile,this.PAGE_SIZE) ;
  }
  //根据查询条件，返回文件列表(定制每页记录数)
  public PaginatedList querySettleArchivesFileList(ArchivesFile archivesFile,int pageSize){
    PaginatedList lstRet = null;
    try {
      this.startTransation();
      lstRet = this.executeQueryForPaginatedList("querySettleArchivesFileList",
                                               archivesFile, pageSize);
      this.commitTransation();
    }catch(Exception e){
      try { this.rollbackTransation(); } catch (Exception ex2) {}
    }
    return lstRet ;
  }

}
