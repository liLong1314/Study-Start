<%@ page contentType="text/html;charset=GBK" language="java"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%
String watchId=request.getParameter("watchId");
%>
<html:html>
<head>
<title>显示监督检查内容</title>
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
	var denoteTitle = document.getElementById("watchExamineDenoteInfo.denoteTitle");
	var denoteContent = document.getElementById("watchExamineDenoteInfo.denoteContent");
        var leadshiperSignature = document.getElementById("watchExamineDenoteInfo.leadshiperSignature");
        var denoteDate = document.getElementById("watchExamineDenoteInfo.denoteDate");
        if(BASEtrim(denoteTitle.value)=="")
        	return BASEalert("请输入正确的[主题]！",denoteTitle);
        if(BASEtrim(denoteContent.value)=="")
        	return BASEalert("请输入正确的[指示内容]！",denoteContent);
        if(BASEtrim(leadshiperSignature.value)=="" )
        	return BASEalert("请输入正确的[领导签字]！",leadshiperSignature);
        if(BASEtrim(denoteDate.value)!="" && BASEisNotDate(denoteDate.value))
        	return BASEalert("请输入正确的[日期]！",denoteDate);
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
                  <td align="center" bgcolor="#F2F9E6" class="tishi">领导批示</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td align="center" bgcolor="#FFFFFF"><br>
        <table width="95%" border="1">
          <html:form action="/arm/watchExamineDenoteAdd.do" method="post" onsubmit="return doSubmit(this.form);">
          <html:hidden property="watchExamineDenoteInfo.watchId" value="<%=watchId%>"/>
          <tr>
            <td height="62"> <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
                <tr bgcolor="#FFFFFF">
                  <td align="right">主题<font color="#FF0000">*</font></td>
                  <td><html:text property="watchExamineDenoteInfo.denoteTitle" size="12"/></td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td align="right">指示内容<font color="#FF0000">*</font></td>
                  <td><html:textarea property="watchExamineDenoteInfo.denoteContent" /></td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td align="right">负责人</font></td>
                  <td><html:text property="watchExamineDenoteInfo.denoteSuperinrtendent" size="12"/></td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td align="right">领导签字<font color="#FF0000">*</font></td>
                  <td><html:text property="watchExamineDenoteInfo.leadshiperSignature" /></td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td align="right">日期(YYYY-MM-DD)</td>
                  <td><html:text property="watchExamineDenoteInfo.denoteDate" /></td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td align="center"><input name="Submit" type="Submit" value="提交"></td>
                  <td align="center"><input type="button" name="button" onclick="window.location='/arm/viewallwatchexamine.do'"value="返回"></td>
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
