package com.bestlove.string;

/**
 * 字符串的正则表达式：替换
 * @author think
 *
 */

public class Replacing {

	static String s = Splitting.knights;
	
	public static void main(String[] args) {
		System.out.println(s);
		//匹配的是以f开头的，后面跟着一个或多个字母(注意这里的w是小写的)。
		//并且只替换掉第一个匹配的部分，所以"found"被替换为"located"
		System.out.println(s.replaceFirst("f\\w+", "located"));
		//整个单词被替换，使用了|  或，其中任何一个
		System.out.println(s.replaceAll("shrubbery|tree|herring", "banana"));
	}
}
