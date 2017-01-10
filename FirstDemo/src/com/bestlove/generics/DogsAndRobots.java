package com.bestlove.generics;

import com.bestlove.classtype.Dog;

/**
 * Java 实现示例，会被强制要求使用一个类或接口，
 * 并在边界表达式中指定它
 * @author think
 *
 */

public class DogsAndRobots {
	public static void main(String[] args) {
		PerformingDog d = new PerformingDog();
		Robot r = new Robot();
		Communicate.perform(d);
		Communicate.perform(r);
		//需要注意的是：perform()不需要使用泛型来工作，
		//它可以被简单地指定为接受一个Performs对象
		CommunicateSimply.perform(d);
		CommunicateSimply.perform(r);
	}
}

interface Performs {
	void speak();
	void sit();
}

class PerformingDog extends Dog implements Performs {
	@Override
	public void speak() {
		System.out.println("Woof!");
	}
	@Override
	public void sit() {
		System.out.println("Sitting");
	}
	public void reproduce() {}
}

class Robot implements Performs {
	@Override
	public void speak() {
		System.out.println("Click!");
	}
	@Override
	public void sit() {
		System.out.println("Clank!");
	}
	public void oilChange() {}
}

class Communicate {
	//指定
	public static <T extends Performs> void perform(T performer) {
		performer.speak();
		performer.sit();
	}
}

class CommunicateSimply {
	static void perform(Performs performer) {
		performer.speak();
		performer.sit();
	}
}
