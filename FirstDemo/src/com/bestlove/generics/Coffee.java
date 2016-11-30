package com.bestlove.generics;

public class Coffee {

	private static long counter = 0;
	private final long ID = counter++;
	@Override
	public String toString() {
		return getClass().getSimpleName() + " " + ID;
	}
	
}

//拿铁
class Latte extends Coffee {}
//摩卡
class Mocha extends Coffee {}
//卡布奇诺
class Cappuccino extends Coffee {}
//美式
class Americano extends Coffee {}
//布雷卫
class Breve extends Coffee {}