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
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 郑先全
 * @version 1.0
 */
public class EformSqlMapDao extends BaseSqlMapDao implements EformDao {
  //取得所有的电子表单定义
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

  //根据电子表单ID取得电子表单的字段定义
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

  //插入一条电子表单字段值记录
  public int addEformFieldValue(EformFieldValue eformFieldValue){
    int iResult = 0;
    try {
      //设置
      //执行插入操作
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

  //取得电子表单的字段值信息
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

  //获取工程阶段定义记录
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

  //获取字段类型定义记录
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

  //删除一条电子表单字段值记录
  public int deleteEformFieldValueByFileId(String fileId){
    int iResult = 0;
    try {
      //操作
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

  //根据项目编号取得项目概要信息
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

  //取得项目概要字段集合
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

  //取得需要打印的字段
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

  //对于2－其他类，根据类目编码取得该类的扩展字段所在的表单
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

  //对于2－其他类，根据二级类目编码取得该类的扩展字段定义信息
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

  //对于2－其他类，根据一级类目编码取得该类的扩展字段定义信息
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

  //电子表单管理部分
  //查询电子表单列表
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

  //查询表单字段列表
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
  //根据表单ID取得电子表单信息
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

  //根据字段ID取得指定字段信息
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
  //更新电子表单信息
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
  //新增电子表单信息
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

  //删除电子表单信息
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
      throw new Exception("由于表单已经使用，故不可删除！\n具体信息为：\n" + ex);
    }
    return iResult;
  }

  //更新字段信息
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

  //新增字段信息
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

  //删除字段信息
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
      throw new Exception("由于字段已被引用，故不可删除！\n具体信息为：\n" + ex);
    }
    return iResult;
  }


  //查询表单可选字段列表
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
  //删除表单指定的字段
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

  //更新表单指定的字段（字段顺序）
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

  //增加表单指定的字段（多个，事务性处理）
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

  //查询字段对应的电子表单列表
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