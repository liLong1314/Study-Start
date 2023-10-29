<%@ page contentType="text/html;charset=GBK" language="java"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<html>
<head>
<title>增加申请人信息</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<script language="javascript" src="../common/js/base.js"></script>
<style type="text/css">
<!--
body {
	background-image: url('../image/2_mainpagebg_01.gif');
}
-->
</style>
<script language="JavaScript" type="text/JavaScript">
<!--

function MM_openBrWindow(theURL,winName,features) { //v2.0
  window.open(theURL,winName,features);
}


function mySubmit(theForm){
  var name = document.getElementById("utilizePerson.person_name");
  var corp = document.getElementById("utilizePerson.person_corp");
  var tel = document.getElementById("utilizePerson.person_tel");
  var address = document.getElementById("utilizePerson.person_address");
  var number = document.getElementById("utilizePerson.certificate_num");

  if(BASEtrim(name.value)=="")
    alert("请输入[姓名]！");
  else if(BASEtrim(corp.value)=="")
    alert("请输入[单位]！");
  else if(BASEtrim(tel.value)=="")
    alert("请输入[电话]！");
  else if(BASEisNotNum(tel.value))
    alert("[电话]应为数字，请重新输入！");
  else if(BASEtrim(address.value)=="")
    alert("请输入[地址]！");
  else if(BASEtrim(number.value)=="")
    alert("请输入[证件号]！");
  else if(BASEisNotNum(number.value))
    alert("[证件号]应为数字，请重新输入！");
  else
    theForm.submit();

}

//-->
</script>
</head>
<body class="bg-page01">
<script>
	function doChange(obj){
		window.location.href=obj.options[obj.selectedIndex].url;
	}
</script>

<html:form action="/aum/AddUtilizePerson" method="post" >
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="4%"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="94%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif" bgcolor="#FFFFFF"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#99CC00">
                <tr>
                  <td align="center" bgcolor="#F2F9E6" class="tishi">申请人信息</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif"><img src="../image/2_table_c_r.gif" width="32" height="234"></td>
      <td align="center" bgcolor="#FFFFFF"><br>
        <table width="95%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
          <tr bgcolor="#FFFFFF">
            <td nowrap>姓名</td>
            <td nowrap>
              <html:text property="utilizePerson.person_name" />
            </td>
            <td nowrap>单位</td>
            <td nowrap><html:text property="utilizePerson.person_corp" /></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>电话</td>
            <td nowrap><html:text property="utilizePerson.person_tel" /></td>
            <td nowrap>地址</td>
            <td nowrap><html:text property="utilizePerson.person_address" /></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>证件类型</td>
            <td nowrap>
		<html:select property="utilizePerson.certificate_type">
		<html:optionsCollection property="certificate_type_options"/>
		</html:select>
            </td>
            <td nowrap>证件号</td>
            <td nowrap><html:text property="utilizePerson.certificate_num" /></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td>备注</td>
            <td colspan="3"><html:text property="utilizePerson.remark" /></td>
          </tr>
          <tr align="center" bgcolor="#FFFFFF">
            <td colspan="4">&nbsp;
            <input type="button" name="submit1" value="增加" onclick="mySubmit(this.form)">
            <input type="button" name="submit2" value="取消" onclick="window.history.go(-1)">
          </tr>
        </table>
        <br>
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