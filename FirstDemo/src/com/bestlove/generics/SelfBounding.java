package com.bestlove.generics;


/**
 * 自限定：自己限定自己
 * 自限定要做的，就是要求在继承关系中，想下面这样使用这个类：
 * class A extends SelfBounded<A> {}
 * 这会强制要求将正在定义的类当作参数传递给基类
 * 自限定的参数有何意义呢？它可以保证类型参数必须与正在被定义的类相同
 * 但遗憾的是，F可以编译，不会有任何警告，因此自限定惯用法不是强制执行的。
 * 如果它确实很重要，可以要求一个外部工具来确保不会使用原生类型来代替参数化类型
 * @author think
 *
 */


public class SelfBounding {
	public static void main(String[] args) {
		A a = new A();
		a.set(new A());
		a = a.set(new A()).get();
		a = a.get();
		C c = new C();
		c = c.setAndGet(new C());
	}
}

class SelfBounded<T extends SelfBounded<T>> {
	T element;
	SelfBounded<T> set(T arg) {
		element = arg;
		return this;
	}
	T get() {
		return element;
	}
}

class A extends SelfBounded<A> {}

class B extends SelfBounded<B> {}

class C extends SelfBounded<C> {
	C setAndGet(C arg) {
		set(arg);
		return get();
	}
}

class D {}

//class E extends SelfBounded<D> {}

class F extends SelfBounded {}