<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="com.sunyard.hgam.util.aum.AumUtil"%>
<%@ page import="com.sunyard.hgam.util.adc.AdcUtil"%>

<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>�������б�</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
body {
	background-image: url(../image/2_mainpagebg_01.gif);
}
-->
</style>
<script src="/common/js/chkBoxOperation.js">
//��ѡ���������
</script>
</head>
<script language="javascript">
<!--
function addCharge(){
	document.all.functionName.value = "insert";
	document.ChargeStandardForm.submit();
}

function deleteCharge() {
	document.all.functionName.value = "delete";
	document.ChargeStandardForm.submit();
}

function doDelete(form){
        if (!validateCheckBox(form)){
          alert("��ѡ��Ҫɾ�����ļ���");
        }else
	  form.submit();
}

function validateCheckBox(theform){
	var obj=document.getElementsByName("utilizePerson.person_id");
	var isChecked = -1;
	for(var i=0;i<obj.length;i++){
		if (obj[i].checked){
			isChecked=i;break;
		}
	}
	return isChecked;
}

function isCheck(optionName){
  var obj=document.getElementsByName(optionName);
  for(var i=0;i<obj.length;i++){
     if(obj[i].checked) return true;
  }
  return false;
}

function doSubmit(form) {

  var obj1=document.getElementsByName("utilizePerson.person_id");
  var obj2=document.getElementsByName("person_name");
  var obj3=document.getElementsByName("person_corp");
  var obj4=document.getElementsByName("utilizeInfo.personID");
  var obj5=document.getElementsByName("utilizeInfo.personName");
  var obj6=document.getElementsByName("utilizeInfo.personCorp");
  var i=validateCheckBox(form);

  if (i==-1)
    alert("��ѡ�������ˣ�");
  else {
    obj4[0].value=obj1[i].value;
    obj5[0].value=obj2[i].value;
    obj6[0].value=obj3[i].value;
    form.submit();
  }
}


function doSomething(flag){
  var obj=document.getElementsByName("utilizePerson.person_id");
  var i=validateCheckBox(this.form);
  if(flag==1){
    if(i==-1)
      alert("��ѡ��һ��Ҫ�༭�������ߣ�");
    else
      window.location.href="/aum/ShowUtilizePersonFormForEdit.do?personID="+obj[i].value;
  }
  else if(flag==2){
    if(i==-1)
      alert("��ѡ��һ��Ҫɾ���������ߣ�");
    else
      window.location.href="/aum/DeleteUtilizePerson.do?personID="+obj[i].value;
  }
}


-->
</script>
<body class="bg-page01">

<table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="4%"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="94%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif" bgcolor="#FFFFFF"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#99CC00">
                <tr>
                  <td align="center" bgcolor="#F2F9E6" class="tishi">�������б�</td>
                </tr></table>
              <table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#99CC00"><tr></tr>
              </table></td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>

    <td background="../image/2_table_c_r.gif">&nbsp;</td>
  <html:form action="/aum/ViewNewApplyForm?showFlag=1" method="post" >
    <html:hidden property="utilizeInfo.personID" value=""/>
    <html:hidden property="utilizeInfo.personName" value=""/>
    <html:hidden property="utilizeInfo.personCorp" value=""/>
    <td align="center" bgcolor="#FFFFFF"> <br>
    <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#FFFFFF">
        <tr align="center" bgcolor="#F7EED9">
          <td nowrap>ѡ��</td>
          <td nowrap>����</td>
          <td nowrap>��λ</td>
          <td nowrap>�绰</td>
          <td nowrap>��ַ</td>
          <td nowrap>֤������</td>
          <td nowrap>֤����</td>
        </tr>
        <logic:present name="personListForPaging">
        <logic:iterate id="item" name="personListForPaging" >
        <tr align="center">
          <td bgcolor="#f6f6f6">
            <input type="radio" name="utilizePerson.person_id" value="<bean:write name="item" property="person_id"/>">
          </td>
          <td bgcolor="#f6f6f6">
            <bean:write name="item" property="person_name"/>
            <input type="hidden" name="person_name" value="<bean:write name="item" property="person_name"/>">
          </td>
          <td bgcolor="#f6f6f6">
            <input type="hidden" name="person_corp" value="<bean:write name="item" property="person_corp"/>">
            <bean:write name="item" property="person_corp"/></td>
          <td bgcolor="#f6f6f6">
            <bean:write name="item" property="person_tel"/></td>
          <td bgcolor="#f6f6f6">
            <bean:write name="item" property="person_address"/></td>
          <td bgcolor="#f6f6f6">
            <bean:write name="item" property="certificate_type"/></td>
          <td bgcolor="#f6f6f6">
            <bean:write name="item" property="certificate_num"/></td>
        </tr>
        </logic:iterate>
        </logic:present>
      </table>
        <logic:present name="pagingHelper">
        <input type="hidden" name="pageAmount" value="<bean:write name="pagingHelper" property="pageAmount" />"/>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td bgcolor="#F7EED9">
            <logic:equal name="pagingHelper" property="firstPage" value="0" >
              <a href="/aum/ShowAllUtilizePerson.do?pagingFlag=first&pageIndex=<bean:write name="pagingHelper" property="pageIndex" />">&lt;&lt;
              ��һҳ </a><a href="/aum/ShowAllUtilizePerson.do?pagingFlag=previous&pageIndex=<bean:write name="pagingHelper" property="pageIndex" />">&lt;
              ��һҳ </a>
            </logic:equal>
            <logic:equal name="pagingHelper" property="lastPage" value="0" >
              <a href="/aum/ShowAllUtilizePerson.do?pagingFlag=next&pageIndex=<bean:write name="pagingHelper" property="pageIndex" />">��һҳ
              &gt; </a><a href="/aum/ShowAllUtilizePerson.do?pagingFlag=last&pageIndex=<bean:write name="pagingHelper" property="pageIndex" />">���ҳ
              &gt;&gt; </a>
            </logic:equal>
              &nbsp; ��<bean:write name="pagingHelper" property="amountOfObject" />����¼&nbsp;
              ��ǰ��
              <input type="text" name="pageIndex" size="1" value="<bean:write name="pagingHelper" property="pageIndex" />" onChange="javascript:gotoPage(this)">
              /<bean:write name="pagingHelper" property="pageAmount" />
              ҳ&nbsp; ÿҳ<bean:write name="pagingHelper" property="pageSize" />��</td>
          </tr>
        </table>
        </logic:present>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td colspan="4" bgcolor="#F7EED9">
            	<input type="button" name="Submit1" value="ѡ��" onclick="doSubmit(this.form)">
                <input type="button" name="Submit3" value="����" onclick="window.location.href='/aum/ShowUtilizePersonForm.do'">
                <input type="button" name="Submit4" value="�޸�" onclick="doSomething(1)">
                <input type="button" name="Submit5" value="ɾ��" onclick="doSomething(2)">
            	<input type="button" name="Submit2" value="ȡ��" onclick="window.location='/aum/ViewNewApplyForm.do'">
            </td>
          </tr>
        </table>
      </td>
    </html:form>
    <td background="../image/2_table_c_l.gif">&nbsp;</td>
    </tr>
    <tr>
      <td><img src="../image/2_table_r_b.gif" width="32" height="20"></td>
      <td background="../image/2_table_c_b.gif"><img src="../image/2_table_c_b.gif" width="115" height="20"></td>
      <td><img src="../image/2_table_l_b.gif" width="26" height="20"></td>
    </tr>
  </table>
</body>
</html>
