//���ߣ�֣��ȫ
//��֤���ӱ�
//1	varchar2 �ַ���
//2	number	 ����
//3	date	 ����
function validateEform(theform){
	var theValue=document.getElementsByName("field_value");
	var theName =document.getElementsByName("field_cname");
	for(var i=0;i<theValue.length;i++){
		if(BASEtrim(theValue[i].value)==""){
			if(theValue[i].field_isNull=="0")
				return BASEalert("������[" + theName[i].value + "]",theValue[i]);
		}else{
			if(BASEtrim(theValue[i].field_type_id)=="1"){
				//�ַ���
				//return BASEalert("������[" + theName[i].value + "]��",theValue[i]);
			}if(BASEtrim(theValue[i].field_type_id)=="2"){
				//����
				if(BASEisNotFloat(theValue[i].value))
					return BASEalert("�����������͵�[" + theName[i].value + "]���� 123��",theValue[i]);
			}if(BASEtrim(theValue[i].field_type_id)=="3"){
				//����
				if(BASEisNotDate(theValue[i].value))
					return BASEalert("�����������͵�[" + theName[i].value + "]����ʽΪ YYYY-MM-DD��",theValue[i]);
			}
		}
	}
	return true;
}
