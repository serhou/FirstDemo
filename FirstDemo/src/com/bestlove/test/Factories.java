package com.bestlove.test;

/**
 * 接口与工厂
 * 
 * 接口是实现多重继承的途径，而生成遵循某个接口的对象的典型方式就是工厂方法设计模式。
 * 这与直接调用构造器不同，我们在工厂对象上调用的是创建方法，而该工厂对象将生成接口的某个实现的对象。
 * 理论上，通过这种方式，我们的代码将完全与接口的实现分离，这就使得我们可以透明地将某个实现替换为另一个实现。
 * @author think
 *
 */

public class Factories {

	public static void serviceConsumer(ServiceFactory factory) {
		Service s = factory.getService();
		s.method1();
		s.method2();
	}
	public static void main(String[] args) {
		serviceConsumer(new Implementation1Factory());
		serviceConsumer(new Implementation2Factory());
	}
	
}

interface Service {
	void method1();
	void method2();
}

interface ServiceFactory {
	Service getService();
}

class Implementation1 implements Service {
	Implementation1() {
		
	}
	@Override
	public void method1() {
		System.out.println("Implementation1.method1()");
	}
	@Override
	public void method2() {
		System.out.println("Implementation1.method2()");
	}
}
//工厂1
class Implementation1Factory implements ServiceFactory {
	@Override
	public Service getService() {
		return new Implementation1();
	}
}

class Implementation2 implements Service {
	Implementation2() {
		
	}
	@Override
	public void method1() {
		System.out.println("Implementation2.method1()");
	}
	@Override
	public void method2() {
		System.out.println("Implementation2.method2()");
	}
}
//工厂2
class Implementation2Factory implements ServiceFactory {
	@Override
	public Service getService() {
		return new Implementation2();
	}
	
}
