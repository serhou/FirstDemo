package com.bestlove.generics;

/**
 * 基类用导出类替代其参数
 * 在所产生的类中将使用确切类型而不是基类型。
 * 因此，在Subtype中，传递给set()的参数和从get()
 * 返回的类型都是确切的Subtype
 * @author think
 *
 */
public class CRGWithBasicHolder {

	public static void main(String[] args) {
		
		Subtype st1 = new Subtype(), st2 = new Subtype();
		st1.set(st2);
		Subtype st3 = st1.get();
		st1.f();
//		st3.f();//java.lang.NullPointerException st2没有set值，所以element为null
	}
	
}

class Subtype extends BasicHolder<Subtype> {}

class BasicHolder<T> {
	T element;
	void set(T arg) {
		element = arg;
	}
	T get() {
		return element;
	}
	void f() {
		System.out.println(element.getClass().getSimpleName());
	}
}