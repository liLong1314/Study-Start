<%@ page contentType="text/html; charset=gb2312" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<html>
<head>
<title>待选字段列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<script language="javascript" src="../common/js/base.js"></script>
<script language="javascript" src="../common/js/chkBoxOperation.js"></script>
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
//查看选中字段
function doGoto(field_id){
	window.location="viewFieldDefine.do?field_id=" + field_id;
}
//操作
function doSubmit(form){
	if(validateCheckBox(form)){
		form.submit();
	}else{
               	alert("请选择字段！");
	}
}
function validateCheckBox(theform){
	var obj=document.getElementsByName("field_id");
	var isChecked = false;
	fileId = "";
	for(var i=0;i<obj.length;i++){
		if (obj[i].checked){
			isChecked=true;
			fileId += obj[i].value + ",";
		}
	}
	return isChecked;
}
-->
</script>
</head>
<body class="bg-page01">
<html:form action="/smm/viewEformFieldListForSelect" method="post" >
  <html:hidden property="operName"/>
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
</html:form>
<html:form action="/smm/selectEformField" method="post" >
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="32"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="100%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#00A8CC">
                <tr>
                  <td align="center" bgcolor="#E4F2FA" class="style1">待选字段列表</td>
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
          <td bgcolor="#F7EED9"><input type="checkbox" onclick="if(this.checked)SelectAll(this.form,'field_id');else UnSelectAll(this.form,'field_id');">选择</td>
          <td nowrap>字段中文名称</td>
          <td nowrap>字段英文名称</td>
          <td nowrap>字段类型</td>
          <td nowrap>字段长度</td>
          <td nowrap>是否为空</td>
          <td nowrap>是否摘要字段</td>
          <td nowrap>是否可编辑</td>
          <td nowrap>查看字段</td>
        </tr>
	<logic:notPresent name="eformFieldListForSelect">
	<tr align="center" bgcolor="#F7EED9">
          <td colspan=10>暂无记录</td>
        </tr>
	</logic:notPresent>
	<logic:present name="eformFieldListForSelect">
	<logic:iterate id="list" name="eformFieldListForSelect" >
        <tr align="center">
          <td><input type="checkbox" name="field_id" value="<bean:write name="list" property="field_id"/>"></td>
          <td align="left"><bean:write name="list" property="field_cname" /></td>
          <td><bean:write name="list" property="field_ename" /></td>
          <td><bean:write name="list" property="field_type_id" /></td>
          <td><bean:write name="list" property="field_len" /></td>
          <td><bean:write name="list" property="field_isNull" /></td>
          <td><bean:write name="list" property="field_isBrief" /></td>
          <td><bean:write name="list" property="field_isEdit" /></td>
          <td><a href="javascript:doGoto('<bean:write name='list' property='field_id' />')">GO</a></td>
        </tr>
	</logic:iterate>
	</logic:present>
      </table>

      <logic:present name="eformFieldListForSelect">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td bgcolor="#F7EED9"> <logic:notEqual name="eformFieldListForSelect" property="firstPage" value="true" >
            <a href="?page=first">&lt;&lt;
            第一页 </a><a href="?page=previous">&lt;
            上一页 </a></logic:notEqual> <logic:notEqual name="eformFieldListForSelect" property="lastPage" value="true" >
            <a href="?page=next">下一页
            &gt; </a><a href="?page=last">最后页
            &gt;&gt; </a></logic:notEqual>&nbsp; 共<bean:write name="eformFieldListForSelect" property="rowAmount" />条记录&nbsp;
            当前第
            <input type="text" size="1" value="<bean:write name="eformFieldListForSelect" property="pageIndex" />" onChange="javascript:PageTo(this)">
            /<bean:write name="eformFieldListForSelect" property="pageAmount" />
            页&nbsp; 每页<bean:write name="eformFieldListForSelect" property="pageSize" />条</td>
        </tr>
      </table>
      </logic:present>

      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td align="center" bgcolor="#F7EED9">
		<input type="button" name="Submit1" value="确定" onclick="doSubmit(this.form);">
		<input type="button" name="Submit3" value="打印" onclick="window.print()">
              	<input type="reset" name="Submit2" value="返回" onclick="window.location.href='/smm/queryEformDefineList.do?page=';">
          </td>
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
