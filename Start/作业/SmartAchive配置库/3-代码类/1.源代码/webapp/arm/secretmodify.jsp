<%@ page contentType="text/html;charset=GBK" language="java"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>

<html:html>
<head>
<title>修改密级</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<script language="javascript" src="../common/js/base.js"></script>
<style type="text/css">
<!--
body {
	background-image: url(../image/2_mainpagebg_01.gif);
}
-->
</style>
<script language="JavaScript" type="text/JavaScript">
function doSubmit(theform){
	var obj=document.forms[0];
        if(validateForm(obj)){
		return true;
        }
		return false;
      }
function validateForm(theform){
	var secretCode = document.getElementById("secretInfo.secretCode");
	var secretName = document.getElementById("secretInfo.secretName");

        if(BASEtrim(secretCode.value)=="")
        	return BASEalert("请输入正确的[密级编号]！",secretCode);
        if(BASEtrim(secretName.value)=="")
        	return BASEalert("请输入正确的[密级名称]！",secretName);
		return true;
	}
</script>
</head>
<body class="bg-page01">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="32"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td colspan="3" background="../image/2_table_c_t.gif">&nbsp;</td>
      <td width="26"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td width="51" align="right" bgcolor="#FFFFFF"> <img src="../image/dot01.gif" width="8" height="8"><br>
      </td>
      <td width="8" align="center" bgcolor="#FFFFFF">&nbsp;</td>
    <td width="653" align="left" bgcolor="#FFFFFF"> 您现在的位置：<a href="/arm/SecretAllView.do">密级管理</a>
      &gt;&gt; 修改密级</td>
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
      <td width="4%"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="94%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif" bgcolor="#FFFFFF"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#99CC00">
                <tr>
                  <td align="center" bgcolor="#F2F9E6" class="tishi">修改密级信息</td>
                </tr>
            </table></td>
          </tr>
      </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td align="center" bgcolor="#FFFFFF"><br>
          <table width="100%" border="1">
          <tr>
            <td height="112">
              <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
		<html:form action="/arm/SecretModify.do" method="post" onsubmit="return doSubmit(this.form);">
                <tr bgcolor="#FFFFFF">

                <td width="9%" align="right">密级编号<font color="#FF0000">*</font></td>
                  <td width="15%">
		<html:hidden name="secretForm" property="secretInfo.secretId"/>
		<html:text name="secretForm" property="secretInfo.secretCode" size="12"/>
                </td>
                </tr>
                <tr bgcolor="#FFFFFF">

                <td align="right">密级名称<font color="#FF0000">*</font></td>
                  <td><html:text name="secretForm" property="secretInfo.secretName" size="12"/></td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td align="right">说明</td>
                  <td><html:textarea name="secretForm" property="secretInfo.remark"/></td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td align="center"><input type="submit" name="Submit" value="提交"></td>
                  <td align="center"><input type="reset" name="reset" value="重写"></td>
                </tr>
		</html:form>
              </table></td>
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
</body>
</html:html>
