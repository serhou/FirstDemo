package com.bestlove.generics;

public class ErasureAndInheritance {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Derived2 d2 = new Derived2();
		Object obj = d2.get();
		d2.set(obj);//警告在set()被调用时才会出现
	}
	
}

class GenericBase<T> {
	private T element;
	public void set(T arg) {
		arg = element;
	}
	public T get() {
		return element;
	}
}

class Derived1<T> extends GenericBase<T> {}

class Derived2 extends GenericBase {}

