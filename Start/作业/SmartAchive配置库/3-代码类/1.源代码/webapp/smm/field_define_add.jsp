<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>字段增加</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<script language="javascript" src="../common/js/base.js"></script>
<style type="text/css">
<!--
body {
	background-image: url(../image/2_mainpagebg_01.gif);
}
-->
</style>
<script>
	//表单提交
	function doSubmit(theform){
		var operName = document.getElementById("operName");
		if(validateForm(theform)){
			operName.value="SUBMIT_ACTION";
			theform.submit();
		}
	}
	//验证表单
	function validateForm(theform){
		var field_cname = document.getElementById("eformFieldDefine.field_cname");
		var field_len = document.getElementById("eformFieldDefine.field_len");

		if(BASEtrim(field_cname.value)=="")
			return BASEalert("请输入正确的[字段名称]！",eform_name);
		if(BASEisNotNum(field_len.value))
			return BASEalert("请输入正确的[字段长度]！",field_len);
		return true;
	}
</script>
</head>
<body class="bg-page01">
<html:form action="/smm/addFieldDefine" method="post">
  <html:hidden property="operName"/>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="32"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td colspan="3" background="../image/2_table_c_t.gif">&nbsp;</td>
      <td width="26"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td width="28" align="right" bgcolor="#FFFFFF"> <img src="../image/dot01.gif" width="8" height="8"><br>
      </td>
      <td width="6" align="center" bgcolor="#FFFFFF">&nbsp;</td>
      <td width="454" align="left" bgcolor="#FFFFFF"> 您现在的位置： &gt;&gt; 系统管理 &gt;&gt; 表单字段管理</td>
      <td background="../image/2_table_c_l.gif">&nbsp;</td>
    </tr>
    <tr>
      <td><img src="../image/2_table_r_b.gif" width="32" height="20"></td>
      <td colspan="3" background="../image/2_table_c_b.gif"><img src="../image/2_table_c_b.gif" width="115" height="20"></td>
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
                  <td align="center" bgcolor="#E4F2FA" class="tishi">字段增加</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td align="center" bgcolor="#FFFFFF">
        <table width="95%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
	  <logic:notEmpty name="EformFieldDefineForm" property="msgError">
          <tr bgcolor="#FFFFFF">
		<td colspan="4">
		<b><font color=red>很抱歉，过程中发生错误！点击<a href="#" style="color:blue" onclick="var obj=document.all('err');if(obj.style.display=='none') {obj.style.display='block'} else{obj.style.display='none'}">此处</a>查看详细信息</font></b>
		<span id=err style="display:none"><bean:write name="EformFieldDefineForm" property="msgError"/></span>
		</td>
          </tr>
          </logic:notEmpty>
          <tr bgcolor="#FFFFFF">
            <td nowrap>字段中文名称<font color=red>*</font></td>
            <td colspan="3" nowrap><html:text property="eformFieldDefine.field_cname" size="40" maxlength="80"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>字段英文名称</td>
            <td colspan="3" nowrap><html:text property="eformFieldDefine.field_ename" size="40" maxlength="40"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>字段类型<font color=red>*</font></td>
            <td colspan="3" nowrap>
		<html:select property="eformFieldDefine.field_type_id">
		<html:optionsCollection property="field_type_idOptions"/>
		</html:select>
            </td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>字段长度<font color=red>*</font></td>
            <td colspan="3" nowrap><html:text property="eformFieldDefine.field_len" size="10" maxlength="18"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>能否为空</td>
            <td colspan="3" nowrap><html:checkbox property="eformFieldDefine.field_isNull" value="1"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>是否概要字段</td>
            <td colspan="3" nowrap><html:checkbox property="eformFieldDefine.field_isBrief" value="1"/></td>
          </tr>
          <tr align="center" bgcolor="#FFFFFF">
            <td colspan="4">
		<input type="button" name="Submit1" value="保存" onclick="doSubmit(this.form);">
              	<input type="reset" name="Submit9" value="返回" onclick="window.location.href='/smm/queryFieldDefineList.do?page=';">
            </td>
          </tr>
        </table>
        <br>
      </td>
      <td background="../image/2_table_c_l.gif">&nbsp;</td>
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

