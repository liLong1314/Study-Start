<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="com.sunyard.hgam.util.adc.AdcUtil"%>
<%@ page import="java.util.List" %>

<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<title>�������</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
body {
	background-image: url(../image/2_mainpagebg_01.gif);
}
-->
</style>
<script src="/common/js/openWindow.js">
//�򿪴��ڵĴ���
</script>
<script src="/common/js/chkBoxOperation.js">
//��ѡ���������
</script>
</head>

<body class="bg-page01" onload="myLoad();" onUnLoad="myUnLoad();">
<script language="JavaScript" type="text/JavaScript">
<!--
function DeletePages(){
	if (confirm("��ȷ��ɾ����")){
		document.all.functionName.value = "DeletePage";
		document.CheckArchivesPageViewForm.submit();
	}
}

function myLoad() {
	if (document.all.functionName.value=='DeleteOK') {
		alert("ɾ���ɹ���");
	}
	if (document.all.functionName.value=='DeleteFailure') {
		alert("ɾ��ʧ�ܣ�");
	}
}

function myUnLoad() {
	//alert("close");
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

//-->
</script>

<html:form action="/adc/CheckArchivesPageView" method="post" >
<html:hidden property="functionName"/>
<html:hidden property="functionData"/>
<html:hidden property="archives.AARCHIVES_ID"/>

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
      <td width="637" align="left" bgcolor="#FFFFFF"> �����ڵ�λ�ã� ������� &gt;&gt; Ӱ��ҳ�б� &gt;&gt; </td>
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
                  <td align="center" bgcolor="#E4F2FA" class="tishi">����Ӱ��ҳ�б�</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr> 
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td align="center" bgcolor="#FFFFFF"><table width="100%"  border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
          <tr bgcolor="#FFFFFF"> 
            <td width="131%" nowrap><table width="100%"  border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
                <tr bgcolor="#FFFFFF"> 
                  <td width="6%" nowrap>����</td>
                  <td width="20%" nowrap><bean:write name="CheckArchivesPageViewForm" property="archives.AARCHIVES_NUM" /></td>
                  
                <td width="14%" nowrap>��������/������</td>
                  <td width="60%" ><bean:write name="CheckArchivesPageViewForm" property="archives.AARCHIVES_NAME" /></td>
                </tr>
              </table>
			</td>
          </tr>
          <tr align="center" bgcolor="#FFFFFF"> 
            <td height="16" nowrap> <input name="Submit3" type="button" onClick="openPageCheckUpdateWindow('/adc/check/CheckUpdatePageNum.jsp')" value="�޸�ҳ��"> 
              <input name="Submit32" type="button" onClick="openPageCheckUpdateWindow('/adc/check/CheckUpdateFileID.jsp')" value="�޸������ļ�">
              <input name="Submit332" type="button" onClick="openPageCheckUpdateWindow('/adc/check/CheckUpdatePageOperator.jsp')" value="����Ȩ��"> 
              <input name="Submit332" type="button" onClick="openPageCheckUpdateWindow('/adc/check/CheckUpdatePageSize.jsp')" value="����ҳ��"> 
              <input name="Submit333" type="button" onclick="openPageCheckUpdateWindow('/adc/check/CheckUpdateStatus.jsp')" value="����״̬"> 
              <input type="button" name="Submit334" value="ɾ��ҳ" onClick="DeletePages();"> </td>
          </tr>
        </table>
        <br> 
        <table width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
        <tr align="center" bgcolor="#F7EED9"> 
            
          <td width="10" align="center"> 
            <input type=checkbox onclick="if(this.checked)SelectAll(document.forms[0],'selectedPageID');else UnSelectAll(document.forms[0],'selectedPageID');">
          </td>
			<td>
		    	<table width="100%" border="0" cellpadding="2" cellspacing="1">
				<tr>
		            <td width="6%">ҳ��</td>
		            <td width="18%">�ļ����</td>
		            <td width="50">��������</td>
		            <td width="17%">��¼����</td>
		            <td width="10%">����Ȩ��</td>
		            <td width="10%">ҳ��</td>
		            <td width="16%">��������</td>
		            <td width="50">����״̬</td>
	            </tr>
	            </table>
	        </td>
          </tr>
	      <logic:present name="queryArchivesPage">
		  <logic:iterate id="listItem" name="queryArchivesPage" >
		  <tr>
          	<td width="10" align="center"><input type="checkbox" name="selectedPageID" value="<bean:write name='listItem' property='page_id'/>"></td>
            <td>
		    	<table width="100%" border="0" cellpadding="2" cellspacing="1">
	            <tr align="center" bgcolor="#f6f6f6" style='cursor:hand' 
			       	onMouseover="this.style.backgroundColor='#dff1ff'" 
			       	onMouseOut="this.style.backgroundColor='#f6f6f6'" 
			       	onclick="window.location='../adc/CheckArchivesPage.do?page_id=<bean:write name='listItem' property='page_id' />'">
		            <td width="6%"><bean:write name="listItem" property="page_num"/></td>
		            <td width="18%">
			            <bean:define id="fileID" name="listItem" property="file_id"/>
			            <%
			            	//����������idת���ɿɶ����ַ���
			            	out.print(AdcUtil.getArchivesFileCaptionByFileID((String)fileID));
			            %> 
		            </td>
		            <td width="50"><bean:write name="listItem" property="page_type"/></td>
		            <td width="17%"><bean:write name="listItem" property="page_date"/></td>
		            <td width="10%">
			            <bean:define id="pageOperate" name="listItem" property="page_operate"/>
			            <%
			            	//����������idת���ɿɶ����ַ���
			            	out.print(AdcUtil.getSysParamByTypeAndValue("PAGE_OPERATOR", (String)pageOperate));
			            %> 
		            </td>
		            <td width="10%">
			            <bean:define id="pageSize" name="listItem" property="page_size"/>
			            <%
			            	//����������idת���ɿɶ����ַ���
			            	out.print(AdcUtil.getSysParamByTypeAndValue("PAGE_SIZE", (String)pageSize));
			            %> 
		            </td>
		            <td width="16%">
			            <bean:write name="listItem" property="page_area"/>
		            </td>
		            <td width="50">
					    <bean:define id="pageStatus" name="listItem" property="page_status"/>
					    <% 
					    String strPageStatus = (String)pageStatus;
			            if(((strPageStatus).equalsIgnoreCase("PASS"))) {
			            	out.print("ͨ��");
			            }else if(((strPageStatus).equalsIgnoreCase("NOPASS"))){
			            	out.print("δͨ��");
			            }else {
			            	out.print("δͨ��");
			            }
			            %>
		            </td>
		        </tr>
		        </table>
		    </td>    
          </tr>
		  </logic:iterate>
			<logic:notEqual name="queryArchivesPage" property="firstPage" value="true" >
				<a href="?page=first">&lt;&lt; ��һҳ</a>
				<a href="?page=previous">&lt;&lt; ��һҳ</a>
			</logic:notEqual>
			<logic:notEqual name="queryArchivesPage" property="lastPage" value="true" >
				<a href="?page=next">��һҳ &gt;&gt;</a>
				<a href="?page=last">���ҳ &gt;&gt;</a>
			</logic:notEqual>
			����<bean:write name="queryArchivesPage" property="rowAmount" />����¼&nbsp;
			��Ϊ<bean:write name="queryArchivesPage" property="pageAmount" />ҳ&nbsp;
			ÿҳ<bean:write name="queryArchivesPage" property="pageSize" />��&nbsp; 
			��ǰ��<input type="text" size="1" value="<bean:write name="queryArchivesPage" property="pageIndex" />" onChange="javascript:gotoPage(this.value)" />ҳ
		  </logic:present>
        </table>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr> 
            <td align="center" bgcolor="#F7EED9"> 
              <input type="button" name="Submit22" value="��ӡ" onClick="window.print()">
              <input type="button" name="Submit222" value="����" onClick="window.location= '/adc/checkArchivesView.do'">
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
