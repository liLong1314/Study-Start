<%@ page contentType="text/html; charset=gb2312" %>

<%@ page import="com.sunyard.hgam.util.common.PrintInfo"%>
<%@ page import="com.sunyard.hgam.util.common.Common"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>��ӡ</title>
<link href="../../common/css/sunhoo.css" rel="stylesheet" type="text/css">
</head>
���Ժ�......
<%
//�õ�ģ���·��
String requestURI = request.getRequestURI();
String requestURL = request.getRequestURL().toString();
int serverURLLen = requestURL.length() - requestURI.length();
String templetFileName = requestURL.substring(0,serverURLLen);

templetFileName += "/templet/";
templetFileName += "rollbeikao.xls";

//�õ�archives_id
String archives_id = request.getParameter("archives_id");

PrintInfo printInfo = new PrintInfo();
//���ò���
printInfo.setPrintData(Common.getYewuBeiKao(archives_id));

printInfo.setTempletFileName(templetFileName);
printInfo.setHeight(2);
printInfo.setLeft(1);
//�õ�VBS����
out.print(printInfo.getVBSCode());

%>

<body onload="javascript:self.close()">

</body>
</html>
