<%@ page contentType="text/html; charset=gb2312" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>�ļ���Ϣ��ҵ����</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<script language="javascript" src="../common/js/base.js"></script>
<script language="javascript" src="../common/js/validateEform.js"></script>
<style type="text/css">
<!--
body {
	background-image: url(../image/2_mainpagebg_01.gif);
}
-->
</style>
<script>
function doViewFile(filePathName){
	window.open("/rcv/viewArchivesFileAccessory.do?filePathName=" + filePathName,"filewin","nomenu=1;notoolbar=1");
}
</script>
</head>
<body class="bg-page01">
<html:form action="/adc/updateArchivesFile.do" method="post">
  <html:hidden property="operName"/>
  <html:hidden property="archivesFile.file_id"/>
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
      <td width="637" align="left" bgcolor="#FFFFFF">�����ڵ�λ�ã� &gt;&gt; ������ѯ &gt;&gt;
        �ļ���Ϣ(ҵ����)</td>
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
                  <td align="center" bgcolor="#E4F2FA" class="tishi">�ļ�����ҳ��</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif"><img src="../image/2_table_c_r.gif" width="32" height="234"></td>
      <td align="center" bgcolor="#FFFFFF">
        <table width="95%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
          <tr align="center" bgcolor="#FFFFFF">
            <td nowrap colspan=2>
		<html:select property="archivesFile.eform_id" disabled="true">
		<option value="">�����������ļ�����</option>
		<html:optionsCollection property="eform_idOptions"/>
		</html:select>
		<logic:notEmpty name="ArchivesFileForm" property="archivesFile.eform_id">
		<input type="button" value="��ʾ���ӱ���չ�ֶ�>>" onclick="var obj=document.all('eformX');if(obj.style.display=='none') {obj.style.display='block';this.value='���ص��ӱ���չ�ֶ�<<';} else{obj.style.display='none';this.value='��ʾ���ӱ���չ�ֶ�>>';}">
          	</logic:notEmpty>
            </td>
          </tr>
	</table>
	<span id="eformX" style="display:none">
	<table width="95%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
          <logic:notEmpty name="ArchivesFileForm" property="eformFieldValueList">
	  <logic:iterate id="eformFieldValueItem" name="ArchivesFileForm" property="eformFieldValueList">
          <tr bgcolor="#FFFFFF">
            <td nowrap>
		<bean:write name ="eformFieldValueItem" property="field_cname"/>
            </td>
            <td nowrap>
		<bean:write name ="eformFieldValueItem" property="field_value"/>
            </td>
          </tr>
	  </logic:iterate>
          </logic:notEmpty>
        </table>
	</span>
        <table width="95%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
          <tr bgcolor="#FFFFFF">
            <td colspan="4" nowrap><strong>�ļ���¼��Ϣ</strong></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>��Ŀ���</td>
            <td colspan="3" nowrap><bean:write  name ="ArchivesFileForm" property="archivesFile.proj_id"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>�����</td>
            <td colspan="3" nowrap><bean:write  name ="ArchivesFileForm" property="archivesFile.accept_id"/></td>
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
            <td nowrap>�ļ����</td>
            <td colspan="3" nowrap><bean:write  name ="ArchivesFileForm" property="archivesFile.file_seq"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>�ļ�����</td>
            <td colspan="3" nowrap><bean:write  name ="ArchivesFileForm" property="archivesFile.file_title"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>�ļ����</td>
            <td nowrap><bean:write  name ="ArchivesFileForm" property="archivesFile.file_num"/></td>
            <td nowrap>������</td>
            <td nowrap><bean:write  name ="ArchivesFileForm" property="archivesFile.file_duty"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>�ļ�����</td>
            <td nowrap><bean:write  name ="ArchivesFileForm" property="archivesFile.file_date"/></td>
            <td nowrap>�ļ�ҳ��</td>
            <td nowrap><bean:write  name ="ArchivesFileForm" property="archivesFile.file_page_amount"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>�ļ���ֹҳ��</td>
            <td nowrap colspan=3><bean:write  name ="ArchivesFileForm" property="archivesFile.page_num_from_to"/></td>
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
            <td colspan="3" nowrap>
		<logic:notEmpty name="ArchivesFileForm" property="archivesFile.file_pathName">
		<input type="button" name="viewFile" value="�鿴�����ļ�"
			onclick="doViewFile('<bean:write name="ArchivesFileForm" property="archivesFile.file_pathName"/>')">
		</logic:notEmpty>
            </td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>�ļ�����</td>
            <td nowrap><bean:write  name ="ArchivesFileForm" property="archivesFile.file_count"/></td>
            <td nowrap>�屾����</td>
            <td nowrap> <html:select property="archivesFile.file_type" disabled="true"> <html:optionsCollection property="file_typeOptions"/> </html:select></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>��ע</td>
            <td colspan="3" nowrap><bean:write  name ="ArchivesFileForm" property="archivesFile.remark"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td colspan="4" align="center" nowrap>
		<input type="button" name="Submit2" value="��ӡ" onclick="window.print();">
		<input type="reset" name="Submit3" value="����" onclick="window.history.go(-1)">
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
</html:form>
</body>
</html>
