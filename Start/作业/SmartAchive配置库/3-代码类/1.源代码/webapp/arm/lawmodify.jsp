<%@ page contentType="text/html;charset=GBK" language="java"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>

<html:html>
<head>
<title>修改法律法规</title>
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
	var lawType = document.getElementById("lawInfo.lawType");
	var lawCode = document.getElementById("lawInfo.lawCode");
	var lawTitle = document.getElementById("lawInfo.lawTitle");
	var lawDate = document.getElementById("lawInfo.lawDate");

        if(BASEtrim(lawType.value)=="")
        	return BASEalert("请输入正确的[法律法规类型]！",lawType);
        if(BASEtrim(lawCode.value)=="")
        	return BASEalert("请输入正确的[法律法规编号]！",lawCode);
        if(BASEtrim(lawTitle.value)=="")
        	return BASEalert("请输入正确的[主题]！",lawTitle);
        if(BASEtrim(lawDate.value)!="" && BASEisNotDate(lawDate.value))
        	return BASEalert("请输入正确的[发布日期]！",lawDate);
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
    <td width="620" align="left" bgcolor="#FFFFFF"> 您现在的位置：<a href="/arm/LawSearch.do">法律法规管理</a>
      &gt;&gt; 法律法规修改</td>
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

                <td align="center" bgcolor="#F2F9E6" class="tishi">法律法规修改</td>
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
            <td height="62">
		<table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
		<html:form action="/arm/LawModify.do" method="post" onsubmit="return doSubmit(this.form);">
                <tr bgcolor="#FFFFFF">

                <td width="9%" align="right">法律法规类型<font color="#FF0000">*</font></td>
                  <td width="15%">
                  <html:text name="lawForm" property="lawInfo.lawType"/>
                  <html:hidden name="lawForm" property="lawInfo.lawId"/>
                  </td>
                </tr>
                <tr bgcolor="#FFFFFF">

                <td align="right">法律法规编号<font color="#FF0000">*</font></td>
                  <td><html:text name="lawForm" property="lawInfo.lawCode"/></td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td align="right">发布单位</td>
                  <td><html:text name="lawForm" property="lawInfo.lawDept" size="28"/></td>
                </tr>
                <tr bgcolor="#FFFFFF">

                <td align="right">发布日期(YYYY-MM-DD)</td>
                  <td><html:text name="lawForm" property="lawInfo.lawDate"/></td>
                </tr>
                <tr bgcolor="#FFFFFF">

                <td align="right">法律法规主题<font color="#FF0000">*</font></td>
                  <td><html:text name="lawForm" property="lawInfo.lawTitle" size="28"/></td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td align="right">法律法规内容</td>
                  <td><html:textarea name="lawForm" property="lawInfo.lawContent"/></td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td align="right">说明</td>
                  <td><html:textarea name="lawForm" property="lawInfo.remark"/></td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td align="center"><input name="Submit" type="submit" value="提交"></td>
                  <td align="center"><input name="Reset"type="reset"  value="重写"></td>
                </tr>
		</html:form>
              </table></td>
          </tr>
        </table>
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
