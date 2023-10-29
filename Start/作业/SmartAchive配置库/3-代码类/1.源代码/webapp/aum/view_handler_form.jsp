<%@ page contentType="text/html;charset=GBK" language="java"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<html>
<head>
<title>查阅管理</title>
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

  if (handlerCaption=="领导审批") {
    if(!isCheck("utilizeInfo.agree"))
      alert("请填写领导审批的处理意见！");
    else
      document.UtilizeInfoForm.submit();
  }
  else if (handlerCaption=="出库审核") {
    if(!isCheck("utilizeInfo.agreeOfRegistration"))
      alert("请填写出库的处理意见！");
    else
      document.UtilizeInfoForm.submit();
  }
  else if (handlerCaption=="入库审核") {
    if(!isCheck("utilizeInfo.agreeOfRestore"))
      alert("请填写入库的处理意见！");
    else
      document.UtilizeInfoForm.submit();
  }
  else if (handlerCaption=="反馈") {
    if(BASEtrim(feedbackIdea.value)=="")
      alert("请填写反馈信息！");
    else
      document.UtilizeInfoForm.submit();
  }
  else if (handlerCaption=="收费") {
    if(BASEtrim(realGetMoney.value)=="")
      alert("请填写实收金额！");
    else
      document.UtilizeInfoForm.submit();
  }
  else if (handlerCaption=="申请结束") {
      alert("借阅申请流程已经结束！");
  }
  else
    document.UtilizeInfoForm.submit();

  //MM_openBrWindow('view_handler_form.jsp','查阅管理','width=700,height=500')
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
                  <td align="center" bgcolor="#F2F9E6" class="tishi">查阅处理</td>
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
            <td nowrap>查阅者姓名</td>
            <td nowrap><bean:write name="utilInfo" property="personName" /></td>
            <td nowrap>查阅者单位</td>
            <td nowrap><bean:write name="utilInfo" property="personCorp" /></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>查阅方式</td>
            <td nowrap><bean:write name="utilInfo" property="modeName" /></td>
            </select></td>
            <td nowrap>查阅目的</td>
            <td nowrap><bean:write name="utilInfo" property="aim" /></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>查阅起始日期</td>
            <td nowrap><bean:write name="utilInfo" property="beginDate" /></td>
            <td nowrap>查阅期限</td>
            <td nowrap><bean:write name="utilInfo" property="utilizeTerm" /></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>是否为外部人员</td>
            <td nowrap>
              <input type="radio" name="radiobutton" value="radiobutton"
              <logic:equal name="utilInfo" property="external" value="1">checked</logic:equal> disabled>
                      是

              <input type="radio" name="radiobutton" value="radiobutton"
              <logic:equal name="utilInfo" property="external" value="0">checked</logic:equal> disabled>
                      否
            </td>
            <td nowrap>是否查阅本单位</td>
            <td nowrap>
              <input type="radio" name="radiobutton2" value="radiobutton2"
              <logic:equal name="utilInfo" property="self" value="1">checked</logic:equal> disabled>
                      是

              <input type="radio" name="radiobutton2" value="radiobutton2"
              <logic:equal name="utilInfo" property="self" value="0">checked</logic:equal> disabled>
                      否
            </td>
          </tr>

          <tr bgcolor="#FFFFFF">
            <td nowrap>应收金额</td>
            <td nowrap>
              <bean:write name="totalCharge" />
            </td>
            <td nowrap>实收金额</td>
            <td nowrap>
                <input type="text" name="utilizeInfo.realGetMoney" value="<bean:write name="utilInfo" property="realGetMoney" />">
            </td>
          </tr>

          <tr bgcolor="#FFFFFF">
            <td rowspan="2">审核意见</td>
            <td height="0" colspan="3" align="center">
              <input type="radio" name="utilizeInfo.agree" value="1"
                <logic:equal name="utilInfo" property="agree" value="1">checked</logic:equal>>同意
              <input type="radio" name="utilizeInfo.agree" value="0"
                <logic:equal name="utilInfo" property="agree" value="0">checked</logic:equal>>不同意
            </td>
          </td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td colspan="3" align="center">说明
                <input type="text" name="utilizeInfo.leadConfirmIdea" value="<bean:write name="utilInfo" property="leadConfirmIdea" />" size="55">
          </tr>
          <tr bgcolor="#FFFFFF">
            <td rowspan="2">出库意见</td>
            <td height="0" colspan="3" align="center"><p>
              <input type="radio" name="utilizeInfo.agreeOfRegistration" value="1"
                <logic:equal name="utilInfo" property="agreeOfRegistration" value="1">checked</logic:equal>>同意
              <input type="radio" name="utilizeInfo.agreeOfRegistration" value="0"
                <logic:equal name="utilInfo" property="agreeOfRegistration" value="0">checked</logic:equal>>不同意
              </p>
            </td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td colspan="3" align="center">说明
                <input type="text" name="utilizeInfo.registConfirmIdea" value="<bean:write name="utilInfo" property="registConfirmIdea" />" size="55">
            </td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td rowspan="2">入库意见</td>
            <td height="0" colspan="3" align="center"><p>
              <input type="radio" name="utilizeInfo.agreeOfRestore" value="1"
                <logic:equal name="utilInfo" property="agreeOfRestore" value="1">checked</logic:equal>>同意
              <input type="radio" name="utilizeInfo.agreeOfRestore" value="0"
                <logic:equal name="utilInfo" property="agreeOfRestore" value="0">checked</logic:equal>>不同意
              </p>
            </td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td colspan="3" align="center">说明
                <input type="text" name="utilizeInfo.restoreConfirmIdea" value="<bean:write name="utilInfo" property="restoreConfirmIdea" />" size="55">
            </td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td>利用效果反馈信息</td>
            <td colspan="3">
                <input type="text" name="utilizeInfo.feedbackIdea" value="<bean:write name="utilInfo" property="feedbackIdea" />" size="55">
            </td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td>档案列表明细</td>
            <td colspan="3"><a href="#" onClick="window.location='/aum/ViewUtilizeDetail.do?applyID=<bean:write  name="utilInfo" property="applyID" />&flag=1'">点击查看</a></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td>备注</td>
            <td colspan="3">
                <input type="text" name="utilizeInfo.remark" value="<bean:write name="utilInfo" property="remark" />" size="55">
            </td>
          </tr>
          <tr align="center" bgcolor="#FFFFFF">
            <td colspan="4">&nbsp;
            <logic:equal name="isHandler" value="0">
            <input type="button" name="handlerCaption" onclick="mySubmit()" value="<bean:write name="btnCaption" />">
            </logic:equal>
            <input type="button" name="Submit4" value="打印" onclick="window.print()">
            <input type="button" name="Submit4" value="关闭" onclick="window.location='/aum/ViewTaskList.do'"></td>
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