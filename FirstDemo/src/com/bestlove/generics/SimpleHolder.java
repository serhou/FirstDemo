package com.bestlove.generics;

/**
 * 与GenericHolder对比
 * javap -c SimpleHolder > SimpleHolder.log
 * @author think
 *
 */

public class SimpleHolder {

	private Object obj;
	public void set(Object obj) {
		this.obj = obj;
	}
	public Object get() {
		return obj;
	}
	
	public static void main(String[] args) {
		
		SimpleHolder holder = new SimpleHolder();
		holder.set("Item");
		String s = (String) holder.get();//需要转型
		System.out.println(s);
	}
	
}
