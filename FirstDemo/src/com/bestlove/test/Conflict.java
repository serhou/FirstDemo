package com.bestlove.test;

/**
 * 组合接口时的名字冲突
 * 
 * 在打算组合的不同接口中使用相同的方法名通常会造成代码可读性的混乱，
 * 请尽量避免这种情况。
 * 
 * @author think
 *
 */

public class Conflict {

}

interface I1 {
	void f();
}

interface I2 {
	int f(int i);
}

interface I3 {
	int f();
}

class C {
	public int f() {
		return 1;
	}
}

class C2 implements I1, I2 {
	public int f(int i) {
		return 2;
	}
	public void f() {
		System.out.println("C2.f()");
	}
}

class C3 extends C implements I3 {
	public int f(int i) {
		return 3;
	}
}

class C4 extends C implements I3 {
	public int f() {
		return 4;
	}
}
/**
 * 此时困难来了，因为覆盖、实现和重载令人不快地搅在一起，而且重载方法
 * 仅通过返回类型是区分不开的。当撤销下面两行的注释时，编译器就会放生错误
 */
//class C5 extends C implements I1 {}
//interface I4 extends I1, I3 {}

