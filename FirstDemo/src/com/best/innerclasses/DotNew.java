package com.best.innerclasses;

/**
 * 有时你可能想要告知某些其他对象，去创建其某个内部类的对象。
 * 要实现此目的，你必须在new表达式中提供对其他外部类对象的引用，
 * 这是需要使用.new语法
 * 
 * 必须使用外部类的对象来创建该内部类对象
 * 
 * @author think
 *
 */

public class DotNew {

	public class Inner {
		@Override
		public String toString() {
			return "什么都别说";
		}
	}
	
	public static void main(String[] args) {
		DotNew dn = new DotNew();
		DotNew.Inner dni = dn.new Inner();
		System.out.println(dni);
	}
	
}
