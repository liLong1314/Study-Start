<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="com.sunyard.hgam.util.adc.AdcUtil"%>

<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>影像页检查</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<script src="/common/js/ftpOperator.js">
//连接ftp代码
</script>
<script src="/common/js/openWindow.js">
//打开窗口代码
</script>
<style type="text/css">
<!--
body {
	background-image: url(../image/2_mainpagebg_01.gif);
}
-->
</style>
</head>

<body class="bg-page01" onload="myLoad();" >
<object classid="clsid:32019071-CB2B-421D-928B-F485FA051451" id="UploadCtrl1" codebase="/ImgProc.cab" width="0" height="0"></object>
<script language="javascript">
<!--

//从配置文件获取配置参数
var serverName = '<bean:write property="properiesInfo.serverName" name="CheckArchivesPageForm"/>';
var serverPort = '<bean:write property="properiesInfo.serverPort" name="CheckArchivesPageForm"/>';
var userName = '<bean:write property="properiesInfo.userName" name="CheckArchivesPageForm"/>';
var password = '<bean:write property="properiesInfo.password" name="CheckArchivesPageForm"/>';
var ftpObject;
var imgProcObject;

//当打开页面时，从服务器下载并显示图片文件
function myLoad() {
try{
	ftpObject = document.getElementById("UploadCtrl1");
	imgProcObject = document.getElementById("imgProc");
	var sNext = "";

	if (document.all.functionName.value=='SaveOK') {
		//检查保存成功

		//根据functionReturn跳转
		if (document.all.functionReturn.value=="ShowPageUp" || document.all.functionReturn.value == "ShowPageDown"){
			document.all.functionName.value = document.all.functionReturn.value;
			document.CheckArchivesPageForm.submit();
		}else{
			alert("保存成功");
			sNext = "/adc/CheckArchivesPageView.do?archives_id=<bean:write property='archivesPage.archives_id' name="CheckArchivesPageForm"/>";
			document.location = sNext;
		}
	}
	else if (document.all.functionName.value=='SaveFail') {
		//检查保存失败
		alert("保存失败");

		//重新显示当前页
		document.all.functionName.value="ShowPage";
		document.CheckArchivesPageForm.submit();
	}
	else if (document.all.functionName.value=='nonePage') {
		alert("页空");

		//跳转到显示所有影像页的JSP
		sNext = "/adc/CheckArchivesPageView.do?archives_id=<bean:write property='archivesPage.archives_id' name="CheckArchivesPageForm"/>";
		document.location = sNext;
	}

	//如果图片已经存放在FTP服务器上，那么可以下载
	if(document.all.functionName.value=='PageFileReady') {
		var serverDir = document.all.serverDir.value;
		var serverFileName = document.all.serverFileName.value;
		//var localDir = 'c:\\temp\\';
		var  WshShell  =  new  ActiveXObject("WScript.Shell");
		//var localDir = WshShell.RegRead("HKEY_LOCAL_MACHINE\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Cache\\Paths\\Directory");
		//localDir = localDir + "\\";
     		var localDir = WshShell.RegRead("HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Explorer\\Shell Folders\\Local Settings");
		localDir = localDir + "\\Temp\\";
     		//alert(localDir);

		var localFileName = serverFileName;

		if (serverFileName!=""){
			var localFilePath = downloadFile(ftpObject, serverName, serverPort, userName, password, localDir, localFileName, serverDir, serverFileName);

			if(localFilePath != false) {
				//如果是图片文件，那么可以控件显示，否则浏览器打开
				//alert(localFilePath);
				if(imgProcObject.ShowPicture(localFilePath)==true) {
					//imgProcObject.SetPreview(true);
					imgProcObject.SetShowButton(false);
					imgProcObject.SetCaption('保存修改');
				}else {
					//document.location = "file:///" + localFilePath;
					window.open("file:///" + localFilePath);
				}
			}
		}
	}
	document.all.functionName.value = "";
	document.all.functionReturn.value = "";
}catch(e){
}
}

//图片处理后保存到服务器
function mySubmit() {

	var serverDir = document.all.serverDir.value;
	var serverFileName = document.all.serverFileName.value;
	//var localDir = WshShell.RegRead("HKEY_LOCAL_MACHINE\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Cache\\Paths\\Directory");
	//localDir = localDir + "\\";
     	var localDir = WshShell.RegRead("HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Explorer\\Shell Folders\\Local Settings");
	localDir = localDir + "\\Temp\\";
     	//alert(localDir);
	var localFileName = serverFileName;

	if (serverFileName!=""){
		//alert(serverFileName);
		if (!uploadFile(ftpObject, serverName, serverPort, userName, password, localDir, localFileName, serverDir, serverFileName)){
			alert("保存图像页失败！");
			return false;
		}
	}
	document.all.functionName.value="CheckSave";
	document.CheckArchivesPageForm.submit();
}

//显示上一页或下一页 “影像页”
function ShowNextPage(nextpage) {
	result = openDialogWindow('/adc/yesNo.htm','是否保存当前页的修改？',300,150);
	if(result=='YES'){
		document.all.functionReturn.value= nextpage;
		mySubmit();
	}
	if(result=='NO'){
		document.all.functionName.value= nextpage;
		document.CheckArchivesPageForm.submit();
	}
}

//得到保密区域
function setArea() {
	var myArea = imgProcObject.GetRegion();
	if(myArea == '') {
		alert('请先在图像上选中一块区域！');
	}else {
		document.getElementById("archivesPage.page_area").value = myArea;
	}
}

-->
</script>

<html:form action="/adc/CheckArchivesPage" method="post">
<html:hidden property="functionName"/>
<html:hidden property="functionReturn"/>
<html:hidden property="serverDir" />
<html:hidden property="serverFileName"/>
<html:hidden property="archivesPage.archives_id"/>
<html:hidden property="archivesPage.page_id"/>
<html:hidden property="archivesPage.page_pathName"/>

<table width="100%" height="100%" border="0">
<tr>
	<td width="100%" height="100%" align="left" valign="top">
		<object classid="clsid:FEDB33C8-E55B-4417-B6B7-5704435985C4" id="imgProc" codebase="/ImgProc.cab" width=100% height=100%></object>
	</td>
	<td valign="top">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
            <td width="32"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
            <td width="100%" background="../image/2_table_c_t.gif">
            	<table width="237" border="0" cellspacing="0" cellpadding="0">
                <tr align="center">
					<td width="25" align="right" background="../image/2_table_c_t.gif"><img src="../image/dot01.gif" width="8" height="8"></td>
					<td width="212">
		              	<table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#00A8CC">
						<tr>
	                        <td align="center" bgcolor="#E4F2FA" class="tishi">影像处理</td>
						</tr>
	                    </table>
					</td>
                </tr>
				</table>
			</td>
            <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
		</tr>
		<tr>
            <td background="../image/2_table_c_r.gif">&nbsp;</td>
            <td align="center" bgcolor="#FFFFFF">
            	<table width="100%" border="1">
                <tr>
					<td>
						<table width="100%" border="1" cellpadding="0" bordercolor="#EFEFEF" bgcolor="#FFFFFF">
						<tr>
							<td width="50%"><input type="button" name="btn11" value="去黑边" onClick="imgProcObject.CutBlank(5)"></td>
							<td width="50%"><input type="button" name="btn12" value="去污点" onClick="imgProcObject.CutPoint(5,5)"></td>
						</tr>
						<tr>
							<td><input type="button" name="btn21" value="截取区域" onClick="imgProcObject.InterceptArea()"></td>
							<td><input type="button" name="btn22" value="删除区域" onClick="imgProcObject.DeleteArea()"></td>
						</tr>
						<tr>
							<td><input type="button" name="btn31" value="自动纠漏" onClick="imgProcObject.AutoRotate()"></td>
							<td><input type="button" name="btn32" value="旋转" onClick="imgProcObject.Round()"></td>
						</tr>
						<tr>
							<td nowrap>
								<input type="button" name="btn41" value="预览" onClick="imgProcObject.SetPreview(true);">
								<input type="button" name="btn42" value="取消预览" onClick="imgProcObject.SetPreview(false);">
							</td>
							<td nowrap> <input type="button" name="btn43" value="保存修改" onClick="imgProcObject.ApplyPreview();"></td>
						</tr>
						</table>
					</td>
                </tr>
				</table>
			</td>
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
					<td width="212">
						<table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#00A8CC">
						<tr>
							<td align="center" bgcolor="#E4F2FA" class="tishi">信息处理</td>
						</tr>
						</table>
					</td>
				</tr>
				</table>
			</td>
            <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
		</tr>
		<tr>
            <td background="../image/2_table_c_r.gif">&nbsp;</td>
            <td align="center" bgcolor="#FFFFFF">
            	<table width="100%" border="1">
                <tr>
					<td>
						<table width="100%" border="1" cellpadding="0" bordercolor="#EFEFEF" bgcolor="#FFFFFF">
						<tr>
							<td width="55" nowrap>页码</td>
							<td nowrap><html:text property="archivesPage.page_num" style="width:100%" maxlength="6"/></td>
						</tr>
						<tr>
							<td width="55" nowrap>所属文件</td>
							<td nowrap><bean:define id="aa" name="CheckArchivesPageForm" property="list_ArchivesFiles"/>
								<html:select property="archivesPage.file_id" size="1" style="width:100%">
									<html:options collection="aa" property="value" labelProperty="label"/>
								</html:select>
							</td>
						</tr>
						<tr>
							<td width="55" nowrap>权限</td>
							<td nowrap><bean:define id="bb" name="CheckArchivesPageForm" property="list_operator"/>
								<html:select property="archivesPage.page_operate" size="1" style="width:100%">
									<html:options collection="bb" property="value" labelProperty="label"/>
								</html:select>
							</td>
						</tr>
						<tr>
							<td width="55" nowrap>页幅</td>
							<td nowrap><bean:define id="cc" name="CheckArchivesPageForm" property="list_pageSize"/>
								<html:select property="archivesPage.page_size" size="1" style="width:100%">
									<html:options collection="cc" property="value" labelProperty="label"/>
								</html:select>
							</td>
						</tr>
						<tr>
							<td width="55" nowrap>状态 </td>
							<td nowrap>
								<html:radio property="archivesPage.page_status" value="PASS" />通过
								<html:radio property="archivesPage.page_status" value="NOPASS" />未通过
							</td>
						</tr>
						<tr>
							<td nowrap><input type="button" name="btn81" value="设置保密区域" onClick="setArea();"></td>
							<td nowrap><html:text property="archivesPage.page_area" style="width:100%" maxlength="30"/></td>
						</tr>
						</table>
					</td>
				</tr>
				</table>
				<input type="button" name="btn91" value="上一页" onClick="ShowNextPage('ShowPageUp');">
				<input type="button" name="btn92" value="下一页" onClick="ShowNextPage('ShowPageDown');">
				<input type="button" name="btn93" value="保存" onClick="mySubmit();">
				<input type="button" name="btn99" value="返回" onClick="window.location='/adc/CheckArchivesPageView.do?archives_id=<bean:write property='archivesPage.archives_id' name='CheckArchivesPageForm'/>'">
			</td>
	        <td background="../image/2_table_c_l.gif">&nbsp;</td>
		</tr>
		<tr>
            <td><img src="../image/2_table_r_b.gif" width="32" height="20"></td>
            <td background="../image/2_table_c_b.gif"><img src="../image/2_table_c_b.gif" width="115" height="20"></td>
            <td><img src="../image/2_table_l_b.gif" width="26" height="20"></td>
		</tr>
		</table>
	</td>
</tr>
</table>

</html:form>
</body>
</html>
