<%@ page contentType="text/html; charset=GBK" %>

<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>�ޱ����ĵ�</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
body {
	background-image: url(../image/2_mainpagebg_01.gif);
}
-->
</style>
<script src="/common/js/validCheck.js">
//���������Ч�Ժ����Ĵ���
</script>
<script src="/common/js/ftpOperator.js">
//����ftp����
</script>

</head>

<script language="JavaScript" type="text/JavaScript">
<!--

//��ʾ���ڱ���
function showSaving() {
	saving.style.visibility = "visible";
	scanCtrl.style.visibility = "hidden";
	cover.style.visibility = "visible";
}

//��ʾ���ڱ���
function hideSaving() {
	saving.style.visibility = "hidden";
	scanCtrl.style.visibility = "visible";
	cover.style.visibility = "hidden";
}

//-->
</script>


<body leftmargin="0" topmargin="0" onload = "scanPage()">

<html:form action="/adc/ScanPage" method="post" >
<html:hidden property="functionName"/>
<html:hidden property="folderName"/>
<html:hidden property="archives_id"/>
<html:hidden property="file_id"/>

<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">	
<tr>
	<td height="100%" valign="top" background="images/bgcolor.gif">
		<table width="90%" height="100%" border="0" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td height="21">
				<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr> 
					<td width="4%"><img src="../image/2_table_l_t.gif" width="32"></td>
					<td width="100%" background="../image/2_table_c_t.gif">
						<table width="237" border="0" cellspacing="0" cellpadding="0">
						<tr align="center"> 
							<td width="25" align="right" background="../image/2_table_c_t.gif"><img src="../image/dot01.gif" width="8"></td>
							<td width="212">
								<table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#00A8CC">
								<tr> 
									<td align="center" bgcolor="#E4F2FA" class="tishi">�ļ���Ϣ</td>
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
						<table width="100%"  border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
						<tr bgcolor="#FFFFFF"> 
							<td width="25%" nowrap>������</td>
							<td width="27%" nowrap><bean:write name="ArchivesPageForm" property="archives_num"/> </td>
							<td width="17%" nowrap>��������</td>
							<td width="31%" nowrap><bean:write name="ArchivesPageForm" property="archives_name"/></td>
						</tr>
						<tr bgcolor="#FFFFFF"> 
							<td width="20%" nowrap>�ļ�����</td>
							<td width="27%" nowrap><bean:write name="ArchivesPageForm" property="file_title"/></td>
							<td width="17%" nowrap>&nbsp;</td>
							<td width="31%" nowrap>&nbsp;</td>
						</tr>
						<tr align="center" bgcolor="#FFFFFF"> 
							<td colspan="4" nowrap> 
								<p>
								<input type="button"  name="button2"  value="����" onclick="mySubmit()" >
								<input type="button" name="Submit3" value="����" onclick="window.history.go(-1)">
								</p>
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
			</td>
		</tr>
		<div id="scanCtrl" style=" z-index:50; "> 
		<tr  align="center">
          	<td align="center"> 
            <p>								
              <input name="button" type="button" onclick="initPage()" value="��ʼ��ҳ��">
              <input name="button" type="button" onclick="paramSetPage1()" value="���õ�ҳ����">
              <input name="button" type="button" onclick="paramSetPage2()" value="������������">
              <input name="button22" type="button" onclick="scanPage()" value="ɨ��ҳ��">
            </p>
			</td>
		</tr>
		<tr>
			<td height="100%" valign="top"> 
			<object classid="clsid:B66669B1-BEA5-4176-A9A2-3D4410157C37" id="WebScan" data="DATA:application/x-oleobject;BASE64,sWlmtqW+dkGpoj1EEBV8NwADAADYEwAA2BMAAA==" width="100%" height="100%">
			</object> 
			</td>
		</tr>
				
		<object classid="clsid:32019071-CB2B-421D-928B-F485FA051451" id="UploadCtrl1" width="14" height="14">
			<param name="_ExtentX" value="370">
			<param name="_ExtentY" value="370">
		</object>
		</div>
		</table>
	</td>
</tr>
	
<script language="JavaScript" type="text/JavaScript">
<!--

var webscanObj;
var ftpObj;

//�������ļ���ȡ���ò���
var serverName = '<bean:write property="properiesInfo.serverName" name="ArchivesPageForm"/>';
var serverPort = '<bean:write property="properiesInfo.serverPort" name="ArchivesPageForm"/>';
var userName = '<bean:write property="properiesInfo.userName" name="ArchivesPageForm"/>';
var password = '<bean:write property="properiesInfo.password" name="ArchivesPageForm"/>';

var dirName = '/' + document.all.folderName.value;							//�ϴ����½���Ŀ¼��
var zipFileName = 'SubmitTemp.zip';											//ѹ������ļ���
var localZipFilePath = 'C:\\Program Files\\Sunyard\\SVII\\';				//ѹ�����ļ��Ĵ��·��
var folderStructPath = "C:\\Program Files\\Sunyard\\SVII\\FolderStruct.xml";//���folderSturct.xml�ļ���·��


//ɾ������ɨ���ļ�
function deleteFiles() {
   webscanObj.FileDelete('');
}

//��ʾ��ʼ��ɨ��ҳ
function initPage() {
	webscanObj.TabPageSet(0);
}

//��ʼ������ʾɨ��ҳ
function scanPage() {
	webscanObj = document.getElementById("WebScan");
	ftpObj = document.getElementById("UploadCtrl1");
	webscanObj.ViewModeSet(1);
	webscanObj.TabPageSet(2);
	
	if (document.all.functionName.value == "SaveOK"){
		alert("����ɹ���");
		deleteFiles();
		document.all.functionName.value = "SaveOK";
		document.ArchivesPageForm.submit();
	}else if (document.all.functionName.value == "SaveFail"){
		document.all.functionName.value = "";
		alert("����ʧ�ܣ������ԣ�");
	}
}

//��ʾ��ҳ��������ҳ��
function paramSetPage1() {
	webscanObj.TabPageSet(3);
}

//��ʾ������������ҳ��
function paramSetPage2() {
	webscanObj.TabPageSet(4);
}

//ѹ���ļ���
function zipFiles() {

	var strScanResultXML;

	//��ȡɨ��ͼ���ļ���xml�ļ�
	strScanResultXML=webscanObj.FileSubmit();
	if(strScanResultXML=="")
	{
		var errinfo=webscanObj.LastErrorGet();
		window.alert(errinfo);
	}
	else
	{
		//ѹ��Ӱ���ļ�
		var zipFile=localZipFilePath + zipFileName;
		webscanObj.FileZipWithName('',zipFile);
	}
}

function uploadFiles() {

	return uploadFile(ftpObj,serverName, serverPort, userName, password, localZipFilePath, zipFileName, dirName, zipFileName);

}

//�ݽ������������ļ�������ϴ���ɾ���ļ���������
function mySubmit() {
	document.all.functionName.value="SaveScanPage";
	
	showSaving();
	zipFiles();
	if(!uploadFiles()) {
		hideSaving();
		alert('����ʧ�ܣ�');
		return false;
	}
	//�ݽ�
	document.ArchivesPageForm.submit();
}

//-->
</script>

</table>
</html:form>
<div id="cover" style="position:absolute; top:0; left:0; z-index:9; visibility:hidden"><TABLE WIDTH=100% height=900 BORDER=0 CELLSPACING=0 CELLPADDING=0><TR><TD align=center><br></td></tr></table></div>
<div id="saving" style="position:absolute; left:349px; top:172px; width:305px; height:90px; z-index:51;visibility:hidden"> 
  <table width=100% border=0 cellspacing=0 cellpadding=0>
		    <tr> 
		      <td></td>
		      <td bgcolor=#ff9900><table width=100% height=70 border=0 cellspacing=2 cellpadding=0>
		          <tr> 
		            <td bgcolor=#eeeeee align=center>���ڱ���ͼƬ, ���Ժ�...</td>
		          </tr>
		        </table></td>
		      <td></td>
		    </tr>
		  </table>
		</div>
</body>
</html>
