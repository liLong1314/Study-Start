<%@ page contentType="text/html;charset=GBK" language="java"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<html>
<head>
<title>�����Ŀ¼��</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
body {
	background-image: url(../image/2_mainpagebg_01.gif);
}
-->
</style></head>
<body class="bg-page01">
<script>
function doChange(obj){
	window.location.href=obj.options[obj.selectedIndex].url;
}
function gotoPage(pageIndex) {
	location = "?page=" + pageIndex;
}
function doGoto(cataId){
	window.location.href="buildingCataLogView.do?cataId="+cataId;
}
</script>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="33"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td colspan="3" background="../image/2_table_c_t.gif">&nbsp;</td>
      <td width="26"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td width="52" align="right" bgcolor="#FFFFFF"> <img src="../image/dot01.gif" width="8" height="8"><br>
      </td>
      <td width="8" align="center" bgcolor="#FFFFFF">&nbsp;</td>
      <td width="667" align="left" bgcolor="#FFFFFF"> �����ڵ�λ�ã� &gt;&gt; �������� &gt;&gt;
        ȫ�ڹ��� &gt;&gt; Ŀ¼�����</td>
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
                  <td align="center" bgcolor="#F2F9E6" class="tishi">��ʷĿ¼�����</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td align="center" bgcolor="#FFFFFF"> <br>
        <table width="95%" border="1">
         <html:form action="/arm/queryOtherCataLogList.do" method="post">
          <tr>
            <td height="39"> <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
                <tr align="center" bgcolor="#FFFFFF">
                  <td width="19%" align="left"><select name=selParent onchange="doChange(this);">
                      <option selected value="1" url="/arm/viewAllotherCataLog.do" >�����Ŀ¼��</option>
                      <option value="2"url="viewAllbuildingCataLog.do" >��������Ŀ¼��</option>

                    </select></td>
                  <td width="10%" align="left" nowrap>��λ����</td>
                  <td width="13%" align="left" nowrap>
<html:text property="otherCataLogInfo.cataUnit" size="8"/></td>
                  <td width="11%" align="left" nowrap>������Ŀ</td>
                  <td width="12%" align="left" nowrap>
<html:text property="otherCataLogInfo.cataItem" size="8"/></td>
                  <td width="7%" align="left" nowrap>֤��</td>
                  <td width="13%" align="left" nowrap>
<html:text property="otherCataLogInfo.cataCardNum" size="8"/></td>
                  <td width="15%"><input type="Submit" name="Submit" value="��ѯ"></td>
                </tr>
                </html:form>
              </table></td>
          </tr>
        </table>

      </td>
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
      <td width="4%"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="94%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif" bgcolor="#FFFFFF"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#99CC00">
                <tr>
                  <td align="center" bgcolor="#F2F9E6" class="tishi">�����Ŀ¼����Ϣ</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif"><img src="../image/2_table_c_r.gif" width="32" height="234"></td>
      <td align="center" valign="top"  bgcolor="#FFFFFF"><br>
        <table width="100%" height="0" border="0" cellpadding="2" cellspacing="1" bgcolor="#FFFFFF">
          <tr align="center"   bgcolor="#F7EED9">
            <td width="7%">����</td>
            <td width="7%" bgcolor="#F7EED9">���</td>
            <td width="7%" bgcolor="#F7EED9">��λ����</td>
            <td width="7%" bgcolor="#F7EED9">�⽨�ص�</td>
            <td width="7%" bgcolor="#F7EED9">������Ŀ</td>
            <td width="7%" bgcolor="#F7EED9">�н���λ</td>
            <td width="7%" bgcolor="#F7EED9">��</td>
            <td width="7%" bgcolor="#F7EED9">����</td>
            <td width="7%" bgcolor="#F7EED9">��֤����</td>
            <td width="7%" bgcolor="#F7EED9">֤��</td>
            <td width="7%" bgcolor="#F7EED9">������</td>
            <td width="7%">���</td>
            <td width="7%">��ע</td>
          </tr>
          <logic:present name="OtherCataLogs">
          <logic:iterate id="otherCataLog" name="OtherCataLogs" >
          <tr align="center" style='cursor:hand' onMouseover="this.style.backgroundColor='#dff1ff'" onMouseOut="this.style.backgroundColor=''" onclick="doGoto('<bean:write name='otherCataLog' property='cataId' />')">
            <td bgcolor="#f6f6f6"><bean:write name="otherCataLog" property="cataDate"/></td>
            <td bgcolor="#f6f6f6"><bean:write name="otherCataLog" property="cataNum"/></td>
            <td bgcolor="#f6f6f6"><bean:write name="otherCataLog" property="cataUnit"/></td>
            <td bgcolor="#f6f6f6"><bean:write name="otherCataLog" property="cataAddress"/></td>
            <td bgcolor="#f6f6f6"><bean:write name="otherCataLog" property="cataItem"/></td>
            <td bgcolor="#f6f6f6"><bean:write name="otherCataLog" property="cataBuid"/></td>
            <td bgcolor="#f6f6f6"><bean:write name="otherCataLog" property="cataSec"/></td>
            <td bgcolor="#f6f6f6"><bean:write name="otherCataLog" property="cataValue"/></td>
            <td bgcolor="#f6f6f6"><bean:write name="otherCataLog" property="cataCardDate"/></td>
            <td bgcolor="#f6f6f6"><bean:write name="otherCataLog" property="cataCardNum"/></td>
            <td bgcolor="#f6f6f6"><bean:write name="otherCataLog" property="cataMan"/></td>
            <td bgcolor="#f6f6f6"><bean:write name="otherCataLog" property="cataArea"/></td>
            <td bgcolor="#f6f6f6"><bean:write name="otherCataLog" property="remark"/></td>
          </tr>
	  </logic:iterate>
         <logic:notEqual name="OtherCataLogs" property="firstPage" value="true" >
				<a href="?page=first">&lt;&lt; ��һҳ</a>
				<a href="?page=previous">&lt;&lt; ��һҳ</a>
			</logic:notEqual>
			<logic:notEqual name="OtherCataLogs" property="lastPage" value="true" >
				<a href="?page=next">��һҳ &gt;&gt;</a>
				<a href="?page=last">���ҳ &gt;&gt;</a>
			</logic:notEqual>
			����<bean:write name="OtherCataLogs" property="rowAmount" />����¼&nbsp;
			��Ϊ<bean:write name="OtherCataLogs" property="pageAmount" />ҳ&nbsp;
			ÿҳ<bean:write name="OtherCataLogs" property="pageSize" />��&nbsp;
			��ǰ��<input type="text" size="1" value="<bean:write name="OtherCataLogs" property="pageIndex" />" onChange="javascript:gotoPage(this.value)" />ҳ
          </logic:present>
        </table>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="9%" bgcolor="#F7EED9"><input name="Submit" type="Submit" value="��ӡĿ¼��" onclick="window.print()">
            </td>
            <td width="6%" bgcolor="#F7EED9"><input type="Submit" name="Submit" onclick="window.location='otherCataLogAdd.jsp'"value="����"></td>
          </tr>
        </table>
        <br>
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
</html>
