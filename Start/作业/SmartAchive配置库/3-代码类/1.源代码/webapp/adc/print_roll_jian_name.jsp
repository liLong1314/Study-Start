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
templetFileName += "rollbeikaojianname.xls";

//�õ�c
String begin_id = request.getParameter("begin_id");
String end_id = request.getParameter("end_id");

PrintInfo printInfo = new PrintInfo();
//���ò���
//printInfo.setPrintData(Common.getRoll_JianName_Content("11","22"));
printInfo.setPrintData(Common.getRoll_JianName_Content(begin_id,end_id));
printInfo.setTempletFileName(templetFileName);
printInfo.setHeight(2);
printInfo.setLeft(1);
//�õ�VBS����
out.print(printInfo.getVBSCode());

%>

<body onload="javascript:self.close()">

</body>
</html>
