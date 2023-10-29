<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="com.sunyard.hgam.util.adc.AdcUtil"%>

<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<title>归档-查询档案</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
body {
	background-image: url(../image/2_mainpagebg_01.gif);
}
-->
</style>
<script src="../common/js/chkBoxOperation.js">
//复选框操作代码
</script>
</head>

<body class="bg-page01" onload="myLoad();">
<script language="JavaScript" type="text/JavaScript">
<!--
//设置功能名称
function setFunctionName(functionName){
	document.all.functionName.value=functionName;
}

function myLoad() {
	//alert(document.all.roll_mode);
	//document.all.roll_mode.value = "1";
	chooseRollMode();
}

function chooseRollMode() {
	var mode  = document.all("archives.AROLL_MODE");
	var span1 = document.all("Mode1");
	var span2 = document.all("Mode2");
	var iMode;
	for(var i=0;i<mode.length;i++){
		//alert(mode[i].checked);
		if (mode[i].checked) iMode = mode[i].value;
	}
	
	//alert(iMode);
	if(iMode == "1" || iMode==null){
		//alert("按卷查询");
		for(var i=0;i<span1.length;i++){
			span1[i].style.display="block";
		}
		for(var i=0;i<span2.length;i++){
			span2[i].style.display="none";
		}
	}else {//if(iMode == "2"){
		//alert("按件查询");
		for(var i=0;i<span2.length;i++){
			span2[i].style.display="block";
		}
		for(var i=0;i<span1.length;i++){
			span1[i].style.display="none";
		}
	}
}

function TryStrToInt(strInt) {
	var ivalueLength = strInt.length;

	for(var i = 0; i != ivalueLength; i++) {
		var aChar = strInt.substring(i,i+1);
		if(aChar<"0" || aChar>"9") {
			return false;
		}
	}
	return true;
}

function gotoPage(pageIndex) {
	if (TryStrToInt(pageIndex)==false){
		alert("请输入正确的页码！(" + pageIndex + ")");
		return;
	}
  location = "?page=" + pageIndex;
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

<html:form action="/aum/queryArchivesView" method="post" >
<html:hidden property="functionName"/>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="32"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="100%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#00A8CC">
                <tr>
                  <td align="center" bgcolor="#E4F2FA" class="tishi">档案查询</td>
                </tr>
            </table></td>
          </tr>
      </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td align="center" bgcolor="#FFFFFF"> <br>
          <table width="100%" height="37" border="1">
            <tr>

            <td height="31"> <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">

					<table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
					<tr bgcolor="#FFFFFF">
						<td nowrap bgcolor="#FFFFFF">
							<html:radio property="archives.AROLL_MODE" value="1" onclick="chooseRollMode();"/>按卷查询
							<html:radio property="archives.AROLL_MODE" value="2" onclick="chooseRollMode();" />按件查询
						</td>
					</tr>
					</table>
	              <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
	                <tr bgcolor="#FFFFFF">
					  <td width="100%">
						  <table width="100%">
						  <tr>
			                  <td width="50" nowrap>档号:</td>
			                  <td width="130" nowrap><html:text property="archives.AARCHIVES_NUM" size="10" maxlength="50" style="width:100" /></td>
							  <td nowrap>档案状态： 
							    <html:radio property="archives.AARCHIVES_STATUS" value="" />所有
							    <html:radio property="archives.AARCHIVES_STATUS" value="0" />未归档
							    <html:radio property="archives.AARCHIVES_STATUS" value="1" />已归档
							  </td>
		                  </tr>
		                  </table>
	                  </td>
					</tr>
	                <tr bgcolor="#FFFFFF">
	                  <td><table><tr>
	                  <td width="50" nowrap id="Mode1">目录号:</td>
	                  <td width="25%" nowrap id="Mode1"><html:text property="archives.ACATALOG_NUM" size="10" maxlength="9" style="width:100%" /></td>
	                  <td width="10%" nowrap id="Mode1">案卷号:</td>
	                  <td width="25%" nowrap id="Mode1"><html:text property="archives.AROLL_NUM" size="10" maxlength="9" style="width:100%" /></td>
	                  <td width="10%" nowrap id="Mode1">案卷题名:</td>
	                  <td width="35%" nowrap colspan=3 id="Mode1"><html:text property="archives.AARCHIVES_NAME" size="40" maxlength="100" style="width:100%" /></td>

	                  <td width="50" nowrap id="Mode2">件号:</td>
	                  <td width="30%" nowrap id="Mode2"><html:text property="archives.APIECE_NUM" size="10" maxlength="9" style="width:100%" /></td>
	                  <td width="10%" nowrap id="Mode2">件题名:</td>
	                  <td width="50%" nowrap colspan=3 id="Mode2"><html:text property="archives.AARCHIVES_NAME" size="40" maxlength="100" style="width:100%" /></td>
	                  <td colspan=2 align="center" nowrap> <input type="submit" name="btnQry" value="查询" onClick="setFunctionName('QueryAllArchives')"></td>
	                  </tr></table></td>
	                </tr>
	              </table>
              </td>
            </tr>
        </table></td>
      <td background="../image/2_table_c_l.gif">&nbsp;</td>
    </tr>
    <tr>
      <td><img src="../image/2_table_r_b.gif" width="32" height="20"></td>
      <td background="../image/2_table_c_b.gif"><img src="../image/2_table_c_b.gif" width="115" height="20"></td>
      <td><img src="../image/2_table_l_b.gif" width="26" height="20"></td>
    </tr>
  </table>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="32"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="100%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#00A8CC">
                <tr>
                  <td align="center" bgcolor="#E4F2FA" class="tishi">档案列表</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="4%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif"><img src="../image/2_table_c_r.gif" width="32" height="24"></td>

    <td align="center" bgcolor="#FFFFFF"><br>
        <table width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
        <tr align="center" bgcolor="#F7EED9">
          <td width="10" align="center"> 
            dd
            <!--<input type=checkbox onclick="if(this.checked)SelectAll(document.forms[0],'selectID');else UnSelectAll(document.forms[0],'selectID');">
            -->
          </td>
          <td>
	    	<table align="center" width="100%" border="0" cellpadding="2" cellspacing="1">
					<tr align="center" >
	            <td width="90">档号</td>
	            <td width="45%">案卷题名</td>
	            <td width="50">档案年度</td>
	            <td width="50">保管期限</td>
	            <td width="20%">档案状态</td>
            </tr>
            </table>
          </td>
        </tr>

	     <logic:present name="queryAllArchives">
		<logic:iterate id="item" name="queryAllArchives" >
        <tr align="center">
        	<td width="10" align="center">dd 
          <!--<input type="checkbox" name="selectID" value="<bean:write name='item' property='AARCHIVES_ID'/>">
          -->
          </td>
		  <td width="100%" align="center">
	    	<table align="center" width="100%" border="0" cellpadding="2" cellspacing="1">
			<tr align="center"  bgcolor="#f6f6f6" 
	        	onMouseover="this.style.backgroundColor='#dff1ff'" 
	        	onMouseOut="this.style.backgroundColor='#f6f6f6'" 
						style='cursor:hand' 
	        	onclick="window.location='../aum/SelectArchivesFile.do?archives_id=<bean:write name='item' property='AARCHIVES_ID' />'">
	            <td width="90"><bean:write name="item" property="AARCHIVES_NUM" /></td>
	            <td width="45%"><bean:write name="item" property="AARCHIVES_NAME" /></td>
	            <td width="50"><bean:write name="item" property="AARCHIVES_YEAR" /></td>
	            <td width="50">
	            	<!--<bean:write name="item" property="ASTORE_TERM" />-->
						    <bean:define id="store_term" name="item" property="ASTORE_TERM"/>
								<%
									out.print(AdcUtil.getSysParamByTypeAndValue("ArchiveStore", (String)store_term));
								%>
	            </td>
	            <td width="20%">
	            	<!--  <bean:write name="item" property="AARCHIVES_STATUS" />  -->
				    <bean:define id="status" name="item" property="AARCHIVES_STATUS"/>
				    <% 
				    String strStatus = (String)status;
		            if(strStatus.equalsIgnoreCase("0")) {
		            	out.print("未归档");
		            }else if(strStatus.equalsIgnoreCase("1")){
		            	out.print("已归档");
		            }else if(strStatus.equalsIgnoreCase("2")){
		            	out.print("<font color=ff0000>没有扫描页</font>");
		            }else if(strStatus.equalsIgnoreCase("3")){
		            	out.print("<font color=ff0000>影像页页码相同</font>");
		            }else if(strStatus.equalsIgnoreCase("4")){
		            	out.print("<font color=ff0000>影像页“未通过检查”</font>");
		            }else {
		            	out.print("未通过");
		            }
		            %>
	            </td>
            </tr>
            </table>
		  </td>
        </tr>
		</logic:iterate>
    
		<logic:notEqual name="queryAllArchives" property="firstPage" value="true" >
			<a href="?page=first">&lt;&lt; 第一页</a>
			<a href="?page=previous">&lt;&lt; 上一页</a>
		</logic:notEqual>
		<logic:notEqual name="queryAllArchives" property="lastPage" value="true" >
			<a href="?page=next">下一页 &gt;&gt;</a>
			<a href="?page=last">最后页 &gt;&gt;</a>
		</logic:notEqual>
		共有<bean:write name="queryAllArchives" property="rowAmount" />条记录&nbsp;
		分为<bean:write name="queryAllArchives" property="pageAmount" />页&nbsp;
		每页<bean:write name="queryAllArchives" property="pageSize" />条&nbsp;
		当前第<input type="text" size="1" value="<bean:write name="queryAllArchives" property="pageIndex" />" onChange="javascript:gotoPage(this.value)" />页

		</logic:present>
      </table>

      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td align="center" bgcolor="#F7EED9">&nbsp; </td>
        </tr>
        <tr>
          <td align="center" bgcolor="#F7EED9"> <p>

            </p></td>
        </tr>
      </table>

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
