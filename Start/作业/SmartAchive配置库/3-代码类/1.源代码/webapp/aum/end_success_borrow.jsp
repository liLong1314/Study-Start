<%@ page contentType="text/html; charset=GBK" %>
<html>
<head>
<title>
操作成功
</title>
<script>
function doBack(){
  window.location='/aum/BorrowTaskList.do?flag=0';
  parent.frames[1].location.reload();
}
</script>
</head>
<body background="../image/2_mainpagebg_01.gif" leftmargin="0" topmargin="0">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td><p>&nbsp;</p>
      <font color="blue" size="3">操作成功!</font></p></td>
  </tr>
  <tr>
    <td><p>&nbsp;</p>
    <input type="button" name="Submit" value="返回" onclick="doBack()" />
  </tr>
</table>
</body>
</html>
