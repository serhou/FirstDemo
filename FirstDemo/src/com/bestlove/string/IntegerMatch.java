package com.bestlove.string;

/**
 * 特殊字符必须使用\\转义 
 * @author think
 *
 */


public class IntegerMatch {

	public static void main(String[] args) {
		//要找一个数字，它可能有一个负号在最前面，那你就写一个负号加上一个问号
		System.out.println("-1234".matches("-?\\d+"));//true
		System.out.println("23974".matches("-?\\d+"));//true
		System.out.println("+423".matches("-?\\d+"));//false
		System.out.println("+385".matches("(-|\\+)?\\d+"));//有证号或负号，或者都没有
		System.out.println("-385".matches("(-|\\+)?\\d+"));//有证号或负号，或者都没有
		System.out.println("385".matches("(-|\\+)?\\d+"));//有证号或负号，或者都没有
	}
	
	
}
