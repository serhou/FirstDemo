package com.bestlove.test;

/**
 * 通过继承来扩展接口
 * 
 * DangerousMonster是Monster的直接扩展，它产生了一个新的接口
 * DragonZilla中实现了这个接口。
 * 
 * 在Vampire中使用的语法仅适用于接口继承。一般情况下，只可以将
 * extends用于单一类，但是可以引用多个基类接口。就像所看到的，
 * 只需用逗号将接口名一一分隔开即可。
 * 
 * @author think
 *
 */

public class HorrorShow {
	static void u(Monster b) {
		b.menace();
	}
	static void v(DangerousMonster d) {
		d.menace();
		d.destroy();
	}
	static void w(Lethal l) {
		l.kill();
	}
	public static void main(String[] args) {
		DangerousMonster barney = new DragonZilla();
		u(barney);
		v(barney);
		Vampire vlad = new VeryBadVampire();
		u(vlad);
		v(vlad);
		w(vlad);
	}
}

interface Monster {
	void menace();
}

interface DangerousMonster extends Monster {
	void destroy();
}

interface Lethal {
	void kill();
}

class DragonZilla implements DangerousMonster {
	public void menace() {
		System.out.println("DragonZilla.menace()");
	}
	public void destroy() {
		System.out.println("DragonZilla.destroy()");
	}
}
//接口可以同时继承多个接口,但是只能继承一个类
interface Vampire extends DangerousMonster, Lethal {
	void drinkBlood();
}

class VeryBadVampire implements Vampire {
	public void destroy() {
		System.out.println("VeryBadVampire.destroy()");
	}
	public void menace() {
		System.out.println("VeryBadVampire.menace()");
	}
	public void kill() {
		System.out.println("VeryBadVampire.kill()");
	}
	public void drinkBlood() {
		System.out.println("VeryBadVampire.drinkBlood()");
	}
	
}