package com.best.innerclasses;


/**
 * 
 * 至此，我们已经看到了许多描述内部类的语法和语义，但是这并不能回答
 * “为什么需要内部类”这个问题。那么，SUN公司为什么会如此费心地增加这项基本的语言特性呢？
 * 
 * 一般说来，内部类继承自某个类或实现某个接口，内部类的代码操作创建它的外围类的对象。
 * 所以可以认为内部类提供了某种进入其外围类的窗口。
 * 
 * 内部类必须要回答的一个问题是：如果只是需要一个对接口的引用，为什么不通过外围类实现那个接口呢？
 * 答案是：“如果这能满足需求，那么就应该这样做。”那么内部类实现一个接口与外围类实现这个接口有什么区别呢？
 * 答案是：后者不是总能享用到接口带来的方便，有时需要用到接口的实现。所以，使用内部类最吸引人的原因是：
 * 
 * 每个内部类都能独立地继承自一个（接口的）实现，所以无论外围是否已经继承了某个（接口的）实现，对于内部类都没有影响。
 * 
 * 如果没有内部类提供的、可以继承多个具体的或抽象的类的能力，一些设计与编程问题就很难解决。
 * 从这个角度看，内部类使得多重继承的解决方案变得完整。接口解决了部分问题，而内部类有效地实现了“多重继承”。
 * 也就是说，内部类允许继承多个非接口类型。
 * 
 * @author think
 *
 */


public class MultiInterfaces {
	
	static void takesA(A a) {
		a.a();
	}
	
	static void takesB(B b) {
		b.b();
	}
	
	public static void main(String[] args) {
		X x = new X();
		Y y = new Y();
		takesA(x);
		takesA(y);
		takesB(x);
		takesB(y.makeB());
		y.makeB().b();
	}

}

interface A {
	void a();
}

interface B {
	void b();
}

class X implements A, B {

	@Override
	public void b() {
		System.out.println("X.b()");
	}

	@Override
	public void a() {
		System.out.println("X.a()");
	}
	
}

class Y implements A {
	B makeB() {
		return new B(){
			@Override
			public void b() {
				System.out.println("Y.makeB().new B() {...}.b()");
			}
			
		};
	}

	@Override
	public void a() {
		System.out.println("Y.a()");
	}
}
