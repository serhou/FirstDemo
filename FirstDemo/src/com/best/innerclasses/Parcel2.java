package com.best.innerclasses;

/**
 * 外部类可以有一个方法，返回一个指向内部类的引用。
 * @author think
 *
 */

public class Parcel2 {

	class Contents {
		private int i = 324;
		public int value() {
			return i;
		}
	}
	
	class Destination {
		private String label;
		Destination(String whereTo) {
			label = whereTo;
		}
		String readLabel() {
			return label;
		}
	}
	
	public Destination to(String s){
		return new Destination(s);
	}
	
	public Contents contents() {
		return new Contents();
	}
	
	public void ship(String dest) {
		Contents c = contents();
		Destination d = to(dest);
		System.out.println(d.readLabel()+"+"+c.value());
	}
	public static void main(String[] args) {
		Parcel2 p = new Parcel2();
		p.ship("Tasmania");
		Parcel2 p2 = new Parcel2();
		/**
		 * 如果想从外部类的非静态方法之外的任意位置创建某个内部类的对象,
		 * 那么必须像在main()方法中那样，集体地指明这个对象的类型：OuterClassName.InnerClassName
		 */
		Parcel2.Contents c = p2.contents();
		Parcel2.Destination d = p2.to("Borneo");
		System.out.println(d.readLabel()+"----------"+c.value());
	}
	
}
