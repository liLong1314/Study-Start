<%@ page contentType="text/html; charset=gb2312" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<html>
<head>
<title>�����б�</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<script language="javascript" src="../common/js/base.js"></script>
<style type="text/css">
<!--
body {
	background-image: url(../image/2_mainpagebg_01.gif);
}
.style1 {font-size: 14px}
-->
</style>
<script language="JavaScript" type="text/JavaScript">
<!--
function doIt(ARCHIVES_ID){
	window.location.href="/aum/viewArchivesFilesList.do?ARCHIVES_ID=" + ARCHIVES_ID;
}
-->
</script>
</head>
<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="4%"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="94%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif" bgcolor="#FFFFFF"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#99CC00">
                <tr>
                  <td align="center" bgcolor="#F2F9E6" class="tishi">����������Ϣ</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif"><img src="../image/2_table_c_r.gif" width="32" height="234"></td>
      <td align="center" bgcolor="#FFFFFF" valign="top">
    <logic:present name="QueryArchs">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td bgcolor="#F7EED9"> <logic:notEqual name="QueryArchs" property="firstPage" value="true" >
            <a href="?page=first">&lt;&lt;
            ��һҳ </a><a href="?page=previous">&lt;
            ��һҳ </a></logic:notEqual> <logic:notEqual name="QueryArchs" property="lastPage" value="true" >
            <a href="?page=next">��һҳ
            &gt; </a><a href="?page=last">���ҳ
            &gt;&gt; </a></logic:notEqual>&nbsp; ��<bean:write name="QueryArchs" property="rowAmount" />����¼&nbsp;
            ��ǰ��
            <input type="text" size="1" value="<bean:write name="QueryArchs" property="pageIndex" />" onChange="javascript:PageTo(this)">
            /<bean:write name="QueryArchs" property="pageAmount" />
            ҳ&nbsp; ÿҳ<bean:write name="QueryArchs" property="pageSize" />��</td>
        </tr>
      </table>
      </logic:present>
      <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#FFFFFF">
        <tr align="center" bgcolor="#F7EED9">
          <td nowrap>����</td>
          <td nowrap>��������</td>
          <td nowrap>�������</td>
          <td nowrap>�鿴�����ļ�</td>
        </tr>
        <logic:present name="QueryArchs">
	<logic:iterate id="archOper" name="QueryArchs">
        <tr align="center">
          <td bgcolor="#f6f6f6" nowrap><bean:write name="archOper" property="archivesNum"/></td>
          <td bgcolor="#f6f6f6" ><a href="/aum/viewArchives.do?ARCHIVES_ID=<bean:write name="archOper" property="archivesId"/>"><bean:write name="archOper" property="archivesName"/></a></td>
          <td bgcolor="#f6f6f6" nowrap><bean:write name="archOper" property="archivesYear"/></td>
          <td bgcolor="#f6f6f6"
		style="cursor:hand;color:blue"
		title="�鿴�����ļ�"
		onclick="doIt('<bean:write name="archOper" property="archivesId"/>');"
		>GO</td>
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
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td align="center">
              <input type="button" name="Submit3" value="��ӡ" onclick="window.print()">
              <input type="button" name="Submit4" onclick="window.location='/aum/queryArchivesNavigator.do'"value="����">
          </td>
        </tr>
      </table>
</body>
</html>
