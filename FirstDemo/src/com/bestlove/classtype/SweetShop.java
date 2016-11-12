package com.bestlove.classtype;

/**
 * 类加载器
 * @author think
 *
 */

public class SweetShop {

	public static void main(String[] args) {
		
		System.out.println("inside main");
		
		new Candy();
		System.out.println("After creating Candy");
		try {
			Class.forName("Gum");//类加载器，反射的错误打开方式
		} catch (ClassNotFoundException e) {
			System.out.println("Couldn't find Gum");
		}
		System.out.println("After Class.forName(\"Gum\")");
		new Cookie();
		System.out.println("After creating Cookie");
		try {
			Class.forName("com.bestlove.classtype.Gum");//反射的正确打开方式
		} catch (ClassNotFoundException e) {
			System.out.println("Couldn't find com.bestlove.classtype.Gum");
		}
		System.out.println("After creating Gum");
	}
	
}


class Candy {
	//static 子句在类第一次被加载时执行
	static {
		System.out.println("Loading Candy");
	}
}

class Gum {
	//Class对象仅在需要的时候才被加载，static初始化是在类加载时进行的
	static {
		System.out.println("Loading Gum");
	}
}

class Cookie {
	static {
		System.out.println("Loading Cookie");
	}
}