package com.best.innerclasses;

/**
 * 在拥有外部类对象之前是不可能创建内部类对象的。
 * 这是因为内部类对象会暗暗地连接到创建它的外部类对象上。
 * 但是，如果你创建的是嵌套类（静态内部类），那么它就
 * 不需要外部类对象的引用。（可以参考静态方法）
 * @author think
 *
 */

public class Parcel3 {

	class Contents {
		private int i = 11;
		public int value() {
			return i;
		}
	}
	
	class Destination {
		private String label;
		public Destination(String whereTo) {
			label = whereTo;
		}
		String readLabel() {
			return label;
		}
	}
	
	public static void main(String[] args) {
		Parcel3 p = new Parcel3();
		Parcel3.Contents c = p.new Contents();
		Parcel3.Destination d = p.new Destination("Tasmania");
		System.out.println(c.value());
		System.out.println(d.readLabel());
	}
}
