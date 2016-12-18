package com.bestlove.generics;

/**
 * 模板方法
 * @author think
 *
 */

public class CreatorGeneric {
	public static void main(String[] args) {
		
		Creator c = new Creator();
		c.f();
		
	}
}

abstract class GenericWithCreate<T> {
	final T element;
	abstract T create();
	GenericWithCreate() {
		element = create();
	}
}

class X {}

class Creator extends GenericWithCreate<X> {
	X create() {
		return new X();
	}
	void f() {
		System.out.println(element.getClass().getSimpleName());
	}
}