<%@ page contentType="text/html;charset=GBK" language="java"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<html>
<head>
<title>�����ֵ����</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
body {
	background-image: url(../image/2_mainpagebg_01.gif);
}
-->
</style></head>
<script>
function doConfirm(){
	if(confirm("��ȷ��ɾ����"))
	{

	}
}
function gotoPage(pageIndex) {
	location = "?page=" + pageIndex;
}
</script>
<body class="bg-page01">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="32"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="100%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#0293CA">
                <tr>
                  <td align="center" bgcolor="#E4F7FA" class="tishi">����ʹ����ѯ</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="3%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td align="center" bgcolor="#FFFFFF">
	    <html:form method="post" action="/smm/searchTheme.do">
		<html:hidden property="search" value="true"/>
	    <table width="100%" border="0">
          <tr bgcolor="#f6f6f6">
            <td>�������</td>
            <td><html:text property="themeInfo.themeName" size="12"/></td>
            <td>����ʴ���</td>
            <td><html:text property="themeInfo.themeCode" size="12"/></td>
            <td>�������Ϣ</td>
            <td><html:text property="themeInfo.themeMessage" size="12"/></td>
            <td align="center"><input type="submit" name="Submit" value="��ѯ"></td>
          </tr>
        </table>
		</html:form>
        <br>
      </td>
      <td background="../image/2_table_c_l.gif">&nbsp;</td>
    </tr>
    <tr>
      <td><img src="../image/2_table_r_b.gif" width="32" height="20"></td>
      <td background="../image/2_table_c_b.gif">&nbsp;</td>
      <td><img src="../image/2_table_l_b.gif" width="26" height="20"></td>
    </tr>
  </table>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="32"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="100%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#0293CA">
                <tr>
                  <td align="center" bgcolor="#E4F7FA" class="tishi">�������Ϣ�б�</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="3%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td align="center" bgcolor="#FFFFFF">
	  <logic:present name="Themes"> 
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr> 
          <td bgcolor="#F7EED9"> 
			<logic:notEqual name="Themes" property="firstPage" value="true" > 
              <a href="?page=first">&lt;&lt; ��һҳ</a> <a href="?page=previous">&lt; ��һҳ</a> 
            </logic:notEqual> 
			<logic:notEqual name="Themes" property="lastPage" value="true" > 
              <a href="?page=next">��һҳ &gt;</a> <a href="?page=last">���ҳ &gt;&gt;</a> 
            </logic:notEqual>&nbsp; 
			��<bean:write name="Themes" property="rowAmount" />����¼&nbsp; 
            ��ǰ��<input name="text" type="text" onChange="javascript:gotoPage(this.value)" size="3" value="<bean:write name="Themes" property="pageIndex"/>" > /<bean:write name="Themes" property="pageAmount" /> ҳ&nbsp; 
			ÿҳ<bean:write name="Themes" property="pageSize" />��
		  </td>
        </tr>
      </table>
      </logic:present>
        <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#FFFFFF">
          <tr align="center" bgcolor="#F7EED9">
            <td>���</td>
            <td>�������</td>
            <td>�������Ϣ</td>
            <td>����ʴ���</td>
            <td>��ע</td>
            <td width="13%" bgcolor="#F7EED9">����</td>
          </tr>
          <logic:present name="Themes">
          <logic:iterate id="theme" name="Themes" >
          <tr align="center">
            <td bgcolor="#f6f6f6"><bean:write name="theme" property="themeId"/></td>
            <td bgcolor="#f6f6f6"><bean:write name="theme" property="themeName"/></td>
            <td bgcolor="#f6f6f6"><bean:write name="theme" property="themeMessage"/></td>
            <td bgcolor="#f6f6f6"><bean:write name="theme" property="themeCode"/></td>
            <td bgcolor="#f6f6f6"><bean:write name="theme" property="remark"/></td>
            <td bgcolor="#f6f6f6"><a href="/smm/thememodview.do?themeId=<bean:write name="theme" property="themeId"/>"> �޸�</a> <a href="/smm/ThemeDel.do?themeId=<bean:write name="theme" property="themeId"/>"> ɾ��</a></td>
          </tr>
	  </logic:iterate>
          </logic:present>
        </table>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="36%" bgcolor="#F7EED9">&nbsp;</td>
            <td width="9%" bgcolor="#F7EED9"><input type="button" name="Submit"onclick="window.location='themeadd.jsp'" value="���������"></td>
          </tr>
        </table>
       </td>
      <td background="../image/2_table_c_l.gif">&nbsp;</td>
    </tr>
    <tr>
      <td><img src="../image/2_table_r_b.gif" width="32" height="20"></td>
      <td background="../image/2_table_c_b.gif"><img src="../image/2_table_c_b.gif" width="115" height="20"></td>
      <td><img src="../image/2_table_l_b.gif" width="26" height="20"></td>
    </tr>
  </table>
</body>
<html>
