package com.bestlove.test;


/**
 * 属性（域）是不能被重写的
 * @author think
 *
 */


public class FieldAccess {

	public static void main(String[] args) {
		/**
		 * 当Sub对象转型为Super引用时，任何域访问操作都将由编译器解析，因此不是多态的。
		 * 在本例中，为Super.field和Sub.field分配了不同的存储空间。
		 */
		Super sup = new Sub();
		System.out.println("sup.field = " + sup.field + 
				", sup.getField() = " + sup.getField());  //属性不能多态:0, 方法多态:1
		/**
		 * Sub实际上包含两个成为field的域：它自己的和它从Super处得到的。
		 * 然而，在引用Sub中的field时所产生的默认域并非Super版本的field域。
		 * 因此，为了得到Super.field，必须显式地指明super.field
		 */
		Sub sub = new Sub();
		System.out.println("sub.field = " + sub.field + 
				", sub.getField() = " + sub.getField() + 
				", sub.getSuperField() = " + sub.getSuperField());  //没有转型：1, 1, 0
		
		/**
		 * 尽管这看起来好像会成为一个容易令人混淆的问题，但是在实践中，它实际上从来不会发生。
		 * 首先，你通常会将所有的域都设置成private，因此不能直接访问他们，其副作用是只能调用方法来访问。
		 * 另外，你可能不会对基类中的域和导出类中的域赋予相同的名字，因为这种做法容易令人混淆
		 */
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