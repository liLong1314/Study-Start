<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>

<H3>����!</H3>

<logic:present name="message">
  <B><bean:write name="message"/></B>
</logic:present>

<logic:notPresent name="message">
  <B></B>
</logic:notPresent>

<logic:notPresent name="ACCOUNT_INFORMATION">
  <B>���ӳ�ʱ�������µ�¼��</B>
</logic:notPresent>

<logic:notPresent name="ACCOUNT_INFORMATION">
<script language="JavaScript">
alert("��ʱ������δ��¼�������µ�¼");
if (top.location == self.location && opener) {
  opener.location.replace("/login.htm");
  self.close();
}
else {
  top.location.replace("/login.htm");
}
</script>
</logic:notPresent>