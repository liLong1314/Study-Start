<%@ page contentType="text/html; charset=gb2312" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>�ļ���¼ҳ�棭ҵ����</title>
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
//�ı���ӱ�
function doChange(theform){
	var operName = theform.operName;
	operName.value="";
	theform.submit();
}
//�ύ
function doSubmit(theform){
        var operName = theform.operName;
        if(validateForm(theform)){
                operName.value="SUBMIT_ACTION";
                theform.submit();
        }
}
//��֤���Ϸ���
function validateForm(theform){
	//����֤���ӱ�
	if(!validateEform(theform)) return false;
	//��֤�����ı�Ԫ��
	//TODO HERE
	var phase_id = document.getElementById("archivesFile.phase_id");
	var up_phase_id = document.getElementById("archivesFile.up_phase_id");
	var file_title = document.getElementById("archivesFile.file_title");
	var file_id = document.getElementById("archivesFile.file_id");
	var file_duty = document.getElementById("archivesFile.file_duty");
	var file_date = document.getElementById("archivesFile.file_date");
	var file_page_amount = document.getElementById("archivesFile.file_page_amount");
	var page_num_from_to = document.getElementById("archivesFile.page_num_from_to");

	if((up_phase_id.value!="") && (parseInt(phase_id.value)<=parseInt(up_phase_id.value)))
		return BASEalert("��ѡ����ȷ��[��ǰ��Ŀ�׶�]��",phase_id);
        if(BASEtrim(file_title.value)=="")
		return BASEalert("��������ȷ��[�ļ�����]��",file_title);
        //if(BASEtrim(file_id.value)=="")
	//	return BASEalert("��������ȷ��[�ļ����]��",file_id);
        //if(BASEtrim(file_duty.value)=="")
	//	return BASEalert("��������ȷ��[������]��",file_duty);
        //if(BASEtrim(file_date.value)=="")
	//	return BASEalert("��������ȷ��[�ļ�����]��",file_date);
        if(BASEtrim(file_page_amount.value)!="" && BASEisNotNum(file_page_amount.value))
		return BASEalert("��������ȷ��[�ļ�ҳ��]��",file_page_amount);
        //if(BASEtrim(page_num_from_to.value)=="")
	//	return BASEalert("��������ȷ��[�ļ���ֹҳ��]��",page_num_from_to);
        return true;
}
//
function doListPhaseFile(theform){
	window.location="";
}
/*
function doSwitchEform(){
	var obj=document.all("eformX");
	if(obj.style.display=="none"){
		obj.style.display="block";
		this.value="���ص��ӱ���չ�ֶ�<<";
	}else{
		obj.style.display="none";
		this.value="��ʾ���ӱ���չ�ֶ�>>";
	}
}*/
</script>
</head>
<body class="bg-page01">
<html:form action="/adc/addArchivesFile.do" method="post">
  <html:hidden property="operName"/>
  <html:hidden property="archivesFile.archives_id"/>
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
      <td width="637" align="left" bgcolor="#FFFFFF">�����ڵ�λ�ã� &gt;&gt; �����ɼ� &gt;&gt;
        �ļ���¼(ҵ����)</td>
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
      <td width="4%"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="94%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif" bgcolor="#FFFFFF"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#99CC00">
                <tr>
                  <td align="center" bgcolor="#F2F9E6" class="tishi">�滮���������ļ���¼ҳ��</td>
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
		<logic:notEmpty name="ArchivesFileForm" property="msgError">
		<b><font color=red>�ܱ�Ǹ�������з������󣡵��<a href="#" style="color:blue" onclick="var obj=document.all('err');if(obj.style.display=='none') {obj.style.display='block'} else{obj.style.display='none'}">�˴�</a>�鿴��ϸ��Ϣ</font></b>
		<span id=err style="display:none"><bean:write name="ArchivesFileForm" property="msgError"/></span>
          	</logic:notEmpty>
            <td nowrap colspan=2>
		<html:select property="archivesFile.eform_id">
		<option value="">�����������ļ�����</option>
		<html:optionsCollection property="eform_idOptions"/>
		</html:select>
		<input type="button" name="ChangeEform" value="ȷ��" onclick="doChange(this.form);">
		<logic:notEmpty name="ArchivesFileForm" property="archivesFile.eform_id">
		<input type="button" value="��ʾ���ӱ���չ�ֶ�>>" onclick="var obj=document.all('eformX');if(obj.style.display=='none') {obj.style.display='block';this.value='���ص��ӱ���չ�ֶ�<<';} else{obj.style.display='none';this.value='��ʾ���ӱ���չ�ֶ�>>';}">
          	</logic:notEmpty>
            </td>
          </tr>
	</table>
	<span id="eformX" style="display:none">
	<table width="95%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
	  <logic:notEmpty name="ArchivesFileForm" property="eformFieldDefineList">
	  <logic:iterate id="eformFieldDefineItem" name="ArchivesFileForm" property="eformFieldDefineList">
          <tr bgcolor="#FFFFFF">
            <td nowrap>
		<bean:write name ="eformFieldDefineItem" property="field_cname"/>
            </td>
            <td nowrap colspan="3">
		<input type="hidden" name="field_id" value="<bean:write name ="eformFieldDefineItem" property="field_id"/>">
		<input type="hidden" name="field_cname" value="<bean:write name ="eformFieldDefineItem" property="field_cname"/>">
		<logic:lessThan name="eformFieldDefineItem" property="field_len" value="21">
		<input type="text" name="field_value"
			field_type_id="<bean:write name ="eformFieldDefineItem" property="field_type_id"/>"
			field_isEdit ="<bean:write name ="eformFieldDefineItem" property="field_isEdit"/>"
			size   	     ="20"
			maxlength    ="<bean:write name ="eformFieldDefineItem" property="field_len"/>"
			field_isNull ="<bean:write name ="eformFieldDefineItem" property="field_isNull"/>"
			value	     ="">
		</logic:lessThan>
		<logic:greaterEqual name="eformFieldDefineItem" property="field_len" value="21">
		<textarea name="field_value" cols="60" rows="2"
			field_type_id="<bean:write name ="eformFieldDefineItem" property="field_type_id"/>"
			field_isEdit ="<bean:write name ="eformFieldDefineItem" property="field_isEdit"/>"
			field_isNull ="<bean:write name ="eformFieldDefineItem" property="field_isNull"/>"></textarea>
		</logic:greaterEqual>
            </td>
          </tr>
	  </logic:iterate>
          </logic:notEmpty>
        </table>
	</span>
        <table width="95%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
          <tr bgcolor="#FFFFFF">
            <td colspan="4" nowrap><strong>����¼��Ϣ</strong></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>��Ŀ���<font color=red>*</font></td>
            <td colspan="3" nowrap><html:text property="archivesFile.proj_id" size="20" readonly="true"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>�����</td>
            <td colspan="3" nowrap><html:text property="archivesFile.accept_id" size="20"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>��ǰ��Ŀ�׶�<font color=red>*</font></td>
            <td colspan="3" nowrap>
		<html:select name="ArchivesFileForm" property="archivesFile.phase_id">
		<html:optionsCollection property="phase_idOptions"/>
		</html:select>
            </td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>�ϼ���Ŀ�׶�</td>
            <td colspan="3" nowrap>
		<html:select name="ArchivesFileForm" property="archivesFile.up_phase_id">
		<html:optionsCollection property="up_phase_idOptions"/>
		</html:select>
            </td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>�ļ����</td>
            <td colspan="3" nowrap><html:text property="archivesFile.file_seq" size="24" maxlength="20"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>�ļ�����<font color=red>*</font></td>
            <td colspan="3" nowrap><html:textarea property="archivesFile.file_title" cols="60" rows="2"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>�ļ����</td>
            <td nowrap><html:text property="archivesFile.file_num" size="24" maxlength="20"/> </td>
            <td nowrap>������</td>
            <td nowrap><html:text property="archivesFile.file_duty" size="24" maxlength="100"/> </td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>�ļ�����</td>
            <td nowrap><html:text property="archivesFile.file_date" size="24"/> </td>
            <td nowrap>�ļ�ҳ��</td>
            <td nowrap><html:text property="archivesFile.file_page_amount" size="10" maxlength="9"/> </td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>�ļ���ֹҳ��</td>
            <td nowrap colspan=3><html:text property="archivesFile.page_num_from_to" size="24"/> </td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>�ļ��ܼ�</td>
            <td nowrap>
		<html:select property="archivesFile.secret_id">
		<html:optionsCollection property="secret_idOptions"/>
		</html:select>
            </td>
            <td nowrap>��������</td>
            <td nowrap>
		<html:select property="archivesFile.file_store_term">
		<html:optionsCollection property="file_store_termOptions"/>
		</html:select>
            </td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>��������</td>
            <td nowrap> <html:select property="archivesFile.media_type"> <html:optionsCollection property="media_typeOptions"/> </html:select></td>
            <td nowrap>������</td>
            <td nowrap><html:select property="archivesFile.file_spec"> <html:optionsCollection property="file_specOptions"/> </html:select></td>
          </tr>
          <!--
          <tr bgcolor="#FFFFFF">
            <td nowrap>��������</td>
            <td colspan="3" nowrap><html:text property="archivesFile.file_pathName" size="50" maxlength="100"/></td>
          </tr>-->
          <tr bgcolor="#FFFFFF">
            <td nowrap>�ļ�����</td>
            <td nowrap><html:text property="archivesFile.file_count" size="10" maxlength="9"/></td>
            <td nowrap>�屾����</td>
            <td nowrap> <html:select property="archivesFile.file_type"> <html:optionsCollection property="file_typeOptions"/> </html:select></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>��ע</td>
            <td colspan="3" nowrap> <html:textarea property="archivesFile.remark" cols="60" rows="4"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td colspan="4" align="center" nowrap>
		<input type="button" name="Submit2" value="ȷ��" onclick="doSubmit(this.form);">
		<input type="reset" name="Submit3" value="ȡ��" onclick="window.history.go(-1)">
		<input type="button" name="Submit2" value="�鿴���׶��ļ��б�" onclick="window.location='/adc/viewArchivesFileListByPhaseId.do?ARCHIVES_ID=<bean:write name="ArchivesFileForm" property="archivesFile.archives_id"/>&PHASE_ID=<bean:write name="ArchivesFileForm" property="archivesFile.phase_id"/>'"></td>
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
