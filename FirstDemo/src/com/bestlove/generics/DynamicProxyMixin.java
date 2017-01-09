package com.bestlove.generics;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * 可以使用动态代理来创建一种比装饰器更贴近混型模型的机制
 * 由于动态代理的限制，每个被混入的类都必须是某个接口的实现
 * 因为只有动态类型而不是非静态类型才包含所有的混入类型
 * 在具有这些类型的对象上调用方法之前，你被强制要求必须先将这些
 * 对象向下转型到恰当的类型。
 * 为了让Java支持混型，人们已经做了大量的工作朝着这个目标努力，
 * 包括创建了至少一种附加语言（jam语言），它是专门用来支持混型的
 * @author think
 *
 */

public class DynamicProxyMixin {
	public static void main(String[] args) {
		Object mixin = MixinProxy.newInstance(//每个被混入的类都必须是某个接口的实现
				Tuple.tuple(new BasicImp(), Basic.class),
				Tuple.tuple(new TimeStampedImp(), TimeStamped.class),
				Tuple.tuple(new SerialNumberedImp(), SerialNumbered.class));
		Basic b = (Basic) mixin;
		TimeStamped t = (TimeStamped) mixin;
		SerialNumbered s = (SerialNumbered) mixin;
		b.set("Hello");
		System.out.println(b.get());
		System.out.println(t.getStamp());
		System.out.println(s.getSerialNumber());
	}
}

class MixinProxy implements InvocationHandler {
	Map<String, Object> delegatesByMethod;
	public MixinProxy(TwoTuple<Object, Class<?>>... pairs) {
		delegatesByMethod = new HashMap<String, Object>();
		for (TwoTuple<Object, Class<?>> pair : pairs) {
			for (Method method : pair.SECOND.getMethods()) {
				String methodName = method.getName();
				if (!delegatesByMethod.containsKey(methodName)) {
					delegatesByMethod.put(methodName, pair.FIRST);
				}
			}
		}
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		String methodName = method.getName();
		Object delegate = delegatesByMethod.get(methodName);
		return method.invoke(delegate, args);
	}
	@SuppressWarnings("unchecked")
	public static Object newInstance(TwoTuple... pairs) {
		Class[] interfaces = new Class[pairs.length];
		for (int i = 0; i < pairs.length; i++) {
			interfaces[i] = (Class) pairs[i].SECOND;
		}
		ClassLoader cl = pairs[0].FIRST.getClass().getClassLoader();
		return Proxy.newProxyInstance(cl, interfaces, new MixinProxy(pairs));
	}
}