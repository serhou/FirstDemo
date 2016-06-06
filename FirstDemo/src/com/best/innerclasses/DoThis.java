package com.best.innerclasses;

/**
 * 如果需要生成外部类对象的引用，
 * 可以使用外部类的名字后面紧跟圆点和this。
 * 这样产生的引用自动地具有正确的类型。
 * @author think
 *
 */

public class DoThis {

	void f() {
		System.out.println("DoThis.f()");
	}
	
	public class Inner {
		public DoThis outer() {
			return DoThis.this;
		}
	}
	
	public Inner inner() {
		return new Inner();
	}
	
	public static void main(String[] args) {
		DoThis dt = new DoThis();
		DoThis.Inner dti = dt.inner();
		dti.outer().f();
	}
	
}
