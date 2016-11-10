package com.bestlove.string;

import java.util.Scanner;

/**
 * Scanner定界符
 * 在默认的情况下，Scanner根据空白字符对输入进行分词，
 * 但是你可以用正则表达式指定自己所需的定界符
 * 这个例子使用逗号(包括逗号前后任意的空白字符)作为定界符
 * 我们可以用useDelimiter()来设置定界符，同时，还有一个delimiter()方法
 * 用来返回当前正在作为定界符使用的Pattern对象
 * @author think
 *
 */

public class ScannerDelimiter {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner("12, 35, 47, 78  , 11, 56 , 193");
		System.out.println(scanner.delimiter().pattern());
		scanner.useDelimiter("\\s*,\\s*");
		while(scanner.hasNextInt()){
			System.out.println(scanner.nextInt());
		}
		System.out.println(scanner.delimiter().pattern());
	}
	
}
