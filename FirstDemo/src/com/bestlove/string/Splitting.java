package com.bestlove.string;

import java.util.Arrays;

/**
 * 字符串的分割：split
 * @author think
 *
 */

public class Splitting {

	public static String knights = 
			"Then, when you have found the shrubbery, you must "
			+ "cut down the mightiest tree in the forest... "
			+ "with... a herring!";
	
	public static void split(String regex){
		System.out.println(Arrays.toString(knights.split(regex)));
	}
	
	public static void main(String[] args) {
		
		split(" ");//只按空格来划分字符串
		split("\\W+");//\W大写，它的意思是非单词字符（如果\w小写，\w则表示一个单词字符）
		split("n\\W+");//字母n后面跟着一个或多个非单词字符
		split("\\w");//按单词分，单词都没了
		split("\\w+");//按单词或多个分，单词都没了
	}
	
}
