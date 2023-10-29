<%@ page contentType="text/html; charset=gb2312" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<html>
<head>
<title>表单字段查询</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<script language="javascript" src="../common/js/base.js"></script>
<style type="text/css">
<!--
body {
	background-image: url(../image/2_mainpagebg_01.gif);
}
.style1 {font-size: 14px}
-->
</style>
<script language="JavaScript" type="text/JavaScript">
<!--
//查询
function doQuery(theform){
	theform.submit();
}

//查看选中字段
function doGoto(field_id){
	window.location="viewFieldDefine.do?field_id=" + field_id;
}
//新增电子表单
function doAdd(form){
	window.location="/smm/field_define_add.jsp";
}
-->
</script>
</head>
<body class="bg-page01">
<html:form action="/smm/queryFieldDefineList" method="post" >
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="32"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="100%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#00A8CC">
                <tr>
                  <td align="center" bgcolor="#E4F2FA" class="style1">表单字段查询</td>
                </tr>
            </table></td>
          </tr>
      </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td align="center" bgcolor="#FFFFFF"> <br>
          <table width="100%" height="37" border="0">
            <tr>
            <td height="31">
              <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
                <tr bgcolor="#FFFFFF">
                  <td nowrap>字段名称:</td>
                  <td nowrap><html:text property="eformFieldDefine.field_cname" value="" size="20" maxlength="100"/>
		  </td>
                  <td nowrap>是否摘要字段:</td>
                  <td nowrap>
                <html:select property="eformFieldDefine.field_isBrief">
		<option value="">不限</option>
		<option value="1">是</option>
		<option value="0">否</option>
		</html:select>
		</td>
		<td width="40%" align="center"><input type="submit" name="b1" value="查询"></td>
                </tr>
              </table>
              </td>
            </tr>
        </table></td>
      <td background="../image/2_table_c_l.gif">&nbsp;</td>
    </tr>
    <tr>
      <td><img src="../image/2_table_r_b.gif" width="32" height="20"></td>
      <td background="../image/2_table_c_b.gif"><img src="../image/2_table_c_b.gif" width="115" height="20"></td>
      <td><img src="../image/2_table_l_b.gif" width="26" height="20"></td>
    </tr>
  </table>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="32"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="100%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#00A8CC">
                <tr>
                  <td align="center" bgcolor="#E4F2FA" class="style1">表单字段列表</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="4%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif"><img src="../image/2_table_c_r.gif" width="32" height="24"></td>

    <td align="center" bgcolor="#FFFFFF">
        <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#FFFFFF">
        <tr align="center" bgcolor="#F7EED9">
          <td nowrap>字段中文名称</td>
          <td nowrap>字段英文名称</td>
          <td nowrap>字段类型</td>
          <td nowrap>字段长度</td>
          <td nowrap>是否为空</td>
          <td nowrap>是否摘要字段</td>
        </tr>
	<logic:notPresent name="fieldDefineList">
	<tr align="center" bgcolor="#F7EED9">
          <td colspan=5>暂无记录</td>
        </tr>
	</logic:notPresent>
	<logic:present name="fieldDefineList">
	<logic:iterate id="list" name="fieldDefineList" >
        <tr align="center" style='cursor:hand' onMouseover="this.style.backgroundColor='#dff1ff'" onMouseOut="this.style.backgroundColor=''" onclick="doGoto('<bean:write name='list' property='field_id' />')">
          <td align="left"><bean:write name="list" property="field_cname" /></td>
          <td><bean:write name="list" property="field_ename" /></td>
          <td><bean:write name="list" property="field_type_id" /></td>
          <td><bean:write name="list" property="field_len" /></td>
          <td><bean:write name="list" property="field_isNull" /></td>
          <td><bean:write name="list" property="field_isBrief" /></td>
        </tr>
	</logic:iterate>
	</logic:present>
      </table>

      <logic:present name="fieldDefineList">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td bgcolor="#F7EED9"> <logic:notEqual name="fieldDefineList" property="firstPage" value="true" >
            <a href="?page=first">&lt;&lt;
            第一页 </a><a href="?page=previous">&lt;
            上一页 </a></logic:notEqual> <logic:notEqual name="fieldDefineList" property="lastPage" value="true" >
            <a href="?page=next">下一页
            &gt; </a><a href="?page=last">最后页
            &gt;&gt; </a></logic:notEqual>&nbsp; 共<bean:write name="fieldDefineList" property="rowAmount" />条记录&nbsp;
            当前第
            <input type="text" size="1" value="<bean:write name="fieldDefineList" property="pageIndex" />" onChange="javascript:PageTo(this)">
            /<bean:write name="fieldDefineList" property="pageAmount" />
            页&nbsp; 每页<bean:write name="fieldDefineList" property="pageSize" />条</td>
        </tr>
      </table>
      </logic:present>

      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td align="center" bgcolor="#F7EED9"> <p>
              <input type="button" name="Submit3" value="打印" onclick="window.print()">
              <input type="button" name="Submit2" value="新增" onclick="doAdd(this.form);">
            </p></td>
        </tr>
      </table>

      </td>
      <td background="../image/2_table_c_l.gif"><img src="../image/2_table_c_l.gif" width="26" height="138"></td>
    </tr>
    <tr>
      <td><img src="../image/2_table_r_b.gif" width="32" height="20"></td>
      <td background="../image/2_table_c_b.gif"><img src="../image/2_table_c_b.gif" width="115" height="20"></td>
      <td><img src="../image/2_table_l_b.gif" width="26" height="20"></td>
    </tr>
  </table>
</html:form>
</body>
</html>
