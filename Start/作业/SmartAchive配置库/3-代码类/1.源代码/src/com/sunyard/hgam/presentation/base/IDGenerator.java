package com.sunyard.hgam.presentation.base;

/**
 * ���ݵ�ǰʱ�䣬�õ�һ��id����ȷ��΢��
 */
public class IDGenerator {
	public static String getTimeString() {
		StringBuffer retValue = new StringBuffer();
		String tempString = TimestampConvert.currentTimeString().trim();
		for(int i = 0; i < tempString.length(); i++) {
			try {
				if(Integer.parseInt(tempString.substring(i, i + 1)) < 10)
					retValue.append(tempString.substring(i, i + 1));
			} catch(Exception e) {
			}
		}
		return retValue.toString();
	}

}