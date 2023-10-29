//validCheck.js
//Used for check the form validate of a web

//Check if the textObj.value is a number
//Used in validcheck of a input form
//Usage eg.:
//<script src="../validCheck.js">
//function validCheck() {
//	....
//	//check if the input value is a number	
//	if(!isInt(formName.textName)) {
//		alert("please input a number in textName");
//		return false;
//	}
//}
//</script>
//zhangdong@sunyard.com 2003-9-22
function isInt(textObj) {
	var ivalue = textObj.value;
	var ivalueLength = ivalue.length;

	for(var i = 0; i != ivalueLength; i++) {
		var aChar = ivalue.substring(i,i+1);
		if(aChar<"0" || aChar>"9") {
			return false;
		}
	}
	return true;
}

//����Ƿ���磺123.45 or 123 or 123.4 or 123.
//By CaoFeng
function isMoney(theFloat){
	len=theFloat.length
	dotNum=0
	if (len==0)
		return false
	for(var i=0;i<len;i++){
		oneNum=theFloat.substring(i,i+1)
		if (oneNum==".")
			dotNum++
		if ( ((oneNum<"0" || oneNum>"9") && oneNum!=".") || dotNum>1)
			return false
	}
	//08
	if (len>1 && theFloat.substring(0,1)=="0"){
		if (theFloat.substring(1,2)!=".")
			return false
	}
	if(dotNum==1){
		last = theFloat.indexOf(".")
		laststr = theFloat.substr(last)
		if(laststr.length > 2)
			return false
	}
	return true
}

//Check if the textObj.value is empty
//Used in validcheck of a input form
//Usage eg.:
//function validCheck() {
//	....
//	//check if the input value is a number	
//	if(isEmpty(formName.textName)) {
//		alert("textName should not be empty");
//		return false;
//	}
//}
//zhangdong@sunyard.com 2003-9-22
function isEmpty(textObj) {
	var iValue = textObj.value;
	if(iValue == "") {
		return true;
	}else {
		return false;
	}
}

//������ڸ�ʽ
//2003-11-3 Modified by zhangdong@sunyard.com
function isDate(date)
{ if (date.value!="" && date.value.length!=10 && date.value.length!=8) {
    	//alert("����ȷ��������,��2002-01-01����20020101��");
        return false
   }
   if (date.value.length==10){
        var i
		if  ((date.value.substring(4,5)!="-") || (date.value.substring(7,8)!="-") ) {
            //alert("����ȷ��������,��2002-01-01��" );
            return false
		}
        for (i=1;i<11;i++)  {
            if ((i!=8) && (i!=5) && (date.value.substring(i-1,i)<"0" || date.value.substring(i-1,i)>"9")) {
                //alert("����ȷ�������ڣ���2002-01-01��" );
                return false
	        }
      	} 
		if ((date.value.substring(0,4)>"2058") || (date.value.substring(0,4)<"1971")) {
			//alert("��������ȷ����ݣ�");
			return false
		}
		if ((date.value.substring(5,7)>"12") || (date.value.substring(5,7)<"01")) {
			//alert("��������ȷ���·ݣ�");
			return false
		}
		if ((date.value.substring(8,10)>"31") || (date.value.substring(8,10)<"01")) {
			//alert("��������ȷ�����ڣ�");
			return false
		}
		var year=date.value.substring(0,4),month=date.value.substring(5,7),day=date.value.substring(8,10);
		var leap=(year%4==0&&year%100!=0)||year%400;
	
		if(month=="02")
			if(leap) 
				if(day>"29") {
					//alert("����ȷ�������ڣ�");
					return false
				}
			else 
				if(day>"28") {
					//alert("����ȷ�������ڣ�");
					return false
				}
		if(month=="04"||month=="06"||month=="09"||month=="11")	
			if(day>"30") {
				//alert("����ȷ�������ڣ�");
				return false
			}
   }
   if (date.value.length==8){
        var i
        if ((date.value.substring(0,4)>"2100") || (date.value.substring(0,4)<"1900")) {
			//alert("��������ȷ����ݣ�");
			return false
		}
		if ((date.value.substring(4,6)>"12") || (date.value.substring(4,6)<"01")) {
			//alert("��������ȷ���·ݣ�");
			return false
		}
		if ((date.value.substring(6,8)>"31") || (date.value.substring(6,8)<"01")) {
			//alert("��������ȷ�����ڣ�");
			return false
		}
		var temp=date.value;
		date.value=temp.substring(0,4) + "-" + temp.substring(4,6) + "-" + temp.substring(6,8);
		var year=date.value.substring(0,4),month=date.value.substring(5,7),day=date.value.substring(8,10);
		var leap=(year%4==0&&year%100!=0)||year%400;
		if(year<="1970"){
			//alert("��ݱ������1970��");
			return false
		}
		if(year>="2059"){
			//alert("��ݱ���С��2059��");
			return false
		}
		if(month=="02")
			if(leap) 
				if(day>"29") {
					//alert("����ȷ�������ڣ�");
					return false
				}
			else 
				if(day>"28") {
					//alert("����ȷ�������ڣ�");
					return false
				}
		if(month=="04"||month=="06"||month=="09"||month=="11")	
			if(day>"30") {
				//alert("����ȷ�������ڣ�");
				return false
			}
   }
   return true
}

//������ڸ�ʽ
function checkIsDate(DateString , Dilimeter) 
{ 
  if (DateString==null) return false; 
  if (Dilimeter=='' || Dilimeter==null) 
   Dilimeter = '-'; 
  var tempy=''; 
  var tempm=''; 
  var tempd=''; 
  var tempArray; 
  if (DateString.length<8 && DateString.length>10) 
    return false;    
  tempArray = DateString.split(Dilimeter); 
  if (tempArray.length!=3) 
   return false; 
  if (tempArray[0].length==4) 
  { 
   tempy = tempArray[0]; 
   tempd = tempArray[2]; 
  } 
  else 
  { 
   tempy = tempArray[2]; 
   tempd = tempArray[1]; 
  } 
  tempm = tempArray[1]; 
  var tDateString = tempy + '/'+tempm + '/'+tempd+' 8:0:0';//�Ӱ�Сʱ����Ϊ���Ǵ��ڶ����� 
  var tempDate = new Date(tDateString); 
  if (isNaN(tempDate)) 
   return false; 
 if (((tempDate.getUTCFullYear()).toString()==tempy) && (tempDate.getMonth()==parseInt(tempm)-1) && (tempDate.getDate()==parseInt(tempd))) 
  { 
   return true; 
  } 
  else 
  { 
   return false; 
  } 
} 

//���ڸ�ʽ��yyyy-mm-dd
// ��       yyyy-m-d
function IsDateString(Str)
{
	// У���Ƿ�YYYY-MM-DD��ʽ�����������ݣ�����ֵΪTrue�ɹ������򷵻�False
	// ������ݵ��ǿ��ַ����򷵻�False
	// ����ָ���
	var sSplit="-" 
	var iYearPos=Str.indexOf(sSplit);
	if (iYearPos==-1) return false;
	
	var iMonthPos=Str.indexOf(sSplit,iYearPos+1);
	if (iMonthPos==-1) return false;
	
	// ��������
	sYear=Str.substr(0,iYearPos);
	// ������·�
	sMonth=Str.substr(iYearPos+1,iMonthPos-iYearPos-1);
	//�·ݳ���Ϊ�� 
	//if (sMonth.length!=2) return false;
	if (sMonth.substr(0,1)=="0") sMonth=sMonth.substr(1);
	// ���������
	sDay=Str.substr(iMonthPos+1);
	//�ճ���Ϊ��
	//if (sDay.length!=2) return false;
	if (sDay.substr(0,1)=="0") sDay=sDay.substr(1);
	
	// ����Ƿ����֣�
	if (isNaN(sYear)) return false;
	var iYear=parseInt(sYear);
	// ����Ƿ�������
	if (sYear!=iYear) return false;
	// ����Ƿ���1000-9999֮�䣿
	if (iYear<1000 || iYear>9999) return false;
	
	// �·��Ƿ����֣�
	if (isNaN(sMonth)) return false;
	var iMonth=parseInt(sMonth);
	// �·��Ƿ�������
	if (sMonth!=iMonth) return false;
	// �·��Ƿ���1-12֮�䣿
	if (iMonth<1 || iMonth>12) return false;
	
	// �����Ƿ����֣�
	if (isNaN(sDay)) return false;
	var iDay=parseInt(sDay);
	// �����Ƿ�������
	if (sDay!=iDay) return false;
	// �����Ƿ���1-31֮�䣿 
	if (iDay<1 || iDay>31) return false;
	
	if (iDay<29) return true;
	
	// ���������Ƿ�Ϸ��ģ�
	switch (iMonth)
	{
	case 1:
	if (iDay>31) return false;
	break;
	case 2:
	if (IsLeapYear(iYear))
	{
	if (iDay>29) return false;
	}
	else
	{
	if (iDay>28) return false;
	}
	break;
	case 3:
	if (iDay>31) return false;
	break;
	case 4:
	if (iDay>30) return false;
	break;
	case 5:
	if (iDay>31) return false;
	break;
	case 6:
	if (iDay>30) return false;
	break;
	case 7:
	if (iDay>31) return false;
	break;
	case 8:
	if (iDay>31) return false;
	break;
	case 9:
	if (iDay>30) return false;
	break;
	case 10:
	if (iDay>31) return false;
	break;
	case 11:
	if (iDay>30) return false;
	break;
	case 12:
	if (iDay>31) return false;
	}
	
	return true;

}

function IsLeapYear(Y)
{
	// ����Ƿ�Ϊ����
	if (Y % 4 !=0) return false;
	if (Y % 400 == 0) return true;
	if (Y % 100 == 0) return false;
}

