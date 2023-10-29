//作者：郑先全
//验证电子表单
//1	varchar2 字符串
//2	number	 数字
//3	date	 日期
function validateEform(theform){
	var theValue=document.getElementsByName("field_value");
	var theName =document.getElementsByName("field_cname");
	for(var i=0;i<theValue.length;i++){
		if(BASEtrim(theValue[i].value)==""){
			if(theValue[i].field_isNull=="0")
				return BASEalert("请输入[" + theName[i].value + "]",theValue[i]);
		}else{
			if(BASEtrim(theValue[i].field_type_id)=="1"){
				//字符串
				//return BASEalert("请输入[" + theName[i].value + "]！",theValue[i]);
			}if(BASEtrim(theValue[i].field_type_id)=="2"){
				//数字
				if(BASEisNotFloat(theValue[i].value))
					return BASEalert("请输入数字型的[" + theName[i].value + "]，如 123！",theValue[i]);
			}if(BASEtrim(theValue[i].field_type_id)=="3"){
				//日期
				if(BASEisNotDate(theValue[i].value))
					return BASEalert("请输入日期型的[" + theName[i].value + "]，格式为 YYYY-MM-DD！",theValue[i]);
			}
		}
	}
	return true;
}
