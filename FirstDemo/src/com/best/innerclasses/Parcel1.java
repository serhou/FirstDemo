package com.best.innerclasses;

/**
 * 我们可以将一个类的定义放在另一个类的定义内部，这就是内部类。
 * 
 * 内部类和组合是完全不同的概念
 * 
 * 内部类看起来就像是一种代码隐藏机制：将类置于其他类的内部。但是，
 * 内部类远不止于此，它了解外围类，并能与之通信，而且你用内部类写
 * 出的代码更加优雅而清晰，尽管并不总是这样。
 * 
 * 内部类是为了语言的完备性而设计的，但是你也许不需要使用它们，至少
 * 一开始不需要。
 * 
 * @author think
 *
 */

public class Parcel1 {
	//内部类
	class Contents {
		private int i = 11;
		public int value() {
			return i;
		}
	}
	//内部类
	class Destination {
		private String label;
		Destination(String whereTo) {
			label = whereTo;
		}
		String readLabel() {
			return label;
		}
	}
	
	public void ship(String dest) {
		//方法中生成内部类对象
		Contents c = new Contents();
		Destination d = new Destination(dest);
		System.out.println(d.readLabel()+"+"+c.value());
	}
	
	public static void main(String[] args) {
		Parcel1 p = new Parcel1();
		p.ship("Tasmania");
	}
}
