package com.bestlove.test;

/**
 * 使用计数器来跟踪仍旧访问着共享对象的对象数量
 * @author think
 *
 */

public class ReferenceCounting {

	public static void main(String[] args) {
		Shared shared = new Shared();
		Composing[] composings = {new Composing(shared), 
				new Composing(shared),
				new Composing(shared),
				new Composing(shared),
				new Composing(shared)};
		for (Composing composing : composings) {
			composing.dispose();
		}
		
	/*	结果
		Creating Shared 0
		Creating Composing 0
		Creating Composing 1
		Creating Composing 2
		Creating Composing 3
		Creating Composing 4
		disposing Composing 0
		disposing Composing 1
		disposing Composing 2
		disposing Composing 3
		disposing Composing 4
		Disposing Shared 0*/
	}
	
}

class Shared {
	private int refcount = 0;
	private static long counter = 0; //跟踪所创建的Shared的实例数量，还可以为id提供值, long类型防止溢出
	private final long id = counter++; //id是final的，因为我们不希望它的值在对象生命周期中被改变
	public Shared() {
		System.out.println("Creating " + this);
	}
	public void addRef() {
		refcount++;
	}
	protected void dispose() {
		if(--refcount == 0) {
			System.out.println("Disposing " + this);
		}
	}
	public String toString() {
		return "Shared " + id;
	}
}

class Composing {
	private Shared shared;
	private static long counter = 0;
	private final long id = counter++;
	public Composing(Shared shared) {
		System.out.println("Creating " + this);
		this.shared = shared;
		this.shared.addRef();
		/**
		 * 在将一个共享对象附着到类上时，必须记住调用addRef(),但是dispose()方法将跟踪引用数，
		 * 并决定何时执行清理。使用这种技巧需要加倍地细心，但是如果你正在共享需要清理的对象，
		 * 那么你就没有太多的选择余地了。
		 */
	}
	protected void dispose() {
		System.out.println("disposing " + this);
		shared.dispose();
	}
	public String toString() {
		return "Composing " + id;
	}
}
