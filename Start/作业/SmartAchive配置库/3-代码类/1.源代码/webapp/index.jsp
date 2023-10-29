<%@ page contentType="text/html; charset=gb2312" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<html>
<head>
<title>杭州市规划局档案综合管理系统 | 为您服务</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">

<script language="javascript">
/*
  if(top!=self)
  {
  	top.location=location;
  }
*/
</script>
</head>
<frameset rows="102,*,38" frameborder="NO" border="0" framespacing="0">
  <frame src="public/top_default.jsp" name="topFrame" scrolling="NO" noresize >
  <frameset name="content" rows="*" cols="188,27,*" framespacing="0" frameborder="NO" border="0">
    <frame src="public/left_default.jsp" name="left" scrolling="no" noresize id="left">

      <frame src="public/change.htm" name="change" scrolling="NO" noresize id="change">
      <frame src="/pub/viewAllPublishInfoList.do" name="hmain" id="hmain">

  </frameset>
  <frame src="public/bottom_default.htm" name="bottomFrame" scrolling="NO" noresize>
</frameset>
<noframes>
<body>
</body>
</noframes>
</html>
