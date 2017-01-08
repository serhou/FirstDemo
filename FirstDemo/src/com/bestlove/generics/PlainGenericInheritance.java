package com.bestlove.generics;

/**
 * DerivedGS包含两个set()的重载版本。如果不使用自限定，将重载参数类型
 * 如果使用了自限定，只能获得某个方法的一个版本
 * @author think
 *
 */

public class PlainGenericInheritance {
	public static void main(String[] args) {
		Base base = new Base();
		Derived derived = new Derived();
		DerivedGS dgs = new DerivedGS();
		dgs.set(derived);
		dgs.set(base);//Compiles: overloaded, not overridden!
	}
}

class GenericSetter<T> {//Not self-bounded
	void set(T arg) {
		System.out.println("GenericSetter.set(Base)");
	}
}

class DerivedGS extends GenericSetter<Base> {
	void set(Derived derived) {
		System.out.println("DerivedGS.set(Derived)");
	}
}