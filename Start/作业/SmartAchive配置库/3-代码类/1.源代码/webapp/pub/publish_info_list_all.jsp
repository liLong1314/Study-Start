<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<html>
<head>
<title>信息发布主页</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<script language="javascript" src="../common/js/base.js"></script>
<style type="text/css">
<!--
body {
	background-image: url(../image/2_mainpagebg_01.gif);
}
-->
</style>
<script language="JavaScript" type="text/JavaScript">

</script>
</head>
<body class="bg-page01">
<html:form action="/pub/viewAllPublishInfoList" method="post" >
<table border=0 width="80%" align="center">
<tr>
<td>
<!--公告-->
<logic:present name="SYSList">
        <table width="100%" border="0" cellpadding="5" cellspacing="0" align="left">
          <tr bgcolor="#AED3E6">
            <td nowrap>
		<img src="../image/dot02.gif"><font style="weight:bold">系统公告</font>
            </td>
            <td>
            	<div align="right"><a href="queryPublishInfoList.do?ACT=VIW">更多内容>></a></div>
            </td>
          </tr>
          <logic:present name="SYSList">
	  <logic:iterate id="item" name="SYSList" >
          <tr bgcolor="#f6f6f6" style='cursor:hand'
			  onMouseover="this.style.backgroundColor='#dff1ff'"
			  onMouseOut="this.style.backgroundColor='#f6f6f6'"
			  onclick="window.location='/pub/viewPublishInfo.do?info_id=<bean:write name="item" property="info_id"/>' ">
            <td colspan=2><li>
		<bean:write name="item" property="info_title"/>
		[<bean:write name="item" property="info_publish_person"/>,
		<bean:write name="item" property="info_publish_datetime"/>]
            </td>
          </tr>
	  </logic:iterate>
          </logic:present>
        </table>
</logic:present>
</td>
</tr>
<tr>
<td>
<!--反馈-->
<logic:present name="BUGList">
        <table width="100%" border="0" cellpadding="5" cellspacing="0" align="left">
          <tr bgcolor="#AED3E6">
            <td nowrap>
		<img src="../image/dot02.gif"><font style="weight:bold">用户反馈</font>
            </td>
            <td>
            	<div align="right"><a href="queryFeedbackList.do?ACT=VIW">更多内容>></a></div>
            </td>
          </tr>
          <logic:present name="BUGList">
	  <logic:iterate id="item" name="BUGList" >
          <tr bgcolor="#f6f6f6" style='cursor:hand'
			  onMouseover="this.style.backgroundColor='#dff1ff'"
			  onMouseOut="this.style.backgroundColor='#f6f6f6'"
			  onclick="window.location='/pub/viewPublishInfo.do?info_id=<bean:write name="item" property="info_id"/>' ">
            <td colspan=2><li>
		<bean:write name="item" property="info_title"/>
		[<bean:write name="item" property="info_publish_person"/>,
		<bean:write name="item" property="info_publish_datetime"/>]
            </td>
          </tr>
	  </logic:iterate>
          </logic:present>
        </table>
</logic:present>
</html:form>
</td>
</tr>
</table>
</body>
</html>
