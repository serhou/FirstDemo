package com.bestlove.test;

import java.math.BigDecimal;

/**
 * BigDecimal支持任意精度的定点数，
 * 虽然它属于包装器类的范畴，但是没有相对应的基本类型
 * 所以能作用于float的操作，也同样能作用于BigDecimal。
 * 只不过必须以方法调用方式取代运算符方式来实现。
 * 由于这么做复杂了很多，所以运算速度会比较慢。
 * 这是典型的拿速度换精度的案例
 * @author think
 *
 */
public class TestBigDecimal {

	public static void main(String[] args) {
		
		BigDecimal bg = new BigDecimal("-17732.432");
		System.out.println(bg.abs());
		System.out.println(bg.plus().add(bg.abs()));
	}
	
}
