<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>�ļ���Ϣ</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<script language="javascript" src="../common/js/base.js"></script>
<style type="text/css">
<!--
body {
	background-image: url(../image/2_mainpagebg_01.gif);
}
-->
</style>
<script>
</script>
</head>
<body class="bg-page01">
<html:form action="/rcv/viewIfaceArchivesFile.do" method="post">
  <html:hidden property="operName"/>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="32"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td colspan="3" background="../image/2_table_c_t.gif">&nbsp;</td>
      <td width="26"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td width="50" align="right" bgcolor="#FFFFFF"> <img src="../image/dot01.gif" width="8" height="8">
      </td>
      <td width="8" align="center" bgcolor="#FFFFFF">&nbsp;</td>
      <td width="637" align="left" bgcolor="#FFFFFF">�����ڵ�λ�ã� &gt;&gt; �����ļ� &gt;&gt;
        �ļ���Ϣ</td>
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
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#0293CA">
                <tr>
                  <td align="center" bgcolor="#E4F7FA" class="tishi">�滮���������ļ���¼ҳ��</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr align="center" bgcolor="#FFFFFF">
            <td nowrap colspan=3>
		<html:select property="archivesFile.eform_id" disabled="true">
		<option value="">�����������ļ�����</option>
		<html:optionsCollection property="eform_idOptions"/>
		</html:select>
            </td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif"><img src="../image/2_table_c_r.gif" width="32" height="234"></td>
      <td align="center" bgcolor="#FFFFFF">
        <table width="95%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
	  <logic:notEmpty name="ArchivesFileForm" property="eformFieldValueList">
	  <logic:iterate id="eformFieldValueItem" name="ArchivesFileForm" property="eformFieldValueList">
          <tr bgcolor="#FFFFFF">
            <td nowrap>
		<bean:write name ="eformFieldValueItem" property="field_cname"/>
            </td>
            <td nowrap colspan="3">
		<input type="hidden" name="field_id" value="<bean:write name ="eformFieldValueItem" property="field_id"/>">
		<input type="hidden" name="field_cname" value="<bean:write name ="eformFieldValueItem" property="field_cname"/>">
		<logic:lessThan name="eformFieldValueItem" property="field_len" value="21">
		<input type="text" name="field_value" disabled
			field_type_id="<bean:write name ="eformFieldValueItem" property="field_type_id"/>"
			field_isEdit ="<bean:write name ="eformFieldValueItem" property="field_isEdit"/>"
			size   	     ="20"
			maxlength    ="<bean:write name ="eformFieldValueItem" property="field_len"/>"
			field_isNull ="<bean:write name ="eformFieldValueItem" property="field_isNull"/>"
			value	     ="<bean:write name ="eformFieldValueItem" property="field_value"/>">
		</logic:lessThan>
		<logic:greaterEqual name="eformFieldValueItem" property="field_len" value="21">
		<textarea name="field_value" cols="60" rows="2" disabled
			field_type_id="<bean:write name ="eformFieldValueItem" property="field_type_id"/>"
			field_isEdit ="<bean:write name ="eformFieldValueItem" property="field_isEdit"/>"
			field_isNull ="<bean:write name ="eformFieldValueItem" property="field_isNull"/>"><bean:write name ="eformFieldValueItem" property="field_value"/></textarea>
		</logic:greaterEqual>
            </td>
          </tr>
	  </logic:iterate>
          </logic:notEmpty>

        </table>
        <table width="95%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
          <tr bgcolor="#FFFFFF">
            <td colspan="4" nowrap><strong>����Ϣ</strong></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>��Ŀ���</td>
            <td colspan="3" nowrap><html:text property="archivesFile.proj_id" size="20" readonly="true" disabled="true"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>��ǰ��Ŀ�׶�</td>
            <td colspan="3" nowrap>
		<html:select name="ArchivesFileForm" property="archivesFile.phase_id" disabled="true">
		<html:optionsCollection property="phase_idOptions"/>
		</html:select>
            </td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>�ϼ���Ŀ�׶�</td>
            <td colspan="3" nowrap>
		<html:select name="ArchivesFileForm" property="archivesFile.up_phase_id" disabled="true">
		<html:optionsCollection property="up_phase_idOptions"/>
		</html:select>
            </td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>�ļ�����</td>
            <td colspan="3" nowrap><html:text property="archivesFile.file_title" size="50" maxlength="200" disabled="true"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>�ļ����</td>
            <td nowrap><html:text property="archivesFile.file_id" size="24" maxlength="20" disabled="true"/> </td>
            <td nowrap>������</td>
            <td nowrap><html:text property="archivesFile.file_duty" size="24" maxlength="100" disabled="true"/> </td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>�ļ�����</td>
            <td nowrap><html:text property="archivesFile.file_date" size="24" disabled="true"/> </td>
            <td nowrap>�ļ�ҳ��</td>
            <td nowrap><html:text property="archivesFile.file_page_amount" size="10" maxlength="9" disabled="true"/> </td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>�ļ��ܼ�</td>
            <td nowrap>
		<html:select property="archivesFile.secret_id" disabled="true">
		<html:optionsCollection property="secret_idOptions"/>
		</html:select>
            </td>
            <td nowrap>��������</td>
            <td nowrap>
		<html:select property="archivesFile.file_store_term" disabled="true">
		<html:optionsCollection property="file_store_termOptions"/>
		</html:select>
            </td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>��������</td>
            <td nowrap> <html:select property="archivesFile.media_type" disabled="true"> <html:optionsCollection property="media_typeOptions"/> </html:select></td>
            <td nowrap>������</td>
            <td nowrap><html:select property="archivesFile.file_spec" disabled="true"> <html:optionsCollection property="file_specOptions"/> </html:select></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>��������</td>
            <td colspan="3" nowrap><html:text property="archivesFile.file_pathName" size="50" maxlength="100" disabled="true"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>�ļ�����</td>
            <td nowrap><html:text property="archivesFile.file_count" size="10" maxlength="9" disabled="true"/></td>
            <td nowrap>�屾����</td>
            <td nowrap> <html:select property="archivesFile.file_type" disabled="true"> <html:optionsCollection property="file_typeOptions"/> </html:select></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>��ע</td>
            <td colspan="3" nowrap> <html:textarea property="archivesFile.remark" cols="60" rows="4" disabled="true"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td colspan="4" align="center" nowrap>
		<input type="button" name="Submit2" value="��ӡ" onclick="window.print();">
		<input type="reset" name="Submit3" value="����" onclick="window.location='/rcv/receive_file_query.jsp'"></td>
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
</html:form>
</body>
</html>
