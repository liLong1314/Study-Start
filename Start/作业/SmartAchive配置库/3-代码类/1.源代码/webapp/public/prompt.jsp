<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>

<H3>����!</H3>

<logic:present name="message">
  <B><bean:write name="message"/></B>
</logic:present>

<logic:notPresent name="message">
  <B>δ�ṩ�������Ϣ��</B>
</logic:notPresent>