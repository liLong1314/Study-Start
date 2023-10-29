<%@ page contentType="text/html; charset=GBK" %>

<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>收费项目定义</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
body {
	background-image: url(../image/2_mainpagebg_01.gif);
}
-->
</style>
<script language="javascript"> 
<!--
//返回所有记录的状态
function getAllValues(frm){
	var str = '';
	var delimeter = ',';
	var counter = 0;
	var checked;
	for(var i=0;i<frm.elements.length;i++){
	 if((frm.elements[i].type=="checkbox") ){
	 	 if (frm.elements[i].checked)
	 	 	checked= "=1";
	 	 else
	 	 	checked= "=0";
		 if(counter==0){str += frm.elements[i].value + checked;}
		 else{str += delimeter + frm.elements[i].value + checked;}
		 counter++;
	 }
	}
	if(counter==0)
		return false;
	return str;
}

function mySubmit(){
	var AllIsCharge;
	AllIsCharge= getAllValues(document.forms[0]);
	if (AllIsCharge==false){
		alert("空");
		return;
	}
	document.all.functionName.value = "Save";
	document.all.functionData.value = AllIsCharge;
	document.IsChargeForm.submit();
}

//双击滚屏
var currentpos,timer;  
function initialize() 
{ 
	timer= setInterval("scrollwindow()",10); 
} 
function sc() 
{ 
	clearInterval(timer); 
} 
function scrollwindow() 
{ 
	currentpos= document.body.scrollTop; 
	window.scroll(0,++currentpos); 
	if (currentpos != document.body.scrollTop) 
	sc(); 
} 
document.onmousedown= sc 
document.ondblclick= initialize 
-->
</script>

</head>
<body class="bg-page01">
<html:form action="/aum/IsCharge" method="post" >
<html:hidden property="functionName"/> 
<html:hidden property="functionData"/> 

<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr> 
    <td width="4%"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
    <td width="94%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
        <tr align="center"> 
          <td width="25" align="right" background="../image/2_table_c_t.gif" bgcolor="#FFFFFF"><img src="../image/dot01.gif" width="8" height="8"></td>
          <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#99CC00">
              <tr> 
                <td align="center" bgcolor="#F2F9E6" class="tishi">项目收费定义</td>
              </tr>
            </table></td>
        </tr>
      </table></td>
    <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
  </tr>
  <tr> 
    <td rowspan="2" background="../image/2_table_c_r.gif" width="26">&nbsp;</td>
    <td align="center" bgcolor="#FFFFFF"> <br>
      <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#FFFFFF">
        <tr align="center"> 
          <td width="10%" nowrap bgcolor="#F7EED9">是否收费项目</td>
          <td width="60%" nowrap bgcolor="#F7EED9">类目名称</td>
          <td width="30%" nowrap bgcolor="#F7EED9">说明</td>
        </tr>
        <logic:notEmpty name="IsChargeForm" property="list_entry">
          <logic:iterate id="item" name="IsChargeForm" property="list_entry" >
	        <tr align="center" bgcolor="#f6f6f6" 
	        	onMouseover="this.style.backgroundColor='#dff1ff'" 
	        	onMouseOut="this.style.backgroundColor='#f6f6f6'" > 
 	          <td> 
 	          <input type="checkbox" name="selectID" value="<bean:write name='item' property='entryId'/>"
 	          	<logic:equal name="item" property="is_charge" value="1"> checked
 	          	</logic:equal>
 	          >
	          </td>
	          <td><bean:write name="item" property="entryName" /></td>
	          <td><bean:write name="item" property="remark" /></td>
	        </tr>
	      </logic:iterate>
	    </logic:notEmpty>
      </table>
      </br></td>
    <td rowspan="2" width="26" background="../image/2_table_c_l.gif">&nbsp;</td>
  </tr>
  <tr> 
    <td align="center" bgcolor="#FFFFFF"> 
      <input type="button" name="btn91" value="刷新" onClick="window.location='/aum/IsCharge.do';">
      <input type="button" name="btn92" value="保存收费项目" onClick="mySubmit();">
	</td>
  </tr>
  <tr> 
    <td><img src="../image/2_table_r_b.gif" width="32" height="20"></td>
    <td background="../image/2_table_c_b.gif">&nbsp;</td>
    <td><img src="../image/2_table_l_b.gif" width="26" height="20"></td>
  </tr>
</table>
</html:form> 
</body>
</html>
