/** 用户单选按钮的操作，包括判断是否有选中，以及取得选中按钮的value值*/
//判断radio组ButtonGroup是否被选中一个
function IsChecked(ButtonGroup){

	for(var x=0; x<ButtonGroup.length; x++){
		if(ButtonGroup[x].checked){
			return true;
		}		
	}
	return false
}
//得到选择的radio的value,ButtonGroup为option的name，如document.formname.name
//auther:Zhangdong@sunyard.com
function GetSelectedValue(ButtonGroup){
	var index=-1;
	var returnValue=-1;
		
	//得到已经选择的radio的下标
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