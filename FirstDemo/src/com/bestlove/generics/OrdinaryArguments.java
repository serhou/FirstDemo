package com.bestlove.generics;

/**
 * set(derived)和set(base)都是合法的，因此DerivedSetter.set()
 * 没有覆盖OrdinarySetter.set()，而是重载了这个方法。
 * @author think
 *
 */

public class OrdinaryArguments {
	public static void main(String[] args) {
		Base base = new Base();
		Derived derived = new Derived();
		DerivedSetter ds = new DerivedSetter();
		ds.set(derived);
		ds.set(base);//Compiles: overloaded, not overridden!
		
	}
}

class OrdinarySetter {
	void set(Base base) {
		System.out.println("OrdinarySetter.set(Base)");
	}
}

class DerivedSetter extends OrdinarySetter {
	void set(Derived derived) {//重载
		System.out.println("DerivedSetter.set(Derived)");
	}
}