<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="com.sunyard.hgam.util.adc.AdcUtil"%>

<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Ӱ��ҳ���</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<script src="/common/js/ftpOperator.js">
//����ftp����
</script>
<script src="/common/js/openWindow.js">
//�򿪴��ڴ���
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

//�������ļ���ȡ���ò���
var serverName = '<bean:write property="properiesInfo.serverName" name="CheckArchivesPageForm"/>';
var serverPort = '<bean:write property="properiesInfo.serverPort" name="CheckArchivesPageForm"/>';
var userName = '<bean:write property="properiesInfo.userName" name="CheckArchivesPageForm"/>';
var password = '<bean:write property="properiesInfo.password" name="CheckArchivesPageForm"/>';
var ftpObject;
var imgProcObject;

//����ҳ��ʱ���ӷ��������ز���ʾͼƬ�ļ�
function myLoad() {
try{
	ftpObject = document.getElementById("UploadCtrl1");
	imgProcObject = document.getElementById("imgProc");
	var sNext = "";

	if (document.all.functionName.value=='SaveOK') {
		//��鱣��ɹ�

		//����functionReturn��ת
		if (document.all.functionReturn.value=="ShowPageUp" || document.all.functionReturn.value == "ShowPageDown"){
			document.all.functionName.value = document.all.functionReturn.value;
			document.CheckArchivesPageForm.submit();
		}else{
			alert("����ɹ�");
			sNext = "/adc/CheckArchivesPageView.do?archives_id=<bean:write property='archivesPage.archives_id' name="CheckArchivesPageForm"/>";
			document.location = sNext;
		}
	}
	else if (document.all.functionName.value=='SaveFail') {
		//��鱣��ʧ��
		alert("����ʧ��");

		//������ʾ��ǰҳ
		document.all.functionName.value="ShowPage";
		document.CheckArchivesPageForm.submit();
	}
	else if (document.all.functionName.value=='nonePage') {
		alert("ҳ��");

		//��ת����ʾ����Ӱ��ҳ��JSP
		sNext = "/adc/CheckArchivesPageView.do?archives_id=<bean:write property='archivesPage.archives_id' name="CheckArchivesPageForm"/>";
		document.location = sNext;
	}

	//���ͼƬ�Ѿ������FTP�������ϣ���ô��������
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
				//�����ͼƬ�ļ�����ô���Կؼ���ʾ�������������
				//alert(localFilePath);
				if(imgProcObject.ShowPicture(localFilePath)==true) {
					//imgProcObject.SetPreview(true);
					imgProcObject.SetShowButton(false);
					imgProcObject.SetCaption('�����޸�');
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

//ͼƬ����󱣴浽������
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
			alert("����ͼ��ҳʧ�ܣ�");
			return false;
		}
	}
	document.all.functionName.value="CheckSave";
	document.CheckArchivesPageForm.submit();
}

//��ʾ��һҳ����һҳ ��Ӱ��ҳ��
function ShowNextPage(nextpage) {
	result = openDialogWindow('/adc/yesNo.htm','�Ƿ񱣴浱ǰҳ���޸ģ�',300,150);
	if(result=='YES'){
		document.all.functionReturn.value= nextpage;
		mySubmit();
	}
	if(result=='NO'){
		document.all.functionName.value= nextpage;
		document.CheckArchivesPageForm.submit();
	}
}

//�õ���������
function setArea() {
	var myArea = imgProcObject.GetRegion();
	if(myArea == '') {
		alert('������ͼ����ѡ��һ������');
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
	                        <td align="center" bgcolor="#E4F2FA" class="tishi">Ӱ����</td>
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
							<td width="50%"><input type="button" name="btn11" value="ȥ�ڱ�" onClick="imgProcObject.CutBlank(5)"></td>
							<td width="50%"><input type="button" name="btn12" value="ȥ�۵�" onClick="imgProcObject.CutPoint(5,5)"></td>
						</tr>
						<tr>
							<td><input type="button" name="btn21" value="��ȡ����" onClick="imgProcObject.InterceptArea()"></td>
							<td><input type="button" name="btn22" value="ɾ������" onClick="imgProcObject.DeleteArea()"></td>
						</tr>
						<tr>
							<td><input type="button" name="btn31" value="�Զ���©" onClick="imgProcObject.AutoRotate()"></td>
							<td><input type="button" name="btn32" value="��ת" onClick="imgProcObject.Round()"></td>
						</tr>
						<tr>
							<td nowrap>
								<input type="button" name="btn41" value="Ԥ��" onClick="imgProcObject.SetPreview(true);">
								<input type="button" name="btn42" value="ȡ��Ԥ��" onClick="imgProcObject.SetPreview(false);">
							</td>
							<td nowrap> <input type="button" name="btn43" value="�����޸�" onClick="imgProcObject.ApplyPreview();"></td>
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
							<td align="center" bgcolor="#E4F2FA" class="tishi">��Ϣ����</td>
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
							<td width="55" nowrap>ҳ��</td>
							<td nowrap><html:text property="archivesPage.page_num" style="width:100%" maxlength="6"/></td>
						</tr>
						<tr>
							<td width="55" nowrap>�����ļ�</td>
							<td nowrap><bean:define id="aa" name="CheckArchivesPageForm" property="list_ArchivesFiles"/>
								<html:select property="archivesPage.file_id" size="1" style="width:100%">
									<html:options collection="aa" property="value" labelProperty="label"/>
								</html:select>
							</td>
						</tr>
						<tr>
							<td width="55" nowrap>Ȩ��</td>
							<td nowrap><bean:define id="bb" name="CheckArchivesPageForm" property="list_operator"/>
								<html:select property="archivesPage.page_operate" size="1" style="width:100%">
									<html:options collection="bb" property="value" labelProperty="label"/>
								</html:select>
							</td>
						</tr>
						<tr>
							<td width="55" nowrap>ҳ��</td>
							<td nowrap><bean:define id="cc" name="CheckArchivesPageForm" property="list_pageSize"/>
								<html:select property="archivesPage.page_size" size="1" style="width:100%">
									<html:options collection="cc" property="value" labelProperty="label"/>
								</html:select>
							</td>
						</tr>
						<tr>
							<td width="55" nowrap>״̬ </td>
							<td nowrap>
								<html:radio property="archivesPage.page_status" value="PASS" />ͨ��
								<html:radio property="archivesPage.page_status" value="NOPASS" />δͨ��
							</td>
						</tr>
						<tr>
							<td nowrap><input type="button" name="btn81" value="���ñ�������" onClick="setArea();"></td>
							<td nowrap><html:text property="archivesPage.page_area" style="width:100%" maxlength="30"/></td>
						</tr>
						</table>
					</td>
				</tr>
				</table>
				<input type="button" name="btn91" value="��һҳ" onClick="ShowNextPage('ShowPageUp');">
				<input type="button" name="btn92" value="��һҳ" onClick="ShowNextPage('ShowPageDown');">
				<input type="button" name="btn93" value="����" onClick="mySubmit();">
				<input type="button" name="btn99" value="����" onClick="window.location='/adc/CheckArchivesPageView.do?archives_id=<bean:write property='archivesPage.archives_id' name='CheckArchivesPageForm'/>'">
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
