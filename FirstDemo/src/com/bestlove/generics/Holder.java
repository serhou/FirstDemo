package com.bestlove.generics;

public class Holder<T> {

	private T value;
	public Holder() {};
	public Holder(T val) {
		value = val;
	}
	public void set(T val) {
		value = val;
	}
	public T get() {
		return value;
	}
	public boolean equals(Object obj) {
		return value.equals(obj);
	}
	
	public static void main(String[] args) {
		
		Holder<Apple> apple = new Holder<Apple>(new Apple());
		Apple d = apple.get();
		apple.set(d);
//		Holder<Fruit> fruit0 = apple;//Error
		Holder<? extends Fruit> fruit = apple;
		Fruit p = fruit.get();
		d = (Apple) fruit.get();
		System.out.println(p.equals(d));
		try {
			Orange c = (Orange) fruit.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
//		fruit.set(new Apple());
//		fruit.set(new Fruit());
		System.out.println(fruit.equals(d));//value.equal(obj);
	}
	
}
