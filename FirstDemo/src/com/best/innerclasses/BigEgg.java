package com.best.innerclasses;

/**
 * 默认的构造器时编译器自动生成的，这里调用基类的默认构造器
 * 当继承了某个外围类的时候，内部类并没有发生什么特别神奇的变化。
 * 这两个内部类是完全独立的两个实体，各自在自己的命名空间内。
 * 
 * @author think
 *
 */


public class BigEgg extends Egg {

	public class Yolk {
		public Yolk() {
			System.out.println("BigEgg.Yolk.Yolk()");
		}
	}
	
	public static void main(String[] args) {
		BigEgg bigEgg = new BigEgg();  //父类的内部类未被子类的内部类覆盖
		bigEgg.new Yolk(); //子类的构造器
	}
	
}

class Egg {
	private Yolk y;
	protected class Yolk {
		public Yolk() {
			System.out.println("Egg.Yolk.Yolk()");
		}
	}
	public Egg() {
		System.out.println("Egg.Egg()");
		y = new Yolk();
	}
	
}

