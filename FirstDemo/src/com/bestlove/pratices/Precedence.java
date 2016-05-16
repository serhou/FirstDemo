package com.bestlove.pratices;

/**
 * 操作符的优先级一般是先乘除后加减，程序员经常会忘记其他优先级规则
 * 所以应该用括号明确规定计算顺序
 * @author think
 *
 */

public class Precedence {

	public static void main(String[] args) {
		
		int x = 1, y = 2, z = 3;
		int a = x + y - 2/2 + z;
		int b = x + (y - 2)/(2 + z);
		// int 通过字符串相加变成了String类型
		System.out.println("a = " + a + ", b = "+ b);
		
	}
	
}
