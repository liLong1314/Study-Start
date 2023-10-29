<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<html>
<head>
<title>×ÛºÏ²éÑ¯</title>
</head>
<frameset  name="content" rows="*" cols="180,*" framespacing="0" frameborder="NO" scrolling="AUTO" border="0">
  <frame src="/arm/ViewAllEntryTreeList.do?type=9" name="leftFrame" scrolling="AUTO" noresize>
  <frameset cols="20,*" frameborder="NO" border="0" framespacing="0">
    <frame src="/public/change.htm" name="leftFrame1" scrolling="NO" noresize>
    <frame src="l_right.htm" name="main" id="main" scrolling="AUTO">
  </frameset>
</frameset>
  <script language="javascript">
  if(top!=self)
  {
  	top.location=location;
  }
</script>
<noframes><body>

</body></noframes>
</html>
