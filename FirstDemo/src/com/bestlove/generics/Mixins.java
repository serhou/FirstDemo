package com.bestlove.generics;

import java.util.Date;

/**
 * 与接口混合
 * Mixin类基本上是在使用代理，因此每个混入类型都要求在Mixin中
 * 有一个相应的域，而你必须在Mixin中编写所有必需的方法，将方法
 * 调用转发给恰当的对象。
 * @author think
 *
 */

public class Mixins {
	public static void main(String[] args) {
		Mixin mixin1 = new Mixin(), mixin2 = new Mixin();
		mixin1.set("test string 1");
		mixin2.set("test string 2");
		System.out.println(mixin1.get() + " " 
		+ mixin1.getStamp() +" " 
				+ mixin1.getSerialNumber());
		System.out.println(mixin2.get() + " " 
				+ mixin2.getStamp() +" " 
						+ mixin2.getSerialNumber());
	}
}

interface TimeStamped {
	long getStamp();
}

class TimeStampedImp implements TimeStamped {
	private final long TIME_STAMP;
	public TimeStampedImp() {
		TIME_STAMP = new Date().getTime();
	}
	@Override
	public long getStamp() {
		return TIME_STAMP;
	}
}

interface SerialNumbered {
	long getSerialNumber();
}

class SerialNumberedImp implements SerialNumbered {
	private static long counter = 1;
	private final long SERIAL_NUMBER = counter++;
	@Override
	public long getSerialNumber() {
		return SERIAL_NUMBER;
	}
}

interface Basic {
	public void set(String val);
	public String get();
}

class BasicImp implements Basic {
	private String value;
	@Override
	public void set(String val) {
		value = val;
	}
	@Override
	public String get() {
		return value;
	}
}

class Mixin extends BasicImp implements TimeStamped, SerialNumbered {
	private TimeStamped timeStamp = new TimeStampedImp();
	private SerialNumbered serialNumbered = new SerialNumberedImp();
	@Override
	public long getSerialNumber() {
		return serialNumbered.getSerialNumber();
	}
	@Override
	public long getStamp() {
		return timeStamp.getStamp();
	}
}