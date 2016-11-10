package com.bestlove.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Pattern.CASE_INSENSITIVE  (?i)
 * 默认情况下，大小写不敏感的匹配假定只有US-ASCII字符集中的字符才能进行
 * 这个标记允许模式匹配不必考虑大小写(大写或小写)。
 * 我们也可以通过指定Pattern.UNICODE_CASE  (?u)标记及结合此标记，基于Unicode
 * 的大小写不敏感的匹配。
 * Pattern.MULTILINE  (?m) 在多行模式下，表达式^和$分别匹配一行的开始和结束。
 * ^还匹配输入字符串的开始，而$还匹配输入字符串的结尾。默认情况下，这些表达式
 * 仅匹配输入的完整字符串的开始和结束
 * 
 * Pattern.COMMENTS  (?x) 在这种模式下，空格符将被忽略掉，并且以#开始直到行末
 * 的注释也会被忽略掉。通过嵌入的标记表达式也可以开启Unix的行模式。（对声明或文档有用）
 * @author think
 *
 */

public class ReFlags {

	public static void main(String[] args) {
		
		Pattern p = Pattern.compile("^java", 
				Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
		
		Matcher m = p.matcher(
				"java has regex\nJava has regex\n"
				+ "JAVA has pretty good regular expression\n"
				+ "Regular expressions are in Java");
		while (m.find()) {
			System.out.println(m.group());
		}
		
	}
	
}
