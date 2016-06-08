package com.best.innerclasses;



/**
 * 
 * 在方法和作用域内的内部类
 * 
 * @author think
 *
 */


public class Parcel5 {

	
	public Destination destination(String s){
		
		/**
		 * PDestination类是destination()方法的一部分，而不是Parcel5的一部分。
		 * 所以在destination()之外不能访问PDestination。
		 * @author think
		 *
		 */
		class PDestination implements Destination{
			private String label;
			private PDestination(String whereTo){
				label = whereTo;
			}
			@Override
			public String readLabel() {
				return label;
			}
		}
		return new PDestination(s);
	}
	
	public static void main(String[] args) {
		Parcel5 p = new Parcel5();
		Destination d = p.destination("Tasmania");
		System.out.println(d.readLabel());
	}
}
