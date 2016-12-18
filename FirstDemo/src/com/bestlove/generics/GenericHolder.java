package com.bestlove.generics;

/**
 * 与SimpleHolder对比
 * javap -c GenericHolder > GenericHolder.log
 * 
 * 所产生的字节码是相同的
 * @author think
 *
 * @param <T>
 */

public class GenericHolder<T> {

	private T obj;
	public void set(T obj) {
		this.obj = obj;
	}
	public T get() {
		return obj;
	}
	
	public static void main(String[] args) {
		
		GenericHolder<String> holder = new GenericHolder<String>();
		holder.set("Item");
		String s = holder.get();//无需转型
		System.out.println(s);
		
	}
}
