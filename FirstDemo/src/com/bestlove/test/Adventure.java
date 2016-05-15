package com.bestlove.test;

/**
 * 注意，CanFight接口与ActionCharacter类中的fight()方法的特征签名是一样的，
 * 而且，在Hero中并没有提供fight()的定义。可以扩展接口，但是得到的只是另一个接口。
 * 当想要创建对象时，所有的定义首先必须都存在。即使Hero没有显式地提供fight()的定义，
 * 其定义也因ActionCharacter而随之而来，这样就使得创建Hero对象成为了可能。
 * @author think
 *
 */

public class Adventure {

	public static void t(CanFight x) {
		x.fight();
	}
	public static void u(CanSwim x) {
		x.swim();
	}
	public static void v(CanFly x) {
		x.fly();
	}
	public static void w(ActionCharacter x) {
		x.fight();
	}
	/**
	 * 一定要记住，这个例子所展示的就是使用接口的核心原因：
	 * 为了能够向上转型为多个基类型（以及由此而带来的灵活性）。
	 * 然而使用接口的第二个原因却是与使用抽象基类相同：
	 * 防止客户端程序员创建该类的对象，并确保这仅仅是建立一个接口。
	 * 这就带来了一个问题：我们应该使用接口还是抽象类？
	 * 如果要创建不带任何方法定义和成员变量的基类，那么就应该选择接口而不是抽象类。
	 * 事实上，如果知道某事物应该成为一个基类，那么第一选择应该是使它成为一个接口。
	 * @param args
	 */
	public static void main(String[] args) {
		Hero h = new Hero();
		t(h);
		u(h);
		v(h);
		w(h);
	}
}

interface CanFight {
	void fight();
}

interface CanSwim {
	void swim();
}

interface CanFly {
	void fly();
}

class ActionCharacter {
	public void fight() {
		System.out.println("ActionCharacter.fight()");
	}
}

class Hero extends ActionCharacter implements CanFight, CanSwim, CanFly {

	public void fly() {
		System.out.println("Hero.fly()");
	}

	public void swim() {
		System.out.println("Hero.swim()");
	}
	
}