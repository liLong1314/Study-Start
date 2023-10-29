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
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 郑先全
 * @version 1.0
 */
public interface EformDao {
  //取得所有的电子表单定义
  public List getAllEformDefine();

  //根据电子表单ID取得电子表单的字段定义
  public List getEformFieldDefineByEformId(String eformId);

  //插入一条电子表单字段值记录
  public int addEformFieldValue(EformFieldValue eformFieldValue);

  //取得电子表单的字段值信息
  public List getEformFieldValueInfoByFileId(String fileId);

  //获取工程阶段定义记录
  public List getProjectPhaseList();

  //获取字段类型定义记录
  public List getFieldTypeList();

  //删除指定文件的所有电子表单字段值记录
  public int deleteEformFieldValueByFileId(String fileId);

  //根据项目编号取得项目概要信息
  public List getProjBriefByProjId(Map projIdMap);

  //取得项目概要字段集合
  public List getProjBriefFields();

  //取得需要打印的字段
  public List getPrintFieldValue(String archivesId);

  //对于2－其他类，根据二级类目编码取得该类的扩展字段所在的表单
  public EformDefine getEformDefineByEntryId(String entryId);

  //对于2－其他类，根据二级类目编码取得该类的扩展字段定义信息
  public List getEformFieldsByEntryId(String entryId);

  //对于2－其他类，根据二级类目编码取得该类的扩展字段定义信息
  public List getEformFieldsByFirstEntryId(String entryId);

  //电子表单管理部分
  //查询电子表单列表
  public PaginatedList queryEformDefineList(EformDefine eformDefine);
  public PaginatedList queryEformDefineList(EformDefine eformDefine,int pageSize);
  //查询表单字段列表
  public PaginatedList queryFieldDefineList(EformFieldDefine eformFieldDefine);
  public PaginatedList queryFieldDefineList(EformFieldDefine eformFieldDefine,int pageSize);
  //根据表单ID取得电子表单信息
  public EformDefine getEformDefineByEformId(String eform_id);
  //根据字段ID取得指定字段信息
  public EformFieldDefine getFieldDefineByFieldId(String field_id);
  //更新电子表单信息
  public int updateEformDefine(EformDefine eformDefine);
  //新增电子表单信息
  public int addEformDefine(EformDefine eformDefine);
  //删除电子表单信息
  public int deleteEformDefine(String eform_id) throws Exception;
  //更新字段信息
  public int updateFieldDefine(EformFieldDefine eformFieldDefine);
  //新增字段信息
  public int addFieldDefine(EformFieldDefine eformFieldDefine);
  //删除字段信息
  public int deleteFieldDefine(String field_id) throws Exception;

  //查询表单可选字段列表
  public PaginatedList getFieldDefineListForSelectByEformId(EformFieldDefine eformFieldDefine);
  public PaginatedList getFieldDefineListForSelectByEformId(EformFieldDefine eformFieldDefine,int pageSize);
  //删除表单指定的字段
  public int deleteEformField(List eformField);
  //更新表单指定的字段（字段顺序）（多个，事务性处理）
  public int updateEformField(List eformField);
  //增加表单指定的字段（多个，事务性处理）
  public int addEformField(List eformField);
  //查询字段对应的电子表单列表
  public List queryFieldEformList(String field_id);

}