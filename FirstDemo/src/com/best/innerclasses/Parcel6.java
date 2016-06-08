package com.best.innerclasses;

/**
 * 作用域内的内部类
 * @author think
 *
 */

public class Parcel6 {

	private void internalTracking(boolean b){
		if(b){
			/**
			 * TrackingSlip类被嵌入到if语句的作用域内，这并不是说该类的创建是有条件的，
			 * 它其实与别的类一起编译过了。然而，在定义TrackingSlip的作用域之外，它是
			 * 不可用的；除此之外，它与普通的类一样。
			 * @author think
			 *
			 */
			class TrackingSlip{
				private String id;
				public TrackingSlip(String s) {
					id = s;
				}
				String getSlip(){
					return id;
				}
			}
			TrackingSlip ts = new TrackingSlip("slip");
			String s = ts.getSlip();
			System.out.println(s);
		}
	}
	public void track(){
		internalTracking(true);
	}
	public static void main(String[] args) {
		Parcel6 p = new Parcel6();
		p.track();
	}
	
}
