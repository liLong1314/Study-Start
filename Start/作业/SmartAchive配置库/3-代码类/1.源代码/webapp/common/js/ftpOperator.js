
//从服务器上下载文件，返回文件的本地路径
function downloadFile(ftpCtrl, serverName, serverPort, userName, password, localDir, localFileName, serverDir, serverFileName){

	//连接服务器
	if(!ftpCtrl.ConnectServer(serverName, serverPort, userName, password))
	{
	  alert("连接FTP服务器失败，本次保存失败！");
	  return false;
	}
	
	//下载文件
    if(!ftpCtrl.GetFile(serverDir, serverFileName, localDir, localFileName))
    {
        alert("下载文件失败！");
        UploadCtrl1.DisconnectServer();
        return false;
    }
    ftpCtrl.DisconnectServer();
    
    return localDir + localFileName;
}

function uploadFile(ftpCtrl, serverName, serverPort, userName, password, localDir, localFileName, serverDir, serverFileName) {
	
	//上传扫描文件及配置文件
	var s = "server      =" + serverName + "\n" +
			"serverPort = " + serverPort + "\n" +
			"userName   = " + userName + "\n" +
			"password   = " + password + "\n" ;
	//alert(s);
	if(!ftpCtrl.ConnectServer(serverName, serverPort, userName, password))
	{
	  alert("连接FTP服务器失败，本次保存失败！");
	  return false;
	}

	if(!ftpCtrl.CreateDirectory(serverDir))
	{
	  alert("在ftp服务器上建临时目录时出错！本次保存失败");
	  return false;
	}
	if(!ftpCtrl.PutFile(serverDir,serverFileName,localDir,localFileName))
	{
	  alert("上传扫描信息文件时出错，本次保存失败！");
	  return false;
	}
	ftpCtrl.DisconnectServer();
	return true;
}