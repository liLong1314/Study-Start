<%@ page contentType="text/html;charset=GBK" language="java"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>

<html:html>
<head>
<title>����У��-�鿴ҳ��</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<script src="/common/js/ftpOperator.js">
//����ftp����
</script>
<style type="text/css">
<!--
body {
	background-image: url(../image/2_mainpagebg_01.gif);
}
-->
</style></head>
<body class="bg-page01" onload="myLoad();">
<object classid="clsid:32019071-CB2B-421D-928B-F485FA051451" id="UploadCtrl1" width="0" height="0"></object>
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
	ftpObject = document.getElementById("UploadCtrl1");
	imgProcObject = document.getElementById("imgProc");
	var sNext = "";

	//���ͼƬ�Ѿ������FTP�������ϣ���ô��������
	if(document.all.functionName.value=='PageFileReady') {
		var serverDir = document.all.serverDir.value;
		var serverFileName = document.all.serverFileName.value;
		var localDir = 'c:\\temp\\';

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
					document.location = "file:///" + localFilePath;
				}
			}
		}
	}
}
-->
</script>
<html:form action="/arm/ArchImageShow.do" method="post">
<html:hidden property="functionName"/>
<html:hidden property="functionReturn"/>
<html:hidden property="serverDir" />
<html:hidden property="serverFileName"/>
</html:form>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="4%"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="94%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif" bgcolor="#FFFFFF"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#99CC00">
                <tr>
                <td align="center" bgcolor="#F2F9E6" class="tishi">�����ļ�Ӱ��</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif"><img src="../image/2_table_c_r.gif" width="32" height="234"></td>
      <td align="center" bgcolor="#FFFFFF" valign="top">
      <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#FFFFFF">
        <tr align="center" bgcolor="#F7EED9">
          <td width="20%">�ļ�·������</td>
          <td width="30%"><bean:write name="pageOper" property="pagePathName"/></td>
          <td width="20%">¼��ʱ�䣺</td>
          <td width="30%"><bean:write name="pageOper" property="pageDate"/></td>
        </tr>
        <tr align="center">
          <td bgcolor="#f6f6f6" width="20%">ҳ���ͣ�</td>
          <td bgcolor="#f6f6f6" width="30%"><bean:write name="pageOper" property="pageType"/></td>
          <td bgcolor="#f6f6f6" width="20%">ҳ����</td>
          <td bgcolor="#f6f6f6" width="30%"><bean:write name="pageOper" property="pageSize"/></td>
        </tr>
        <tr align="center" bgcolor="#F7EED9">
          <td colspan="4">
            <input type="button" name="close" onclick="javscript:window.close()" value="�ر�">
          </td>
        </tr>
      </table>
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td bgcolor="#f6f6f6" align="center">
          <!--img src="file:///D|/hgam/webapp/image/mm03.jpg" width="300" height="400"-->
          <object classid="clsid:FEDB33C8-E55B-4417-B6B7-5704435985C4" id="imgProc" width=800 height=600></object>
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
</body>
</html:html>
