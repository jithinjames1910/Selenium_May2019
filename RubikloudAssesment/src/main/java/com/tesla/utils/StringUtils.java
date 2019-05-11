package com.tesla.utils;


public class StringUtils {
	
	public static String getOnlyIntegerFromString(String str) {
		return str.replaceAll("\\D+","");
	}

}
