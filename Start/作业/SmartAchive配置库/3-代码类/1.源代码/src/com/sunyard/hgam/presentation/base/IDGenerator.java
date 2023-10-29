package com.sunyard.hgam.presentation.base;

/**
 * 根据当前时间，得到一个id，精确到微秒
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