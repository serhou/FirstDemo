package com.bestlove.string;

/**
 * 我们的目的并不是编写最难理解的正则表达式，
 * 而是尽量编写能够完成任务的、最简单以及最必要的正则表达式
 * 一旦真正开始使用正则表达式了，你就会发现，在编写新的表达式
 * 之前，你通常会参考代码中已经用到的正则表达式。
 * @author think
 *
 */

public class Rudolph {

	public static void main(String[] args) {

		for (String pattern : new String[]{
				"Rudolph", 
				"[rR]udolph", 
				"[rR][aeiou][a-z]ol.*", 
				"R.*"}) {
			System.out.println("Rudolph".matches(pattern));//全部匹配
		}
		
	}
	
}
