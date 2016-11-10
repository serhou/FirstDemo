package com.bestlove.string;

import java.util.Scanner;
import java.util.regex.MatchResult;

/**
 * 使用自定义的正则表达式进行扫描
 * 当next()方法配合指定的正则表达式使用时，
 * 将找到下一个匹配该模式的输入部分，调用match()方法就可以获得匹配的结果
 * 
 * 有一点需要注意：在配合正则表达式使用扫描时，它仅仅针对下一个输入粪池进行匹配，
 * 如果你的正则表达式中含有定界符，那永远都不可能匹配成功
 * 
 * @author think
 *
 */

public class ThreatAnalyzer {

	static String threatData = 
			"58.27.82.161@02/10/2005\n " + 
			"204.45.234.40@02/10/2005\n " + 
			"58.27.82.161@02/11/2005\n " + 
			"58.27.82.161@02/12/2005\n " + 
			"58.27.82.161@02/13/2005\n " + 
			"[Next log section with different data format]";
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(threatData);
		
		String pattern = "(\\d+[.]\\d+[.]\\d+[.]\\d+)@"
				+ "(\\d{2}/\\d{2}/\\d{4})";
		while (scanner.hasNext(pattern)) {
			scanner.next(pattern);
			MatchResult matchResult = scanner.match();
			String ip = matchResult.group(1);
			String date = matchResult.group(2);
			System.out.format("Threat on %s from %s\n", date, ip);
		}
	}
	
	
}
