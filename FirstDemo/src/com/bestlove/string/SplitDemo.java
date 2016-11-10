package com.bestlove.string;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * 分割split()
 * @author think
 *
 */

public class SplitDemo {

	public static void main(String[] args) {
		
		String input = 
				"This!!unusual use!!of exclamation!!points";
		System.out.println(Arrays.toString(
				Pattern.compile("!!")
				.split(input)));//全部分割
		System.out.println(Arrays.toString(
				Pattern.compile("!!")
				.split(input, 3)));//可以限制将输入分割成字符串的数量
	}
	
}
