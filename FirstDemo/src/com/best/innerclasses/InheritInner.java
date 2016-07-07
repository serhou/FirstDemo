package com.best.innerclasses;


/**
 * 
 * 内部类的继承
 * 
 * @author think
 *
 */


public class InheritInner extends WithInner.Inner {

	InheritInner(WithInner wi) {
		wi.super();
	}
	
	public static void main(String[] args) {
		
		WithInner wi = new WithInner();  //创建外围类的对象
		InheritInner ii = new InheritInner(wi);  //传递一个指向外围类对象的引用给构造器
		ii.why();  //继承了内部类的why()方法
	}
	
}

class WithInner {
	
	void what() {
		System.out.println("WithInner.what()");
	}
	
	class Inner {
		void why() {
			System.out.println("WithInner.Inner.why()");
		}
	}
}
