<%@ page contentType="text/html;charset=GBK" language="java"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>

<html:html>
<head>
<title>��������</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<script language="javascript" src="../common/js/base.js"></script>
<style type="text/css">
<!--
body {
	background-image: url(../image/2_mainpagebg_01.gif);
}
-->
<script>
	function doChange(obj){
		window.location.href=obj.options[obj.selectedIndex].url;
	}
        function gotoPage(pageIndex) {
  location = "?page=" + pageIndex;
}
</script>
</style></head>
<body class="bg-page01">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="32"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td colspan="3" background="../image/2_table_c_t.gif">&nbsp;</td>
      <td width="26"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td width="51" align="right" bgcolor="#FFFFFF"> <img src="../image/dot01.gif" width="8" height="8"><br>
      </td>
      <td width="8" align="center" bgcolor="#FFFFFF">&nbsp;</td>

    <td width="653" align="left" bgcolor="#FFFFFF"> �����ڵ�λ�ã���������</td>
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
                  <td align="center" bgcolor="#E4F2FA" class="tishi">�����ѯ</td>
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
		<html:form action="/arm/ArchSearch.do?flag=2" method="post">
                <tr bgcolor="#FFFFFF">
                  <td width="20%" height="25" nowrap>����</td>
                  <td width="20%" nowrap>
                    <html:text property="archOperInfo.archivesNum" size="10"/>
                  </td>
                  <td width="20%" nowrap>�������</td>
                  <td width="20%" nowrap>
                    <html:text property="archOperInfo.archivesYear" size="10"/>
                  </td>
                  <td rowspan="2" nowrap>
                    <input type="submit" name="Submit" value="��ѯ">
                  </td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td width="20%" height="25" nowrap>��������</td>
                  <td width="20%" nowrap>
                    <html:text property="archOperInfo.archivesName" size="15"/>
                  </td>
                  <td width="20%" nowrap>��������</td>
                  <td width="20%" nowrap>
		<html:select property="archOperInfo.storeTerm">
		<html:option value="">--ȫ��--</html:option>
		<html:option value="F">����</html:option>
		<html:option value="L">����</html:option>
		<html:option value="S">����</html:option>
		</html:select>
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
                  <td align="center" bgcolor="#E4F2FA" class="tishi">����������Ϣ</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif"><img src="../image/2_table_c_r.gif" width="32" height="234"></td>
      <td align="center" bgcolor="#FFFFFF" valign="top">
        <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#FFFFFF">
          <tr align="center" bgcolor="#F7EED9">
            <td>����</td>
            <td>��������</td>
            <td>�������</td>
            <td>��������</td>
            <td>����</td>
          </tr>
          <logic:present name="ArchOpers">
          <logic:iterate id="archOper" name="ArchOpers">
          <tr align="center">
            <td bgcolor="#f6f6f6"><bean:write name="archOper" property="archivesNum"/></td>
           <td bgcolor="#f6f6f6" ><a href="/aum/viewArchives.do?flag=2&ARCHIVES_ID=<bean:write name="archOper" property="archivesId"/>"><bean:write name="archOper" property="archivesName"/></a></td>
            <td bgcolor="#f6f6f6"><bean:write name="archOper" property="archivesYear"/></td>
            <td bgcolor="#f6f6f6"><bean:write name="archOper" property="storeTerm"/></td>
            <td bgcolor="#f6f6f6"><a href="/arm/FileView.do?flag=2&archiveId=<bean:write name="archOper" property="archivesId"/>">�鿴�����ļ�</a></td>
          </tr>
          </logic:iterate>
          <logic:notEqual name="ArchOpers" property="firstPage" value="true" >
				<a href="?page=first">&lt;&lt; ��һҳ</a>
				<a href="?page=previous">&lt;&lt; ��һҳ</a>
			</logic:notEqual>
			<logic:notEqual name="ArchOpers" property="lastPage" value="true" >
				<a href="?page=next">��һҳ &gt;&gt;</a>
				<a href="?page=last">���ҳ &gt;&gt;</a>
			</logic:notEqual>
			����<bean:write name="ArchOpers" property="rowAmount" />����¼&nbsp;
            ��ǰ��
            <input type="text" size="1" value="<bean:write name="ArchOpers" property="pageIndex" />" onChange="javascript:PageTo(this)">
			��Ϊ<bean:write name="ArchOpers" property="pageAmount" />ҳ&nbsp;
			ÿҳ<bean:write name="ArchOpers" property="pageSize" />��&nbsp;

          </logic:present>
        </table>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td bgcolor="#F7EED9" align="right">
            <input name="Submit" type="button" onclick="window.location='/arm/FileIdentStat.do'"value="����ͳ��">
            </td>
          </tr>
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
