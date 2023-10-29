<%@ page contentType="text/html;charset=GBK" language="java"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>

<html:html>
<head>
<title>销毁管理-查看文件</title>
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
function doSubmit(theform){
	var obj=document.forms[0];
        if(validateForm(obj)){
           if (!validateCheckBox(theform))
           {
              alert("请选择销毁文件!");
              return false;
           }
           return true;
        }
	return false;
      }


function validateForm(theform){
	var destroyOperator = document.getElementById("destroyInfo.destroyOperator");
	var destroyDate = document.getElementById("destroyInfo.destroyDate");

        if(BASEtrim(destroyOperator.value)=="")
        	return BASEalert("请输入正确的[销毁人]！",destroyOperator);
        if(BASEtrim(destroyDate.value)!="" && BASEisNotDate(destroyDate.value))
        	return BASEalert("请输入正确的[销毁日期]！",destroyDate);
	return true;
	}

function validateCheckBox(theform){
	var obj=document.getElementsByName("destroyInfo.filelist");
	var isChecked = false;
	fileId = "";
	for(var i=0;i<obj.length;i++){
		if (obj[i].checked){
			isChecked=true;
			//fileId += obj[i].value + ",";
		}
	}
	return isChecked;
	}
</script>
</head>
<body class="bg-page01">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="32"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td colspan="3" background="../image/2_table_c_t.gif">&nbsp;</td>
      <td width="39"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td width="50" align="right" bgcolor="#FFFFFF"> <img src="../image/dot01.gif" width="8" height="8"><br>
      </td>
      <td width="8" align="center" bgcolor="#FFFFFF">&nbsp;</td>

    <td width="620" align="left" bgcolor="#FFFFFF"> 您现在的位置：<a href="/arm/ArchView.do?flag=3">销毁管理</a> &gt;&gt; 档案文件</td>
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
                  <td align="center" bgcolor="#F2F9E6" class="tishi">档案文件销毁</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif"><img src="../image/2_table_c_r.gif" width="32" height="234"></td>
      <td align="center" bgcolor="#FFFFFF" valign="top">
	<html:form action="/arm/FileDestroy.do" method="post" onsubmit="return doSubmit(this.form);">
        <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#FFFFFF">
          <tr align="center" bgcolor="#F7EED9">
            <td width="20%">选择框</td>
            <td width="20%">文件编号</td>
            <td width="20%">文件题名</td>
            <td width="20%">文件日期</td>
            <td width="20%">责任者</td>
          </tr>
          <logic:present name="FileOpers">
          <logic:iterate id="fileOper" name="FileOpers">
          <tr align="center">
            <td bgcolor="#f6f6f6" width="20%">
            <input type="checkbox" name="destroyInfo.filelist" value="<bean:write name="fileOper" property="fileId"/>">
            </td>
            <td bgcolor="#f6f6f6" width="20%"><bean:write name="fileOper" property="fileNum"/></td>
            <td bgcolor="#f6f6f6" width="20%"><bean:write name="fileOper" property="fileTitle"/></td>
            <td bgcolor="#f6f6f6" width="20%"><bean:write name="fileOper" property="fileDate"/></td>
            <td bgcolor="#f6f6f6" width="20%"><bean:write name="fileOper" property="fileDuty"/></td>
          </tr>
          </logic:iterate>
          </logic:present>
        </table>
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="20%" bgcolor="#F7EED9">销毁人<font color="#FF0000">*</font>：</td>
          <td width="30%" bgcolor="#F7EED9">
          <html:hidden property="destroyInfo.isDestroy" value="1"/>
          <html:text property="destroyInfo.destroyOperator" size="10"/>
          </td>
          <td width="20%" bgcolor="#F7EED9">监督人：</td>
          <td width="30%" bgcolor="#F7EED9"> <html:text property="destroyInfo.destroySupervisor" size="10"/>
          </td>
        </tr>
        <tr>
          <td width="20%" bgcolor="#F7EED9">销毁情况：</td>
          <td width="30%" bgcolor="#F7EED9"> <html:text property="destroyInfo.destroySituation" size="15"/>
          </td>
          <td width="20%" bgcolor="#F7EED9">销毁时间(YYYY-MM-DD)：</td>
          <td width="30%" bgcolor="#F7EED9"> <html:text property="destroyInfo.destroyDate" size="10"/>
          </td>
        </tr>
        <tr>
          <td width="20%" bgcolor="#F7EED9">销毁地点：</td>
          <td width="30%" bgcolor="#F7EED9"><html:text property="destroyInfo.destroyPlace" size="20"/>
          </td>
          <td width="20%" bgcolor="#F7EED9">说明：</td>
          <td width="30%" bgcolor="#F7EED9"><html:text property="destroyInfo.remark" size="20"/></td>
        </tr>
        <tr>
          <td colspan="4" bgcolor="#F7EED9" align="center">
            <input type="submit" name="Submit" value="销毁">
          </td>
        </tr>
      </table>
      </html:form>
      </td>
      <td background="../image/2_table_c_l.gif"><img src="../image/2_table_c_l.gif" width="26" height="138"></td>
    </tr>
    <tr>
      <td><img src="../image/2_table_r_b.gif" width="32" height="20"></td>
      <td background="../image/2_table_c_b.gif"><img src="../image/2_table_c_b.gif" width="115" height="20"></td>
      <td><img src="../image/2_table_l_b.gif" width="26" height="20"></td>
    </tr>
  </table>
</body>
</html:html>
