<%@ page contentType="text/html;charset=GBK" language="java"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>

<html>
<head>
<title>�����ۺϲ�ѯ-�鿴Ӱ��</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<script src="/common/js/ftpOperator.js">
<script src="/common/js/base.js">
//����ftp����
</script>
<style type="text/css">
<!--
body {
	background-image: url(../image/2_mainpagebg_01.gif);
}
-->
</style>
</head>
<body class="bg-page01" onload="myLoad();">
<%
String flag = request.getParameter("flag");
if(flag==null) flag="";
%>
      <logic:present name="pageImageList">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="100%">
          <logic:notEqual name="pageImageList" property="firstPage" value="true" >
            <a href="?page=first&flag=<%=flag%>">&lt;&lt;��һҳ&nbsp;&nbsp;</a>
            <a href="?page=previous&flag=<%=flag%>">&lt;��һҳ&nbsp;&nbsp;</a>
          </logic:notEqual>
          <logic:notEqual name="pageImageList" property="lastPage" value="true" >
            <a href="?page=next&flag=<%=flag%>">��һҳ&gt;&nbsp;</a>
            <a href="?page=last&flag=<%=flag%>">���ҳ&gt;&gt;&nbsp;&nbsp;</a>
          </logic:notEqual>
          ��<bean:write name="pageImageList" property="rowAmount" />��Ӱ��ҳ��&nbsp;
            ��ǰ��<input type="text" size="1" value="<bean:write name="pageImageList" property="pageIndex" />" onChange="javascript:PageTo(this)">
          /<bean:write name="pageImageList" property="pageAmount" />ҳ&nbsp;


	<%

	if(flag.equals("1")){
	%>
        <a title="����" href="javascript:window.history.go(-1)">����</a>
	<%
	}else{
	String ISOPERATION = "";
	if(request.getSession().getAttribute("ISOPERATION")!=null){
		ISOPERATION = String.valueOf(request.getSession().getAttribute("ISOPERATION"));
	}
	if(ISOPERATION.equals("1")){
	//ҵ����
	%>
        <a title="����" href="/aum/viewArchivesFileListByPhaseId.do?page=">����</a>
	<%}else{%>
	<a title="����" href="/aum/viewArchivesFilesList.do?page=">����</a>
	<%}}%>
	</td>
        </tr>
      </table>
      </logic:present>

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
			//alert(localFilePath);
			if(localFilePath != false) {
				//�����ͼƬ�ļ�����ô���Կؼ���ʾ�������������
				//alert(localFilePath);
				if(imgProcObject.ShowPicture(localFilePath)==true) {
					//imgProcObject.SetPreview(true);
					imgProcObject.SetShowButton(false);
					imgProcObject.SetCaption('�����޸�');
					//ADD BY ZHENGXQ:ȥ����������
					var area=document.all("archivesPage.page_area");
					if(area.value!=""){
						imgProcObject.DeleteArea(area.value);
					}
					//��������ģʽ
					imgProcObject.SetZoomMode();
				}else {
					document.location = "file:///" + localFilePath;
				}
			}
		}
	}
}catch(e){
}
}
-->
</script>
<object classid="clsid:FEDB33C8-E55B-4417-B6B7-5704435985C4" id="imgProc" codebase="/ImgProc.cab" width=100% height=98% ></object>
<html:form action="/aum/viewArchivesPage.do" method="post">
<html:hidden property="functionName"/>
<html:hidden property="functionReturn"/>
<html:hidden property="serverDir" />
<html:hidden property="serverFileName"/>
<html:hidden property="archivesPage.page_area"/>
<html:hidden property="archivesPage.page_pathName"/>
</html:form>
</body>
</html>
