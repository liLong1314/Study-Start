<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>

<H3>出错!</H3>

<logic:present name="message">
  <B><bean:write name="message"/></B>
</logic:present>

<logic:notPresent name="message">
  <B></B>
</logic:notPresent>

<logic:notPresent name="ACCOUNT_INFORMATION">
  <B>连接超时，请重新登录！</B>
</logic:notPresent>

<logic:notPresent name="ACCOUNT_INFORMATION">
<script language="JavaScript">
alert("超时或者尚未登录，请重新登录");
if (top.location == self.location && opener) {
  opener.location.replace("/login.htm");
  self.close();
}
else {
  top.location.replace("/login.htm");
}
</script>
</logic:notPresent>