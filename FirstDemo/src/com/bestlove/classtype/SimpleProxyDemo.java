package com.bestlove.classtype;

/**
 * 简单的代理示例
 * @author think
 *
 */

class SimpleProxyDemo {

	public static void consumer(Interface iface) {
		iface.doSomething();
		iface.somethingElse("bonobo");
	}
	public static void main(String[] args) {
		consumer(new RealObject());
		System.out.println("==================");
		consumer(new SimpleProxy(new RealObject()));
	}
}


interface Interface {
	void doSomething();
	void somethingElse(String arg);
}

class RealObject implements Interface {
	@Override
	public void doSomething() {
		System.out.println("doSomething");
	}
	@Override
	public void somethingElse(String arg) {
		System.out.println("somethingElse " + arg);
	}
}

class SimpleProxy implements Interface {
	private Interface proxied;
	public SimpleProxy(Interface proxied) {
		this.proxied = proxied;
	}

	@Override
	public void doSomething() {
		System.out.println("SimpleProxy doSomething");
		proxied.doSomething();
	}

	@Override
	public void somethingElse(String arg) {
		System.out.println("SimpleProxy somethingElse " + arg);
		proxied.somethingElse(arg);
	}
	
}