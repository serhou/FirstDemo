package com.best.innerclasses;

/**
 * 
 * 现在BigEgg2.Yolk通过extends Egg2.Yolk明确地继承了此内部类，
 * 并且覆盖了其中的方法。insertYolk()方法允许BigEgg2将它自己的
 * Yolk对象向上转型为Egg2中的引用y。所以当g()调用y.f()时，覆盖
 * 后的新版的f()被执行。第二次调用Egg2.Yolk()，结果是BigEgg2.Yolk
 * 的构造器调用了其基类的构造器
 * 
 * @author think
 *
 */


public class BigEgg2 extends Egg2 {

	public class Yolk extends Egg2.Yolk {
		public Yolk() {
			System.out.println("BigEgg2.Yolk.Yolk()");
		}
		public void f() {
			System.out.println("BigEgg2.Yolk.f()");
		}
	}
	public BigEgg2() {
		insertYolk(new Yolk());
	}
	public static void main(String[] args) {
		Egg2 e2 = new BigEgg2();
		e2.g();
	}
	
}

class Egg2 {
	protected class Yolk {
		public Yolk() {
			System.out.println("Egg2.Yolk.Yolk()");
		}
		public void f() {
			System.out.println("Egg2.Yolk.f()");
		}
	}
	private Yolk y = new Yolk();
	public Egg2() {
		System.out.println("Egg2.Egg2()");
	}
	public void insertYolk(Yolk yy) {
		y = yy;
	}
	public void g() {
		y.f();
	}
}
