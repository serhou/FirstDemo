package com.bestlove.classtype;

/**
 * 普通的类引用不会产生警告信息。
 * 通过使用泛型语法，可以让编译器强制执行额外的类型检查
 * @author think
 *
 */

public class GenericClassReferences {

	public static void main(String[] args) {
		
		Class intClass = int.class;
		Class<Integer> genericIntClass = int.class;
		genericIntClass = Integer.class;
		intClass = double.class;
//		genericIntClass = double.class; //Illegal 非法
		/**
		 * 为了在使用泛化的Class引用时放松限制，我们可以使用通配符，
		 * 它是Java泛型的一部分。通配符就是“?”，表示“任何事物”
		 * Class<?>优于平凡的Class，即便它们是等价的。
		 * Class<?>的好处是它表示你并非是碰巧或者由于疏忽，而使用了一个非
		 * 具体的类引用，而是你本身就是选择了非具体的版本
		 */
		Class<?> intClass2 = int.class;
		intClass2 = double.class;
		//限定为某种类型，或该类型的任何子类型
		Class<? extends Number> bounded = int.class;
		bounded = double.class;
		bounded = Number.class;	
	}
	
}
