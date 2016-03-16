package com.bestlove.test;

import java.math.BigInteger;

/**
 * BigInteger支持任意精度的整数，
 * 虽然它属于包装器类的范畴，但是没有相对应的基本类型
 * 所以能作用于int的操作，也同样能作用于BigInteger。
 * 只不过必须以方法调用方式取代运算符方式来实现。
 * 由于这么做复杂了很多，所以运算速度会比较慢。
 * 这是典型的拿速度换精度的案例
 * @author think
 *
 */
public class TestBigInteger {

	public static void main(String[] args) {
		//字符串转化
		BigInteger bi = new BigInteger("-123348932");
		//求绝对值
		System.out.println(bi.abs());
		System.out.println(bi.toByteArray().length);
		byte[] b = bi.toByteArray();
		for (byte c : b) {
			System.out.println(c);
		}
	}
	
}
