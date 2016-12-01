package com.bestlove.generics;

import java.util.Date;

/**
 * 泛型方法
 * 一个基本指导原则：
 * 无论何时，只要你能做到，你就应该尽量使用泛型方法。
 * 也就是说，如果使用泛型方法可以取代将整个类泛型话，
 * 那么就应该只使用泛型方法，因为它可以使事情更清楚明白
 * @author think
 *
 */

public class GenericMethods {

	public <T> void f(T t) {
		System.out.println(t.getClass().getName());
	}
	
	public static void main(String[] args) {
		
		GenericMethods gm = new GenericMethods();
		gm.f("");
		gm.f(1);
		gm.f(1.0);
		gm.f(1.2F);
		gm.f('c');
		gm.f(gm);
		gm.f(new Date());
	}
	
}
