<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="com.sunyard.hgam.util.aum.AumUtil"%>
<%@ page import="com.sunyard.hgam.util.adc.AdcUtil"%>

<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>档案列表</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
body {
	background-image: url(../image/2_mainpagebg_01.gif);
}
-->
</style>
<script src="/common/js/chkBoxOperation.js">
//复选框操作代码
</script>
</head>
<script language="javascript">
<!--
function addCharge(){
	document.all.functionName.value = "insert";
	document.ChargeStandardForm.submit();
}

function deleteCharge() {
	document.all.functionName.value = "delete";
	document.ChargeStandardForm.submit();
}

function doDelete(form){
        if (!validateCheckBox(form)){
          alert("请选择文件!");
        }else
	  form.submit();
}

function validateCheckBox(theform){
	var obj=document.getElementsByName("uDetail.selectID");
	var isChecked = false;
	fileId = "";
	for(var i=0;i<obj.length;i++){
		if (obj[i].checked){
			isChecked=true;
			//fileId += obj[i].value + ",";
		}
	}
	return isChecked;
}
function doIt(fileId){
	window.location.href="/aum/viewArchivesPage.do?fileId="+fileId+"&flag=1";
}
-->
</script>
<body class="bg-page01">

  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="35"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="94%" colspan="3" background="../image/2_table_c_t.gif">&nbsp;</td>
      <td width="51"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td width="70" align="right" bgcolor="#FFFFFF"> <img src="../image/dot01.gif" width="8" height="8"><br>
      </td>
      <td width="10" align="center" bgcolor="#FFFFFF">&nbsp;</td>
      <td width="796" align="left" bgcolor="#FFFFFF"> 您现在的位置:查阅申请处理->档案列表</td>
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
                  <td align="center" bgcolor="#F2F9E6" class="tishi">档案列表</td>
                </tr></table>
              <table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#99CC00"><tr></tr>
              </table></td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>

    <td background="../image/2_table_c_r.gif">&nbsp;</td>
    <html:form action="/aum/DeleteUtilizeDetail" method="post" >
    <td align="center" bgcolor="#FFFFFF"> <br>
    <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#FFFFFF">
        <tr align="center" bgcolor="#F7EED9">
          <td nowrap>类目名称</td>
          <td nowrap bgcolor="#F7EED9">档号</td>
          <td nowrap bgcolor="#F7EED9">案卷名称</td>
          <td nowrap>文件名称</td>
          <td nowrap>页数</td>
          <td nowrap>收费金额</td>
          <td nowrap>查看影像页</td>
        </tr>
        <logic:present name="utilizeDetailList">
        <logic:iterate id="item" name="utilizeDetailList" >
        <tr align="center">
          <td bgcolor="#f6f6f6"><bean:write name="item" property="entry_name"/></td>
          <td bgcolor="#f6f6f6"><bean:write name="item" property="archives_num"/></td>
          <td bgcolor="#f6f6f6"><bean:write name="item" property="archives_name"/></td>
            <td bgcolor="#f6f6f6">
              <a href="/aum/viewArchivesFile.do?file_id=<bean:write name="item" property="file_id"/>">
              <bean:write name="item" property="file_name"/>
            </td>
          <td bgcolor="#f6f6f6"><bean:write name="item" property="page_count"/></a></td>
          <td bgcolor="#f6f6f6"><bean:write name="item" property="charge_money"/></td>
            <logic:equal name="isViewable" value="1">
            <td bgcolor="#f6f6f6" nowrap title="查看影像页"
		style="cursor:hand;color:blue"
		onclick="doIt('<bean:write name="item" property="file_id"/>');">
                GO</td>
            </logic:equal>
            <logic:equal name="isViewable" value="0">
            <td bgcolor="#f6f6f6" >GO</td>
            </logic:equal>
        </tr>
        </logic:iterate>
        </logic:present>
      </table>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td colspan="3" bgcolor="#F7EED9">
              <logic:equal name="flowDefID" value="1">
            	<input type="reset" name="Submit1" value="返回" onclick="window.location='ViewShowForm.do?flag=HANDLER'">
              </logic:equal>
              <logic:equal name="flowDefID" value="2">
            	<input type="reset" name="Submit2" value="返回" onclick="window.location='BorrowShowForm.do?flag=HANDLER'">
              </logic:equal>
              <logic:equal name="flowDefID" value="3">
            	<input type="reset" name="Submit3" value="返回" onclick="window.location='RepairShowForm.do?flag=HANDLER'">
              </logic:equal>
          </tr>
        </table>
      </td>
    </html:form>
    <td background="../image/2_table_c_l.gif">&nbsp;</td>
    </tr>
    <tr>
      <td><img src="../image/2_table_r_b.gif" width="32" height="20"></td>
      <td background="../image/2_table_c_b.gif"><img src="../image/2_table_c_b.gif" width="115" height="20"></td>
      <td><img src="../image/2_table_l_b.gif" width="26" height="20"></td>
    </tr>
  </table>
</body>
</html>
