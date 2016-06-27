package com.best.innerclasses;


/**
 * 1)内部类可以有多个实例，每个实例都有自己的状态信息，并且与其外围类对象的信息相互独立
 * 2)在单个外围类中，可以让多个内部类以不同的方式实现同一个接口，或继承同一个类。
 * 3)创建内部类对象的时刻并不依赖于外围类对象的创建。
 * 4)内部类并没有令人迷惑的“is-a”关系，它就是一个独立的实体。
 * @author think
 *
 */


public class MultiImplementation {

	static void takesD(D d){
		
	}
	
	static void takesE(E e){
		
	}
	
	public static void main(String[] args) {
	
		Z z = new Z();
		takesD(z);
		takesE(z.makeE());
		z.makeE().e();
		z.d();
		
	}
	
}

class D {
	void d(){
		System.out.println("D.d()");
	}
}

abstract class E {
	void e(){
		System.out.println("E.e()");
	}
}

class Z extends D {
	E makeE() {
		return new E(){
			@Override
			void e() {
				System.out.println("Z.makeE().new E() {...}.e()");
				super.e();
			}
		};
	}
}