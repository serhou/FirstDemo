package com.bestlove.generics;

import java.util.Date;

/**
 * 使用装饰器
 * 装饰器模式是使用分层对象来动态透明地向单个对象中添加责任。
 * 装饰器指定包装在最初的对象周围的所有对象都具有相同的基本
 * 接口。某些事物是可装饰的，可以通过将其他类包装在这个装饰
 * 对象的四周，来将功能分层。
 * 装饰器是通过使用组合和形式化结构（可装饰物/装饰器层次结构）
 * 来实现的，而混型是基于继承的。因此可以将基于参数化类型的混型
 * 当作是一种泛型装饰器机制，这种机制不需要装饰器设计模式的继承
 * 结构。
 * @author think
 *
 */

public class Decoration {
	public static void main(String[] args) {
		TimeStamped2 t = new TimeStamped2(new Basic2());
		TimeStamped2 t2 = new TimeStamped2(
				new SerialNumbered2(new Basic2()));
		SerialNumbered2 s = new SerialNumbered2(new Basic2());
		SerialNumbered2 s2 = new SerialNumbered2(
				new TimeStamped2(new Basic2()));
	}
}

class Basic2 {
	private String value;
	public void set(String val) {
		value = val;
	}
	public String get() {
		return value;
	}
}

class Decorator extends Basic2 {
	protected Basic2 basic2;
	public Decorator(Basic2 basic2) {
		this.basic2 = basic2;
	}
	@Override
	public void set(String val) {
		basic2.set(val);
	}
	@Override
	public String get() {
		return basic2.get();
	}
}

class TimeStamped2 extends Decorator {
	private final long TIME_STAMP;
	public TimeStamped2(Basic2 basic2) {
		super(basic2);
		TIME_STAMP = new Date().getTime();
	}
	public long getStamp() {
		return TIME_STAMP;
	}
}

class SerialNumbered2 extends Decorator {
	private static long counter = 1;
	private final long SERIAL_NUMBER = counter++;
	public SerialNumbered2(Basic2 basic2) {
		super(basic2);
	}
	public long getSerialNumber() {
		return SERIAL_NUMBER;
	}
}

