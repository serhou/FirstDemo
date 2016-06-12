package com.best.innerclasses;


/**
 * 
 * 在匿名类中定义字段时，还能够对其执行初始化操作
 * 
 * 如果定义一个匿名内部类，并且希望它使用一个在其外部定义的对象，
 * 那么编译器会要求其参数引用时final的。
 * 
 * @author think
 *
 */

public class Parcel9 {

	public Destination destination(final String dest){
		return new Destination() {
			private String label = dest;
			@Override
			public String readLabel() {
				return label;
			}
		};
	}
	public static void main(String[] args) {
		Parcel9 parcel9 = new Parcel9();
		Destination d = parcel9.destination("Tasmania");
		System.out.println(d.readLabel());
	}
	
}
