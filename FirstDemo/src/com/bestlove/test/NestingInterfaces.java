package com.bestlove.test;

/**
 * 在类中嵌套接口的语法是相当显而易见的，就像非嵌套接口一样，可以拥有public 和包访问 两种可视性
 * 作为一种新添加的方式，接口也可以被实现为private的，就像在A.D中看到的（相同的语法既适用于嵌套接口，
 * 也适用于嵌套类）。那么private的嵌套接口能带来什么好处呢？
 * 你可能会认为，它只能够被实现为DImp中的一个private内部类，但是A.DImp2展示了它同样可以被实现为public类，
 * 但是，A.DImp2只能被其自身所使用。你无法说它实现了一个private接口D。
 * 因此，实现一个private接口只是一种方式，它可以强制该接口中的方法定义不要添加任何类型信息（也就是说不允许向上转型）
 * 
 * getD()方法使我们陷入了一个进退两难的境地，这个问题与private接口相关：
 * 它是一个返回对private接口的引用的public方法。你对这个方法的返回值能做些什么呢？
 * 在main()中，可以看到数次尝试使用返回值的行为都失败了。只有一种方式可以成功。那就是将返回值交给有权使用它的对象。
 * 在本例中，是A通过receiveD()方法来实现的。
 * 
 * 接口E说明接口彼此之间也可以嵌套，然而，作用于接口的各种规则，特别是所有的接口元素都必须是public的，在此都会被
 * 严格的执行。因此，嵌套在另一个接口中的接口自动就是public的，而不能声明为private的。
 * 
 * NestingInterfaces展示了嵌套接口的各种实现方式。特别要注意的是，当实现某个接口时，并不需要实现嵌套在其内部的任何接口。
 * 而且，private接口不能在定义它的类之外被实现。
 * 
 * 添加这些特性的最初原因可能是出于严格的语法一致性的考虑。但是，我总认为。一旦你了解了某种特性，就总能够找到它的用武之地。
 * @author think
 *
 */

public class NestingInterfaces {

	public class BImp implements A.B {
		@Override
		public void f() {
			System.out.println("NestingInterfaces.BImp.f()");
		}
	}
	
	class CImp implements A.C {
		@Override
		public void f() {
			System.out.println("NestingInterfaces.CImp.f()");
		}
	}
	
//	class DImp implements A.D {} //无法实现私有化接口
	
	class EImp implements E {
		@Override
		public void g() {
			System.out.println("NestingInterfaces.EImp.g()");
		}
	}
	
	class EGImp implements E.G {
		@Override
		public void f() {
			System.out.println("NestingInterfaces.EGImp.f()");
		}
	}
	
	class EHImp implements E.H {
		@Override
		public void f() {
			System.out.println("NestingInterfaces.EHImp.f()");
		}
	}
	
	class EImp2 implements E {
		@Override
		public void g() {
			System.out.println("NestingInterfaces.EImp2.g()");
		}
		class EG implements E.G {
			@Override
			public void f() {
				System.out.println("NestingInterfaces.EImp2.EG.f()");
			}
		}
	}
	
	public static void main(String[] args) {
		A a = new A();
//		A.D = a.getD(); //A.D私有用不了
//		A.DImp2 = a.getD(); // a.getD()返回的是A.D类型私有；
//		a.getD().f(); //私有无法访问f()方法
		a.receiveD(a.getD());  //A.DImp2.f()
		
	}
}

class A {
	//内部接口
	interface B {
		void f();
	}
	//内部类
	public class BImp implements B {
		@Override
		public void f() {
			System.out.println("A.BImp.f()");
		}
	}
	private class BImp2 implements B {
		@Override
		public void f() {
			System.out.println("A.BImp2.f()");
		}
	}
	
	
	public interface C {
		void f();
	}
	class CImp implements C {
		@Override
		public void f() {
			System.out.println("A.CImp.f()");
		}
	}
	private class CImp2 implements C {
		@Override
		public void f() {
			System.out.println("A.CImp2.f()");
		}
	}
	
	
	private interface D {
		void f();
	}
	private class DImp implements D {
		@Override
		public void f() {
			System.out.println("A.DImp.f()");
		}
	}
	public class DImp2 implements D {
		@Override
		public void f() {
			System.out.println("A.DImp2.f()");
		}
	}
	public D getD() {
		return new DImp2();
	}
	private D dRef;
	public void receiveD(D d) {
		dRef = d;
		dRef.f();
	}
}

interface E {
	interface G {
		void f();
	}
	public interface H {
		void f();
	}
	void g();
//	private interface I {} //接口中的接口私有化没有意义
}