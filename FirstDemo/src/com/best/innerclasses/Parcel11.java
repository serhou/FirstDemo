package com.best.innerclasses;


/**
 * 嵌套类
 * 想要理解static应用于内部类时的含义，就必须记住，普通的内部类对象隐式地
 * 保存了一个引用，指向创建它的外围类对象。然而，当内部类时static的时，
 * 就不是这样了。嵌套类意味着：
 * 1)要创建嵌套类的对象，并不需要其外围类的对象
 * 2)不能从嵌套类的对象中访问非静态的外围类对象
 * @author think
 *
 */


public class Parcel11 {

	private static class ParcelContents implements Contents {
		private int i = 123;
		@Override
		public int value() {
			return i;
		}
	}
	
	protected static class ParcelDestination implements Destination {
		private String label;
		private  ParcelDestination(String whereTo) {
			label = whereTo;
		}
		@Override
		public String readLabel() {
			return label;
		}
		public static void f(){
			System.out.println("Parcel11.ParcelDestination.f()");
		}
		static int x = 10;
		static class AnotherLevel {
			public static void f(){
				System.out
						.println("Parcel11.ParcelDestination.AnotherLevel.f()");
			}
			static int x = 154;
		}
	}
	public static Destination destination(String s){
		return new ParcelDestination(s);
	}
	public static Contents contents(){
		return new ParcelContents();
	}
	public static void main(String[] args) {
		Contents c = contents();
		System.out.println(c.value());
		Destination d = destination("Tasmania");
		System.out.println(d.readLabel());
		((ParcelDestination) d).f();
		
	}
	
}


