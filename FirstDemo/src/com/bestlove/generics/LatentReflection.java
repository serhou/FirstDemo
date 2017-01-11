package com.bestlove.generics;

import java.lang.reflect.Method;

/**
 * 反射的应用 -----曲线救国，实现潜在类型机制
 * 尽管Java不支持潜在类型机制，但是这并不意味这有界泛型代码
 * 不能在不同的类型层次结构之间应用。也就是说，我们仍旧可以
 * 创建真正的泛型代码，但是这需要付出一些额外的努力
 * @author think
 *
 */

public class LatentReflection {
	public static void main(String[] args) {
		CommunicateReflectively.perform(new SmartDog());
		CommunicateReflectively.perform(new Robot());
		CommunicateReflectively.perform(new Mime());
	}
}

class Mime {
	public void walkAgainstTheWind() {}
	public void sit() {
		System.out.println("Pretending to sit");
	}
	public void pushInvisibleWalls() {}
	public String toString() {
		return "Mime";
	}
}

class SmartDog {
	public void speak() {
		System.out.println("Woof!");
	}
	public void sit() {
		System.out.println("Sitting");
	}
	public void reproduce() {}
}

class CommunicateReflectively {
	public static void perform(Object speaker) {
		Class<?> spkr = speaker.getClass();
		try {
			try {
				Method speak = spkr.getMethod("speak");
				speak.invoke(speaker);
			} catch (NoSuchMethodException e) {
				System.out.println(speaker + " cannot speak");
			}
			try {
				Method speak = spkr.getMethod("sit");
				speak.invoke(speaker);
			} catch (NoSuchMethodException e) {
				System.out.println(speaker + " cannot sit");
			}
		} catch (Exception e) {
			throw new RuntimeException(speaker.toString(), e);
		}
	}
}
