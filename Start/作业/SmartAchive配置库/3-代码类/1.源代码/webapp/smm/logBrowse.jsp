<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<html>
<head>
<title>��־����</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<script language="javascript" src="../common/js/delete.js"></script>
</head>
<body class="bg-page01">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="32"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="100%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#0293CA">
                <tr>
                  <td align="center" bgcolor="#E4F7FA" class="tishi">��־�б�</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td align="center" bgcolor="#FFFFFF">
	    <logic:present name="allUserLogList">
	    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr> 
          <td bgcolor="#F7EED9">
		  <logic:notEqual name="allUserLogList" property="firstPage" value="true" > 
            <a href="?page=first">&lt;&lt; 
            ��һҳ </a><a href="?page=previous">&lt; 
            ��һҳ </a></logic:notEqual> <logic:notEqual name="allUserLogList" property="lastPage" value="true" > 
            <a href="?page=next">��һҳ 
            &gt; </a><a href="?page=last">���ҳ 
            &gt;&gt; </a></logic:notEqual>&nbsp; ��<bean:write name="allUserLogList" property="rowAmount" />����¼&nbsp; 
            ��ǰ�� 
            <input type="text" size="1" value="<bean:write name="allUserLogList" property="pageIndex" />" onChange="javascript:gotoPage(this.value)"> 
						/<bean:write name="allUserLogList" property="pageAmount" /> 
            ҳ&nbsp; ÿҳ<bean:write name="allUserLogList" property="pageSize" />��</td>
        </tr>
        </table>
	    </logic:present>
	    <table width="100%" border="0" cellpadding="2" spacing="1" bgcolor="#FFFFFF">
          <tr align="center" bgcolor="#F7EED9">
            <td><input type="checkbox" name="checkall" onClick="javascript:setCheckBoxes(allUserLogList,this.checked)"></td>
            <td>���</td>
            <td>�û���</td>
            <td>IP��ַ</td>
            <td>������Ϣ</td>
            <td>����ʱ��</td>
          </tr>
          <form name="allUserLogList">
		  <logic:present name="allUserLogList">
          <logic:iterate id="userLog" name="allUserLogList" > 
          <tr align="center" bgcolor="#f6f6f6">
            <td><input name="checkbox" type="checkbox" value="<bean:write name="userLog" property="logID" />"></td>
            <td><bean:write name="userLog" property="logID" /></td>
            <td><bean:write name="userLog" property="userName" /></td>
            <td><bean:write name="userLog" property="ip" /></td>
            <td><bean:write name="userLog" property="logMsg" /></td>
            <td><bean:write name="userLog" property="occurTime" /></td>
          </tr>
          </logic:iterate> 
		  </logic:present>
          </form>
        </table>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="10%" align="center" bgcolor="#F7EED9">&nbsp; </td>
            <td width="11%" align="center" bgcolor="#F7EED9">
			  <form name="delform" method="post" action="/smm/deleteUserLog.do" onSubmit="return delConfirm(allUserLogList,this.ids)">
                <input type="hidden" name="ids">
                <input type="submit" name="delete" value="ɾ��" alt="ɾ��">
              </form>
			</td>
            <td width="77%" bgcolor="#F7EED9">&nbsp; </td>
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
</body>
</html>
