package com.bestlove.classtype;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 在任何时刻，只要你想要将额外的操作从“实际”对象中分离到不同的地方，
 * 特别是当你希望能够很容易地做出修改，从没有使用额外操作转为使用这些操作，
 * 或者反过来时，代理就显得很有用。（设计模式的关键就是封装修改——因此你需要
 * 修改事务以证明这种模式的正确性）。
 * 
 * 通过调用静态方法Proxy.newProxyInstance()可以创建动态代理，这个方法需要得到
 * 一个类加载器（你通常可以从已经被加载的对象中获取其类加载器，然后传递给它），
 * 一个你希望该代理实现的接口列表（不是类或抽象类），以及InvocationHandler接口
 * 的一个实现。
 * Method.invoke()将请求转发给被代理对象，并传入必须的参数
 * @author think
 *
 */

class SelectingMethods {

	public static void main(String[] args) {
		
		SomeMethods proxy = (SomeMethods) Proxy.newProxyInstance(
				SomeMethods.class.getClassLoader(), 
				new Class[]{SomeMethods.class}, 
				new MethodSelector(new Implementation()));
		proxy.boring1();
		proxy.boring2();
		proxy.interesting("bonobo");
		proxy.boring3();
	}
	
}

class MethodSelector implements InvocationHandler {
	private Object proxied;
	public MethodSelector(Object proxied) {
		this.proxied = proxied;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		if (method.getName().equals("interesting")) {
			System.out.println("Proxy detected the interesting method");
		}
		return method.invoke(proxied, args);
	}
}

interface SomeMethods {
	void boring1();
	void boring2();
	void interesting(String arg);
	void boring3();
}

class Implementation implements SomeMethods {

	@Override
	public void boring1() {
		System.out.println("Implementation.boring1()");
	}

	@Override
	public void boring2() {
		System.out.println("Implementation.boring2()");
	}

	@Override
	public void interesting(String arg) {
		System.out.println("Implementation.interesting() " + arg);
	}

	@Override
	public void boring3() {
		System.out.println("Implementation.boring3()");
	}
	
}