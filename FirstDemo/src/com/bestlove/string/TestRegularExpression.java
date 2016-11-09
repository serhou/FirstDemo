package com.bestlove.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Pattern和Matcher
 * @author think
 *
 */

public class TestRegularExpression {

	public static void main(String[] args) {
		
		args =new String[] {"abcabcabcdefabc", "abc+", "(abc)+", "(abc){2,}"};
		
		if (args.length < 2) {
			System.out.println("Usage:\njava TestRegularExpression "
					+ "characterSequence regularExpression+");
			System.exit(0);
		}
		
		System.out.println("Input: \"" + args[0] + "\"");//第一个作为输入的字符串
		
		for (String arg : args) {
			System.out.println("Regular expression: \"" + arg + "\"");
			Pattern p = Pattern.compile(arg);//数组中的每个元素都作为正则表达式
			Matcher m = p.matcher(args[0]);//拿每个正则表达式与第一个字符串做匹配
			while (m.find()) {
				System.out.println("Match \"" + m.group() + "\" at positions "
						+ m.start() + "-" + (m.end()-1));//输出匹配结果
			}
		}
		
		/*
		
		Input: "abcabcabcdefabc"
		Regular expression: "abcabcabcdefabc" //正则表达式为"abcabcabcdefabc"时
		Match "abcabcabcdefabc" at positions 0-14 //全部匹配
		Regular expression: "abc+" //正则表达式为"abc+"时
		Match "abc" at positions 0-2 //第一个abc
		Match "abc" at positions 3-5 //第二个abc
		Match "abc" at positions 6-8 //第三个abc
		Match "abc" at positions 12-14 //第四个abc
		Regular expression: "(abc)+"
		Match "abcabcabc" at positions 0-8 //abcabcabc
		Match "abc" at positions 12-14 //abc
		Regular expression: "(abc){2,}" //至少2个abc
		Match "abcabcabc" at positions 0-8
		
		*/
		
	}
	
	
}
