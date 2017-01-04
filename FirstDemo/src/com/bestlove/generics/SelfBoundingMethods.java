package com.bestlove.generics;

/**
 * 还可以将自限定用于泛型方法
 * 这可以防止这个方法被用于与除上述形式的
 * 自限定参数之外的任何事物上
 * @author think
 *
 */

public class SelfBoundingMethods {
	static <T extends SelfBounded<T>> T f(T arg) {
		return arg.set(arg).get();
	}
	public static void main(String[] args) {
		A a = f(new A());
	}
}
