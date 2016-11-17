package com.bestlove.classtype;

import java.util.Random;

/**
 * 
 * “.class”来创建对Class对象的引用时，不会自动地初始化该Class对象。需要三个步骤：
 * 1.加载	2.链接	3.初始化
 * 
 * 初始化有效地实现了尽可能的“惰性”，从对initable引用的创建中可以看到，
 * 仅使用.class语法来获得对类的引用不会引发初始化。但是，为了产生Class引用，
 * Class.forName()立即就进行了初始化，就像在对initable3引用的创建中所看到的
 * 
 * @author think
 *
 */


public class ClassInitialization {
	public static Random rand = new Random(68);
	public static void main(String[] args) throws ClassNotFoundException {
		Class<?> initable = Initable.class;//没有初始化
		System.out.println("After creating Initable ref");
		System.out.println(Initable.STATIC_FINAL);//“编译期常量”，不需要对Initable类进行初始化就可以被读取
		System.out.println(Initable.STATIC_FINAL2);//不是编译期常量，强制进行类的初始化
		System.out.println(Initable2.staticNonFinal);//在被读取前，先进行链接（为这个域分配存储空间）和初始化（初始化该存储空间）
		Class<?> initable3 = Class.forName("com.bestlove.classtype.Initable3");//首先初始化
		System.out.println("After creating Initable3 ref");
		System.out.println(Initable3.staticNonFinal);
	}

}

class Initable {
	static final int STATIC_FINAL = 47;
	static final int STATIC_FINAL2 = ClassInitialization.rand.nextInt(1000);
	static {
		System.out.println("Initializing Initable");
	}
}

class Initable2 {
	static int staticNonFinal = 147;
	static {
		System.out.println("Initializing Initable2");
	}
}

class Initable3 {
	static int staticNonFinal = 74;
	static {
		System.out.println("Initializing Initable3");
	}
}