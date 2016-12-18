package com.bestlove.generics;

public class ClassTypeCapture<T> {

	Class<T> kind;
	public ClassTypeCapture(Class<T> kind) {
		this.kind = kind;
	}
	public boolean f(Object arg) {
		return kind.isInstance(arg);
	}
	/**
	 * 编译器将确保类型标签可以匹配泛型参数
	 * @param args
	 */
	public static void main(String[] args) {
		
		ClassTypeCapture<Building> ctt1 = new ClassTypeCapture<Building>(Building.class);
		System.out.println(ctt1.f(new Building()));
		System.out.println(ctt1.f(new House()));
		ClassTypeCapture<House> ctt2 = new ClassTypeCapture<House>(House.class);
		System.out.println(ctt2.f(new Building()));
		System.out.println(ctt2.f(new House()));
	}
	
}

class Building {}
class House extends Building {}
