<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<html>
<head>
<title>œ˙ªŸπ‹¿Ì</title>
</head>
<frameset  name="content" rows="*" cols="180,*" framespacing="0" frameborder="NO" scrolling="YES" border="0">
  <frame src="/arm/ViewAllEntryTreeList.do?type=7" name="leftFrame" scrolling="YES" noresize>
  <frameset cols="20,*" frameborder="NO" border="0" framespacing="0">
    <frame src="/public/change.htm" name="leftFrame1" scrolling="NO" noresize>
    <frame src="rightmain.htm" name="main" id="main">
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
