package com.bestlove.test;


/**
 * 属性（域）是不能被重写的
 * @author think
 *
 */


public class FieldAccess {

	public static void main(String[] args) {
		
		Super sup = new Sub();
		System.out.println("sup.field = " + sup.field + 
				", sup.getField() = " + sup.getField());  //属性不能多态:0, 方法多态:1
		Sub sub = new Sub();
		System.out.println("sub.field = " + sub.field + 
				", sub.getField() = " + sub.getField() + 
				", sub.getSuperField() = " + sub.getSuperField());  //没有转型：1, 1, 0
		
	}
	
}

class Super{
	public int field = 0;
	public int getField(){
		return field;
	}
}

class Sub extends Super{
	public int field = 1;
	public int getField(){
		return field;
	}
	public int getSuperField(){
		return super.field;
	}
}