<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="com.sunyard.hgam.util.adc.AdcUtil"%>

<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<title>�������-��ѯ����</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
body {
	background-image: url(../image/2_mainpagebg_01.gif);
}
-->
</style></head>

<body class="bg-page01" onload="myLoad();">

<script language="JavaScript" type="text/JavaScript">
<!--
//���ù�������
function setFunctionName(functionName){
	document.all.functionName.value=functionName;
}

function myLoad() {
	//document.all.btnQryPiece.disabled = true;
	//document.all.btnQryRoll.disabled = true;
	//var mode  = document.all.roll_mode.value;
	//chooseRollMode(mode);
	chooseRollMode();
}

function chooseRollMode() {
	var mode  = document.all("archives.AROLL_MODE");
	var span1 = document.all("Mode1");
	var span2 = document.all("Mode2");
	var iMode;
	for(var i=0;i<mode.length;i++){
		//alert(mode[i].checked);
		if (mode[i].checked) iMode = mode[i].value;
	}
	
	//alert(iMode);
	if(iMode == "1" || iMode==null){
		//alert("�����ѯ");
		for(var i=0;i<span1.length;i++){
			span1[i].style.display="block";
		}
		for(var i=0;i<span2.length;i++){
			span2[i].style.display="none";
		}
	}else {//if(iMode == "2"){
		//alert("������ѯ");
		for(var i=0;i<span2.length;i++){
			span2[i].style.display="block";
		}
		for(var i=0;i<span1.length;i++){
			span1[i].style.display="none";
		}
	}
}

function getCheckedValues(frm,hidden){
var str = '';
var delimeter = ',';
var counter = 0;
for(var i=0;i<frm.elements.length;i++){
 if((frm.elements[i].type=="checkbox") && (frm.elements[i].checked)){
   if(counter==0){str += frm.elements[i].value;}
   else{str += delimeter + frm.elements[i].value;}
   counter++;
 }
}
if(counter!=0){
  hidden.value = str;
}
}

function setCheckBoxes(frm,flag){
for(var i=0;i<frm.elements.length;i++){
 if(frm.elements[i].type=="checkbox"){
   frm.elements[i].checked = flag;
 }
}
}


function TryStrToInt(strInt) {
	var ivalueLength = strInt.length;

	for(var i = 0; i != ivalueLength; i++) {
		var aChar = strInt.substring(i,i+1);
		if(aChar<"0" || aChar>"9") {
			return false;
		}
	}
	return true;
}

function gotoPage(pageIndex) {
	if (TryStrToInt(pageIndex)==false){
		alert("��������ȷ��ҳ�룡(" + pageIndex + ")");
		return;
	}
  location = "?page=" + pageIndex;
}

-->
</script>

<html:form action="/adc/checkArchivesView" method="post" >
<html:hidden property="functionName"/>

  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="32"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="100%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#00A8CC">
                <tr>
                  <td align="center" bgcolor="#E4F2FA" class="tishi">������ѯ</td>
                </tr>
            </table></td>
          </tr>
      </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td align="center" bgcolor="#FFFFFF"> <br>
          <table width="100%" height="37" border="1">
            <tr>

            <td height="31"> <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
                <tr bgcolor="#FFFFFF">
                  <td><table><tr>
                  <td>
                    <html:radio property="archives.AROLL_MODE" value="1" onclick="chooseRollMode();"/>�����ѯ
                    <html:radio property="archives.AROLL_MODE" value="2" onclick="chooseRollMode();" />������ѯ
                  </td>
                  </tr></table></td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td><table><tr>
                  <td width="50" nowrap>����:</td>
                  <td width="130" nowrap><html:text property="archives.AARCHIVES_NUM" size="10" maxlength="50" style="width:100" /></td>
                  </tr></table></td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td><table><tr>
                  <td width="50" nowrap id="Mode1">Ŀ¼��:</td>
                  <td width="25%" nowrap id="Mode1"><html:text property="archives.ACATALOG_NUM" size="10" maxlength="9" style="width:100%" /></td>
                  <td width="10%" nowrap id="Mode1">�����:</td>
                  <td width="25%" nowrap id="Mode1"><html:text property="archives.AROLL_NUM" size="10" maxlength="9" style="width:100%" /></td>
                  <td width="10%" nowrap id="Mode1">��������:</td>

                  <td width="50" nowrap id="Mode2">����:</td>
                  <td width="30%" nowrap id="Mode2"><html:text property="archives.APIECE_NUM" size="10" maxlength="9" style="width:100%" /></td>
                  <td width="10%" nowrap id="Mode2">������:</td>

                  <td width="50%" nowrap colspan=3 ><html:text property="archives.AARCHIVES_NAME" size="40" maxlength="100" style="width:100%" /></td>
                  <td colspan=2 align="center" nowrap> <input type="submit" name="btnQry" value="��ѯ" onClick="setFunctionName('QUERYARCHIVES')"></td>
                  </tr></table></td>
                </tr>
              </table></td>
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
                  <td align="center" bgcolor="#E4F2FA" class="tishi">δ�鵵�����б�</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="4%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif"><img src="../image/2_table_c_r.gif" width="32" height="24"></td>

    <td align="center" bgcolor="#FFFFFF"><br>
        <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#FFFFFF">
        <tr align="center" bgcolor="#F7EED9">
<!--          <td>���</td>  -->
          <td>����</td>
          <td>��������</td>
          <td>�������</td>
          <td>��������</td>
        </tr>

	     <logic:present name="queryArchivesRoll">
		<logic:iterate id="archivesListItem" name="queryArchivesRoll" >
        <tr align="center" bgcolor="#f6f6f6" style='cursor:hand' 
        	onMouseover="this.style.backgroundColor='#dff1ff'" 
        	onMouseOut="this.style.backgroundColor='#f6f6f6'" 
        	onclick="window.location='../adc/CheckArchivesPageView.do?archives_id=<bean:write name='archivesListItem' property='AARCHIVES_ID' />'">
<!--          <td><bean:write name="archivesListItem" property="AARCHIVES_ID" /></td>-->
          <td><bean:write name="archivesListItem" property="AARCHIVES_NUM" /></td>
          <td><bean:write name="archivesListItem" property="AARCHIVES_NAME" /></td>
          <td><bean:write name="archivesListItem" property="AARCHIVES_YEAR" /></td>
          <td>
				    <bean:define id="store_term" name="archivesListItem" property="ASTORE_TERM"/>
						<%
							out.print(AdcUtil.getSysParamByTypeAndValue("ArchiveStore", (String)store_term));
						%>
					</td>
        </tr>
		</logic:iterate>

		<logic:notEqual name="queryArchivesRoll" property="firstPage" value="true" >
			<a href="?page=first">&lt;&lt; ��һҳ</a>
			<a href="?page=previous">&lt;&lt; ��һҳ</a>
		</logic:notEqual>
		<logic:notEqual name="queryArchivesRoll" property="lastPage" value="true" >
			<a href="?page=next">��һҳ &gt;&gt;</a>
			<a href="?page=last">���ҳ &gt;&gt;</a>
		</logic:notEqual>
		����<bean:write name="queryArchivesRoll" property="rowAmount" />����¼&nbsp;
		��Ϊ<bean:write name="queryArchivesRoll" property="pageAmount" />ҳ&nbsp;
		ÿҳ<bean:write name="queryArchivesRoll" property="pageSize" />��&nbsp;
		��ǰ��<input type="text" size="1" value="<bean:write name="queryArchivesRoll" property="pageIndex" />" onChange="javascript:gotoPage(this.value)" />ҳ

		</logic:present>
      </table>

      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td align="center" bgcolor="#F7EED9">&nbsp; </td>
        </tr>
        <tr>
          <td align="center" bgcolor="#F7EED9"> <p>
              <input type="button" name="Submit3" value="��ӡ" onclick="window.print()">
            </p></td>
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
