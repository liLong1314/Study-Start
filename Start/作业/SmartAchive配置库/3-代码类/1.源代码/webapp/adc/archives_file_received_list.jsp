<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>�ѽ����ļ�</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<script language="javascript" src="../common/js/base.js"></script>
<script language="javascript" src="../common/js/chkBoxOperation.js"></script>
<script language="JavaScript" type="text/JavaScript">
<!--
//��ѯ
function doQuery(theform){
	document.all("operName").value="QUERY";
	theform.submit();
}

//���
function doSubmit(theform){
	var operName = document.all("operName");
	if(!validateCheckBox(theform)){
		alert("��ѡ����Ҫ���в����ļ�¼");
		return false;
	}
	//operName.value="SUBMIT_ACTION";
	theform.submit();
}
//
function validateCheckBox(theform){
	var obj=document.getElementsByName("file_id");
	var isChecked = false;
	for(var i=0;i<obj.length;i++){
		if (obj[i].checked){
			isChecked=true;
			break;
		}
	}
	return isChecked;
}
-->
</script>
<style type="text/css">
<!--
body {
	background-image: url(../image/2_mainpagebg_01.gif);
}
-->
</style>
</head>
<body class="bg-page01">
<html:form action="/adc/viewReceivedFiles" method="post" >
  <html:hidden property="operName"/>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="32"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td colspan="3" background="../image/2_table_c_t.gif">&nbsp;</td>
      <td width="26"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td width="76" align="right" bgcolor="#FFFFFF"> <img src="../image/dot01.gif" width="8" height="8"><br>
      </td>
      <td width="10" align="center" bgcolor="#FFFFFF">&nbsp;</td>
      <td width="849" align="left" bgcolor="#FFFFFF"> �����ڵ�λ�ã� &gt;&gt; �����ɼ� &gt;&gt;
        ѡ���������ļ�</td>
      <td background="../image/2_table_c_l.gif">&nbsp;</td>
    </tr>
    <tr>
      <td><img src="../image/2_table_r_b.gif" width="32" height="20"></td>
      <td colspan="3" background="../image/2_table_c_b.gif"><img src="../image/2_table_c_b.gif" width="115" height="20"></td>
      <td><img src="../image/2_table_l_b.gif" width="26" height="20"></td>
    </tr>
  </table><table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="32"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="100%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#0293CA">
                <tr>

                <td align="center" bgcolor="#E4F7FA" class="tishi">�������ļ���ѯ����</td>
                </tr>
            </table></td>
          </tr>
      </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td align="center" bgcolor="#FFFFFF">
          <table width="100%" height="37" border="0">
            <tr>
            <td height="31">
              <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
                <tr bgcolor="#FFFFFF">
                  <td nowrap id="Mode1">�ļ����:</td>
                  <td nowrap id="Mode1">
			<html:text property="archivesFile.file_num" value="" size="12" maxlength="40"/>
                  </td>
                  <td nowrap id="Mode1">�ļ�����:</td>
                  <td nowrap id="Mode1">
			<html:text property="archivesFile.file_title" value="" size="20" maxlength="40"/>
                  </td>
                  <td align="center" nowrap colspan=3>&nbsp;</td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td nowrap id="Mode1">��Ŀ���:</td>
                  <td nowrap id="Mode1">
			<html:text property="archivesFile.proj_id" value="" size="12" maxlength="40"/>
                  </td>
                  <td nowrap id="Mode1">��Ŀ����:</td>
                  <td nowrap id="Mode1">
			<html:text property="archivesFile.proj_name" value="" size="20" maxlength="40"/>
                  </td>
                  <td nowrap id="Mode1">ÿҳ�г�:</td>
                  <td align="center" nowrap colspan=1>
			<input type="text" name="pageSize" value="10" size="4" maxlength=10>��
                  </td>
                  <td align="center" nowrap colspan=1>
			<input type="button" name="btnQry" value="��ѯ" onClick="doQuery(this.form)">
                  </td>
                </tr>
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
</html:form>
<html:form action="/adc/selectReceivedFiles" method="post" >
<html:hidden property="archivesFile.archives_id"/>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="4%"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="93%" background="../image/2_table_c_t.gif">
	<table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif" bgcolor="#FFFFFF"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#99CC00">
                <tr>
                  <td align="center" bgcolor="#F2F9E6" class="tishi">�ӽӿڿ���յ��ļ��б�</td>
                </tr>
              </table>
            </td>
          </tr>
        </table>
      </td>
      <td width="3%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td align="center" bgcolor="#FFFFFF"><br>
        <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#FFFFFF">
          <tr align="center" bgcolor="#F7EED9">
          <td bgcolor="#F7EED9"><input type="checkbox" onclick="if(this.checked)SelectAll(this.form,'file_id');else UnSelectAll(this.form,'file_id');">ѡ��</td>
          <td bgcolor="#F7EED9">��Ŀ���</td>
          <td bgcolor="#F7EED9">��Ŀ����</td>
          <td bgcolor="#F7EED9">�ļ����</td>
          <td bgcolor="#F7EED9">�ļ�����</td>
          <td bgcolor="#F7EED9">����</td>
        </tr>
	<logic:notPresent name="receivedArchivesFileList">
	<tr align="center" bgcolor="#F7EED9">
          <td colspan=6>���޼�¼</td>
        </tr>
	</logic:notPresent>
	<logic:present name="receivedArchivesFileList">
	<logic:iterate id="list" name="receivedArchivesFileList" >
        <tr align="center" bgcolor="#F7EED9">
          <td bgcolor="#F6F6F6">
		<input type="checkbox" name="file_id" value="<bean:write name="list" property="file_id" />">
          </td>
          <td bgcolor="#F6F6F6"><bean:write name="list" property="proj_id" /></td>
          <td bgcolor="#F6F6F6"><bean:write name="list" property="proj_name" /></td>
          <td bgcolor="#F6F6F6"><bean:write name="list" property="file_num" /></td>
          <td bgcolor="#F6F6F6"><bean:write name="list" property="file_title" /></td>
          <td bgcolor="#F6F6F6"><a href="/rcv/settleArchivesFileNavigator.do?file_id=<bean:write name="list" property="file_id" />">�鿴</a></td>
          </tr>
	</logic:iterate>
	</logic:present>
        </table>
        <logic:present name="receivedArchivesFileList">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td bgcolor="#F7EED9"> <logic:notEqual name="receivedArchivesFileList" property="firstPage" value="true" >
            <a href="?page=first">&lt;&lt;
            ��һҳ </a><a href="?page=previous">&lt;
            ��һҳ </a></logic:notEqual> <logic:notEqual name="receivedArchivesFileList" property="lastPage" value="true" >
            <a href="?page=next">��һҳ
            &gt; </a><a href="?page=last">���ҳ
            &gt;&gt; </a></logic:notEqual>&nbsp; ��<bean:write name="receivedArchivesFileList" property="rowAmount" />����¼&nbsp;
            ��ǰ��
            <input type="text" size="1" value="<bean:write name="receivedArchivesFileList" property="pageIndex" />" onChange="javascript:gotoPage(this.value)">
            /<bean:write name="receivedArchivesFileList" property="pageAmount" />
            ҳ&nbsp; ÿҳ<bean:write name="receivedArchivesFileList" property="pageSize" />��</td>
        </tr>
      </table>
      </logic:present>
      </td>
      <td background="../image/2_table_c_l.gif">&nbsp;</td>
    </tr>
    <tr>
      <td><img src="../image/2_table_r_b.gif" width="32" height="20"></td>
      <td background="../image/2_table_c_b.gif"><img src="../image/2_table_c_b.gif" width="115" height="20"></td>
      <td><img src="../image/2_table_l_b.gif" width="26" height="20"></td>
    </tr>
  </table>
<center>
<input name="Submit3" type="button" value="ѡ��" onClick="doSubmit(this.form);">
<input type="button" name="Submit2" value="����" onclick="window.history.go(-1);">
<input type="button" name="Submit2" value="��ӡ" onclick="window.print();">
</center>
</html:form>
</body>
</html>

