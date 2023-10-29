<%@ page contentType="text/html;charset=GBK" language="java"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>

<html>
<head>
<title>档案综合查询-查看影像</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<script src="/common/js/ftpOperator.js">
<script src="/common/js/base.js">
//连接ftp代码
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
            <a href="?page=first&flag=<%=flag%>">&lt;&lt;第一页&nbsp;&nbsp;</a>
            <a href="?page=previous&flag=<%=flag%>">&lt;上一页&nbsp;&nbsp;</a>
          </logic:notEqual>
          <logic:notEqual name="pageImageList" property="lastPage" value="true" >
            <a href="?page=next&flag=<%=flag%>">下一页&gt;&nbsp;</a>
            <a href="?page=last&flag=<%=flag%>">最后页&gt;&gt;&nbsp;&nbsp;</a>
          </logic:notEqual>
          共<bean:write name="pageImageList" property="rowAmount" />个影像页面&nbsp;
            当前第<input type="text" size="1" value="<bean:write name="pageImageList" property="pageIndex" />" onChange="javascript:PageTo(this)">
          /<bean:write name="pageImageList" property="pageAmount" />页&nbsp;


	<%

	if(flag.equals("1")){
	%>
        <a title="返回" href="javascript:window.history.go(-1)">返回</a>
	<%
	}else{
	String ISOPERATION = "";
	if(request.getSession().getAttribute("ISOPERATION")!=null){
		ISOPERATION = String.valueOf(request.getSession().getAttribute("ISOPERATION"));
	}
	if(ISOPERATION.equals("1")){
	//业务类
	%>
        <a title="返回" href="/aum/viewArchivesFileListByPhaseId.do?page=">返回</a>
	<%}else{%>
	<a title="返回" href="/aum/viewArchivesFilesList.do?page=">返回</a>
	<%}}%>
	</td>
        </tr>
      </table>
      </logic:present>

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
			//alert(localFilePath);
			if(localFilePath != false) {
				//如果是图片文件，那么可以控件显示，否则浏览器打开
				//alert(localFilePath);
				if(imgProcObject.ShowPicture(localFilePath)==true) {
					//imgProcObject.SetPreview(true);
					imgProcObject.SetShowButton(false);
					imgProcObject.SetCaption('保存修改');
					//ADD BY ZHENGXQ:去掉保密区域
					var area=document.all("archivesPage.page_area");
					if(area.value!=""){
						imgProcObject.DeleteArea(area.value);
					}
					//设置漫游模式
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
