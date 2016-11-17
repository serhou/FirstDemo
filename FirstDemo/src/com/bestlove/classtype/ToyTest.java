package com.bestlove.classtype;

public class ToyTest {

	static void printInfo(Class<?> cc){
		System.out.println("Class name: " + cc.getName() + 
				" is interface ? [" + cc.isInterface() + "]");
		System.out.println("Simple name:" + cc.getSimpleName());
		System.out.println("Canonical name:" + cc.getCanonicalName());//标准名称
	}
	public static void main(String[] args) {
		
		Class<?> c = null;
		
		try {
			c = Class.forName("com.bestlove.classtype.FancyToy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		printInfo(c);
		
		for (Class<?> face : c.getInterfaces()) {
			printInfo(face);
		}
		
		Class<?> up = c.getSuperclass();//可以查询直接基类
		Object obj = null;
		try {
			obj = up.newInstance();//创建对象
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		printInfo(obj.getClass());
	
	}
	
}

interface HasBatteries {}
interface Waterproof {}
interface Shoots {}

class Toy {
	Toy() {}
	Toy(int i) {}
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
	FancyToy() {
		super(1);
	}
}

