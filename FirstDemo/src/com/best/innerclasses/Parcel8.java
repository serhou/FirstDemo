package com.best.innerclasses;


/**
 * 
 * 尽管Wrapping只是一个具有具体实现的普通类，
 * 但它还是被其导出类当作公共“接口”来使用。
 * 
 * @author think
 *
 */

public class Parcel8 {

	public Wrapping wrapping(int x){
		return new Wrapping(x){
			public int value(){
				return super.value()*57;
			}
		};
	}
	
	public static void main(String[] args) {
		
		Parcel8 parcel8 = new Parcel8();
		Wrapping w = parcel8.wrapping(10);
		System.out.println(w.value());
	}
	
	
}

class Wrapping {
	private int i;
	public Wrapping(int x) {
		i = x;
	}
	public int value(){
		return i;
	}
}