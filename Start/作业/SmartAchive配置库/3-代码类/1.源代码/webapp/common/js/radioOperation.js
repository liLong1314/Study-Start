/** �û���ѡ��ť�Ĳ����������ж��Ƿ���ѡ�У��Լ�ȡ��ѡ�а�ť��valueֵ*/
//�ж�radio��ButtonGroup�Ƿ�ѡ��һ��
function IsChecked(ButtonGroup){

	for(var x=0; x<ButtonGroup.length; x++){
		if(ButtonGroup[x].checked){
			return true;
		}		
	}
	return false
}
//�õ�ѡ���radio��value,ButtonGroupΪoption��name����document.formname.name
//auther:Zhangdong@sunyard.com
function GetSelectedValue(ButtonGroup){
	var index=-1;
	var returnValue=-1;
		
	//�õ��Ѿ�ѡ���radio���±�
	for(var x=0; x<ButtonGroup.length; x++){
		if(ButtonGroup[x].checked){
			index=x;
			break;
		}		
	}
	if(index!=-1)
		returnValue = ButtonGroup[index].value;
	return returnValue;
}