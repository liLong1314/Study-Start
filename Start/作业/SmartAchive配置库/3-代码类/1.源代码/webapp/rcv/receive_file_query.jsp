<%@ page contentType="text/html; charset=gb2312" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<html>
<head>
<title>接收文件列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<script language="javascript" src="../common/js/base.js"></script>
<script language="javascript" src="../common/js/chkBoxOperation.js"></script>
<style type="text/css">
<!--
body {
	background-image: url(../image/2_mainpagebg_01.gif);
}
-->
</style>
<script language="JavaScript" type="text/JavaScript">
<!--
var fileId = "";
//查询
function doQuery(theform){
	theform.submit();
}

//检查
function doCheck(theform){
	var operName = document.all("operName");
	if(!validateCheckBox(theform)){
		alert("请选择需要进行操作的记录");
		return false;
	}
	operName.value="CHECK_ACTION";
	theform.submit();
}
//接收
function doReceive(theform){
	var operName = document.all("operName");
	if(!validateCheckBox(theform)){
		alert("请选择需要进行操作的记录");
		return false;
	}
	if(confirm("您确认从接口库接收所选择的电子文件吗？")){
		operName.value="RECEIVE_ACTION";
		if (fileId.substring(fileId.length-1,fileId.length)==",")
			fileId = fileId.substring(0,fileId.length-1);
		//alert(fileId);
		var receiveForm = document.forms[1];
		var fileIds1 = document.all("fileIds1");
		fileIds1.value = fileId;
		receiveForm.submit();
	}
}
//退回
function doBack(theform){
	var operName = document.all("operName");
	if(!validateCheckBox(theform)){
		alert("请选择需要进行操作的记录");
		return false;
	}
	if(confirm("您确认退回接口库中所选择的电子文件吗？")){
		operName.value="BACK_ACTION";
		if (fileId.substring(fileId.length-1,fileId.length)==",")
			fileId = fileId.substring(0,fileId.length-1);
		//alert(fileId);
		var backForm = document.forms[2];
		var fileIds2 = document.all("fileIds2");
		fileIds2.value = fileId;
		backForm.submit();
	}
}
//
function validateCheckBox(theform){
	var obj=document.getElementsByName("file_id");
	var isChecked = false;
	fileId = "";
	for(var i=0;i<obj.length;i++){
		if (obj[i].checked){
			isChecked=true;
			fileId += obj[i].value + ",";
		}
	}
	return isChecked;
}
//查看
function doGoto(url){
	window.location=url;
}
-->
</script>
</head>
<body class="bg-page01">
<html:form action="/rcv/queryIfaceArchivesFileList" method="post" >
  <html:hidden property="operName"/>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="32"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="100%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#0293CA">
                <tr>

                <td align="center" bgcolor="#E4F7FA" class="tishi">待接收文件查询条件</td>
                </tr>
            </table></td>
          </tr>
      </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td align="center" bgcolor="#FFFFFF"> <br>
          <table width="100%" height="37" border="0">
            <tr>
            <td height="31">
              <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
                <tr bgcolor="#FFFFFF">
                  <td nowrap id="Mode1">项目编号:</td>
                  <td nowrap id="Mode1">
			<html:text property="archivesFile.proj_id" value="" size="12" maxlength="40"/>
                  </td>
                  <td nowrap id="Mode1">项目名称:</td>
                  <td nowrap id="Mode1">
			<html:text property="archivesFile.proj_name" value="" size="20" maxlength="40"/>
                  </td>
                  <td nowrap id="Mode1">文件阶段:</td>
                  <td nowrap id="Mode1">
			<html:select property="archivesFile.phase_id">
			<html:option value=""/>
			<html:optionsCollection property="phase_idOptions"/>
			</html:select>
                  </td>
                  <td nowrap id="Mode1">文件上级阶段:</td>
                  <td nowrap id="Mode1">
			<html:select property="archivesFile.up_phase_id">
			<html:optionsCollection property="up_phase_idOptions"/>
			</html:select>
                  </td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td nowrap id="Mode1">文件编号:</td>
                  <td nowrap id="Mode1">
			<html:text property="archivesFile.file_num" value="" size="12" maxlength="40"/>
                  </td>
                  <td nowrap id="Mode1">文件题名:</td>
                  <td nowrap id="Mode1">
			<html:text property="archivesFile.file_title" value="" size="20" maxlength="40"/>
                  </td>
                  <td nowrap id="Mode1" colspan=3>每页列出:
			<input type="text" name="pageSize" value="10" size=5 maxlength=10>条
                  </td>
                  <td>
			<input type="button" name="btnQry" value="查询" onClick="doQuery(this.form)">
                  </td>
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
      <td width="100%" background="../image/2_table_c_t.gif">
	<table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#0293CA">
                <tr>

                <td align="center" bgcolor="#E4F7FA" class="tishi">待接收文件信息列表</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="4%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif"><img src="../image/2_table_c_r.gif" width="32" height="24"></td>

    <td align="center" bgcolor="#FFFFFF">
        <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#FFFFFF">
        <tr align="center" bgcolor="#F7EED9">
          <td bgcolor="#F7EED9"><input type="checkbox" onclick="if(this.checked)SelectAll(this.form,'file_id');else UnSelectAll(this.form,'file_id');">选择</td>
          <td bgcolor="#F7EED9">项目编号</td>
          <td bgcolor="#F7EED9">项目名称</td>
          <td bgcolor="#F7EED9">文件编号</td>
          <td bgcolor="#F7EED9">文件题名</td>
          <td bgcolor="#F7EED9">查看文件</td>
        </tr>
	<logic:notPresent name="ifaceArchivesFileList">
	<tr align="center" bgcolor="#F7EED9">
          <td colspan=6>暂无记录</td>
        </tr>
	</logic:notPresent>
	<logic:present name="ifaceArchivesFileList">
	<logic:iterate id="list" name="ifaceArchivesFileList" >
        <tr align="center" bgcolor="#F7EED9">
          <td bgcolor="#F6F6F6">
		<input type="checkbox" name="file_id" value="<bean:write name="list" property="file_id" />">
          </td>
          <td bgcolor="#F6F6F6"><bean:write name="list" property="proj_id" /></td>
          <td bgcolor="#F6F6F6"><bean:write name="list" property="proj_name" /></td>
          <td bgcolor="#F6F6F6"><bean:write name="list" property="file_num" /></td>
          <td bgcolor="#F6F6F6"><bean:write name="list" property="file_title" /></td>
          <td bgcolor="#F6F6F6"><a href="viewIfaceArchivesFile.do?file_id=<bean:write name="list" property="file_id" />">GO</a></td>
          </tr>
	</logic:iterate>
	</logic:present>
      </table>

      <logic:present name="ifaceArchivesFileList">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td bgcolor="#F7EED9"> <logic:notEqual name="ifaceArchivesFileList" property="firstPage" value="true" >
            <a href="?page=first">&lt;&lt;
            第一页 </a><a href="?page=previous">&lt;
            上一页 </a></logic:notEqual> <logic:notEqual name="ifaceArchivesFileList" property="lastPage" value="true" >
            <a href="?page=next">下一页
            &gt; </a><a href="?page=last">最后页
            &gt;&gt; </a></logic:notEqual>&nbsp; 共<bean:write name="ifaceArchivesFileList" property="rowAmount" />条记录&nbsp;
            当前第
            <input type="text" size="1" value="<bean:write name="ifaceArchivesFileList" property="pageIndex" />" onChange="javascript:PageTo(this)">
            /<bean:write name="ifaceArchivesFileList" property="pageAmount" />
            页&nbsp; 每页<bean:write name="ifaceArchivesFileList" property="pageSize" />条</td>
        </tr>
      </table>
      </logic:present>

      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td align="center" bgcolor="#F7EED9">
              <!--<input type="button" name="button2" value="检查" onclick="doCheck(this.form);">-->
              <input type="button" name="button1" value="接收所选文件" onclick="doReceive(this.form);">
              <input type="button" name="Submit3" value="退回所选文件" onclick="doBack(this.form);">
              <input type="button" name="button4" value="打印" onclick="window.print()">
          </td>
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
<html:form action="/rcv/receiveIfaceArchivesFiles.do" method="post" >
  <input type="hidden" name="fileIds1" value=""/>
</html:form>
<html:form action="/rcv/backIfaceArchivesFiles.do" method="post" >
  <input type="hidden" name="fileIds2" value=""/>
</html:form>
</body>
</html>
