package com.bestlove.string;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 在引入正则表达式(1.4)和Scanner(1.5)类之前，分割字符串的唯一方法是使用
 * StringToKenizer来分词。
 * 使用正则表达式或Scanner对象，我们能够以更加复杂的模式来分割一个字符串，
 * 而这对于StringTokenizer来说就困难了。基本上，我们可以放心的说，StringTokenizer
 * 已经可以废弃不用了。
 * @author think
 *
 */

public class ReplacingStringTokenizer {
	
	public static void main(String[] args) {
	
		String input = "But   I'm not     dead yet! I feel happy!";
		
		StringTokenizer stoke = new StringTokenizer(input);
		while (stoke.hasMoreElements()) {
			System.out.print(stoke.nextToken() + " ");
		}
		System.out.println();
		System.out.println(Arrays.toString(input.split("\\s+")));
		Scanner scanner = new Scanner(input);
		while (scanner.hasNext()) {
			System.out.print(scanner.next() + " ");
		}
	
	}
	
}
