package com.bestlove.test;


/**
 * 静态方法是与类，而并非与单个的对象相关联的
 * @author think
 *
 */

public class StaticPolymorphism {

	public static void main(String[] args) {
		
		StaticSuper sup = new StaticSub();
		System.out.println(sup.staticGet()); //这种调用方法被提示使用静态方法的调用方式：Base staticGet()
		System.out.println(StaticSuper.staticGet()); //静态方法的调用：Base staticGet()
		System.out.println(StaticSub.staticGet()); //静态方法的调用：Derived staticGet()
		System.out.println(sup.dynamicGet()); //Derived dynamicGet()
	}
	
}

class StaticSuper {
	public static String staticGet() {
		return "Base staticGet()";
	}
	public String dynamicGet() {
		return "Base dynamicGet()";
	}
}

class StaticSub extends StaticSuper {
	public static String staticGet() {
		return "Derived staticGet()";
	}
	public String dynamicGet() {
		return "Derived dynamicGet()";
	}
}