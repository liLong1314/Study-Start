<%@ page contentType="text/html; charset=gbk" %>

<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html >
<head>
<title>修改页状态</title>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
</head>
<link href="../../common/css/sunhoo.css" rel="stylesheet" type="text/css">

<script src="/common/js/validCheck.js">
//检查数据有效性函数的代码
</script>
<script src="/common/js/radioOperation.js">
//对radio操作的代码
</script>

<script language="JavaScript" type="text/JavaScript">
<!--

//设置功能名称

function setFunctionName(functionName){
	document.CheckArchivesPageViewForm.functionName.value=functionName;
}

//用于设置子窗口的递交
function mySubmit() {

	if(!IsChecked(document.CheckArchivesPageViewForm.functionData)) {
		alert("请选择一项！");
		return;
	}
	
	var functionData = GetSelectedValue(document.CheckArchivesPageViewForm.functionData);

	if(window.opener) {
		window.opener.document.CheckArchivesPageViewForm.functionName.value = "UpdateStatus";
		window.opener.document.CheckArchivesPageViewForm.functionData.value = functionData;
		window.opener.document.CheckArchivesPageViewForm.submit();
		
		self.close();
	}
}
-->
</script>
<body class="bg-page01">
<html:form action="/adc/CheckArchivesPageView" method="post"> 
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr> 
    <td width="4%"><img src="../../image/2_table_l_t.gif" width="32" height="22"></td>
    <td width="94%" height="10" background="../../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
        <tr align="center"> 
          <td width="25" align="right" background="../../image/2_table_c_t.gif" bgcolor="#FFFFFF"><img src="../image/dot01.gif" width="8" height="8"></td>
          <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#00A8CC">
              <tr> 
                <td align="center" bgcolor="#E4F2FA" class="tishi">修改状态</td>
              </tr>
            </table></td>
        </tr>
      </table></td>
    <td width="2%"><img src="../../image/2_table_r_t.gif" width="26" height="22"></td>
  </tr>
  <tr> 
    <td background="../../image/2_table_c_r.gif">&nbsp;</td>
    <td align="center" valign="middle" bgcolor="#FFFFFF"><br>
      <table align="center">
        <tr> 
          <td> 
          	<input type=radio name=functionData value="PASS">通过 
            <input type=radio name=functionData value="NOPASS">未通过 
          </td>
        </tr>
        <tr> 
          <td><input type="button" name="Submit" value="确定" onclick="mySubmit();"> 
          </td>
          <td><input type="button" name="Submit" value="取消" onclick="self.close()"> 
          </td>
        </tr>
      </table>
      <br></td>
    <td background="../../image/2_table_c_l.gif">&nbsp;</td>
  </tr>
  <tr> 
    <td><img src="../../image/2_table_r_b.gif" width="32" height="20"></td>
    <td height="10" background="../../image/2_table_c_b.gif"><img src="../../image/2_table_c_b.gif" width="115" height="20"></td>
    <td><img src="../../image/2_table_l_b.gif" width="26" height="20"></td>
  </tr>
</table>
</html:form> 
</body>
</html>