<%@ page contentType="text/html;charset=GBK" language="java"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<html>
<head>
<title>借阅管理|借阅申请</title>
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

function isCheck(optionName){
  var obj=document.getElementsByName(optionName);
  for(var i=0;i<obj.length;i++){
     if(obj[i].checked) return true;
  }
  return false;
}

function mySubmit(){
  var aim = document.getElementById("utilizeInfo.aim");
  var beginDate = document.getElementById("utilizeInfo.beginDate");
  var term = document.getElementById("utilizeInfo.utilizeTerm");

  if(BASEtrim(aim.value)=="")
    alert("请输入[借阅目的]！");
  else if(BASEtrim(beginDate.value)=="" || BASEisNotDate(beginDate.value))
    alert("请输入正确的[借阅起始日期]，格式为YYYY-MM-DD。");
  else if(BASEtrim(term.value)=="")
    alert("请输入[借阅期限]！");
  else if(BASEisNotNum(term.value))
    alert("[借阅期限]应为数字，请重新输入！");
  else if (!isCheck("utilizeInfo.self"))
    alert("请选择是否为机关人员！");
  else
    document.UtilizeInfoForm.submit();
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

<html:form action="/aum/AddUtilizeInfo" method="post" >
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="4%"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="94%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif" bgcolor="#FFFFFF"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#99CC00">
                <tr>
                  <td align="center" bgcolor="#F2F9E6" class="tishi">借阅申请</td>
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
            <td nowrap>借阅者姓名</td>
            <td nowrap>
              <html:text property="utilizeInfo.personName" />
              <input type="button" name="button1" value="选择借阅人" onClick="window.location='/aum/ShowAllUtilizePerson.do?type=2'">
            </td>
            <td nowrap>借阅者单位</td>
            <td nowrap><html:text property="utilizeInfo.personCorp" /></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>借阅方式</td>
            <td nowrap>
              <bean:define id="aa" name="utilForm" property="utilizeInfo.listModeName"/>
              <html:select property="utilizeInfo.modeID" size="1" >
              <html:options collection="aa" property="modeID" labelProperty="modeName"/>
              </html:select>
            </td>
            <td nowrap>借阅目的</td>
            <td nowrap><html:text property="utilizeInfo.aim" /></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>借阅起始日期(YYYY-MM-DD)</td>
            <td nowrap><html:text property="utilizeInfo.beginDate" /></td>
            <td nowrap>借阅期限(天)</td>
            <td nowrap><html:text property="utilizeInfo.utilizeTerm" /></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td rowspan="1">是否为机关人员</td>
            <td height="0" colspan="3" align="center">
              <input type="radio" name="utilizeInfo.self" value="1" checked />是
              <input type="radio" name="utilizeInfo.self" value="0" />否
            </td>
          </td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td>备注</td>
            <td colspan="3"><html:text property="utilizeInfo.remark" /></td>
          </tr>
          <tr align="center" bgcolor="#FFFFFF">
            <td colspan="4">&nbsp;
            <input type="button" name="Submit3" value="选择档案文件" onclick="mySubmit()">
            <input type="button" name="Submit4" value="打印" onclick="window.print()">
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