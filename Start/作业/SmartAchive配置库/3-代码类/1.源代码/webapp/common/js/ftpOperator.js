
//�ӷ������������ļ��������ļ��ı���·��
function downloadFile(ftpCtrl, serverName, serverPort, userName, password, localDir, localFileName, serverDir, serverFileName){

	//���ӷ�����
	if(!ftpCtrl.ConnectServer(serverName, serverPort, userName, password))
	{
	  alert("����FTP������ʧ�ܣ����α���ʧ�ܣ�");
	  return false;
	}
	
	//�����ļ�
    if(!ftpCtrl.GetFile(serverDir, serverFileName, localDir, localFileName))
    {
        alert("�����ļ�ʧ�ܣ�");
        UploadCtrl1.DisconnectServer();
        return false;
    }
    ftpCtrl.DisconnectServer();
    
    return localDir + localFileName;
}

function uploadFile(ftpCtrl, serverName, serverPort, userName, password, localDir, localFileName, serverDir, serverFileName) {
	
	//�ϴ�ɨ���ļ��������ļ�
	var s = "server      =" + serverName + "\n" +
			"serverPort = " + serverPort + "\n" +
			"userName   = " + userName + "\n" +
			"password   = " + password + "\n" ;
	//alert(s);
	if(!ftpCtrl.ConnectServer(serverName, serverPort, userName, password))
	{
	  alert("����FTP������ʧ�ܣ����α���ʧ�ܣ�");
	  return false;
	}

	if(!ftpCtrl.CreateDirectory(serverDir))
	{
	  alert("��ftp�������Ͻ���ʱĿ¼ʱ�������α���ʧ��");
	  return false;
	}
	if(!ftpCtrl.PutFile(serverDir,serverFileName,localDir,localFileName))
	{
	  alert("�ϴ�ɨ����Ϣ�ļ�ʱ�������α���ʧ�ܣ�");
	  return false;
	}
	ftpCtrl.DisconnectServer();
	return true;
}