package com.bestlove.test;

public class CountSize {

	public static int getStringLength(String sourceStr, String splitStr){
		String[] strs = sourceStr.split(splitStr);
		System.out.println("******************************start******************************");
		for (int i = 0; i < strs.length; i++) {
			String string = strs[i];
			System.out.println(string);
		}
		System.out.println("*******************************end*******************************");
		return strs.length;
	}
}
