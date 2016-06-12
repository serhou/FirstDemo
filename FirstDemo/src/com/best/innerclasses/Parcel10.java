package com.best.innerclasses;

/**
 * 
 * 对于匿名类而言，实例初始化的实际效果就是构造器。
 * 当然它受到了限制——你不能重载实例初始化方法，所以你仅有一个这样的构造器
 * 
 * 匿名内部类与正规的继承相比有些受限，因为匿名内部类既可以扩展类，也可以实现接口，
 * 但是不能两者兼备。而且如果是实现接口，只能实现一个接口。
 * 
 * @author think
 *
 */

public class Parcel10 {

	public Destination destination(final String dest, final float price){
		return new Destination() {
			private int cost;
			{
				cost = Math.round(price);
				if(cost > 100){
					System.out.println("Over budget!");
				}
			}
			private String label = dest;
			@Override
			public String readLabel() {
				return label;
			}
		};
	}
	public static void main(String[] args) {
		Parcel10 p = new Parcel10();
		Destination d = p.destination("Tasmania", 102.384F);
		System.out.println(d.readLabel());
	}
	
}
