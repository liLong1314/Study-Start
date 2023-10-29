<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<html>
<head>
<title></title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<script src="../common/js/validCheck.js">
//检查数据有效性函数的代码
</script>
<script language="javascript">
function mysubmit()
{
	if(document.getElementById("org.name").value=="")
	{
		alert("请输入组织名称！");
		document.getElementById("org.name").focus();
		return false;
	}
	document.orgForm.submit();
}
function displayinfo()
{
	if(document.getElementById("operResults").value!="")
	{
		alert(document.getElementById("operResults").value);
	}
}
function openWindow(newUrl) {

	var width = 600;
	var height = 480;
	var left = (screen.width - width)/2;
	var top = (screen.height - height)/2;
	style="toolbar=no,location=no,directories=no,status=no,resizable=no,scrollbars=yes,left="+left+",top="+top+",width="+width+",height="+height; 

	window.open(newUrl, "", style);
}
</script>
<style type="text/css">
<!--
.style1 {font-size: 12px}
-->
</style>
</head>
<body class="bg-page01" onload="javascript:displayinfo()">
<html:form action="/smm/newOrg.do" method="POST">
<html:hidden name="orgForm" property="operResults"/>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr nowrap>
      <td width="4%"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="94%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr nowrap align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif" bgcolor="#FFFFFF"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#99CC00">
                <tr nowrap>
                  <td align="center" bgcolor="#F2F9E6" class="tishi">新建组织</td>
                </tr>
              </table>
            </td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr nowrap>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td align="center" bgcolor="#FFFFFF">
	  <bean:write name="orgForm" property="operResults"/>
        <table width="95%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
          <tr nowrap bgcolor="#FFFFFF">
	        <td width="28%">组织名称</td>
	        <td colspan="3"><html:text size="12" property="org.name"/></td>
          </tr>
          <tr nowrap bgcolor="#FFFFFF">
	        <td>描述信息</td>
	    <td colspan="3"><html:text size="12" property="org.desc"/></td>
          </tr>
          <tr nowrap bgcolor="#FFFFFF">
	    <td>上级组织</td>
	    <td colspan="3">
		  <html:text size="12" property="org.superiorOrgName" value="顶级组织" readonly="true"/>
		  <html:hidden property="org.superiorOrgId" value="0"/>
		  <a href="javascript:openWindow('/smm/selectOrg.do?page=refresh')">选择...</a>
		</td>
        </tr>
          <tr nowrap bgcolor="#FFFFFF">
            <td>&nbsp;</td>
            <td width="23%"><a href="#" onclick="javascript:mysubmit()">确定</a></td>
            <td width="16%"><a href="/smm/queryOrg.do?search=first">回上页</a></td>
            <td width="33%">&nbsp;</td>
          </tr>
        </table></td>
      <td background="../image/2_table_c_l.gif"><img src="../image/2_table_c_l.gif" width="26" height="138"></td>
    </tr>
    <tr nowrap>
      <td><img src="../image/2_table_r_b.gif" width="32" height="20"></td>
      <td background="../image/2_table_c_b.gif">&nbsp;</td>
      <td><img src="../image/2_table_l_b.gif" width="26" height="20"></td>
    </tr>
  </table>
</html:form>
</body>
</html>
