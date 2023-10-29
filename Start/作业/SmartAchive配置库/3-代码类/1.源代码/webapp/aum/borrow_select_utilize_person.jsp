<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="com.sunyard.hgam.util.aum.AumUtil"%>
<%@ page import="com.sunyard.hgam.util.adc.AdcUtil"%>

<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>利用者列表</title>
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
          alert("请选择要删除的文件！");
        }else
	  form.submit();
}

function validateCheckBox(theform){
	var obj=document.getElementsByName("personID");
	var isChecked = -1;
	for(var i=0;i<obj.length;i++){
		if (obj[i].checked){
			isChecked=i;break;
		}
	}
	return isChecked;
}
function doSubmit(form) {
  var obj1=document.getElementsByName("personID");
  var obj2=document.getElementsByName("personName");
  var obj3=document.getElementsByName("personCorp");
  var obj4=document.getElementsByName("utilizeInfo.personID");
  var obj5=document.getElementsByName("utilizeInfo.personName");
  var obj6=document.getElementsByName("utilizeInfo.personCorp");
  var i=validateCheckBox(form);

  if (i==-1)
    alert("请选择申请人！");
  else {
    obj4[0].value=obj1[i].value;
    obj5[0].value=obj2[i].value;
    obj6[0].value=obj3[i].value;
    form.submit();
  }


}
-->
</script>
<body class="bg-page01">

<table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="4%"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="94%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif" bgcolor="#FFFFFF"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#99CC00">
                <tr>
                  <td align="center" bgcolor="#F2F9E6" class="tishi">利用者列表</td>
                </tr></table>
              <table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#99CC00"><tr></tr>
              </table></td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>

    <td background="../image/2_table_c_r.gif">&nbsp;</td>
  <html:form action="/aum/BorrowNewApplyForm?showFlag=1" method="post" >
    <html:hidden property="utilizeInfo.personID" value=""/>
    <html:hidden property="utilizeInfo.personName" value=""/>
    <html:hidden property="utilizeInfo.personCorp" value=""/>
    <td align="center" bgcolor="#FFFFFF"> <br>
    <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#FFFFFF">
        <tr align="center" bgcolor="#F7EED9">
          <td nowrap>选择</td>
          <td nowrap>姓名</td>
          <td nowrap>单位</td>
        </tr>
        <logic:present name="personList">
        <logic:iterate id="item" name="personList" >
        <tr align="center">
          <td bgcolor="#f6f6f6">
            <input type="radio" name="personID" value="<bean:write name="item" property="personID"/>">
          </td>
          <td bgcolor="#f6f6f6">
            <bean:write name="item" property="personName"/>
            <input type="hidden" name="personName" value="<bean:write name="item" property="personName"/>">
          </td>
          <td bgcolor="#f6f6f6">
            <input type="hidden" name="personCorp" value="<bean:write name="item" property="personCorp"/>">
          <bean:write name="item" property="personCorp"/></td>
        </tr>
        </logic:iterate>
        </logic:present>
      </table>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td colspan="4" bgcolor="#F7EED9">
            	<input type="button" name="Submit" value="选择" onclick="doSubmit(this.form)">
            	<input type="button" name="Submit4" value="取消" onclick="window.close()">
            </td>
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
