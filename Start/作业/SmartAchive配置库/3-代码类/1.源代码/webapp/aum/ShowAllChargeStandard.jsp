<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="com.sunyard.hgam.util.aum.AumUtil"%>
<%@ page import="com.sunyard.hgam.util.adc.AdcUtil"%>

<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>收费标准列表</title>
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
	document.all.functionName.value = "InitInsert";
	document.ChargeStandardForm.submit();
}

function deleteCharge() {	
	document.all.functionName.value = "delete";
	document.ChargeStandardForm.submit();
}
-->
</script>
<body class="bg-page01">
<html:form action="/aum/ChargeStandard" method="post" >
<html:hidden property="functionName"/>
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
      <td width="796" align="left" bgcolor="#FFFFFF"> 您现在的位置：收费标准定义列表 &gt;&gt; </td>
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
                  <td align="center" bgcolor="#F2F9E6" class="tishi">收费标准定义信息列表</td>
                </tr></table>              
              <table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#99CC00"><tr></tr>
              </table></td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr> 
      
    <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td align="center" bgcolor="#FFFFFF"><br>
        <table width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
        <tr align="center" bgcolor="#F7EED9"> 
          <td width="10" align="center"> 
            <input type=checkbox onclick="
            	if(this.checked)
            		SelectAll(document.forms[0],'selectID');
            	else 
            		UnSelectAll(document.forms[0],'selectID');
            	">
          </td>
          <td>
			<table width="100%" border="0" cellpadding="2" cellspacing="1">
			<tr>
<!--	          <td width="40" nowrap>id</td>-->
	          <td width="20%" nowrap>类目</td>
	          <td width="65" nowrap>收费方式</td>
	          <td width="65" nowrap>版本</td>
	          <td width="85" nowrap>收费标准金额</td>
	          <td width="85" nowrap>执行开始日期</td>
	          <td width="85" nowrap>执行结束日期</td>
	          <td width="65" nowrap>收费依据</td>
	          <td width="65" nowrap>备注</td>
			</tr>
			</table>
          </td>
        </tr>
	  <logic:present name="AllChargeStandard">
          <logic:iterate id="item" name="AllChargeStandard" >
			<tr>
	          <td width="10" align="center">
	          	<input type="checkbox" name="selectID" value="<bean:write name='item' property='charge_id'/>">
	          </td>
	          <td>
				<table width="100%" border="0" cellpadding="2" cellspacing="1">
		        <tr align="center" bgcolor="#f6f6f6" 
		        	onMouseover="this.style.backgroundColor='#dff1ff'" 
		        	onMouseOut="this.style.backgroundColor='#f6f6f6'" 
		        	style='cursor:hand' onclick="window.location='../aum/ChargeStandard.do?charge_id=<bean:write name='item' property='charge_id' />'">
<!--		          <td width="40"><bean:write name="item" property="charge_id" /></td>  -->
		          <td width="20%">
					<bean:define id="entry" name="item" property="sentryid"/>
		            <%
		            	out.print(AumUtil.getEntryNameById((String)entry));
		            %> 
		          </td>
		          <td width="65">
					<bean:define id="chargeMode" name="item" property="charge_mode"/>
		            <%
		            	out.print(AdcUtil.getSysParamByTypeAndValue("CHARGE_MODE", (String)chargeMode));
		            %> 
		          </td>
		          <td width="65"><bean:write name="item" property="charge_version" /></td>
		          <td width="85"><bean:write name="item" property="charge_money" /></td>
		          <td width="85"><bean:write name="item" property="charge_begin_date" /></td>
		          <td width="85"><bean:write name="item" property="charge_end_date" /></td>
		          <td width="85"><bean:write name="item" property="charge_base" /></td>
		          <td width="65"><bean:write name="item" property="remark" /></td>
				</tr>
				</table>
	          </td>
	        </tr>
          </logic:iterate>
       </logic:present>
      </table>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr> 
            <td align="center" bgcolor="#F7EED9">
				<input type="button" name="btn91" value="增加" onClick="addCharge();">
				<input type="button" name="btn91" value="删除" onClick="deleteCharge();">
				<input type="button" name="btn92" value="打印" onClick="window.print()">
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
