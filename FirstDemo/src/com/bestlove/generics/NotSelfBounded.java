package com.bestlove.generics;

/**
 * 移除自限定这个限制，这样所有的类仍旧是可以编译的
 * 因此很明显，自限定限制只能强制作用于继承关系。
 * 如果使用自限定，就应该了解这个类所用的类型参数将
 * 使用这个参数的类既有相同的基本类型。这会强制要求
 * 使用这个类的每个人都要遵循这种形式
 * @author think
 *
 * @param <T>
 */

public class NotSelfBounded<T> {
	T element;
	NotSelfBounded<T> set(T arg) {
		element = arg;
		return this;
	}
	T get() {
		return element;
	}
}

class A2 extends NotSelfBounded<A2> {}
class B2 extends NotSelfBounded<A2> {}

class C2 extends NotSelfBounded<C2> {
	C2 setAndGet(C2 arg) {
		set(arg);
		return get();
	}
}

class D2 {}
class E2 extends NotSelfBounded<D2> {}

