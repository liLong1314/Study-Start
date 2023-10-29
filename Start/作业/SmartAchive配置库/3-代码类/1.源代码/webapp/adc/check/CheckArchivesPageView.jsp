<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="com.sunyard.hgam.util.adc.AdcUtil"%>
<%@ page import="java.util.List" %>

<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<title>档案检查</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
body {
	background-image: url(../image/2_mainpagebg_01.gif);
}
-->
</style>
<script src="/common/js/openWindow.js">
//打开窗口的代码
</script>
<script src="/common/js/chkBoxOperation.js">
//复选框操作代码
</script>
</head>

<body class="bg-page01" onload="myLoad();" onUnLoad="myUnLoad();">
<script language="JavaScript" type="text/JavaScript">
<!--
function DeletePages(){
	if (confirm("你确认删除吗？")){
		document.all.functionName.value = "DeletePage";
		document.CheckArchivesPageViewForm.submit();
	}
}

function myLoad() {
	if (document.all.functionName.value=='DeleteOK') {
		alert("删除成功！");
	}
	if (document.all.functionName.value=='DeleteFailure') {
		alert("删除失败！");
	}
}

function myUnLoad() {
	//alert("close");
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

//-->
</script>

<html:form action="/adc/CheckArchivesPageView" method="post" >
<html:hidden property="functionName"/>
<html:hidden property="functionData"/>
<html:hidden property="archives.AARCHIVES_ID"/>

  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="32"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td colspan="3" background="../image/2_table_c_t.gif">&nbsp;</td>
      <td width="26"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td width="50" align="right" bgcolor="#FFFFFF"> <img src="../image/dot01.gif" width="8" height="8"><br>
      </td>
      <td width="8" align="center" bgcolor="#FFFFFF">&nbsp;</td>
      <td width="637" align="left" bgcolor="#FFFFFF"> 您现在的位置： 档案检查 &gt;&gt; 影像页列表 &gt;&gt; </td>
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
      <td width="32"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="100%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center"> 
            <td width="25" align="right" background="../image/2_table_c_t.gif"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#00A8CC">
                <tr> 
                  <td align="center" bgcolor="#E4F2FA" class="tishi">档案影像页列表</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr> 
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td align="center" bgcolor="#FFFFFF"><table width="100%"  border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
          <tr bgcolor="#FFFFFF"> 
            <td width="131%" nowrap><table width="100%"  border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
                <tr bgcolor="#FFFFFF"> 
                  <td width="6%" nowrap>档号</td>
                  <td width="20%" nowrap><bean:write name="CheckArchivesPageViewForm" property="archives.AARCHIVES_NUM" /></td>
                  
                <td width="14%" nowrap>档案题名/件题名</td>
                  <td width="60%" ><bean:write name="CheckArchivesPageViewForm" property="archives.AARCHIVES_NAME" /></td>
                </tr>
              </table>
			</td>
          </tr>
          <tr align="center" bgcolor="#FFFFFF"> 
            <td height="16" nowrap> <input name="Submit3" type="button" onClick="openPageCheckUpdateWindow('/adc/check/CheckUpdatePageNum.jsp')" value="修改页码"> 
              <input name="Submit32" type="button" onClick="openPageCheckUpdateWindow('/adc/check/CheckUpdateFileID.jsp')" value="修改所属文件">
              <input name="Submit332" type="button" onClick="openPageCheckUpdateWindow('/adc/check/CheckUpdatePageOperator.jsp')" value="设置权限"> 
              <input name="Submit332" type="button" onClick="openPageCheckUpdateWindow('/adc/check/CheckUpdatePageSize.jsp')" value="设置页幅"> 
              <input name="Submit333" type="button" onclick="openPageCheckUpdateWindow('/adc/check/CheckUpdateStatus.jsp')" value="设置状态"> 
              <input type="button" name="Submit334" value="删除页" onClick="DeletePages();"> </td>
          </tr>
        </table>
        <br> 
        <table width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
        <tr align="center" bgcolor="#F7EED9"> 
            
          <td width="10" align="center"> 
            <input type=checkbox onclick="if(this.checked)SelectAll(document.forms[0],'selectedPageID');else UnSelectAll(document.forms[0],'selectedPageID');">
          </td>
			<td>
		    	<table width="100%" border="0" cellpadding="2" cellspacing="1">
				<tr>
		            <td width="6%">页码</td>
		            <td width="18%">文件编号</td>
		            <td width="50">对象类型</td>
		            <td width="17%">著录日期</td>
		            <td width="10%">操作权限</td>
		            <td width="10%">页幅</td>
		            <td width="16%">保密区域</td>
		            <td width="50">对象状态</td>
	            </tr>
	            </table>
	        </td>
          </tr>
	      <logic:present name="queryArchivesPage">
		  <logic:iterate id="listItem" name="queryArchivesPage" >
		  <tr>
          	<td width="10" align="center"><input type="checkbox" name="selectedPageID" value="<bean:write name='listItem' property='page_id'/>"></td>
            <td>
		    	<table width="100%" border="0" cellpadding="2" cellspacing="1">
	            <tr align="center" bgcolor="#f6f6f6" style='cursor:hand' 
			       	onMouseover="this.style.backgroundColor='#dff1ff'" 
			       	onMouseOut="this.style.backgroundColor='#f6f6f6'" 
			       	onclick="window.location='../adc/CheckArchivesPage.do?page_id=<bean:write name='listItem' property='page_id' />'">
		            <td width="6%"><bean:write name="listItem" property="page_num"/></td>
		            <td width="18%">
			            <bean:define id="fileID" name="listItem" property="file_id"/>
			            <%
			            	//把资料类型id转换成可读的字符串
			            	out.print(AdcUtil.getArchivesFileCaptionByFileID((String)fileID));
			            %> 
		            </td>
		            <td width="50"><bean:write name="listItem" property="page_type"/></td>
		            <td width="17%"><bean:write name="listItem" property="page_date"/></td>
		            <td width="10%">
			            <bean:define id="pageOperate" name="listItem" property="page_operate"/>
			            <%
			            	//把资料类型id转换成可读的字符串
			            	out.print(AdcUtil.getSysParamByTypeAndValue("PAGE_OPERATOR", (String)pageOperate));
			            %> 
		            </td>
		            <td width="10%">
			            <bean:define id="pageSize" name="listItem" property="page_size"/>
			            <%
			            	//把资料类型id转换成可读的字符串
			            	out.print(AdcUtil.getSysParamByTypeAndValue("PAGE_SIZE", (String)pageSize));
			            %> 
		            </td>
		            <td width="16%">
			            <bean:write name="listItem" property="page_area"/>
		            </td>
		            <td width="50">
					    <bean:define id="pageStatus" name="listItem" property="page_status"/>
					    <% 
					    String strPageStatus = (String)pageStatus;
			            if(((strPageStatus).equalsIgnoreCase("PASS"))) {
			            	out.print("通过");
			            }else if(((strPageStatus).equalsIgnoreCase("NOPASS"))){
			            	out.print("未通过");
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
			<logic:notEqual name="queryArchivesPage" property="firstPage" value="true" >
				<a href="?page=first">&lt;&lt; 第一页</a>
				<a href="?page=previous">&lt;&lt; 上一页</a>
			</logic:notEqual>
			<logic:notEqual name="queryArchivesPage" property="lastPage" value="true" >
				<a href="?page=next">下一页 &gt;&gt;</a>
				<a href="?page=last">最后页 &gt;&gt;</a>
			</logic:notEqual>
			共有<bean:write name="queryArchivesPage" property="rowAmount" />条记录&nbsp;
			分为<bean:write name="queryArchivesPage" property="pageAmount" />页&nbsp;
			每页<bean:write name="queryArchivesPage" property="pageSize" />条&nbsp; 
			当前第<input type="text" size="1" value="<bean:write name="queryArchivesPage" property="pageIndex" />" onChange="javascript:gotoPage(this.value)" />页
		  </logic:present>
        </table>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr> 
            <td align="center" bgcolor="#F7EED9"> 
              <input type="button" name="Submit22" value="打印" onClick="window.print()">
              <input type="button" name="Submit222" value="返回" onClick="window.location= '/adc/checkArchivesView.do'">
            </td>
          </tr>
        </table>
        <br> </td>
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
