<%@ page contentType="text/html;charset=GBK" language="java"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<html>
<head>
<title>���Ĺ���</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<script language="javascript" src="../common/js/base.js"></script>
<style type="text/css">
<!--
body {
	background-image: url('../image/2_mainpagebg_01.gif');
}
-->
</style>
<script language="JavaScript" type="text/JavaScript">
<!--
function MM_openBrWindow(theURL,winName,features) { //v2.0
  window.open(theURL,winName,features);
}

function mySubmit(){
  var handlerCaption=document.all.handlerCaption.value;
  var feedbackIdea = document.getElementById("utilizeInfo.feedbackIdea");
  var realGetMoney = document.getElementById("utilizeInfo.realGetMoney");

  if (handlerCaption=="�쵼����") {
    if(!isCheck("utilizeInfo.agree"))
      alert("����д�쵼�����Ĵ��������");
    else
      document.UtilizeInfoForm.submit();
  }
  else if (handlerCaption=="�������") {
    if(!isCheck("utilizeInfo.agreeOfRegistration"))
      alert("����д����Ĵ��������");
    else
      document.UtilizeInfoForm.submit();
  }
  else if (handlerCaption=="������") {
    if(!isCheck("utilizeInfo.agreeOfRestore"))
      alert("����д���Ĵ��������");
    else
      document.UtilizeInfoForm.submit();
  }
  else if (handlerCaption=="����") {
    if(BASEtrim(feedbackIdea.value)=="")
      alert("����д������Ϣ��");
    else
      document.UtilizeInfoForm.submit();
  }
  else if (handlerCaption=="�շ�") {
    if(BASEtrim(realGetMoney.value)=="")
      alert("����дʵ�ս�");
    else
      document.UtilizeInfoForm.submit();
  }
  else if (handlerCaption=="�������") {
      alert("�������������Ѿ�������");
  }
  else
    document.UtilizeInfoForm.submit();

  //MM_openBrWindow('view_handler_form.jsp','���Ĺ���','width=700,height=500')
}

function isCheck(optionName){
  var obj=document.getElementsByName(optionName);
  for(var i=0;i<obj.length;i++){
     if(obj[i].checked) return true;
  }
  return false;
}

//-->
</script>
</head>
<body class="bg-page01">
<script>
	function doChange(obj){
		window.location.href=obj.options[obj.selectedIndex].url;
	}
</script>

<html:form action="/aum/ViewCommitTask" method="post">
  <input type="hidden" name="utilizeInfo.applyID" value="<bean:write  name="utilInfo" property="applyID" />">
  <input type="hidden" name="utilizeInfo.utilizeStatus" value="<bean:write  name="utilInfo" property="utilizeStatus" />">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="4%"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="94%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif" bgcolor="#FFFFFF"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#99CC00">
                <tr>
                  <td align="center" bgcolor="#F2F9E6" class="tishi">���Ĵ���</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <logic:present name="utilInfo">
      <td background="../image/2_table_c_r.gif"><img src="../image/2_table_c_r.gif" width="32" height="234"></td>
      <td align="center" bgcolor="#FFFFFF"><br>
        <table width="95%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
          <tr bgcolor="#FFFFFF">
            <td nowrap>����������</td>
            <td nowrap><bean:write name="utilInfo" property="personName" /></td>
            <td nowrap>�����ߵ�λ</td>
            <td nowrap><bean:write name="utilInfo" property="personCorp" /></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>���ķ�ʽ</td>
            <td nowrap><bean:write name="utilInfo" property="modeName" /></td>
            </select></td>
            <td nowrap>����Ŀ��</td>
            <td nowrap><bean:write name="utilInfo" property="aim" /></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>������ʼ����</td>
            <td nowrap><bean:write name="utilInfo" property="beginDate" /></td>
            <td nowrap>��������</td>
            <td nowrap><bean:write name="utilInfo" property="utilizeTerm" /></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>�Ƿ�Ϊ�ⲿ��Ա</td>
            <td nowrap>
              <input type="radio" name="radiobutton" value="radiobutton"
              <logic:equal name="utilInfo" property="external" value="1">checked</logic:equal> disabled>
                      ��

              <input type="radio" name="radiobutton" value="radiobutton"
              <logic:equal name="utilInfo" property="external" value="0">checked</logic:equal> disabled>
                      ��
            </td>
            <td nowrap>�Ƿ���ı���λ</td>
            <td nowrap>
              <input type="radio" name="radiobutton2" value="radiobutton2"
              <logic:equal name="utilInfo" property="self" value="1">checked</logic:equal> disabled>
                      ��

              <input type="radio" name="radiobutton2" value="radiobutton2"
              <logic:equal name="utilInfo" property="self" value="0">checked</logic:equal> disabled>
                      ��
            </td>
          </tr>

          <tr bgcolor="#FFFFFF">
            <td nowrap>Ӧ�ս��</td>
            <td nowrap>
              <bean:write name="totalCharge" />
            </td>
            <td nowrap>ʵ�ս��</td>
            <td nowrap>
                <input type="text" name="utilizeInfo.realGetMoney" value="<bean:write name="utilInfo" property="realGetMoney" />">
            </td>
          </tr>

          <tr bgcolor="#FFFFFF">
            <td rowspan="2">������</td>
            <td height="0" colspan="3" align="center">
              <input type="radio" name="utilizeInfo.agree" value="1"
                <logic:equal name="utilInfo" property="agree" value="1">checked</logic:equal>>ͬ��
              <input type="radio" name="utilizeInfo.agree" value="0"
                <logic:equal name="utilInfo" property="agree" value="0">checked</logic:equal>>��ͬ��
            </td>
          </td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td colspan="3" align="center">˵��
                <input type="text" name="utilizeInfo.leadConfirmIdea" value="<bean:write name="utilInfo" property="leadConfirmIdea" />" size="55">
          </tr>
          <tr bgcolor="#FFFFFF">
            <td rowspan="2">�������</td>
            <td height="0" colspan="3" align="center"><p>
              <input type="radio" name="utilizeInfo.agreeOfRegistration" value="1"
                <logic:equal name="utilInfo" property="agreeOfRegistration" value="1">checked</logic:equal>>ͬ��
              <input type="radio" name="utilizeInfo.agreeOfRegistration" value="0"
                <logic:equal name="utilInfo" property="agreeOfRegistration" value="0">checked</logic:equal>>��ͬ��
              </p>
            </td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td colspan="3" align="center">˵��
                <input type="text" name="utilizeInfo.registConfirmIdea" value="<bean:write name="utilInfo" property="registConfirmIdea" />" size="55">
            </td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td rowspan="2">������</td>
            <td height="0" colspan="3" align="center"><p>
              <input type="radio" name="utilizeInfo.agreeOfRestore" value="1"
                <logic:equal name="utilInfo" property="agreeOfRestore" value="1">checked</logic:equal>>ͬ��
              <input type="radio" name="utilizeInfo.agreeOfRestore" value="0"
                <logic:equal name="utilInfo" property="agreeOfRestore" value="0">checked</logic:equal>>��ͬ��
              </p>
            </td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td colspan="3" align="center">˵��
                <input type="text" name="utilizeInfo.restoreConfirmIdea" value="<bean:write name="utilInfo" property="restoreConfirmIdea" />" size="55">
            </td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td>����Ч��������Ϣ</td>
            <td colspan="3">
                <input type="text" name="utilizeInfo.feedbackIdea" value="<bean:write name="utilInfo" property="feedbackIdea" />" size="55">
            </td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td>�����б���ϸ</td>
            <td colspan="3"><a href="#" onClick="window.location='/aum/ViewUtilizeDetail.do?applyID=<bean:write  name="utilInfo" property="applyID" />&flag=1'">����鿴</a></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td>��ע</td>
            <td colspan="3">
                <input type="text" name="utilizeInfo.remark" value="<bean:write name="utilInfo" property="remark" />" size="55">
            </td>
          </tr>
          <tr align="center" bgcolor="#FFFFFF">
            <td colspan="4">&nbsp;
            <logic:equal name="isHandler" value="0">
            <input type="button" name="handlerCaption" onclick="mySubmit()" value="<bean:write name="btnCaption" />">
            </logic:equal>
            <input type="button" name="Submit4" value="��ӡ" onclick="window.print()">
            <input type="button" name="Submit4" value="�ر�" onclick="window.location='/aum/ViewTaskList.do'"></td>
          </tr>
        </table>
        <br>
      </td>
      <td background="../image/2_table_c_l.gif"><img src="../image/2_table_c_l.gif" width="26" height="138"></td>
      </logic:present>
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