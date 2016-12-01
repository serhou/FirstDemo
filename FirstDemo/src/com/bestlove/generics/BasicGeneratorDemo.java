package com.bestlove.generics;

import com.bestlove.util.Generator;

/**
 * 使用泛型方法创建的Generator对象，大大减少了我们要编写的代码
 * Java泛型要求传入Class对象，以便也可以在create()方法中用它
 * 进行类型判断
 * @author think
 *
 */

public class BasicGeneratorDemo {

	public static void main(String[] args) {
		
		Generator<CountedObject> gen = BasicGenerator.create(CountedObject.class);
		for (int i = 0; i < 5; i++) {
			System.out.println(gen.next());
		}
		
		
	}
	
}
