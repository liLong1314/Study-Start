<%@ page contentType="text/html;charset=GBK" language="java"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%
String archivesId=request.getSession().getAttribute("tmparchId").toString();
%>
<html:html>
<head>
<title>�����ۺϲ�ѯ-�鿴�ļ�</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<script language="javascript" src="../common/js/base.js"></script>
<style type="text/css">
<!--
body {
	background-image: url(../image/2_mainpagebg_01.gif);
}
-->
</style></head>
<body class="bg-page01">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="32"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td colspan="3" background="../image/2_table_c_t.gif">&nbsp;</td>
      <td width="39"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td width="50" align="right" bgcolor="#FFFFFF"> <img src="../image/dot01.gif" width="8" height="8"><br>
      </td>
      <td width="8" align="center" bgcolor="#FFFFFF">&nbsp;</td>
    <td width="620" align="left" bgcolor="#FFFFFF"> �����ڵ�λ�ã� <a href="/aum/ArchQuery.do">�����ۺϲ�ѯ</a>
      &gt;&gt; �����ļ�</td>
      <td background="../image/2_table_c_l.gif">&nbsp;</td>
    </tr>
    <tr>
      <td><img src="../image/2_table_r_b.gif" width="32" height="20"></td>
      <td colspan="3" background="../image/2_table_c_b.gif"><img src="../image/2_table_c_b.gif" width="115" height="20"></td>
      <td><img src="../image/2_table_l_b.gif" width="26" height="20"></td>
    </tr>
  </table>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="32"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="100%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#00A8CC">
                <tr>
                  <td align="center" bgcolor="#E4F2FA" class="tishi">�ļ���ѯ</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td align="center" bgcolor="#FFFFFF"> <br> <table width="100%" height="37" border="1">
          <tr>
            <td height="31">
              <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
		<html:form action="/aum/FileQuery.do" method="post">
                <tr bgcolor="#FFFFFF">
                <td width="20%" height="25" nowrap>�ļ����</td>
                  <td width="20%" nowrap>
                    <html:hidden property="fileOperInfo.archivesId" value="<%=archivesId%>"/>
                    <html:text property="fileOperInfo.fileNum" size="10"/>
                  </td>
                <td width="20%" nowrap>�ļ�����</td>
                  <td width="20%" nowrap>
                    <html:text property="fileOperInfo.fileDate" size="10"/>
                  </td>
                  <td rowspan="2" nowrap>
                    <input type="submit" name="Submit" value="��ѯ">
                  </td>
                </tr>
                <tr bgcolor="#FFFFFF">
                <td width="20%" height="25" nowrap>�ļ�����</td>
                  <td width="20%" nowrap>
                    <html:text property="fileOperInfo.fileTitle" size="15"/>
                  </td>
                <td width="20%" nowrap>������</td>
                  <td width="20%" nowrap>
                    <html:text property="fileOperInfo.fileDuty" size="10"/>
                  </td>
                </tr>
		</html:form>
              </table>
            </td>
          </tr>
        </table></td>
      <td background="../image/2_table_c_l.gif">&nbsp;</td>
    </tr>
    <tr>
      <td><img src="../image/2_table_r_b.gif" width="32" height="20"></td>
      <td background="../image/2_table_c_b.gif"><img src="../image/2_table_c_b.gif" width="115" height="20"></td>
      <td><img src="../image/2_table_l_b.gif" width="26" height="20"></td>
    </tr>
  </table>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="32"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="100%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#00A8CC">
                <tr>
                <td align="center" bgcolor="#E4F2FA" class="tishi">�����ļ�</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif"><img src="../image/2_table_c_r.gif" width="32" height="234"></td>
      <td align="center" bgcolor="#FFFFFF" valign="top">
    <logic:present name="FileOpers">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td bgcolor="#F7EED9"> <logic:notEqual name="FileOpers" property="firstPage" value="true" >
            <a href="/aum/FileQuery.do?page=first">&lt;&lt;
            ��һҳ </a><a href="/aum/FileQuery.do?page=previous">&lt;
            ��һҳ </a></logic:notEqual> <logic:notEqual name="FileOpers" property="lastPage" value="true" >
            <a href="/aum/FileQuery.do?page=next">��һҳ
            &gt; </a><a href="/aum/FileQuery.do?page=last">���ҳ
            &gt;&gt; </a></logic:notEqual>&nbsp; ��<bean:write name="FileOpers" property="rowAmount" />����¼&nbsp;
            ��ǰ��
            <input type="text" size="1" value="<bean:write name="FileOpers" property="pageIndex" />" onChange="javascript:PageTo(this)">
            /<bean:write name="FileOpers" property="pageAmount" />
            ҳ&nbsp; ÿҳ<bean:write name="FileOpers" property="pageSize" />��</td>
        </tr>
      </table>
      </logic:present>
      <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#FFFFFF">
        <tr align="center" bgcolor="#F7EED9">
          <td width="20%">�ļ����</td>
          <td width="20%">�ļ�����</td>
          <td width="20%">�ļ�����</td>
          <td width="20%">������</td>
          <td width="20%">����</td>
        </tr>
        <logic:present name="FileOpers">
	<logic:iterate id="fileOper" name="FileOpers">
        <tr align="center">
          <td bgcolor="#f6f6f6" width="20%"><bean:write name="fileOper" property="fileNum"/></td>
          <td bgcolor="#f6f6f6" width="20%"><bean:write name="fileOper" property="fileTitle"/></td>
          <td bgcolor="#f6f6f6" width="20%"><bean:write name="fileOper" property="fileDate"/></td>
          <td bgcolor="#f6f6f6" width="20%"><bean:write name="fileOper" property="fileDuty"/></td>
          <td bgcolor="#f6f6f6" width="20%"><a href="/aum/PageLook.do?fileId=<bean:write name="fileOper" property="fileId"/>">�鿴ҳ��</a></td>
        </tr>
        </logic:iterate>
	</logic:present>
      </table>
      </td>
      <td background="../image/2_table_c_l.gif"><img src="../image/2_table_c_l.gif" width="26" height="138"></td>
    </tr>
    <tr>
      <td><img src="../image/2_table_r_b.gif" width="32" height="20"></td>
      <td background="../image/2_table_c_b.gif"><img src="../image/2_table_c_b.gif" width="115" height="20"></td>
      <td><img src="../image/2_table_l_b.gif" width="26" height="20"></td>
    </tr>
  </table>
</body>
</html:html>
