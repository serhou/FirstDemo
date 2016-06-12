package com.best.innerclasses;


/**
 * 
 * 在匿名类中不可能有命名构造器（因为它根本没有名字）
 * 但是通过实例初始化，就能够达到为匿名内部类创建一个构造器的效果
 * 
 * 在此例中，不要求变量i一定是final的。因为i被传递给匿名类的基类的构造器，
 * 它并不会在匿名内部被直接使用
 * 
 * @author think
 *
 */

public class AnonymousConstructor {

	public static Base getBase(int i){
		return new Base(i) {
			{
				System.out.println("Inside instance initializer");
			}
			@Override
			public void f() {
				System.out.println("In anonymous f()");
			}
		};
	}
	
	public static void main(String[] args) {
		Base base = getBase(56);
		base.f();
	}
}

abstract class Base{
	public Base(int i){
		System.out.println("Base constructor.i = " + i);
	}
	public abstract void f();
}
