<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<html>
<head>
<title>�������ļ��б�</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<script language="javascript" src="../common/js/base.js"></script>
<style type="text/css">
<!--
body {
	background-image: url(../image/2_mainpagebg_01.gif);
}
-->
</style>
<script language="JavaScript" type="text/JavaScript">
function addArchivesFile(ARCHIVES_ID){
	window.location.href="addArchivesFile.do?ARCHIVES_ID="+ARCHIVES_ID;
}
</script>
</head>
<body class="bg-page01">
<html:form action="/adc/addArchivesFile" method="post" >
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="32"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td colspan="3" background="../image/2_table_c_t.gif">&nbsp;</td>
      <td width="26"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td width="50" align="right" bgcolor="#FFFFFF"> <img src="../image/dot01.gif" width="8" height="8"><br>
      </td>
      <td width="8" align="center" bgcolor="#FFFFFF">&nbsp;</td>
      <td width="637" align="left" bgcolor="#FFFFFF">�����ڵ�λ�ã�&gt;&gt; �����ɼ� &gt;&gt; ������Ϣ(������)</td>
      <td background="../image/2_table_c_l.gif">&nbsp;</td>
    </tr>
    <tr>
      <td><img src="../image/2_table_r_b.gif" width="32" height="20"></td>
      <td colspan="3" background="../image/2_table_c_b.gif"><img src="../image/2_table_c_b.gif" width="115" height="20"></td>
      <td><img src="../image/2_table_l_b.gif" width="26" height="20"></td>
    </tr>
  </table>

  <table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td width="4%"><img src="../image/2_table_l_t.gif" width="32"></td>
      <td width="100%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif"><img src="../image/dot01.gif" width="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#00A8CC">
                <tr>
                  <td align="center" bgcolor="#E4F2FA" class="tishi">������Ϣ[������]</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td align="center" bgcolor="#FFFFFF">
	<table width="100%"  border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
          <tr bgcolor="#FFFFFF">
            <td width="18%"nowrap>����</td>
            <td nowrap colspan="3"><bean:write  name ="ArchivesFileForm" property="archives.AARCHIVES_NUM"/></td>
    	  </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>����/������</td>
            <td colspan="3" nowrap><bean:write  name ="ArchivesFileForm" property="archives.AARCHIVES_NAME"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>������λ</td>
            <td nowrap><bean:write  name ="ArchivesFileForm" property="archives.AARCHIVES_FOUND_UNIT"/></td>
            <td nowrap width="18%">�ļ���ֹ����</td>
            <td nowrap><bean:write  name ="ArchivesFileForm" property="archives.ABEGIN_DATE"/>-<bean:write  name ="ArchivesFileForm" property="archives.AEND_DATE"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>�ܼ�</td>
            <td nowrap><bean:write  name ="ArchivesFileForm" property="archives.ASECRET_ID"/></td>
            <td nowrap>��������</td>
            <td nowrap><bean:write  name ="ArchivesFileForm" property="archives.ASTORE_TERM"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>ҳ��</td>
            <td nowrap><bean:write  name ="ArchivesFileForm" property="archives.APAGE_AMOUNT"/></td>
            <td nowrap>�������</td>
            <td nowrap><bean:write  name ="ArchivesFileForm" property="archives.AARCHIVES_YEAR"/></td>
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
                  <td align="center" bgcolor="#E4F2FA" class="tishi">�����ļ��б�</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td align="center" bgcolor="#FFFFFF"><br>

        <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#FFFFFF">
          <tr align="center" bgcolor="#F7EED9">
            <td nowrap>�ļ����</td>
            <td nowrap>�ļ����</td>
            <td nowrap>�ļ�����</td>
            <td nowrap>������</td>
            <td nowrap>�ļ�����</td>
            <td nowrap>ҳ��</td>
          </tr>

          <logic:present name="archivesFilesList">
	  <logic:iterate id="archivesListItem" name="archivesFilesList" >
          <tr align="center" bgcolor="#f6f6f6" style='cursor:hand'
			  onMouseover="this.style.backgroundColor='#dff1ff'"
			  onMouseOut="this.style.backgroundColor='#f6f6f6'"
			  onclick="window.location='/adc/viewArchivesFile.do?file_id=<bean:write name="archivesListItem" property="file_id"/>' ">
            <td><bean:write name="archivesListItem" property="file_seq"/></td>
            <td><bean:write name="archivesListItem" property="file_num"/></td>
            <td><bean:write name="archivesListItem" property="file_title"/></td>
            <td><bean:write name="archivesListItem" property="file_duty"/></td>
            <td><bean:write name="archivesListItem" property="file_date"/></td>
            <td><bean:write name="archivesListItem" property="file_page_amount"/></td>
          </tr>
	  </logic:iterate>
          </logic:present>
        </table>

      <logic:present name="archivesFilesList">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td bgcolor="#F7EED9"> <logic:notEqual name="archivesFilesList" property="firstPage" value="true" >
            <a href="?page=first">&lt;&lt;
            ��һҳ </a><a href="?page=previous">&lt;
            ��һҳ </a></logic:notEqual> <logic:notEqual name="archivesFilesList" property="lastPage" value="true" >
            <a href="?page=next">��һҳ
            &gt; </a><a href="?page=last">���ҳ
            &gt;&gt; </a></logic:notEqual>&nbsp; ��<bean:write name="archivesFilesList" property="rowAmount" />����¼&nbsp;
            ��ǰ��
            <input type="text" size="1" value="<bean:write name="archivesFilesList" property="pageIndex" />" onChange="javascript:PageTo(this)">
            /<bean:write name="archivesFilesList" property="pageAmount" />
            ҳ&nbsp; ÿҳ<bean:write name="archivesFilesList" property="pageSize" />��</td>
        </tr>
      </table>
      </logic:present>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td align="center" bgcolor="#F7EED9">
              <logic:notEqual name="ISOPERATION" value="1">
              <input type="button" name="Submit3" value="��¼���ļ�" onClick="addArchivesFile('<bean:write  name ="ArchivesFileForm" property="archives.AARCHIVES_ID"/>');">
              </logic:notEqual>
              <input type="button" name="Submit4" value="����" onClick="window.history.go(-1)">
              <input type="button" name="Submit5" value="��ӡ" onClick="window.print()">
              <input type="button" name="Submit2" value="ѡ���ѽ����ļ�" onClick="window.location='/adc/viewReceivedFiles.do?ARCHIVES_ID=<bean:write name="ArchivesFileForm" property="archives.AARCHIVES_ID"/>'">
              <input type="button" name="Submit8" value="��ӡ���ڱ�����" onClick="window.location='/adc/print_roll_beikao_wenshu.jsp?archives_id=<bean:write name="ArchivesFileForm" property="archives.AARCHIVES_ID"/>'">
              <input type="button" name="Submit10" value="��ӡ��ǩ" onClick="window.location='/adc/print_roll_biaoqian.jsp?archives_id=<bean:write name="ArchivesFileForm" property="archives.AARCHIVES_ID"/>'">
              <logic:present name="ROLL_MODE">
              <logic:equal name="ROLL_MODE" value="1">
              <input type="button" name="Submit1" value="��¼�°���" onClick="window.location='/adc/inputRollNavigator.do'">
              <input type="button" name="Submit6" value="��ӡ����Ŀ¼" onClick="window.location='/adc/print_roll_catalog.jsp?archives_id=<bean:write name="ArchivesFileForm" property="archives.AARCHIVES_ID"/>'">
              <input type="button" name="Submit9" value="��ӡ�������" onClick="window.location='/adc/print_roll_face_wenshujuan.jsp?archives_id=<bean:write name="ArchivesFileForm" property="archives.AARCHIVES_ID"/>'">
              </logic:equal>
              <logic:notEqual name="ROLL_MODE" value="1">
              <input type="button" name="Submit2" value="��¼�¼�" onClick="window.location='/adc/inputPieceNavigator.do'">
              <input type="button" name="Submit7" value="��ӡ����Ŀ¼" onClick="window.location='/adc/print_roll_catalog_jian.jsp?archives_id=<bean:write name="ArchivesFileForm" property="archives.AARCHIVES_ID"/>'">
              </logic:notEqual>
              </logic:present>
            </td>
          </tr>
        </table>
        <br> </td>
      <td background="../image/2_table_c_l.gif">&nbsp;</td>
    </tr>
    <tr>
      <td><img src="../image/2_table_r_b.gif" width="32" height="20"></td>
      <td background="../image/2_table_c_b.gif"><img src="../image/2_table_c_b.gif" width="115" height="20"></td>
      <td><img src="../image/2_table_l_b.gif" width="26" height="20"></td>
    </tr>
  </table>
</html:form>
</body>
</html>
