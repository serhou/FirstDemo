package com.bestlove.pratices;

public class AutoInc {

	public static void main(String[] args) {
		
		int i = 1;
		
		/**
		 * 对于前缀递增和前缀（如++a或--a）,会先执行运算，再生成值。
		 * 而对于后缀递增和后缀递减（如a++或a--），会先生成值，再执行运算
		 */
		
		System.out.println("i: " + i);
		System.out.println("先执行运算，再生成值++i: " + ++i);
		System.out.println("先生成值，再执行运算i++: " + i++);
		System.out.println("i: " + i);
		System.out.println("先执行运算，再生成值--i: " + --i);
		System.out.println("先生成值，再执行运算i--: " + i--);
		System.out.println("i: " + i);
	}
	
}
