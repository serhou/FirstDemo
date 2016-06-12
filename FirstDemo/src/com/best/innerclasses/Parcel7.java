package com.best.innerclasses;

/**
 * 
 * 匿名内部类
 * 
 * @author think
 *
 */

public class Parcel7 {

	public Contents contents(){
		return new Contents() {
			private int i = 12;
			@Override
			public int value() {
				return i;
			}
		};
	}
	
	public static void main(String[] args) {
		Parcel7 parcel7 = new Parcel7();
		Contents c = parcel7.contents();
		System.out.println(c.value());
	}
	
}
